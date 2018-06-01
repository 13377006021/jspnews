package com.web.controller;

import com.web.service.contactsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "W_contactsController", urlPatterns = {"/web/W_contactsController"})
public class W_contactsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> map = null;
        map = new contactsService().getData();
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/contacts.jsp").forward(request,response);
    }
}