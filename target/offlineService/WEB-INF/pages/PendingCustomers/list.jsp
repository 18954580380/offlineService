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
    <title>Kode</title>
    <!-- ========== Css Files ========== -->
    <link href="<%=path%>/TheHomePageTemplate/css/root.css" rel="stylesheet">
</head>
<body style="background:#f5f5f5">
<style>
    .border_radius10{
        border-radius: 10px;
    }
    .fontsize36{
        font-size: 36px !important;
    }
    .nav li .list_btn,.nav li:hover .list_btn{
        padding-top: 0;width: 60px;height: 40px;
        background: url("${ctx}/jiaoben5599/img/list_img.png") no-repeat;
        background-size: 30px;
        background-position-x: 15px;
    }
    .nav li.active .list_btn,.nav li.active:hover .list_btn{
        background: url("${ctx}/jiaoben5599/img/list_img_ac.png") no-repeat;
        background-size: 30px;
        background-position-x: 15px;
    }

    .nav li .graph_btn,.nav li:hover .graph_btn{
        padding-top: 0;width: 60px;height: 40px;
        background: url("${ctx}/jiaoben5599/img/graph_img.png") no-repeat;
        background-size: 30px;
        background-position-x: 15px;
    }
    .nav li.active .graph_btn,.nav li.active:hover .graph_btn{
        background: url("${ctx}/jiaoben5599/img/graph_img_ac.png") no-repeat;
        background-size: 30px;
        background-position-x: 15px;
    }


</style>
<%--文字特效--%>
<link href="${ctx}/jiaoben3904/css/styles.css" rel="stylesheet">
<style type="text/css">
    .demo{  padding: 2em 0;}
    .top_btn_left{
        height: 60px;
        font-size: 22px;
        display: block;
        width: 62px;
        text-align: center;
        float: right;
        color: rgba(255, 242, 248, 0.6);
        padding-top: 15px;
        /*border-left: 1px solid rgba(0, 0, 0, 0.14);*/
        z-index: 1;
    }
    .counter{
        background: #fff;
        text-align: center;
        position: relative;
    }
    /*设置字体*/
    .counter .counter-content{
        padding: 30px 5px 50px;
        color: #fff2f8;
        position: relative;
    }
    .counter:before,
    .counter:after,
    .counter .counter-content:before,
    .counter:after{
        left: auto;
        right: 15px;
    }
    .counter .counter-content:before,
    .counter .counter-content:after{
        box-shadow: inset 0 -2px 2px #fff2f8;
        top: auto;
        bottom: 15px;
    }
    .counter .counter-content:after{
        left: auto;
        bottom: 15px;
        right: 15px;
    }
    .counter .counter-icon{
        display: inline-block;
        font-size: 30px;
        margin-bottom: 15px;
    }
    .counter .counter-value{
        display: block;
        font-size: 20px;
        margin-bottom: 15px;
    }
    .counter .title{
        color: #ffffff;
        font-size: 13px;
        text-transform: uppercase;
        text-shadow: 3px 3px 2px rgba(0, 14, 255, 0);
    }
    @media only screen and (max-width: 990px){
        .counter{ margin-bottom: 20px; }
    }
    @media screen and (max-width: 990px) {
        .container .col-md-2 {
            width:16%!important;
            padding-right: 0px;
        }
        .container .col-md-1,.container .col-md-2, .container.col-md-3,.container .col-md-4,.container .col-md-5,.container .col-md-6, .container.col-md-7, .container.col-md-8,.container .col-md-9, .container.col-md-10, .container.col-md-11, .container.col-md-12 {
            float: left !important;

        }
    }

    .container .col-md-2 {
        width:16% !important;
        padding-right: 0px;
    }
    .container .col-md-1,.container .col-md-2, .container.col-md-3,.container .col-md-4,.container .col-md-5,.container .col-md-6, .container.col-md-7, .container.col-md-8,.container .col-md-9, .container.col-md-10, .container.col-md-11, .container.col-md-12 {
        float: left !important;

    }
    .border_radius10{
        border-radius: 10px;
    }
    .image-list .img{
        top: 6px;
    }
