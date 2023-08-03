package com.controller;

public class Test {

	public static void main(String args[]) {
		// int a[][]=new int[2][3];
		// int b[][]=new int[2][3];
		int a[][] = { { 2, 3 }, { 4, 5, 6 } };
		int b[][] = { { 2, 3 }, { 4, 5, 6 } };
		int z[][] = null;
		
		

		int c[][] = addTwoMatix(a, b);
		int k[][]=addTwoMatix(a,b,z);
		
		

	}

	private static int[][] addTwoMatix(int[][] a, int[][] b, int[][] z) {
		
		for (int i = 0; i <=2; i++) {
			for (int j = 0; j <=3; j++) {

				z[i][j] = a[i][j] - b[i][j];
				System.out.print(z[i][j]);
			}
		}
		
		return z;
	}

	private static int[][] addTwoMatix(int[][] a2, int[][] b2) {

		int c[][] = new int[2][3];
		for (int i = 0; i <=2; i++) {
			for (int j = 0; j <=3; j++) {

				c[i][j] = a2[i][j] + b2[i][j];
				System.out.print(c[i][j]);
			}
		}

		return c;

	}

}
