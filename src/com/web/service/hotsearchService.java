package com.web.service;

import com.beans.Category;
import com.beans.News;
import com.dao.CategoryDao;
import com.dao.NewsDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class hotsearchService {

    /*
    * 获取最新搜索量最高文章
    * */
    private List<News> getSearchHeightNewsById(int id,int number){
        return new NewsDao().selectLikeSearchsHeightNewsDisText(id,0,number);
    }

    private List<Map<String, Object>> getCategoryNews(int number){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<Category> listCategory = new CategoryDao().selectAllCategoryDisDefault();
        for (Category c:listCategory){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("category",c);
            map.put("news",getSearchHeightNewsById(c.getId(),10));
            list.add(map);
        }
        return list;
    }

    public Map<String,Object> getData(){
        Map<String,Object> map = new HashMap<>();
        map.put("header",new HeaderService().getHeaderData());
        map.put("footer",new FooterService().getFooterData());
        map.put("data",getCategoryNews(10));
        return map;
    }
}
