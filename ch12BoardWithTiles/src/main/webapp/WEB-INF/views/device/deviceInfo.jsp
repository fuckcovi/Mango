<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

${device.d_seq}
${device.di_seq}
${device.d_name}
${device.di_color}
				<c:if test="${fn:endsWith(device.di_imagename, '.jpg') || 
							fn:endsWith(device.di_imagename, '.png') || 
							fn:endsWith(device.di_imagename, '.gif') || 
							fn:endsWith(device.di_imagename, '.JPG') || 
							fn:endsWith(device.di_imagename, '.PNG') || 
							fn:endsWith(device.di_imagename, '.GIF')}">
					<img src="${pageContext.request.contextPath}/device/imageView.do?d_seq=${device.d_seq}" style="width:200px;height:200px;">
				</c:if>