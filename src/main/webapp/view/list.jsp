<%@page import="com.ict.db
.VO"%> 
<%@page import="com.ict.db.DAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
    List<VO> list = DAO.getInstance().getSelectAll(); 
    pageContext.setAttribute("list", list);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{text-decoration: none;}
	table{width: 600px; border-collapse: collapse;; text-align: center;}
	table, th, td{border: 1px solid black; padding: 5px; margin: auto;}
	div{ width: 600px; margin: 100px auto; text-align: center;}
</style>
</head>
<body>
	<div>
		<h2>방명록</h2>
		<hr>
		<p>[ <a href="write.jsp">방명록 쓰기</a> ]</p>
		<form method="post">
			<table>
				<thead>
					<tr style="background-color: #99ccff">
					   <th>번호</th><th>작성자</th><th>제목</th><th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list}">
						   <tr><td colspan="4"><h2>원하는 정보가 존재하지 않습니다</h2></td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="k" items="${list}" varStatus="vs">
								<tr>
									<td>${vs.count}</td>
									<td>${k.name }</td>
									<td><a href="onelist.jsp?idx=${k.idx}">${k.subject }</a></td>
									<td>${k.regdate.substring(0,10)}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>