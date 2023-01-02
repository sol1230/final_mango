package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SurveyResultWithDB {

  // 내 설문 조회
  // 설문 완료 사용자 확인
  public boolean checkUser(String user_id) throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT COUNT(USER_ID) AS COUNT FROM USERS_ANSWER WHERE USER_ID = '" +
      user_id +
      "'";
    ResultSet resultSet = statement.executeQuery(query);
    String count = null;
    while (resultSet.next()) {
      count = resultSet.getString("COUNT");
    }
    int count1 = Integer.parseInt(count);
    boolean checkUser;
    if (count1 > 0) {
      checkUser = true;
    } else {
      checkUser = false;
    }
    return checkUser;
  }

  public ArrayList<HashMap> getmySurvey(String user_id) throws SQLException {
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

  public HashMap<String, Object> getUserName(String user_id)
    throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT * FORM SURVEYOR " + "WHERE USER_ID = '" + user_id + "'";

    ResultSet resultSet = statement.executeQuery(query);
    HashMap<String, Object> userName = null;
    while (resultSet.next()) {
      userName = new HashMap<>();
      userName.put("NAME", resultSet.getString("NAME"));
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

  // 답 출력
  public ArrayList<HashMap> getAnswer(String user_id) throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT * FROM SURVEYOR INNER JOIN USERS_ANSWER " +
      "ON SURVEYOR.USER_ID = USERS_ANSWER.USER_ID INNER JOIN ANSWER " +
      "ON USERS_ANSWER.ANSWER_UID = ANSWER.ANSWER_UID WHERE SURVEYOR.USER_ID='" +
      user_id +
      "' " +
      "ORDER BY USERS_ANSWER.QUESTION_UID";

    ResultSet resultSet = statement.executeQuery(query);

    ArrayList<HashMap> answers_list = new ArrayList<>();
    HashMap<String, Object> answers = null;

    while (resultSet.next()) {
      answers = new HashMap<>();
      answers.put("NAME", resultSet.getString("NAME"));
      answers.put("USER_ID", resultSet.getString("USER_ID"));
      answers.put("ANSWER_LIST", resultSet.getString("ANSWER_LIST"));

      answers_list.add(answers);
    }

    return answers_list;
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
      statistics.put("E1", resultSet.getInt("E1"));
      statistics.put("E2", resultSet.getInt("E2"));
      statistics.put("E3", resultSet.getInt("E3"));
      statistics.put("E4", resultSet.getInt("E4"));

      statistics_list.add(statistics);
    }
    return statistics_list;
  }
}
