<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3><B>요금제</B></h3>
<c:if test="${user_status == 9 }">
<input type="button" value="요금제등록" onclick="location.href='${pageContext.request.contextPath}/plan/registerCpForm.do'">
</c:if>
<table>
<thead>
	<tr>
		<th>상품명</th>
		<th>데이터</th>
		<th>전화</th>
		<th>문자</th>
		<th>월정액(부가세포함)</th>
		<th>24개월약정시(부가세포함)</th>
		<th></th>
	</tr>
</thead>
<tbody>
	<c:forEach var="callingPlanList" items="${callingPlanList }">
	<tr>
		<td>${callingPlanList.cp_name }</td>
	<c:if test="${callingPlanList.cp_category eq  '부가서비스'}">
		<td>
			부가서비스데이터
		</td>
		<td>
			부가서비스전화
		</td>
		<td>
			부가서비스문자
		</td>
	</c:if>
	<c:if test="${callingPlanList.cp_category eq '모바일' }">
		<td>
		<c:if test="${callingPlanList.cp_data ne '무제한' }">
		<fmt:formatNumber value="${callingPlanList.cp_data}" pattern="#,###" />GB
		</c:if>
		<c:if test="${callingPlanList.cp_data eq '무제한' }">
		${callingPlanList.cp_data}
		</c:if>
		</td>
		<td>
		<c:if test="${callingPlanList.cp_call ne '무제한' }">
		<fmt:formatNumber value="${callingPlanList.cp_call}" pattern="#,###" />분
		</c:if>
		<c:if test="${callingPlanList.cp_call eq '무제한' }">
		${callingPlanList.cp_call}
		</c:if>
		</td>
		<td>
		<c:if test="${callingPlanList.cp_message ne '무제한' }">
		<fmt:formatNumber value="${callingPlanList.cp_message}" pattern="#,###" />건
		</c:if>
		<c:if test="${callingPlanList.cp_message eq '무제한' }">
		${callingPlanList.cp_message}
		</c:if>
		</td>
	</c:if>
		<td><fmt:formatNumber value="${callingPlanList.cp_price}" pattern="#,###" />원</td>
		<td>
		<fmt:formatNumber value="${callingPlanList.cp_price*0.95 }" pattern="#,###"/>원
		</td>
	<c:if test="${callingPlanList.cp_category eq  '모바일'}">
		<td><input type="button" value="자세히보기" onclick="location.href='${pageContext.request.contextPath }/plan/cpDetail.do?cp_seq=${callingPlanList.cp_seq}'"></td>
	</c:if>
	<c:if test="${callingPlanList.cp_category eq  '부가서비스'}">
		<td><input type="button" value="자세히보기" onclick="location.href='${pageContext.request.contextPath }/plan/serDetail.do?cp_seq=${callingPlanList.cp_seq}'"></td>
	</c:if>
	</tr>
	</c:forEach>
</tbody>

</table>