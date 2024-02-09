documnet.addEventListener("DOMCOntentLoaded",() => {
let voted=document.querySelectorAll("input");
let vote_btn=document.querySelector(".submit-btn");
let nota_btn=document.querySelector(".no-vote");

let Voted=false;
let votedID=0;
let isvoted=isVoted;

let check= () => {
    if(isvoted){
		if(isAdmin){
        window.location.href="home_admin.jsp";
    }else{
		window.location.href="home.jsp"
	}
}};

check();

voted.forEach(item => {
    item.addEventListener('click',() =>{
    if(item.checked){
        console.log(item.getAttribute("id"));
        Voted=true;
        votedID = parseInt(item.getAttribute("id"),10);  
    }});
});

vote_btn.addEventListener("click", () => {
    if(Voted){
        if(canVote){
            console.log("voting successful");
            alert("You have successfully Voted");
            isvoted=true;
            check();
            console.log(votedID);
        }
        else{
            alert("You have already casted your vote!")
        }
    } else {
        alert("Please vote before submitting.");
}
}
);

nota_btn.addEventListener("click",()=>{
    if(canVote){
            console.log("You Have decided to not vote for anyone.")
            alert("You have successfully Voted");
            canVote=false;
            check();
            votedID=0;
            console.log(voteID);
        }else{
            alert("You cannot change your mind after voting!");
        }
});
});