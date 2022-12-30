package com.mango.final_mango.dao;

import java.sql.Statement;
import java.util.HashMap;

// 설문자별 답변 결과
public class StstisticsWithDB {

  public HashMap<String, Object> getStatistics1() {
    Commons commons = new Commons();
    Statement statement = commons.getStatement();

    // 이름 출력
    String query = "SELECT * FROM SURVEYOR";

    // 답변 출력
    String answerQuery = "SELECT * FROM USERS_ANSWER";

    return null;
  }
}
