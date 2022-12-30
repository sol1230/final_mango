package com.mango.final_mango.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SurveyWithDB {

  // 질문 출력
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
  public ArrayList<HashMap> getAnswer() throws SQLException {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    String query = "SELECT * FROM ANSWER";

    ResultSet resultSet = statement.executeQuery(query);
    ArrayList<HashMap> answers_list = new ArrayList<>();
    HashMap<String, Object> answers = null;

    while (resultSet.next()) {
      answers = new HashMap<>();
      answers.put("ANSWER_UID", resultSet.getString("ANSWER_UID"));
      answers.put("ANSWER_LIST", resultSet.getString("ANSWER_LIST"));

      answers_list.add(answers);
    }

    return answers_list;
  }
}
