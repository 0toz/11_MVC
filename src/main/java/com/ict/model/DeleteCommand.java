package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("idx", idx);
		request.setAttribute("pwd", pwd);
		return "view/del.jsp";
	}
}
