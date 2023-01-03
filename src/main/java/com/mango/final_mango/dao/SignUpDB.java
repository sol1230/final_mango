package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SignUpDB {
    public static void setSurveyor(HashMap<String, Object> surveyor) throws SQLException {
        
        // DB 연결
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        HashMap<String, Object> userDataInfo = new HashMap<>();

        if(surveyor.get("NAME")!= null) {
            userDataInfo.put("USER_ID", (String)surveyor.get("USER_ID"));
            userDataInfo.put("NAME", (String)surveyor.get("NAME"));
            userDataInfo.put("BIRTH_DATE", (String)surveyor.get("BIRTH_DATE"));
            userDataInfo.put("PASSWORD", (String)surveyor.get("PASSWORD"));
            userDataInfo.put("PHONE", (String)surveyor.get("PHONE"));

            String query = "INSERT INTO SURVEYOR (USER_ID, NAME, BIRTH_DATE, PASSWORD, PHONE) VALUES ('"+ userDataInfo.get("USER_ID")+"', '"+ userDataInfo.get("NAME")+"', '"+ userDataInfo.get("BIRTH_DATE")+"', '"+ userDataInfo.get("PASSWORD")+"', '"+ userDataInfo.get("PHONE")+"');";

            
            statement.executeUpdate(query);
        }
    }

        public int checkId(String checkID) {
            // 중복 ID 체크
            int result = -1;
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
    
            String query = "SELECT * FROM USERS_LIST " +
            "WHERE ID = '" + checkID + "'";
    
            ResultSet resultSet;
            try {
                resultSet = statement.executeQuery(query);
                if(resultSet.next()) {
                    result = 0;
                } else {
                    result = 1;
                }
                // 중복 있을 경우 0, 중복 없을 경우 1, 오류 -1
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
    }
}

