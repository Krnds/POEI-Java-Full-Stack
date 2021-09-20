function randomPassword(min, max) {
    let characters = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 0, 1,
        2, 3, 4, 5, 6, 7, 8, 9, '?', '*', '@', '-', '_', '!'];
    let randomLength = Math.floor(Math.random() * (max - min + 1) + min);
    let string = "";
    for (i = 0; i < randomLength; i++) {
        string += characters[Math.floor(Math.random() * characters.length)];
    }
    return string;
}

function randomUsername() {
    let name = document.getElementById('nom').value;
    let randomUsername = name + (Math.round(Math.random() * 900) + 100).toString();
    document.getElementById('username').setAttribute('value', randomUsername);
 }

const togglePassword = document.querySelector('#basic-addon2');
const password = document.querySelector('#password');

togglePassword.addEventListener('click', function (e) {
    // toggle the type attribute
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    // toggle the eye / eye slash icon
    this.classList.toggle('bi-eye');
});


function progressBar() {
    let fields, index, filledInputs, progress;
    fields = document.getElementsByTagName('input');
    filledInputs = 0, progress = 0;

    for (index = 0; index < fields.length - 2; ++index) {
        if (fields[index].value !== "") {
            filledInputs++;
        }
    }
    progress = Math.round(filledInputs / (fields.length - 2) * 100);
    $("#progress-inputs .progress-bar").attr("aria-valuenow", progress).width(progress + "%").find(".sr-only").html(progress + "% Completed");
}


function validate() {

    let password = document.getElementById("password");
    let upper = /[A-Z]/,
        lower = /[a-z]/,
        number = /[0-9]/;

    if (upper.test(password) &&
        lower.test(password) &&
        number.test(password)) {
        return true;
    }
    return false;
}