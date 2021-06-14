package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Update_okCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/upload");
		MultipartRequest mr = 
				new MultipartRequest(request,path,100*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		
		//세션에 있는 vo를 꺼내자/
		VO o_vo = (VO)request.getSession().getAttribute("vo");
		
		
		VO vo = new VO();
	    vo.setIdx(o_vo.getIdx("idx"));
	    //안고치는 애들만 세션에서 받음. 고쳐지는 애들은 바뀌기떄문에 세션에서 불러오기어렵.
	    vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setEmail(request.getParameter("email"));
		vo.setPwd(request.getParameter("pwd"));
		String f_name2= mr.getParameter("f_name2");
		if(mr.getFIle("f_name")==null) {
			vo.setF_name(f_name2);
		}else {
			//첨부파일이 있으면 첨부파일을 사용한다.
		}
		
		int result = DAO.getInstance().getUpdate(vo);
		if(result>0){ 
			// response.sendRedirect("onelist.jsp?idx="+vo.getIdx());
			return "MyController?cmd=onelist&idx="+vo.getIdx();
		}
		return null;
	}
}
