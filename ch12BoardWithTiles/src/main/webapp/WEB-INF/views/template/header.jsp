<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="user-bar">
	<div class="sub-bar">
		<c:if test="${empty user_id}">
		<ul>
			<li><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
			<li><a href="${pageContext.request.contextPath}/member/join.do">회원가입</a></li>
		</ul>
		</c:if>
		<c:if test="${!empty user_id}">
		<ul>
			<li>${user_id}</li>
			<li><a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
		</ul>
		</c:if>
	</div>
</div>
<div id="menu-bar">
	<div class="sub-bar">
		<div style="float:left;height:100%;">
			<img src="${pageContext.servletContext.contextPath}/resources/images/mango.PNG" height="100%" onclick="location.href='${pageContext.request.contextPath}/main/main.do'" style="cursor:pointer">
		</div>
		<div style="float:right;min-width:800px;height:100%;display:table;">
			<nav id="topMenu">
				<ul> 
					<li class="topMenuLi"> 
						<a class="menuLink" href="${pageContext.request.contextPath}/plan/callingplan.do">상품서비스</a> 
						<ul class="submenu">
							<li><a href="#" class="submenuLink">휴대폰 요금제</a></li>
							<li><a href="#" class="submenuLink">부가서비스</a></li>
							<li><a href="#" class="submenuLink">맞춤상품</a></li>
						</ul>
					</li>
					<li class="topMenuLi">
						<a class="menuLink" href="${pageContext.request.contextPath}/device/device.do">다이렉트샵</a>
						<ul class="submenu">
							<li><a href="${pageContext.request.contextPath}/device/phone.do" class="submenuLink">휴대폰</a></li>
							<li><a href="${pageContext.request.contextPath}/device/tablet.do" class="submenuLink">태블릿</a></li>
							<li><a href="${pageContext.request.contextPath}/device/smartwatch.do" class="submenuLink">스마트워치</a></li>
							<li><a href="${pageContext.request.contextPath}/device/kids.do" class="submenuLink">키즈폰</a></li>
							<li><a href="${pageContext.request.contextPath}/device/acc.do" class="submenuLink">악세사리</a></li>
						</ul>
					</li>
					<li class="topMenuLi">
						<a class="menuLink" href="#">멤버십</a>
						<ul class="submenu">
							<li><a href="${pageContext.request.contextPath}/membership/join.do">멤버십가입</a></li>
							<li><a href="#" class="submenuLink">멤버십혜택</a></li>
							<li><a href="#" class="submenuLink">VIP</a></li>
							<li><a href="#" class="submenuLink">제휴사</a></li>
						</ul>
					</li>
					<li class="topMenuLi">
						<a class="menuLink" href="${pageContext.request.contextPath}/event/eventList.do">이벤트</a>
						<ul class="submenu">
							<li><a href="#" class="submenuLink longLink">진행중인 이벤트</a></li>
							<li><a href="#" class="submenuLink">지난 이벤트</a></li>
							<li><a href="#" class="submenuLink">당첨확인</a></li>
						</ul>
					</li>
					<li class="topMenuLi">
						<a class="menuLink" href="#">고객센터</a>
						<ul class="submenu">
							<li><a href="#" class="submenuLink">자주묻는 질문</a></li>
							<li><a href="#" class="submenuLink">1:1상담</a></li>
							<li><a href="#" class="submenuLink longLink">매장 및 AS센터</a></li>
						</ul>
					</li>
					<li class="topMenuLi">
						<a class="menuLink" href="#">myMango</a>
						<ul class="submenu">
							<li><a href="#" class="submenuLink longLink">가입상품 조회/변경/해지</a></li>
							<li><a href="#" class="submenuLink">주문내역</a></li>
							<li><a href="#" class="submenuLink">문의내역</a></li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</div>