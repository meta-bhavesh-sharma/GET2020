hide("gen");
hide("email");
hide("password");
hide("confirmPassword");
hide("contact");
hide("company");
hide("model");
hide("type");
hide("number");
hide("identification");
hide("id");
hide("submitfinal");
hide("selectCurrency");
hide("selectPass");



var name;
var password;
var vehicle;
var id;

function successful() {
    alert("thank you for registration your employee id is " + id);
    hide("message");
    hide("submitfinal");
    hide("headingofemployeeregistration");
}

function hidePricing() {
    document.getElementById("pricingLabel ").style = "display:block ";
    document.getElementById("pricing").style = "display:none ";
}


function fname(item) {
    var key = event.keyCode;
    if (key == 13) {
        if (item.value.length > 0) {
            if ((item.value.search(/[!@#$%^&*]+/) == -1) && (item.value.search(/[0-9]+/) == -1) && item.value.length >= 2) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                name = item.value;
                item.style = "display:none ";
                display("gen");
                document.getElementById("message").innerHTML = "Hii " + item.value + " can you please tell your gender ";
            } else {
                item.style = "border:2px solid red ";
                document.getElementById("error").innerHTML = "please enter a valid name ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the name ";

        }

    }
}

function fgender(item) {
    var key = event.keyCode;
    document.getElementById("message").innerHTML = "Hii " + name + " can you please link your email ";
    hide("gen");
    display("email");

}

function femail(item) {
    var key = event.keyCode;
    if (key == 13) {
        if (item.value.length > 0) {
            if (item.value.search(/[a-zA-z]{1,}[@][a-zA-Z]+[.][a-zA-Z]+/) != -1) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                item.style = "display:none ";
                display("password");

                document.getElementById("message").innerHTML = "Hii " + name + " can you please set your password ";


            } else {
                item.style = "border:2px solid red ";
                document.getElementById("error").innerHTML = "please enter valid email ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the email ";

        }
    }
}

function fpassword(item) {
    var key = event.keyCode;
    if (key == 13) {
        if (item.value.length > 0) {
            if ((item.value.search(/[0-9]+/) != -1) && (item.value.search(/[!@#$%^&*(){}?><]+/) != -1) && (item.value.search(/[A-Z]+/) != -1) && item.value.length >= 8) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                password = item.value;
                item.style = "display:none ";
                display("confirmPassword");
                document.getElementById("message").innerHTML = "Hii " + name + " can you please confirm your password ";


            } else {
                item.style = "border:2px solid red ";
                document.getElementById("error").innerHTML = "please enter valid password ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the password ";

        }
    }
}

function fconfirmPassword(item) {
    var key = event.keyCode;

    if (key == 13) {
        if (item.value.length > 0) {
            if (password == item.value) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                item.style = "display:none ";
                document.getElementById("contact").style = "display:block";
                display("contact");

                document.getElementById("message").innerHTML = "Hii " + name + " can you please share your contact number ";
            } else {
                document.getElementById("error").innerHTML = " confirm password did not match with password ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the password ";

        }

    }
}

function fcontact(item) {
    var key = event.keyCode;
    if (key == 13) {
        if (item.value.length > 0) {

            if (item.value.length > 8 && (item.value.search(/[a-zA-Z]+/) == -1) && (item.value.search(/[!@#$%^&*(){}?><]+/) == -1)) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                item.style = "display:none ";
                display("company");
                id = name[0] + item.value[2] + item.value[6] + name[2];
                document.getElementById("message").innerHTML = "Hii " + name + " can you please add vehicle details also ";


            } else {
                item.style = "border:2px solid red ";
                document.getElementById("error").innerHTML = "please enter valid contact number ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the contact number ";

        }
    }
}

function fvehicleCompany(item) {
    var key = event.keyCode;
    if (key == 13) {
        if (item.value.length > 0) {

            if ((item.value.search(/[!@#$%^&*]+/) == -1) && (item.value.search(/[0-9]+/) == -1)) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                item.style = "display:none ";
                display("model");

                document.getElementById("message").innerHTML = "Hii " + name + " can you please tell us vehicle model ";
            } else {
                item.style = "border:2px solid red ";
                document.getElementById("error").innerHTML = "please enter valid vehicle company Name ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the contact number ";

        }
    }
}

function fvehicleType(item) {
    var key = event.keyCode;
    document.getElementById("error").innerHTML = " ";
    item.style = "display:none ";
    display("number");
    vehicle = item.value;
    document.getElementById("message").innerHTML = "Hii " + name + " can you please register your vehicle number ";

}

function fvehicleModel(item) {
    var key = event.keyCode;
    if (key == 13) {
        if (item.value.length > 0) {

            if (item.value.length > 2) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                item.style = "display:none ";
                display("type");
                document.getElementById("message").innerHTML = "Hii " + name + " can you please select your vehicle type ";
            } else {
                item.style = "border:2px solid red ";
                document.getElementById("error").innerHTML = "please enter valid vehicle Model ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the vehicle model ";

        }
    }
}

function fvehicleNumber(item) {
    var key = event.keyCode;
    if (key == 13) {
        if (item.value.length > 0) {

            if (item.value.length > 4) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                item.style = "display:none ";
                display("identification");

                document.getElementById("message").innerHTML = "Hii " + name + " can you please tell something about your vehicle ";
            } else {
                item.style = "border:2px solid red ";
                document.getElementById("error").innerHTML = "please enter valid vehicle number ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the vehicle number ";

        }
    }
}

function fvehicleIdentication(item) {
    var key = event.keyCode;
    if (key == 13) {
        if (item.value.length > 0) {

            if (item.value.length > 4) {
                item.style = "border:2px solid blue ";
                document.getElementById("error").innerHTML = " ";
                item.style = "display:none ";
                display("selectCurrency");

                document.getElementById("message").innerHTML = "Hii " + name + " can you please select your currency to Pay ";
            } else {
                item.style = "border:2px solid red ";
                document.getElementById("error").innerHTML = "please enter valid vehicle identifications ";

            }
        } else {
            item.style = "border:2px solid red ";
            document.getElementById("error").innerHTML = "please enter the vehicle model ";

        }
    }
}

function fid(item) {
    var key = event.keyCode;
    if (key == 13) {
        item.style = "border:2px dashed red ";
        document.getElementById("message").innerHTML = "hello " + y.value;
    }
}


function hide(idName) {
    document.getElementById(idName).style = "display:none ";
}

function display(idName) {
    document.getElementById(idName).style = "display:block ";
}

function currencyTypeChange(item) {
    var currency = item.value;

    if (currency == "INR") {
        if (vehicle == "Bicycle") {
            document.getElementById("passCost").value = "0.07 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 5 RS";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 100 RS";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 500 RS";
        } else if (vehicle == "MotorCycle") {
            document.getElementById("passCost").value = "0.14 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 10 RS";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 200 RS";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 1000 RS";
        } else if (vehicle == "FourWheeler") {
            document.getElementById("passCost").value = "0.28 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 20 RS";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 500 RS";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 3500 RS";
        }
    } else if (currency == "USD") {
        if (vehicle == "Bicycle") {
            document.getElementById("passCost").value = "0.07 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 0.07 $";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 1.4 $";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 7.0 $";
        } else if (vehicle == "MotorCycle") {
            document.getElementById("passCost").value = "0.14 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 0.14 $";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 2.8 $";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 14.0 $";
        } else if (vehicle == "FourWheeler") {
            document.getElementById("passCost").value = "0.28 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 0.28 $";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 7.14 $";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 50$";

        }
    } else if (currency == "YEN") {
        if (vehicle == "Bicycle") {
            document.getElementById("passCost").value = " 0.07 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 7 YEN";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 150 YEN";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 1500 YEN";
        } else if (vehicle == "MotorCycle") {
            document.getElementById("passCost").value = "0.14 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 14 YEN";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 300 YEN";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 3000 YEN";
        } else if (vehicle == "FourWheeler") {
            document.getElementById("passCost").value = "0.28 $";
            document.getElementById("dailyPass").innerHTML = "Daily Parking 30 YEN";
            document.getElementById("monthlyPass").innerHTML = "Monthly Parking 750 YEN";
            document.getElementById("yearlyPass").innerHTML = "Yearly Parking 5250 YEN";
        }
    }
    document.getElementById("message").innerHTML = "Hii " + name + " can you please choose pass planning ";

    hide("selectCurrency");
    display("selectPass");

}

function passTypeChange(item) {


    var x = item.selectedIndex;
    if (x == 1) {
        if (vehicle == "Bicycle") {
            document.getElementById("passCost").value = "0.07 $";
        } else if (vehicle == "MotorCycle") {
            document.getElementById("passCost").value = "0.14 $";
        } else if (vehicle == "FourWheeler") {
            document.getElementById("passCost").value = "0.28 $";
        }
    } else if (x == 2) {
        if (vehicle == "Bicycle") {
            document.getElementById("passCost").value = "1.4 $";
        } else if (vehicle == "MotorCycle") {
            document.getElementById("passCost").value = "2.8 $";
        } else if (vehicle == "FourWheeler") {
            document.getElementById("passCost").value = "7.14 $";
        }
    } else if (x == 3) {
        if (vehicle == "Bicycle") {
            document.getElementById("passCost").value = "7 $";
        } else if (vehicle == "MotorCycle") {
            document.getElementById("passCost").value = "14 $";
        } else if (vehicle == "FourWheeler") {
            document.getElementById("passCost").value = "50 $";
        }
    }
    document.getElementById("message").innerHTML = "Hii " + name + " Please Pay " + document.getElementById("passCost").value;

    hide("selectPass");
    display("submitfinal");
}