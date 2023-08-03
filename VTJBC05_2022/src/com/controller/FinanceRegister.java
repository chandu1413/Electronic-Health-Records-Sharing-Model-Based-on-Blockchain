package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.RegisterModel;
import com.service.FinanceRegisterService;
import com.service.RegisterService;

@WebServlet("/fregister")
public class FinanceRegister extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FinanceRegisterService regService=new FinanceRegisterService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname=req.getParameter("name");
		String emailid=req.getParameter("emailid");
		String password=req.getParameter("password");
		String mobile=req.getParameter("mobile");
		String address=req.getParameter("address");
		
		
		
		RegisterModel rm= new RegisterModel();
		rm.setName(uname);rm.setEmailid(emailid);rm.setPassword(password);
		rm.setMobile(mobile);rm.setAddress(address);
		
		try {
		int i=regService.registerUser(rm);
		if(i!=0) {
			if(i!=10) {
			 String info = "<div class=\"alert alert-success wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            Register Success!\n" +
	                    "                        </p>\n" +
	                    "                    </div>";
			req.setAttribute("info", info);
            req.getRequestDispatcher("Fregister.jsp").forward(req, resp);
			}else {
				 String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
		                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
		                    "                            Email id already present choose different mail!\n" +
		                    "                        </p>\n" +
		                    "                    </div>";
				req.setAttribute("alert", alert);
	            req.getRequestDispatcher("Fregister.jsp").forward(req, resp);
				
			}
		}else {
			
			
			
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
		
		
	}
	
	


