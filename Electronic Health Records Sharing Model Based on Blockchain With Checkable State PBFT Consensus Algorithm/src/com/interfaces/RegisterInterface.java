package com.interfaces;

import java.sql.SQLException;

import com.exceptions.MyExcetpion;
import com.model.RegisterModel;

public interface RegisterInterface {
	
	public int registerUser(RegisterModel rm) throws ClassNotFoundException, SQLException, MyExcetpion;

}
