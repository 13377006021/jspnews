package com.controller.ajax;

import com.service.ajax.CommentsDataService;
import com.utils.CookieUtils;
import com.utils.Encrypt;
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

@WebServlet(name = "CommentsDataController", urlPatterns = {"/ajax/CommentsDataController.do"})
public class CommentsDataController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        String type=request.getParameter("type");
        String text = request.getParameter("text");
        String parentId = request.getParameter("id");
        String newsId = request.getParameter("newsId");
        Object id = request.getSession().getAttribute("id");
        String lastTime = CookieUtils.FindCookie("lastCom",request);
       // System.out.println(type);
        CommentsDataService cds=new CommentsDataService();
        if(type!=null){
            if(type.equals("赞")){
                tipsMap= cds.saveCommentsLike(Integer.parseInt(parentId));
                jsonArray.put(tipsMap);
            }else if(type.equals("insert")){
                if(id==null || Tools.empty(text) || !Tools.isNumber(parentId) || !Tools.isNumber(newsId)){
                    tipsMap.put("code","403");
                    tipsMap.put("msg","缺少或错误参数,无法执行评论操作");
                    jsonArray.put(tipsMap);
                }else{
                    int ids = (int)id;
                    tipsMap = cds.saveComments(response,ids,Integer.parseInt(parentId),text,Integer.parseInt(newsId));
                    jsonArray.put(tipsMap);
                }
            }else {
                tipsMap= cds.delCommentsLike(Integer.parseInt(parentId));
                jsonArray.put(tipsMap);
            }
        }else {
            tipsMap.put("code","403");
            tipsMap.put("msg","缺少或错误参数,无法执行评论操作");
            jsonArray.put(tipsMap);
        }
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}