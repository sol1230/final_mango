## ๐ปServlet - JSP PROJECT

## ๐ฆ๋ฐ๋ ค๋๋ฌผ ์ค๋ฌธ์กฐ์ฌ

![main](https://user-images.githubusercontent.com/111327647/210258146-be9a9ab9-73ae-4520-a6ee-90a54867c255.png)


### ํ๋ก์ ํธ ๊ธฐ๊ฐ

2022.12.27 ~ 2023.01.03

## ๐์์ค์ฝ๋

#### ๐์ด์์ : ์ค๋ฌธ / ํต๊ณ

1. DB  
   -[survey DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/SurveyWithDB.java)  
   -[survey result DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/SurveyResultWithDB.java)

2. Servlet  
   -[survey start Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/SurveyStart.java)  
   -[survey Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/SurveyServlets.java)  
   -[survey result servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/SurveyServlets.java)  
   -[statistics1 Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/Statistics1Servlet.java)  
   -[statistics2 Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/Statistics2Servlet.java)

#### ๐๊น์ํฌ : ๋ก๊ทธ์ธ / ๋ก๊ทธ์์

1. DB  
   -[login DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/LoginWithDB.java)  
   -[login Filter](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/filter/LoginFilter.java)

2. Servlet  
   -[login Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/LoginServlets.java)  
   -[logout Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/LogoutServlets.java)  
   -[Find UserInfo Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/FindUserInfoServlets.java)

#### ๐๋ฐ์ฐฌํฌ : ํ์๊ฐ์

1. DB  
   -[sign up DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/SignUpDB.java)

2. Servlet  
   -[membership Servlet](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/Membership_test/MembershipServlet.java)  
   -[MembershipBean](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/Membership_test/MembershipBean.java)

#### ๐๋ฐฐํ์  : ํ์๊ด๋ฆฌ

1. DB  
   -[User DB](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/dao/UserWithDB.java)

2. Servlet  
   -[Admin User List](https://github.com/sol1230/final_mango/blob/master/src/main/java/com/mango/final_mango/servlets/AdminUserList.java)

## ๐๊ตฌํ ํ์ด์ง ์ด๋ฏธ์ง
<div>
<img src="https://user-images.githubusercontent.com/111327647/210258539-128494f0-f0b1-48c6-9ba1-e15a36ea9ee7.png" width="500" height="300">
<img src="https://user-images.githubusercontent.com/111327647/210258637-11e48e49-2f51-4e70-9a22-55222dfd270c.png" width="500" height="300">
<img src="https://user-images.githubusercontent.com/111327647/210260703-122848a3-984c-4093-a895-cb0fb9e5f23c.png" width="500" height="300">
<img src="https://user-images.githubusercontent.com/111327647/210258790-7eb09714-6c7a-4511-ab17-ab01ec7d67f9.png" width="500" height="300">
<img src="https://user-images.githubusercontent.com/111327647/210259345-9d9a1ff3-f140-434b-b1ae-444e73393f51.png" width="500" height="300">
<img src="https://user-images.githubusercontent.com/111327647/210259459-d530a1fe-a4e3-4abc-887f-915d27b897e3.png" width="500" height="300">
</div>


## ๐น๊ตฌํ ์์

-[Video](https://youtu.be/bIDMNy5KAWk)

## ๐์ฃผ์ ์ฝ๋
#### ํ์ ์ ๋ณด ๋ฐ์์ค๊ธฐ

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
                      <input type="submit" class="btn btn-outline-secondary opacity-75" value="๋ณด๊ธฐ"/>
                      <input type="hidden" name="user_id" value="<%= user_id %>"/>
                  </th>
                </form>
```

#### ์ง๋ฌธ, ๋ต๋ณ ๋ฐ์์ค๊ธฐ
````
 <% 
                for (int i = 0; i < question_list.size(); i++){ 
                  HashMap<String,Object> question = question_list.get(i);
                  HashMap<String, Object> surveyor_answer = surveyor_answerList.get(i);
            %>
              <tr>                  
                  <th class="text-center"> 
                    <%-- ์ง๋ฌธ ์ถ๋ ฅ --%>
                     <%= question.get("QUESTION_LIST") %> 
                  </th>
                  <th>
                    <%-- ๋ต๋ณ ์ถ๋ ฅ --%>
                    <%= surveyor_answer.get("ANSWER_LIST") %>
                  </th>
 ````
