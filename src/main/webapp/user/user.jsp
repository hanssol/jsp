<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<title>사용자 상세조회</title>

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
						<h2 class="sub-header">사용자상세</h2>
						
						<form class="form-horizontal" role="form" action="${cp }/userModify"
							  method="get">
								<input type="hidden" id="userId" name="userId" value="${userInfo.userId}"/>
						
						<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
								<div class="col-sm-10">
								
									<img src="${cp }/profile?userId=${userInfo.userId}"/>
								</div>
							</div>
						
		
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
								<div class="col-sm-10">
									<label class="control-label">${userInfo.userId }</label>
<!-- 										<input type="text" class="form-control" id="userId" name="userId" -->
<!-- 											placeholder="사용자 아이디"> -->
								</div>
							</div>
		
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
								<div class="col-sm-10">
									<label class="control-label">${userInfo.name }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">별명</label>
								<div class="col-sm-10">
									<label class="control-label">${userInfo.alias }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">주소</label>
								<div class="col-sm-10">
									<label class="control-label">${userInfo.addr1 }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-10">
									<label class="control-label">${userInfo.addr2 }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									<label class="control-label">${userInfo.zipcd }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">생일</label>
								<div class="col-sm-10">
									<label class="control-label"> <fmt:formatDate value="${userInfo.birth}" pattern="yyyy-MM-dd"/></label>
								</div>
							</div>
							
							
		
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									
									<button type="submit" class="btn btn-default">사용자 수정</button>
								</div>
							</div>
							
							
							
						</form>

						
						
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>