<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/5/9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<nav class="top ">
    <a href="/">
        <span style="color: #4cae4c; margin: 0px;"class="glyphicon glyphicon-tree-deciduous"></span>
        驯鹿首页
    </a>

    <c:if test="${!empty user}">
        <a href="/html/login.html">${user.name}</a>
        <a href="forelogout">退出</a>
    </c:if>

    <c:if test="${empty user}">
        <a href="/html/login.html">登录</a>
        <a href="/html/login.html">注册</a>
    </c:if>


    <span class="pull-right">
			<a href="forebought">我的订单</a>
			<a href="foreCart">
			<span style="color:#4cae4c; margin:0px" class=" glyphicon glyphicon-shopping-cart redColor"></span>
			购物车<strong>${cartTotalItemNumber}</strong>件</a>
		</span>
</nav>