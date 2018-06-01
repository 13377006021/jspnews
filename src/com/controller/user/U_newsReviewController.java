package com.controller.user;

import com.beans.Page;
import com.service.ajax.NewsReviewService;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "U_newsReviewController", urlPatterns = {"/user/U_newsReviewController"})
public class U_newsReviewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!Tools.isLevelOnPage(request,"2")){
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return;
        }
        String url = "newsReview.html?";
        String search = request.getParameter("search");
        String text = request.getParameter("searchText");
        String nowPageNum = request.getParameter("page");
        Page page = null;
        if(Tools.empty(nowPageNum)){
            nowPageNum = "1";
        }
        if(!Tools.empty(search)&&!Tools.empty(text)&&("id".equals(search)||"title".equals(search))){
            url = url+"search="+search+"&searchText="+text+"&";
            page = new NewsReviewService().getSearchNewsList(Integer.parseInt(nowPageNum),url,search,text);
        }else{
            page = new NewsReviewService().getDefaultNewsList(Integer.parseInt(nowPageNum),url);
        }
        request.setAttribute("page",page);
        request.getRequestDispatcher("/WEB-INF/web/user/newsReview.jsp").forward(request,response);
    }
}