</style>
<!-- Start Page Loading -->
<div class="loading"><img src="<%=path%>/TheHomePageTemplate/img/loading.gif" alt="loading-img"></div>
<!-- End Page Loading -->
<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START TOP -->
<div id="top" class="clearfix">
    <!-- Start Sidebar Show Hide Button -->
    <a href="#" class="sidebar-open-button"><i class="fa fa-bars"></i></a>
    <a href="#" class="sidebar-open-button-mobile"><i class="fa fa-bars"></i></a>
    <!-- End Sidebar Show Hide Button -->

    <!-- Start Searchbox -->
    <form class="searchform">
        <input type="text" class="searchbox" id="searchbox" placeholder="Search">
        <span class="searchbutton"><i class="fa fa-search"></i></span>
    </form>
    <!-- End Searchbox -->

    <!-- Start Top Menu -->
    <ul class="topmenu">
        <li><a href="#">Files</a></li>
        <li><a href="#">Authors</a></li>
        <li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">My Files <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Videos</a></li>
                <li><a href="#">Pictures</a></li>
                <li><a href="#">Blog Posts</a></li>
            </ul>
        </li>
    </ul>
    <!-- End Top Menu -->

    <!-- Start Sidepanel Show-Hide Button -->
    <a href="#sidepanel" class="sidepanel-open-button"><i class="fa fa-outdent"></i></a>
    <!-- End Sidepanel Show-Hide Button -->

    <!-- Start Top Right -->
    <ul class="top-right">

        <li class="dropdown link">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle hdbutton">Create New <span class="caret"></span></a>
            <ul class="dropdown-menu dropdown-menu-list">
                <li><a href="#"><i class="fa falist fa-paper-plane-o"></i>Product or Item</a></li>
                <li><a href="#"><i class="fa falist fa-font"></i>Blog Post</a></li>
                <li><a href="#"><i class="fa falist fa-file-image-o"></i>Image Gallery</a></li>
                <li><a href="#"><i class="fa falist fa-file-video-o"></i>Video Gallery</a></li>
            </ul>
        </li>

        <li class="link">
            <a href="#" class="notifications">6</a>
        </li>

     <li class="dropdown link">
     <a href="#" data-toggle="dropdown" class="dropdown-toggle profilebox"><img src="<%=path%>/TheHomePageTemplate/img/profileimg.png" alt="img"><b>${loginName }</b><span class="caret"></span></a>
        <ul class="dropdown-menu dropdown-menu-list dropdown-menu-right">
          <li><a href="<%=path%>/logout" target="showlayout"><i class="fa falist fa-power-off"></i> 退出登录</a></li>
        </ul>
    </li>

    </ul>
    <!-- End Top Right -->

</div>

<!-- END TOP -->
<!-- //////////////////////////////////////////////////////////////////////////// -->

<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START CONTENT -->
<!-- END SIDEBAR -->
<!-- //////////////////////////////////////////////////////////////////////////// -->

