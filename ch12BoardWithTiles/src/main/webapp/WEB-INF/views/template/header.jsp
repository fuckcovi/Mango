<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="user-bar">
	<div class="sub-bar">
		<c:if test="${empty user_id}">
		<ul>
			<li><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
			<li><a href="${pageContext.request.contextPath}/member/join.do">회원가입</a></li>
		</ul>
		</c:if>
		<c:if test="${!empty user_id}">
		<ul>
			<li>${user_id}</li>
			<li><a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
		</ul>
		</c:if>
	</div>
</div>
<div id="menu-bar">
	<div class="sub-bar">
		<div style="float:left;height:100%;">
			<img src="${pageContext.servletContext.contextPath}/resources/images/mango.PNG" height="100%" onclick="location.href='${pageContext.request.contextPath}/main/main.do'" style="cursor:pointer">
		</div>
		<div style="float:right;height:100%;display:table;">
			<ul>
				<li><a href="${pageContext.request.contextPath}/plan/callingplan.do">상품서비스</a></li>
				<li><a href="${pageContext.request.contextPath}/device/device.do">다이렉트샵</a></li>
				<li><a href="#">멤버십</a></li>
				<li><a href="#">이벤트</a></li>
				<li><a href="#">고객센터</a></li>
				<li><a href="#">myMango</a></li>
			</ul>
		</div>
	</div>
</div>