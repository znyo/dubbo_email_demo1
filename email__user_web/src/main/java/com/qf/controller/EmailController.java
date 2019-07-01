package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Email;
import com.qf.entity.User;
import com.qf.service.IEmailService;
import com.qf.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class EmailController {
    @Reference
    private IUserService userService;
    @Reference
   private IEmailService emailService;

    @RequestMapping("/email")
    public String email(Email email,HttpServletRequest request){
       Email list= emailService.getEmail();
        String content=null;
        content = email.getContent();
        request.getSession().setAttribute("content",content);

        return content;
    }
    @RequestMapping("/checkNum")
    public boolean checkNum(Email email,HttpServletRequest request){
        boolean result=false;
       if (email.getContent().equals(request.getParameter("num"))){
           result=true;
       }
        return result;
    }
    @RequestMapping("/log")
    public String log(){
        return "login";

    }
    @RequestMapping("/success")
    public String success(User user){
        int  i= userService.addUser();
        return "login";
    }
    @RequestMapping("/find")
    public String find(){
        return "findpwd";
    }
    @RequestMapping("/login")
    public String login(String name){
        userService.selectName(name);
        return "success";
    }
}
