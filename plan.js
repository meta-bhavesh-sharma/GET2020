        function validate() {
            pdocument.write(getElementById('button1').value);
            pricem = document.getElementById('button2').value;
            pricey = document.getElementById('button3').value;
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