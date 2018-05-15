<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/5/9
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<div class="recordArea">
    <c:if test="${empty os}">
        <img class="noRecord" src="images/blackMan.jpg" alt="">
    </c:if>
    <c:if test="${!empty os}">
    <ul class="cbp_tmtimeline">
        <c:forEach items="${os}" var="o" >
            <li>
                <time class="cbp_tmtime"><span>${o.createDate}</span><span></span></time>
                <div class="cbp_tmicon "><span class="glyphicon glyphicon-tags redColor"></span></div>
                <div class="cbp_tmlabel">
                    <h2>获取内容(｀・ω・´)</h2>
                    <p>
                        <c:forEach items="${o.orderItems}" var="p" >
                            "${p.product.name}"
                        </c:forEach>
                    </p>
                </div>
            </li>
        </c:forEach>
    </ul>
    </c:if>
</div>