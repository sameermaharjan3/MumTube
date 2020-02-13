<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="css/style.css"   rel="stylesheet">
    <div th:replace="/header :: header-css"/>
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    /* Style the tab */
    body {
        background-color: #EEEEEE;
    }

    .tab {
        overflow: hidden;
        border: 1px solid #ccc;
        background-color: #ffffff;
    }

    /* Style the buttons that are used to open the tab content */
    .tab button {
        background-color: inherit;
        float: left;
        border: none;
        outline: none;
        cursor: pointer;
        padding: 14px 16px;
        transition: 0.3s;
    }

    /* Change background color of buttons on hover */
    .tab button:hover {
        background-color: #ddd;
    }

    /* Create an active/current tablink class */
    .tab button.active {
        background-color: #ccc;
    }

    /* Style the tab content */
    .tabcontent {
        display: none;
        padding: 6px 12px;
        border: 1px solid #ccc;
        border-top: none;

    }

    input[type=submit] {
        width: 20%;
        background-color: #007bff;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;

    }

    input[type=submit]:hover {
        background-color: #0069D9;
    }


    /* Clear floats after image containers */
    .row::after {
        content: "";
        clear: both;
        display: table;
    }

    #styleTable td, #styleTable th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #styleTable tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    #styleTable tr:hover {
        background-color: #ddd;
    }

    #styleTable th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #007bff;
        color: white;
    }
    .container{width:100%;padding-right:15px;padding-left:15px;margin-right:auto;margin-left:auto}@media (min-width:576px){.container{max-width:2040px}}
    .card{position:relative;display:-ms-flexbox;display:flex;-ms-flex-direction:column;flex-direction:column;min-width:0;word-wrap:break-word;background-color:#fff;background-clip:border-box;border:1px solid rgba(0,0,0,.125);border-radius:.25rem}.card>hr{margin-right:0;margin-left:0}.card>.list-group:first-child .list-group-item:first-child{border-top-left-radius:.25rem;border-top-right-radius:.25rem}.card>.list-group:last-child .list-group-item:last-child{border-bottom-right-radius:.25rem;border-bottom-left-radius:.25rem}.card-body{-ms-flex:1 1 auto;flex:1 1 auto;padding:1.25rem}.card-title{margin-bottom:.75rem}
</style>
<body style="background-color:#EEEEEE;">
<script src="js/format.js"></script>

<div class="tab">
    <button style="float:left;" class="tablinks" onclick="location.reload();location.href='/playVideo'"><b>MumTube</b></button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='/login'">SignOut</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='/upload'">Upload Video</button>
    <!--button-- style="float:right;" class="tablinks" onclick="window.open('allVideos')">My Playlists</button-->
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='/allVideos'">My Playlists</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='/addNewPlaylist'">Create Playlist</button>
    <button style="float:right;" class="tablinks" onclick="location.reload();location.href='/charts'">Charts</button>

</div>
<br>
<div class="row">
    <div class="card">
        <div style="background-color:#ffffff;color:black;padding:20px;">
            <form:form method="post" action="comment" enctype="multipart/form-data">
            <textarea rows="10" style="width:100%;" name="comment"></textarea>
            <form:form method="post" action="comment">
                <input style="float: right;" type="submit" value="comment" onclick="window.location.reload();"/>
            <br>
            </form:form>
            </form:form>
        </div>
    </div>
</div>
<br>
<div class ="container" style="margin:0px;padding:0px;">

        <c:forEach var="comment" items="${comment}"  varStatus="status">
            <div class="col-md-12">
            <div class="row">
                <div class="card">
                    <div style="background-color:#ffffff;color:black;padding:20px;">
                        <h1>${comment}</h1>
<%--
                        <i><h4>Commented by ${username[status.index]}</h4></i>
--%>
                    </div>
                </div>
            </div>
            </div>
            <br>
        </c:forEach>
</div>

</body>
</html>