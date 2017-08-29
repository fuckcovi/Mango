<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<th></th>
	</tr>
</thead>
<tbody>
	<c:forEach var="callingPlanList" items="${callingPlanList }">
	<tr>
		<td>${callingPlanList.cp_name }</td>
		<td>${callingPlanList.cp_data }</td>
		<td>${callingPlanList.cp_call }</td>
		<td>${callingPlanList.cp_message }</td>
		<td>${callingPlanList.cp_price }</td>
		<td>
		<fmt:formatNumber value="${callingPlanList.cp_price*0.95 }" pattern="0"/>
		</td>
		<td><input type="button" value="자세히보기" onclick="location.href='${pageContext.request.contextPath }/plan/cpDetail.do?cp_seq=${callingPlanList.cp_seq}'"></td>
	</tr>
	</c:forEach>
</tbody>

</table>