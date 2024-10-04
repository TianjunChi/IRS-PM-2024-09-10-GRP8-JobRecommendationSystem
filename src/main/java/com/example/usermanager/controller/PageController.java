package com.example.usermanager.controller;


import com.example.usermanager.entity.Job;
import com.example.usermanager.entity.User;
import com.example.usermanager.util.CommunicateWithPython;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        // 返回 index.jsp，Spring Boot 会自动解析为 /WEB-INF/views/index.jsp
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // 会找到 /WEB-INF/views/login.jsp
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // 会找到 /WEB-INF/views/register.jsp
    }

    @GetMapping("/mainPage")
    public String showMainPage(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getUserName());
        }
        List<Job> recommendJobs = CommunicateWithPython.getRecommendJobs(user);
        model.addAttribute("jobs",recommendJobs);
        return "mainPage";
    }

    @GetMapping("/resumeModify")
    public String resumeModify(){
        return "resumeModify";
    }
}
