<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${ctx}/res/css/fore/fore_nav.css"/>
<script>
    $(function () {
        $(".quick_li").find("li").hover(
            function () {
                $(this).find(".sn_menu").addClass("sn_menu_hover");
                $(this).find(".quick_menu,.quick_qrcode,.quick_DirectPromoDiv,.quick_sitmap_div").css("display", "block");
            }, function () {
                $(this).find(".sn_menu").removeClass("sn_menu_hover");
                $(this).find(".quick_menu,.quick_qrcode,.quick_DirectPromoDiv,.quick_sitmap_div").css("display", "none");
            }
        );
    });
</script>
<div id="nav">
    <div class="nav_main">
        <p id="container_login">
            <c:choose>
                <c:when test="${sessionScope.user.userName==null}">
                    <em>嗨！欢迎来到Mall商城</em>
                    <a href="${ctx}/user/UserLogin">登录</a>
                    <a href="${ctx}/user/register">注册</a>
                </c:when>
                <c:otherwise>
                    <em>Hi，</em>
                    <a href="${ctx}/userDetails" class="userName"
                       target="_blank">${sessionScope.user.userName}</a>
                    <a href="${ctx}/user/logout">退出</a>
                </c:otherwise>
            </c:choose>
        </p>
        <ul class="quick_li">
            <li class="quick_li_MyTaobao">
                <div class="sn_menu">
                    <a href="${ctx}/userDetails">我的Mall<b></b></a>
                    <div class="quick_menu">
                        <a href="${ctx}/order/0/10">已买到的宝贝</a>
                        <a href="#">已卖出的宝贝</a>
                    </div>
                </div>
            </li>
            <li class="quick_li_cart">
                <img src="${ctx}/res/images/fore/WebsiteImage/buyCar.png">
                <a href="${ctx}/cart">购物车</a>
            </li>
            <li class="quick_li_menuItem">
                <div class="sn_menu">
                    <a href="#">收藏夹<b></b></a>
                    <div class="quick_menu">
                        <a href="#">收藏的宝贝</a>
                        <a href="#">收藏的店铺</a>
                    </div>
                </div>
            </li>
            <li class="quick_li_separator"></li>
            <li class="quick_li_mobile">
                <img src="${ctx}/res/images/fore/WebsiteImage/mobile.png">
                <a href="#" title="Mall无线">手机版</a>
                <div class="quick_qrcode">
                    <img src="${ctx}/res/images/fore/WebsiteImage/qrcode.png">
                    <b></b>
                </div>
            </li>
            <li class="quick_home"><a href="${ctx}">Mall商城</a></li>
            <li class="quick_DirectPromo">
                <div class="sn_menu">
                    <a href="#">商家支持<b></b></a>
                    <div class="quick_DirectPromoDiv">
                        <ul>
                            <li>
                                <h3>商家：</h3>
                                <a href="">商家中心</a>
                                <a href="">Mall规则</a>
                                <a href="">商家入驻</a>
                                <a href="">运营服务</a>
                                <a href="">商家品控</a>
                                <a href="">商家工具</a>
                                <a href="">Mall智库</a>
                                <a href="">喵言喵语</a>
                            </li>
                            <li>
                                <h3>帮助：</h3>
                                <a href="">帮助中心</a>
                                <a href="">问商友</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </li>
            <li class="quick_sitemap">
                <div class="sn_menu">
                    <a>网站导航<b></b></a>
                    <div class="quick_sitmap_div">
                        <div class="site-hot">
                            <h2>热点推荐<span>Hot</span></h2>
                            <ul>
                                <li><a href="">Mall超市</a></li>
                                <li><a href="">Mall生鲜</a></li>
                                <li><a href="">科技新品</a></li>
                                <li><a href="">女装新品</a></li>
                                <li><a href="">酷玩街</a></li>
                                <li><a href="">内衣新品</a></li>
                                <li><a href="">试美妆</a></li>
                                <li><a href="">运动新品</a></li>
                                <li><a href="">时尚先生</a></li>
                                <li><a href="">精明妈咪</a></li>
                                <li><a href="">吃乐会</a></li>
                                <li><a href="">企业采购</a></li>
                                <li><a href="">会员积分</a></li>
                                <li><a href="">Mall国际</a></li>
                                <li><a href="">品质频道</a></li>
                            </ul>
                        </div>
                        <div class="site-market">
                            <h2>行业市场<span>Market</span></h2>
                            <ul>
                                <li><a href="">美妆</a></li>
                                <li><a href="">电器</a></li>
                                <li><a href="">女装</a></li>
                                <li><a href="">男装</a></li>
                                <li><a href="">女鞋</a></li>
                                <li><a href="">男鞋</a></li>
                                <li><a href="">内衣</a></li>
                                <li><a href="">箱包</a></li>
                                <li><a href="">运动</a></li>
                                <li><a href="">母婴</a></li>
                                <li><a href="">家装</a></li>
                                <li><a href="">医药</a></li>
                                <li><a href="">食品</a></li>
                                <li><a href="">配饰</a></li>
                                <li><a href="">汽车</a></li>
                            </ul>
                        </div>
                        <div class="site-brand">
                            <h2>品牌风尚<span>Brand</span></h2>
                            <ul>
                                <li><a href="">尚Mall</a></li>
                                <li><a href="">大牌街</a></li>
                                <li><a href="">潮牌街</a></li>
                                <li><a href="">Mall原创</a></li>
                                <li><a href="">什么牌子好</a></li>
                            </ul>
                        </div>
                        <div class="site-help">
                            <h2>服务指南<span>Help</span></h2>
                            <ul>
                                <li><a href="">帮助中心</a></li>
                                <li><a href="">品质保障</a></li>
                                <li><a href="">特色服务</a></li>
                                <li><a href="">7天退换货</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>