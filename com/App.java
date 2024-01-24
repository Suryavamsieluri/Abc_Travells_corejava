package com;

import java.io.FileNotFoundException;
import java.util.Scanner;
//its a travels application in which we can Create account and login into account 
//and we can enquire about available buses

public class App {
	//importing scanner class for to enable users can choose option
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		AbcUtil abcUtil = new AbcUtil();
		//wish method to print logo in display
		abcUtil.wish();
		//while(true) prints options repeatedly until we choose option 4
		while (true) {
			abcUtil.menu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				//here we create users by taking details and adding them into map as their email id as a key
				System.out.println("create account");
				abcUtil.createUser();

				break;
			}
			case 2: {
				//here we creating login method by taking email and password
				System.out.println("you have chosen option 2");
				System.out.println("Login");
				abcUtil.login();
				break;
			}
			case 3: {
				//here we creating enquire method to avalible buses 
				System.out.println("you have chosen option 3");
				System.out.println("Enquery");
				abcUtil.enquire();
				break;
			}
			case 4: {
				System.out.println("you have chosen option 4");
				System.out.println("bye..bye..");
				break;
			}
			}
			if (choice == 4)
				break;
		}
	}
}
