var divs = document.getElementsByClassName("product");
var btns = document.getElementsByClassName("product-price-btn");

var prv = document.getElementsByName("prev");
var nxt = document.getElementsByName("next");
prv[0].style.visibility ="hidden";
if(divs.length<=3) nxt[0].style.visibility ="hidden";

var now=0;
var toShow=3;

show(divs,0,toShow);

function listNext()
{
    if(now<divs.length-toShow)
    {
        now+=toShow;
        min=now+toShow;
        
        if(divs.length<min)
            min=divs.length;
        
        show(divs,now,min);

        prv[0].style.visibility ="visible";
        if(now>=divs.length-toShow)
            nxt[0].style.visibility ="hidden";
    }
}

function listPrev()
{
    if(now>0)
    {
        now-=toShow;
        show(divs,now,now+toShow);
        nxt[0].style.visibility ="visible";
        if(now<=0)
            prv[0].style.visibility ="hidden";
    }  
    
}

function show(divs,n,m)
{
    for(i=0;i<n;i++)
    {
        divs[i].style.display="none";
    } 
    for(i=n;i<m;i++)
    {
        divs[i].style.display="block";
    }
    for(i=m;i<divs.length;i++)
    {
        divs[i].style.display="none";
    } 
}

function selectProd(n)
{
    for(i=0;i<btns.length;i++)
    {
        btns[i].textContent="Select";
        btns[i].style.color="#D3D3D3";
        btns[i].style.backgroundColor="#2C2C2C"; 
    }
    btns[n].textContent="Selected";
    btns[n].style.color="#2C2C2C";
    btns[n].style.backgroundColor="#D3D3D3";
}