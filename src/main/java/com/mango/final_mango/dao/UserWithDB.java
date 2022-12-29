package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class UserWithDB {
    //회원 정보 출력
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
}
