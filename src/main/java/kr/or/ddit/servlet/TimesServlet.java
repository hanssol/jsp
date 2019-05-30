package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimesServlet extends HttpServlet {
	
	private Logger logger = LoggerFactory.getLogger(TimesServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		// localhost/jsp/timesTables?param=7
		String param = req.getParameter("i");
		logger.debug("pram : {}" + param);
		
		String param2 = req.getParameter("j");
		logger.debug("pram2 : {}" + param2);
//		System.out.println("param : " + param);
		
		
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>Hello, World!</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<span>Hello, World!</span>");
		pw.write("		<table border='1'>");
		for (int i = 1; i <= Integer.parseInt(param2); i++) {
			pw.write("			<tr>");
			for (int j = 2; j <= Integer.parseInt(param); j++) {
				pw.write("				<td> "+ j+" X "+i+" = "+i*j +" </td>");
			}
			pw.write("			</tr>");
		}
		pw.write("		</table>");
		
		pw.write("	</body>");
		pw.write("</html>");
		pw.close();
		
	}

}
