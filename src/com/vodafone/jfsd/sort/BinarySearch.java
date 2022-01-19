package com.vodafone.jfsd.sort;

public class BinarySearch {
	//input is a sorted list of strings
	public int search(String array[], String key) {
		int l = 0;
		int r = array.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(array[mid].contentEquals(key))
				return mid;
			//else if(array[mid] < key)
			else if(array[mid].compareTo(key)<0)
				l = mid+1;
			else
				r = mid-1;
		}
		return -1;
	}
}
