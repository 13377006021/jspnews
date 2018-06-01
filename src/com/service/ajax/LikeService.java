package com.service.ajax;


import java.util.HashMap;
import java.util.Map;

import com.dao.LikesDao;
import com.dao.NewsDao;


public class LikeService {
    /**
     * 点赞+1
     * */
    private int saveLikeNews(int newsId,String type){

       return new NewsDao().updateLike(newsId,type);

    }
    /**
     * 判断是否点过赞
     * */
    private int isLike(int news_id,int user_id){
        return new LikesDao().getlikes(news_id,user_id);
    }
    /**
     * 保存点赞到likes表
     * */
    private int saveLike(int ids,int newsId,String type){
        return new LikesDao().insetLike(ids,newsId,type);
    }
    /**
     * 重新获取点赞总数
     * */
    private int getLikes(int newsid){
        return new NewsDao().getLike(newsid);
    }

    public Map<String,String> saveLikeDate(int ids,int newsId,String type){
        Map<String,String> tipsMap = new HashMap<>();
        int islike=isLike(newsId,ids);
        if(islike>0){
            tipsMap.put("code","403");
            tipsMap.put("msg","您已为本条新闻点过赞!<br>请勿重复点赞");
            return tipsMap;
        }
        int num=saveLikeNews(newsId,type);
        int num1=saveLike(ids,newsId,type);
        String likes="("+getLikes(newsId)+")";
        if(num>0&&num1>0){
            tipsMap.put("likes",likes);
            tipsMap.put("code","200");
            tipsMap.put("msg","已赞"+likes);
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","点赞失败!");
        }
        return tipsMap;
    }
}

