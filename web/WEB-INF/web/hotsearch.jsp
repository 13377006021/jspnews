<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","热搜新闻")}
${pageContext.setAttribute("type","hotsearch")}
<%@ include file="header.jsp"%>

<!--内容区域-->
<div id="main">
    <div class="areas" style="background-image: url('/app/img/red-bg.png')">
        <p>热搜新闻 - Hot search news</p>
    </div>
    <c:forEach items="${requestScope.map.data}" var="d">
        <div class="rank">
            <div class="title">
                <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category, d.category.id)}">
                        ${m:getCategoryNameById(requestScope.map.header.category, d.category.id)}
                </a>
            </div>
            <ul>
                    ${pageContext.setAttribute("newestNum",1)}
                <c:forEach items="${d.news}" var="n">
                    <li><span class="top">${pageScope.newestNum}</span>
                        <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category, d.category.id)}/${n.id}.html" title="<c:out value="${n.title}"/>">
                            <c:out value="${n.title}"/><dd><c:out value="${m:dateFormat(n.created)}"/></dd>
                        </a>
                    </li>
                    ${pageContext.setAttribute("newestNum",pageScope.newestNum+1)}
                </c:forEach>

            </ul>
        </div>
    </c:forEach>
</div>

<%@ include file="footer.jsp"%>
