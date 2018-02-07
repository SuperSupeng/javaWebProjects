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

    <script>
        function showTips(id) {
            var password= document.getElementById("inputPassword").value;
            var repassword = document.getElementById(id).value;
            if(password!=repassword){
                alert("input the same password!");
                document.getElementById("submit").setAttribute("disabled",true);
                return;
            }else{
                document.getElementById("submit").removeAttribute("disabled");
            }
        }
    </script>
  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="post" action="${pageContext.request.contextPath}/ControlerServlet?op=register">
        <h2 class="form-signin-heading">Register</h2>
        <label for="inputEmail" class="sr-only">name</label>
        <input type="input" id="inputEmail" class="form-control" placeholder="Username" name="username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
        <label for="rePassword" class="sr-only">RePassword</label>
        <input type="password" id="rePassword" class="form-control" placeholder="Password" name="repassword" onblur="showTips('rePassword')" required>
        <button class="btn btn-lg btn-primary btn-block" id="submit" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script type="text/javascript" src="js/jquery-1.11.3.min.js" charset="utf-8"></script>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
