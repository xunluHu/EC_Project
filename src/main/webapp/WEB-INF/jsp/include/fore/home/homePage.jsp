<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/5/9
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<div class="categoryWithCarousel">
    <div style="position: relative">
        <div class="categoryMenu ">
            <c:if test="${!empty pCategory}">
                <c:forEach items="${pCategory}" var="pc">
                    <div class="eachCategory" cid="${pc.id}">
                        <span class="glyphicon glyphicon-link"></span>
                        <a href="Category?id=${pc.id}">${pc.name}</a>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <div style="position: relative;left: 0;top: 0;">
        <c:if test="${!empty pCategory}">
            <c:forEach items="${pCategory}" var="pc">
                <div class="productsAsideCategorys" cid="${pc.id}">
                    <div class="row">
                        <c:forEach items="${pc.nextCategorys}" var="nc">
                            <a href="Category?id=${nc.id}">${nc.name}</a>
                        </c:forEach>
                        <div class="seperator"></div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>

    <div class="headBar">
        <div class="head ">
            <span class="glyphicon glyphicon-th-list" style="margin-left:10px"></span>
            <span style="margin-left:10px">商品分类</span>
        </div>
        <div class="rightMenu">
            <span><a href="https://www.liaoxuefeng.com/">好好学习</a></span>
            <span><a href="https://www.battlenet.com.cn/zh/">随便玩玩</a></span>
            <span><a href="http://www.chinawalking.net.cn/">顺便健身</a></span>
        </div>
    </div>
    <div class="carousel">
        <figure class="carouselImage">
            <img src="/images/homeBody/ai.jpg" alt="">
            <img src="/images/homeBody/book.jpg" alt="">
            <img src="/images/homeBody/game.jpg" alt="">
        </figure>
        <nav class="nav-circlepop">
            <a class="prev prevBtn">
                <span class="icon-wrap prev"></span>
            </a>
            <a class="next nextBtn">
                <span class="icon-wrap next"></span>
            </a>
        </nav>
    </div>
</div>
