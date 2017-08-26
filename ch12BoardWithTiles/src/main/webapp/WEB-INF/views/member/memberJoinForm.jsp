<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var checkDuplicated = 0;
		$("#m_id").blur(function(){
			if($("#m_id").val()==""){
				$("#loading").show();
				$("#confirmId").text("");
				return;
			}
			$("#confirmId").text("");
			$("#loading").show();
			
			$.ajax({
				url:"confirmId.do",
				type:"post",
				data:{m_id:$("#m_id").val()},
				dataType:"json",
				cache:false,
				timeout:30000,
				success:function(data){
					$("#loading").hide();
					if(data.result=="idNotFound"){
						$("#confirmId").css("color","black").text("사용가능한 아이디");
						checkTnameDuplicated=1;
					}else if(data.result=="idDuplicated"){
						$("#confirmId").css("color","red").text("이미 등록된 아이디");
						checkTnameDuplicated=0;
					}else{
						alert("아이디 중복체크 오류 발생");
						checkTnameDuplicated=0;
					}
				},
				error:function(){
					$("#loading").hide();
					alert("아이디 중복체크 실패 - 네트워크 오류 발생");
				}
			});
		
		})
	})
</script>
<form:form commandName="memberCommand" >
<table>
<tr>
	<th>
		<form:label path="m_id">아이디</form:label>
	</th>
	<td>
		<form:input path="m_id"/>
		<span id="confirmId"></span>
		<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" width="16" height="16" style="display:none">
	</td>
	<td><form:errors path="m_id" cssClass="error-color"/></td>
</tr>
<tr>
	<th>
		<form:label path="m_pw">비밀번호</form:label>
	</th>
	<td>
		<form:password path="m_pw"/>
	</td>
	<td><form:errors path="m_pw" cssClass="error-color"/></td>
</tr>
<tr>
	<th>
		<form:label path="m_name">이름</form:label>
	</th>
	<td>
		<form:input path="m_name"/>
	</td>
	<td><form:errors path="m_name" cssClass="error-color"/></td>
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
	<td><form:errors path="m_phone2" cssClass="error-color"/>
		<form:errors path="m_phone3" cssClass="error-color"/></td>
</tr>
<tr>
	<th>	
		<form:label path="m_birth">생년월일</form:label>
	</th>
	<td>
		<input type="date" id="m_birth" name="m_birth">
	</td>
	<td><form:errors path="m_birth" cssClass="error-color"/></td>
</tr>
<tr>
	<th>	
		<form:label path="m_address1">주소</form:label>
	</th>
	<td>
		<form:input path="m_address1"/>
	</td>
	<td><form:errors path="m_address1" cssClass="error-color"/></td>
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