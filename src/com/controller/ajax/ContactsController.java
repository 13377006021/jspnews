package com.controller.ajax;

import com.beans.Contacts;
import com.utils.Tools;
import com.service.ajax.contactsService;
import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ContactsController", urlPatterns = {"/ajax/ContactsController.do"})
public class ContactsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ajaxHeader = request.getHeader("x-requested-with");
        if(!"XMLHttpRequest".toUpperCase().equals(ajaxHeader.toUpperCase())) {
            return;
        }
        Contacts contacts = new Contacts();
        try {
            BeanUtils.populate(contacts,request.getParameterMap());
        }catch (Exception e) {
            e.printStackTrace();
        }
        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

        if (request==null){
            tipsMap.put("code","403");
            tipsMap.put("msg","内容不能为空!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        /*开始反馈*/
        contacts.setIp(Tools.getIpAddress(request));
        contactsService contactsService = new contactsService();
        tipsMap = contactsService.insertContacts(contacts);
        jsonArray.put(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}