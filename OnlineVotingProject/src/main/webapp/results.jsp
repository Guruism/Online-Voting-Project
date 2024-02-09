<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voting Hub</title>
    <link rel="stylesheet" href="style_results.css">
    <link rel="icon" href="images/uncolored_logo2.png" type="image/png">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Mono:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
</head>
<body>
	<%
	int countBJP = (Integer) session.getAttribute("countBJP");
	int countCONG = (Integer) session.getAttribute("countCONG");
	int countAAP = (Integer) session.getAttribute("countAAP");
	%>
	 <div class="back-nav">
        <div class="back">
            <div class="back-img">
                <img src="images/icons8-back-50 (1).png" alt="">
            </div>
            <button class="bn-btn">GO BACK</button>
        </div>
    </div>
    <div class="main">
        <div class="text">
            <h1>RESULTS</h1>
        </div>
        <div class="images">
            <div class="party1" id="box">
                <div class="logo"><img src="images/BJP-removebg-preview.png" alt="logo of bjp"></div>
                <div class="votes" id="bjpWinner">
                    Votes: <%= countBJP %>
                    <p class="win-tag">WINNER!!</p>
                </div>
            </div>
            <div class="party2" id="box">
                <div class="logo"><img src="images/download__3_-removebg-preview.png" alt="logo of congress"></div>
                <div class="votes" id="congWinner">
                    Votes: <%= countCONG %>
                    <p class="win-tag">WINNER!!</p>
                </div>
            </div>
            <div class="party3" id="box">
                <div class="logo"><img src="images/aap-removebg-preview.png" alt="logo of aap"></div>
                <div class="votes" id="aapWinner">
                    Votes: <%= countAAP %>
                    <p class="win-tag">WINNER!!</p>
                </div>
            </div>
        </div>
    </div>
    <script>
    	const countBJP = <%= countBJP %>;
    	const countCONG = <%= countCONG %>;
    	const countAAP = <%= countAAP %>;
    </script>
    <script src="script_results.js"></script>
</body>
</html>