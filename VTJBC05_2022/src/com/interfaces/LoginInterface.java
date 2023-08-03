package com.interfaces;

import com.model.RegisterModel;

@FunctionalInterface
public interface LoginInterface {
	
	public boolean userLogin(String email, String password);

}
