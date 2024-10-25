<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resume Recognition</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f6f9;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin: 10px 0 5px;
            font-weight: bold;
            color: #495057;
        }
        input[type="file"], input[type="text"], input[type="submit"], select {
            padding: 10px;
            font-size: 1rem;
            margin-bottom: 15px;
            border: 1px solid #ced4da;
            border-radius: 5px;
            box-sizing: border-box;
            background-color: #f8f9fa;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        input[type="file"] {
            border: none;
            background-color: #ffffff;
        }
        input[type="text"]:focus, select:focus {
            outline: none;
            border-color: #80bdff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }
        .radio-group {
            display: flex;
            align-items: center;
            gap: 10px;
            margin-bottom: 15px;
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
    <div id="userInfo" >
        <h2>Recognized User Information</h2>
        <form id="userInfoForm" action="/user/confirmResume" method="post">
            <%--@declare id="hobby"--%><label for="userName">Name:</label>
            <input type="text" id="userName" name="userName" value="${user.userName}" required>

            <label for="phoneNumber">Phone:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}">

            <label for="emailAddress">Email:</label>
            <input type="text" id="emailAddress" name="emailAddress" value="${user.emailAddress}" required>

            <label for="degree">Degree:</label>
            <select id="degree" name="degree">
                <option value="Associate degree">Associate degree</option>
                <option value="Bachelor’s degree (BA, BS, B.Eng., etc.)">Bachelor’s degree (BA, BS, B.Eng., etc.)</option>
                <option value="Master’s degree (MA, MS, M.Eng., MBA, etc.)">Master’s degree (MA, MS, M.Eng., MBA, etc.)</option>
                <option value="Other doctoral degree (Ph.D, Ed.D., etc.)">Other doctoral degree (Ph.D, Ed.D., etc.)</option>
                <option value="Primary/elementary school">Primary/elementary school</option>
                <option value="Professional degree (JD, MD, etc.)">Professional degree (JD, MD, etc.)</option>
                <option value="Secondary school (e.g. American high school, German Realschule or Gymnasium, etc.)">Secondary school (e.g. American high school, German Realschule or Gymnasium, etc.)</option>
                <option value="Some college/university study without earning a degree">Some college/university study without earning a degree</option>
            </select>

            <label for="major">Major:</label>
            <select id="major" name="major">
                <option value="A business discipline (ex. accounting, finance, marketing)">A business discipline (ex. accounting, finance, marketing)</option>
                <option value="A health science (ex. nursing, pharmacy, radiology)">A health science (ex. nursing, pharmacy, radiology)</option>
                <option value="A humanities discipline (ex. literature, history, philosophy)">A humanities discipline (ex. literature, history, philosophy)</option>
                <option value="A natural science (ex. biology, chemistry, physics)">A natural science (ex. biology, chemistry, physics)</option>
                <option value="A social science (ex. anthropology, psychology, political science)">A social science (ex. anthropology, psychology, political science)</option>
                <option value="Another engineering discipline (ex. civil, electrical, mechanical)">Another engineering discipline (ex. civil, electrical, mechanical)</option>
                <option value="Computer science, computer engineering, or software engineering">Computer science, computer engineering, or software engineering</option>
                <option value="Fine arts or performing arts (ex. graphic design, music, studio art)">Fine arts or performing arts (ex. graphic design, music, studio art)</option>
                <option value="Information systems, information technology, or system administration">Information systems, information technology, or system administration</option>
                <option value="Web development or web design">Web development or web design</option>
                <option value="Mathematics or statistics">Mathematics or statistics</option>
            </select>

            <label for="skills">Skills:</label>
            <input type="text" id="skills" name="skills" value="${user.skills}">

            <label for="yearsCoding">Years Coding:</label>
            <select id="yearsCoding" name="yearsCoding">
                <option value="0-2 years">0-2 years</option>
                <option value="3-5 years">3-5 years</option>
                <option value="6-8 years">6-8 years</option>
                <option value="9-11 years">9-11 years</option>
                <option value="12-14 years">12-14 years</option>
                <option value="15-17 years">15-17 years</option>
                <option value="18-20 years">18-20 years</option>
                <option value="21-23 years">21-23 years</option>
                <option value="24-26 years">24-26 years</option>
                <option value="27-29 years">27-29 years</option>
                <option value="30 or more years">30 or more years</option>
            </select>

            <label for="hometown">Hometown:</label>
            <input type="text" id="hometown" name="hometown" value="${user.hometown}">

            <label for="hobby">Hobby:</label>
            <div class="radio-group">
                <input type="radio" id="hobbyTrue" name="hobby" value="true" ${user.hobby == 'true' ? 'checked' : ''}>
                <label for="hobbyTrue">True</label>
                <input type="radio" id="hobbyFalse" name="hobby" value="false" ${user.hobby == 'false' ? 'checked' : ''}>
                <label for="hobbyFalse">False</label>
            </div>

            <label for="desiredJob">Desired Job:</label>
            <input type="text" id="desiredJob" name="desiredJob" value="${user.desiredJob}">

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

