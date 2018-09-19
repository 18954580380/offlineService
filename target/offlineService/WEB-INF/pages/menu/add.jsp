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
  <div id="ribbon">
        <!-- breadcrumb -->
        <ol class="breadcrumb">
            <li>菜单管理</li>
            <li>新建菜单</li>
        </ol>
        <!-- end breadcrumb -->
    </div>
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
                 <!-- NEW WIDGET START -->
                <form id="addMenu" action="${ctx}/menu/save">
                    <article class="col-sm-12 col-md-12 sortable-grid ui-sortable">

                        <div class="jarviswidget" id="wid-id-711" data-widget-colorbutton="false"
                             data-widget-editbutton="false" data-widget-deletebutton="false"
                             data-widget-fullscreenbutton="false">
                            <header>
                                <h2>新建菜单<font class="pl10 f12 color07"></font></h2>
                            </header>
                            <!-- widget div-->
                            <div>
                                <div class="smart-form">
                                    <!-- widget content -->
                                    <div class="widget-body no-padding">
                                        <div class="m20">
                                            <div style="display: none"
                                                 class="alert alert-block alert-success ml15 mr15">
                                                <p><i class="fa fa-check-circle pr15"></i>保存成功</p>
                                            </div>
                                            <div style="display: none" class="alert alert-danger alert-block ml15 mr15">
                                                <p><i class="fa fa-exclamation-circle pr15"></i>保存失败</p>
                                            </div>
                                        </div>
                                        <div class="mt10 mb10 ml30">
                                            <table class="table">
                                                <col width="112"/>
                                                <col/>
                                                <tbody>
                                                <tr>
                                                    <td align="left">菜单名称：</td>
                                                    <td>
                                                        <label class="input">
                                                            <input type="text" maxlength="50" name="menuName" value=""
                                                                   style="width:256px;"/>
                                                        </label>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td align="left">菜单地址：</td>
                                                    <td>
                                                        <label class="input" style="width:256px;">
                                                            <input type="text" maxlength="50" name="menuUrl" value=""
                                                                   style="width:256px;">
                                                        </label>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td align="left">排序：</td>
                                                    <td>
                                                        <label class="input" style="width:256px;">
                                                            <input type="text" maxlength="50" name="sort" value=""
                                                                   style="width:256px;">
                                                        </label>
                                                    </td>
                                                </tr>

                                                <%-- <tr>
                                                    <td align="left">开始时间：</td>
                                                    <td>
                                                        <section class="fl">
                                                            <label class="input" style="width:256px;"> <i
                                                                    class="icon-append fa fa-calendar"></i>
                                                                <input type="text" name="selectdate1" class="selectdate"
                                                                       placeholder="请选择时间">
                                                            </label>
                                                        </section>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td align="left">结束时间：</td>
                                                    <td>
                                                        <section class="fl">
                                                            <label class="input" style="width:256px;"> <i
                                                                    class="icon-append fa fa-calendar"></i>
                                                                <input type="text" name="selectdate2" class="selectdate"
                                                                       placeholder="请选择时间">
                                                            </label>
                                                        </section>
                                                    </td>
                                                </tr> --%>
                                                </tbody>
                                            </table>
                                            <div class="mt50 mb20" id="wid-id-713">
                                                <button class="btn btn-success table-nobg-btn" id="save"
                                                        type="button"><i
                                                        class="fa fa-clipboard mr5"></i>保存
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </article>
                </form>
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
<script type="text/javascript" charset="utf-8">
    $(document).ready(function () {
        $('.selectdate').datetimepicker({
            language: 'zh-CN',
            weekStart: 1,
            autoclose: 1,
            format: 'yyyy-mm-dd',
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    });

    $("#save").click(function () {
        $("#addMenu").ajaxSubmit({
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            type: 'post',
            success: function (data) {
                alert(data);
                if (data.code == '0') {
                    jAlert("提交成功!", '成功提示', function (r) {
                        window.location.href = "${ctx}/menu/list";
                    });
                } else {
                    jAlert("提交失败，失败原因：" + data.msg, '失败提示', function (r) {
                        <%--window.location.href = "${ctx}/sys/dict/list";--%>
                    });
                }
            }
        });
    });


</script>

</div>
</body>
</html>