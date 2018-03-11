<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/3/7
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>iotInformation</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="js/jquery-1.11.3.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.js"></script>
  <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
  <script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
</head>
  <body>
  <div class="container">
    <form action="" class="form-horizontal"  role="form">
      <fieldset>
        <legend>iotInformation</legend>
        <div class="form-group">
          <label for="dtp_input2" class="col-md-2 control-label">起始时间</label>
          <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-MM-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
            <input class="form-control" size="16" type="text" value="" name="startDate" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
          </div>
          <input type="hidden" id="dtp_input2" value="" /><br/>
        </div>
        <div class="form-group">
          <label for="dtp_input3" class="col-md-2 control-label">结束时间</label>
          <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-MM-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
            <input class="form-control" size="16" type="text" value="" name="endDate" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
          </div>
          <input type="hidden" id="dtp_input3" value="" /><br/>
        </div>
      </fieldset>
      <input type="submit" class="btn btn-primary" value="查询"/>
    </form>
    <div class="btn-group" role="group" aria-label="...">
      <button type="button" class="btn btn-info">升序</button>
      <button type="button" class="btn btn-success">降序</button>
    </div>

    <table class="table table-bordered">
      <thead>
      <tr>
        <th>#</th>
        <th>id</th>
        <th>Date</th>
        <th>Temperature</th>
      </tr>
      </thead>
      <tbody>

      <c:forEach items="${tempList}" var="c" varStatus="vs">
        <tr>
          <td>${vs.count}</td>
          <td>${c.id}</td>
          <td>${c.dataDate}</td>
          <td>${c.temperature}</td>
        </tr>
      </c:forEach>

      </tbody>
    </table>
  </div>

  <script type="text/javascript">
      $('.form_date').datetimepicker({
          language:  'fr',
          weekStart: 1,
          todayBtn:  1,
          autoclose: 1,
          todayHighlight: 1,
          startView: 2,
          minView: 2,
          forceParse: 0
      });
  </script>
  </body>
</html>
