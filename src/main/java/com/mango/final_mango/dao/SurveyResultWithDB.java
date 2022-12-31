package com.mango.final_mango.dao;

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

    String query = "SELECT * FROM SURVEYOR " + "ORDER BY USER_ID";

    ResultSet resultSet = statement.executeQuery(query);

    ArrayList<HashMap> userName_list = new ArrayList<>();
    HashMap<String, Object> userName = null;
    while (resultSet.next()) {
      userName = new HashMap<>();
      userName.put("NAME", resultSet.getString("NAME"));

      userName_list.add(userName);
    }
    return userName_list;
  }

  // 답변 결과 출력
  public ArrayList<HashMap> getStatistics1() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT * FROM USERS_ANSWER " +
      "INNER JOIN QUESTION ON QUESTION.QUESTION_UID = USERS_ANSWER.QUESTION_UID " +
      "INNER JOIN ANSWER ON ANSWER.ANSWER_UID = USERS_ANSWER.ANSWER_UID " +
      "ORDER BY USER_ID, QUESTION.QUESTION_UID ";

    ResultSet resultSet = statement.executeQuery(query);
    ArrayList<HashMap> statistics1_list = new ArrayList<>();
    HashMap<String, Object> statistics1 = null;
    while (resultSet.next()) {
      statistics1 = new HashMap<>();
      statistics1.put("USER_ID", resultSet.getString("USER_ID"));
      statistics1.put("QUESTION_UID", resultSet.getString("QUESTION_UID"));
      statistics1.put("QUESTION_LIST", resultSet.getString("QUESTION_LIST"));
      statistics1.put("ANSWER_UID", resultSet.getString("ANSWER_UID"));
      statistics1.put("ANSWER_LIST", resultSet.getString("ANSWER_LIST"));

      statistics1_list.add(statistics1);
    }

    return statistics1_list;
  }

  //   public ArrayList<HashMap> getStatistics1_2() throws SQLException {
  //     Commons commons = new Commons();
  //     Statement statement = commons.getStatement();

  //     String query =
  //       "SELECT * FROM USERS_ANSWER " +
  //       "INNER JOIN QUESTION ON QUESTION.QUESTION_UID = USERS_ANSWER.QUESTION_UID " +
  //       "INNER JOIN ANSWER ON ANSWER.ANSWER_UID = USERS_ANSWER.ANSWER_UID " +
  //       "ORDER BY USER_ID, QUESTION.QUESTION_UID ";

  //     ResultSet resultSet = statement.executeQuery(query);

  //     ArrayList<HashMap> statistics_list = new ArrayList<>();
  //     HashMap<String, Object> statistics = null;
  //     while (resultSet.next()) {
  //       statistics = new HashMap<>();
  //       statistics.put("USER_ID", resultSet.getString("USER_ID"));
  //       statistics.put("ANSWER_UID", resultSet.getString("ANSWER_UID"));
  //       statistics.put("ANSWER_LIST", resultSet.getString("ANSWER_LIST"));

  //       statistics_list.add(statistics);
  //     }
  //     return statistics_list;
  //   }

  // 질문별 총 답변 수
  public ArrayList<HashMap> getStatistics2() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT USERS_ANSWER.QUESTION_UID, QUESTION_LIST, USERS_ANSWER.ANSWER_UID, ANSWER_LIST, count(USERS_ANSWER.ANSWER_UID) " +
      "AS nums FROM USERS_ANSWER " +
      "INNER JOIN QUESTION ON QUESTION.QUESTION_UID = USERS_ANSWER.QUESTION_UID " +
      "INNER JOIN ANSWER ON ANSWER.ANSWER_UID = USERS_ANSWER.ANSWER_UID " +
      "GROUP BY USERS_ANSWER.QUESTION_UID, USERS_ANSWER.ANSWER_UID " +
      "ORDER BY USERS_ANSWER.QUESTION_UID ";

    ResultSet resultSet = statement.executeQuery(query);
    ArrayList<HashMap> statistics_list = new ArrayList<>();
    HashMap<String, Object> statistics = null;
    while (resultSet.next()) {
      statistics = new HashMap<>();
      statistics.put("QUESTION_UID", resultSet.getString("QUESTION_UID"));
      statistics.put("QUESTION_LIST", resultSet.getString("QUESTION_LIST"));
      statistics.put("ANSWER_UID", resultSet.getString("ANSWER_UID"));
      statistics.put("ANSWER_LIST", resultSet.getString("ANSWER_LIST"));
      statistics.put("nums", resultSet.getString("nums"));

      statistics_list.add(statistics);
    }
    return statistics_list;
  }
}
