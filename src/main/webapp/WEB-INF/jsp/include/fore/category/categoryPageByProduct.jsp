<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/5/9
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<c:if test="${empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="100"/>
</c:if>

<c:if test="${!empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>

<div class="categoryPageDiv">
    <div class="categoryProducts">
        <c:forEach items="${products}" var="p" varStatus="stc">
            <c:if test="${stc.count<=categorycount}">
                <div class="productUnit" price="${p.promotePrice}">
                    <div class="productUnitFrame">
                        <a href="foreProduct?pid=${p.id}">
                            <img class="productImage" src="/images/productsImage/${p.id}.jpg" onerror="this.onerror=null;this.src='/images/productImage/book.jpg'">
                        </a>
                        <span class="productPrice">¥<fmt:formatNumber type="number" value="${p.promotePrice}"
                                                                      minFractionDigits="2"/></span>
                        <a class="productLink" href="foreProduct?pid=${p.id}">
                                ${fn:substring(p.name, 0, 50)}
                        </a>
                        <a class="xunluLink" href="#">驯鹿特卖</a>
                    </div>
                </div>
            </c:if>
        </c:forEach>
        <div style="clear:both"></div>
    </div>
</div>
