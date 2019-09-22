<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="../../resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../resources/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>

</head>

<body style="padding-top: 50px;">
<!-- 主体 -->
<div class="container-fluid">
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="navbar-form navbar-left">
                <div class="form-group">
                    <a class="btn btn-default" href="/main" role="button">返回首页</a>
                </div>
            </div>
        </nav>
        <div class="jumbotron">
            <a class="btn btn-info" href="/demo2/testServletAPI" role="button">testServletAPI</a>
            <a class="btn btn-info" href="/demo2/testModelAndView" role="button">testModelAndView</a>
            <a class="btn btn-info" href="/demo2/testMap" role="button">testMap</a>
            <a class="btn btn-info" href="/demo2/testModel" role="button">testModel</a>
            <a class="btn btn-info" href="/demo2/testModelMap" role="button">testModelMap</a>
            <br> <br>
            <div class="form-group">
                <ul class="list-group">
                    <li class="list-group-item "><label>map: ${requestScope.map } </label></li>
                    <li class="list-group-item "><label>model: ${requestScope.model } </label></li>
                    <li class="list-group-item "><label>modelMap: ${requestScope.modelMap } </label></li>
                    <li class="list-group-item "><label>className : ${requestScope.className }</label></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>

</html>