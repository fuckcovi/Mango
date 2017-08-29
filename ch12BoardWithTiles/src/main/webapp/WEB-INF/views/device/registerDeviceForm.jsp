<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form commandName="deviceCommand">
<table>
	<tr>
		<th><form:label path="d_name">기기명</form:label></th>
		<td><form:input path="d_name"/></td>
		<td><form:errors path="d_name" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="d_modelnum">기기번호</form:label></th>
		<td><form:input path="d_modelnum"/></td>
		<td><form:errors path="d_modelnum" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="d_regdate">출시일</form:label></th>
		<td><input type="date" id="d_regdate" name=d_regdate></td>
		<td>출시일 미지정 시 출시예정으로 등록됩니다.</td>
	</tr>
	<tr>
		<th><form:label path="d_type">기기유형</form:label></th>
		<td>
			<form:select path="d_type">
				<form:option value="핸드폰">핸드폰</form:option>
				<form:option value="태블릿">태블릿</form:option>
				<form:option value="스마트워치">스마트워치</form:option>
				<form:option value="키즈폰">키즈폰</form:option>
			</form:select>
		</td>
		<td><form:errors path="d_type" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="d_explain">기기설명</form:label></th>
		<td><form:input path="d_explain"/></td>
		<td><form:errors path="d_explain" cssClass="error-color"/></td>
	</tr>
</table>
<input type="submit" value="기기등록">
<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/device/device.do'">
</form:form>
