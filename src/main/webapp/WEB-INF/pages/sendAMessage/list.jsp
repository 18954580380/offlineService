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
<script type="text/javascript"
        src="<%=path%>/My97DatePicker/WdatePicker.js"
        charset="UTF-8"></script>
</head>
<body>
<style type="text/css">
    .switchSendClass{
        height:36px;width:118px;text-align:center;background-color: white;
        cursor: pointer;
    }

    .sendClass{
        border-collapse: collapse;
        width:100%;
        border-collapse: collapse;
        font-size: 13px;
    }
    .sendClass th{
        font-family: "微软雅黑 Bold","微软雅黑";
        font-style: normal;
        font-weight: 700;
        height: 40px;
        left: 0;
        top: 0;
    }

    .sendClass .tdLable{
        text-align:center;
        font-weight: 700;
        height: 40px;
        left: 0;
        top: 0;
        width:11%
    }
    .divBorder{border:1px #CCCCCC solid; width:100%; height:234px;overflow-y:scroll;background-color: white}
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
    <!-- Start Row -->
    <!-- end Row -->
    <!-- Start Row -->
    <div class="row">
        <!-- Start Panel -->
            <div class="panel panel-default">
                <div class="panel-body table-responsive">
                    <div id="content">
                        <div class="ui-layout-center" style="background-color: #F9F9F9;">
                            <div class="opt-body" style="background-color: #F9F9F9;color: #666666">
                                <span id="message" style="display: none"><font class="onSuccess"><nobr>保存成功！</nobr></font></span>
                                <form action="<%=path%>/sendAMessage/sendAMessageList" method="get" id="sendMessageForm" name="sendMessageForm">
                                    <div class="opt-btn" style="padding-left: 17px;border-bottom: 2px solid #0D6FB8; width: 98%;
					background-color: #F9F9F9;color: white;height: 47px;font-weight: bold;">
                                        <div style="height: 10px;"></div>
                                        <table>
                                            <tr>
                                                <td class="switchSendClass" onclick="switchSend(${themeTaskId})"
                                                    style="background-color: #0D6FB8;line-height: 36px;">客户提醒</td>
                                                <td class="switchSendClass" onclick="switchSend2(${themeTaskId})"
                                                    style="background-color: #666666;line-height: 36px;">发送记录</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <%--<aa:zone name="myTableZone">--%>
                                    <div id="" style="background-color: white;width:1065px; height: 526px;margin-left: 19px">
                                        <table class="sendClass">
                                            <tr>
                                                <td class="tdLable"> 已选择客户： </td>
                                                <td>
                                                    <div>
                                                        <div id="custListSize" style="width: 63px;float: left;padding-top: 10px">${custListSize}人</div>
                                                        <div id="checkbox1" style="width: 120px;float: left;padding-top: 10px"><input type="checkbox" name="source" checked="checked" />主题筛选客户</div>
                                                        <div id="checkbox2" style="width: 120px;float: left;padding-top: 10px"><input type="checkbox" name="source"  />主动报名客户</div>
                                                        <div id="checkbox3" style="width: 120px;float: left;padding-top: 10px"><input type="checkbox" name="source" checked="checked" />任务未完成客户</div>
                                                        <div id="checkbox4" style="width: 120px;float: left;padding-top: 10px"><input type="checkbox" name="source" checked="checked" />套餐未完成客户</div>
                                                        <div id="checkbox5" style="width: 120px;float: left;padding-top: 10px"><input type="checkbox" name="source" checked="checked" />上次为服务客户</div>
                                                        <%--<div onclick="selectNames()" style="float: right;height:100%;width:118px;text-align:center;background-color: #0D6FB8;color: white;cursor: pointer;"><p style="line-height: 100%">选择客户</p></div>--%>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="tdLable"> </td>
                                                <td rowspan="1">
                                                    <div style="" id="sportGuideAdvise" class="divBorder">

                                                        <c:forEach items="${custList}" var="a">
                                                            <div style="width: auto;height:28px;background-color: #F9F9F9;margin-top: 7px;margin-left:10px;float: left;">
                                                                <span style="line-height:100%;vertical-align: middle;"> &nbsp;${a.name} <a href="###" onclick="removeItem(this)"><img src="<%=path%>/img/clear.png" /></a></span>
                                                                <input type="hidden" value="${a.id}" name="id">
                                                                <input type="hidden" value="${a.source}" >
                                                                <input type="hidden" value="${a.name}" name="name">
                                                                <input type="hidden" class="archivalNumber" value="${a.archivalNumber}" name="archivalNumber">
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr> <td class="tdLable"> 提醒内容： </td>
                                                <td> <textarea name="remindContentBatch.remindComtent" id="remindComtent" style="width:948px;border:1px #CCCCCC solid;" cols="10" rows="5" placeholder="不超过200个汉字"  />${remindComtent}</textarea> </td>
                                            </tr>
                                            <tr>
                                                <td class="tdLable">
                                                    发送时间：
                                                </td>
                                                <td>
                                                    <input class="Wdate" name="remindContentBatch.sendDate" id="sendDate" readonly="readonly" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td  colspan="4">
                                                    <span id="sendMessButton" style="float: left;margin-left: 20px;cursor: pointer;" onclick="sendMessage('${themeTaskId}');"> <p> <img alt="" src="<%=path%>/img/subSend.png"> </p> </span>
                                                    <span id="sendMessButton"  style="float: left; margin-left: 20px;cursor: pointer;" onclick="reSetCon()"> <p> <img alt="" src="<%=path%>/img/cut.png"> </p> </span>
                                                    <span id="sendMessButton" style="float: left; margin-left: 20px;cursor: pointer;" onclick="returnPage()"> <p> <img alt="" src="<%=path%>/img/return.png"> </p> </span>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <!-- End Panel -->
    </div>
    <!-- End Row -->
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
<script src="<%=path%>/TheHomePageTemplate/js/datatables/jquery.dataTables.js"></script>
<!-- 時間插件 -->
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="<%=path%>/layer/layer.js"></script>
<script src="<%=path%>/js/custom/timeFormatting.js"></script>

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
    //发送页面标签切换
    function switchSend2(themeTaskId) {
        location.href="<%=path%>/sendAMessage/pageRecording?themeTaskId="+themeTaskId;
    }
    function switchSend(themeTaskId) {
        location.href="<%=path%>/sendAMessage/page?themeTaskId"+themeTaskId;
    }

    function sendMessage(themeTaskId){
        var arr=$('[name="name"]');//获取相同name的对象，然后再遍历这个数组就行了。
        var  name="";
        $('[name="name"]').each(function() {
            name+=$(this).val();
            name+=",";
        });
        var  source="";
        $('[name="source"]').each(function() {
            source+=$(this).val();
            source+=",";
        });
        var  id="";
        $('[name="id"]').each(function() {
            id+=$(this).val();
            id+=",";
        });
        var  archivalNumber="";
        $('[name="archivalNumber"]').each(function() {
            archivalNumber+=$(this).val();
            archivalNumber+=",";
        });
        var custListSize = $("#custListSize").text().replace("人", "");
        if(custListSize!= undefined && custListSize == 0){
            alert("发送人不能为空！");
            return;
        }
        var remindComtent = $("#remindComtent").val();
        if(remindComtent!= undefined && remindComtent == ""){
            alert("消息内容不能为空！");
            return;
        }
        var sendDate = $("#sendDate").val();
        if(sendDate!= undefined && sendDate == ""){
            alert("发送时间不能为空！");
            return;
        }
        var sendDate = $("#sendDate").val();
        var remindComtent = $("#remindComtent").val();
        $.ajax({
            dataType: "json",
            type: 'get',
            data:{name:name,
                source:source,
                id:id,
                archivalNumber:archivalNumber,
                sendDate:sendDate,
                remindComtent:remindComtent,
                themeTaskId:themeTaskId
            },
            url: '<%=path%>/sendAMessage/sendAMessageList',
            success: function () {
                location.href="<%=path%>/sendAMessage/page";
            }, error: function (data) {
                console.info("新增失败");
            }
        });
    }


    function  removeItem(obj){
        var custListSize=$("#custListSize").text().replace("人", "");
        custListSize--;
        if(custListSize<0){
            custListSize=0;
        }
        $("#custListSize").text(custListSize+"人");
        $(obj).parent().parent().remove();
    }

    function prescriptionsInfor(obj){
        var	planDate=$("#planDate").val();
        var	switchTab=$("#switchTab").val();
        var prescriptionIds= $(obj).parent().find("input[name='prescriptionIds']").val();
        publicAnyWhere('defaultForm',webRoot+'/healthStation/health-taskCenter-prescriptionTempInfo-list.htm?planDate='+planDate+"&switchTab="+switchTab+'&prescriptionIds='+prescriptionIds,'myTableZone');
    }


    window.setTimeout(changeBg,50);
    function  changeBg(){
        var tag=1;
        $(".trClassTag").each(function() {
            if(tag==0){
                tag=1;
                $(this).css("background-color","");
            }else{
                tag=0;
                $(this).css("background-color","#F2F2F2");
            }
        });
    }

    function  reSetCon(){
        $("#remindComtent").val("");
        $("#sendDate").val("");
        $("#sportGuideAdvise").html("");
        $("#custListSize").text(0+"人");
    }
    function  returnPage(){
        window.location.href='<%=path%>/pendingcustomers/page';
    }

    function validate(){
        $("#remindComtent").validate({
            submitHandler: function() {
                removeClick('saveBut');
                publicAjaxForm("remindComtent","",remindContentBatchBackup);
            },
            rules: {
                remindComtent: "required",
                name: "required"
            },
            messages: {
                remindComtent: "必填",
                name: "必填"
            }
        });
    }
    function remindContentBatchBackup(data){
        addClick('saveBut');
        $("#id").attr("value",data);
        $("#message").show("show");
        setTimeout('$("#message").hide("show");',3000);
    }

    //选择人员
    function selectNames(){
        $.colorbox({
            href:webRoot+'/healthStation/health-taskCenter-sendMessageSelectNames.htm',
            iframe:true,
            innerWidth:800,
            innerHeight:500,
            overlayClose:false,
            title:"选择人员"
        });
    }

</script>

</body>
</html>

