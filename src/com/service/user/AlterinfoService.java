package com.service.user;

import com.beans.User;
import com.dao.UserDao;


public class AlterinfoService {
    /*
    * 查询出当前用户的信息
    * */
    public User getNowUserInfo(int id){
        return new UserDao().selectUserById(id);
    }
}
