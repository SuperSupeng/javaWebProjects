<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/3/7
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
  <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
  <script type="text/javascript" src="js/Chart.js"></script>
  <script type="text/javascript" src="js/Chart.bundle.js"></script>
  <script type="text/javascript" src="js/util.js"></script>
</head>
  <body>
  <div class="container">
    <form class="form-horizontal" method="post" role="form" action="${pageContext.request.contextPath}/ChangeServlet">
      <fieldset>
        <legend>iotInformation</legend>
        <div class="form-group">
          <label for="dtp_input2" class="col-md-2 control-label">起始时间</label>
          <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy/MM/dd" data-link-field="dtp_input2" data-link-format="yyyy/mm/dd">
            <input class="form-control" size="16" type="text" value="" name="startDate">
            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
          </div>
          <input type="hidden" id="dtp_input2" value="" /><br/>
        </div>
        <div class="form-group">
          <label for="dtp_input3" class="col-md-2 control-label">结束时间</label>
          <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy/MM/dd" data-link-field="dtp_input2" data-link-format="yyyy/mm/dd">
            <input class="form-control" size="16" type="text" value="" name="endDate">
            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
          </div>
          <input type="hidden" id="dtp_input3" value="" /><br/>
        </div>
      </fieldset>
      <input type="submit" class="btn btn-info" value="查询" name="inverse"/>
    </form>

    <canvas id="myChart" width="400" height="400"></canvas>
    <script type="text/javascript">
        var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        var myarry = new Array();
        var config = {
            type: 'line',
            data: {
                labels: MONTHS,
                datasets: [{
                    label: 'Temperature',
                    backgroundColor: window.chartColors.red,
                    borderColor: window.chartColors.red,
                    data: myarry,
                    fill: false,
                }]
            },
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: '温度曲线'
                },
                tooltips: {
                    mode: 'index',
                    intersect: false,
                },
                hover: {
                    mode: 'nearest',
                    intersect: true
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Month'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Value'
                        }
                    }]
                }
            }
        };
        <c:forEach items="${changeTempList}" var="c" varStatus="vs">
          myarry[${vs.index}]= ${c.temperature};
        </c:forEach>

        <%--alert(typeof 20);--%>
        <%--alert(typeof ${changeTempList[0].temperature})--%>

        window.onload = function() {
            var ctx = document.getElementById('myChart').getContext('2d');
            window.myLine = new Chart(ctx, config);
        };

        $('.form_date').datetimepicker({
            language:'zh-CN',
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            minView: 2,
            format:'yyyy/mm/dd'
        });
    </script>
  </body>
</html>
