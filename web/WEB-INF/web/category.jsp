<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title",m:getCategoryNameById(requestScope.map.header.category,requestScope.map.catId))}
${pageContext.setAttribute("type","category")}
<%@ include file="header.jsp"%>

<!--内容区域-->
<div id="main">
    <div class="areas" style="background-image: url('/app/img/color15.png')">
        <p>${m:getCategoryNameById(requestScope.map.header.category,requestScope.map.catId)}</p>
    </div>


    <div class="tab-group">
        <section id="tab1" title="热搜新闻">

            <p>

            <div class="rank">
                <div class="title">
                    <a>热搜新闻</a>
                </div>
                <ul>
                    ${pageContext.setAttribute("categoryNum",1)}
                    <c:forEach items="${requestScope.map.search}" var="n" begin="0" end="9">
                        <li><span class="top">${pageScope.categoryNum}</span>
                            <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,n.category)}/${n.id}.html" title="<c:out value="${n.title}"/>">
                                <c:out value="${n.title}"/> <dd><c:out value="${m:dateFormat(n.created)}"/></dd>
                            </a>
                        </li>
                        ${pageContext.setAttribute("categoryNum",pageScope.categoryNum+1)}
                    </c:forEach>
                </ul>
            </div>
            </p>
        </section>
        <section id="tab2" title="最新新闻">
            <p>
            <div class="rank">
                <div class="title">
                    <a>最新新闻</a>
                </div>
                <ul>
                    ${pageContext.setAttribute("categoryNum",1)}
                    <c:forEach items="${requestScope.map.newest}" var="n" begin="0" end="9">
                        <li><span class="top">${pageScope.categoryNum}</span>
                            <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,n.category)}/${n.id}.html" title="<c:out value="${n.title}"/>">
                                <c:out value="${n.title}"/><dd><c:out value="${m:dateFormat(n.created)}"/></dd>
                            </a>
                        </li>
                        ${pageContext.setAttribute("categoryNum",pageScope.categoryNum+1)}
                    </c:forEach>
                </ul>
            </div>
            </p>
        </section>
        <section id="tab3" title="热评新闻">

            <p>

            <div class="rank">
                <div class="title">
                    <a>热评新闻</a>
                </div>
                <ul>
                    ${pageContext.setAttribute("categoryNum",1)}
                    <c:forEach items="${requestScope.map.comments}" var="n" begin="0" end="9">
                        <li><span class="top">${pageScope.categoryNum}</span>
                            <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,n.category)}/${n.id}.html" title="<c:out value="${n.title}"/>">
                                <c:out value="${n.title}"/><dd><c:out value="${m:dateFormat(n.created)}"/></dd>
                            </a>
                        </li>
                        ${pageContext.setAttribute("categoryNum",pageScope.categoryNum+1)}
                    </c:forEach>
                </ul>
            </div>

            </p>
        </section>
        <section id="tab4" title="热门关注">

            <p>

            <div class="rank">
                <div class="title">
                    <a>热门关注</a>
                </div>
                <ul>
                    ${pageContext.setAttribute("categoryNum",1)}
                    <c:forEach items="${requestScope.map.views}" var="n" begin="0" end="9">
                        <li><span class="top">${pageScope.categoryNum}</span>
                            <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,n.category)}/${n.id}.html" title="<c:out value="${n.title}"/>">
                                <c:out value="${n.title}"/><dd><c:out value="${m:dateFormat(n.created)}"/></dd>
                            </a>
                        </li>
                        ${pageContext.setAttribute("categoryNum",pageScope.categoryNum+1)}
                    </c:forEach>
                </ul>
            </div>

            </p>
        </section>
    </div>




        <div class="rank">
            <div class="title" style="text-align: left">
                <a>有关${m:getCategoryNameById(requestScope.map.header.category,requestScope.map.catId)}全部新闻</a>
            </div>
            <ul>
                ${pageContext.setAttribute("categoryNum",1)}
                <c:forEach items="${requestScope.page.list}" var="n" >
                    <li><span class="top">${pageScope.categoryNum}</span>
                        <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,n.category)}/${n.id}.html" title="<c:out value="${n.title}"/>">
                            <c:out value="${n.title}"/><dd><c:out value="${m:dateFormat(n.created)}"/></dd>
                        </a>
                    </li>
                    ${pageContext.setAttribute("categoryNum",pageScope.categoryNum+1)}
                </c:forEach>
            </ul>
        </div>


        <%@include file="lb-page.jsp"%>
    </div>



<%@ include file="footer.jsp"%>