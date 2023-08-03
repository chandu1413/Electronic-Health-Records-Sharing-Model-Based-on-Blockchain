package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.MyExcetpion;
import com.model.RegisterModel;
import com.service.LoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String emailid=req.getParameter("emailid");
		String password=req.getParameter("password");
		String logintype=req.getParameter("fin");
		
		if(emailid.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("admin")) {
		
			
			resp.sendRedirect("adminhome.jsp");
		}else if(logintype.equalsIgnoreCase("finance")){
			
			
			LoginService lc=new LoginService();
			boolean userStatus=lc.financeLogin(emailid, password);
			
			if(userStatus) {
				try {
					
					RegisterModel rm=lc.getFinanceDetails(emailid);
					 HttpSession session = req.getSession();
					 session.setAttribute("account", rm);
					 req.setAttribute("account", rm);
				     req.getRequestDispatcher("FinanceHome.jsp").forward(req, resp);
				} catch (ClassNotFoundException | SQLException | MyExcetpion e) {
					e.printStackTrace();
				}	
				
			}else {
				String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            email/passowrd wrong!\n" +
	                    "                        </p>\n" +
	                    "                    </div>";
			req.setAttribute("alert", alert);
	        req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
			
		}
		
		else {
		
		LoginService lc=new LoginService();
		boolean userStatus=lc.userLogin(emailid, password);
		
		if(userStatus) {
			try {
				
				RegisterModel rm=lc.getUserDetails(emailid);
				 HttpSession session = req.getSession();
				 session.setAttribute("account", rm);
				 req.setAttribute("account", rm);
			     req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ClassNotFoundException | SQLException | MyExcetpion e) {
				e.printStackTrace();
			}	
			
		}else {
			String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    "                            email/passowrd wrong!\n" +
                    "                        </p>\n" +
                    "                    </div>";
		req.setAttribute("alert", alert);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		}

	}

}
