package com.example.usermanager.util;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    private Integer code;   // 状态码
    private String message; // 提示信息
    private T data;         // 返回数据

    // 构造函数
    public Result() {}

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功静态方法
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    // 自定义成功静态方法
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(200, message, data);
    }

    // 错误静态方法
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }

}
