<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Room</title>
</head>
<body>
	<h2>Welcome, <%= request.getParameter("user") %> 👋</h2>
    <div id="messages" style="border:1px solid #ccc; height:200px; width:300px; overflow:auto;"></div>
    <br>
    <input type="text" id="msg" placeholder="Type a message..." />
    <button onclick="sendMessage()">Send</button>
	
</body>
<script>
	var user = "<%= request.getParameter("user") %>";
	var ws = new WebSocket("ws://localhost:8010/ChatAppWebSocket/chat");
	
	ws.onmessage = function(event) {
	    var chatBox = document.getElementById("messages");
	    chatBox.innerHTML += event.data + "<br>";
	};
	
	function sendMessage() {
	    var msg = document.getElementById("msg").value;
	    ws.send(user + ": " + msg);
	    document.getElementById("msg").value = "";
	}
</script>
</html>