<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- Start Page Header -->
<div class="page-header">
</div>
<!-- End Page Header -->
<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START CONTAINER -->
<div class="container-padding" style="margin-top: 60px">
    <!-- Start Row -->
    <div class="row btndiv">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-12 col-lg-6" style="padding-left:0px">
                        <a href='#' class="btn" style="background: none;font-size: 16px"><font color="blue">计划邀约客户类别${date}</font></a>
                        <a href="#" class="btn"  style="background: none;font-size: 16px" onclick="selectServiceCustomers()"><font>今日服务对象  &nbsp;&nbsp;&nbsp;</font></a>
                        <input  type="text" name="date" class="selectdate" placeholder="邀约日期" onchange="getDate()" style="height: 30px " value="${date}">
                    </div>
                    <!-- Start right -->
                    <div class="col-md-12"   background-color="white;" style="margin-bottom: 10px;padding: 0px;margin-right: 1px">
                        <div class="container" style="width: 100%;padding: 0;">
                            <div class="row" style=' padding: 0 20px;'>
                                <div class="col-md-2 " >
                                    <div class="counter border_radius10"  style="background-color:#6ccac9;">
                                        <a href="#" data-toggle="dropdown" class="dropdown-toggle profilebox">
                                            <div class="counter-content" style="padding-top: 50px;padding-bottom: 40px;"onclick="select(0)">
                                                <h3 class="title">
                                                    <i class="fa fa-newspaper-o"></i>
                                                    主题筛选客户
                                                </h3>
                                                <span  class="counter-value" style="margin: 0;">${a}</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-2" >
                                    <div class="counter border_radius10"  style="background-color:#ff6c60;">
                                        <a href="#" data-toggle="dropdown" class="dropdown-toggle profilebox">
                                            <div class="counter-content" style="padding-top: 50px;padding-bottom: 40px;"onclick="select(1)">
                                                <h3 class="title">
                                                    <i class="fa fa-bicycle"></i>
                                                    主动报名客户
                                                </h3>
                                                <span  class="counter-value" style="margin: 0;">${b}</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-2" >
                                    <div class="counter border_radius10" style="background-color:#f8d346;">
                                        <a href="#" data-toggle="dropdown" class="dropdown-toggle profilebox" >
                                            <div class="counter-content" style="padding-top: 50px;padding-bottom: 40px;"onclick="select(2)">
                                                <h3 class="title"><i class="fa fa-beer"></i>
                                                    任务未完成客户
                                                </h3>
                                                <span class="counter-value" style="margin: 0;">${c}</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-2" >
                                    <div class="counter border_radius10" style="background-color:#57c8f2;">
                                        <a href="#" data-toggle="dropdown" class="dropdown-toggle profilebox">
                                            <div class="counter-content" style="padding-top: 50px;padding-bottom: 40px;"onclick="select(3)">
                                                <h3 class="title">
                                                    <i class="fa fa-book"></i>
                                                    套餐未完成客户
                                                </h3>
                                                <span  class="counter-value" style="margin: 0px;">${d}</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-2" style="padding-right:15px" >
                                    <div class="counter border_radius10" style="background-color:#d978f8;">
                                        <a href="#" data-toggle="dropdown" class="dropdown-toggle profilebox">
                                            <div class="counter-content" style="padding-top: 50px;padding-bottom: 40px;"onclick="select(4)">
                                                <h3 class="title">
                                                    <i class="fa fa-circle-o-notch"></i>
                                                    上次未服务客户
                                                </h3>
                                                <span  class="counter-value" style="margin: 0px;">${e}</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-2" style="padding-right:15px" >
                                    <div class="counter border_radius10" style="background-color:#A0B0DF;">
                                        <a href="javascript:selectCustomize()">
                                            <div class="counter-content" style="padding-top: 37px;padding-bottom: 40px;" >
                                                <h3 class="title" style="border-top: none">
                                                    <i class="fa fa-circle-o-notch"></i>
                                                    自定义添加客户
                                                </h3>
                                                <span  class="counter-value" style="margin: 0px;"><img src="<%=path%>/img/92620.png" style="width: 42px;height: 34px;background: #A0B0DF"></span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End right -->
                </div>
            </div>
        </div>
    </div>
    <!-- end Row -->
    <!-- Start Row -->
    <div class="row">
        <!-- Start Panel -->
        <div class="col-md-12">
            <div class="panel panel-default">
                <!-- from -->
                <div class="panel-body">
                    全部待邀约客户${count}
                    <form id="fromId" class="form-inline">
                        <div class="form-group">
                            <label  class="form-label">公司</label>
                            <input style="width: 230px" type="text"  class="form-control" id="blocName" name="blocName">
                        </div>
                        <div class="form-group">
                            <label  class="form-label">部门</label>
                            <input type="hidden" name="source" id="sourceId" style="height: 20px;width: 100px;"/>
                            <input style="width: 230px" type="text" id="dept" name="dept" class="form-control"  >
                        </div>
                        <div class="form-group">
                            <label  class="form-label">联系方式</label>
                            <input style="width: 230px" type="text" id="phoneNumber" name="phoneNumber" class="form-control">
                        </div>
                        <div class="form-group">
                            <label  class="form-label">姓名</label>
                            <input style="width: 230px" type="text" id="name" name="name" class="form-control">
                        </div>
                        <button type="button" class="btn btn-default" id="findTemplate">查询</button>
                        <button type="button" class="btn btn-default" onclick ="sendAMessage(${themeTaskId})">发送消息</button>
                    </form>
                </div>
                <div class="panel-title">

                </div>
                <div class="panel-body table-responsive">
                    <table id="task" class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th style="background:none;">
                                <div class="checkbox margin-t-0 text-center">
                                    <input  id="checkbox101" type="checkbox" onclick="pitchOn(this)" >
                                    <label for="checkbox101">
                                    </label>
                                </div>
                            </th>
                            <th >姓名</th>
                            <th >部门</th>
                            <th >性别</th>
                            <th >联系方式</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- End Panel -->
    </div>
    <!-- End Row -->
</div>
<!-- END CONTAINER -->
<!-- //////////////////////////////////////////////////////////////////////////// -->
</div>
<!-- End Content -->
<!-- //////////////////////////////////////////////////////////////////////////// -->

