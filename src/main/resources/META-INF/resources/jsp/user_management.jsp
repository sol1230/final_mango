<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/css/font.css" />
  </head>
  <body class="bg-light">
    <div class="container pb-5">
      <%@ include file="header.jsp" %>

      <main class="mt-5 p-1">
          <div class="mt-5">
            <div class="fs-3 text-center text-success opacity-75 mb-3">회원관리 페이지</div>
            <form action="/admin/userList">
              <div class="d-flex input-group w-50">
                <select class="form-select" name="keyField" id="">
                  <option value="NAME">이름</option>
                  <option value="BIRTH_DATE">생년월일</option>
                  <option value="PHONE">전화번호</option>
                </select>
                <input class="form-control w-50" type="text" name="keyWord" id="">
                <button type="submit" class="btn btn-success opacity-75">검색</button>
              </div>
            </form>
            <table class="table text-center mt-3">
              <thead>
                <tr class="table-success opacity-75">
                  <th>아이디</th>
                  <th>이름</th>
                  <th>생년월일</th>
                  <th>전화번호</th>
                  <th>설문조사 결과 조회</th>
                  <th>회원수정</th>
                </tr>
              </thead>
              <tbody class="align-middle">
                  <% 
                      ArrayList<HashMap> user_list = null; 
                      user_list = (ArrayList<HashMap>) request.getAttribute("user_list");
                  %>
                  <%
                      for(int i = 0; i < user_list.size(); i++){
                          HashMap<String, Object> user = user_list.get(i);
                  %>
                <tr>
                <% String user_id = (String)user.get("USER_ID");
                    String name = (String)user.get("NAME");
                    String birth_date = (String)user.get("BIRTH_DATE");
                    String phone = (String)user.get("PHONE"); %>
                <form action="/admin/userManagementServlet" method="post">
                  <th><%= user_id %></th>
                  <th><%= name %></th>
                  <th><%= birth_date %></th>
                  <th><%= phone %></th>
                  <th>
                      <input type="submit" class="btn btn-outline-secondary opacity-75" value="보기"/>
                      <input type="hidden" name="user_id" value="<%= user_id %>"/>
                  </th>
                </form>
                  <th>
                    <div class="d-flex justify-content-center">
                      <form action="/admin/userManagementServlet?name=modify" method="post">  
                        <%-- <a href="/admin/userManagementServlet?name=modify" class="btn btn-outline-secondary opacity-75">수정</a> --%>
                        <input type="submit" class="btn btn-outline-secondary opacity-75" value="수정"/>
                        <%-- <input type="hidden" name="modify" value="modify"/> --%>
                        <input type="hidden" name="user_id" value="<%= user_id %>"/>
                        <input type="hidden" name="user_name" value="<%= name %>"/>
                        <input type="hidden" name="birth_date" value="<%= birth_date %>"/>
                        <input type="hidden" name="phone" value="<%= phone %>"/>
                      </form>
                      <form class="ms-1" action="/admin/userManagementServlet?name=delete" method="post">
                          <input type="submit" class="btn btn-outline-danger" value="삭제" onclick="if(!confirm('정말로 삭제하시겠습니까?')) return false"/>
                          <input type="hidden" name="user_id" value="<%= user_id %>"/>
                          <%-- <a href="/admin/userManagementServlet?name=delete" class="btn btn-outline-danger" onclick="if(!confirm('정말로 삭제하시겠습니까?')) return false">삭제</a> --%>
                          <%-- <input type="hidden" name="delete" value="<%= user_id %>"/> --%>
                          <%-- <input type="submit" name="modify_button" class="btn btn-secondary opacity-75" value="수정"/> --%>
                          <%-- <input type="hidden" name="modify" value="<%= user_id %>"/> --%>
                      </form>
                    </div>
                  </th>
                  <%-- <th><input name="<%= user_id %>" id="<%= user_id %>" class="btn btn-secondary opacity-75" type="submit" value="보기" /></th> --%>
                  <%-- <th><a href="/admin/userManagementServlet?user_id=<%= user_id %>&name=<%= name %>" class="btn btn-secondary opacity-75">보기</a></th> --%>
                </tr>
                <% } %>
              </tbody>
            </table>
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
