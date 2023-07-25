<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
<h1 class="text-center">
	<img src="<%=request.getContextPath() %>/resources/img/hello.gif" width="100">자유게시판/찾은후기 <img src="<%=request.getContextPath() %>/resources/img/hello.gif" width="100"> 
</h1>
<hr>
	<ul class="text-center">
 <c:if test="${nowUser != null }">
   		loginUser : ${nowUser }님 환영합니다. <a href="modify" class="btn btn-primary" role="button">회원정보 수정</a>
   		<a href="withdrawal" class="btn btn-primary" role="button">회원탈퇴</a>
   		<a href="logout" class="btn btn-primary" role="button">로그아웃</a> <br>
 </c:if>
 <c:if test="${nowUser == null }">
	<form action="login" method="post" >
	

			<img src="<%=request.getContextPath() %>/resources/img/고양이2.gif" width="50">아이디<input type="text" name="userid">
			비밀번호<input type="password" name="pass">
			<input class="btn btn-primary" type="submit" value="로그인">
			<a class="btn btn-primary" href="register" role="button">회원가입</a>
			
	<c:if test="${msg == false }">
 		<p style="color:#f00;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력해주세요.</p>
	</c:if>		
		
	
	</form>
</c:if>
</ul>


<hr>

<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header col-md-9">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse col-md-3"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/"" style="font-size: 30px">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="list_findboard" style="font-size: 30px">유기동물 찾기</a></li>
					<li class="nav-item"><a class="nav-link" href="list_protectboard" style="font-size: 30px">유기동물 보호중</a></li>
					<li class="nav-item"><a class="nav-link" href="list_sponsorboard" style="font-size: 30px">후원요청</a></li>
					<li class="nav-item"><a class="nav-link" href="list_comunityboard" style="font-size: 30px">커뮤니티</a></li>
					<li class="nav-item"><a class="nav-link" href="list_applicationboard" style="font-size: 30px">분양신청</a>
						<form action="list_findboard" method="get">
						</form>
						<form action="list_protectboard" method="get">
						</form>
						<form action="list_sponsorboard" method="get">
						</form>
						<form action="list_comunityboard" method="get">
						</form>
						<form action="list_applicationboard" method="get">
						</form>
					
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</hr>

<hr>
	<h3 class="text-center">
	<a href="input_comunityboard" class="btn btn-primary btn-lg" role="button">글 작성하기</a>
	</h3>  
</hr>

<hr>
 <table class="table table-hover">  
  <tr>
             <td style="width: 5%" class="text-center">글번호</td>
             <td style="width: 80%" class="text-center">${viewvo.num}</td>
 </tr>
 <tr>		
             <td style="vertical-align: middle" class="text-center">이미지</td>
             <td style="vertical-align: middle" class="text-center"><img src="<%=request.getContextPath() %>\resources${viewvo.img_url}" width="200"/></td>
 </tr>
 <tr>
             <td style="width: 10%" class="text-center">종류</td>
             <td style="width: 80%" class="text-center">${viewvo.animal_kind}</td>
 </tr>
 <tr>
             <td style="width: 20%" class="text-center">제목</td>
             <td style="width: 80%" class="text-center">${viewvo.title}</td>
 </tr>
 <tr>
             <td style="width: 20%" class="text-center">내용</td>
             <td style="width: 80%" class="text-center">${viewvo.content}</td>
 </tr>
 
 <tr>
             <td style="width: 10%" class="text-center">작성자</td>
             <td style="width: 80%" class="text-center">${viewvo.writer}</td>
 </tr>
 <tr>
             <td style="width: 10%" class="text-center">등록일</td>
             <td style="width: 80%" class="text-center"><fmt:formatDate value="${viewvo.indate}" pattern="yyyy-MM-dd"/></td>
 </tr>
 
 <tr>
             <td style="width: 5%" class="text-center">조회수</td>
             <td style="width: 80%" class="text-center">${viewvo.cnt}</td>
 </tr>
 </table>
 <hr>
 <ul class="text-center">
 <c:forEach items="${reply}" var="reply">
<li>
	<div>
		<p>작성자 : ${reply.writer} /
		 등록일 : <fmt:formatDate value="${reply.indate}" pattern="yyyy-MM-dd"/></p>
		<p>내용 : ${reply.content }</p>
		
	</div>
</li>	
</c:forEach>
</ul>

<div class="text-center">

	<form method="post" action="write">
	
		<p>
			<label>댓글 작성자</label> <input type="text" name="writer">
		</p>
		<p>
			<textarea class="form-control" placeholder="Leave a comment here" rows="5" cols="50" name="content"></textarea>
		</p>
		<p>
			<input type="hidden" name="num" value="${viewvo.num}">
			<button type="submit">댓글 작성</button>
		</p>
	</form>
	
</div>

		<h4 class="text-center">

 				<td><a href="modComunityboard?modno=${viewvo.num}"  class="btn btn-primary" role="button">수정하기
 				<a href="deleteComunityboard?deltitle=${viewvo.num}"  class="btn btn-primary" role="button">삭제하기</a></td>
 		</h4>		 
</div>			
</body>
</html>