<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="../../../static/css/font.css" />
    <link
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet"
    />
  </head>
  <body class="bg-light">
    <div class="container-fluid pb-5">
         <%@ include file="header.jsp" %>

      <main class="mt-5 p-1">
        <div class="row mt-5 text-center">
          <div class="col-12 col-md-6 mx-auto">
            <form action="./a_main.html" method="get">
              <div class="mb-4">
                <img
                  src="../../../static/img/hedgehog.png"
                  alt="고슴도치"
                  width="150"
                />
              </div>
              <div class="fs-2 text-success opacity-75 mb-3">로그인</div>
              <div class="row justify-content-center">
                <div class="col input-group mb-1">
                  <label for="id" class="input-group-text">
                    <i
                      class="material-icons col-1 text-secondary fs-5"
                      id="person"
                    >
                      person
                    </i>
                  </label>
                  <input
                    type="text"
                    class="form-control opacity-75"
                    name="id-login"
                    id="id"
                    placeholder="아이디"
                  />
                </div>
                <div class="input-group mb-2" id="password-input">
                  <label for="password" class="input-group-text">
                    <i
                      class="material-icons col-1 text-secondary fs-5"
                      id="lock"
                    >
                      lock
                    </i>
                  </label>
                  <input
                    type="password"
                    class="form-control opacity-75"
                    name="password-login"
                    id="password-login"
                    placeholder="비밀번호"
                  />
                </div>

                <div class="text-end">
                  <input
                    type="checkbox"
                    class="form-check-input"
                    name="remember"
                    id="remember"
                  />
                  <label class="form-check-label text-secondary" for="remember"
                    >아이디 저장</label
                  >
                </div>
                <div class="text-end mb-3">
                  <a
                    href="./find_users.html"
                    class="text-decoration-none text-secondary"
                    target="_self"
                    >아이디 또는 비밀번호 찾기</a
                  >
                  <a
                    href="./find_users.html"
                    class="btn btn-success btn-sm opacity-75 text-decoration-none text-white"
                    target="_self"
                    id="btn"
                  >
                    ID/PW찾기</a
                  >
                </div>
                <div class="row">
                  <a
                    href="./membership.html"
                    class="col form-control btn btn-secondary btn-lg fs-5"
                  >
                    회원가입</a
                  >

                  <button
                    type="submit"
                    class="col btn btn-success btn-lg opacity-75 ms-3"
                  >
                    로그인
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
  </body>
</html>
