package com.vodafone.jfsd.sort;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,4,13,5,6,60,8,123,3};
		for(int j=0;j<arr.length-1;j++) {
			for (int i=0;i<arr.length-1-j;i++) {
				if (arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		for(int val:arr) {
			System.out.println(val);
		}
	}

}
