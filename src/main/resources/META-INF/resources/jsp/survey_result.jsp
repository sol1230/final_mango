<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SurveyResult</title>
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
     ArrayList<HashMap> question_list = (ArrayList<HashMap>)request.getAttribute("question_list");
    ArrayList<HashMap> answers_list = (ArrayList<HashMap>)request.getAttribute("answers_list");
    String userName = (String) request.getAttribute("userName");
  %>
    <div class="container pb-5">
    <%@ include file="header.jsp" %>
     
    
      <main class="mt-5 p-1">
        <div class="row" style="margin-top: 8%">
          <div class="ms-2" style="width: 8rem">
          <form action="/survey/surveyResultServlets" method="get">
            <a
              href="#modalTarget02"
              class="btn btn-success opacity-75 mb-2 text-middle p-3"
              style="width: 6.5rem; height: 4rem"
              data-bs-toggle="modal"
              >설문 조사</a
            >
            <div class="modal fade" id="modalTarget02">
              <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                  <div class="modal-body">이미 설문을 제출 하셨습니다.</div>
                  <div class="modal-footer">
                    <button class="btn btn-secondary" data-bs-dismiss="modal">
                      Close
                    </button>
                  </div>
                </div>
              </div>
            </div>

            <a href="/survey/surveyResultServlets"
              class="btn btn-success opacity-75"
              style="width: rem; height: 4rem"
            >
              설문 결과 조회
            </a>
          </div>
          <%-- result --%>
          <div class="col d-flex justify-content-center mt-5">
            <table class="table text-center" style="width: 90%">
              <thead>
                <tr class="table-light">
                  <th>설문자 명</th>
                    <%
                      for(int i = 0; i< question_list.size(); i++){
                        HashMap<String,Object> question = question_list.get(i);
                    %>
                  <th><%= question.get("QUESTION_LIST") %></th>
                </tr>
                 <%     } %>
              </thead>
              <tbody>
                <tr>
                <td><%= userName %>
                <%
                  for(int j = 0; j <answers_list.size(); j++){
                    HashMap<String, Object> answers = answers_list.get(ㅓ);
                %>
                  <td><%= answers.get("ANSWER_UID") %></td>
                </tr>
              <%    } %>
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
