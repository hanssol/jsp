<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sumInput 테스트</h2>
	<form action="<%=request.getContextPath()%>/sumCalculation" method="post">
	Start : <input type="text" name="start" />
	End : <input type="text" name="end"/>
	<button>더하기</button>	
	</form>
</body>
</html>