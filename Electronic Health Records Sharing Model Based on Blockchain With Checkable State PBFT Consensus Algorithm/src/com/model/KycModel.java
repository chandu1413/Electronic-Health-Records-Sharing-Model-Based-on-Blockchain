package com.model;

import java.io.InputStream;

public class KycModel {

	private int kycid;
	private String name;
	private String fatherName;
	private String motherName;
	private String mobile;
	private String gender;
	private String address;
	private byte[] image;
	private String base64Image;
	private InputStream inputStream;
	private int userid;
	private String hashValue;
	private String encyPassword;
	
	

	public KycModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KycModel(int kycid, String name, String fatherName, String motherName, String mobile, String gender,
			byte[] image, String base64Image) {
		super();
		this.kycid = kycid;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.mobile = mobile;
		this.gender = gender;
		this.image = image;
		this.base64Image = base64Image;
	}

	public int getKycid() {
		return kycid;
	}

	public void setKycid(int kycid) {
		this.kycid = kycid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getHashValue() {
		return hashValue;
	}

	public void setHashValue(String hashValue) {
		this.hashValue = hashValue;
	}

	public String getEncyPassword() {
		return encyPassword;
	}

	public void setEncyPassword(String encyPassword) {
		this.encyPassword = encyPassword;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	

}
