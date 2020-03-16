str = "eeeabbacddckfwdj";
var i = 1;
while (i != 0) {
    i = 0;
    for (var j = 1; j < str.length; j++) {
        if (str[j] == str[j - 1]) {
            i = j;
            break;
        }
    }
    if (i != 0) {
        str = str.slice(0, i - 1) + str.slice(i + 1);
    }
}