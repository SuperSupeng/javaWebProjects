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

    <title>CloudCHome</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/cover.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">CloudC</h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#">Contacts</a></li>
                            <c:if test="${sessionScope.user==null}">
                                <li><a href="#">about us</a></li>
                            </c:if>
                            <c:if test="${sessionScope.user!=null}">
                                <li><a href="${pageContext.request.contextPath}/ControlerServlet?op=logout">logout</a></li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <c:if test="${sessionScope.user==null}">
                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/ControlerServlet?op=signin">
                        <c:if test="${msg!=null}">
                            <div class="alert alert-danger col-sm-offset-2 col-sm-10" role="alert">用户名或密码错误</div>
                        </c:if>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-10">
                                <input type="input" class="form-control" id="inputEmail3" placeholder="Username" name="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-7">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="remember"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <a class="btn btn-info btn-block" href="register.jsp">register</a>
                            </div>
                        </div>
                    </form>
                </c:if>

                <c:if test="${sessionScope.user!=null}">
                    <div class="profile-content">
                        <div class="head">
                            <div class="image"
                                 style="background-image:url(https://aboutme.imgix.net/background/users/p/e/n/peng.su_1513480928_688.jpg?q=40&amp;dpr=2&amp;auto=format&amp;fit=max&amp;w=620&amp;h=413.3333333333333&amp;rect=0,160,1440,960);background-size:cover;background-position:center center;background-repeat:no-repeat;padding-bottom:66.66666666666667%"></div>
                            <div class="name-headline">
                                <section><h1 class="name">${user.name}</h1></section>
                            </div>
                        </div>
                        <div class="body">
                            <section class="spotlight"><a href="http://superssssss.cn" target="_blank"
                                                          rel="noopener noreferrer"
                                                          class="button large dark primary glyph-article">Read my blog</a>
                            </section>
                            <br/>
                            <section class="bio short-bio">
                                <div><p>没有无底的深渊，只有执迷不悟的灵魂</p>
                                    <p>没有不醒的噩梦，只有畏葸不前的懦夫</p></div>
                            </section>
                            <section class="interests">
                                <ul class="list-inline">
                                    <li class="interest">#<!-- --> basketball</li>
                                    <li class="interest">#<!-- --> reading</li>
                                    <li class="interest">#<!-- --> programming</li>
                                </ul>
                            </section>
                        </div>
                    </div>
                </c:if>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>power by <a href="http://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@super</a>.
                    </p>
                </div>
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
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
