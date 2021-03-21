var CurrentUserName;
var CurrentUserId;
var CurrentChannelId;
var request = new XMLHttpRequest();
(function () {

  document.getElementById("UserName").innerHTML = localStorage.getItem("name");


  request.open('GET', '/getAllUser', true)
  request.onload = function () {
    // Begin accessing JSON data here
    var data = JSON.parse(this.response)

    if (request.status >= 200 && request.status < 400) {
      data.forEach((user) => {
        if (localStorage.getItem("id") != user.id) {
          document.getElementById("UserList").innerHTML +=
            `<li class="clearfix" onclick=` + `"OpenChat('` + user.name + `','` + user.id + `')"` + `>
              <img style="width: 50px;" src="profile.png" alt="avatar" />
              <div class="about">
                <div class="name">`+ user.name + `</div>
                <div class="status"><i class="fa fa-circle online"></i> online</div>
              </div>
            </li>`
        }
      });
      searchFilter.init();
    } else {
      console.log('error');
    }
  }

  request.send();

  var searchFilter = {
    options: { valueNames: ['name'] },
    init: function () {
      var userList = new List('people-list', this.options);
      var noItems = $('<li id="no-items-found">No items found</li>');

      userList.on('updated', function (list) {
        if (list.matchingItems.length === 0) {
          $(list.list).append(noItems);
        } else {
          noItems.detach();
        }
      });
    }
  };

  searchFilter.init();

})();



function sendMassage() {
  var text = document.getElementById("message-to-send").value;
  if (text != '') {
    request.open('POST', '/sendMessage?channelId=' + CurrentChannelId + '&senderId=' + localStorage.getItem('id') + '&text=' + EncriptText(text), true)
    request.onload = function () {
      // Begin accessing JSON data here
      var data = JSON.parse(this.response)
      if (request.status >= 200 && request.status < 400) {
        if (!data.status)
          alert(data.message);
        else{
          document.getElementById("message-to-send").value = '';
          getAllMessage();
        }
      } else {
        alert("Error");
        console.log('error');
      }
    }
    request.send();
  }
}

function EncriptText(text) {
  let cipherText = ""
  let key = parseInt(document.getElementById("Key").value);
  for (let i = 0; i < text.length; i++)
    cipherText += String.fromCharCode(text.charCodeAt(i) + key);
  return cipherText;
}

function DecriptText(cipher) {
  let plainText = "";
  let key = parseInt(document.getElementById("Key").value);
  for (let i = 0; i < cipher.length; i++)
    plainText += String.fromCharCode(cipher.charCodeAt(i) - key);
  return plainText;
}

function getAllMessage() {
  var key = parseInt(document.getElementById("Key").value);
  request.open('POST', '/getMessage?channelId=' + CurrentChannelId, true)
  request.onload = function () {
    // Begin accessing JSON data here
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {
      if (data.response.status) {
        document.getElementById("ReciverMsgCount").innerHTML = 'already' + data.message.length + ' messages';
        document.getElementById("messageList").innerHTML = "";
        data.message.forEach((message) => {
          if (message.sendBy == localStorage.getItem("id")) {
            document.getElementById("messageList").innerHTML +=
              `<li>
                <div class="message-data">
                  <span class="message-data-time">`+ message.time + `</span> &nbsp; &nbsp;
                  <span class="message-data-name">`+ localStorage.getItem("name") + `</span> <i class="fa fa-circle online"></i>
                </div>
                <div class="message my-message">`+ DecriptText(message.text) + `</div>
              </li>`
          }
          else {
            document.getElementById("messageList").innerHTML +=
              `<li class="clearfix">
                <div class="message-data align-right">
                  <span class="message-data-time">`+ message.time + `</span> &nbsp; &nbsp;
                  <span class="message-data-name">`+ CurrentUserName + `</span> <i class="fa fa-circle me"></i>
                </div>
                <div class="message other-message float-right">`+ message.text + `</div>
              </li>`
          }
        });
        var objDiv = document.getElementById("AllMessages");
        objDiv.scrollTop = objDiv.scrollHeight;
      }
      else {
        alert(data.response.message);
      }
    } else {
      console.log('error');
    }
  }

  request.send();
}

function getChannelId(user1, user2) {
  request.open('POST', '/getChannelId?user1=' + user1 + '&user2=' + user2, true)
  request.onload = function () {
    // Begin accessing JSON data here
    var data = JSON.parse(this.response)
    if (request.status >= 200 && request.status < 400) {
      if (data.response.status) {
        CurrentChannelId = data.id;
        getAllMessage();
      }
      else {
        alert(data.response.message);
      }
    } else {
      console.log('error');
    }
  }

  request.send();
}



function OpenChat(userName, userId) {
  CurrentUserName = userName;
  CurrentUserId = userId;
  document.getElementById("ReciverName").innerHTML = userName;
  getChannelId(userId, localStorage.getItem("id"));
  document.getElementById("chatDIV").style.display = "block";
  document.getElementById("UserInfo").style.display = "none";
}


function logout() {
  localStorage.clear();
  window.open("index.html", "_self");
}

// setInterval(function () {
//   if (CurrentChannelId != null)
//     getAllMessage(CurrentChannelId);
// }, 1000);