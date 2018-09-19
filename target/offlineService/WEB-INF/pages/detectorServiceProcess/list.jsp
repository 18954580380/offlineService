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
    <link rel="stylesheet" type="text/css" media="screen"
          href="<%=path%>/layer/skin/layer.css">
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
                            <h2>服务任务列表</h2>
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
                                    <div>
                                        <form id="from1" class="smart-form" action="<%=path%>detectorServiceProcess/page">
                                            <!-- widget edit box -->
                                            <div class="jarviswidget-editbox">
                                                <!-- This area used as dropdown edit box -->
                                            </div>
                                            <!-- end widget edit box -->
                                            <!-- widget content -->
                                            <div class="widget-body no-padding">
                                                <div class="mt10 mb10">
                                                    <table class="table lh32">
                                                        <col width="100" />
                                                        <col width="220" />
                                                        <col width="100" />
                                                        <col width="280" />
                                                        <col width="100" />
                                                        <col />

                                                        <tbody>
                                                        <tr>
                                                            <td class="tr">联系方式:</td>
                                                            <td>
                                                                <label class="input">
                                                                    <input type="text" id="phoneNumber" name="phoneNumber" >
                                                                </label>
                                                            </td>
                                                            <td class="tr">姓名:</td>
                                                            <td>
                                                                <label class="input">
                                                                    <input type="text" id="name" name="name">
                                                                </label>
                                                            </td>
                                                            <td class="tr"></td>
                                                            <td>
                                                                <label class="input">
                                                                    <select name="status" >
                                                                        <option value="">全部</option>
                                                                        <option value="0">未完成</option>
                                                                        <option value="1">已完成</option>
                                                                    </select>
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <footer style="background: none;border-top: 0px">
                                                                    <button class="btn btn-primary" type="submit">查&nbsp;&nbsp;&nbsp;询</button>
                                                                    <button class="btn btn-default" onclick="cleanParam()" type="button">重&nbsp;&nbsp;&nbsp;置</button>
                                                                </footer>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>
                                            <!-- end widget content -->
                                        </form>
                                    </div>
                                    <!-- widget div-->
                                    <div
                                            style="text-align: center; margin: 20px 0; font: normal 14px/24px 'MicroSoft YaHei';">
                                    </div>
                                    <table id="borrow-rep-table1" class="table table-bordered"
                                           style="text-align:center;min-width:1100px">
                                        <thead>
                                        <tr>
                                            <td>姓名</td>
                                            <td>性别</td>
                                            <td>身高</td>
                                            <td>体重</td>
                                            <td>出生日期</td>
                                            <td>年龄</td>
                                            <td>联系方式</td>
                                            <td>服务项目</td>
                                            <td>其他项目服务状态</td>
                                            <td>服务状态</td>
                                            <td>操作者</td>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${pendingCustomersList}" var="c" varStatus="status">
                                            <tr>
                                                <td>${c.name}</td>
                                                <td>
                                                    <c:if test="${c.sex==1}">男</c:if>
                                                    <c:if test="${c.sex==2}">女</c:if>
                                                </td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td>${c.phoneNumber}</td>
                                                <td></td>
                                                <td>${c.completeStatus}</td>
                                                <td>
                                                    <c:if test="${c.status==1}">未完成</c:if>
                                                    <c:if test="${c.status==0}">未完成</c:if>
                                                </td>
                                                <td>${loginName}</td>
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
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script
            src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="<%=path%>/js/plugin/bootstrap-datetimepicker/bootstrap-datetimepicker.js"
            charset="UTF-8"></script>
    <script type="text/javascript"
            src="<%=path%>/js/plugin/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"
            charset="UTF-8"></script>
    <!-------datatables Jquery plugin-------->
    <script src="<%=path%>/js/plugin/datatables/jquery.dataTables-cust.js"></script>
    <script src="<%=path%>/js/plugin/datatables/DT_bootstrap.js"></script>
    <!-- MAIN APP JS FILE -->
    <script src="<%=path%>/js/app.js"></script>
    <!-- MAIN COMMON JS FILE -->
    <script src="<%=path%>/js/common.js"></script>
    <script src="<%=path%>/layer/layer.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            pageSetUp();
            DT_page("borrow-rep-table1", false, false, false);
        });
        //清空from表单
        function cleanParam(){
            $("#themeName").val("");
            $("#serviceAddress").val("");
            $("#blocName").val("");
        }
        function deleteById(id){
            layer.confirm('确定要删除健康主题么？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                $.ajax({
                    //几个参数需要注意一下
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "<%=path%>/healthTheme/deleteById",
                    data:{"id":id},
                    success: function (result) {
                        console.log(result);//打印服务端返回的数据(调试用)
                        if (result) {
                            window.location.href="<%=path%>/healthTheme/selectAll"
                        }
                        ;
                    },
                    error : function() {
                        layer.msg("添加失败");
                    }
                });
            });
        }
        function updateById(id){
            window.location.href="<%=path%>/healthTheme/updateById?id="+id
        }
    </script>
</div>
</body>
</html>