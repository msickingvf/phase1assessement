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
		while (input != 3) {
			if (message != null) {System.out.println("Message: "+this.message);}
			System.out.println("1. Add new file");
			System.out.println("2. Delete file");
			System.out.println("3. Return to main menu");
			try {
				input = scanner.nextInt();
			} catch (InputMismatchException e1) {
				String errInput = scanner.nextLine();
				message = "invalid input \""+errInput+"\"";
				continue;
			}
			switch(input) {
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
			case 3: 
				break;
			}
		}
		
	}

}
