package Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface FileComponent {
	public String showProperty();
	public long totalSize();
}

class FileLeaf implements FileComponent {

	private String fileName;
	private long fileSize;
	
	public FileLeaf() {
		
	}
	
	public FileLeaf(String fileName, long fileSize) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String showProperty() {
		return "FileLeaf [fileName=" + fileName + ", fileSize=" + fileSize + "]";
	}

	@Override
	public long totalSize() {
		return this.fileSize;
	}
}

class FolderComposite implements FileComponent {

	private List<FileComponent> files = new ArrayList<FileComponent>();
	
	
	
	public FolderComposite(List<FileComponent> files) {
		this.files = files;
	}

	@Override
	public String showProperty() {
		for (FileComponent file : files) {
			System.out.println(file.showProperty());
		}
		return null;
	}

	@Override
	public long totalSize() {
		long total = 0;
		for (FileComponent file : files) {
			total = total + file.totalSize();
		}
		return total;
	}
	
}

public class Composite {
	public static void main(String[] args) {
		FileComponent file1 = new FileLeaf("file1", 10);
		FileComponent file2 = new FileLeaf("file2", 20);
		FileComponent file3 = new FileLeaf("file3", 30);
		
		List<FileComponent> files = Arrays.asList(file1, file2, file3);
		FileComponent folder = new FolderComposite(files);
		folder.showProperty();
		System.out.println("Size: " + folder.totalSize());
	}
}
