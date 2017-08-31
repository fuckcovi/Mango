<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h3><B>요금제</B></h3>
<table>
	<tr>
		<th>상품명</th>
		<td>${callingPlan.cp_name }</td>
	</tr>
	<tr>
		<th>데이터</th>
		<c:if test="${callingPlan.cp_data ne '무제한' }">
		<td><img alt="데이터" src="${pageContext.request.contextPath }/resources/images/bar70.PNG" height="30px;">
		<td>
		<fmt:formatNumber value="${callingPlan.cp_data}" pattern="#,###" />GB
		</c:if>
		<c:if test="${callingPlan.cp_data eq '무제한' }">
		<td><img alt="데이터" src="${pageContext.request.contextPath }/resources/images/bar100.PNG" height="30px;">
		<td>
		${callingPlan.cp_data}
		</c:if>
		</td>
	</tr>
	<tr>
		<th>전화</th>
		<c:if test="${callingPlan.cp_call ne '무제한' }">
		<td><img alt="전화" src="${pageContext.request.contextPath }/resources/images/bar70.PNG" height="30px;">
		<td>
		<fmt:formatNumber value="${callingPlan.cp_call}" pattern="#,###" />분
		</c:if>
		<c:if test="${callingPlan.cp_call eq '무제한' }">
		<td><img alt="전화" src="${pageContext.request.contextPath }/resources/images/bar100.PNG" height="30px;">
		<td>
		${callingPlan.cp_call}
		</c:if>
		</td>
	</tr>
	<tr>
		<th>문자</th>
		<c:if test="${callingPlan.cp_message ne '무제한' }">
		<td><img alt="문자" src="${pageContext.request.contextPath }/resources/images/bar70.PNG" height="30px;">
		<td>
		<fmt:formatNumber value="${callingPlan.cp_message}" pattern="#,###" />건
		</c:if>
		<c:if test="${callingPlan.cp_message eq '무제한' }">
		<td><img alt="문자" src="${pageContext.request.contextPath }/resources/images/bar100.PNG" height="30px;">
		<td>
		${callingPlan.cp_message}
		</c:if>
		</td>
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