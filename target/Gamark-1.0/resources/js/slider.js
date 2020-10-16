var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n)
{
    showDivs(slideIndex += n);
}

function currentDiv(n)
{
    showDivs(slideIndex = n);
}
function showDivs(n)
{
    var i;
    var x = document.getElementsByClassName("mySlides");
    console.log(x.length);
    var dots = document.getElementsByClassName("dot");

    if (n > x.length)
            slideIndex = 1;
    if (n < 1)
        slideIndex = x.length;
    for (i = 0; i < x.length; i++)
        x[i].style.display = "none";
    for (i = 0; i < dots.length; i++)
        dots[i].setAttribute('src', "resources/img/home/dot.png");
    
    x[slideIndex - 1].style.display = "inline";
    dots[slideIndex-1].setAttribute('src', "resources/img/home/dotfull.png");
}