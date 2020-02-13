<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="css/style.css"   rel="stylesheet">
    <div th:replace="/header :: header-css"/>
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color:#EEEEEE;">
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
<br>
<br>
<h3>List of all Videos and Playlist videos</h3>
<tr>
    <tr>
        <td>

            <table border="1px" cellpadding="0" cellspacing="0" id="styleTable" >

                <h3>List of all Videos</h3>
                        <tr>
                              <th>Video Id</th>
                              <th>User Id</th>
                              <th>Likes</th>
                              <th>Dislikes</th>
                        </tr>

                             <c:forEach var="video" items="${videoList}">
                                 <tr>
                                     <td>${video.videoId}</td>
                                     <td>${video.userId}</td>
                                     <td>${video.no_dislikes}</td>
                                     <td>${video.no_likes}</td>
                                </tr>
                             </c:forEach>

            </table>
        </td>
        <td>
            <!--loop through all the playlists available-->

            <h3>Playlist videos</h3>

            <table border="1px" cellpadding="0" cellspacing="0" id="styleTable" >
            <c:forEach var="playlist" items="${playlistList}">

                                    <tr>
                                        <td>playlist Id = ${playlist.userId}</td>
                                        <td>Playlist Name  = ${playlist.playlistName}</td>
                                    </tr>

                                    <c:forEach var="videos" items="${videoList}">
                                           <c:if test = "${videos.userId==playlist.userId}">
                                                    <tr>
                                                        <td>${videos.videoId}</td>
                                                        <td>${videos.userId}</td>
                                                    </tr>
                                           </c:if>
                                    </c:forEach>

            </c:forEach></table>

        </td>
</tr>
</table>
</body>
</html>
