<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
	<c:forEach var="deviceList" items="${deviceList}">
		<input type="button" value="${deviceList.di_color }" onclick="location.href='${pageContext.request.contextPath}/device/modifyDeviceInfo.do?d_seq=${deviceList.d_seq}&di_seq=${deviceList.di_seq}'">
	</c:forEach>
</div>
<form:form commandName="deviceInfoCommand"  enctype="multipart/form-data">
	<input type="hidden" id="d_seq" name="d_seq" value="${d_seq}">
	<input type="hidden" id="di_seq" name="di_seq" value="${di_seq}">
	<table>
		<tr>
			<th><form:label path="di_color">색상</form:label></th>
			<td><form:input path="di_color" value="${deviceInfo.di_color}"/></td>
			<td><form:errors path="di_color" cssClass="error-color"/></td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile1">대표사진1</form:label></th>
			<td><input type="file" name="di_imagefile1" id="di_imagefile1" onchange="javascript:document.getElementById('file_route1').value=this.value">
		    <td>
			    <input type="text" readonly="readonly" title="File Route" id="file_route1">
			    <c:if test="${!empty deviceInfo.di_imagename1}">
			    	<c:if test="${fn:endsWith(deviceInfo.di_imagename1, '.jpg') || 
							fn:endsWith(deviceInfo.di_imagename1, '.png') || 
							fn:endsWith(deviceInfo.di_imagename1, '.gif') || 
							fn:endsWith(deviceInfo.di_imagename1, '.JPG') || 
							fn:endsWith(deviceInfo.di_imagename1, '.PNG') || 
							fn:endsWith(deviceInfo.di_imagename1, '.GIF')}">
						<img src="${pageContext.request.contextPath}/device/imageView1.do?d_seq=${deviceInfo.d_seq}&di_seq=${deviceInfo.di_seq}" style="width:200px;height:200px;">
					</c:if>
					<span>(${deviceInfo.di_imagename1}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if>
			</td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile2">대표사진2</form:label></th>
			<td><input type="file" name="di_imagefile2" id="di_imagefile2" onchange="javascript:document.getElementById('file_route2').value=this.value">
		    <td><input type="text" readonly="readonly" title="File Route" id="file_route2">
		    	<c:if test="${!empty deviceInfo.di_imagename2}">
					<c:if test="${fn:endsWith(deviceInfo.di_imagename2, '.jpg') || 
							fn:endsWith(deviceInfo.di_imagename2, '.png') || 
							fn:endsWith(deviceInfo.di_imagename2, '.gif') || 
							fn:endsWith(deviceInfo.di_imagename2, '.JPG') || 
							fn:endsWith(deviceInfo.di_imagename2, '.PNG') || 
							fn:endsWith(deviceInfo.di_imagename2, '.GIF')}">
						<img src="${pageContext.request.contextPath}/device/imageView2.do?d_seq=${deviceInfo.d_seq}&di_seq=${deviceInfo.di_seq}" style="width:200px;height:200px;">
					</c:if>
					<span>(${deviceInfo.di_imagename2}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if> 
			</td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile3">대표사진3</form:label></th>
			<td><input type="file" name="di_imagefile3" id="di_imagefile3" onchange="javascript:document.getElementById('file_route3').value=this.value">
		    <td><input type="text" readonly="readonly" title="File Route" id="file_route3">
		    	 <c:if test="${!empty deviceInfo.di_imagename3}">
					<c:if test="${fn:endsWith(deviceInfo.di_imagename3, '.jpg') || 
							fn:endsWith(deviceInfo.di_imagename3, '.png') || 
							fn:endsWith(deviceInfo.di_imagename3, '.gif') || 
							fn:endsWith(deviceInfo.di_imagename3, '.JPG') || 
							fn:endsWith(deviceInfo.di_imagename3, '.PNG') || 
							fn:endsWith(deviceInfo.di_imagename3, '.GIF')}">
						<img src="${pageContext.request.contextPath}/device/imageView3.do?d_seq=${deviceInfo.d_seq}&di_seq=${deviceInfo.di_seq}" style="width:200px;height:200px;">
					</c:if>
					<span>(${deviceInfo.di_imagename3}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if>
		    </td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile4">대표사진4</form:label></th>
			<td><input type="file" name="di_imagefile4" id="di_imagefile4" onchange="javascript:document.getElementById('file_route4').value=this.value">
		    <td><input type="text" readonly="readonly" title="File Route" id="file_route4">
		    	 <c:if test="${!empty deviceInfo.di_imagename4}">
					<c:if test="${fn:endsWith(deviceInfo.di_imagename4, '.jpg') || 
							fn:endsWith(deviceInfo.di_imagename4, '.png') || 
							fn:endsWith(deviceInfo.di_imagename4, '.gif') || 
							fn:endsWith(deviceInfo.di_imagename4, '.JPG') || 
							fn:endsWith(deviceInfo.di_imagename4, '.PNG') || 
							fn:endsWith(deviceInfo.di_imagename4, '.GIF')}">
						<img src="${pageContext.request.contextPath}/device/imageView4.do?d_seq=${deviceInfo.d_seq}&di_seq=${deviceInfo.di_seq}" style="width:200px;height:200px;">
					</c:if>
					<span>(${deviceInfo.di_imagename4}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
				</c:if>
		    </td>
		</tr>
		<tr>
			<th><form:label path="di_imagefile5">대표사진5</form:label></th>
			<td><input type="file" name="di_imagefile5" id="di_imagefile5" onchange="javascript:document.getElementById('file_route5').value=this.value">
		    <td><input type="text" readonly="readonly" title="File Route" id="file_route5">
		    	 <c:if test="${!empty deviceInfo.di_imagename5}">
					<c:if test="${fn:endsWith(deviceInfo.di_imagename5, '.jpg') || 
							fn:endsWith(deviceInfo.di_imagename5, '.png') || 
							fn:endsWith(deviceInfo.di_imagename5, '.gif') || 
							fn:endsWith(deviceInfo.di_imagename5, '.JPG') || 
							fn:endsWith(deviceInfo.di_imagename5, '.PNG') ||  
							fn:endsWith(deviceInfo.di_imagename5, '.GIF')}">
						<img src="${pageContext.request.contextPath}/device/imageView5.do?d_seq=${deviceInfo.d_seq}&di_seq=${deviceInfo.di_seq}" style="width:200px;height:200px;">
					</c:if>
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
	<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/device/device.do'">
</form:form>