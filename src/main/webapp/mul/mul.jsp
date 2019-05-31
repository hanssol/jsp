<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<%--
<%
String param1 = request.getParameter("i");
String param2 = request.getParameter("j");
request.setAttribute("hang", Integer.parseInt(param1));
request.setAttribute("dan", Integer.parseInt(param2));

%>
	<table border="1">
	<c:forEach begin="1" end="${dan}" var="i">
		<tr>
			<c:forEach begin="2" end="${hang}" var="j">
				<td>${j } X ${i } = ${i*j } </td>
			
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
 --%>
	
	<table border="1">
	<c:forEach begin="1" end="${empty param.hang ? 9 : param.hang}" var="i">
		<tr>
			<c:forEach begin="2" end="${empty param.dan ? 9 : param.dan}" var="j">
				<td>${j } X ${i } = ${i*j } </td>
			
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
</body>
</html>