
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="css/style.css"   rel="stylesheet">
</head>
<body>
<script src="js/format.js"></script>

<!-- Tab links -->
<div class="tab">
    <button style="float:left;" class="tablinks" onclick="location.reload();location.href='playVideo'"><b>MumTube</b></button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='login'">SignOut</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='upload'">Upload Video</button>
    <!--button-- style="float:right;" class="tablinks" onclick="window.open('allVideos')">My Playlists</button-->
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='allVideos'">My Playlists</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='addNewPlaylist'">Create Playlist</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='charts'">Charts</button>

</div>

</body>
</html>