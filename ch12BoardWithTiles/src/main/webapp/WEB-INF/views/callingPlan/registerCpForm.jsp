<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h3><B>요금제 등록</B></h3>
<form:form commandName="callingPlanCommand" enctype="multipart/form-data">
<table>
	<tr>
		<th><form:label path="cp_name">상품명</form:label></th>
		<td><form:input path="cp_name"/></td>
		<td><form:errors path="cp_name" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_category">카테고리</form:label></th>
		<td><form:input path="cp_category"/></td>
		<td><form:errors path="cp_category" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_modelnum">모델명</form:label></th>
		<td><form:input path="cp_modelnum"/></td>
		<td><form:errors path="cp_modelnum" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_regdate">출시일</form:label></th>
		<td><input type="date" id="cp_regdate" name=cp_regdate></td>
		<td>출시일 미지정 시 출시예정으로 등록됩니다.</td>
	</tr>
	<tr>
		<th><form:label path="cp_data">데이터</form:label></th>
		<td><form:input path="cp_data"/></td>
		<td><form:errors path="cp_data" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_call">음성</form:label></th>
		<td><form:input path="cp_call"/></td>
		<td><form:errors path="cp_call" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_message">문자</form:label></th>
		<td><form:input path="cp_message"/></td>
		<td><form:errors path="cp_message" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_price">가격</form:label></th>
		<td><form:input path="cp_price"/></td>
		<td><form:errors path="cp_price" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_detail">상세설명(이미지안보일때)</form:label></th>
		<td><form:textarea path="cp_detail" cols="30" rows="10"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_detailimagefile">상세이미지</form:label></th>
		<td><input type="file" name="cp_detailimagefile" id="cp_detailimagefile" onchange="javascript:document.getElementById('file_route').value=this.value">
		<td><input type="text" readonly="readonly" title="File Route" id="file_route"></td>
	</tr>
</table>
<input type="submit" value="요금제등록">
<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/plan/callingPlan.do'">
</form:form>