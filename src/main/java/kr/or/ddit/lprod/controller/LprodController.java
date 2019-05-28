package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.paging.model.PageVo;

/**
 * Servlet implementation class LprodController
 */
@WebServlet("/lprodPagingList")
public class LprodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private ILprodService lprodService;
   
   
	@Override
	public void init() throws ServletException {
		lprodService = new LprodService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize =  pageSizeString == null ? 5 : Integer.parseInt(pageSizeString);
		
		PageVo pageVo = new PageVo(page,pageSize);
		
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/lprod/lprodPage.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
