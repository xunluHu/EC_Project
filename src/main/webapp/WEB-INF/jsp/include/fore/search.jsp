<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/5/9
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<a href="${contextPath}">
    <img id="logo" src="" class="logo">
</a>

<form action="productSearch" method="post" >
    <div class="searchDiv">
        <input name="context" type="text" placeholder="anything you like~">
        <button  type="submit" class="searchButton">搜索</button>
    </div>
</form>

