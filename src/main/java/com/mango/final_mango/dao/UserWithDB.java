package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class UserWithDB {
    // 회원 정보 출력
  public ArrayList<HashMap> getUser(String userId, String keyWord, String keyField) throws SQLException{
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    // 회원 전체 목록 쿼리
    String query = "SELECT * FROM SURVEYOR";
    // 검색한 회원 목록 쿼리
    String query2 = "SELECT * FROM SURVEYOR " +
                    "WHERE "+ keyField +" LIKE '%"+ keyWord + "%' ORDER BY USER_ID";

    ResultSet resultSet;
    
    // 검색으로 회원 찾기
    if(keyWord != null) {
      resultSet = statement.executeQuery(query2);
      ArrayList<HashMap> user_list = new ArrayList<>();
      while(resultSet.next()){
        HashMap<String, Object> user = new HashMap<String, Object>();
        user.put("USER_ID", resultSet.getString("USER_ID"));
        user.put("NAME", resultSet.getString("NAME"));
        user.put("BIRTH_DATE", resultSet.getString("BIRTH_DATE"));
        user.put("PHONE", resultSet.getString("PHONE"));

        user_list.add(user);
    }
      return user_list;
    } else { // 전체 회원 목록
      resultSet = statement.executeQuery(query);
      ArrayList<HashMap> user_list = new ArrayList<>();
      while(resultSet.next()){
        HashMap<String, Object> user = new HashMap<String, Object>();
        user.put("USER_ID", resultSet.getString("USER_ID"));
        user.put("NAME", resultSet.getString("NAME"));
        user.put("BIRTH_DATE", resultSet.getString("BIRTH_DATE"));
        user.put("PHONE", resultSet.getString("PHONE"));
  
        user_list.add(user);
      }
      return user_list;
    }
  }
  public ArrayList<HashMap> getUserDelete(String userDelete) throws SQLException{
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "DELETE FROM USERS_ANSWER " +
                    "WHERE USER_ID = 'U4'" +
                    " DELETE FROM SURVEYOR " +
                    "WHERE USER_ID = 'U6'" +
                    " SELECT * FROM SURVEYOR";
    
    ResultSet resultSet = statement.executeQuery(query);

    ArrayList<HashMap> user_delete_list = new ArrayList<>();
    while(resultSet.next()){
      HashMap<String, Object> user_delete = new HashMap<String, Object>();
      user_delete.put("USER_ID", resultSet.getString("USER_ID"));
      user_delete.put("NAME", resultSet.getString("NAME"));
      user_delete.put("BIRTH_DATE", resultSet.getString("BIRTH_DATE"));
      user_delete.put("PHONE", resultSet.getString("PHONE"));

      user_delete_list.add(user_delete);
    }
    return user_delete_list;
  }
}
