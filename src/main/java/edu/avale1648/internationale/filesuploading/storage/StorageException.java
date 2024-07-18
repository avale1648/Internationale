package edu.avale1648.internationale.filesuploading.storage;

public class StorageException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}
