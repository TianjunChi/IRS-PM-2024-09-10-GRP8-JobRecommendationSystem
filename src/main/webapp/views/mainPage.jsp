<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Recommendations</title>
    <style>
        body {
            font-family: 'Helvetica Neue', Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
            color: #333;
        }
        .header {
            background-color: #ffcc00; /* Meituan yellow */
            color: black;
            padding: 15px 20px;
            text-align: right;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .header span {
            font-size: 1.2em;
            font-weight: bold;
        }
        .container {
            display: flex;
            margin: 20px;
            flex-direction: column; /* 修改为列布局 */
        }
        .sidebar {
            max-width: 250px;
            margin-bottom: 20px;
        }
        .sidebar .btn {
            display: block;
            padding: 12px 20px;
            background-color: #ffcc00;
            color: black;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            margin-bottom: 15px;
            font-size: 1.1em;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }
        .sidebar .btn:hover {
            background-color: #e6b800;
        }
        .job-list {
            display: flex;
            flex-direction: column; /* 单列布局 */
            gap: 20px;
        }
        .job-item {
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            text-align: left;
            width: 100%; /* 占满容器宽度 */
        }
        .job-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 10px rgba(0, 0, 0, 0.15);
        }
        .job-item h3 {
            font-size: 1.4em;
            margin-bottom: 10px;
            color: #333;
        }
        .job-item p {
            font-size: 0.95em;
            color: #666;
        }
        .job-item .company {
            font-weight: bold;
            font-size: 1.1em;
            color: #ffcc00;
            margin-bottom: 8px;
        }
        .job-item .details {
            margin-top: 15px;
        }
        .job-item .details strong {
            color: #333;
        }
    </style>
</head>
<body>
<!-- Header section -->
<div class="header">
    <span>Welcome, ${username}</span>
</div>

<!-- Main content section -->
<div class="container">
    <!-- Sidebar section -->
    <div class="sidebar">
        <a href="/resumeModify" class="btn">修改简历</a> <!-- Link to the resume editing page -->
    </div>

    <!-- Job recommendations section -->
    <div class="job-list">
        <c:forEach var="job" items="${jobs}">
            <div class="job-item">
                <p class="company">${job.companyName}</p>  <!-- Display Company Name -->
                <h3>${job.jobTitle}</h3>
                <p>${job.jobDescription}</p>
                <div class="details">
                    <p><strong>Location:</strong> ${job.location}</p>
                    <p><strong>Salary:</strong> ${job.salary}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>




