package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configurations.AppConfig;
import com.dao.DAO;
import com.model.RegisterModel;
import com.model.RequestedUsersModel;

public class AdminService {
	
	
	DAO dao=AppConfig.getDao();
	
	public List<RegisterModel> getUsers() throws ClassNotFoundException, SQLException{
		
		List<RegisterModel> regModel=new ArrayList<>();
		ResultSet rs=dao.getUsers();
		while(rs.next()) {
			RegisterModel rm=new RegisterModel();
			rm.setUserid(rs.getInt(1));
			rm.setName(rs.getString(2));
			rm.setEmailid(rs.getString(3));
			regModel.add(rm);
		}
		
		return regModel;
	}
	
public List<RegisterModel> getFUsers() throws ClassNotFoundException, SQLException{
		
		List<RegisterModel> regModel=new ArrayList<>();
		ResultSet rs=dao.getFUsers();
		while(rs.next()) {
			RegisterModel rm=new RegisterModel();
			rm.setUserid(rs.getInt(1));
			rm.setName(rs.getString(2));
			rm.setEmailid(rs.getString(8));
			rm.setAddress(rs.getString(3));
			rm.setMobile(rs.getString(4));
			rm.setStatus(rs.getInt(9));
			regModel.add(rm);
		}
		
		return regModel;
	}

public List<RequestedUsersModel> getKycStatus(int fid) throws ClassNotFoundException, SQLException{
	
	List<RequestedUsersModel> regModel=new ArrayList<>();
	ResultSet rs=dao.getRequestedKyc(fid);
	while(rs.next()) {
		RequestedUsersModel rm=new RequestedUsersModel();
		rm.setRequestedId(rs.getInt(1));
		String femail=dao.getfemail(fid);
		String uemail=dao.getUemail(rs.getInt(3));
		rm.setStatus(rs.getString(4));
		rm.setUserId(rs.getInt(3));
		rm.setFinanaceEmail(femail);
		rm.setUserEmail(uemail);
		regModel.add(rm);
	}
	
	return regModel;
}

public int updateFusers(int Userid) throws ClassNotFoundException, SQLException{
	
	int rs=dao.updateFUsers(Userid);
	
	return rs;
}
public int updateRequest(int Userid) throws ClassNotFoundException, SQLException{
	
	int rs=dao.updateRequest(Userid);
	
	return rs;
}

public List<RequestedUsersModel>  getKycRequest() throws ClassNotFoundException, SQLException{
	ArrayList<RequestedUsersModel> al=new ArrayList<>();
	ResultSet rs=dao.getRequestKyc();
	while(rs.next()) {
		
		RequestedUsersModel rum=new RequestedUsersModel();
		String femail= dao.getfemail(rs.getInt(2));
		String uemail=dao.getUemail(rs.getInt(3));
		rum.setFinanaceEmail(femail);
		rum.setUserEmail(uemail);
		rum.setRequestedId(rs.getInt(1));
		rum.setStatus(rs.getString(4));
		al.add(rum);
	}
	return al;
	
}
	


}
