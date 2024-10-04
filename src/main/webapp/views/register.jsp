<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Job Recommendation System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .register-box {
            width: 350px;
            padding: 40px;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .input-group {
            margin-bottom: 15px;
        }
        .input-group label {
            display: block;
            font-size: 14px;
            margin-bottom: 5px;
            color: #333;
        }
        .input-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .message {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="register-box">
        <h2>Register</h2>
        <form action="/user/register" method="post">
            <div class="input-group">
                <label for="phoneNumber">phoneNumber</label>
                <input type="text" id="phoneNumber" name="phoneNumber" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-group">
                <label for="confirm_password">Confirm Password</label>
                <input type="password" id="confirm_password" name="confirm_password" required>
            </div>
            <button type="submit" class="btn">Register</button>
            <div class="message">
                <p>Already have an account? <a href="/login">Login</a></p>
            </div>
        </form>

        <!-- 显示错误消息 -->
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
    </div>
</div>
</body>
</html>
