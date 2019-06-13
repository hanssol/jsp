<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
$(document).ready(function(){
	
	$("#languageSelect").val("${locale}");
	
	$("#languageSelect").on("change",function(){
		$("#frm").submit();
		
	})
})		

</script>
</head>
<body>

<h2>select locale</h2>
locale : ${locale }
<form id="frm" action="${pageContext.request.contextPath }/selectLocale" method="post">
	<select id="languageSelect" name="locale">
		<option value="ko">한국어</option>
		<option value="en">english</option>
		<option value="ja">日本言</option>
	</select>

	<br>
	<fmt:setLocale value="${locale }"/>
		<fmt:bundle basename="kr.or.ddit.msg.msg">
			<fmt:message key="GREETING"/>
			<fmt:message key="VISITOR">
			<fmt:param value="brown"/><br>
		</fmt:message>
	</fmt:bundle>
</form>


</body>
</html>