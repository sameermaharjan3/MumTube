<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

<div align="center">
<h3>Create a playlist</h3>
<h1>${headerMessage}</h1>
    <%--@elvariable id="playlist" type=""--%>
    <form:form method="post" action="addNewPlaylist" modelAttribute = "playlist">
        <table>
            <tr>
            <td><form:label path="userId">Playlist Id</form:label></td>
            <td><form:input path="userId" cssClass="inputStyle"/></td>
            </tr>
            <tr>
                <td><form:label path="playlistName" >Playlist Name</form:label></td>
                <td><form:input path="playlistName" cssClass="inputStyle"/></td>
            </tr>
        </table>
        <br><input type="submit" value="Create"/>
    </form:form>
</div>

</body>
</html>
