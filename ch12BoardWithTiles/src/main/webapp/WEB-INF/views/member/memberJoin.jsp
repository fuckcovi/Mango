<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입완료 | Mango</title>
<style>
* { margin: 0 auto; }
body {
	margin: 0 auto;
	width: 100%;
	min-height: 1000px;
	height: 1000px;
	text-align: center;
	background: #EAEAEA;
	font-family: "나눔고딕";
}
</style>
<body>
	<div style="width:650px;height:100%;background:#FFF">
		<div><img src="${pageContext.request.contextPath}/resources/images/mango.PNG" onclick="location.href='${pageContext.request.contextPath}/main/main.do'" style="cursor:pointer"></div>
		<hr size="1" color="#EAEAEA">
		<div style="padding:10px;text-align:left;font-size:12px">약관 동의 > 정보 입력 > </span><strong>가입 완료</strong></div>
		<div style="line-height:250%">
			<h3 style="font-weight:bold;">회원가입이 완료되었습니다!</h3>
			<img src="${pageContext.request.contextPath}/resources/images/mango_img2.PNG">
			<br>
			<input type="button" value="로그인" onclick="location.href='${pageContext.request.contextPath}/member/login.do'" style="width:200px;height:60px;background:#FFC000;border:0;font-size:16px;cursor:pointer">
		</div>
	</div>
</body>
</html>