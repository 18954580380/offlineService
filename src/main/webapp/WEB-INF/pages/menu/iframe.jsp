<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/base.jsp" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Kode is a Premium Bootstrap Admin Template, It's responsive, clean coded and mobile friendly">
    <meta name="keywords" content="bootstrap, admin, dashboard, flat admin template, responsive," />
    <title>Kode - Premium Bootstrap Admin Template</title>

    <!-- ========== Css Files ========== -->
    <link href="<%=path%>/TheHomePageTemplate/css/root.css" rel="stylesheet">
    <style>
        .sidebar-panel li a .caret {
            top: 40px;
        }
        .sidebar-panel li a:hover{
            background: #2d374a;
        }
        .sidebar-panel li a.active{
            background: #2d374a;
            border-bottom: none;
        }
        .nav_a_bord{
            border-bottom: 1px solid #3d475b;
            border-top: 1px solid #3d475b;
            border-image: -webkit-linear-gradient( #3d475b , #151a23) 30 30;
            border-image: -moz-linear-gradient(#3d475b , #151a23) 30 30;
            border-image: linear-gradient( #3d475b , #151a23) 30 30;
        }
        /*.nav_bgimg{*/
            /*background: url("/emp/jiaoben5599/img/nav_down.png") no-repeat;*/
            /*background-position: 240px 35px;*/
        /*}*/
        /*.sidebar-panel li a.active{*/
            /*background:  #2d374a url("/emp/jiaoben5599/img/nav_up.png") no-repeat;*/
            /*background-position: 240px 35px;*/
        /*}*/
        .nav_nav2_ul{
            text-align: center;width: 100%;
            background: #2d374a !important;
        }
        .caret_img{
            width: 15px;
            height: 15px;
            position: absolute;
            right: 25px;
            top: 40px;
            background: url("<%=path%>/jiaoben5599/img/nav_down.png") no-repeat;
        }
        li a.active .caret_img{
            background: url("<%=path%>/jiaoben5599/img/nav_up.png") no-repeat;
        }

    </style>
</head>

<body style="background: #242c3b;overflow: hidden;">
 <div id="top" class="clearfix">
  	<!-- Start App Logo -->
  	<div class="applogo">
  		<a href="index.html" class="logo">kode</a>
  	</div>
  	<!-- End App Logo -->
  </div>
  <!-- END TOP -->
<div class="row">
    <h6>
    <ul class="sidebar-panel nav" style="height: 47px;">
        <li><a href="#">&nbsp;</a></li>
    </ul>
    <ul class="sidebar-panel nav" style="    width: 100%;margin: 0px;border: none;padding-top: 0px;">
        <li>
            <a href="<%=path%>/healthTheme/selectAll" target="showframe" class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color6" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-university"></i></span>
                <span>健康主题模板</span>
            </a>
        </li>
        <li>
            <a href="<%=path%>/healthThemeTask/selectAll" target="showframe" class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color6" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-th-list"></i></span>
                <span>服务任务列表</span>
            </a>
        </li>
        <li>
            <a href="<%=path%>/todayServiceCustomers/selectAll" target="showframe" class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color6" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-user-md"></i></span>
                <span>今日服务对象</span>
            </a>
        </li>
        <li>
            <a href="<%=path%>/serviceAnalyze/list" target="showframe" class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color6" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-database"></i></span>
                <span>线下服务汇总详情</span>
            </a>
        </li>
      <%--   <li>
            <a href="<%=path%>/testFirst/dailyInspection" target="showframe" class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color7" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-pie-chart"></i></span>
                <span>日常指标监测</span>
                <span class="caret_img"></span>
            </a>
            <ul class="nav_nav2_ul" >
                <li><a href="<%=path%>/testFirst/dailyInspection" target="showframe">日常监测情况</a></li>
                <li><a href="<%=path%>/testFirst/dataAnalysis" target="showframe">监测数据分析</a></li>
            </ul>
        </li>

        <li>
            <a href="<%=path%>/testFirst/skipManagement" target="showframe" class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color7" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-flask"></i></span>
                <span>营养运动管理</span>
                <span class="caret_img"></span>
            </a>
            <ul class="nav_nav2_ul" >
                <li><a href="<%=path%>/testFirst/skipManagement" target="showframe">员工运动情况</a></li>
                <li><a href="<%=path%>/motionAssessment/list" target="showframe">运动风险评估</a></li>
            </ul>
        </li>

        <li>
            <a  class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color6" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-area-chart"></i></span>
                <span>体检数据管理</span>
                <span class="caret_img"></span>
            </a>
           <!--  <ul class="nav_nav2_ul">
                <li><a target="showframe">体检概论</a></li>
                <li><a  target="showframe">历年体检对比</a></li>
            </ul> -->
        </li>
        <li>
            <a  class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color7" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-flask"></i></span>
                <span>慢病风险管理</span>
                <span class="caret_img"></span>
            </a>
            <ul class="nav_nav2_ul">
                <li><a  target="showframe">慢病风险评估</a></li>
                <li><a  target="showframe">员工慢病管理</a></li>
            </ul>
        </li>
        <li>
            <a  class="nav_a_bord" style="padding: 49px 5px 9px;text-align: center;width: 100%;margin: 0px;">
                <span class="icon color7" style="top: 13px;left: 50%;margin-left: -12px;"><i class="fa fa-flask"></i></span>
                <span>健康管理服务</span>
                <span class="caret_img"></span>
            </a>
            <ul class="nav_nav2_ul">
                <li><a  target="showframe">管理服务进程</a></li>
                <li><a  target="showframe">管理效果分析</a></li>
            </ul>
        </li> --%>

    </ul>
    </h6>
</div>


<!-- END SIDEBAR -->
<!-- //////////////////////////////////////////////////////////////////////////// -->

<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/jquery.min.js"></script>
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/plugins.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/bootstrap-select/bootstrap-select.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/flot-chart/flot-chart.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/flot-chart/flot-chart-time.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/flot-chart/flot-chart-stack.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/flot-chart/flot-chart-pie.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/flot-chart/flot-chart-plugin.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/easypiechart/easypiechart.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/easypiechart/easypiechart-plugin.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/sparkline/sparkline.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/sparkline/sparkline-plugin.js"></script>
<script src="<%=path%>/TheHomePageTemplate/js/rickshaw/d3.v3.js"></script>
<script src="<%=path%>/TheHomePageTemplate/js/rickshaw/rickshaw.js"></script>
<script src="<%=path%>/TheHomePageTemplate/js/rickshaw/rickshaw-plugin.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/moment/moment.min.js"></script>

</body>
</html>
