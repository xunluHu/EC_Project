<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/5/9
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<script src="js/fore/cart.js"></script>
<div class="cartbox">
    <table id="cartTable">
        <thead>
        <tr>
            <th><label><input class="check-all check" type="checkbox"/>&nbsp;全选</label></th>
            <th>商品</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="checked"><input class="check-one check" type="checkbox"/></td>
            <td class="goods"><img src="/images/productImage/ship.jpg" alt=""/><span>某江英语</span></td>
            <td class="price">5999.88</td>
            <td class="count"><span class="reduce"></span><input class="count-input" type="text" value="1"/><span
                    class="add">+</span></td>
            <td class="subtotal">5999.88</td>
            <td class="operation"><span class="delete">删除</span></td>
        </tr>
        </tbody>
    </table>

    <div class="foot" id="foot">
        <label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;全选</label>
        <a class="fl delete" id="deleteAll" href="javascript:;">删除</a>
        <div class="fr getIt">一键获取</div>
        <div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
        <div class="fr selected" id="selected">已选商品<span id="selectedTotal">0</span>件
            <!-- <span class="arrow up">︽</span><span class="arrow down">︾</span> -->
        </div>
        <div class="selected-view">
            <div id="selectedViewList" class="clearfix">
                <div><img src="/images/productImage/ship.jpg"><span>取消选择</span></div>
            </div>
        </div>
    </div>
</div>

