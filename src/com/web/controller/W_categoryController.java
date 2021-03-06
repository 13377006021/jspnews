package com.web.controller;

import com.beans.Page;
import com.utils.Tools;
import com.web.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "W_categoryController", urlPatterns = {"/web/W_categoryController"})
public class W_categoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        String nowPageNum = request.getParameter("page");
        String url = category+"?";
        Page page = null;
        if(Tools.empty(nowPageNum)){
            nowPageNum = "1";
        }
        page = new CategoryService().getCategoryNews(Integer.parseInt(nowPageNum),url,category);
        Map<String,Object> map = null;
        map = new CategoryService().getData(category,20);
        request.setAttribute("map",map);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/WEB-INF/web/category.jsp").forward(request,response);
    }
}