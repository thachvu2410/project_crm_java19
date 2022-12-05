package com.cybersoft.crm.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = {"/login"})
public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("check filter");

        // cho phep di vao client mong muon

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

//        if (session.getAttribute("isLogin") != null && !Objects.equals(session.getAttribute("isLogin"), "")){
//            boolean isLogin = (boolean) session.getAttribute("isLogin");
//            if (isLogin){
//                if (request.getServletPath().equals("/login")){
//                    //Neu la trang login phai chuyen huong qua trang home
//                    response.sendRedirect(request.getContextPath() + "/home");
//                }else {
//                    //chuyen ve page login vi chua dang nhap
//                    filterChain.doFilter(request,response);
//                }
//            }else {
//                //chuyen ve page login
//                response.sendRedirect(request.getContextPath() + "/login");
//            }
//        }else {
//            //Chua login
//            //Chuyen ve page login
//            System.out.println("kiemtrapath" + request.getServletPath());
//            if (request.getServletPath().equals("/login")){
//                //Neu la trang login
//                filterChain.doFilter(request,response);
//            }else {
//                //chuyen ve page login
//                response.sendRedirect(request.getContextPath() + "/login");
//            }
//        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
