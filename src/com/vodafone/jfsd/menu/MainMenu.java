package com.vodafone.jfsd.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.vodafone.jfsd.menuActions.FileActions;

public class MainMenu {
	/*
	 * Main Menu of file management application
	 */
	//info String for failed/successfull commands which appears on top of the menu.
	private String message = null;
	private FileActions fileActions;
	public void showMenu() {
		System.out.println("Application Name: File Manager");
		System.out.println("Application Version: 1.0");
		System.out.println("Developer: Marcel Sicking");
		//instance for file actions
		fileActions = new FileActions();
		System.out.println("--------------------------");		
		int input = -1;
		//menu loop. will quit when 3 is pressed
		while (input != 3) {
			//showmessage if existing
			if (message != null) {System.out.println("Message: "+this.message);}
			//menu entries
			System.out.println("1. Show directory content");
			System.out.println("2. File Action Menu");
			System.out.println("3. Exit Program");
			Scanner scanner = new Scanner(System.in);
			try {
				input = scanner.nextInt();
				//catch exception when not a number was entered
			} catch (InputMismatchException e1) {
				String errInput = scanner.nextLine();
				message = "invalid input \""+errInput+"\"";
				continue;
			}
			switch(input) {
			case 1:
				//System.out.println("directory Listing");
				message=null;
				try {
					fileActions.listDirectoryContent();
				} catch (Exception e) {
					e.printStackTrace();
					message=e.getMessage();
				}	
				break;
			case 2: 
				//System.out.println("fileActionMenu");
				FirstSubMenu fsm = new FirstSubMenu(fileActions, scanner);
				fsm.showMenu();
				message=null;
				break;
			case 3: 
				System.out.println("Exiting Program");
				break;
			default:
				//if none of these inputs 1,2,3 are entered, it is invalid
				message = "invalid input";
				break;
			}
		}
	}
}
