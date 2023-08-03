package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.RegisterModel;
import com.service.RegisterService;

@WebServlet("/Register")
public class RegisterController  extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RegisterService regService=new RegisterService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		
		String uname=req.getParameter("name");
		String emailid=req.getParameter("emailid");
		String password=req.getParameter("password");
		
		RegisterModel rm= new RegisterModel();
		rm.setName(uname);rm.setEmailid(emailid);rm.setPassword(password);
		try {
		int i=regService.registerUser(rm);
		if(i!=-1) {
			if(i!=10) {
			 String info = "<div class=\"alert alert-success wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            Register Success!\n" +
	                    "                        </p>\n" +
	                    "                    </div>";
			req.setAttribute("info", info);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
			}else {
				 String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
		                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
		                    "                            Email id already present choose different mail!\n" +
		                    "                        </p>\n" +
		                    "                    </div>";
				req.setAttribute("alert", alert);
	            req.getRequestDispatcher("register.jsp").forward(req, resp);
				
			}
		}else {
			
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
