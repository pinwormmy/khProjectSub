<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>비밀번호 찾기</title>

</head>

<body id="body">

	<%@ include file="../include/header.jspf"%>

	<%-- Forgot password box --%>
	<section class="forget-password-page account">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="block text-center">
						<h2 class="text-center">비밀번호 찾기</h2>
						<form class="text-center" action="changePwd.jsp">
							<p>
								가입한 계정의 이메일 주소로 인증 코드가 전송됩니다. </br>
								인증 코드 확인 후 새 비밀번호를 설정할 수 있습니다.
							</p>
							<div class="form-group">
								<input type="email" class="form-control" id="exampleInputEmail1"
									placeholder="가입한 이메일을 입력해주세요">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-main text-center">인증
									코드 전송</button>
							</div>
						</form>
						<p class="mt-20">
							<a href="login.do">로그인하러 가기</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../include/footer.jspf"%>

</body>
</html>