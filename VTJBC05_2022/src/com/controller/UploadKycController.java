package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.configurations.AppConfig;
import com.model.KycModel;
import com.model.RegisterModel;
import com.service.UploadKycService;
import com.utils.HashCodeGenearate;

@WebServlet("/uploadKyc")
@MultipartConfig
public class UploadKycController extends HttpServlet {

	UploadKycService uks = new UploadKycService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("uname");
		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String mobile = req.getParameter("mobile");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");

		Part part = req.getPart("kyc-image");
		InputStream inputStream = part.getInputStream();

		KycModel kycModel = AppConfig.getKycmodel();

		HttpSession session = req.getSession();
		RegisterModel rm = (RegisterModel) session.getAttribute("account");

		String genearatehash = name.substring(0, 2) + fname.substring(0, 2) + mname.substring(0, 2)
				+ gender.substring(0, 2);
		String hashValue = HashCodeGenearate.getHashValue(genearatehash);

		kycModel.setName(name);
		kycModel.setFatherName(fname);
		kycModel.setMotherName(mname);
		kycModel.setMobile(mobile);
		kycModel.setGender(gender);
		kycModel.setAddress(address);
		kycModel.setInputStream(inputStream);
		kycModel.setHashValue(hashValue);
		kycModel.setUserid(rm.getUserid());

		try {
			boolean b = uks.uploadKyc(kycModel);
			if(b==true) {
				 String info = "<div class=\"alert alert-success wrap-input100\">\n" +
		                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
		                    "                            Upload Success!\n" +
		                    "                        </p>\n" +
		                    "                    </div>";
				req.setAttribute("info", info);
	            req.getRequestDispatcher("uploadkyc.jsp").forward(req, resp);
				}else {
					 String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
			                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
			                    "                            KYC document updation failed\n" +
			                    "                        </p>\n" +
			                    "                    </div>";
					req.setAttribute("alert", alert);
		            req.getRequestDispatcher("uploadkyc.jsp").forward(req, resp);
					
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			 String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            Image size is greater than 1mb \n" +
	                    "                        </p>\n" +
	                    "                    </div>";
			req.setAttribute("alert", alert);
         req.getRequestDispatcher("uploadkyc.jsp").forward(req, resp);
		}

	}

}
