<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/base.jsp" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>线下服务</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <%@include file="/WEB-INF/pages/include/common_css.jsp" %>
    <%@include file="/WEB-INF/pages/include/common_js.jsp" %>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="<%=path%>/css/bootstrap/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="<%=path%>/css/bootstrap/bootstrap-datetimepicker.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="<%=path%>/css/smartadmin-production_unminified.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="<%=path%>/css/base.css">
    <!-- FAVICONS -->
    <link rel="shortcut icon" href="<%=path%>/img/favicon/favicon.ico" type="image/x-icon">
    <link rel="icon" href="<%=path%>/img/favicon/favicon.ico" type="image/x-icon">
</head>

<body>
<!-- HEADER -->
<header id="header" style="background: #17BC84">
    <div id="logo-group">
        <!-- PLACE YOUR LOGO HERE -->
        <!--<span id="logo"> <img src="img/logo.png" alt="logo"> </span>-->
        <span id="logo"> <img src="<%=path%>/img/kbr.png" alt="logo" style="width: 300px; height: 50px"> </span>
        <!-- END LOGO PLACEHOLDER -->
    </div>

    <!-- pulled right: nav area -->
    <div class="pull-right">
        <!-- collapse menu button -->
        <div id="hide-menu" class="btn-header pull-right">
            <span> <a href="javascript:void(0);" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
        </div>
        <!-- end collapse menu -->

        <!-- logout button -->
        <div id="logout" class="btn-header transparent pull-right">
            <span> <a href="login.html" title="Sign Out"><i class="fa fa-sign-out"></i></a> </span>
        </div>
        <!-- end logout button -->

        <!-- search mobile button (this is hidden till mobile view port) -->
        <div id="search-mobile" class="btn-header transparent pull-right">
            <span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
        </div>
        <!-- end search mobile button -->

    </div>
    <!-- end pulled right: nav area -->
</header>
<!-- END HEADER -->
<!--------LEFT SIDER---------->
<aside id="left-panel" style="height: 100%">

    <!-- User info -->
    <div class="login-info">
            <span> <!-- User image size is adjusted inside CSS, it should stay as it --> 
				<a href="javascript:void(0);" id="show-shortcut">
                     <img src="<%=path%>/img/avatars/sunny.png" alt="me" class="online"/>
                    <span>操作者</span>
            <i class="fa fa-angle-down"></i>
            </a>
            </span>
    </div>
    <!-- end user info -->

    <!-- NAVIGATION : This navigation is also responsive

        To make this navigation dynamic please make sure to link the node
        (the reference to the nav > ul) after page load. Or the navigation
        will not initialize.
        -->
    <nav>
        <!-- NOTE: Notice the gaps after each icon usage <i></i>..
            Please note that these links work a bit different than
            traditional href="" links. See documentation for details.
            -->
        <kbr:menu/>
    </nav>
    <span class="minifyme"> <i class="fa fa-arrow-circle-left hit"></i> </span>
</aside>
<div id="main" role="main">
    <div id="content">
        <div class="row">
            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
              <!--   <h4 class="page-title txt-color-blueDark"><i class="fa-fw fa fa-cog"></i> 首页 </h4> -->
            </div>
        </div>

        <section id="widget-grid" class="">
            <div class="row">
                <!-- NEW WIDGET START -->
                <article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <!--
                    -->
                    <!-- NEW WIDGET START -->
                    <!-- 	<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
                    <div class="jarviswidget jarviswidget-color-darken" id="wid-id-12" data-widget-sortable="false">
                        <header>
                            <span class="widget-icon"> <i class="fa fa-table"></i> </span>
                            <h2>菜单列表</h2>
                        </header>
                        <!-- widget div-->
                        <div>
                            <form class="smart-form">
                                <!-- widget edit box -->
                                <div class="jarviswidget-editbox">
                                    <!-- This area used as dropdown edit box -->
                                </div>
                                <!-- end widget edit box -->
                                <!-- widget content -->
                                <div class="widget-body">
                                    <div class="widget-body-nobg-toolbar" style="overflow:hidden;">
                                        <a class="btn btn-default fl table-nobg-btn" href='<%=path%>/menu/add' ;><i
                                                class="fa fa-plus"></i>&nbsp;添加菜单</a>
                                    </div>
                                    <table id="borrow-rep-table1" class="table table-bordered"
                                           style="text-align:center;min-width:1100px">
                                        <thead>
                                        <tr>
                                            <td>序号</td>
                                            <td>菜单名称</td>
                                            <td>菜单地址</td>
                                            <td>创建时间</td>
                                            <td>是否菜单</td>
                                            <td>图片class</td>
                                            <td>操作</td>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="t" varStatus="status">
                                            <tr>
                                                <td>${status.index}</td>
                                                <td>${t.menuName}</td>
                                                <td>${t.menuUrl}</td>
                                                <td><fmt:formatDate value="${t.createTime}" pattern="yyyy-MM-dd"/></td>
                                                <td>${t.isMenu}</td>
                                                <td>${t.imgClass}</td>
                                                <td></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </form>
                        </div>
                    </div>
                </article>
            </div>

        </section>
    </div>
    <script type="text/javascript" src="<%=path%>/js/plugin/bootstrap-datetimepicker/bootstrap-datetimepicker.js"
            charset="UTF-8"></script>
    <script type="text/javascript"
            src="<%=path%>/js/plugin/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"
            charset="UTF-8"></script>

</div>
</body>
</html>