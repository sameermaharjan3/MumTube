<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="css/style.css"   rel="stylesheet">
    <div th:replace="/header :: header-css"/>
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color:#EEEEEE;">

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

<div class ="Container" style="margin: 0px;">
    <div class="col-md-12">
        <div class="main-title" style="margin-top:20px;margin-left:5px;">
            <h4>Videos</h4>
        </div>
    </div>


        <div class="row">
        <c:forEach var="video" items="${videos}"  varStatus="status">

            <div class="col-md-3" style="margin-bottom: 25px;">
                 <div class="card">
                     <div class="card-body text-center">

                        <a href="/${video}"><video class="col-sm-12" controls>
                        <source src="/${video}">
                        </video>
                        </a>
                        <p>${video}</p>
                         <button class="commentStyle" onclick="location.reload();location.href='comment/video/${VideoIds[status.index]}'">Comment</button>
                     </div>
                </div>
            </div>
                <%--<a href="/${video}">${video}><img src="/images/playvideo.png" style="width: 10%"></a>--%>
        </c:forEach>

        </div>

</div>
</body>
</html>