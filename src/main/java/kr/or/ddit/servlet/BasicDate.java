package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

public class BasicDate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Date today = new Date();         
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");

		PrintWriter pw = resp.getWriter();
		pw.write(date.format(today));
	}
	
}
