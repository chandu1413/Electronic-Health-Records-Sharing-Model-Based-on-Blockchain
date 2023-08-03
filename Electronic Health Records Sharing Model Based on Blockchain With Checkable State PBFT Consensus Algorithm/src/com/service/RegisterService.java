package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dao.DAO;
import com.exceptions.MyExcetpion;
import com.interfaces.RegisterInterface;
import com.model.RegisterModel;

public class RegisterService implements RegisterInterface {

	DAO dao = new DAO();

	@Override
	public int registerUser(RegisterModel rm) throws ClassNotFoundException, SQLException, MyExcetpion {

		String email = rm.getEmailid();
		int i = 0;
		ResultSet rs = dao.getEmails();
		List<String> regModel = new ArrayList<>();
		if (rs.next() == false) {
			i = dao.registerUser(rm);
		} else {
			do {
				String em = rs.getString("emailid");
				regModel.add(em);
			} while (rs.next());

			boolean b = regModel.stream().filter(s -> s.equalsIgnoreCase(email)).collect(Collectors.toList()).isEmpty()
					? true
					: false;
			
			i=b?(i = dao.registerUser(rm)):10;

		}
		if (i != -1) {
			return i;
		} else {
			throw new MyExcetpion("user register not success");
		}

	}

}
