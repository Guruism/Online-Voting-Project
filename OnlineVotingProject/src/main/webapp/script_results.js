let CountBJP=countBJP;
let CountCONG=countCONG;
let CountAAP=countAAP;

let goBack=document.querySelector(".back");
let bjpWinner=(document.getElementById("bjpWinner")).querySelector('p');
let congWinner=(document.getElementById("congWinner")).querySelector('p');
let aapWinner=(document.getElementById("aapWinner")).getElementsByTagName('p');

let winner=CountBJP;

function checkWinner(CountBJP,CountCONG,CountAAP){
    if(CountCONG > CountBJP && CountCONG > CountAAP){
        winner=CountCONG;
        congWinner.style.display="block";
    }
    else if(CountAAP > CountCONG && CountAAP > CountBJP){
        winner=CountAAP;
        aapWinner.syle.display ="block";
    }
    else{
        bjpWinner.style.display = "block";
    }
};
checkWinner(CountBJP,CountCONG,CountAAP);

goBack.addEventListener("click",()=>{
    window.location.href="home_admin.jsp";
});
