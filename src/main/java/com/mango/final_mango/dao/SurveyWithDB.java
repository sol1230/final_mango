package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SurveyWithDB {

  // 질문 출력
  public HashMap<String, Object> getQuestion(String question_uid)
    throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT * FROM QUESTION " +
      " WHERE QUESTION_UID = '" +
      question_uid +
      "'";

    ResultSet resultSet = statement.executeQuery(query);

    HashMap<String, Object> question = null;
    while (resultSet.next()) {
      question = new HashMap<>();
      question.put("QUESTION_LIST", resultSet.getString("QUESTION_LIST"));
      question.put("QUESTION_UID", resultSet.getString("QUESTIONS_UID"));
    }
    return question;
  }

  // 답 출력
  public ArrayList<HashMap> getAnswer(String question_uid) throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query =
      "SELECT ANSWER.ANSWER_UID, ANSWER.ANSWER_LIST " +
      "FROM SURVEY INNER JOIN ANSWER " +
      "ON SURVEY.ANSWER_UID = ANSWER.ANSWER_UID " +
      "WHERE QUESTION_UID = '" +
      question_uid +
      "'" +
      "ORDER BY ANSWER_UID";

    ResultSet resultSet = statement.executeQuery(query);

    ArrayList<HashMap> answers = new ArrayList<HashMap>();
    while (resultSet.next()) {
      HashMap<String, Object> answers_list = new HashMap<>();
      answers_list.put("ANSWER_LIST", resultSet.getString("ANSWER_LIST"));
      answers_list.put("ANSWER_UID", resultSet.getString("ANSWER_UID"));

      answers.add(answers_list);
    }

    return answers;
  }
}
