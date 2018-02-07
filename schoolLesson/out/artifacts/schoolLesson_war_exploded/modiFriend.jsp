<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta  http-equiv="Content-Type" content="text/html;" charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="post" action="${pageContext.request.contextPath}/ControlerServlet?op=editFriend">
        <c:if test="${friend==null}">
          <h2 class="form-signin-heading">Register</h2>
        </c:if>
        <c:if test="${friend!=null}">
          <h2 class="form-signin-heading">Modification</h2>
        </c:if>
        <input type="hidden" name="id" value="${friend.id}"/>
        <label for="inputEmail" class="sr-only">name</label>
        <input type="input" id="inputEmail" class="form-control" placeholder="Username" name="name" value="${friend.name}" required autofocus>
        <label class="sr-only">Sex</label>
        <input type="radio" name="sex" value="nan" ${friend.sex=='nan'?'checked="checked"':''} />男
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="sex" value="nv" ${friend.sex=='nv'?'checked="checked"':''} />女
        <label for="Age" class="sr-only">Age</label>
        <input value="${friend.age}" type="input" id="Age" class="form-control" placeholder="Age" name="age"required>
        <label for="qq" class="sr-only">QQ</label>
        <input value="${friend.qq}" type="input" id="qq" class="form-control" placeholder="QQ" name="qq"required>
        <label for="telphone" class="sr-only">Telephone</label>
        <input value="${friend.telphone}" type="input" id="telphone" class="form-control" placeholder="Telephone" name="telphone"required>
        <label for="email" class="sr-only">Email</label>
        <input value="${friend.email}" type="email" id="email" class="form-control" placeholder="Email" name="email"required>
        <label for="address" class="sr-only">Address</label>
        <input value="${friend.address}" type="input" id="address" class="form-control" placeholder="Address" name="address" required>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit"/>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script type="text/javascript" src="js/jquery-1.11.3.min.js" charset="utf-8"></script>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
