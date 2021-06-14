package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class UpdateCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		  
	
		return "view/update.jsp";
	}
}
