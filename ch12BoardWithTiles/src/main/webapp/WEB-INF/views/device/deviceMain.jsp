<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style type="text/css">
	.back{min-width:980px;height:1150px;}
	.deviceList{border: 1px solid; margin:10px 10px; min-width:300px;width:30%;height:350px;display:inline-block;float:left;}
	.deviceList ul{list-style: none;}
</style>
<h3><B>다이렉트샵</B></h3>
<div class="back">
<c:if test="${user_status == 9 }">
<div>
	<input type="button" value="기기등록" onclick="location.href='${pageContext.request.contextPath}/device/registerDevice.do'">
</div>
</c:if>
<c:set var="seq" value="0"/>
<c:forEach var="device" items="${deviceList}">
<c:set var="d_seq" value="[${device.d_seq}]"/>
<c:if test="${!fn:contains(seq,d_seq)}">
	<c:set var="seq" value="${seq},[${device.d_seq}]"/>
	<div class="deviceList">
	<ul>
		<li>
		<c:if test="${fn:endsWith(device.di_imagename1, '.jpg') || 
					fn:endsWith(device.di_imagename1, '.png') || 
					fn:endsWith(device.di_imagename1, '.gif') || 
					fn:endsWith(device.di_imagename1, '.JPG') || 
					fn:endsWith(device.di_imagename1, '.PNG') || 
					fn:endsWith(device.di_imagename1, '.GIF')}">
			<img src="${pageContext.request.contextPath}/device/imageView1.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:200px;height:200px;">
		</c:if>
		<c:if test="${empty device.di_imagename1}">
			<img src="${pageContext.request.contextPath}/resources/images/basicdevice.PNG" style="width:200px;height:200px;">
		</c:if>
		</li>
		<li><b>${device.d_name}</b></li>
		<li>${device.d_modelnum}</li>
		<li><c:if test="${device.d_regdate == null}">출시예정</c:if>
			<c:if test="${device.d_regdate != null}">${device.d_regdate}</c:if></li>
		<li>${device.d_type}</li>
		<li>${device.d_explain}</li>
		<li>
		
		<c:if test="${user_status == 9 }">
			<c:if test="${device.di_seq == 0 }">
				<input type="button" value="상세등록" onclick="location.href='${pageContext.request.contextPath}/device/registerDeviceInfo.do?d_seq=${device.d_seq}'">
			</c:if> 
			<c:if test="${device.di_seq != 0}">
			<input type="button" value="상세추가등록" onclick="location.href='${pageContext.request.contextPath}/device/registerDeviceInfo.do?d_seq=${device.d_seq}'">
				<input type="button" value="상세수정" onclick="location.href='${pageContext.request.contextPath}/device/modifyDeviceInfo.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}'">
			</c:if>
		</c:if>
		<c:if test="${user_status != 9 }">
			<c:if test="${device.di_seq == 0 }">
				상세정보없음.
			</c:if> 
			<c:if test="${device.di_seq != 0}">
				<input type="button" value="자세히보기" onclick="location.href='${pageContext.request.contextPath}/device/deviceInfo.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}'">
			</c:if>
		</c:if>
		</li>
	</ul>	
	</div>

</c:if>
</c:forEach>
</div>