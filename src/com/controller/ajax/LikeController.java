package com.controller.ajax;
import com.service.ajax.LikeService;
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

@WebServlet(name = "LikeController", urlPatterns = {"/ajax/LikeController.do"})
public class LikeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        /*判断是否存在类型*/
        String type = request.getParameter("type");
        String parentId = request.getParameter("id");
        String newsId = request.getParameter("newsId");
        Object id = request.getSession().getAttribute("id");
        if(id==null || !Tools.isNumber(newsId)){
            tipsMap.put("code","403");
            tipsMap.put("msg","只有登陆用户才可以点赞");
            jsonArray.put(tipsMap);
        }else{
            int ids = (int)id;
            tipsMap = new LikeService().saveLikeDate(ids,Integer.parseInt(newsId),type);
            jsonArray.put(tipsMap);
        }
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}