<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

${device.d_seq}
${device.di_seq}
${device.d_name}
${device.di_color}
				<c:if test="${fn:endsWith(device.di_imagename1, '.jpg') || 
							fn:endsWith(device.di_imagename1, '.png') || 
							fn:endsWith(device.di_imagename1, '.gif') || 
							fn:endsWith(device.di_imagename1, '.JPG') || 
							fn:endsWith(device.di_imagename1, '.PNG') || 
							fn:endsWith(device.di_imagename1, '.GIF')}">
					<img src="${pageContext.request.contextPath}/device/imageView1.do?d_seq=${device.d_seq}" style="width:200px;height:200px;">
				</c:if>
				<c:if test="${fn:endsWith(device.di_imagename2, '.jpg') || 
							fn:endsWith(device.di_imagename2, '.png') || 
							fn:endsWith(device.di_imagename2, '.gif') || 
							fn:endsWith(device.di_imagename2, '.JPG') || 
							fn:endsWith(device.di_imagename2, '.PNG') || 
							fn:endsWith(device.di_imagename2, '.GIF')}">
					<img src="${pageContext.request.contextPath}/device/imageView2.do?d_seq=${device.d_seq}" style="width:200px;height:200px;">
				</c:if>
				<c:if test="${fn:endsWith(device.di_imagename3, '.jpg') || 
							fn:endsWith(device.di_imagename3, '.png') || 
							fn:endsWith(device.di_imagename3, '.gif') || 
							fn:endsWith(device.di_imagename3, '.JPG') || 
							fn:endsWith(device.di_imagename3, '.PNG') || 
							fn:endsWith(device.di_imagename3, '.GIF')}">
					<img src="${pageContext.request.contextPath}/device/imageView3.do?d_seq=${device.d_seq}" style="width:200px;height:200px;">
				</c:if>
				<c:if test="${fn:endsWith(device.di_imagename4, '.jpg') || 
							fn:endsWith(device.di_imagename4, '.png') || 
							fn:endsWith(device.di_imagename4, '.gif') || 
							fn:endsWith(device.di_imagename4, '.JPG') || 
							fn:endsWith(device.di_imagename4, '.PNG') || 
							fn:endsWith(device.di_imagename4, '.GIF')}">
					<img src="${pageContext.request.contextPath}/device/imageView4.do?d_seq=${device.d_seq}" style="width:200px;height:200px;">
				</c:if>
				<c:if test="${fn:endsWith(device.di_imagename5, '.jpg') || 
							fn:endsWith(device.di_imagename5, '.png') || 
							fn:endsWith(device.di_imagename5, '.gif') || 
							fn:endsWith(device.di_imagename5, '.JPG') || 
							fn:endsWith(device.di_imagename5, '.PNG') || 
							fn:endsWith(device.di_imagename5, '.GIF')}">
					<img src="${pageContext.request.contextPath}/device/imageView5.do?d_seq=${device.d_seq}" style="width:200px;height:200px;">
				</c:if>