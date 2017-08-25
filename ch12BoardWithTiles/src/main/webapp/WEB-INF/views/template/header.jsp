<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="user-bar">
	<c:if test="${empty user_id}">
	<ul>
		<li><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/member/join.do">회원가입</a></li>
	</ul>
	</c:if>
	<c:if test="${!empty user_id}">
	<ul>
		<li>${user_id}</li>
	</ul>
	</c:if>
</div>
<div id="menu-bar">
<img src="${pageContext.servletContext.contextPath}/resources/images/mango.PNG" height="100%" onclick="location.href='${pageContext.request.contextPath}/main/main.do'" style="cursor:pointer">
</div>