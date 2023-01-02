## 💻Servlet - JSP PROJECT

## 🦔반려동물 설문조사

### 프로젝트 기간

2022.12.27 ~ 2023.01.03

## 🔌소스코드

#### 📗이은솔 : 설문 / 통계

1. DB  
   -[survey DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/SurveyWithDB.java)  
   -[survey result DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/SurveyResultWithDB.java)

2. Servlet  
   -[survey start Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/SurveyStart.java)  
   -[survey Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/SurveyServlets.java)  
   -[survey result servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/SurveyServlets.java)  
   -[statistics1 Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/Statistics1Servlet.java)  
   -[statistics2 Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/Statistics2Servlet.java)

#### 📘김소희 : 로그인 / 로그아웃

1. DB  
   -[login DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/LoginWithDB.java)  
   -[login Filter](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/filter/LoginFilter.java)

2. Servlet  
   -[login Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/LoginServlets.java)  
   -[logout Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/LogoutServlets.java)  
   -[Find UserInfo Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/FindUserInfoServlets.java)

#### 📙박찬희 : 회원가입

1. DB  
   -[sign up DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/SignUpDB.java)

2. Servlet  
   -[membership Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/Membership_test/MembershipServlet.java)  
   -[MembershipBean](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/Membership_test/MembershipBean.java)

#### 📕배하선 : 회원관리

1. DB  
   -[User DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/UserWithDB.java)

2. Servlet  
   -[User Management](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/UserManagement.java)

## 📚구현 페이지

-[Page](http://localhost:8080/jsp/a_main.jsp)

## 📹구현 영상

-[Video]()

## 🔋주요 코드
#### 회원 정보 받아오기

```
        <% 
         HashMap<String, Object> userWithUid = (HashMap<String, Object>) request.getAttribute("userWithUid");
         %>
                 <form action="/admin/userManagementServlet" method="post">
                <tr>
                  <% String user_id = (String)userWithUid.get("USER_ID"); %>
                  <th><%= user_id %></th>
                  <th><%= userWithUid.get("NAME") %></th>
                  <th><%= userWithUid.get("BIRTH_DATE") %></th>
                  <th><%= userWithUid.get("PHONE") %></th>
                  <th>
                      <input type="submit" class="btn btn-outline-secondary opacity-75" value="보기"/>
                      <input type="hidden" name="user_id" value="<%= user_id %>"/>
                  </th>
                </form>
```

#### 질문, 답변 받아오기
````
 <% 
                for (int i = 0; i < question_list.size(); i++){ 
                  HashMap<String,Object> question = question_list.get(i);
                  HashMap<String, Object> surveyor_answer = surveyor_answerList.get(i);
            %>
              <tr>                  
                  <th class="text-center"> 
                    <%-- 질문 출력 --%>
                     <%= question.get("QUESTION_LIST") %> 
                  </th>
                  <th>
                    <%-- 답변 출력 --%>
                    <%= surveyor_answer.get("ANSWER_LIST") %>
                  </th>
 ````
