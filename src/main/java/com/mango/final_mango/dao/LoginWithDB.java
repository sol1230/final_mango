package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginWithDB {
    public ArrayList<HashMap> getLoginDB(String user_id, String password) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM SURVEYOR "+
                        "WHERE USER_ID='"+user_id+"' AND PASSWORD='"+password+"'";

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<HashMap> login_list = new ArrayList<>();
        while(resultSet.next()){
            HashMap<String, Object> login = new HashMap<>();
            login.put("USER_ID", resultSet.getString("USER_ID"));
            login.put("NAME", resultSet.getString("NAME"));
            login.put("BIRTH_DATE", resultSet.getString("BIRTH_DATE"));
            login.put("PASSWORD", resultSet.getString("PASSWORD"));
            login.put("PHONE", resultSet.getString("PHONE"));

            login_list.add(login);
        }
        return login_list;
    }

    // 로그인 정보 체크
    public boolean checkLoginDB(String user_id, String password) throws SQLException{
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM SURVEYOR "+
                        "WHERE USER_ID='"+user_id+"' AND PASSWORD='"+password+"'";
                        
        ResultSet resultSet = statement.executeQuery(query);

        // 정보가 있으면 true
        if(resultSet.next()){
            return true;
        }
        return false;
    }

    // 아이디 찾기
    public String findID(String find_id, String phone0, String phone1, String phone2) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM SURVEYOR "+
                        "WHERE NAME='"+find_id+"' AND PHONE='"+phone0+"-"+phone1+"-"+phone2+"'";
                        
        ResultSet resultSet = statement.executeQuery(query);

        String findID = null;
        
        // 정보가 있으면 가져오기
        if(resultSet.next()){
            findID = resultSet.getString("USER_ID");
        } 
        return findID;
    }
    
    // 비밀번호 찾기
    public String findPassword(String user_id, String name) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM SURVEYOR "+
                        "WHERE USER_ID='"+user_id+"' AND NAME='"+name+"'";
                        
        ResultSet resultSet = statement.executeQuery(query);

        String findPassword = null;
        
        // 정보가 있으면 가져오기
        if(resultSet.next()){
            findPassword = resultSet.getString("PASSWORD");
        } 
        return findPassword;
    }
}
