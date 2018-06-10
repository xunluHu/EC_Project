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
<script>
    function getIt() {
        var orderArray = []
        var table = document.getElementById('cartTable');
        var tr = table.children[1].rows; //行
        for(var i = 0; i < tr.length; ++i) {
            var number = (tr[i].getElementsByTagName('input')[1].value);
            var pid = (tr[i].getElementsByTagName('input')[2].value);
            orderArray.push({pid: pid, number: number});
        }
        $.ajax({
            url: "/getIt",
            type: "Post",
            data: JSON.stringify(orderArray),
            content: "application/json",
            success: function (result) {
                if (result == "success") {
                    alert("获取成功");
                    location.reload();
                }
            },
            error: function () {
                alert("获取失败");
            }
        });
    }
</script>
<div class="cartbox">
    <table id="cartTable">
        <thead>
        <tr>
            <th><label><input class="check-all check" type="checkbox"/>&nbsp;全选</label></th>
            <th>商品</th>
            <th>单价(元)</th>
            <th>数量</th>
            <th>小计(元)</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:if test="${!empty os}">
        <tbody>
            <c:forEach items="${os}" var="o" varStatus="stc">
                <tr>
                    <td class="checked"><input class="check-one check" type="checkbox"/></td>
                    <td class="goods"><img src="/images/productsImage/${o.product.id}.jpg" alt=""/><span>${o.product.name}</span></td>
                    <td class="cartProductPrice" style="width: 130px">${o.product.originalPrice}</td>
                    <td class="count" >
                        <div class="reduce">-</div>
                        <input class="count-input" type="text" value=${o.number} />
                        <div class="add">+</div></td>
                    <td class="subtotal" >${o.subTotal}</td>
                    <td class="operation"><span class="delete">删除</span></td>
                    <td class="pid" hidden="hidden"><input type="text" value=${o.product.id}></input></td>
                </tr>
            </c:forEach>
        </tbody>
        </c:if>
    </table>
    <div class="foot" id="foot">
        <label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;全选</label>
        <a class="fl delete" id="deleteAll" href="javascript:;">删除</a>
        <button class="fr getIt" onclick="getIt()">全部获取</button>
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

