<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Recommendations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .header {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-align: right;
        }
        .container {
            display: flex; /* Flexbox layout */
            margin: 20px;
        }
        .sidebar {
            width: 200px; /* Sidebar width */
            margin-right: 20px; /* Space between sidebar and main content */
        }
        .sidebar .btn {
            display: block;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #007bff;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .job-list {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 20px;
            flex-grow: 1; /* Allow job list to grow */
        }
        .job-item {
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 15px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .job-item h3 {
            font-size: 1.2em;
            margin: 0 0 10px;
            color: #333;
        }
        .job-item p {
            font-size: 0.9em;
            color: #666;
            margin: 5px 0;
        }
        .job-item .company {
            font-weight: bold;
            color: #007bff;
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
        <h1>Recommended Jobs for You</h1>
        <!-- Loop through jobs passed from the backend -->
        <c:forEach var="job" items="${jobs}">
            <div class="job-item">
                <p class="company">${job.companyName}</p>  <!-- Display Company Name -->
                <h3>${job.jobTitle}</h3>
                <p>${job.jobDescription}</p>
                <p><strong>Location:</strong> ${job.location}</p>
                <p><strong>Salary:</strong> ${job.salary}</p>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

