package com.dao;

import com.utils.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikesDao {
    private Connection conn=null;
    private PreparedStatement st=null;
    private ResultSet re=null;
    /*
    判断是否点赞
     */
    public int getlikes(int newid,int userid){
        int count = 0;
        String sql = "SELECT * FROM `likes` WHERE `news_id`=? and `user_id`=?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setInt(1,newid);
            st.setInt(2,userid);
            re = st.executeQuery();
            while (re.next()) {
                count++;
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    插入点赞
     */
    public int insetLike(int ids,int newsId,String type){
        int count = 0;
        if (type!=null){
            if(type.equals("+")){

            }else if(type.equals("-")){

            }
        }
        String sql = "INSERT INTO `likes`(`user_id`,`vote_time`,`news_id`,`STATUS`) VALUES (?,?,?,?)";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setInt(1,ids);
            st.setLong(2,System.currentTimeMillis());
            st.setInt(3,newsId);
            st.setInt(4,1);
            count = st.executeUpdate();
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
