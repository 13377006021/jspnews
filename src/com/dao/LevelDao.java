package com.dao;

import com.beans.Level;
import com.utils.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LevelDao {
    private Connection conn=null;
    private PreparedStatement st=null;
    private ResultSet re=null;
    /**
    * 根据对应的ID查询权限信息
    * */
    public Level selectLevelById(int id){
        Level level = null;
        String sql = "SELECT `id`,`name` FROM `level` WHERE `id`=?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setInt(1,id);
            re = st.executeQuery();
            while(re.next()){
                level = new Level();
                level.setId(re.getInt(1));
                level.setName(re.getString(2));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return level;
    }

    /**
     * 根据对应的ID查询权限名称
     * */
    public String selectLevelNameById(int id){
        String  name = null;
        String sql = "SELECT `name` FROM `level` WHERE `id`=?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setInt(1,id);
            re = st.executeQuery();
            while(re.next()){
               name = re.getString(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
    * 查询所有的权限信息
    * */
    public List<Level> selectAllLevel(){
        List<Level> list = new ArrayList<>();
        String sql = "SELECT `id`,`name` FROM `level`";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            re = st.executeQuery();
            while(re.next()){
                Level level = new Level();
                level.setId(re.getInt(1));
                level.setName(re.getString(2));
                list.add(level);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
