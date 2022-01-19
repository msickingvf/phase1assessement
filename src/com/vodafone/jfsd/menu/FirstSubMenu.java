package com.vodafone.jfsd.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.vodafone.jfsd.menuActions.FileActions;

public class FirstSubMenu {
	private String message = null;
	private FileActions fileActions;
	private Scanner scanner;
	public FirstSubMenu(FileActions fileActions, Scanner scan) {
		this.fileActions = fileActions;
		this.scanner = scan;
	}
	public void showMenu() {
		int input = -1;
		while (input != 4) {
			if (message != null) {System.out.println("Message: "+this.message);}
			System.out.println("1. Add new file");
			System.out.println("2. Delete file");
			System.out.println("3. Search File");
			System.out.println("4. Return to main menu");
			try {
				input = scanner.nextInt();
			} catch (InputMismatchException e1) {
				String errInput = scanner.nextLine();
				message = "invalid input \""+errInput+"\"";
				continue;
			}
			switch(input) {
			//create file
			case 1:
				System.out.println("Enter filename to create:");
				//create new scanner since re-using scanner not working
				Scanner scannerCreateFile = new Scanner(System.in);
				String newFilename = scannerCreateFile.nextLine();
				try {
					boolean fileCreated = fileActions.createFile(newFilename);
					message="file created successfully";
				} catch (Exception e) {
					message = e.getMessage();
					//log full exception somewhere
				}	
				break;
			//delete file
			case 2:
				System.out.println("Enter filename to delete:");
				Scanner scannerDeleteFilename = new Scanner(System.in);
				String deleteFilename = scannerDeleteFilename.nextLine();
				try {
					boolean fileCreated = fileActions.deleteFile(deleteFilename);
					message="file deleted successfully";
				} catch (Exception e) {
					message = e.getMessage();
					//log full exception somewhere
				}
				break;
			//search file
			case 3:
				System.out.println("Enter filename to search:");
				Scanner scannerSearchFilename = new Scanner(System.in);
				String searchFilename = scannerSearchFilename.nextLine();
				try {
					String fileInfo = fileActions.searchFile(searchFilename);
					message="File found, FileInfo: "+fileInfo;
				} catch (Exception e) {
					message = e.getMessage();
					//e.printStackTrace();
					//log full exception somewhere
				}
				break;
			//return to main menu
			case 4: 
				break;
			}
		}
		
	}

}
