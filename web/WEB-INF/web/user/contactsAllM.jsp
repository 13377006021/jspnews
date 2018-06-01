<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","反馈管理")}
${pageContext.setAttribute("tier",12)}
<!-- /Head -->
<%@ include file="include/header.jsp"%>

<!-- /Head -->
<!-- Body -->
<body>
<!-- Navbar -->
<%@ include file="include/nav.jsp"%>
<!-- /Navbar -->
<!-- Main Container -->
<div class="main-container container-fluid">
    <!-- Page Container -->
    <div class="page-container">
        <!-- Page Sidebar -->
        <%@ include file="include/sidebar.jsp"%>
        <!-- /Page Sidebar -->
        <!-- Page Content -->
        <div class="page-content">
            <!-- Page Breadcrumb -->
            <div class="page-breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">首页</a>
                    </li>
                    <li>
                        <a href="#">${pageScope.title}</a>
                    </li>
                </ul>
            </div>
            <!-- /Page Breadcrumb -->
            <!-- Page Header -->
            <div class="page-header position-relative">
                <div class="header-title">
                    <h1>${pageScope.title}</h1>
                </div>
                <!--Header Buttons-->
                <div class="header-buttons">
                    <a class="sidebar-toggler" href="#">
                        <i class="fa fa-arrows-h"></i>
                    </a>
                    <a class="refresh" id="refresh-toggler" href="">
                        <i class="glyphicon glyphicon-refresh"></i>
                    </a>
                    <a class="fullscreen" id="fullscreen-toggler" href="#">
                        <i class="glyphicon glyphicon-fullscreen"></i>
                    </a>
                </div>
                <!--Header Buttons End-->
            </div>
            <!-- /Page Header -->
            <!-- Page Body -->
            <div class="page-body">
                <div class="row row_edit_user">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-bottom bordered-palegreen">
                                <span class="widget-caption">查看反馈</span>
                            </div>
                            <div class="widget-body">
                                <div>
                                    <form class="form-horizontal form-bordered" role="form">
                                        <div class="form-group">
                                            <label for="userID" class="col-sm-2 control-label no-padding-right">ID</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userID" placeholder="ID" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="userName" class="col-sm-2 control-label no-padding-right">用户名</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userName" placeholder="用户名">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class="col-sm-2 control-label no-padding-right">邮箱</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="email" placeholder="邮箱">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="phone" class="col-sm-2 control-label no-padding-right">手机号码</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="phone" placeholder="手机号码">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="qq" class="col-sm-2 control-label no-padding-right">qq</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="qq" placeholder="qq">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="title" class="col-sm-2 control-label no-padding-right">标题</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="title" placeholder="标题">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="content" class="col-sm-2 control-label no-padding-right">内容</label>
                                            <div class="col-sm-10">
                                                <textarea  type="text" class="form-control" id="content" placeholder="内容"></textarea>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="ip" class="col-sm-2 control-label no-padding-right">反馈ip</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="ip" placeholder="ip">
                                            </div>
                                        </div>

                                        <div class="form-group text-align-right">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <a href="javascript:void(0);" class="btn btn-labeled btn-yellow alterCanal">
                                                    <i class="btn-label glyphicon glyphicon-remove"></i>取消
                                                </a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <div class="well with-header with-footer">
                            <div class="header bordered-sky">
                                ${pageScope.title}
                            </div>
                            <form class="search" method="get">
                                <div style="float:left;margin-right:2px;">
                                    <div class="form-group">
                                        <select name="search">
                                            <option value="id" <c:if test="${param.search=='id'}">selected="selected"</c:if>>ID</option>
                                            <option value="username" <c:if test="${param.search=='username'}">selected="selected"</c:if>>用户名</option>
                                            <option value="email" <c:if test="${param.search=='email'}">selected="selected"</c:if>>邮箱</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <input type="text" value="${param.searchText}" name="searchText" class="form-control" placeholder="搜索用户">
                                                <i class="fa fa-search"></i>
                                            </span>
                                    </div>
                                </div>
                            </form>
                            <table class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>
                                        ID
                                    </th>
                                    <th>
                                        用户名
                                    </th>
                                    <th>
                                        邮箱
                                    </th>
                                    <th>
                                        手机号码
                                    </th>
                                    <th>
                                        qq
                                    </th>
                                    <th>
                                        title
                                    </th>
                                    <th>
                                        content
                                    </th>
                                    <th>
                                        提交时间
                                    </th>
                                    <th>
                                        反馈ip
                                    </th>
                                    <th>
                                        操作
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.page.list}" var="contacts">
                                    <tr id="data_contacts_${contacts.id}">
                                        <td>
                                                ${contacts.id}
                                        </td>
                                        <td>
                                                ${contacts.username}
                                        </td>
                                        <td>
                                                ${contacts.email}
                                        </td>
                                        <td>
                                                ${contacts.phone}
                                        </td>
                                        <td>
                                                ${contacts.qq}
                                        </td>
                                        <td>
                                                ${contacts.title}
                                        </td>
                                        <td>
                                                ${contacts.content}
                                        </td>
                                        <td>
                                                ${m:dateFormat(contacts.tjdate)}
                                        </td>
                                        <td>
                                                ${contacts.ip}
                                        </td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-xs edit_contacts_${contacts.id}"><i class="fa fa-edit"></i> 查看</a>
                                            <a href="#" class="btn btn-danger btn-xs edit" id="delete_contacts_${contacts.id}"><i class="fa fa-edit"></i> 删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <%@include file="include/page.jsp"%>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Page Body -->
        </div>
        <!-- /Page Content -->
    </div>
    <!-- /Page Container -->
    <!-- Main Container -->

</div>

<%@ include file="include/footerScript.jsp"%>
<%@ include file="include/selectTagScript.jsp"%>
<script type="text/javascript" src="/app/js/ajax/contactsAllM.js"></script>
<%@ include file="include/footer.jsp"%>

