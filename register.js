function valid() {
            var name = document.getElementById("empname").value;
            var contact = document.getElementById("contact").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var cpassword = document.getElementById("cpassword").value;
            var letters1 = /^[a-zA-Z]+ [a-zA-Z]+$/;
            var letters2 = /^\d{8}\d*$/;
            var letters3 = /^\w+[.]\w+[@]\w{3}\w*\w+|.[A-Za-z]+$/;
            if (!name.match(letters1)) {
                alert("Enter onmly characters in name and enter only first name and last name");
            } else if (!email.match(letters3)) {
                alert("Enter valid email");
                return false;
            } else if (!password.match(/[a-z]/g) && password.match(
                    /[A-Z]/g) && password.match(
                    /[0-9]/g) && password.match(
                    /[^a-zA-Z\d]/g) && password.length >= 8) {
                alert("Enter valid password please follow these conditions password length minimum 8,atleast one uppercase,lowercase and digit is necessery");
            } else if (password != cpassword || password == "" || cpassword == "") {
                alert("password and confirm password should be same and can't be empty");
            } else if (!contact.match(letters2)) {
                alert("Enter valid contact number ");
            }
}
function purchase() {
	var v=document.getElementByName("email").value;
	var r=document.getElementByName("password").value;
	doccument.write(v);

    var vnum = document.getElementById("vnum").value;
    var name = document.getElementById("vname").value;
    var rid = document.getElementById("Rid").value;
    var Currency = document.getElementById("Currency").value;
    var c1 = document.getElementById("check1");
    var c2 = document.getElementById("check2");
    var c3 = document.getElementById("check3");
    var count = 0;
    if (c1.checked == true) {
        count++;
    }
    if (c2.checked == true) {
        count++;
    }
    if (c3.checked == true) {
        count++;
    }
    if (rid == "") {
        alert("please fill the regestration form first");
    } else if (name == "") {
        alert("veichle name required");
    } else if (count == 0) {
        alert("Select veichle type");
    } else if (vnum == "") {
        alert("enter veichle number");
    } else if (Currency == "1") {
        alert("Select currency");
    }
    document.getElementById("veichle").innerHTML = "<h1>Congratulation You have successfully purchased parking pass now enjoy our parking facilities <h1>";
    document.getElementById("veichle").innerHTML = "<h1>         Thank you        <h1>";
	document.getElementById("vehicle").submit;
}

function validate() {
    var sel = document.getElementById("Currency").value;
    var c1 = document.getElementById("check1");
    var c2 = document.getElementById("check2");
    var c3 = document.getElementById("check3");
    if (c1.checked == true) {
        priced = 5;
        pricem = 100;
        pricey = 500;

    }
    if (c2.checked == true) {
        priced = 10;
        pricem = 200;
        pricey = 1000;
    }
    if (c3.checked == true) {
        priced = 20;
        pricem = 500;
        pricey = 3500;
    }
}