<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
	<img src="<%=request.getContextPath() %>/resources/img/hello.gif" width="100">회원가입 <img src="<%=request.getContextPath() %>/resources/img/hello.gif" width="100">
</h1>
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
<h1 class="text-center">
	정보를 입력하세요  
</h1><br>
	<form class="text-center" action="register_save" method="post"> 
		아이디 <input type="text" name="userid"><button type="button" class="idCheck">중복체크</button> <br>
			<p class="result">
				<span class="msg">아이디 중복체크 해주세요</span>
			</p>
		비밀번호 <input type="password" name="pass"> <br>
		이름 <input type="text" name="name"> <br>
		성별  <input type="radio" name="gender" value="남성">남성
		    <input type="radio" name="gender" value="여성">여성<br>
		전화번호 <input type="text" name="phone_number"> <br>
		주소  
			<input type="text" id="sample2_postcode" placeholder="우편번호">
			<input type="button" class="btn btn-primary" onclick="sample2_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" name="adress" id="sample2_address" placeholder="주소"><br>
			<input type="text" name="adress" id="sample2_detailAddress" placeholder="상세주소"><br>
			<input type="text" name="adress" id="sample2_extraAddress" placeholder="참고항목"><br>
			
			<!-- <input type="text" name="adress" id="sample2_detailAddress" placeholder="상세주소">-->
			<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
			</div><br>
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			
			<script>
    			// 우편번호 찾기 화면을 넣을 element
    			var element_layer = document.getElementById('layer');

   			 function closeDaumPostcode() {
       			 // iframe을 넣은 element를 안보이게 한다.
       			 element_layer.style.display = 'none';
    			}

   			 function sample2_execDaumPostcode() {
        			new daum.Postcode({
            			oncomplete: function(data) {
               			 // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
                			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                			var addr = ''; // 주소 변수
                			var extraAddr = ''; // 참고항목 변수
		
                			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    			addr = data.roadAddress;
               			 } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    			addr = data.jibunAddress;
               			 }

                			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                			if(data.userSelectedType === 'R'){
                   			 // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                   			 // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                   			 if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        			extraAddr += data.bname;
                    			}
                   			 // 건물명이 있고, 공동주택일 경우 추가한다.
                   			 if(data.buildingName !== '' && data.apartment === 'Y'){
                       			 extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    			}
                    				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    			if(extraAddr !== ''){
                        			extraAddr = ' (' + extraAddr + ')';
                   			 }
                    			// 조합된 참고항목을 해당 필드에 넣는다.
                   			 document.getElementById("sample2_extraAddress").value = extraAddr;
                
                			} else {
                    			document.getElementById("sample2_extraAddress").value = '';
                			}

                			// 우편번호와 주소 정보를 해당 필드에 넣는다.
                			document.getElementById('sample2_postcode').value = data.zonecode;
                			document.getElementById("sample2_address").value = addr;
                			// 커서를 상세주소 필드로 이동한다.
               			 document.getElementById("sample2_detailAddress").focus();

               			 // iframe을 넣은 element를 안보이게 한다.
                			// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
               			 element_layer.style.display = 'none';
           			 },
           			 width : '100%',
            			height : '100%',
            			maxSuggestItems : 5
        			}).embed(element_layer);

        			// iframe을 넣은 element를 보이게 한다.
        			element_layer.style.display = 'block';

        			// iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
        			initLayerPosition();
    			}

    			// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    			// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
   				 // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    			function initLayerPosition(){
       			 var width = 300; //우편번호서비스가 들어갈 element의 width
        			var height = 400; //우편번호서비스가 들어갈 element의 height
        			var borderWidth = 5; //샘플에서 사용하는 border의 두께

        			// 위에서 선언한 값들을 실제 element에 넣는다.
        			element_layer.style.width = width + 'px';
        			element_layer.style.height = height + 'px';
        			element_layer.style.border = borderWidth + 'px solid';
       			 // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
       			 element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
       			 element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
   			 }
			</script>

		이메일 <input type="text" name="email" placeholder="example@gmail.com"> <br>
		
		<hr>
		<input class="text-center btn btn-primary" type="submit" value="회원가입">
		</hr>
</form>		
 
<script> 
$(".idCheck").click(function(){
 
 var query = {userid : $("#userid").val()};
 
 $.ajax({
  url : "idCheck",
  type : "post",
  data : query,
  success : function(data) {
  
   if(data == 1) {
    $(".result .msg").text("이 아이디는 사용불가 합니다");
    $(".result .msg").attr("style", "color:#f00");    
   } else {
    $(".result .msg").text("이 아이디는 사용가능 합니다");
    $(".result .msg").attr("style", "color:#00f");
   }
  }
 });  // ajax 끝
});
</script>
</body>
</html>