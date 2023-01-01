<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Membership</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="../../../static/css/font.css" />
  </head>
  <body class="bg-light">
    <div class="container-fluid pb-5">

      <%@ include file="header.jsp" %>
      <form action="/SignUpServlet" method="post">
      <main class="mt-5 p-1">
        <div class="row mt-5 text-center">
          <div class="col-12 col-md-6 mx-auto">
            <form action="./a_main.html" method="get">
              <div class="fs-2 text-success opacity-75 mb-3">회원가입</div>
              <div class="row">
                <div class="col input-group">
                  <div class="input-group mb-2">
                    <input
                      type="text"
                      name="id-memeber"
                      class="form-control opacity-75"
                      id="id-memeber"
                      placeholder="아이디"
                      required
                    />
                    <button class="btn btn-secondary">중복확인</button>
                  </div>
                </div>
                <div id="password-member">
                  <input
                    type="password"
                    name="password-memeber"
                    id="password-memeber"
                    class="form-control mb-2 opacity-75"
                    placeholder="비밀번호"
                    required
                  />
                </div>
                <div id="password-check">
                  <input
                    type="password"
                    name="password-check"
                    id="password-check"
                    class="form-control mb-2 opacity-75"
                    placeholder="비밀번호 재입력"
                    required
                  />
                </div>
                <div id="name-memeber">
                  <input
                    type="text"
                    name="name-member"
                    id="name-memeber"
                    class="form-control mb-2 opacity-75"
                    placeholder="이름"
                    required
                  />
                </div>
                <div id="birth-memeber">
                  <input
                    type="date"
                    name="birth-member"
                    id="birth-memeber"
                    class="form-control mb-2 text-secondary opacity-75"
                    required
                  />
                </div>
                <div class="mb-3">
                  <div class="text-start text-secondary">휴대전화</div>
                  <div class="row">
                    <div class="col">
                      <select class="form-select text-secondary opacity-75">
                        <option>선택</option>
                        <option value="010">010</option>
                        <option value="012">012</option>
                        <option value="013">013</option>
                      </select>
                    </div>
                    <div class="col">
                      <input
                        type="text"
                        name="phone1"
                        id="phone1"
                        class="form-control rounded mb-2"
                        required
                      />
                    </div>
                    <div class="col">
                      <input
                        type="text"
                        name="phone2"
                        id="phone2"
                        class="form-control rounded mb-2"
                        required
                      />
                    </div>
                  </div>
                </div>

                <div class="border-bottom opacity-75 mb-4"></div>
                <div>
                  <button
                    type="submit"
                    class="form-control btn btn-success btn-lg opacity-75"
                  >
                    가입하기
                  </button>
                </div>
              </div>
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
    </form>
  </body>
</html>
