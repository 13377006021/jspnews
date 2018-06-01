<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="http://www.licoy.org/my" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="${requestScope.map.header.icourlSet}" type="image/x-icon">
    <c:choose>
        <c:when test="${pageScope.type=='index'}">
            <title>${requestScope.map.header.siteTitle}</title>
        </c:when>
        <c:when test="${pageScope.type=='page'}">
            <title>${requestScope.map.news.title} - ${requestScope.map.header.siteTitle}</title>
        </c:when>
        <c:when test="${pageScope.type=='search'}">
            <title>"${param.s}" 搜索结果 - ${requestScope.map.header.siteTitle}</title>
        </c:when>
        <c:when test="${pageScope.type=='newest' || pageScope.type=='hotsearch'}">
            <title>${pageScope.title} - ${requestScope.map.header.siteTitle}</title>
        </c:when>
        <c:when test="${pageScope.type=='category'}">
            <title>${pageScope.title} - ${requestScope.map.header.siteTitle}</title>
        </c:when>
        <c:otherwise>
            <title>${requestScope.map.header.siteTitle}</title>
        </c:otherwise>
    </c:choose>

    <meta name="keywords" content="${requestScope.map.header.siteKeyword}"/>
    <meta name="description" content="${requestScope.map.header.siteDescribe}"/>
    <link href="/app/css/style.css" rel="stylesheet">
    <link href="/app/css/normalize.css" rel="stylesheet">
    <link href="/app/css/page-zishe.css" rel="stylesheet">
    <c:if test="${pageScope.type=='index'}">
        <link href="/app/css/slide.css" rel="stylesheet">
    </c:if>
    <link href="/app/css/font-awesome.min.css" rel="stylesheet">
    <c:if test="${pageScope.type=='login'||pageScope.type=='reg'||pageScope.type=='retpswd'||pageScope.type=='contacts'}">
        <link href="/app/css/login.css" rel="stylesheet">
        <link href="/app/css/zeroModal.css" rel="stylesheet">
        <link href="/app/css/common.css" rel="stylesheet">
    </c:if>
    <c:if test="${pageScope.type=='page'}">
        <link href="/app/css/zeroModal.css" rel="stylesheet">
        <link href="/app/css/viewer.min.css" rel="stylesheet">
        <link href="/app/css/dianzan.css" rel="stylesheet">
        <link href="/app/css/animate.css" rel="stylesheet">
        <link href="/app/iconfont/iconfont.css" rel="stylesheet">
    </c:if>
    <script type="text/javascript" src="/app/js/jquery.min.js"></script>
    <script type="text/javascript" src="/app/js/jquery-tab.js"></script>
    <script type="text/javascript" src="/app/js/dianzan.js"></script>
    <script type="text/javascript">
        $(function(){
            $('.tab-group').tabify();
        })
    </script>
</head>
<body>
<!--头部区域-->
<%@ include file="nav.jsp"%>
