package com.dao;

import com.beans.Contacts;
import com.beans.User;
import com.utils.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactsDao {
    private Connection conn=null;
    private PreparedStatement st=null;
    private ResultSet re=null;
    /**
     * 增加反馈
     * */
    public int insertContactsByObject(Contacts contacts){
        int count = 0;
        String sql = "INSERT INTO `contacts`(`Username`,`Email`,`Phone`,`Qq`,`Title`,`Content`,`ip`,`tjdate`) VALUES(?,?,?,?,?,?,?,?)";

        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setString(1,contacts.getUsername());
            st.setString(2,contacts.getEmail());
            st.setString(3,contacts.getPhone());
            st.setString(4,contacts.getQq());
            st.setString(5,contacts.getTitle());
            st.setString(6,contacts.getContent());
            st.setString(7,contacts.getIp());
            st.setLong(8,System.currentTimeMillis());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 判断该邮箱是否存在
     * */
    public boolean isselectUserByUsermail(String email){
        String sql = "SELECT 1 FROM contacts WHERE email=?";
        boolean a=false;
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setString(1,email);
            re = st.executeQuery();
            if(re.next()){
               a=true;
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
    /**
     * 判断该手机是否存在
     * */
    public boolean isselectUserByphone(String phone){
        String sql = "SELECT 1 FROM contacts WHERE email=?";
        boolean a=false;
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setString(1,phone);
            re = st.executeQuery();
            if(re.next()){
                a=true;
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
    /**
     * 模糊查询用户
     * */
    public List<Contacts> selectLikeContacts(int begin, int end, String type, String value){
        List<Contacts> list = new ArrayList<Contacts>();
        String sql = "SELECT * FROM Contacts WHERE "+type+" LIKE ? ORDER BY id DESC LIMIT ?,?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setString(1,"%"+value+"%");
            st.setInt(2,begin);
            st.setInt(3,end);
            re = st.executeQuery();
            while(re.next()){
                Contacts contacts = new Contacts();
                contacts.setId(re.getInt(1));
                contacts.setUsername(re.getString(2));
                contacts.setEmail(re.getString(3));
                contacts.setPhone(re.getString(4));
                contacts.setQq(re.getString(5));
                contacts.setTitle(re.getString(6));
                contacts.setContent(re.getString(7));
                contacts.setIp(re.getString(8));
                contacts.setTjdate(re.getLong(9));
                list.add(contacts);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询所有用户
     * */
    public List<Contacts> selectAllContacts(int begin, int end){
        List<Contacts> list = new ArrayList<Contacts>();
        String sql = "SELECT * FROM Contacts ORDER BY id ASC LIMIT ?,?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setInt(1,begin);
            st.setInt(2,end);
            re = st.executeQuery();
            while(re.next()){
                Contacts contacts = new Contacts();
                contacts.setId(re.getInt(1));
                contacts.setUsername(re.getString(2));
                contacts.setEmail(re.getString(3));
                contacts.setPhone(re.getString(4));
                contacts.setQq(re.getString(5));
                contacts.setTitle(re.getString(6));
                contacts.setContent(re.getString(7));
                contacts.setIp(re.getString(8));
                contacts.setTjdate(re.getLong(9));
                list.add(contacts);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 根据用户名查找用户
     * */
    public Contacts selectUserByUsername(String username){
        Contacts contacts = null;
        String sql = "SELECT * FROM user WHERE username=?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setString(1,username);
            re = st.executeQuery();
            while(re.next()){
                contacts = new Contacts();
                contacts.setId(re.getInt(1));
                contacts.setUsername(re.getString(2));
                contacts.setEmail(re.getString(3));
                contacts.setPhone(re.getString(4));
                contacts.setQq(re.getString(5));
                contacts.setTitle(re.getString(6));
                contacts.setContent(re.getString(7));
                contacts.setIp(re.getString(8));
                contacts.setTjdate(re.getInt(9));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    /**
     * 根据邮箱查找用户
     * */
    public User selectContactsByUsermail(String usermail){
        User user = null;
        String sql = "SELECT id,username,usermail,password,usergroup,created,updated,lastlogin,grava,ip FROM user WHERE usermail=?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setString(1,usermail);
            re = st.executeQuery();
            while(re.next()){
                user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setUsermail(re.getString(3));
                user.setPassword(re.getString(4));
                user.setUsergroup(re.getInt(5));
                user.setCreated(re.getLong(6));
                user.setUpdated(re.getLong(7));
                user.setLastlogin(re.getLong(8));
                user.setGrava(re.getString(9));
                user.setIp(re.getString(10));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 根据邮箱查找用户
     * */
    public User selectUserByUsermailDisSelf(String usermail,int id){
        User user = null;
        String sql = "SELECT id,username,usermail,password,usergroup,created,updated,lastlogin,grava,ip FROM user WHERE usermail=? AND `id`!=?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setString(1,usermail);
            st.setInt(2,id);
            re = st.executeQuery();
            while(re.next()){
                user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setUsermail(re.getString(3));
                user.setPassword(re.getString(4));
                user.setUsergroup(re.getInt(5));
                user.setCreated(re.getLong(6));
                user.setUpdated(re.getLong(7));
                user.setLastlogin(re.getLong(8));
                user.setGrava(re.getString(9));
                user.setIp(re.getString(10));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 根据ID查找用户
     * */
    public Contacts  selectContactsById(int id){
        Contacts contacts = null;

        String sql = "SELECT * FROM Contacts WHERE id=?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setInt(1,id);
            re = st.executeQuery();
            while(re.next()){
                contacts = new Contacts();
                contacts.setId(re.getInt(1));
                contacts.setUsername(re.getString(2));
                contacts.setEmail(re.getString(3));
                contacts.setPhone(re.getString(4));
                contacts.setQq(re.getString(5));
                contacts.setTitle(re.getString(6));
                contacts.setContent(re.getString(7));
                contacts.setIp(re.getString(8));
                contacts.setTjdate(re.getLong(9));

            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    /*
   * 获取所有用户数量
   * */
    public int getContactsCount(){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `Contacts`";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            re = st.executeQuery();
            while(re.next()){
                count = re.getInt(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    /*
 * 获取所有模糊搜索用户数量
 * */
    public int getLikeContactsCount(String type,String value){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `Contacts` WHERE `"+type+"` LIKE ?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setString(1,"%"+value+"%");
            re = st.executeQuery();
            while(re.next()){
                count = re.getInt(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    /**
     * 删除用户组
     * */
    public int deleteContactsByObject(int id){
        int count = 0;
        String sql = "DELETE FROM `Contacts` WHERE `id`=?";
        try {
            conn = DataBase.getConn();
            st = conn.prepareStatement(sql);
            st.setInt(1,id);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
