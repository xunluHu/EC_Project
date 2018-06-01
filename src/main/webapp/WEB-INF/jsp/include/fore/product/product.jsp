<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/5/9
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<canvas id="starryCanvas" style="position: absolute; z-index: -1; "></canvas>
<div class="productContext">
    <div class="productTitle">${p.name}</div>
    <div class="productSubTitle">${p.subTitle}</div>
    <div class="separator">致我们的星辰大海---￥${p.originalPrice}</div>
    <img class="productDetailImage" src="/images/productImage/ship.jpg">
    <div class="buyDiv">
        <button class="buyButton">购物车统一获取</button>
        <div class="calculateArea">
            <span class="reduce">-</span>
            <input class="count-input" type="text" value="1" maxLength="2" disabled="true"/>
            <span class="add">+</span>
        </div>
        <button class="cartButton">
            <span class="glyphicon glyphicon-shopping-cart"></span>
            加入购物车
        </button>
    </div>

</div>

<script>
    $("div.calculateArea .add").click(function () {
        console.log("$(\"div.calculateArea .count-input\").val() ", parseInt($("div.calculateArea .count-input").val()) + 1)
        if ($("div.calculateArea .count-input").val() < 99) {
            $("div.calculateArea .count-input").val((parseInt($("div.calculateArea .count-input").val()) + 1).toString());
        }
    })
    $("div.calculateArea .reduce").click(function () {
        console.log("$(\"div.calculateArea .count-input\").val() ", parseInt($("div.calculateArea .count-input").val()) + 1)
        if ($("div.calculateArea .count-input").val() > 1) {
            $("div.calculateArea .count-input").val((parseInt($("div.calculateArea .count-input").val()) - 1).toString());
        }
    })
    $(document).ready($("button.cartButton").click(function () {
        $.post("/user_checkLogin", function (result) {
            if (result == "success") {
                $.post(
                    "/addCart",
                    {pid: ${p.id},number: $("div.calculateArea .count-input").val()},
                    function (result) {
                        if (result == "success") {
                            alert("添加进购物车");
                        } else {
                            alert("添加失败")
                        }
                    }
                )
            } else {
                alert("请登录");
            }
        })
    }));
    //特效
    "use strict";
    var canvas = document.getElementById('starryCanvas'),
        ctx = canvas.getContext('2d'),
        w = canvas.width = window.innerWidth,
        //100是top和footer的高度之和
        h = canvas.height = window.innerHeight - 100,
        hue = 217,
        stars = [],
        count = 0,
        maxStars = 1300;//星星数量
    $(window).resize(function () {
        w = canvas.width = window.innerWidth, h = canvas.height = window.innerHeight - 100;
    });

    var canvas2 = document.createElement('canvas'),
        ctx2 = canvas2.getContext('2d');
    canvas2.width = 100;
    canvas2.height = 100;
    var half = canvas2.width / 2,
        gradient2 = ctx2.createRadialGradient(half, half, 0, half, half, half);
    gradient2.addColorStop(0.025, '#CCC');
    gradient2.addColorStop(0.1, 'hsl(' + hue + ', 61%, 33%)');
    gradient2.addColorStop(0.25, 'hsl(' + hue + ', 64%, 6%)');
    gradient2.addColorStop(1, 'transparent');

    ctx2.fillStyle = gradient2;
    ctx2.beginPath();
    ctx2.arc(half, half, half, 0, Math.PI * 2);
    ctx2.fill();

    // End cache

    function random(min, max) {
        if (arguments.length < 2) {
            max = min;
            min = 0;
        }

        if (min > max) {
            var hold = max;
            max = min;
            min = hold;
        }

        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    function maxOrbit(x, y) {
        var max = Math.max(x, y),
            diameter = Math.round(Math.sqrt(max * max + max * max));
        return diameter / 2;
        //星星移动范围，值越大范围越小，
    }

    var Star = function () {

        this.orbitRadius = random(maxOrbit(w, h));
        this.radius = random(60, this.orbitRadius) / 8;
        //星星大小
        this.orbitX = w / 2;
        this.orbitY = h / 2;
        this.timePassed = random(0, maxStars);
        this.speed = random(this.orbitRadius) / 50000;
        //星星移动速度
        this.alpha = random(2, 10) / 10;

        count++;
        stars[count] = this;
    }

    Star.prototype.draw = function () {
        var x = Math.sin(this.timePassed) * this.orbitRadius + this.orbitX,
            y = Math.cos(this.timePassed) * this.orbitRadius + this.orbitY,
            twinkle = random(10);

        if (twinkle === 1 && this.alpha > 0) {
            this.alpha -= 0.05;
        } else if (twinkle === 2 && this.alpha < 1) {
            this.alpha += 0.05;
        }

        ctx.globalAlpha = this.alpha;
        ctx.drawImage(canvas2, x - this.radius / 2, y - this.radius / 2, this.radius, this.radius);
        this.timePassed += this.speed;
    }

    for (var i = 0; i < maxStars; i++) {
        new Star();
    }

    function animation() {
        ctx.globalCompositeOperation = 'source-over';
        ctx.globalAlpha = 0.5; //尾巴
        ctx.fillStyle = 'hsla(' + hue + ', 64%, 6%, 2)';
        ctx.fillRect(0, 0, w, h)

        ctx.globalCompositeOperation = 'lighter';
        for (var i = 1, l = stars.length; i < l; i++) {
            stars[i].draw();
        }
        ;

        window.requestAnimationFrame(animation);
    }

    animation();
</script>