<%--<%@ include file="common/header.jspf"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Events</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"--%>
<%--          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
<%--    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"--%>
<%--          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">--%>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">


    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>

    <style>
        .form-elegant .font-small {
            font-size: 0.8rem; }

        .form-elegant .z-depth-1a {
            -webkit-box-shadow: 0 2px 5px 0 rgba(55, 161, 255, 0.26), 0 4px 12px 0 rgba(121, 155, 254, 0.25);
            box-shadow: 0 2px 5px 0 rgba(55, 161, 255, 0.26), 0 4px 12px 0 rgba(121, 155, 254, 0.25); }

        .form-elegant .z-depth-1-half,
        .form-elegant .btn:hover {
            -webkit-box-shadow: 0 5px 11px 0 rgba(85, 182, 255, 0.28), 0 4px 15px 0 rgba(36, 133, 255, 0.15);
            box-shadow: 0 5px 11px 0 rgba(85, 182, 255, 0.28), 0 4px 15px 0 rgba(36, 133, 255, 0.15); }
        .width{
            width: 40%;
            position: center;
            margin-top: 10px;
        }
    </style>
</head>

<body class="container width">
<section class="form-elegant " >

    <!--Form without header-->
    <div class="card">

        <div class="card-body mx-4">

            <!--Header-->
            <div class="text-center">
                <h3 class="dark-grey-text mb-5"><strong>Authenticate</strong></h3>
            </div>

            <!--Body-->
            <form:form method="POST" modelAttribute="user" action="/login">
            <div class="">
                <form:label path="name" for="Form-email1">Username</form:label>
                <form:input type="text" path="name" id="Form-email1" class="form-control" ></form:input>

            </div>
            <div class=" pb-3">
                <form:label path="password" for="Form-pass1">Password</form:label>
                <form:input path="password" type="password" id="Form-pass1" class="form-control"></form:input>

            </div>
            <div class="text-center mb-3">
                <button type="submit" class="btn  purple-gradient btn-block btn-rounded z-depth-1a" data-toggle="button" aria-pressed="false" autocomplete="off">Sign in</button>
            </div>
            </form:form>
        </div>


    </div>

</section>

</body>
</html>