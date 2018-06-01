package com.service.ajax;

import com.beans.Contacts;
import com.dao.ContactsDao;
import com.utils.Encrypt;
import com.utils.Tools;

import java.util.HashMap;
import java.util.Map;

public class contactsService {
    /*
    * 插入评论
    * */
    public Map<String,String> insertContacts(Contacts contacts){
        Map<String,String> tipsMap = new HashMap<>();
        contacts.setUsername(contacts.getUsername().trim());
        contacts.setEmail(contacts.getEmail().trim());
        contacts.setPhone(contacts.getPhone().trim());
        contacts.setQq(contacts.getQq().trim());
        contacts.setTitle(contacts.getTitle().trim());
        contacts.setContent(contacts.getContent());
        if(Tools.empty(contacts.getUsername()) ||  Tools.empty(contacts.getPhone()) || Tools.empty(contacts.getTitle())){
            tipsMap.put("code","403");
            tipsMap.put("msg","内容不能为空!");
            return tipsMap;
        }
        ContactsDao ContactsDao = new ContactsDao();



        if(ContactsDao.isselectUserByUsermail(contacts.getEmail())){
            tipsMap.put("code","403");
            tipsMap.put("msg","该邮箱已经反馈过!");
            return tipsMap;
        }
        if(ContactsDao.isselectUserByphone(contacts.getPhone())){
            tipsMap.put("code","403");
            tipsMap.put("msg","该s手机号码已经反馈过!");
            return tipsMap;
        }
        int num = ContactsDao.insertContactsByObject(contacts);
        if(num>0){
            tipsMap.put("code","200");
            tipsMap.put("msg","提交成功!");
            return tipsMap;
        }
        tipsMap.put("code","403");
        tipsMap.put("msg","提交失败!");
        return tipsMap;
    }
}
