<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		$(".image1").mouseover(function(){
			$(".view").html("");
			$(".view").html('<img class="image1" src="${pageContext.request.contextPath}/device/imageView1.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:250px;height:375px;">');
		});
		$(".image2").mouseover(function(){
			$(".view").html("");
			$(".view").html('<img class="image2" src="${pageContext.request.contextPath}/device/imageView2.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:250px;height:375px;">');
		});
		$(".image3").mouseover(function(){
			$(".view").html("");
			$(".view").html('<img class="image3" src="${pageContext.request.contextPath}/device/imageView3.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:250px;height:375px;">');
		});
		$(".image4").mouseover(function(){
			$(".view").html("");
			$(".view").html('<img class="image4" src="${pageContext.request.contextPath}/device/imageView4.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:250px;height:375px;">');
		});
		$(".image5").mouseover(function(){
			$(".view").html("");
			$(".view").html('<img class="image5" src="${pageContext.request.contextPath}/device/imageView5.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:250px;height:375px;">');
		});
		
		/* $(".detail span").click(function(){
			$("#loading").show();
			$.ajax({
				url:"deviceColorSelect.do",
				type:"post",
				data:{d_seq:$(this).attr("d_seq"),di_seq:$(this).attr("di_seq")},
				dataType:"json",
				cache:false,
				timeout:30000,
				success:function(data){
					$("#loading").hide();
					if(data.result=="success"){
						$(".detail").html("");
						$(".detail").html(
								'색상 : <c:forEach var="deviceInfoList" items="${deviceInfoList}"><span d_seq="${deviceInfoList.d_seq }"di_seq="${deviceInfoList.di_seq}">${deviceInfoList.di_color}</span>		</c:forEach>'	
						);
					}else if(data.result=="NotFound"){
						alert("선택한 색상의 정보가 없습니다.");
					}else{
						alert("목록 호출 시 오류 발생");
					}
				},
				error:function(){
					$("#loading").hide();
					alert("호출 실패 - 네트워크 오류 발생");
				}
			});
		}); */
	});
</script>
<div class="deviceImage" style="width:300px;height:465px;float:left;">
	<div class="view" style="width:250px;heigh:380px;margin:0 auto;">
		<c:if test="${!empty device.di_imagename1}">
			<img class="image1" src="${pageContext.request.contextPath}/device/imageView1.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:250px;height:375px;">
		</c:if>
		<c:if test="${empty device.di_imagename1 }">
			사진없음
		</c:if>
	</div>
	<div style="width:300px;margin:0 auto;">
		<c:if test="${fn:endsWith(device.di_imagename1, '.jpg') || 
					fn:endsWith(device.di_imagename1, '.png') || 
					fn:endsWith(device.di_imagename1, '.gif') || 
					fn:endsWith(device.di_imagename1, '.JPG') || 
					fn:endsWith(device.di_imagename1, '.PNG') || 
					fn:endsWith(device.di_imagename1, '.GIF')}">
			<img class="image1" src="${pageContext.request.contextPath}/device/imageView1.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:50px;height:80px;">
		</c:if>
		<c:if test="${fn:endsWith(device.di_imagename2, '.jpg') || 
					fn:endsWith(device.di_imagename2, '.png') || 
					fn:endsWith(device.di_imagename2, '.gif') || 
					fn:endsWith(device.di_imagename2, '.JPG') || 
					fn:endsWith(device.di_imagename2, '.PNG') || 
					fn:endsWith(device.di_imagename2, '.GIF')}">
			<img class="image2" src="${pageContext.request.contextPath}/device/imageView2.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:50px;height:80px;">
		</c:if>
		<c:if test="${fn:endsWith(device.di_imagename3, '.jpg') || 
					fn:endsWith(device.di_imagename3, '.png') || 
					fn:endsWith(device.di_imagename3, '.gif') || 
					fn:endsWith(device.di_imagename3, '.JPG') || 
					fn:endsWith(device.di_imagename3, '.PNG') || 
					fn:endsWith(device.di_imagename3, '.GIF')}">
			<img class="image3" src="${pageContext.request.contextPath}/device/imageView3.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:50px;height:80px;">
		</c:if>
		<c:if test="${fn:endsWith(device.di_imagename4, '.jpg') || 
					fn:endsWith(device.di_imagename4, '.png') || 
					fn:endsWith(device.di_imagename4, '.gif') || 
					fn:endsWith(device.di_imagename4, '.JPG') || 
					fn:endsWith(device.di_imagename4, '.PNG') || 
					fn:endsWith(device.di_imagename4, '.GIF')}">
			<img class="image4" src="${pageContext.request.contextPath}/device/imageView4.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:50px;height:80px;">
		</c:if> 
		<c:if test="${fn:endsWith(device.di_imagename5, '.jpg') || 
					fn:endsWith(device.di_imagename5, '.png') || 
					fn:endsWith(device.di_imagename5, '.gif') || 
					fn:endsWith(device.di_imagename5, '.JPG') || 
					fn:endsWith(device.di_imagename5, '.PNG') || 
					fn:endsWith(device.di_imagename5, '.GIF')}">
			<img class="image5" src="${pageContext.request.contextPath}/device/imageView5.do?d_seq=${device.d_seq}&di_seq=${device.di_seq}" style="width:50px;height:80px;">
		</c:if>
</div>
</div>
<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" width="16" height="16" style="display:none">
<div class="detail" style="float:left;margin-left:100px;width:500px;">

	상품명 : ${device.d_name}<br>
	상품가격 : ${device.di_price }<br>
	색상 : <c:forEach var="deviceInfoList" items="${deviceInfoList}">
			<input type="button" d_seq="${deviceInfoList.d_seq }"di_seq="${deviceInfoList.di_seq}" onclick="location.href='${pageContext.request.contextPath}/device/deviceInfo.do?d_seq=${device.d_seq }&di_seq=${deviceInfoList.di_seq }'" value="${deviceInfoList.di_color}">
		</c:forEach>
</div>