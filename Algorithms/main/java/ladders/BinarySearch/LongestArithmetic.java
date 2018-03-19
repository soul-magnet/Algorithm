package main.java.ladders.BinarySearch;

public class LongestArithmetic {

	int longest_arithmetic_progression(int a[], int n){

		  int i,j,k;

		  int Table[][]= new int [n][n];
		  int longest_ap = 2;

		  for(i=0;i<n; i++)
		      Table[i][n-1] =2;

		  for(j= n-2; j>=1; j-- ){
		      i = j-1;
		      k = j+1;

		      while(i>=0 && k<n){
		          if(2* a[j] > a[i] + a[k]){
		               k++; // Table[j][k]is already filled 
		          }
		          else if (2* a[j] < a[i] + a[k]){
		            /*Table[i][j] needs to be filled before we move up */
		             Table[i][j] =2; 
		             i--;
		          }
		          else{
		             Table[i][j] = Table[j][k] +1;
		             longest_ap = Math.max(longest_ap, Table[i][j]);
		             i--;
		             k++;
		          }
		       }
		       while(i>=0){
		         Table[i][j] =2; 
		         i--;
		       }
		   }
		   return longest_ap;
		}
}

