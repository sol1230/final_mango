<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>statistics_1</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/css/font.css" />
  </head>
  <body class="bg-light">
  <%
  ArrayList<HashMap> userName_list = (ArrayList<HashMap>)request.getAttribute("userName_list"); 
  ArrayList<HashMap> statistics1_list = (ArrayList<HashMap>)request.getAttribute("statistics1_list");

  %>
    <div class="container pb-5">
      <%@ include file="header.jsp" %>

      <main class="mt-5 p-1">
        <div class="row" style="margin-top: 8%">
          <div class="ms-2 me-5" style="width: 8rem">
          <form action="/result/statistics1Servlets" method="post">
            <a href="/jsp/statistics_1.jsp" class="btn btn-success opacity-75 mb-2" style="width: 6.5rem; height: 4rem">설문자별 답변 결과</a>
           
            <a href="/jsp/statistics_2.jsp" class="btn btn-success opacity-75" style="width: rem; height: 4rem">질문별 총 답변수</a>
          </div>
          <div class="col mt-5">
            <table class="table text-center" style="width: 90%">
              <thead>
                <tr class="table-success opacity-75">
                  <th>설문자 명</th>
                  <th>설문 1</th>
                  <th>설문 2</th>
                  <th>설문 3</th>
                  <th>설문 4</th>
                  <th>설문 5</th>
                </tr>
              </thead>
              <tbody>
              <%-- 통계 출력 --%>
              <% 
                for(int i = 0; i < userName_list.size(); i++){
                HashMap<String, Object> usersName = userName_list.get(i);
              %>
                <tr class="table-light">
                  <td><%= usersName.get("NAME") %></td>
                  <%
                    for(int j = 0; j < statistics1_list.size(); j++){
                      HashMap<String,Object> statistics1 = statistics1_list.get(j);
                  %>
                 <td><%= statistics1.get("ANSWER_UID") %></td>
                <%  } %>
                </tr>
             <% } %>
                
              </tbody>
            </table>
            </form>
          </div>
        </div>
      </main>
    </div>
    <hr />

    <%@ include file="footer.jsp" %>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
