<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
	$(document).ready(function(){
		$(".categorysel").click(function(){
			if($(this).val()=="부가서비스"){
				$(".dataselect").removeAttr("id");
				$(".dataselect").removeAttr("name");
				$(".datainput").removeAttr("disabled");
				$(".dataselect").attr("disabled","disabled");
				$(".datainput").val("부가");
				$(".callselect").removeAttr("id");
				$(".callselect").removeAttr("name");
				$(".callinput").removeAttr("disabled");
				$(".callselect").attr("disabled","disabled");
				$(".callinput").val("부가");
				$(".msselect").removeAttr("id");
				$(".msselect").removeAttr("name");
				$(".msinput").removeAttr("disabled");
				$(".msselect").attr("disabled","disabled");
				$(".msinput").val("부가"); 
			}else{
				$(".dataselect").removeAttr("disabled");
				$(".callselect").removeAttr("disabled");
				$(".msselect").removeAttr("disabled");
				$(".datainput").attr("disabled","disabled");
				$(".dataselect").attr("id","cp_data");
				$(".dataselect").attr("name","cp_data");
				$(".callinput").attr("disabled","disabled");
				$(".callselect").attr("id","cp_call");
				$(".callselect").attr("name","cp_call");
				$(".msinput").attr("disabled","disabled");
				$(".msselect").attr("id","cp_message");
				$(".msselect").attr("name","cp_message");
				$(".datainput").val("");
				$(".callinput").val("");
				$(".msinput").val("");
			}
		});
		$(".dataselect").click(function(){
			if($(this).val()==""){
				$(".dataselect").removeAttr("id");
				$(".dataselect").removeAttr("name");
				$(".datainput").removeAttr("disabled");
			}else{
				$(".datainput").attr("disabled","disabled");
				$(".dataselect").attr("id","cp_data");
				$(".dataselect").attr("name","cp_data");
				$(".datainput").val("");
			}
		});
		$(".callselect").click(function(){
			if($(this).val()==""){
				$(".callselect").removeAttr("id");
				$(".callselect").removeAttr("name");
				$(".callinput").removeAttr("disabled");
			}else{
				$(".callinput").attr("disabled","disabled");
				$(".callselect").attr("id","cp_call");
				$(".callselect").attr("name","cp_call");
				$(".callinput").val("");
			}
		});
		$(".msselect").click(function(){
			if($(this).val()==""){
				$(".msselect").removeAttr("id");
				$(".msselect").removeAttr("name");
				$(".msinput").removeAttr("disabled");
			}else{
				$(".msinput").attr("disabled","disabled");
				$(".msselect").attr("id","cp_message");
				$(".msselect").attr("name","cp_message");
				$(".msinput").val("");
			}
		});
	})
</script>
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
		<td>
			<form:select path="cp_category" class="categorysel">
				<form:option value="모바일">모바일</form:option>
				<form:option value="부가서비스">부가서비스</form:option>
			</form:select>
		</td>
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
		<td>
			<form:select path="cp_data" class="dataselect">
				<form:option value="1">1 GB</form:option>
				<form:option value="2">2 GB</form:option>
				<form:option value="2">3 GB</form:option>
				<form:option value="5">5 GB</form:option>
				<form:option value="10">10 GB</form:option>
				<form:option value="20">20 GB</form:option>
				<form:option value="30">30 GB</form:option>
				<form:option value="무제한">무제한</form:option>
				<form:option value="">직접입력</form:option>
			</form:select>
			<input type="text" id="cp_data" class="datainput" name="cp_data" disabled="disabled"/>
		</td>
		<td><form:errors path="cp_data" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_call">음성</form:label></th>
		<td>
			<form:select path="cp_call" class="callselect">
				<form:option value="30">30 분</form:option>
				<form:option value="60">60 분</form:option>
				<form:option value="100">100 분</form:option>
				<form:option value="150">150 분</form:option>
				<form:option value="300">300 분</form:option>
				<form:option value="무제한">무제한</form:option>
				<form:option value="">직접입력</form:option>
			</form:select>
			<input type="text" id="cp_call" class="callinput" name="cp_call" disabled="disabled"/>
		</td>
		<td><form:errors path="cp_call" cssClass="error-color"/></td>
	</tr>
	<tr>
		<th><form:label path="cp_message">문자</form:label></th>
		<td>
			<form:select path="cp_message" class="msselect">
				<form:option value="30">30 건</form:option>
				<form:option value="50">50 건</form:option>
				<form:option value="100">100 건</form:option>
				<form:option value="150">150 건</form:option>
				<form:option value="300">300 건</form:option>
				<form:option value="무제한">무제한</form:option>
				<form:option value="">직접입력</form:option>
			</form:select>
			<input type="text" id="cp_message" class="msinput" name="cp_message" disabled="disabled"/>
		</td>
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