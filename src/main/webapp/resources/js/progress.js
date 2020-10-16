var nextStep=document.getElementById("nextS");
var prevStep=document.getElementById("prevS");

var Index=0;

prevStep.style.display="none";
var progIndex=0;
showDivs(window.Index);

function nStep()
{
    if(Index<6)
    {
        if(progIndex===Index)
            progIndex+=1;
        localStorage.setItem('Index', localStorage.getItem('Index')+1);
        Index=Index+1;
        prevStep.style.display="block";
        if(Index===6)
        {
            nextStep.style.display="none";
        }
    }
}

function pStep()
{
    if(localStorage.getItem('Index')>0)
    {
        localStorage.setItem('Index', localStorage.getItem('Index')-1);
        showDivs(localStorage.getItem('Index')===1);
        nextStep.style.display="block";
        if(localStorage.getItem('Index')===0)
        {
            prevStep.style.display="none";
        }
    }
}
function showDivs(n)
{
    var i;
    var dots = document.getElementsByClassName("dot");
    
    for (i = 0; i <= progIndex; i++)
        dots[i].setAttribute('src', "resources/img/home/dot.png");
    for(i=progIndex+1; i<dots.length;i++)
        dots[i].setAttribute('src', "resources/img/home/dotempty.png");

    dots[localStorage.getItem('Index')].setAttribute('src', "resources/img/home/dotcurrent.png");
}