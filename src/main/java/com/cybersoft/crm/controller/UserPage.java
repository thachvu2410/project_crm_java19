package com.cybersoft.crm.controller;

import com.cybersoft.crm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userPage", urlPatterns = {"/member"})
public class UserPage extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("usersList", userService.getAllUsers());
//        System.out.println("goi link member");

        req.getRequestDispatcher("/user-table.jsp").forward(req,resp);
    }
}
