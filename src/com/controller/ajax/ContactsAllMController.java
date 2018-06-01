package com.controller.ajax;

import com.service.user.contactsAllMService;
import com.utils.Tools;
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

@WebServlet(name = "ContactsAllMController", urlPatterns = {"/ajax/ContactsAllMController.do"})
public class ContactsAllMController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         /*创建相应JSON和Map集合*/
        Map<String, java.io.Serializable> tipsMap = new HashMap<String, java.io.Serializable>();
        JSONArray jsonArray = new JSONArray();

        String id = request.getParameter("id");
        String type = request.getParameter("type");
        if(Tools.empty(type)){
            tipsMap.put("code","403");
            tipsMap.put("msg","缺少必要参数!");
        }else if("select".equals(type)){
            if(Tools.empty(id)){
                tipsMap.put("code","403");
                tipsMap.put("msg","缺少必要参数!");
            }else{
                tipsMap = new contactsAllMService().getSelectContacts(Integer.parseInt(id ));
            }
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","无效请求!");
        }
        jsonArray.put(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}