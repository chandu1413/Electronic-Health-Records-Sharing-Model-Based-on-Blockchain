package com.service;

import java.sql.SQLException;

import com.dao.DAO;

public class FinanceService {
	
	DAO dao=new DAO();
	
	public int sendRequest(int fid,int uid) throws ClassNotFoundException, SQLException {
		
		int i=dao.sendRequest(fid, uid);
		return i;
	}

}
