package com.example.usermanager.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public String handleUserAlreadyExistsException(UserAlreadyExistException ex, RedirectAttributes redirectAttributes) {
        // 将错误消息添加到 Flash 属性中
        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/register"; // 重定向回注册页面
    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleUserAlreadyExistsException(UserNotExistException ex, RedirectAttributes redirectAttributes) {
        // 将错误消息添加到 Flash 属性中
        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/login"; // 重定向回登录页面
    }
}
