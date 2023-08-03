package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.database.DbConnection;
import com.model.KycModel;
import com.model.RegisterModel;
import com.utils.HashCodeGenearate;

public class DAO {

	public int registerUser(RegisterModel rm) throws ClassNotFoundException, SQLException {

		Connection con = DbConnection.getCon();
		String sql = "insert into register values(0,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, rm.getName());
		ps.setString(2, rm.getEmailid());
		ps.setString(3, rm.getPassword());
		int statusReg = ps.executeUpdate();
		return statusReg;
	}
	
	
	public ResultSet getUsers() throws ClassNotFoundException, SQLException{
		
		Connection con = DbConnection.getCon();
		String sql = "select * from register";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
		
	}
	
public ResultSet getFUsers() throws ClassNotFoundException, SQLException{
		
		Connection con = DbConnection.getCon();
		String sql = "select * from flogin";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
		
	}

public ResultSet getRequestedKyc(int fid) throws ClassNotFoundException, SQLException{
	
	Connection con = DbConnection.getCon();
	String sql = "select * from requestable where fid="+fid;
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	return rs;
	
}

public int updateFUsers(int userId) throws ClassNotFoundException, SQLException{
	
	Connection con = DbConnection.getCon();
	String sql = "update flogin set status=1 where Fid='"+userId+"'";
	PreparedStatement ps = con.prepareStatement(sql);
	int rs=ps.executeUpdate();
	return rs;
	
}

public int updateRequest(int userId) throws ClassNotFoundException, SQLException{
	
	Connection con = DbConnection.getCon();
	String sql = "update requestable set status='approved' where requestId='"+userId+"'";
	PreparedStatement ps = con.prepareStatement(sql);
	int rs=ps.executeUpdate();
	return rs;
	
}
	
	public int FregisterUser(RegisterModel rm) throws ClassNotFoundException, SQLException {

		Connection con = DbConnection.getCon();
		String sql = "insert into flogin values(0,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, rm.getName());
		ps.setString(2, rm.getAddress());
		ps.setString(3, rm.getMobile());
		ps.setString(4, "0");
		ps.setString(5, HashCodeGenearate.getHashValue(rm.getEmailid()));
		ps.setString(6, rm.getPassword());
		ps.setString(7, rm.getEmailid());
		ps.setInt(8, 0);
		int statusReg = ps.executeUpdate();
		return statusReg;
	}

	public ResultSet getEmails() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from register";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public ResultSet getFEmails() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from flogin";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public int insertKyc(KycModel km) throws ClassNotFoundException, SQLException {

		int statusReg = 0;
		Connection con = DbConnection.getCon();
		String sql = "insert into userfiles values(0,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setBinaryStream(1, km.getInputStream());
		ps.setString(2, new Date().toString());
		ps.setInt(3, km.getUserid());
		ps.setString(4, km.getHashValue());
		ps.setString(5, km.getName());
		ps.setString(6, km.getFatherName());
		ps.setString(7, km.getMotherName());
		ps.setString(8, km.getMobile());
		ps.setString(9, km.getAddress());
		ps.setString(10, "");
		statusReg = ps.executeUpdate();
		return statusReg;

	}

	public ResultSet getKyc(int userid) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from userfiles where userid="+userid ;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet getRequestKyc() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from requestable";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	public int sendRequest(int fid,int uid) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getCon();
		String sql = "insert into requesTable values(0,?,?,?)" ;
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(3, "pending");
		ps.setInt(1, fid);
		ps.setInt(2, uid);
		int i=ps.executeUpdate();
		return i;
	}


	public String getfemail(int int1) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String email=null;
		String sql = "select * from flogin where fid="+int1;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			email= rs.getString(8);
		}
		return email;
	}
	public String getUemail(int int1) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String email=null;
		String sql = "select * from register where userid="+int1;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			email= rs.getString(3);
		}
		return email;
	}

}
