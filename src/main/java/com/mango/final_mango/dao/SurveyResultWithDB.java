package com.mango.final_mango.dao;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SurveyResultWithDB {
  String user_id; //session

  // 내 설문 조회
  public ArrayList<HashMap> getmySurvey() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT * FROM USERS_ANSWER " +
      "WHERE USER_ID = '" +
      user_id +
      "'" +
      "ORDER BY QUESTION_UID ";

    ResultSet resultSet = statement.executeQuery(query);
    ArrayList<HashMap> answers = new ArrayList<>();
    HashMap<String, Object> userAnswer = null;
    while (resultSet.next()) {
      userAnswer = new HashMap<>();
      userAnswer.put("USER_ID", resultSet.getString("USER_ID"));
      userAnswer.put("QUESTION_UID", resultSet.getString("QUESTION_UID"));
      userAnswer.put("ANSWER_UID", resultSet.getString("ANSWER_UID"));

      answers.add(userAnswer);
    }
    return answers;
  }

  public String getUserName() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT * FORM SURVEYOR " + "WHERE USER_ID = '" + user_id + "'";

    String userName = "";
    try {
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        userName = resultSet.getString("NAME");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return userName;
  }

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

  // 설문자별 답변 결과
  // 이름 출력
  public ArrayList<HashMap> getSurveyorName() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "SELECT * FROM SURVEYOR ";

    ResultSet resultSet = statement.executeQuery(query);

    ArrayList<HashMap> userName_list = new ArrayList<>();
    HashMap<String, Object> userName = null;
    while (resultSet.next()) {
      userName = new HashMap<>();
      userName.put("USER_ID", resultSet.getString("USER_ID"));
      userName.put("NAME", resultSet.getString("NAME"));
      userName.put("BIRTH_DATE", resultSet.getString("BIRTH_DATE"));
      userName.put("PASSWORD", resultSet.getString("PASSWORD"));
      userName.put("PHONE", resultSet.getString("PHONE"));

      userName_list.add(userName);
    }
    return userName_list;
  }

  // 답변 결과 출력

  public ArrayList<HashMap> getStatistics1_2() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "SELECT * FROM USERS_ANSWER ";

    ResultSet resultSet = statement.executeQuery(query);

    ArrayList<HashMap> statistics1_list = new ArrayList<>();
    HashMap<String, Object> statistics1 = null;
    while (resultSet.next()) {
      statistics1 = new HashMap<>();
      statistics1.put("USER_ID", resultSet.getString("USER_ID"));
      statistics1.put("ANSWER_UID", resultSet.getString("ANSWER_UID"));
      statistics1.put("QUESTION_UID", resultSet.getString("QUESTION_UID"));

      statistics1_list.add(statistics1);
    }
    return statistics1_list;
  }

  // 질문별 총 답변 수
  public ArrayList<HashMap> getStatistics2() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT QUESTION_UID, count(case when ANSWER_UID = 'E1' THEN 1 END) AS 'E1' " +
      ", count(case when ANSWER_UID = 'E2' THEN 1 END) AS 'E2' " +
      ", count(case when ANSWER_UID = 'E3' THEN 1 END) AS 'E3' " +
      ", count(case when ANSWER_UID = 'E4' THEN 1 END) AS 'E4' " +
      "FROM USERS_ANSWER GROUP BY QUESTION_UID";

    ResultSet resultSet = statement.executeQuery(query);
    ArrayList<HashMap> statistics_list = new ArrayList<>();
    HashMap<String, Object> statistics = null;
    while (resultSet.next()) {
      statistics = new HashMap<>();
      String E1 = resultSet.getString("E1");
      String E2 = resultSet.getString("E2");
      String E3 = resultSet.getString("E3");
      String E4 = resultSet.getString("E4");
      statistics.put("QUESTION_UID", resultSet.getString("QUESTION_UID"));
      statistics.put("ANSWER_UID", resultSet.getString("ANSWER_UID"));

      statistics_list.add(statistics);
    }
    return statistics_list;
  }
}
