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
            document.empregeister.action("/register");
            ducument.getEmployByID("empregister").submit();
}