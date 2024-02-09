<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voting Hub</title>
    <link rel="stylesheet" href="style_voting.css">
    <link rel="icon" href="images/uncolored_logo2.png" type="image/png">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Mono:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="main">
        <h1>VOTING ARENA</h1>
        <form action="VotingServlet" method="post">
        <div class="block">
            <div class="img">
                <img src="images/BJP-removebg-preview.png" alt="Image of BJP">
            </div>
            <div class="context">
                <h2>Bharatiya Janata Party</h2><br>
                <p>The Bharatiya Janata Party is a political party in India and one of the two major Indian political parties alongside the Indian National Congress. Since 2014, it has been the ruling political party in India under the incumbent Prime Minister Narendra Modi. The BJP is aligned with right-wing politics and has close ideological and organisational links to the Rashtriya Swayamsevak Sangh (RSS) volunteer paramilitary organisation. Its policies adhere to Hindutva, a Hindu nationalist ideology. As of December 2023, it is the country's biggest political party in terms of representation in the Parliament of India as well as state legislatures.</p>
                <div class="voting-sec">
                    <br><input type="radio" id="1" name="voted" value="BJP">
                    <label for="voted">I am voting for this party.</label>
                </div>
            </div>
        </div>
        <div class="block">
            <div class="img">
                <img src="images/download__3_-removebg-preview.png" alt="Image of Congress">
            </div>
            <div class="context">
                <h2>Indian National Congress</h2><br>
                <p> The Indian National Congress (INC), colloquially the Congress Party or simply the Congress, is a political party in India with widespread roots. Founded in 1885, it was the first modern nationalist movement to emerge in the British Empire in Asia and Africa. From the late 19th century, and especially after 1920, under the leadership of Mahatma Gandhi, the Congress became the principal leader of the Indian independence movement. The Congress led India to independence from the United Kingdom, and significantly influenced other anti-colonial nationalist movements in the British Empire.</p>
                <div class="voting-sec">
                    <br><input type="radio" id="2" name="voted" value="CONG" >
                    <label for="voted">I am voting for this party.</label>
                </div>
            </div>
        </div>
        <div class="block">
            <div class="img">
                <img src="images/aap-removebg-preview.png" alt="Image of AAP">
            </div>
            <div class="context">
                <h2>Aam Aadmi Party</h2><br>
                <p>The Aam Aadmi Party is a political party in India. It was founded on 26 November 2012 by Arvind Kejriwal and his then-companions, following the 2011 Indian anti-corruption movement. AAP is currently the governing party in the Indian state of Punjab and the union territory of Delhi. On 10 April 2023, AAP was officially granted the status of National party by ECI. The party's election symbol is a broom. The party is currently part of the coalition I.N.D.I.A Alliance.</p>
                <div class="voting-sec">
                    <br><input type="radio" id="3" name="voted" value="AAP">
                    <label for="voted">I am voting for this party.</label>
                </div>
            </div>
        </div>
        <div class="btn">
            <input type="submit" class="submit-btn">
            <button class="no-vote" name="nota" value="true">Nota vote</button></div>
            </form>
    </div>
    <% Boolean isAdmin = (Boolean) request.getSession().getAttribute("isAdmin"); %>
    <% Boolean isVoted = (Boolean) request.getSession().getAttribute("isVoted"); %>
      <script>
       var isAdmin = <%= isAdmin %>;
       var isVoted = <%= isVoted %>;
    </script>
    <script src="script_vote.js"></script>
</body>
</html>