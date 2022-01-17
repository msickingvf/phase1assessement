package com.vodafone.jfsd.menu;

import java.util.Scanner;

import com.vodafone.jfsd.menuActions.FileActions;

public class MainMenu {

	private String message = null;
	private FileActions fileActions;
	public void showMenu() {
		System.out.println("Application Name: File Manager");
		System.out.println("Application Version: 1.0");
		System.out.println("Developer: Marcel Sicking");
		fileActions = new FileActions();
		System.out.println("--------------------------");		
		int input = -1;
		while (input != 3) {
			if (message != null) {System.out.println("Message: "+this.message);}
			System.out.println("1. Show directory content");
			System.out.println("2. File Action Menu");
			System.out.println("3. Exit Program");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextInt();
			switch(input) {
			case 1:
				System.out.println("directory Listing");
				message=null;
				try {
					fileActions.listDirectoryContent();
				} catch (Exception e) {
					e.printStackTrace();
					message=e.getMessage();
				}
				
				break;
			case 2: 
				System.out.println("fileActionMenu");
				message=null;
				break;
			case 3: 
				System.out.println("Exiting Program");
				message=null;
				break;
			default:
				message = "invalid input";
				break;
			} 
		}
	}
}
