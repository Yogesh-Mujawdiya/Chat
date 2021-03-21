$(document).ready(function () {
   if (localStorage.getItem("id") != null)
      window.open("chat.html","_self");
   else{
   var $form = $('#login');
   $form.submit(function () {
      $.post($(this).attr('action'), $(this).serialize(), function (response) {
         // do something here on success
         console.log(response);
         if (response == null)
            alert("Invalid UserName and Password")
         else {
            localStorage.setItem("id", response.id);
            localStorage.setItem("name", response.name);
            window.open("chat.html","_self");
         }
      }, 'json');
      return false;
   });
   var $form = $('#signup');
   $form.submit(function () {
      $.post($(this).attr('action'), $(this).serialize(), function (response) {
         console.log(response)
         alert(response.message);
         if (response.status)
            toggleLogin();
      }, 'json');
      return false;
   });      
}

});

function toggleSignup() {
   document.getElementById("login-toggle").style.backgroundColor = "#fff";
   document.getElementById("login-toggle").style.color = "#222";
   document.getElementById("signup-toggle").style.backgroundColor = "#57b846";
   document.getElementById("signup-toggle").style.color = "#fff";
   document.getElementById("login-form").style.display = "none";
   document.getElementById("signup-form").style.display = "block";
}

function toggleLogin() {
   document.getElementById("login-toggle").style.backgroundColor = "#57B846";
   document.getElementById("login-toggle").style.color = "#fff";
   document.getElementById("signup-toggle").style.backgroundColor = "#fff";
   document.getElementById("signup-toggle").style.color = "#222";
   document.getElementById("signup-form").style.display = "none";
   document.getElementById("login-form").style.display = "block";
}