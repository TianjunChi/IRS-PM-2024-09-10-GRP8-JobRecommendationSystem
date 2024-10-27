package com.example.usermanager.controller;



import com.example.usermanager.entity.User;
import com.example.usermanager.exception.UserAlreadyExistException;
import com.example.usermanager.exception.UserNotExistException;
import com.example.usermanager.service.UserService;
import com.example.usermanager.util.CommunicateWithPython;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam("username") String phoneNumber,
                           @RequestParam("password") String password,
                           RedirectAttributes redirectAttributes){
        User userByPhoneNumber = userService.getUserByPhoneNumber(phoneNumber);
        if(userByPhoneNumber !=  null){
            throw new UserAlreadyExistException("PhoneNumber already exists: " + phoneNumber);
        }
        User user = new User(phoneNumber, password);
        redirectAttributes.addFlashAttribute("message", "Registration successful. Please log in.");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String phoneNumber,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes,
                        HttpSession session){
        User userByPhoneNumber = userService.getUserByPassword(phoneNumber,password);
        if(userByPhoneNumber == null){
            throw new UserNotExistException("PhoneNumber not exists: " + phoneNumber);
        }
        session.setAttribute("user",userByPhoneNumber);
        return "redirect:/mainPage";
    }

    @PostMapping("/uploadResume")
    public String readFromResume(@RequestParam("resume") MultipartFile file, Model model){
        User user = null;
        File tempFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        try {
            file.transferTo(tempFile);
            // 调用 readFromResume 方法处理 PDF 文件
            user = CommunicateWithPython.readFromResume(tempFile);
            tempFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("user",user);
        return "resumeModify";
    }

    @PostMapping("/confirmResume")
    public String confirmResume(@ModelAttribute User user,HttpSession session){
        if(!userService.save(user)){
            log.info("save user-info error");
        }
        session.setAttribute("user",user);
        return "redirect:/mainPage";
    }
}
