<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FilePermission"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.write("application.getContextPath() : " + application.getContextPath() + "<br>");
			out.write("application.getServerInfo() : " +application.getServerInfo() + "<br>");
			out.write("application.getMajorVersion() : " +application.getMajorVersion() + "<br>");
			out.write("application.getMinorVersion() : " +application.getMinorVersion() + "<br>");
			out.write("application.getInitParameter(\"ADMIN\") : " +application.getInitParameter("ADMIN") + "<br>");
			
			out.write("application.getRealPath(\"/res/190522.txt\") : " + application.getRealPath("/res/190522.txt")+ "<br>");
			
		BufferedReader reader = null;
		try {
			String filePath = application.getRealPath("/res/190522.txt");
			reader = new BufferedReader(new FileReader(filePath));
			while (true) {
				String str = reader.readLine();
				if (str == null)
					break;
				out.print(str + "</br>");
			}
		} catch (FileNotFoundException fnfe) {
			out.print("파일없어~~~~~.");
		} catch (IOException ioe) {
			out.print("파일 못읽어~~~~~~~.");
		}

		finally {
			try {
				reader.close();
			} catch (Exception e) {

			}
		}
	%>
</body>
</html>