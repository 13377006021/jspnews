<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--侧边栏-->
<div class="page-sidebar" id="sidebar">
    <!-- Page Sidebar Header-->
    <div class="sidebar-header-wrapper">
        <input type="text" class="searchinput" placeholder="搜索文章"/>
        <i class="searchicon fa fa-search"></i>
    </div>
    <!-- /Page Sidebar Header -->
    <!-- Sidebar Menu -->
    <ul class="nav sidebar-menu"  style="font-size: 16px;">
        <!--Dashboard-->
            <!--用户中心-->
            <c:if test="${m:issetContainValue(sessionScope.level,'1',',' )}">
                <li <c:if test="${pageScope.tier==1}">class="active"</c:if>>
                    <a href="index.html">
                        <i class="menu-icon glyphicon glyphicon-home"></i>
                        <span class="menu-text"> 用户中心 </span>
                    </a>
                </li>
            </c:if>

        <!--新闻管理-->
            <c:if test="${m:issetContainValue(sessionScope.level,'2',',' ) || m:issetContainValue(sessionScope.level,'3',',' )}">
                <li <c:if test="${pageScope.tier==2 || pageScope.tier==3}">class="open"</c:if>>
                    <a href="#" class="menu-dropdown">
                        <i class="menu-icon fa fa-newspaper-o"></i>
                        <span class="menu-text"> 新闻管理 </span>

                        <i class="menu-expand"></i>
                    </a>
                    <ul class="submenu">
                        <c:if test="${m:issetContainValue(sessionScope.level,'2',',' )}">
                            <li <c:if test="${pageScope.tier==2}">class="active"</c:if>>
                                <a href="newsAll.html">
                                    <span class="menu-text">所有新闻</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${m:issetContainValue(sessionScope.level,'15',',' )}">
                            <li <c:if test="${pageScope.tier==2}">class="active"</c:if>>
                                <a href="newsReview.html">
                                    <span class="menu-text">新闻审核</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${m:issetContainValue(sessionScope.level,'3',',' )}">
                            <li <c:if test="${pageScope.tier==3}">class="active"</c:if>>
                                <a href="editor.html">
                                    <span class="menu-text">撰写新闻</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </li>
            </c:if>


        <c:if test="${m:issetContainValue(sessionScope.level,'4',',' )}">
            <!--评论管理-->
            <li <c:if test="${pageScope.tier==4}">class="active"</c:if>>
                <a href="comments.html">
                    <i class="menu-icon fa  fa-comments-o"></i>
                    <span class="menu-text"> 评论管理 </span>
                </a>
            </li>
        </c:if>

        <c:if test="${m:issetContainValue(sessionScope.level,'5',',' )}">
            <!--分类管理-->
            <li <c:if test="${pageScope.tier==5}">class="active"</c:if>>
                <a href="category.html">
                    <i class="menu-icon fa fa-folder-open-o"></i>
                    <span class="menu-text"> 分类管理 </span>
                </a>
            </li>
        </c:if>

        <c:if test="${m:issetContainValue(sessionScope.level,'6',',' )}">
            <!--用户管理-->
            <li <c:if test="${pageScope.tier==6}">class="active"</c:if>>
                <a href="user.html">
                    <i class="menu-icon fa fa-user"></i>
                    <span class="menu-text"> 用户管理 </span>
                </a>
            </li>
        </c:if>

        <c:if test="${m:issetContainValue(sessionScope.level,'7',',' )}">
            <!--用户组管理-->
            <li <c:if test="${pageScope.tier==7}">class="active"</c:if>>
                <a href="userGroup.html">
                    <i class="menu-icon fa fa-users"></i>
                    <span class="menu-text"> 用户组管理 </span>
                </a>
            </li>
        </c:if>
        <c:if test="${m:issetContainValue(sessionScope.level,'10',',' )}">
            <!--首页设置-->
            <li <c:if test="${pageScope.tier==10}">class="active"</c:if>>
                <a href="mainSet.html">
                    <i class="menu-icon fa fa-square-o"></i>
                    <span class="menu-text"> 基本设置 </span>
                </a>
            </li>
        </c:if>

        <c:if test="${m:issetContainValue(sessionScope.level,'11',',' )}">
            <!--站点设置-->
            <li <c:if test="${pageScope.tier==11}">class="active"</c:if>>
                <a href="siteSet.html">
                    <i class="menu-icon fa fa-gears"></i>
                    <span class="menu-text"> 站点设置 </span>
                </a>
            </li>
        </c:if>
        <c:if test="${m:issetContainValue(sessionScope.level,'12',',' )}">
            <!--反馈管理-->
            <li <c:if test="${pageScope.tier==12}">class="active"</c:if>>
                <a href="contactsAllM.html">
                    <i class="menu-icon fa  fa-envelope-o"></i>
                    <span class="menu-text"> 反馈管理 </span>
                </a>
            </li>
        </c:if>
        <!--返回首页-->
        <li><a href="/" <c:if test="${pageScope.type=='index'}"></c:if>>
            <i class="menu-icon fa  fa-eye"></i>
            <span class="menu-text"> 新闻首页 </span></a></li>

    </ul>
    <!-- /Sidebar Menu -->
</div>
