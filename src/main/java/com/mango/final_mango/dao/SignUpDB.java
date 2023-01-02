package com.mango.final_mango.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SignUpDB {
    public static void setUserData(HashMap<String, Object> userData) throws SQLException {
        
        // DB 연결
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        HashMap<String, Object> userDataInfo = new HashMap<>();

        if(userData.get("NAME")!= null) {
            userDataInfo.put("USER_ID", (String)userData.get("USER_ID"));
            userDataInfo.put("PASSWORD", (String)userData.get("PASSWORD"));
            userDataInfo.put("NAME", (String)userData.get("NAME"));
            userDataInfo.put("BIRTH_DATE", (String)userData.get("BIRTH_DATE"));
            userDataInfo.put("PHONE", (String)userData.get("PHONE"));

            String query = "INSERT INTO USERDATA (USER_ID, PASSWORD, NAME, BIRTH_DATE, PHONE) VALUES ('"+ userDataInfo.get("USER_ID")+"', '"+ userDataInfo.get("PASSWORD")+"', '"+ userDataInfo.get("NAME")+"', '"+ userDataInfo.get("BIRTH_DATE")+"', '"+ userDataInfo.get("PHONE")+"');";

            statement.executeUpdate(query);
        }
    }

    }

