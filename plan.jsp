<html>
<script>
    function validate() {
    	var priced=0;
    	var pricem=0;
    	var pricey=0;
    	var type=document.getElementById("vehtype").value;
    	if(type=="cycle"){
    	    document.getElementById('button1').value=5;
    	    document.getElementById('button2').value=100;
    	    document.getElementById('button3').value=500;	
    	}
    	if(type=="bike"){
    	    document.getElementById('button1').value=10;
    	    document.getElementById('button2').value=200;
    	    document.getElementById('button3').value=1000;	
    	}
    	if(type=="car"){
    	    document.getElementById('button1').value=20;
    	    document.getElementById('button2').value=500;
    	    document.getElementById('button3').value=3500;	
    	}
    	
    	var priced=document.getElementById('button1').value;
    	var pricem=document.getElementById('button2').value;
    	var pricey=document.getElementById('button3').value;
  
        var sel = document.getElementById('Currency').value;
        if (sel == '2') {
            document.getElementById('currency').value = 'INR';
            document.getElementById('money1').value = priced;
            document.getElementById('money2').value = pricem;
            document.getElementById('money3').value = pricey;
        }
        if (sel == '3') {
            document.getElementById('currency').value = 'USD';
            document.getElementById('money1').value = (priced * 0.014).toFixed(2);
            document.getElementById('money2').value = (pricem * 0.014).toFixed(2);
            document.getElementById('money3').value = (pricey * 0.014).toFixed(2);
        }
        if (sel == '4') {
            document.getElementById('currency').value = 'YEN';
            document.getElementById('money1').value = (priced * 1.52).toFixed(2);
            document.getElementById('money2').value = (pricem * 1.52).toFixed(2);
            document.getElementById('money3').value = (pricey * 1.52).toFixed(2);
        }
    }
</script>

<link href='style.css' rel='stylesheet' type='text/css'>
<title>Select Plan</title>
</head>
<% String email=(String)session.getAttribute("Id");
    if(email.length()==0)
    {
    	response.sendRedirect("register.jsp");
    }
    %>
<body>
    <form id='selectplan' method='post' action='Select'>
        <div>Choose Currency<br><select id='Currency' onchange='validate();'><option value='1'>--Select--</option><option value='2'>INR</option><option value='3'>USD</option><option value='4'>YEN</option></select><br><input type='hidden' name='rid' value="${Rid}">
            <input type='text' name='currency' id='currency' placeholder='currency'><br><label><input id='button1' type='radio' name='plan' value=20 >daily</label><input id='money1' type='text' placeholder='Price' readonly><br><label><input id='button2' type='radio' name='plan' onclick='purchase();'>monthly</label>
            <input id='money2' type='text' placeholder='Price' readonly><br><label><input id='button3' type='radio' name='plan' value=1000 onclick='purchase();'>weekly</label><input id='money3' type='text' placeholder='Price' readonly><br><input type='submit'
                value='purchase'></input>
                <input type="hidden" id="vehtype" name="vehtype" value="${vehtype}">
        </div>
        </form>
            </bodoy>

</html>