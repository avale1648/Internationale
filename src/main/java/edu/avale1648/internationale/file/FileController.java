package edu.avale1648.internationale.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
	@PostMapping
	public String create(@RequestParam("file") MultipartFile file) {
		String filePath = System.getProperty("user.dir") + "/uploads" + File.separator + file.getOriginalFilename();
		String fileUploadStatus = "";

		try {
			FileOutputStream fout = new FileOutputStream(filePath);
			fout.write(file.getBytes());
			fout.close();
			fileUploadStatus = "File uploaded successfully";

		} catch (Exception ex) {
			ex.printStackTrace();
			fileUploadStatus = "Error in uploading file: " + ex;
		}
		return fileUploadStatus;
	}

	@GetMapping
	public String[] getAll() {
		String folderPath = System.getProperty("user.dir") + "/uploads";
		File directory = new File(folderPath);
		String[] filenames = directory.list();

		return filenames;
	}

	@GetMapping("/{path:.+}")
	public ResponseEntity getByPath(@PathVariable("path") String filename) throws FileNotFoundException {
		String fileUploadPath = System.getProperty("user.dir") + "/uploads";
		String[] filenames = this.getAll();

		boolean contains = Arrays.asList(filenames).contains(filename);
		if (!contains) {
			return new ResponseEntity("File not found", HttpStatus.NOT_FOUND);
		}

		String filepath = fileUploadPath + File.separator + filename;
		File file = new File(filepath);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		String contentType = "application/octet-stream";
		String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);
	}
}
