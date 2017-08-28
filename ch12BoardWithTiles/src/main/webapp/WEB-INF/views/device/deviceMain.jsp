<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3><B>다이렉트샵</B></h3>
<c:if test="${user_status == 9 }">
<input type="button" value="기기등록" onclick="location.href='${pageContext.request.contextPath}/device/registerDevice.do'">
</c:if>
<c:forEach var="device" items="${deviceList}">
	<div style="border: 1px solid; margin:10px 10px;">
	<ul>
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
				<input type="button" value="상세수정" onclick="location.href='${pageContext.request.contextPath}/device/modifyDeviceInfo.do?d_seq=${device.d_seq}'">
			</c:if>
		</c:if>
		<c:if test="${user_status != 9 }">
			<c:if test="${device.di_seq == 0 }">
				상세정보없음.
			</c:if> 
			<c:if test="${device.di_seq != 0}">
				<input type="button" value="자세히보기" onclick="location.href='${pageContext.request.contextPath}/device/deviceInfo.do?d_seq=${device.d_seq}'">
			</c:if>
		</c:if>
		</li>
	</ul>	
	</div>
</c:forEach>