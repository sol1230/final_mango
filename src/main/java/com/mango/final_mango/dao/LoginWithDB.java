package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginWithDB {
    public ArrayList<HashMap> getLoginDB() throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM SURVEYOR "+
                        "WHERE USER_ID='U1' AND PASSWORD='1234'";

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
}
