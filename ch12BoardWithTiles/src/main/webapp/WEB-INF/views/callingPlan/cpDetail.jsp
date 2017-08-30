<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h3><B>요금제</B></h3>
<table>
<thead>
	<tr>
		<th>상품명</th>
		<th>데이터</th>
		<th>음성</th>
		<th>문자</th>
		<th>월정액</th>
		<th>24개월약정시</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td>${callingPlan.cp_name }</td>
		<td>${callingPlan.cp_data }</td>
		<td>${callingPlan.cp_call }</td>
		<td>${callingPlan.cp_message }</td>
		<td>${callingPlan.cp_price }</td>
		<td>
		<fmt:formatNumber value="${callingPlan.cp_price*0.95 }" pattern="0"/>
		</td>
	</tr>
</tbody>

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