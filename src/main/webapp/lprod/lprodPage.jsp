<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>lprod 페이지 리스트</title>

<!-- css,js -->
<%@include file="/common/basicLib.jsp" %>
</head>
<body>
	<!-- header -->
	<%@include file="/common/header.jsp" %>
	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>lprod Id</th>
									<th>lprod Gu</th>
									<th>lprod 이름</th>
								</tr>
								<c:forEach items="${lprodList }" var="lprod">
									<tr>
										<td>${lprod.lprod_id }</td>
										<td>${lprod.lprod_gu }</td>
										<td>${lprod.lprod_nm }</td>
									</tr>
								</c:forEach>
								<%
									List<LprodVo> lprodList = (List<LprodVo>)request.getAttribute("lprodList");
									for(int i=0;i<lprodList.size();i++){
										out.write("<tr>");
										out.write("<td>"+lprodList.get(i).getLprod_id()+"</td>");
										out.write("<td>"+lprodList.get(i).getLprod_gu()+"</td>");
										out.write("<td>"+lprodList.get(i).getLprod_nm()+"</td>");
										out.write("<td>"+"</td>");
										out.write("</tr>");
									}
								%>
								
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>
						<!-- 사용자수 : 105건
							페이지네이션 : 11건
						 -->
						<div class="text-center">
							<ul class="pagination">
						<%
								// 내가 현제 몇번째 페이지에 있는가?
								PageVo pageVo = (PageVo)request.getAttribute("pageVo");
							%>
							
							<c:choose>
								<c:when test="${pageVo.page == 1 }">	<%-- <c:when test="${pageVo.getPage() == 1 }"> --%>
									<li class="disabled"><span>«</span></li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="${cp}/lprodPagingList?page=${pageVo.page - 1}&pageSize=${pageVo.pageSize}">«</a>
									</li>
								</c:otherwise>
							</c:choose>

								<c:forEach begin="1" end="${paginationSize}" var="i">
									<c:choose>
										<c:when test="${pageVo.page == i}">
											<li class="active"><span>${i}</span></li>
										</c:when>
										<c:otherwise>
											<li><a href="${cp}/lprodPagingList?page=${i}&pageSize=${pageVo.pageSize}">${i}</a></li>
										</c:otherwise>
									</c:choose>

								</c:forEach>
								<c:choose>
									<c:when test="${pageVo.page == paginationSize}">
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${cp}/lprodPagingList?page=${pageVo.page + 1}&pageSize=${pageVo.pageSize}">»</a>
										</li>
									
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>