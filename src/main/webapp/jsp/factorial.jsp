<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! // 메소드 선언 %>
<%! public String hello(){
		return "hello~";		
	}
%>
	<%!
	public int fac(int i){
		int result = 1;
		if(i == 0){
		return result;
		}else{
			return fac(i-1)*i;
		}
	}
	%>

	
	
	hello() : <%=hello() %><br>
	fac(1) : <%= fac(1)%><br>
	fac(2) : <%= fac(2)%><br>
	fac(3) : <%= fac(3)%><br>
	fac(4) : <%= fac(4)%><br>
	fac(5) : <%= fac(5)%><br>
	fac(6) : <%= fac(6)%><br>
	fac(7) : <%= fac(7)%><br>
	fac(8) : <%= fac(8)%><br>







</body>
</html>