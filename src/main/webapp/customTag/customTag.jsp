<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

1. 고정문자열 : ===================================================<br>
2. loop : <c:forEach begin="1" end="52">=</c:forEach> <br>
3. customTag : <ct:logging/> <br>
4. loopCustomTag : <ct:loopLogging/> <br>
5. colorLoggingTag : <ct:colorLogging color="blue" size="20"/> <br>
5-1. colorLoggingTag : <ct:colorLogging color="blue"/> <br>
6. rangersTag : <ct:rangers rangers="brown,cony,james,sally,moon"/><br>
7. codeTag : <ct:code code="P201"></ct:code>

</body>
</html>