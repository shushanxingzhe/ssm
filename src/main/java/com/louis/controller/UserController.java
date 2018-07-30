package com.louis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.pojo.User;
import com.louis.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showUser", method = RequestMethod.POST)
    public void index(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Integer userId = Integer.parseInt(request.getParameter("id"));
            User user = userService.selectUserById(userId);
            response.getWriter().write(new ObjectMapper().writeValueAsString(user));
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public void userList(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
            Integer pageSize = request.getParameter("pageSize") != null ? Integer.parseInt(request.getParameter("pageSize")) : 20;


            List<User> users = userService.selectByPage(page,pageSize);
            response.getWriter().write(new ObjectMapper().writeValueAsString(users));
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
