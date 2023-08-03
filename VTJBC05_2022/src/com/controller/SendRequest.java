package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.FinanceService;

/**
 * Servlet implementation class SendRequest
 */
@WebServlet("/SendRequest")
public class SendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SendRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FinanceService fs=new FinanceService();
		int fid=Integer.parseInt(request.getParameter("fid"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		int i=0;
		try {
			 i=fs.sendRequest(fid, uid);
			 if(i!=-1) {
				 request.setAttribute("page", "view");
			     request.getRequestDispatcher("FinanceHome.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
