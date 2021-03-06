window.addEventListener('load', function () {
    var carousels = document.querySelectorAll('.carousel');

    for (var i = 0; i < carousels.length; i++) {
        carousel(carousels[i]);
    }
});

function carousel(root) {
    var figure = root.querySelector('figure'),
        nav = root.querySelector('nav'),
        images = figure.children,
        n = images.length,
        gap = root.dataset.gap || 0,
        bfc = 'bfc' in root.dataset,
        theta = 2 * Math.PI / n,
        currImage = 0;

    setupCarousel(n, parseFloat(getComputedStyle(images[0]).width));
    window.addEventListener('resize', function () {
        setupCarousel(n, parseFloat(getComputedStyle(images[0]).width));
    });

    setupNavigation();

    function setupCarousel(n, s) {
        var apothem = s / (2 * Math.tan(Math.PI / n));

        figure.style.transformOrigin = '50% 50% ' + -apothem + 'px';

        for (var i = 0; i < n; i++) {
            images[i].style.padding = gap + 'px';
        }
        for (i = 1; i < n; i++) {
            images[i].style.transformOrigin = '50% 50% ' + -apothem + 'px';
            images[i].style.transform = 'rotateY(' + i * theta + 'rad)';
        }
        if (bfc) for (i = 0; i < n; i++) {
            images[i].style.backfaceVisibility = 'hidden';
        }
        rotateCarousel(currImage);
    }

    function setupNavigation() {
        var time = null;
        var isStop = false;

        function timedCount() {
            if (isStop === false && $("div.productsAsideCategorys").css('display') == 'none') {
                currImage--;
                rotateCarousel(currImage);
            }
            //这里不套一层function()会内存溢出，如果通过“函数()的方法”会去找windows下的全局函数是找不到的
            time = setTimeout(function () {
                timedCount()
            }, 3000)
        }

        timedCount();
        $(".prevBtn").on("click", function () {
            currImage++;
            rotateCarousel(currImage);
        })
        $(".nextBtn").on("click", function () {
            currImage--;
            rotateCarousel(currImage);
        })
        $(".prevBtn, .nextBtn, figure.carouselImage").mouseover(function () {
            isStop = true;
        })
        $(".prevBtn, .nextBtn, figure.carouselImage").mouseout(function () {
            isStop = false;
        })
        $(document).on('visibilitychange', function (e) {
            if (document.visibilityState == "hidden") {
                isStop = true;
            } else if (document.visibilityState == "visible") {
                isStop = false;
            }
        })
    }

    function rotateCarousel(imageIndex) {
        figure.style.transform = 'rotateY(' + imageIndex * -theta + 'rad)';
    }

    function showProductsAsideCategorys(cid) {
        $("div.eachCategory[cid=" + cid + "]").css("background-color", "white");
        $("div.eachCategory[cid=" + cid + "] a").css("color", "#87CEFA");
        $("div.productsAsideCategorys[cid=" + cid + "]").show();
    }

    function hideProductsAsideCategorys(cid) {
        $("div.eachCategory[cid=" + cid + "]").css("background-color", "#e2e2e3");
        $("div.eachCategory[cid=" + cid + "] a").css("color", "#000");
        $("div.productsAsideCategorys[cid=" + cid + "]").hide();
    }

    $(function () {
        $("div.eachCategory").mouseenter(function () {
            var cid = $(this).attr("cid");
            showProductsAsideCategorys(cid);
        });
        $("div.eachCategory").mouseleave(function () {
            var cid = $(this).attr("cid");
            hideProductsAsideCategorys(cid);
        });
        $("div.productsAsideCategorys").mouseenter(function () {
            var cid = $(this).attr("cid");
            showProductsAsideCategorys(cid);
            $("div.categoryMenu").show();
        });
        $("div.productsAsideCategorys").mouseleave(function () {
            var cid = $(this).attr("cid");
            hideProductsAsideCategorys(cid);
            $("div.categoryMenu").hide();
        });
    });


    $("div.head").mouseenter(function () {
            $("div.categoryMenu").show();
        }
    )

    $("div.head").mouseleave(function () {
            $("div.categoryMenu").hide();
        }
    )
    $("div.categoryMenu").mouseenter(function () {
            $("div.categoryMenu").show();
        }
    )
    $("div.categoryMenu").mouseleave(function () {
            $("div.categoryMenu").hide();
        }
    )
}

//使用js代码自动计算需要插入的高让footer沉底
//body的高度计算会因为加载的先后导致不稳定,加延时影响用户体验直接把高度写死
$(function () {
        if ($("body").height() < $(window).height()) {
            $("div.footerBottom").css("height", $(window).height() - $("body").height())
        }
})

function calculateFooterHeight() {
    if ($("body").height() <= $(window).height()) {
        $("div.footerBottom").css("height", parseInt($("div.footerBottom").css("height")) + $(window).height() - $("body").height())
    } else {
        $("div.footerBottom").css("height", parseInt($("div.footerBottom").css("height")) - ($("body").height() - $(window).height()))
    }
}

//当多屏切换或者窗口大小改变时自动计算
$($(window).resize(
    function () {
        $("div.footerBottom").css("height", 0)
        if ($("body").height() < $(window).height()) {
            $("div.footerBottom").css("height", $(window).height() - $("body").height())
        }
    }
))
