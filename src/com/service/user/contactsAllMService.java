package com.service.user;

import com.beans.Contacts;
import com.beans.Group;
import com.beans.Page;
import com.dao.ContactsDao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class contactsAllMService {
    private ContactsDao ContactsDao = new ContactsDao();

    /*
  * 根据ID查找指定的用户组信息
  * */
    public Contacts selectContactsById(int id){
        return ContactsDao.selectContactsById(id);
    }
    /*
    * 获取id获取数据
    * */
    public Map<String, java.io.Serializable> getSelectContacts(int id){
        Map<String, Serializable> tipsMap = new HashMap<String, Serializable>();
        Contacts contacts = selectContactsById(id);
        if(contacts==null){
            tipsMap.put("code","403");
            tipsMap.put("msg","不存在目标");
        }else{
            tipsMap.put("code","200");
            tipsMap.put("msg","获取成功");
            tipsMap.put("id",contacts.getId() );
            tipsMap.put("username",contacts.getUsername() );
            tipsMap.put("Email",contacts.getEmail() );
            tipsMap.put("Phone",contacts.getPhone() );
            tipsMap.put("Qq",contacts.getQq() );
            tipsMap.put("Title",contacts.getTitle() );
            tipsMap.put("Content",contacts.getContent() );
            tipsMap.put("Tjdate",contacts.getTjdate() );
            tipsMap.put("Ip",contacts.getIp() );
        }
        return tipsMap;
    }

    /*
    * 获取用户总数
    * */
    public int getContactsCount(){
        return ContactsDao.getContactsCount();
    }

    /*
    * 获取模糊搜索用户数量
    * */
    public int getLikeContactsCount(String type,String value){
        return ContactsDao.getLikeContactsCount(type,value);
    }

    /*
    * 获取当前页用户列表
    * */
    public List<Contacts> getContacts(int begin, int end){
        return ContactsDao.selectAllContacts(begin,end);
    }

    /*
    * 获取模糊搜索当前页用户列表
    * */
    public List<Contacts> getLikeContacts(int begin,int end,String type,String value){
        return ContactsDao.selectLikeContacts(begin,end,type,value);
    }



    /*
    * 获取默认数据
    * */
    public Page getDefaultContactsList(int nowPageNum, String url){
        int count = getContactsCount();
        Page page  = new Page(nowPageNum,count,url);
        List<Contacts> list = getContacts(page.getStartIndex(),page.getPageSize());
        page.setList(list);
        return page;
    }

    /*
    * 获取搜索数据
    * */
    public Page getSearchContactsList(int nowPageNum,String url,String type,String value){
        int count = getLikeContactsCount(type,value);
        Page page  = new Page(nowPageNum,count,url);
        List<Contacts> list = getLikeContacts(page.getStartIndex(),page.getPageSize(),type,value);
        page.setList(list);
        return page;
    }
}
