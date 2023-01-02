package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class UserWithDB {
    // 전체 회원 정보 출력
    public ArrayList<HashMap> getUser(String userId, String keyWord, String keyField) throws SQLException{
      Commons commons = new Commons();
      Statement statement = commons.getStatement();
  
      // admin을 제외한 회원 전체 목록 쿼리
      String query = "SELECT * FROM SURVEYOR WHERE NOT USER_ID='admin'";
      // 검색한 회원 목록 쿼리
      String query2 = "SELECT * FROM SURVEYOR " +
                      "WHERE "+ keyField +" LIKE '%"+ keyWord + "%' AND NOT USER_ID='admin' ORDER BY USER_ID";
  
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

  // admin에서 확인할 회원 설문 답변 출력
  public ArrayList<HashMap> getSurveyorAnswer(String user_id) throws SQLException{
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "SELECT * FROM SURVEYOR INNER JOIN USERS_ANSWER " +
                    "ON SURVEYOR.USER_ID = USERS_ANSWER.USER_ID INNER JOIN ANSWER " +
                    "ON USERS_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE SURVEYOR.USER_ID='"+user_id+"' " +
                    "ORDER BY USERS_ANSWER.QUESTION_UID";

    ResultSet resultSet = statement.executeQuery(query);

    ArrayList<HashMap> surveyor_answerList = new ArrayList<>();
    HashMap<String, Object> surveyor_answer = null;
    while(resultSet.next()){
      surveyor_answer = new HashMap<>();
      surveyor_answer.put("NAME", resultSet.getString("NAME"));
      surveyor_answer.put("USER_ID", resultSet.getString("USER_ID"));
      surveyor_answer.put("ANSWER_LIST", resultSet.getString("ANSWER_LIST"));

      surveyor_answerList.add(surveyor_answer);
    }
    return surveyor_answerList;
  }

  // 설문 질문 출력
  public ArrayList<HashMap> getQuestion() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "SELECT * FROM QUESTION";

    ResultSet resultSet = statement.executeQuery(query);

    ArrayList<HashMap> question_list = new ArrayList<>();
    HashMap<String, Object> question = null;
    while (resultSet.next()) {
      question = new HashMap<>();
      question.put("QUESTION_UID", resultSet.getString("QUESTION_UID"));
      question.put("QUESTION_LIST", resultSet.getString("QUESTION_LIST"));

      question_list.add(question);
    }
    return question_list;
  }

  // uid를 통한 회원 정보 출력
  public HashMap<String, Object> getUserWithUid(String user_id) throws SQLException{
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "SELECT * FROM SURVEYOR WHERE USER_ID='"+user_id+"'";

    ResultSet resultSet = statement.executeQuery(query);
    HashMap<String, Object> userWithUid = null;
    while(resultSet.next()){
      userWithUid = new HashMap<String, Object>();
      userWithUid.put("USER_ID", resultSet.getString("USER_ID"));
      userWithUid.put("NAME", resultSet.getString("NAME"));
      userWithUid.put("BIRTH_DATE", resultSet.getString("BIRTH_DATE"));
      userWithUid.put("PHONE", resultSet.getString("PHONE"));

    }
    return userWithUid;
  }

  // 회원 삭제
  public void deleteUserInfo(String user_id){
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "DELETE FROM SURVEYOR WHERE USER_ID='"+user_id+"'";

    try {
      statement.execute(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // 회원 정보 수정
  public void modifyUserInfo(String user_id, String name, String birth_date, String phone){
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "UPDATE SURVEYOR SET NAME='"+name+"', BIRTH_DATE='"+birth_date+"', PHONE='"+phone+"' WHERE USER_ID='"+user_id+"'";

    try {
      statement.execute(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
