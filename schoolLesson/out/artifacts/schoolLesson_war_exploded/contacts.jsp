<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Contacts</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript" src="js/util.js"></script>
    <script type="text/javascript">
        function operation(x, id) {
            var code = confirm("确认删除？");
            if (code) {
                var xhr = getXmlHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4 && xhr.state === 200) {
                        //alter("zhanjianshishabi");
                    }
                }
                var index = x.rowIndex;
                xhr.open("Post", "${pageContext.request.contextPath}/ControlerServlet?op=delOneFriend&time=" + new Date().getTime());
                xhr.send("id=" + id);
                alert('已删除');
            } else {
                return false;
            }
        }
    </script>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}">我的好友</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right"
                  action="${pageContext.request.contextPath}/ControlerServlet?op=search" method="post">
                <input type="text" class="form-control" placeholder="Search..." name="searchOne">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Reports</a></li>
                <li><a href="#">Analytics</a></li>
                <li><a href="#">Export</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item</a></li>
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
                <li><a href="">More navigation</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">我的通讯录</h1>

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="img/person1.jpg" width="200" height="200" class="img-responsive"
                         alt="Generic placeholder thumbnail">
                    <h4>Jack</h4>
                    <span class="text-muted">BasketBall</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="img/person2.jpg" width="200" height="200" class="img-responsive"
                         alt="Generic placeholder thumbnail">
                    <h4>Rose</h4>
                    <span class="text-muted">FootBall</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="img/person3.jpg" width="200" height="200" class="img-responsive"
                         alt="Generic placeholder thumbnail">
                    <h4>James</h4>
                    <span class="text-muted">Reading</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="img/person4.jpg" width="200" height="200" class="img-responsive"
                         alt="Generic placeholder thumbnail">
                    <h4>Harden</h4>
                    <span class="text-muted">Swiming</span>
                </div>
            </div>

            <h2 class="sub-header">My Friends</h2>
            <form method="post" action="${pageContext.request.contextPath}/ControlerServlet?op=delMulti">
                <div class="text-left" style="padding-right: 50px">
                    <a href="${pageContext.request.contextPath}/modiFriend.jsp" class="btn btn-primary">添加好友</a>
                    <input type="submit" class="btn btn-success" value="删除好友"/>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th></th>
                            <th>#</th>
                            <th>name</th>
                            <th>sex</th>
                            <th>age</th>
                            <th>qq</th>
                            <th>telphone</th>
                            <th>email</th>
                            <th>address</th>
                            <th>operation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${friends}" var="f" varStatus="vs">
                            <tr>
                                <td>
                                    <input type="checkbox" name="ids" value="${f.id}"/>
                                </td>
                                <td>${vs.count}</td>
                                <td>${f.name}</td>
                                <td>
                                        ${f.sex=='nan'?'男':'女'}
                                </td>
                                <td>${f.age}</td>
                                <td>${f.qq}</td>
                                <td>${f.telphone}</td>
                                <td>${f.email}</td>
                                <td>${f.address}</td>
                                <td>
                                    <button class="btn btn-danger" onclick="operation(this, '${f.id}')">删除</button>
                                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/ControlerServlet?op=editCustomerUI&id=${f.id}">修改</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </form>
        </div>
    </div>
</div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery-1.11.3.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="../../assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
