<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Job Recommendation System</title>
    <style>
        body {
            font-family: 'Roboto', Arial, sans-serif;
            background: linear-gradient(135deg, #f0f8ff, #e6f2ff);
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            text-align: center;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 600px;
        }
        h1 {
            color: #333;
            font-size: 2.5rem;
            margin-bottom: 20px;
        }
        p {
            font-size: 1.2rem;
            color: #666;
            margin-bottom: 30px;
        }
        .btn {
            display: inline-block;
            margin: 10px;
            padding: 12px 25px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 30px;
            text-decoration: none;
            font-size: 1rem;
            transition: background-color 0.3s, box-shadow 0.3s;
            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
        }
        .btn:hover {
            background-color: #45a049;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
        }
        @media (max-width: 768px) {
            h1 {
                font-size: 2rem;
            }
            p {
                font-size: 1rem;
            }
            .btn {
                font-size: 0.9rem;
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to the Job Recommendation System</h1>
    <p>Find your ideal job based on your skills and preferences!</p>
    <a href="/login" class="btn">Login</a>
    <a href="/register" class="btn">Register</a>
</div>
</body>
</html>
