<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>비밀번호 변경</title>

</head>

<body id="body">

	<%@ include file="../include/header.jspf"%>

	<%-- Forgot password box --%>
	<section class="forget-password-page account">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="block text-center">
						<h2 class="text-center">비밀번호 변경</h2>
						<form class="text-left clearfix">
							<div class="form-group">
								<input type="password" class="form-control" id=""
									placeholder="이메일 인증 코드">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id=""
									placeholder="새 비밀번호">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id=""
									placeholder="새 비밀번호 확인">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-main text-center">비밀번호
									변경 요청</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>


	<%@ include file="../include/footer.jspf"%>

</body>
</html>