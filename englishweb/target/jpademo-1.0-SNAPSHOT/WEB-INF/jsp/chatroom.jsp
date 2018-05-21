<%--
  Created by IntelliJ IDEA.
  User: huyl4
  Date: 5/13/2018
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebSocket Client</title>
    <script type="text/javascript">
        var wsocket;
        function connect() {
            wsocket = new WebSocket("ws://localhost:8080/englishweb/server1");x
            wsocket.onmessage = onMessage;
        }
        function onMessage(evt) {
            alert("thanh cong")
        }
        window.addEventListener("load", connect, false);
    </script>
</head>
<body>
<table>
    <tr>
        <td> <label id="rateLbl">Current Rate:</label></td>
        <td> <label id="rate">0</label></td>
    </tr>
</table>
</body>
</html>