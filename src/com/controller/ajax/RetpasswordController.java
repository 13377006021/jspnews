package com.controller.ajax;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.beans.User;
import com.dao.UserDao;
import com.service.user.UserService;
import com.utils.*;
import org.json.JSONArray;
import org.json.JSONException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "RetpasswordController", urlPatterns = {"/ajax/RetpasswordController.do"})
public class RetpasswordController extends HttpServlet {
    //private ServletConfig Servletconf
    //private String temp;
    private String username;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String temp=genCodes();
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String  password = request.getParameter("email");
        Map<String, String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        if(Tools.empty(type)){
            tipsMap.put("code","403");
            tipsMap.put("msg","不存在必要参数,无法操作!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }

        if (type.equals("ret")) {
            User user = new UserDao().selectUserByUsermail(email);
            if (user != null) {
                username = user.getUsername();
            }
            System.out.println(email + username + temp);
        /*创建相应JSON和Map集合*/

        /*获取请求的验证码是否正确*/
            if (!Tools.isCheckCode(request)) {
                tipsMap.put("code", "403");
                tipsMap.put("msg", "验证码错误!");
                jsonArray.put(tipsMap);
                try {
                    response.getWriter().print(jsonArray.getString(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return;
            }
            if (sendmail(email, username,temp)) {
                tipsMap.put("code", "200");
                tipsMap.put("msg", temp);
            } else {
                tipsMap.put("code", "403");
                tipsMap.put("msg", "发送失败!");
            }


        }else if(type.equals("retpassword")){
            if(Tools.empty(email)&&Tools.empty(password)){
                tipsMap.put("code","403");
                tipsMap.put("msg","不存在必要参数,无法操作!");
                jsonArray.put(tipsMap);
                try {
                    response.getWriter().print(jsonArray.getString(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return;
            }
            int num=new UserService().updateUserByEmail(email,Encrypt.md5(password));
            if(num>0){
                tipsMap.put("code", "200");
                tipsMap.put("msg", "更新成功");
            }else {
                tipsMap.put("code", "403");
                tipsMap.put("msg", "修改失败!");
            }
        }
        jsonArray.put(tipsMap);
        System.out.println(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private boolean sendmail(String mailto,String username,String temp){
        String MailTo=mailto;
        String MailSubject="找回密码";
        String MailBCopyTo="";
        String MailCopyTo="";
        String MailBody="<p>J2EE 邮件测试， 亲爱的 "+username+",<br />" +
                "	您的验证码为</p>"+temp ;
        String SMTPHost = "smtp.163.com";
        String Port="25";
        String MailUsername = "13377006021@163.com";
        String MailPassword = "LIyingxian0606";
        String MailFrom = "13377006021@163.com";
        if(SMTPHost==null||SMTPHost==""||MailUsername==null||MailUsername==""||MailPassword==null||MailPassword==""||MailFrom==null||MailFrom=="")
        {
            System.out.println("Servlet parameter Wrongs");
        }
        System.out.println(MailBody);
        SendMail send=new SendMail(SMTPHost,Port,MailUsername,MailPassword);

        if(send.sendingMimeMail(MailFrom, MailTo, MailCopyTo, MailBCopyTo, MailSubject, MailBody)){
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String genCodes() {
        Random random = new Random();
        //pwd=random.nextInt(9999);
        //pwd=99999999*Math.random()+10000000;
        int pwd=random.nextInt(9999-1000+1)+1000;//密码随机值1000-9999

        return  pwd+"";
    }

}