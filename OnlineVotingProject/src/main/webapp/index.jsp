<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voting Hub</title>
    <link rel="icon" href="images/uncolored_logo2.png" type="image/png">
    <link rel="stylesheet" href="style_instruct.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Mono:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
</head>
<body>
    <div class="main">
        <div class="content">
            <header>
                <h1>Voting Instructions</h1>
            </header>
            <main>
                <p class="main-head">Welcome to our online voting platform. Please read the following instructions carefully before proceeding:</p>
                <ol>
                    <li>Registration: Make sure you are a registered voter. If not, please register before proceeding.</li>
                    <li>Eligibility: Only registered voters are eligible to participate.</li>
                    <li>Voting: Each voter can cast only one vote.</li>
                    <li>Selection: Select your preferred candidate by clicking on their name or photo.</li>
                    <li>Confirmation: Review your selection before confirming your vote.</li>
                    <li>Security: This platform is secure and your vote will remain anonymous.</li>
                </ol>
                <p>If you have any questions or concerns, please contact our support team.</p>
            </main>
            <div class="checker">
                <input type="checkbox" id="agreeCheckbox">
                <label for="agreeCheckbox" class="checkbox-label">I have read and understood the instructions.</label>
            </div>
            <div class="vote">
                <button class="vote-btn">VOTE NOW</button>
            </div>
        </div>
    </div>
    <script src="script.js"></script>
</body>
</html>