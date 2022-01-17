package com.vodafone.jfsd.sort;

import java.util.Scanner;

public class BubbleSortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner in = new Scanner(System.in);
		String one = in.nextLine(); 
		String two = in.nextLine(); 
		String three = in.nextLine(); 
		String four = in.nextLine(); 
		String five = in.nextLine(); 
	
		
		String arr[] = {one,two,three,four,five};
		*/

		//for(String val:arr) {
		//	System.out.println(val);
		//}
	}
	
	public void sort(String[] arr) {
		for(int j=0;j<arr.length-1;j++) {
			for (int i=0;i<arr.length-1-j;i++) {
				if (arr[i].compareTo(arr[i+1])>0) {
					String temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
	}

}
