package com.controller;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 0, 1, 0, 0, 1, 1, 1, 0, 1 };
		
		int z[]=new int[arr.length];
            int k[]=new int[arr.length];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {
				//count++;
				z[i]=0;
				
			}else {
				k[i]=1;
			}
			
			

		}

		for (int i = 0; i < count; i++) {
			arr[i] = 0;
			//System.out.println(arr[i]);
		}
		for (int i = count; i < arr.length; i++) {
			arr[i] = 1;
			//System.out.println(arr[i]);
		}
		
		for(int i=0;i<z.length;i++) {
			System.out.println(z[i]);
		}

	}

}
