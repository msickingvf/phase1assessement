package com.vodafone.jfsd.menuActions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.vodafone.jfsd.sort.BubbleSortString;

public class FileActions {
	//name of directory
	private final String directoryName = "workingDir";
	private File directoryFile;

	public FileActions(){

	}
	
	public void listDirectoryContent() throws Exception {
		try {
			checkDirExist();
			String[] files = getFiles();
			sortStringList(files);
			for(int i=0;i<files.length;i++) {
				System.out.println(files[i]);
			}
		} catch (IOException e) {
			throw new Exception("Error Accessing Working Directory");
		}
	}
	
	
	
	private void sortStringList(String[] files) {
		BubbleSortString bss = new BubbleSortString();
		bss.sort(files);
	}

	private String[] getFiles() {
		String[] files = directoryFile.list();
		return files;
	}

	private void checkDirExist() throws IOException {
		//directory = Paths.get(directoryName);
		directoryFile=new File(directoryName);
		if(!directoryFile.exists()) {
			directoryFile.mkdir();
		}	
	}

	public String getDirectoryName() {
		return directoryName;
	}
}