<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START SIDEPANEL -->
<div role="tabpanel" class="sidepanel">

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#today" aria-controls="today" role="tab" data-toggle="tab">TODAY</a></li>
        <li role="presentation"><a href="#tasks" aria-controls="tasks" role="tab" data-toggle="tab">TASKS</a></li>
        <li role="presentation"><a href="#chat" aria-controls="chat" role="tab" data-toggle="tab">CHAT</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">

        <!-- Start Today -->
        <div role="tabpanel" class="tab-pane active" id="today">

            <div class="sidepanel-m-title">
                Today
                <span class="left-icon"><a href="#"><i class="fa fa-refresh"></i></a></span>
                <span class="right-icon"><a href="#"><i class="fa fa-file-o"></i></a></span>
            </div>

            <div class="gn-title">NEW</div>

            <ul class="list-w-title">
                <li>
                    <a href="#">
                        <span class="label label-danger">ORDER</span>
                        <span class="date">9 hours ago</span>
                        <h4>New Jacket 2.0</h4>
                        Etiam auctor porta augue sit amet facilisis. Sed libero nisi, scelerisque.
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="label label-success">COMMENT</span>
                        <span class="date">14 hours ago</span>
                        <h4>Bill Jackson</h4>
                        Etiam auctor porta augue sit amet facilisis. Sed libero nisi, scelerisque.
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="label label-info">MEETING</span>
                        <span class="date">at 2:30 PM</span>
                        <h4>Developer Team</h4>
                        Etiam auctor porta augue sit amet facilisis. Sed libero nisi, scelerisque.
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="label label-warning">EVENT</span>
                        <span class="date">3 days left</span>
                        <h4>Birthday Party</h4>
                        Etiam auctor porta augue sit amet facilisis. Sed libero nisi, scelerisque.
                    </a>
                </li>
            </ul>

        </div>
        <!-- End Today -->

        <!-- Start Tasks -->
        <div role="tabpanel" class="tab-pane" id="tasks">

            <div class="sidepanel-m-title">
                To-do List
                <span class="left-icon"><a href="#"><i class="fa fa-pencil"></i></a></span>
                <span class="right-icon"><a href="#"><i class="fa fa-trash"></i></a></span>
            </div>

            <div class="gn-title">TODAY</div>

            <ul class="todo-list">
                <li class="checkbox checkbox-primary">
                    <input id="checkboxside1" type="checkbox"><label for="checkboxside1">Add new products</label>
                </li>

                <li class="checkbox checkbox-primary">
                    <input id="checkboxside2" type="checkbox"><label for="checkboxside2"><b>May 12, 6:30 pm</b> Meeting with Team</label>
                </li>

                <li class="checkbox checkbox-warning">
                    <input id="checkboxside3" type="checkbox"><label for="checkboxside3">Design Facebook page</label>
                </li>

                <li class="checkbox checkbox-info">
                    <input id="checkboxside4" type="checkbox"><label for="checkboxside4">Send Invoice to customers</label>
                </li>

                <li class="checkbox checkbox-danger">
                    <input id="checkboxside5" type="checkbox"><label for="checkboxside5">Meeting with developer team</label>
                </li>
            </ul>
            <div class="gn-title">TOMORROW</div>
            <ul class="todo-list">
                <li class="checkbox checkbox-warning">
                    <input id="checkboxside6" type="checkbox"><label for="checkboxside6">Redesign our company blog</label>
                </li>

                <li class="checkbox checkbox-success">
                    <input id="checkboxside7" type="checkbox"><label for="checkboxside7">Finish client work</label>
                </li>

                <li class="checkbox checkbox-info">
                    <input id="checkboxside8" type="checkbox"><label for="checkboxside8">Call Johnny from Developer Team</label>
                </li>

            </ul>
        </div>
        <!-- End Tasks -->

        <!-- Start Chat -->
        <div role="tabpanel" class="tab-pane" id="chat">

            <div class="sidepanel-m-title">
                Friend List
                <span class="left-icon"><a href="#"><i class="fa fa-pencil"></i></a></span>
                <span class="right-icon"><a href="#"><i class="fa fa-trash"></i></a></span>
            </div>

            <div class="gn-title">ONLINE MEMBERS (3)</div>
            <ul class="group">
                <li class="member"><a href="#"><img src="img/profileimg.png" alt="img"><b>Allice Mingham</b>Los Angeles</a><span class="status online"></span></li>
                <li class="member"><a href="#"><img src="img/profileimg2.png" alt="img"><b>James Throwing</b>Las Vegas</a><span class="status busy"></span></li>
                <li class="member"><a href="#"><img src="img/profileimg3.png" alt="img"><b>Fred Stonefield</b>New York</a><span class="status away"></span></li>
                <li class="member"><a href="#"><img src="img/profileimg4.png" alt="img"><b>Chris M. Johnson</b>California</a><span class="status online"></span></li>
            </ul>

            <div class="gn-title">OFFLINE MEMBERS (8)</div>
            <ul class="group">
                <li class="member"><a href="#"><img src="img/profileimg5.png" alt="img"><b>Allice Mingham</b>Los Angeles</a><span class="status offline"></span></li>
                <li class="member"><a href="#"><img src="img/profileimg6.png" alt="img"><b>James Throwing</b>Las Vegas</a><span class="status offline"></span></li>
            </ul>

            <form class="search">
                <input type="text" class="form-control" placeholder="Search a Friend...">
            </form>
        </div>
        <!-- End Chat -->

    </div>

