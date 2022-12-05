package com.cybersoft.crm.controller;

import com.cybersoft.crm.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginPage", urlPatterns = {"/login"})
public class LoginPage extends HttpServlet {

    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        boolean isLogin = loginService.checkLogin(email, password);

        // cookie luu o may user nen can khoi tao
//        Cookie cookie = new Cookie("email", email);
//        cookie.setMaxAge(600);
//        resp.addCookie(cookie);
//
//        Cookie cookie1 = new Cookie("password", password);
//        cookie1.setMaxAge(600);
//        resp.addCookie(cookie1);

//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies
//             ) {
//            System.out.println("ten cookie - " + cookie.getName());
//            System.out.println("gia tri cookie - " + cookie.getValue());
//        }

        // moi lan request, browser se tu tao ra 1 session nen khong can tao, chi can lay ra

//        HttpSession session = req.getSession();

//        session.setAttribute("email", email);
//        session.setAttribute("password", password);
//        session.setMaxInactiveInterval(500);

//        System.out.println("email: " + session.getAttribute("email"));
//        System.out.println("password: " + session.getAttribute("password"));

        if (isLogin){

            HttpSession session = req.getSession();
            session.setAttribute("isLogin", isLogin);
            session.setMaxInactiveInterval(10 * 60);
        }


        System.out.println("kiem tra " + isLogin);
        req.getRequestDispatcher("/login.html").forward(req, resp);


    }
}
