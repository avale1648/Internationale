package edu.avale1648.internationale.filesuploading.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
	private String location = "upload-dir";
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String value) {
		location = value;
	}
}
