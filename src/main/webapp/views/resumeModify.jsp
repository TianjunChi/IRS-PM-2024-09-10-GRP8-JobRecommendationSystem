<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resume Recognition</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        input[type="file"], input[type="text"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Resume Recognition</h1>

    <!-- Part 1: Upload PDF -->
    <form id="uploadForm" action="/user/uploadResume" method="post" enctype="multipart/form-data">
        <label for="resume">Upload your resume (PDF):</label>
        <input type="file" id="resume" name="resume" accept=".pdf" required>
        <input type="submit" value="Upload">
    </form>

    <!-- Part 2: Display User Information -->
    <div id="userInfo" style="display: none;">
        <h2>Recognized User Information</h2>
        <form id="userInfoForm" action="/user/confirmResume" method="post">
            <label for="userName">Name:</label>
            <input type="text" id="userName" name="userName" value="${user.userName}" required>

            <label for="phoneNumber">Phone:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}">

            <label for="emailAddress">Email:</label>
            <input type="text" id="emailAddress" name="emailAddress" value="${user.emailAddress}" required>

            <label for="degree">Degree:</label>
            <input type="text" id="degree" name="degree" value="${user.degree}">

            <label for="major">Major:</label>
            <input type="text" id="major" name="major" value="${user.major}">

            <label for="skills">Skills:</label>
            <input type="text" id="skills" name="skills" value="${user.skills}">

            <label for="projectExperience">Project Experience:</label>
            <input type="text" id="projectExperience" name="projectExperience" value="${user.projectExperience}">

            <label for="hometown">Hometown:</label>
            <input type="text" id="hometown" name="hometown" value="${user.hometown}">

            <label for="school">School:</label>
            <input type="text" id="school" name="school" value="${user.school}">

            <label for="preference">Preference:</label>
            <input type="text" id="preference" name="preference" value="${user.preference}">

            <label for="hobby">Hobby:</label>
            <input type="text" id="hobby" name="hobby" value="${user.hobby}">

            <label for="desiredJob">Desired Job:</label>
            <input type="text" id="desiredJob" name="desiredJob" value="${user.desiredJob}">

            <label for="salary">Expected Salary:</label>
            <input type="text" id="salary" name="salary" value="${user.salary}">

            <input type="submit" value="Confirm">
        </form>
    </div>
</div>

<script>
    // JavaScript to handle showing user info section after file upload
    document.getElementById("uploadForm").onsubmit = function() {
        document.getElementById("userInfo").style.display = "block";
    };
</script>
</body>
</html>
