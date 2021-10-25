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
                    <a href="${ctx}/user/userDetails">我的Mall<b></b></a>
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
                                <a href="javascript:void(0)">商家中心</a>
                                <a href="javascript:void(0)">Mall规则</a>
                                <a href="javascript:void(0)">商家入驻</a>
                                <a href="javascript:void(0)">运营服务</a>
                                <a href="javascript:void(0)">商家品控</a>
                                <a href="javascript:void(0)">商家工具</a>
                                <a href="javascript:void(0)">Mall智库</a>
                                <a href="javascript:void(0)">喵言喵语</a>
                            </li>
                            <li>
                                <h3>帮助：</h3>
                                <a href="javascript:void(0)">帮助中心</a>
                                <a href="javascript:void(0)">问商友</a>
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
                                <li><a href="javascript:void(0)">Mall超市</a></li>
                                <li><a href="javascript:void(0)">Mall生鲜</a></li>
                                <li><a href="javascript:void(0)">科技新品</a></li>
                                <li><a href="javascript:void(0)">女装新品</a></li>
                                <li><a href="javascript:void(0)">酷玩街</a></li>
                                <li><a href="javascript:void(0)">内衣新品</a></li>
                                <li><a href="javascript:void(0)">试美妆</a></li>
                                <li><a href="javascript:void(0)">运动新品</a></li>
                                <li><a href="javascript:void(0)">时尚先生</a></li>
                                <li><a href="javascript:void(0)">精明妈咪</a></li>
                                <li><a href="javascript:void(0)">吃乐会</a></li>
                                <li><a href="javascript:void(0)">企业采购</a></li>
                                <li><a href="javascript:void(0)">会员积分</a></li>
                                <li><a href="javascript:void(0)">Mall国际</a></li>
                                <li><a href="javascript:void(0)">品质频道</a></li>
                            </ul>
                        </div>
                        <div class="site-market">
                            <h2>行业市场<span>Market</span></h2>
                            <ul>
                                <li><a href="javascript:void(0)">美妆</a></li>
                                <li><a href="javascript:void(0)">电器</a></li>
                                <li><a href="javascript:void(0)">女装</a></li>
                                <li><a href="javascript:void(0)">男装</a></li>
                                <li><a href="javascript:void(0)">女鞋</a></li>
                                <li><a href="javascript:void(0)">男鞋</a></li>
                                <li><a href="javascript:void(0)">内衣</a></li>
                                <li><a href="javascript:void(0)">箱包</a></li>
                                <li><a href="javascript:void(0)">运动</a></li>
                                <li><a href="javascript:void(0)">母婴</a></li>
                                <li><a href="javascript:void(0)">家装</a></li>
                                <li><a href="javascript:void(0)">医药</a></li>
                                <li><a href="javascript:void(0)">食品</a></li>
                                <li><a href="javascript:void(0)">配饰</a></li>
                                <li><a href="javascript:void(0)">汽车</a></li>
                            </ul>
                        </div>
                        <div class="site-brand">
                            <h2>品牌风尚<span>Brand</span></h2>
                            <ul>
                                <li><a href="javascript:void(0)">尚Mall</a></li>
                                <li><a href="javascript:void(0)">大牌街</a></li>
                                <li><a href="javascript:void(0)">潮牌街</a></li>
                                <li><a href="javascript:void(0)">Mall原创</a></li>
                                <li><a href="javascript:void(0)">什么牌子好</a></li>
                            </ul>
                        </div>
                        <div class="site-help">
                            <h2>服务指南<span>Help</span></h2>
                            <ul>
                                <li><a href="javascript:void(0)">帮助中心</a></li>
                                <li><a href="javascript:void(0)">品质保障</a></li>
                                <li><a href="javascript:void(0)">特色服务</a></li>
                                <li><a href="javascript:void(0)">7天退换货</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>