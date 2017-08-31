<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h3><B>부가서비스</B></h3>
<table>
	<tr>
		<th>상품명</th>
		<td>${callingPlan.cp_name }</td>
	</tr>
	<tr>
		데이터
	</tr>
	<tr>
		전화
	</tr>
	<tr>
		문자
	</tr>
	<tr>
		<th>월정액</th>
		<td>
		<fmt:formatNumber value="${callingPlan.cp_price}" pattern="#,###" />원
		</td>
	</tr>
	<tr>
		<th>24개월약정시</th>
		<td>
		<fmt:formatNumber value="${callingPlan.cp_price*0.95 }" pattern="#,###" />원
		</td>
	</tr>
	
</table>
<div>
	<c:if test="${fn:endsWith(callingPlan.cp_detailimagename, '.jpg') || 
				fn:endsWith(callingPlan.cp_detailimagename, '.png') || 
				fn:endsWith(callingPlan.cp_detailimagename, '.gif') || 
				fn:endsWith(callingPlan.cp_detailimagename, '.JPG') || 
				fn:endsWith(callingPlan.cp_detailimagename, '.PNG') || 
				fn:endsWith(callingPlan.cp_detailimagename, '.GIF')}">
		<img src="${pageContext.request.contextPath}/plan/imageView.do?cp_seq=${callingPlan.cp_seq}" style="width:350px;height:500px;">
	</c:if>
	<c:if test="${empty callingPlan.cp_detailimagename }">
		${callingPlan.cp_detail }
	</c:if>
</div>