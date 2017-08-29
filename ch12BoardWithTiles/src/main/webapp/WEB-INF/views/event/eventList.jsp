<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h2>이벤트</h2>
	<c:forEach var="event" items="${list}">
		${event.e_seq}
	</c:forEach>
	<div>${pagingHtml}</div>
</div>