package com.web.service;

import com.beans.Category;
import com.beans.News;
import com.beans.Page;
import com.dao.CategoryDao;
import com.dao.CommentsDao;
import com.dao.NewsDao;
import com.dao.UserDao;
import com.utils.ComparatorArray;

import java.util.*;


public class CategoryService {
    private NewsDao newsDao = new NewsDao();
    private CategoryDao categoryDao = new CategoryDao();
    /*
    * 获取对应分类目录的最新新闻集合
    * */
    private List<News> getNewestNewsList(int categoryId,int number){
        return newsDao.selectNewsByCategory(categoryId,0,number);
    }
    /*
   * 获取分类新闻总数
   * */

    private int getCategoryNewsCount(String category){
        return newsDao.GetCategoryNewCount(category);
    }
    private int getCategoryNewsCount(int category){
        return newsDao.GetCategoryNewsCount(category);
    }
    /*
   * 获取当前页分类目录
   * */
    public List<News> getCategoryNews(int begin, int end){
        return newsDao.selectAllNews(begin,end);
    }

    /*
    * 获取分类目录总数
    * */
    public int getCategoryCount(int id){
        return categoryDao.GetCategoryCount();
    }
    private List<News> getNews(int begin, int end,String category){
        return newsDao.getCategoryNews1(begin,end,category);
    }
    /*
   * 获取分类新闻数据
   * */
    public Page getCategoryNews(int nowPageNum,String url,String category){
        int count = getCategoryNewsCount(category);
        Page page = new Page(nowPageNum,count,url);
        List<News> list = getNews(page.getStartIndex(),page.getPageSize(),category);
        page.setList(list);
        return page;
    }



    /*
    * 获取对应分类目录的搜索量高的新闻集合
    * */
    private List<News> getSearchHeightNewsList(int categoryId,int number){
        return newsDao.selectLikeSearchsHeightNewsDisText(categoryId,0,number);
    }

    /*
    * 获取指定新闻的评论数量
    * */
    private int getNewsCommentsCountByNewsId(int id){
        return new CommentsDao().GetCommentsCountByNewsId(id);
    }

    /*
    * 获取对应分类目录的评论数量高的新闻集合
    * */
    private List<News> getCommentsHeightNewsList(int categoryId,int number){
        /*获取分类所有新闻的ID集合*/
        List<Integer> newses= newsDao.getNewestNewsId(categoryId,number);
        List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
        for (int i=0;i<newses.size();i++){
            Map<String,Integer> map = new HashMap<>();
            map.put("id",newses.get(i));
            map.put("count",getNewsCommentsCountByNewsId(newses.get(i)));
            list.add(map);
        }
        Collections.sort(list,new ComparatorArray());
        /*再获取分类所有的新闻对应的评论数量集合*/
        List<News> newsList = new ArrayList<>();
        for(Map<String, Integer> m:list){
            News news = newsDao.selectNewsByIdDisText(Integer.parseInt(m.get("id")+""));
            newsList.add(news);
        }
        return newsList;
    }

    /*
    * 获取对应分类目录的查看量高的新闻集合
    * */
    private List<News> getViewsHeightNewsList(int categoryId,int number){
        return newsDao.selectLikeViewsHeightNewsDisText(categoryId,0,number);
    }

    /*
    * 获取该分类的全部新闻
    * */
    private List<News> getCategoryAllNews(int catid){
        return newsDao.selectNewsByCategoryDisText(catid);
    }

    public Map<String,Object> getData(String category,int number){
        Category category1 = new CategoryDao().selectCategoryByAlias(category);
        Map<String,Object> map = new HashMap<>();
        if(category1!=null){
            int catId = category1.getId();
            map.put("header",new HeaderService().getHeaderData());
            map.put("footer",new FooterService().getFooterData());
            map.put("views",getViewsHeightNewsList(catId,number));
            map.put("search",getSearchHeightNewsList(catId,number));
            map.put("comments",getCommentsHeightNewsList(catId,number));
            map.put("newest",getNewestNewsList(catId,number));
           // System.out.println(getNewestNewsList(catId,number).size());
            //map.put("catallnews",getCategoryAllNews(catId));

            map.put("catId",catId);
        }
        return map;
    }




}
