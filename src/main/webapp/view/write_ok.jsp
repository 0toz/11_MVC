<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.ict.db.DAO"%> 
<%@page import="com.ict.db.VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		   // 실제 저장위치
		  String path = request.getServletContext().getRealPath("/upload");
		
		  MultipartRequest mr = new MultipartRequest(request,path,100*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		  VO vo = new VO();
		  vo.setName(mr.getParameter("name"));
		  vo.setSubject(mr.getParameter("subject"));
		  vo.setContent(mr.getParameter("content"));
		  vo.setEmail(mr.getParameter("email"));
		  vo.setPwd(mr.getParameter("pwd"));
		
		  // 첨부파일이 있을 때와 첨부파일이 없을 때을 구분하자 
		  if(mr.getFile("f_name")!=null){
			  vo.setF_name(mr.getFilesystemName("f_name"));
		  }else{
			  vo.setF_name("");
		  }
		  int result = DAO.getInstance().getInsert(vo);
		  if(result>0){
			  response.sendRedirect("list.jsp");
		  }
	}catch(Exception e){
		System.out.println(e);
	}
%>