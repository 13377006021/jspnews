package com.service.ajax;

import com.beans.Comments;
import com.beans.User;
import com.dao.CommentsDao;
import com.dao.UserDao;
import com.utils.CookieUtils;
import com.utils.Encrypt;
import com.utils.Tools;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class CommentsDataService {
    /**
     * 增加赞
     * */
    public Map<String,String> saveCommentsLike(int parentId){
        Map<String,String> tipsMap = new HashMap<>();
        CommentsDao comm=new CommentsDao();
        int num = comm.updateCommentsByLike(parentId);
        String likes=""+ comm.selectCommentsByLike(parentId);
        //System.out.println(likes);
        if(num>0){
            tipsMap.put("code","200");
            tipsMap.put("msg",likes);
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","点赞失败!");
        }
        return tipsMap;
    }
    /**
     * 减少赞
     * */
    public Map<String,String> delCommentsLike(int parentId){
        Map<String,String> tipsMap = new HashMap<>();
        int num = new CommentsDao().delCommentsByLike(parentId);
        System.out.println(num);
        if(num>0){
            tipsMap.put("code","200");
            tipsMap.put("msg","成功");
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","点赞失败!");
        }
        return tipsMap;
    }

    /**
    * 存放评论
    * */
    public Map<String,String> saveComments(HttpServletResponse response, int id, int parentId, String text, int newsId){
        Map<String,String> tipsMap = new HashMap<>();
        Comments comments = new Comments();
        text = Tools.matchAbstract(text,255);
        comments.setUser(id);
        comments.setContain(parentId);
        comments.setText(text);
        comments.setNews(newsId);
        int num = new CommentsDao().insertCommentsByObject(comments);
        if(num>0){
            CookieUtils.addCookie("lastCom",System.currentTimeMillis()+"",response);
            User user = new UserDao().selectUserById(id);
            tipsMap.put("code","200");
            tipsMap.put("msg","评论成功!");
            tipsMap.put("username",user.getUsername());
            tipsMap.put("id",user.getId()+"");
            tipsMap.put("grava",user.getGrava());
            tipsMap.put("text",text);
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","评论失败!");
        }
        return tipsMap;
    }
}
