<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form commandName="deviceInfoCommand"  enctype="multipart/form-data">
	<input type="hidden" id="d_seq" name="d_seq" value="${d_seq}">
	<table>
		<tr>
			<th><form:label path="di_color">색상</form:label></th>
			<td><form:input path="di_color" value="${deviceInfo.di_color}"/></td>
			<td><form:errors path="di_color" cssClass="error-color"/></td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile1">대표사진</form:label></th>
			<td><input type="file" name="di_imagefile1" id="di_imagefile1" onchange="javascript:document.getElementById('file_route1').value=this.value">
		    <td>
			    <input type="text" readonly="readonly" title="File Route" id="file_route1">
			    <c:if test="${!empty deviceInfo.di_imagename1}">
					<span>(${deviceInfo.di_imagename1}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if>
			</td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile2">대표사진</form:label></th>
			<td><input type="file" name="di_imagefile2" id="di_imagefile2" onchange="javascript:document.getElementById('file_route2').value=this.value">
		    <td><input type="text" readonly="readonly" title="File Route" id="file_route2">
		    	<c:if test="${!empty deviceInfo.di_imagename2}">
					<span>(${deviceInfo.di_imagename2}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if>
			</td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile3">대표사진</form:label></th>
			<td><input type="file" name="di_imagefile3" id="di_imagefile3" onchange="javascript:document.getElementById('file_route3').value=this.value">
		    <td><input type="text" readonly="readonly" title="File Route" id="file_route3">
		    	 <c:if test="${!empty deviceInfo.di_imagename3}">
					<span>(${deviceInfo.di_imagename3}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if>
		    </td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile4">대표사진</form:label></th>
			<td><input type="file" name="di_imagefile4" id="di_imagefile4" onchange="javascript:document.getElementById('file_route4').value=this.value">
		    <td><input type="text" readonly="readonly" title="File Route" id="file_route4">
		    	 <c:if test="${!empty deviceInfo.di_imagename4}">
					<span>(${deviceInfo.di_imagename4}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if>
		    </td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile5">대표사진</form:label></th>
			<td><input type="file" name="di_imagefile5" id="di_imagefile5" onchange="javascript:document.getElementById('file_route5').value=this.value">
		    <td><input type="text" readonly="readonly" title="File Route" id="file_route5">
		    	 <c:if test="${!empty deviceInfo.di_imagename5}">
					<span>(${deviceInfo.di_imagename5}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if>
		    </td>
		</tr>
		<tr>
			<th><form:label path="di_quantity">수량</form:label></th>
			<td><form:input path="di_quantity" value="${deviceInfo.di_quantity}"/></td>
			<td>수량 미입력 시 0개로 등록됩니다.</td>
		</tr>
		<tr>
			<th><form:label path="di_price">판매가격</form:label></th>
			<td><form:input path="di_price" value="${deviceInfo.di_price}"/></td>
			<td>판매가 미입력 시 출고가미정으로 등록됩니다.</td>
		</tr>
	</table>
	<input type="submit" value="정보수정">
</form:form>