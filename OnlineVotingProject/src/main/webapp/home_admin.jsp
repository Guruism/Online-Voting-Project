<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voting Hub</title>
    <link rel="stylesheet" href="style_home.css">
    <link rel="icon" href="images/uncolored_logo2.png" type="image/png">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" >
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Sixtyfour&family=Source+Code+Pro:ital,wght@0,200..900;1,200..900&display=swap" rel="stylesheet">
</head>
<body>
    <div class="main">
        <div class="nav-bar">
            <div class="name">
                <div class="pic"><img src="images/Colored_logo1-removebg-preview.png" alt="The Logo"></div>
                <h2>Voting Hub</h2>
            </div>
            <div class="options">
                <% String username = (String) session.getAttribute("username");
                username=username.toUpperCase();%>
                <h3 class="intro">WELCOME <%= username %></h3>
                <a class="info" href="">ABOUT US</a>
                <a class="info" href="">CONTACT US</a>
                <form id="results" action="CountServlet" method="post">
    				<input class="info" type="submit" value="VIEW RESULTS">
				</form>
                <a class="info" href="login_register.jsp" class="log-out">LOG OUT</a>
            </div>
        </div>
        <div class="context">
            <div class="para">
                <p>Choose Your Nation's Leader with a Single Click Now.</p>
            </div>
            <div class="content">
                <div class="booth">
                    <img src="images/voting-hands.jpg" alt="An random Image">
                </div>
                <div class="btn">
                    <form action="VotingServlet" method="get">
   						 <button class="vote-btn" type="submit">VOTE NOW</button>
					</form>
                </div>
            </div>
        </div>
    </div>
     <% Boolean isVoted = (Boolean) request.getSession().getAttribute("isVoted"); %>
      <script>
       var isVoted = <%= isVoted %>;
    </script>
    <script src="script_home.js"></script>
</body>
</html>
