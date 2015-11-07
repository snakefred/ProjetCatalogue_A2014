function switchDisplay(element)
{
    x = document.getElementById(element).style;
    if (x.display == 'block')
        x.display = 'none';
    else
        x.display = 'block';
}

function cacherDesc()
{    
    var i, a;
    var t = document.getElementsByTagName("ul");
    
    for (i = 0; i < t.length; i++)
    {
        a = t[i];
        s = a.getAttribute("class");
        if (s.indexOf("desc") != -1)
            a.style.display = 'none';
    }    
}

