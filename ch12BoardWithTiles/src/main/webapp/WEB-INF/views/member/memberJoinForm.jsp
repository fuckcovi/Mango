<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 | Mango</title>
<style>
* { margin: 0 auto; }
body {
	margin: 0 auto;
	width: 100%;
	min-height: 1000px;
	height: 1000px;
	text-align: center;
	background: #EAEAEA;
	font-family: "나눔고딕";
}
table {
	font-size: 14px;
}
table th {
	width: 100px;
}
.input-box {
	padding: 5px;
	width: 205px;
	height: 25px;
	border: 1px solid #BDBDBD;
}
.phone-box {
	width: 60px;
	height: 25px;
	border: 1px solid #BDBDBD;
}
.error-color {
	font-size: 12px;
	color: red;
}
</style>
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
						$("#confirmId").css("color","blue").text("사용가능");
						checkTnameDuplicated=1;
					}else if(data.result=="idDuplicated"){
						$("#confirmId").css("color","red").text("사용중");
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
		});
		
		$("#join_form").submit(function() {
			if(checkTnameDuplicated == 0) {
				alert("아이디를 확인해 주세요.");
				return false;
			}
		});
	});
</script>
</head>
<body>
	<div style="width:650px;height:100%;background:#FFF">
		<div><img src="${pageContext.request.contextPath}/resources/images/mango.PNG" onclick="location.href='${pageContext.request.contextPath}/main/main.do'" style="cursor:pointer"></div>
		<hr size="1" color="#EAEAEA">
		<div style="padding:10px;text-align:left;font-size:12px"><span style="color:#777">약관 동의 > </span><strong>정보 입력</strong><span style="color:#777"> > 가입 완료</span></div>
		<div style="line-height:300%">
			<h2 style="font-weight:bold;color:#333">가입 정보 입력</h2>
			<span style="color:#777">로그인 및 가입 정보를 입력해 주세요.</span>
			<br>
			<form:form commandName="memberCommand" id="join_form" style="padding-top:30px;width:90%;height:700px;border:1px solid #BDBDBD">
				<table>
					<tr>
						<th>
							<form:label path="m_id"><span style="color:red">*</span>아이디</form:label>
						</th>
						<td>
							<input type="text" id="m_id" name="m_id" class="input-box" placeholder="아이디 (영문, 숫자 3~20자)" style="ime-mode:disabled">
						</td>
						<td width="70">
							<span id="confirmId" style="font-size:12px"></span>
							<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" width="16" height="16" style="display:none">
							<form:errors path="m_id" cssClass="error-color"/>
						</td>
					</tr>
					<tr>
						<th>
							<form:label path="m_pw"><span style="color:red">*</span>비밀번호</form:label>
						</th>
						<td>
							<input type="password" id="m_pw" name="m_pw" class="input-box" placeholder="비밀번호 (영문, 숫자 6~20자)">
						</td>
						<td><form:errors path="m_pw" cssClass="error-color"/></td>
					</tr>
					<tr>
						<th>
							<form:label path="m_name"><span style="color:red">*</span>이름</form:label>
						</th>
						<td>
							<input type="text" name="m_name" class="input-box" placeholder="이름">
						</td>
						<td><form:errors path="m_name" cssClass="error-color"/></td>
					</tr>
					<tr>
						<th>
							<form:label path="m_phone1"><span style="color:red">*</span>전화번호</form:label>
						</th>
						<td>
							<table>
							<tr>
								<td>
									<form:select path="m_phone1" cssClass="phone-box">
										<form:option value="010"/>
										<form:option value="011"/>
										<form:option value="017"/>
										<form:option value="018"/>
										<form:option value="019"/>
									</form:select>
								</td>
								<td>	
									<form:label path="m_phone2">-</form:label>
								</td>
									<td>
										<input type="text" id="m_phone2" name="m_phone2" class="phone-box" maxlength="4" onkeyup="if(this.value.length == 4) this.form.m_phone3.focus();" onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" style="ime-mode:disabled">
									</td>
								<td>
									<form:label path="m_phone3">-</form:label>
								</td>
								<td>
									<input type="text" id="m_phone3" name="m_phone3" class="phone-box" maxlength="4" onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" style="ime-mode:disabled">
								</td>
							</tr>
							</table>
						</td>
						<td>
							<form:errors path="m_phone2" cssClass="error-color"/>
							<form:errors path="m_phone3" cssClass="error-color"/>
						</td>
					</tr>
					<tr>
						<th>	
							<form:label path="m_birth"><span style="color:red">*</span>생년월일</form:label>
						</th>
						<td>
							<input type="date" id="m_birth" name="m_birth" class="input-box">
						</td>
						<td><form:errors path="m_birth" cssClass="error-color"/></td>
					</tr>
					<tr>
						<th>	
							<form:label path="m_address1"><span style="color:red">*</span>주소</form:label>
						</th>
						<td>
							<form:input path="m_address1" cssClass="input-box"/>
						</td>
						<td><form:errors path="m_address1" cssClass="error-color"/></td>
					</tr>
					<tr>
						<th>	
							<form:label path="m_address2">상세주소</form:label>
						</th>
						<td>
							<form:input path="m_address2" cssClass="input-box"/>
						</td>
					</tr>
					<tr>
						<th>	
							<form:label path="m_mydevice1">마이기기1</form:label>
						</th>
						<td>
							<form:input path="m_mydevice1" cssClass="input-box"/>
						</td>
					</tr>
					<tr>
						<th>
							<form:label path="m_mydevice2">마이기기2</form:label>
						</th>
						<td>
							<form:input path="m_mydevice2" cssClass="input-box"/>
						</td>
					</tr>
					<tr>
						<th>
							<form:label path="m_mydevice3">마이기기3</form:label>
						</th>
						<td>
							<form:input path="m_mydevice3" cssClass="input-box"/>
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="회원가입" id="join-btn" style="width:200px;height:60px;background:#FFC000;border:0;font-size:16px;cursor:pointer">
			</form:form>
		</div>
	</div>
</body>
</html>