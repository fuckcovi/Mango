<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form commandName="memberCommand" >
<table>
<tr>
	<th>아이디</th>
	<td><form:input path="m_id"/></td>
</tr>
<tr>
	<th>패스워드</th>
	<td><form:password path="m_pw"/></td>
</tr>
</table>
<input type="submit" value="로그인">
</form:form>