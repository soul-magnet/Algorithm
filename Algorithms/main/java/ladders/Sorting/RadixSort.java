package Sorting;

import java.util.Arrays;

public class RadixSort {
	
	public static void countSort(int arr[], int n, int exp){
		int [] output = new int [n];
		int [] count = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			count[i] = 0;
		}
		
		// Store count of occurrence in count[]
		for (int i = 0; i< n; i++){
			count[(arr[i]/exp)%n]++;
		}
		
		// Change count[i] so that count[i] now contains actual position
		// of this digit in output
		for (int i = 1; i < n; i++){
			count[i] += count[i - 1];
		}
		
		// build the output array
		for (int i = n - 1; i >= 0; i--){
			output[count[(arr[i]/exp)%n] - 1] = arr[i];
			count[(arr[i]/exp)%n]--;
		}
		
		// copy the output array to arr[], so that arr[] now contains sorted
		// numbers according to current digit
		for (int i = 0; i < n; i++){
			arr[i] = output[i];
		}
		
	}
	
	public static void radixSort (int arr[], int n){
		countSort(arr, n, 1);
		countSort(arr, n, n);
	}
	
	public void printArr(int arr[], int n) {
		for (int i = 0; i < n; i++){
			System.out.println(arr[i] + " ");
		}
	}
	
	public static void main(String[] args){
		int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
		int n = arr.length/3;
		radixSort(arr, n);
		System.out.println(arr);
	}


}
