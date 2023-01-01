package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class UserWithDB {
    // 회원 정보 출력
  public ArrayList<HashMap> getUser(String userId) throws SQLException{
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "SELECT * FROM SURVEYOR";

    ResultSet resultSet = statement.executeQuery(query);
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

  // 회원 검색
  public ArrayList<HashMap> getUserSearch(String keyWord, String keyField) throws SQLException{
    Commons commons = new Commons();
    Statement statement = commons.getStatement();
    
    String query = "SELECT * FROM SURVEYOR " +
                    "WHERE "+ keyField +" LIKE '%"+ keyWord + "%' ORDER BY USER_ID";
    
    ResultSet resultSet = statement.executeQuery(query);
    ArrayList<HashMap> search_list = new ArrayList<>();
    while(resultSet.next()){
        HashMap<String, Object> search = new HashMap<String, Object>();
        search.put("USER_ID", resultSet.getString("USER_ID"));
        search.put("NAME", resultSet.getString("NAME"));
        search.put("BIRTH_DATE", resultSet.getString("BIRTH_DATE"));
        search.put("PHONE", resultSet.getString("PHONE"));

        search_list.add(search);
    }
    return search_list;
  }

  // 회원 정보 삭제
}
