package com.mango.final_mango.servlets.Membership_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mango.final_mango.dao.Commons;

public class MembershipWithDB {
    // 회원가입 insert
    public void insertMember(MembershipBean bean) {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        
        // 습관적으로 query 이어지는 뒷 부분에 스페이스바 하나 넣어주기
        String query = "INSERT INTO SURVEYOR (USER_ID, NAME, BIRTH_DATE, PASSWORD, PHONE) "+
                      "VALUE ('"+bean.getUSER_ID()+"', '"+bean.getNAME()+"', '"+bean.getBIRTH_DATE()+"', '"+bean.getPASSWORD()+"', '"+bean.getPHONE()+"')";
        
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 아이디 중복 체크
    public boolean idCheck(String user_id){
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM SURVEYOR WHERE USER_ID='"+user_id+"'";

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(query);
            
            // 아이디가 이미 있으면 false 없으면 true
            if(resultSet.next()){
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
