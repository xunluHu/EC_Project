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
            <div class="eachCategory" cid="1">
                <span class="glyphicon glyphicon-link"></span>
                <a href="#nowhere">我的中国梦</a>
            </div>
            <div class="eachCategory" cid="2">
                <span class="glyphicon glyphicon-link"></span>
                <a href="#nowhere">IT精英必读</a>
            </div>
            <div class="eachCategory" cid="3">
                <span class="glyphicon glyphicon-link"></span>
                <a href="#nowhere">琴棋书画</a>
            </div>
            <div class="eachCategory" cid="4">
                <span class="glyphicon glyphicon-link"></span>
                <a href="#nowhere">金融分析</a>
            </div>
            <div class="eachCategory" cid="5">
                <span class="glyphicon glyphicon-link"></span>
                <a href="Category?id=5">外语学习</a>
            </div>
            <div class="eachCategory" cid="6">
                <span class="glyphicon glyphicon-link"></span>
                <a href="#nowhere">爱的供养</a>
            </div>
        </div>
    </div>
    <div style="position: relative;left: 0;top: 0;">
        <div class="productsAsideCategorys" cid="1">
            <div class="row">
                <a href="#nowhere">国富论</a>
                <a href="#nowhere">道德情操论</a>
                <a href="#nowhere">战争与和平</a>
                <a href="#nowhere">作为意志和表象的世界</a>
                <div class="seperator"></div>
            </div>
            <div class="row">
                <a href="#nowhere">剑桥中国史</a>
                <a href="#nowhere">万历十五年</a>
                <a href="#nowhere">中国历代政治得失</a>
                <div class="seperator"></div>
            </div>
        </div>
        <div class="productsAsideCategorys" cid="2">
            <div class="row">
                <a href="#nowhere">网络协议TCP</a>
                <a href="#nowhere">服务器编程之Socket</a>
                <a href="#nowhere">linux操作系统解析</a>
                <a href="#nowhere">C++与Java，一朝天子一朝臣</a>
                <div class="seperator"></div>
            </div>
            <div class="row">
                <a href="#nowhere">Opengl与OpengCV中的图像学原理</a>
                <a href="#nowhere">nodejs/python的崛起</a>
                <a href="#nowhere">Go的矛与盾</a>
                <a href="#nowhere">人工智能</a>
                <div class="seperator"></div>
            </div>
        </div>
        <div class="productsAsideCategorys" cid="3">
            <div class="row">
                <a href="#nowhere">琴</a>
                <a href="#nowhere">棋</a>
                <a href="#nowhere">书</a>
                <a href="#nowhere">画</a>
                <div class="seperator"></div>
            </div>
        </div>
        <div class="productsAsideCategorys" cid="4">
            <div class="row">
                <a href="#nowhere">金融与经济</a>
                <a href="#nowhere">数据分析的数学知识</a>
                <a href="#nowhere">巧用Excel</a>
                <a href="#nowhere">数据分析语言</a>
                <a href="#nowhere">什么是"大数据"</a>
                <div class="seperator"></div>
            </div>
        </div>
        <div class="productsAsideCategorys" cid="5">
            <div class="row">
                <a href="#nowhere">英语</a>
                <a href="#nowhere">日语</a>
                <a href="#nowhere">德语</a>
                <a href="#nowhere">小语种</a>
                <div class="seperator"></div>
            </div>
        </div>
        <div class="productsAsideCategorys" cid="6">
            <div class="row">
                <a href="#nowhere">纺织材料学</a>
                <a href="#nowhere">西方服装史</a>
                <a href="#nowhere">服装面辅料</a>
                <a href="#nowhere">流水线生产</a>
                <a href="#nowhere">过去，现在与未来</a>
                <div class="seperator"></div>
            </div>
        </div>
    </div>

    <div class="headBar">
        <div class="head ">
            <span class="glyphicon glyphicon-th-list" style="margin-left:10px"></span>
            <span style="margin-left:10px">商品分类</span>
        </div>
        <div class="rightMenu">
            <span><a href="#nowhere">好好学习</a></span>
            <span><a href="#nowhere">随便玩玩</a></span>
            <span><a href="#nowhere">顺便健身</a></span>
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
