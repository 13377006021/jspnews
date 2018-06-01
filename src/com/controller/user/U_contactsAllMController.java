package com.controller.user;

import com.beans.Page;
import com.exception.EndPageException;
import com.service.user.contactsAllMService;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "U_contactsAllMController", urlPatterns = {"/user/U_contactsAllMController"})
public class U_contactsAllMController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!Tools.isLevelOnPage(request,"6")){
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return;
        }
        String url = "contactsAllM.html?";
        String search = request.getParameter("search");
        String text = request.getParameter("searchText");
        String nowPageNum = request.getParameter("page");
        Page page = null;
        if(Tools.empty(nowPageNum)){
            nowPageNum = "1";
        }
        if(!Tools.empty(search)&&!Tools.empty(text)&&("id".equals(search)||"username".equals(search)||"usermail".equals(search))){
            url = url+"search="+search+"&searchText="+text+"&";
            page = new contactsAllMService().getSearchContactsList(Integer.parseInt(nowPageNum),url,search,text);
        }else{
            page = new contactsAllMService().getDefaultContactsList(Integer.parseInt(nowPageNum),url);
        }
        request.setAttribute("page",page);
        request.getRequestDispatcher("/WEB-INF/web/user/contactsAllM.jsp").forward(request,response);
    }
}