<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form commandName="memberCommand" >
<table>
<tr>
	<th>
		<form:label path="m_id">아이디</form:label>
	</th>
	<td>
		<form:input path="m_id"/>
	</td>
</tr>
<tr>
	<th>
		<form:label path="m_pw">비밀번호</form:label>
	</th>
	<td>
		<form:password path="m_pw"/>
	</td>
</tr>
<tr>
	<th>
		<form:label path="m_name">이름</form:label>
	</th>
	<td>
		<form:input path="m_name"/>
	</td>
</tr>
<tr>
	<th>
		<form:label path="m_phone1">전화번호</form:label>
	</th>
	<td>
		<table>
		<tr>
			<td>
				<form:select path="m_phone1">
					<form:option value="010"/>
					<form:option value="011"/>
					<form:option value="017"/>
					<form:option value="018"/>
					<form:option value="019"/>
				</form:select>
			</td>
			<th>	
				<form:label path="m_phone2">-</form:label>
			</th>
				<td>
					<form:input path="m_phone2"/>
				</td>
			<th>
				<form:label path="m_phone3">-</form:label>
			</th>
			<td>
				<form:input path="m_phone3"/>
			</td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<th>	
		<form:label path="m_birth">생년월일</form:label>
	</th>
	<td>
		<input type="date" id="m_birth" name="m_birth">
	</td>
</tr>
<tr>
	<th>	
		<form:label path="m_address1">주소</form:label>
	</th>
	<td>
		<form:input path="m_address1"/>
	</td>
</tr>
<tr>
	<th>	
		<form:label path="m_address2">상세주소</form:label>
	</th>
	<td>
		<form:input path="m_address2"/>
	</td>
</tr>
<tr>
	<th>	
		<form:label path="m_mydevice1">마이기기1</form:label>
	</th>
	<td>
		<form:input path="m_mydevice1"/>
	</td>
</tr>
<tr>
	<th>
		<form:label path="m_mydevice2">마이기기2</form:label>
	</th>
	<td>
		<form:input path="m_mydevice2"/>
	</td>
</tr>
<tr>
	<th>
		<form:label path="m_mydevice3">마이기기3</form:label>
	</th>
	<td>
		<form:input path="m_mydevice3"/>
	</td>
</tr>

</table>
	<input type="submit" value="회원등록">
</form:form>