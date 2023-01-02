package com.mango.final_mango.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// survey는 로그인 후 사용 가능하도록
@WebFilter("/survey/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 한글 처리
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String uri = httpServletRequest.getRequestURI();

        HttpSession httpSession = httpServletRequest.getSession();

        if(httpSession.getAttribute("user_id") == null){
            printWriter.println("<script>alert('로그인이 필요한 서비스입니다.'); location.href = '/jsp/login.jsp' </script>");

            // jsp는 response가 우선순위라 alert창이 뜨지 않음 --> html안에 경로 넣어주기
            // httpServletResponse.sendRedirect("/jsp/login.jsp");
        } else {
            // 사용자가 요청한 servlet으로 넘어간다
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
