package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DbConnection;

public class LoginDAO {

	public ResultSet checkUser(String email,String password) throws ClassNotFoundException, SQLException {

		Connection con = DbConnection.getCon();
		String sql = "select * from register where emailid=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet checkFinanceUser(String email,String password) throws ClassNotFoundException, SQLException {

		Connection con = DbConnection.getCon();
		String sql = "select * from flogin where emailid=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public ResultSet checkUser(String email) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from register where emailid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		return rs;
		
	}
	
	public ResultSet checkFinanceUser(String email) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from flogin where emailid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		return rs;
		
	}

}
