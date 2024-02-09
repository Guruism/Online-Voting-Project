document.addEventListener("DOMContentLoaded", function() {
    let btn = document.querySelector(".vote-btn");
              
    function preventBack() {
        window.history.forward();
    }
    setTimeout(preventBack, 0);
    window.onunload = function() {
        null
    };
    preventBack();
    
    
    btn.addEventListener("click", () => {
        if (isVoted){
            alert("You have already voted!");
        }
    });
});
