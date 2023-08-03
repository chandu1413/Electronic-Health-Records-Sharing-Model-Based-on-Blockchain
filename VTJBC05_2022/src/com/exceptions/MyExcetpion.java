package com.exceptions;

public class MyExcetpion  extends Exception{
	
	String msg;

	public MyExcetpion(String msg) {
		super();
		this.msg = msg;
		System.out.println(msg);
	}
	
	

}
