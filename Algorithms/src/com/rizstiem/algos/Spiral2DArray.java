/*
 * Question 1: 2D Spiral Array
Find the pattern and complete the function:
	int[][] spiral(int n);
	where n is the size of the 2D array.

Sample Result

input = 3
123
894
765

input = 4
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07

input = 8
1 2 3 4 5 6 7 8
28 29 30 31 32 33 34 9
27 48 49 50 51 52 35 10
26 47 60 61 62 53 36 11
25 46 59 64 63 54 37 12
24 45 58 57 56 55 38 13
23 44 43 42 41 40 39 14
22 21 20 19 18 17 16 15

*/



public class Spiral2DArray {

	static int[][] spiral(int n){
		int dir=1;
		int val=1;
		int[][] arr = new int[n][n];
		int r=0,c=0;
		
		while(val<=(n*n)) {
			if(arr[r][c]==0) {
				arr[r][c]=val++;
			}else if(arr[r][c]!=0) {
				if(dir==4) {r++; dir=1;}
				else if(dir==1) {c--; dir=2;}
				else if(dir==2) {r--; dir=3;}
				else if(dir==3) {c++; dir=4;}			
			}
			
			if(dir==1) {
				if(c<n-1) c++;
				else {
					dir=2;
					r++;
				}
			}else if(dir==2) {
				if(r<n-1) r++;
				else {
					dir=3;
					c--;
				}
			}else if(dir==3) {
				if(c>0) c--;
				else {
					dir=4;
					r--;
				}
			}else if(dir==4) {
				if(r>0) r--;
				else {
					dir=1;
					c++;
				}
			}
		}	
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[][] arr=spiral(8);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