</div>
<!-- END SIDEPANEL -->
<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- ================================================
jQuery Library
================================================ -->
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/jquery.min.js"></script>

<!-- ================================================
Bootstrap Core JavaScript File
================================================ -->
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap/bootstrap.min.js"></script>
<!-- ================================================
Plugin.js - Some Specific JS codes for Plugin Settings
================================================ -->
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/plugins.js"></script>
<!-- ================================================
Data Tables
================================================ -->
<script src="<%=path%>/TheHomePageTemplate/js/jquery.dataTables.js"></script>
<script src="<%=path%>/js/page.js"></script>
<!-- 時間插件 -->
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="<%=path%>/layer/layer.js"></script>
<script src="<%=path%>/js/custom/timeFormatting.js"></script>
<script>
    function select(code){
        $("#sourceId").val(code);
        findTemplate();
    }
     $(function () {
         findTemplate();
         $('.selectdate').datetimepicker({
             clearBtn:false,
             language: 'zh-CN',
             weekStart: 1,
             autoclose: 1,
             format: 'yyyy-mm-dd',
             todayHighlight: 1,
             startView: 2,
             minView: 2,
             forceParse: 0
         });
     });//jquery

    //全选全不选
    function pitchOn(obj){
        $('input[type=checkbox]').prop('checked', $(obj).prop('checked'));
    }
    function selectCustomize(){
        window.location.href="<%=path%>/pendingcustomers/selectCustomize"
    }
    function sendAMessage(themeTaskId){
        window.location.href="<%=path%>/sendAMessage/page?themeTaskId="+themeTaskId;
    }
    //今日服务对象页面
    function selectServiceCustomers(){
        window.location.href="<%=path%>/todayServiceCustomers/selectAll";
    }
    //查询列表
    function findTemplate(){
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            data: $("#fromId").serialize(),
            type: 'get',
            url: '<%=path%>/pendingcustomers/list',
            success: function (data) {
                console.info(data)
                $('#task').dataTable().fnClearTable(); //清空表格
                if(data.length) {
                    $('#task').dataTable().fnAddData(showData(data), true); //刷下表格
                }
            }, error: function (data) {
                console.log('新增失败');
            }
        });
    }
    function showData(data) {
        var list = []; //全部行数据的list
        var banddata = data.test_env_all;
        for (var i in data) {
            var tempObj = [];  //一行数据的list
            tempObj.push("<div class='checkbox margin-t-0 text-center'><input id='checkbox"+data[i].id+"' value='"+data[i].id+"' type='checkbox' name='themeTemplate'><label for='checkbox"+data[i].id+"'></label></div>");
            tempObj.push(data[i].name);
            tempObj.push(data[i].dept);
            tempObj.push(data[i].sex==1?"男":"女");
            tempObj.push(data[i].phoneNumber);
            list.push(tempObj);
        }
        return list;
    }

    $(document).ready(function () {
        var dataTable = $("#task").dataTable(options).api();
        searchData(dataTable,$("#findTemplate"));
    });

    var column = [
        function (data) {
            return "<div class='checkbox margin-t-0 text-center'><input id='checkbox"+data.id+"' value='"+data.id+"' type='checkbox' name='themeTemplate'><label for='checkbox"+data.id+"'></label></div>";
        },
        "name",
        "dept",
        function (data) {
            return data.sex==1?"男":"女"
        },
        "phoneNumber"
    ];

    var options = page("<%=path%>/pendingcustomers/list", column, function (data) {
        return data.data;
    }, 'fromId');

</script>

</body>
</html>

