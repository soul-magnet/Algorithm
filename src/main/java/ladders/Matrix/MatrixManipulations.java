package main.java.ladders.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatrixManipulations {
	public static void main(String args[]){
		
		 Scanner sc = new Scanner(System.in);
		    int size = sc.nextInt(); // load the size
		    int[][] matrix = new int[size][size]; // create a new array; note 2
		    for(int row = 0; row < size; ++row) {
		    	byte[] input = sc.nextInt(); // read a row
		        input = Arrays.copyOf(input, size); // pad/truncate the array
		        int[] processed = new int[size]; // for storing a row
		        for(int entry = 0; entry < size; ++entry)
		        	processed[entry] = Integer.parseInt(input[entry]); // parse integers; note 3
		        matrix[row] = processed; // set the row
		        
		    }
		    // for testing purposes:
		    for(int row = 0; row < size; ++row) {
		    	for(int col = 0; col < size; ++col)
		    		System.out.print(matrix[row][col] + " ");
		        System.out.println();
		    }
		
		/*Scanner input = new Scanner(System.in);
		System.out.println("Columns : ");
		int n = input.nextInt();

		int[][] matrix = new int[n][n];
		for ( int i = 0 ; i < n ; i++ ) {
			String[] inp = input.nextLine().split("  "); //read a row
        	inp = Arrays.copyOf(inp, n);
        	int[] processed = new int[n]; // for storing a row
			for ( int j = 0 ; j < n ; j++ ) {
				processed[j]  = Integer.parseInt(inp[j]);
				//matrix[i][j]= input.nextInt();
				}
			matrix[i] = processed; // set the row
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
				
			}
			
			System.out.println();
		}*/
		
		/*int n ;
		Scanner input = new Scanner(System.in);
		System.out.println("Columns : ");
		n = input.nextInt();

		ArrayList<List<Integer>> matrix = new ArrayList<List<Integer>>();
		for ( int i = 0 ; i < n ; i++ )
		{
		    matrix.add(new ArrayList<Integer>());
		    for ( int j = 0 ; j < n ; j++ )
		    {
		         int t = input.nextInt();
		         matrix.get(i).add(t);
		    }
		}

		// This is to check the contents of the data structure 

		for ( int j = 0 ; j < n ; j ++)
		{
		    System.out.println();
		    for ( int k = 0 ; k < n ; k ++)
		    {
		        System.out.print(matrix.get(j).get(k) + " ");
		    }
		}*/
		
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // load the size
        int [][] matrix = new int[n][n];
        
        for (int row = 0; row < n; ++row){
        	String[] input = sc.nextLine().split("  "); //read a row
        	input = Arrays.copyOf(input, n);
        	int[] processed = new int[n]; // for storing a row
        	for (int entry = 0; entry < n; ++ entry){
        		processed[entry]  = Integer.parseInt(input[entry]);
        	}
        	matrix[row] = processed; // set the row
        	}
        
        // for testing purpose
        
        for (int row = 0; row < n; ++row) {
        	for (int col = 0; col < n; ++col)
        		System.out.print(matrix[row][col]+ " ");
        	System.out.println();
        }
        */
	}
}
