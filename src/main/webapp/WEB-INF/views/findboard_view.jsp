<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유기동물 보호센터</title>
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
	<img src="<%=request.getContextPath() %>/resources/img/hello.gif" width="100">유기동물 찾기 게시판  <img src="<%=request.getContextPath() %>/resources/img/hello.gif" width="100">
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
<hr>
	<h3 class="text-center">
		<img src="<%=request.getContextPath() %>/resources/img/강아지.gif" width="50">
		<a href="input_findboard" class="btn btn-primary btn-lg" role="button">유기동물 등록</button></a>
		<img src="<%=request.getContextPath() %>/resources/img/강아지.gif" width="50">  
	</h3>	
</hr>
<hr>
<form class="text-center" action="list_findboard" method="get">
		잃어버린 장소로 검색<input type="text" name="search_word"><input type="submit" value="검색">	
	</form><br>
 <table class="table table-hover"> 
 	<thead>
 		<tr>
 	
 				<th scope="col" class="text-center">순번 </th>
 				<th scope="col" class="text-center">번호</th>
 				<th scope="col" class="text-center">이미지</th>
 				<th scope="col" class="text-center">잃어버린 장소</th>
 				<th scope="col" class="text-center">제목</th>
 				<th scope="col" class="text-center">내용</th>
 				<th scope="col" class="text-center">작성자</th>
 				<th scope="col" class="text-center">조회수</th>		
 		</tr>
	</thead>
	<tbody>
  <!--  리스트를 가져옴.. foreach -->
	<c:forEach var="findboardvo" items="${fList}" varStatus="status">  <!--  리스트나 배열을 제어하는 명령어 -->
 			<tr>
 				<td style="vertical-align: middle" class="text-center">${status.count}</td>
 				<td style="vertical-align: middle" class="text-center">${findboardvo.num}</td>
 				<td style="vertical-align: middle" class="text-center"><a href="findboard_detail?viewno=${findboardvo.num}"><img src="<%=request.getContextPath() %>\resources${findboardvo.img_thumb }" width="50" /></td>
 				<td style="vertical-align: middle" class="text-center">${findboardvo.area}</td>
 				<td style="vertical-align: middle" class="text-center"><a href="findboard_detail?viewno=${findboardvo.num}">${findboardvo.title }</td>
 				<td style="vertical-align: middle" class="text-center">${findboardvo.content}</td>
 				<td style="vertical-align: middle" class="text-center">${findboardvo.writer}</td>
 				<td style="vertical-align: middle" class="text-center">${findboardvo.cnt}</td>
 				
 				
 			</tr>
 	</c:forEach>
 	</tbody>
  </table> 
<hr>	
 	<div>  <!--page 정보 출력 page정보는 pageVO 객체가 저장하고 있음. 컨트롤러가 전달함 -->
 	
 		<ul class="text-center">
 			<c:if test="${pageVO.prev }">
 				<a href="list_findboard?page=${pageVO.startPage -1 }&search_word=${pageVO.search_word }">[이전페이지그룹]</a>
 			</c:if>
 			<!-- page 그룹 정보출력 변수명 startPage   endPage -->
 			<c:forEach begin="${pageVO.startPage }" end="${pageVO.endPage }" var="idx">
 				<a href="list_findboard?page=${idx }&search_word=${pageVO.search_word }">${idx }</a>
 			</c:forEach>
 			<c:if test="${pageVO.next }">
 				<a href="list_findboard?page=${pageVO.endPage +1 }&search_word=${pageVO.search_word }">[다음페이지그룹]</a>
 			</c:if>
 		</ul>
 	
 	
 	</div> 
 </hr>	 

 </div>	
</body>
</html>