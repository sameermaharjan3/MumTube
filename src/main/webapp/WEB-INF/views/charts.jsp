<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="css/style.css"   rel="stylesheet">
    <div th:replace="/header :: header-css"/>
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<script src="js/format.js"></script>
<div class="tab">
    <button style="float:left;" class="tablinks" onclick="location.reload();location.href='playVideo'"><b>MumTube</b></button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='login'">SignOut</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='upload'">Upload Video</button>
    <!--button-- style="float:right;" class="tablinks" onclick="window.open('allVideos')">My Playlists</button-->
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='allVideos'">My Playlists</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='addNewPlaylist'">Create Playlist</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='charts'">Charts</button>
</div>
<div>
    <img style="width:50%;float: left" id="image1" src="images/graph.png">
    <img style="width:50%;" id="image2" src="images/UsersVsTime2.png">
</div>
</body>
</html>
