<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/base.jsp" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description"
          content="Kode is a Premium Bootstrap Admin Template, It's responsive, clean coded and mobile friendly">
    <meta name="keywords" content="bootstrap, admin, dashboard, flat admin template, responsive,"/>
    <title>Kode</title>

    <!-- ========== Css Files ========== -->
    <link href="<%=path%>/TheHomePageTemplate/css/root.css" rel="stylesheet">

</head>
<body>
<!-- Start Page Loading -->
<div class="loading"><img src="<%=path%>/TheHomePageTemplate/img/loading.gif" alt="loading-img"></div>
<!-- End Page Loading -->
<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START TOP -->
<div id="top" class="clearfix">

    <!-- Start App Logo -->
    <!-- End App Logo -->

    <!-- Start Sidebar Show Hide Button -->
    <a href="<%=path%>/TheHomePageTemplate/#" class="sidebar-open-button"><i class="fa fa-bars"></i></a>
    <a href="<%=path%>/TheHomePageTemplate/#" class="sidebar-open-button-mobile"><i class="fa fa-bars"></i></a>
    <!-- End Sidebar Show Hide Button -->

    <!-- Start Searchbox -->
    <form class="searchform">
        <input type="text" class="searchbox" id="searchbox" placeholder="Search">
        <span class="searchbutton"><i class="fa fa-search"></i></span>
    </form>
    <!-- End Searchbox -->

    <!-- Start Top Menu -->
    <ul class="topmenu">
        <li><a href="<%=path%>/TheHomePageTemplate/#">Files</a></li>
        <li><a href="<%=path%>/TheHomePageTemplate/#">Authors</a></li>
        <li class="dropdown">
            <a href="<%=path%>/TheHomePageTemplate/#" data-toggle="dropdown" class="dropdown-toggle">My Files <span
                    class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="<%=path%>/TheHomePageTemplate/#">Videos</a></li>
                <li><a href="<%=path%>/TheHomePageTemplate/#">Pictures</a></li>
                <li><a href="<%=path%>/TheHomePageTemplate/#">Blog Posts</a></li>
            </ul>
        </li>
    </ul>
    <!-- End Top Menu -->

    <!-- Start Sidepanel Show-Hide Button -->
    <a href="<%=path%>/TheHomePageTemplate/#sidepanel" class="sidepanel-open-button"><i class="fa fa-outdent"></i></a>
    <!-- End Sidepanel Show-Hide Button -->

    <!-- Start Top Right -->
    <ul class="top-right">

        <li class="dropdown link">
            <a href="<%=path%>/TheHomePageTemplate/#" data-toggle="dropdown" class="dropdown-toggle hdbutton">Create New
                <span class="caret"></span></a>
            <ul class="dropdown-menu dropdown-menu-list">
                <li><a href="<%=path%>/TheHomePageTemplate/#"><i class="fa falist fa-paper-plane-o"></i>Product or Item</a>
                </li>
                <li><a href="<%=path%>/TheHomePageTemplate/#"><i class="fa falist fa-font"></i>Blog Post</a></li>
                <li><a href="<%=path%>/TheHomePageTemplate/#"><i class="fa falist fa-file-image-o"></i>Image Gallery</a>
                </li>
                <li><a href="<%=path%>/TheHomePageTemplate/#"><i class="fa falist fa-file-video-o"></i>Video Gallery</a>
                </li>
            </ul>
        </li>

        <li class="link">
            <a href="<%=path%>/TheHomePageTemplate/#" class="notifications">6</a>
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
<!-- START SIDEBAR -->
<!-- END SIDEBAR -->
<!-- //////////////////////////////////////////////////////////////////////////// -->


<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START CONTENT -->

<!-- Start Page Header -->
<div class="page-header">
    <h1 class="title">Form Elements</h1>
    <ol class="breadcrumb">
        <li><a href="<%=path%>/TheHomePageTemplate/index.html">Dashboard</a></li>
        <li><a href="<%=path%>/TheHomePageTemplate/#">Forms</a></li>
        <li class="active">Form Elements</li>
    </ol>

    <!-- Start Page Header Right Div -->
    <div class="right">
        <div class="btn-group" role="group" aria-label="...">
            <a href="<%=path%>/TheHomePageTemplate/index.html" class="btn btn-light">Dashboard</a>
            <a href="<%=path%>/TheHomePageTemplate/#" class="btn btn-light"><i class="fa fa-refresh"></i></a>
            <a href="<%=path%>/TheHomePageTemplate/#" class="btn btn-light"><i class="fa fa-search"></i></a>
            <a href="<%=path%>/TheHomePageTemplate/#" class="btn btn-light" id="topstats"><i
                    class="fa fa-line-chart"></i></a>
        </div>
    </div>
    <!-- End Page Header Right Div -->

</div>
<div class="container-padding">


    <!-- Start Row -->
    <div class="row">

        <div class="col-md-12">
            <div class="panel panel-default">

                <div class="panel-title">
                    <h3>健康主题任务设置<input type="button" style=" float:right;" align="left" onclick="returnpage()" class="btn btn-rounded btn-default" value="返回">
                    </h3>
                    <ul class="panel-tools">
                        <li><a class="icon minimise-tool"><i class="fa fa-minus"></i></a></li>
                        <li><a class="icon expand-tool"><i class="fa fa-expand"></i></a></li>
                        <li><a class="icon closed-tool"><i class="fa fa-times"></i></a></li>
                    </ul>
                </div>

                <div class="panel-body">
                    <form class="form-horizontal" action="<%=path%>/addServiceTaskController">

                        <div class="form-group">
                            <label class="col-sm-2 control-label form-label">健康主题</label>
                            <div class="col-sm-8">
                                <select class="selectpicker" onchange="healthTopicsSelect()"
                                        id="healthTopicsSelectId" name="themeId">
                                </select>
                                <input type="hidden" id="themeName" name="themeName" />
                            </div>
                        </div>

                        <div class="form-group">

                            <label class="col-sm-2 control-label form-label">服务集团</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" id="servicesGroupSelectId"
                                       name="servicesGroupInputName">
                            </div>
                            <div class="col-sm-2">
                                <input type="button" class="btn btn-rounded btn-default" value="选择"
                                       onclick="expBiz()">
                            </div>


                            <div id="subsidiaryDivId">
                                <label class="col-sm-1 control-label form-label">子公司</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="subsidiaryTextId"
                                           name="subsidiaryInputName">
                                </div>
                                <div class="col-sm-2">
                                    <input type="button" class="btn btn-rounded btn-default" value="选择"
                                           onclick="subsidiaryDivExpBiz()">
                                </div>
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-sm-2 control-label form-label">主题图片</label>
                            <div class="col-sm-4" id="updatebox" >
						    <input type="file" id="inputfile" name="file"  class="img" onchange="uploadImg()">
						    <input value="" id="imgUrl" name="imgUrl" type="hidden"/>
						    </label>
					     </div>
                         </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label form-label">活动时间</label>
                            <div class="col-sm-8">
                                <fieldset>
                                    <div class="control-group">
                                        <div class="controls">
                                            <div class="input-prepend input-group">
                                                    <span class="add-on input-group-addon"><i
                                                            class="fa fa-calendar"></i></span>
                                                <input type="text" id="date-range-and-time-picker"
                                                       class="form-control" value="" class="span4"
                                                       name="activityTimeName"/>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label form-label">服务地点</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="serviceLocationId"
                                       name="serviceLocationName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label form-label">预约时间段</label>
                            <div class="col-sm-8">

                                <input type="checkbox" id="appointmentId" checked data-toggle="toggle" data-on="设置"
                                       data-off="不设置" onchange="appointmentOnchange()">
                                <input value="0" name="appointmentTime" id="appointmentTime"/>
                            </div>
                        </div>
                        <div id="appointmentPeriodDiv">
                            <div class="form-group">
                                <div class="col-sm-1"></div>
                                <label class="col-sm-2 control-label form-label">上午:</label>
                                <div class="col-sm-2">
                                    <fieldset>
                                        <div class="control-group">
                                            <div class="controls">
                                                <div class="input-prepend input-group">
                                                        <span class="add-on input-group-addon"><i
                                                                class="fa fa-calendar"></i></span>
                                                    <input type="text" class="form-control mydate"
                                                           name="appointmentPeriodAM1"/>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                </div>
                                <span style="float: left;line-height: 35px;">一</span>
                                <div class="col-sm-2">
                                    <fieldset>
                                        <div class="control-group">
                                            <div class="controls">
                                                <div class="input-prepend input-group">
                                                        <span class="add-on input-group-addon"><i
                                                                class="fa fa-calendar"></i></span>
                                                    <input type="text" class="form-control mydate"
                                                           name="appointmentPeriodAM2"/>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-sm-1"></div>
                                <label class="col-sm-2 control-label form-label">下午:</label>
                                <div class="col-sm-2">
                                    <fieldset>
                                        <div class="control-group">
                                            <div class="controls">
                                                <div class="input-prepend input-group">
                                                        <span class="add-on input-group-addon"><i
                                                                class="fa fa-calendar"></i></span>
                                                    <input type="text" class="form-control mydate"
                                                           name="appointmentPeriodPM1"/>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                </div>
                                <span style="float: left;line-height: 35px;">一</span>
                                <div class="col-sm-2">
                                    <fieldset>
                                        <div class="control-group">
                                            <div class="controls">
                                                <div class="input-prepend input-group">
                                                        <span class="add-on input-group-addon"><i
                                                                class="fa fa-calendar"></i></span>
                                                        <input type="text" class="form-control mydate" name="appointmentPeriodPM2"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-1"></div>
                                    <label class="col-sm-2 control-label form-label">时间间隔:</label>
                                    <div class="col-sm-4">
                                         <select class="selectpicker" name="timeLagName" id="timeLagName" onchange="selectTimeSection(this)">
                                            <option value="">不设置</option>
                                            <option value="30">30</option>
                                            <option value="60">60</option>
                                        </select>
                                    </div>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-2 control-label form-label">服务主题介绍</label>
                                <div class="col-sm-10">
                                    <textarea style="width: 80%;height:300px;" name="serviceIntroduction"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label form-label">健康主题管理目标</label>
                                <div class="col-sm-10">
                                    <textarea style="width: 80%;height:300px;" name="managementTarget" placeholder="请写清面向的人群和管理达成的目标"></textarea>
                                </div>
                            </div>

                            <div class="form-group">

                                <label class="col-sm-2 control-label form-label">主题人群</label>
                                <div class="col-sm-2">
                                    <input type="text"  id="inputcrowdid" class="form-control" style="250px">
                                    <input type="hidden" id="userIds" name="userIds">
                                    <div id="mainProblemCountId">
                                        <div id="mainSymptomarrCountId">
                                            <input type="text" name="mainProblemName" class="form-control">
                                        </div>
                                    </div>
                                    <div id="mainProblemCountId1">
                                        <div id="mainSymptomarrCountId1">
                                            <input type="text" name="mainSymptomName" class="form-control">
                                        </div>
                                    </div>
                                    <div id="mainProblemCountId2">
                                        <div id="mainSymptomarrCountId2">
                                            <input type="text" name="positiveindexName" class="form-control">
                                        </div>
                                    </div>
                                    <div id="mainProblemCountId3">
                                        <div id="mainSymptomarrCountId3">
                                            <input type="text" name="healthRiskName" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <input type="button" onclick="mainProblemIdBulletBox()" class="btn btn-rounded btn-default" value="选择">
                                </div>
                            </div>
                            <div class="form-group">
                                <h4><label class="col-sm-2 control-label form-label">服务项目</label></h4>
                                <button type="button" class="btn btn-success btn-sm" onclick="servicesAvailableAddId()">
                                    <i class="fa fa-plus"></i>添加
                                </button>
                            </div>

                            <div id="servicesAvailableAddParentDivId">
                                <div id="servicesAvailableAddDivId">
                                    <div class="form-group">
                                            <label class="col-sm-2 control-label form-label"></label>
                                            <div class="col-sm-2">
                                                <select class="" name="servicesAvailableSelect">
                                                    <option value="" >请选择</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-1 control-label form-label">服务人群上限</label>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" required="required" name="itemCeiling"   onkeyup="value=value.replace(/[^\d]/g,'')">
                                            </div>
                                            <label class="col-sm-1 control-label form-label">必查</label>
                                            <select class="" name="isCheck">
                                                <option value="0">否</option>
                                                <option value="1">是</option>
                                            </select>
                                            <button type="button" class="btn btn-danger btn-icon btn-sm"
                                                    onclick="RemoveTrSerivceOnclick(this)">&nbsp;<i
                                                    class="fa fa-close"></i>&nbsp;&nbsp;&nbsp;删除
                                            </button>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label"></label>
                                            <div class="col-sm-8">
                                                <textarea class="form-control" rows="3" style="width: 800px;" name="itemContext" ></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <h4><label class="col-sm-2 control-label form-label">服务团队</label></h4>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label form-label">健康管理师</label>
                                <button type="button" class="btn btn-success btn-sm" onclick="healthManagerOnclick()">
                                    <i class="fa fa-plus"></i>添加
                                </button>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label form-label"></label>
                                <table id="healthManagerTableId">
                                    <tbody>
                                    <tr id="healthManagerTrd">
                                        <td>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" name="managerName" style="width: 200px">
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-1">
                                                <input type="button" class="btn btn-rounded btn-option2" name="healthManager"
                                                       value="选择健康管理师" onclick="healthManagerSelectOnclick(this)">
                                                <%--<input type="hidden" value="1" name="doctorType">--%>
                                            </div>
                                        </td>
                                        <td>
                                            <label class="control-label form-label">负责项目</label>
                                        </td>
                                        <td>
                                            <div class="col-sm-2">
                                                <select id="testSelect" name="servicesAvailableSelectManager"  onchange="gradeChange()">
                                                    <option>请选择</option>
                                                </select>
                                            </div>
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-danger btn-icon btn-sm"
                                                    onclick="RemoveTrOnclick(this)">&nbsp;<i
                                                    class="fa fa-close"></i>&nbsp;&nbsp;&nbsp;删除
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>

                                </table>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-2 control-label form-label">医 生</label>
                                <button type="button" class="btn btn-success btn-sm" onclick="doctorAddOnclick()">
                                    <i class="fa fa-plus"></i>添加
                                </button>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label form-label"></label>
                                <table id="doctorTableId">
                                    <tr id="doctorTrId">
                                        <td>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control"  name="doctorName" style="width: 200px">
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-1">
                                                <input type="button" class="btn btn-rounded btn-option2" value="选择医生"
                                                       style="width: 110px" onclick="doctorSelectOnclick(this)">
                                                <%--<input type="hidden" value="2" name="doctorType">--%>
                                            </div>
                                        </td>
                                        <td>
                                            <label class="control-label form-label">负责项目</label>
                                        </td>
                                        <td>
                                            <div class="col-sm-2">
                                                <select id="testSelectDoctors" name="servicesAvailableSelectDoctor" onchange="gradeChangeDoctors()">
                                                    <option>请选择</option>
                                                </select>
                                            </div>
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-danger btn-icon btn-sm"
                                                    onclick="RemoveTrOnclick(this)">&nbsp;<i
                                                    class="fa fa-close"></i>&nbsp;&nbsp;&nbsp;删除
                                            </button>
                                        </td>
                                    </tr>
                                </table>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-2 control-label form-label">服务人数上限</label>
                                <div class="col-sm-8">
                                    <label class="col-sm-1 control-label form-label">是否设置</label>
                                    <div class="radio" style="float:left;padding-right:20px">
                                        <input type="radio" name="maxmemberName" id="maxmemberIdYes" value="1"
                                               onclick="maxmemberOnclick()">
                                        <label for="maxmemberIdYes">是</label>
                                    </div>
                                    <div class="radio" style="float:left">
                                        <input type="radio" name="maxmemberName" id="maxmemberIdNo" value="0" checked
                                               onclick="maxmemberOnclick()">
                                        <label for="maxmemberIdNo">否</label>
                                    </div>
                                    <div class="col-sm-1">

                                    </div>
                                    <input class="form-control" type="text" readonly style="width: 400px"
                                           id="maxmemberInputId" name="serviceCeiling">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label form-label">服务支持</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" rows="3" style="width: 800px;" name="serviceSupport"></textarea>
                                </div>
                            </div>
                            <center>
                                <button class="btn btn-default btn-lg" onclick="return check(this.form)" >提交</button>
                            </center>

                            <!-- ///////////////////////////////////弹框div///////////////////////////////////////// -->
                            <!-- 集团名称 弹框div -->
                            <div class="pop"
                                 style="display:none;position: fixed;z-index:9999;left:50%;top:50%;margin-left:-200px;margin-top:-200px;width: 450px;padding: 30px;border:solid 2px #008299;border-radius:2px;background: white;">
                                <center>
                                    <input id="popAccId" type="hidden">
                                    <div class="mb25 pr" style="height: 400px;overflow-y: scroll">
                                        <table class="table table-hover table-striped" id="servicesGroupRadioId">
                                            <thead>
                                            <tr>
                                                <td class="text-center"></td>
                                                <td>集团名称</td>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="mb20" id="wid-id-713">
                                        <button class="btn btn-primary " id="export" type="button" title="确认">确&nbsp;认</button>
                                        &nbsp;&nbsp;
                                        <button class="btn btn-default fl mr30" id="mr30" type="button" title="取消">取&nbsp;消</button>
                                    </div>
                                </center>
                            </div>
                            <!-- 子公司名称 弹框div -->
                            <div class="subsidiaryRadioDivId"
                                 style="display:none;position: fixed;z-index:9999;left:50%;top:50%;margin-left:-200px;margin-top:-200px;width: 450px;padding: 30px;border:solid 2px #000000;border-radius:2px;background: white;">
                                <center>
                                    <div class="mb25 pr" style="height: 400px;overflow-y: scroll">
                                        <table class="table table-hover table-striped" id="subsidiaryRadioId">
                                            <thead>
                                            <tr>
                                                <td class="text-center"></td>
                                                <td>子公司名称</td>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="mb20">
                                        <button class="btn btn-primary " id="subsidiaryDivDuttonId" type="button" title="确认">确&nbsp;认</button>
                                        &nbsp;&nbsp;
                                        <button class="btn btn-default fl mr31" id="mr31" type="button" title="取消">取&nbsp;消</button>
                                    </div>
                                </center>
                            </div>
                            <!-- 医生 弹框div -->
                            <div class="koboroDoctorRadioDivId"
                                 style="display:none;position: fixed;z-index:9999;left:50%;top:50%;margin-left:-200px;margin-top:-200px;width: 450px;padding: 30px;border:solid 2px #000000;border-radius:2px;background: white;">
                                <center>
                                    <div class="mb25 pr" style="height: 400px;overflow-y: scroll">
                                        <table class="table table-hover table-striped" id="koboroDoctorRadioId">
                                            <thead>
                                            <tr>
                                                <td class="text-center"></td>
                                                <td>医生</td>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="mb20">
                                        <button class="btn btn-primary " id="koboroDoctorDivDuttonId" type="button" title="确认">确&nbsp;认</button>
                                        &nbsp;&nbsp;
                                        <button class="btn btn-default fl mr32" id="mr32" type="button" title="取消">取&nbsp;消</button>
                                    </div>
                                </center>
                            </div>
                            <!-- 健康管理师 弹框div -->
                            <div class="healthManagerRadioDivId"
                                 style="display:none;position: fixed;z-index:9999;left:50%;top:50%;margin-left:-200px;margin-top:-200px;width: 450px;padding: 30px;border:solid 2px #000000;border-radius:2px;background: white;">
                                <center>
                                    <div class="mb25 pr" style="height: 400px;overflow-y: scroll">
                                        <table class="table table-hover table-striped" id="healthManagerRadioId">
                                            <thead>
                                            <tr>
                                                <td class="text-center"></td>
                                                <td>健康管理师</td>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="mb20">
                                        <button class="btn btn-primary " id="healthManagerDivDuttonId" type="button" title="确认">确&nbsp;认</button>
                                        &nbsp;&nbsp;
                                        <button class="btn btn-default fl mr33" id="mr33" type="button" title="取消">取&nbsp;消</button>
                                    </div>
                                </center>
                            </div>
                            <!-- End Content -->
                            <!-- //////////////////////////////////////////////////////////////////////////// -->
                        </form>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <!-- END CONTAINER -->
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
Bootstrap Select
================================================ -->
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/bootstrap-select/bootstrap-select.js"></script>

<!-- ================================================
Bootstrap Toggle
================================================ -->
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/bootstrap-toggle/bootstrap-toggle.min.js"></script>

<!-- ================================================
Moment.js
================================================ -->
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/moment/moment.min.js"></script>

<!-- ================================================
Bootstrap Date Range Picker
================================================ -->
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/date-range-picker/daterangepicker.js"></script>
<!-- ================================================
kindeditor富文本编译器
================================================ -->
<script charset="utf-8" src="<%=path%>/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="<%=path%>/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="<%=path%>/layer/layer.js"></script>
<script charset="utf-8" src="<%=path%>/js/ajaxfileupload.js"></script>
<!--加载的请求 -->
<script type="text/javascript">
    var servicesGroupVar;
    var servicesAvailableVar = "<option value='-1'>请选择</option>";
    var healthManagerTrd = '';
    var doctorTrId = '';
    var koboroDoctorVar = '';
    var healthManagerVar = '';
    $(function () {

        //健康主题option下拉框内容
        $.ajax({
            type: "GET",
            url: "<%=path%>/selectHealthThemeTemplate",
            dataType: "json",
            success: function (data) {
                if (data.healthThemeTemplates != null) {
                    var selectHealthThemeVar = "<option value='-1'>请选择</option>";
                    for (var i = 0; i < data.healthThemeTemplates.length; i++) {
                        selectHealthThemeVar += "<option value='" + data.healthThemeTemplates[i].id + "'>" + data.healthThemeTemplates[i].themeName + "</option>";
                        $("#healthTopicsSelectId").html(selectHealthThemeVar);
                    }
                }

            }
        });
        //医生健康师option下拉框内容
        $.ajax({
            type: "GET",
            url: "<%=path%>/doctorSelectAll",
            dataType: "json",
            success: function (data) {
                if (data.koboroDoctor != null) {
                    for (var i = 0; i < data.koboroDoctor.length; i++) {
                        if (data.koboroDoctor[i].doctorType.indexOf("医生") > -1) {
                            koboroDoctorVar += '<tr>\n' +
                                '<td class="text-center"><div class="margin-t-0">' +
                                '<input id="checkbox' + data.koboroDoctor[i].id + '" type="radio" name="doctorId" ' +
                                'value="' + data.koboroDoctor[i].doctorId + '" ' +
                                'valueName="' + data.koboroDoctor[i].doctorName + '" ' +
                                '<label for="checkbox' + data.koboroDoctor[i].id + '"></label></div></td>\n' +
                                '<td>' + data.koboroDoctor[i].doctorName + '</td>\n' +
                                '</tr>';
                        } else if (data.koboroDoctor[i].doctorType.indexOf("健康管理师") > -1) {
                            healthManagerVar += '<tr>\n' +
                                '<td class="text-center"><div class="margin-t-0">' +
                                '<input id="checkbox' + data.koboroDoctor[i].id + '" type="radio" name="managerId" ' +
                                'value="' + data.koboroDoctor[i].doctorId + '" ' +
                                'valueName="' + data.koboroDoctor[i].doctorName + '" ' +
                                '<label for="checkbox' + data.koboroDoctor[i].id + '"></label></div></td>\n' +
                                '<td>' + data.koboroDoctor[i].doctorName + '</td>\n' +
                                '</tr>';
                        }

                    }
                    $("#koboroDoctorRadioId").children("tbody").append(koboroDoctorVar);
                    $("#healthManagerRadioId").children("tbody").append(healthManagerVar);
                }

            }
        });

        //服务项目option下拉框内容
        $.ajax({
            type: "GET",
            url: "<%=path%>/servicesAvailableSelectAll",
            dataType: "json",
            success: function (data) {
                if (data.servicesAvailable != null) {
                    for (var i = 0; i < data.servicesAvailable.length; i++) {
                        servicesAvailableVar += "<option value='" + data.servicesAvailable[i].name + "'>" + data.servicesAvailable[i].name + "</option>";
                    }
                    $("select[name^='servicesAvailableSelect']").html(servicesAvailableVar);
                    doctorTrId = "<tr>" + $("#doctorTrId").html() + "</tr>";
                    healthManagerTrd = "<tr>" + $("#healthManagerTrd").html() + "</tr>";
                }

            }
        });
        //服务集团option下拉框内容
        $.ajax({
            type: "GET",
            url: "<%=path%>/servicesGroupSelectAll",
            dataType: "json",
            success: function (data) {
                servicesGroupVar = data.servicesGroup;
                $("#subsidiaryDivId").hide(); //初始化的时候第二个下拉列表隐藏
                if (data.servicesGroup != null) {
                    for (var i = 0; i < data.servicesGroup.length; i++) {
                        if (data.servicesGroup[i].parentId == null | data.servicesGroup[i].parentId == "" | data.servicesGroup[i].parentId == 0) {
                            var tr = '<tr>\n' +
                                '<td class="text-center"><div class="margin-t-0">' +
                                '<input id="checkbox' + data.servicesGroup[i].id + '" type="radio" name="servicesGroupName" ' +
                                'value="' + data.servicesGroup[i].id + '" ' +
                                ' valueName="' + data.servicesGroup[i].name + '"  ' +
                                ' valueParentId="' + data.servicesGroup[i].parentId + '"  ' +
                                ' valueActualAddr="' + data.servicesGroup[i].actualAddr + '" >' +
                                '<label for="checkbox' + data.servicesGroup[i].id + '"></label></div></td>\n' +
                                '<td>' + data.servicesGroup[i].name + '</td>\n' +
                                '</tr>';
                            $("#servicesGroupRadioId").children("tbody").append(tr);
                        }
                    }
                }

            }
        });
    });
    $(function () {
        $(".mr30").click(function () {
            $('.pop').hide();
        });
        $("#export").click(function () {
            var names = document.getElementsByName("servicesGroupName");
            for (var i=0; i < names.length; i++) {
                if (names[i].checked) {
                    //取出弹出框选择的公司
                    $("#servicesGroupSelectId").val(names[i].getAttribute('valueName'));
                    //判断地址是否存在
                    if (names[i].getAttribute('valueActualAddr') != "null") {
                        $("#serviceLocationId").val(names[i].getAttribute('valueActualAddr'));
                    } else {
                        $("#serviceLocationId").val('');
                    }
                    //判断所选公司是否有子公司
                    $("#subsidiaryRadioId").children("tbody").empty();
                    for (var l = 0; l < servicesGroupVar.length; l++) {
                        if (servicesGroupVar[l].parentId == names[i].value) {
                            var subsidiaryVar = '<tr>\n' +
                                '<td class="text-center"><div class="margin-t-0">' +
                                '<input id="checkbox' + servicesGroupVar[l].id + '" type="radio" name="subsidiaryName" ' +
                                'value="' + servicesGroupVar[l].id + '" ' +
                                ' valueName="' + servicesGroupVar[l].name + '"  ' +
                                ' valueParentId="' + servicesGroupVar[l].parentId + '"  ' +
                                ' valueActualAddr="' + servicesGroupVar[l].actualAddr + '" >' +
                                '<label for="checkbox' + servicesGroupVar[l].id + '"></label></div></td>\n' +
                                '<td>' + servicesGroupVar[l].name + '</td>\n' +
                                '</tr>';
                            $("#subsidiaryRadioId").children("tbody").append(subsidiaryVar);
                        }
                    }
                }
            }
            $('.pop').hide();
            if (subsidiaryVar != '') {
                $("#subsidiaryDivId").show(); //第二个下拉列表显示
            } else {
                $("#subsidiaryDivId").hide();
            }
        });
        //子公司
        $(function () {
            $(".mr31").click(function () {
                $('.subsidiaryRadioDivId').hide();
            });
            $("#subsidiaryDivDuttonId").click(function () {
                var names = document.getElementsByName("subsidiaryName");
                var i = 0;
                for (i; i < names.length; i++) {
                    if (names[i].checked) {
                        //取出弹出框选择的公司
                        $("#subsidiaryTextId").val(names[i].getAttribute('valueName'));
                        //判断地址是否存在
                        if (names[i].getAttribute('valueActualAddr') != "null") {
                            $("#serviceLocationId").val(names[i].getAttribute('valueActualAddr'));
                        } else {
                            $("#serviceLocationId").val('');

                        }
                    }
                }
                $('.subsidiaryRadioDivId').hide();
            })
        });
    });
</script>
<!--kindeditor  富文本控件 -->
<script>
    $(function () {
        $('[data-toggle="popover"]').popover();
    });
    var options = {
        filterMode: true,
        items: ['source', '|', 'undo', 'redo', '|', 'preview', 'cut', 'copy', 'paste',
            'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', '|',
            'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
            'superscript', 'clearhtml', 'quickformat', 'selectall', '|',
            'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', '|',
            'bold', 'italic', 'underline', 'fullscreen', 'image', 'strikethrough', 'lineheight', 'removeformat', '|',
            'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
            'anchor', 'link', 'unlink', '|', 'about'
        ],
        afterBlur: function () {
            this.sync();
        },
        themeType: 'oschina',
        resizeType: 1,
        shadowMode: true,//弹框是否有阴影
        allowPreviewEmoticons: true,
        allowUpload: true, //允许上传图片
        allowImageUpload: true,
        allowImageRemote: true,
        uploadJson: '<%=path%>/upload',//上传路径
        filePostName: "file",
        // afterUpload : function(url, data, name) { //上传文件后执行的回调函数，必须为3个参数
        //     window.editor.insertHtml("<img src='" + url + "'  />");
        // }
    };
    KindEditor.ready(function (K) {
        window.editor = K.create('.serveTheme', options);
    });
</script>
<!-- 时间控件 -->
<script type="text/javascript">
    // 预约时间段 -----单个时间
    //定义locale汉化插件
    var locale = {
        format: "YYYY/MM/DD HH:mm:SS",
        separator: " - ",
        applyLabel: "确认",
        cancelLabel: "清空",
        fromLabel: "开始时间",
        toLabel: "结束时间",
        customRangeLabel: "自定义",
        daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
        monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
    };
    var locale1 = {
        format: "HH:mm:SS",
        separator: " - ",
        applyLabel: "确认",
        cancelLabel: "清空",
        fromLabel: "开始时间",
        toLabel: "结束时间",
        customRangeLabel: "自定义",
        daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
        monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
    };
    $(document).ready(function () {
        $('.mydate').daterangepicker({
            'locale': locale1,
            language: 'zh-CN',
            timePicker: true,
            timePickerIncrement: 10,
            timePicker24Hour: true,
            singleDatePicker: true,
            autoUpdateInput: true,//1.当设置为false的时候,不给与默认值(当前时间)2.选择时间时,失去鼠标焦点,不会给与默认值 默认true
        }, function (start, end, label) {
            console.log(start.toISOString(), end.toISOString(), label);
        });
    });
    // 活动时间 -----时间区间
    $(document).ready(function () {
        $('#date-range-and-time-picker').daterangepicker({
            'locale': locale,
            //汉化按钮部分
            ranges: {
                '今日': [moment(), moment()],
                '最近7日': [moment(), moment().subtract(-6, 'days')],
                '最近30日': [moment(), moment().subtract(-29, 'days')],
                '本月': [moment().startOf('month'), moment().endOf('month')],
                '下一个月': [moment().subtract(-1, 'month').startOf('month'), moment().subtract(-1, 'month').endOf('month')]
            },
            timePicker: true,
            timePickerIncrement: 10,
            timePicker24Hour: true,
            showDropdowns: true,//当设置值为true的时候，允许年份和月份通过下拉框的形式选择 默认false
            autoUpdateInput: true,//1.当设置为false的时候,不给与默认值(当前时间)2.选择时间时,失去鼠标焦点,不会给与默认值 默认true
        }, function (start, end, label) {
            console.log(start.toISOString(), end.toISOString(), label);
        });
    });

    $(document).ready(function () {
        $('#date-range-picker').daterangepicker(null, function (start, end, label) {
            console.log(start.toISOString(), end.toISOString(), label);
        });
    });
</script>
<!-- 触发方法 -->
<script type="text/javascript">
    $("input[name='mainProblemName']").hide();
    $("input[name='mainSymptomName']").hide();
    $("input[name='positiveindexName']").hide();
    $("input[name='healthRiskName']").hide();
    var width=window.parent.innerWidth-260;
    //主题人群 弹框
    function mainProblemIdBulletBox() {
        var healthThemeId = $("#healthTopicsSelectId").val();
        //弹出浮层
        layer.open({
            type: 2,
            closeBtn: 1, //显示关闭按钮
            shade: [0.8, '#393D49'],
            area: [width+'px','95%'],
            shadeClose: true,
            scrollbar: false, // 父页面 滚动条 禁止
            offset: 'auto', //右下角弹出
            btn: ['确定','取消'],
            shift: 2,
            zIndex: 999,
            content: '<%=path%>/selectCrowd/page?healthThemeId='+healthThemeId,
            yes: function (layero, index) {
                var newpsw = window[index.find('iframe')[0]['name']];
                var code = newpsw.getcode();
                if(code==1){
                    var value=newpsw.getChoseIds();
                    $("#userIds").val(value);
                    if(value!=""){
                    	 $("#inputcrowdid").val("自定义筛选用户"+(value.split(",").length-1)+"人");
                    	 $("#inputcrowdid").show();
                    }
                     /*$("input[name='mainProblemName']").hide();
                    $("input[name='mainSymptomName']").hide();
                    $("input[name='positiveindexName']").hide();
                    $("input[name='healthRiskName']").hide();
                    $("input[name='mainProblemName']").val("");
                    $("input[name='mainSymptomName']").val("");
                    $("input[name='positiveindexName']").val("");
                    $("input[name='healthRiskName']").val(""); */
                }else{
                    var mainProblem =  newpsw.getmainProblem();
                    var mainSymptom =  newpsw.getmainSymptom();
                    var positiveIndex =  newpsw.getpositiveIndex();
                    var healthRisk =  newpsw.gethealthRisk();
                    console.log(healthRisk);
                    var getcheckboxvalue =  newpsw.getcheckboxvalue();
                    if(getcheckboxvalue!=""){
                    	  if($("#userIds").val()!=""){
                    		  $("#inputcrowdid").val("自定义筛选用户"+($("#userIds").val().split(",").length-1)+"人;"+"主题筛选用户"+(getcheckboxvalue.split(",").length-1)+"人");
                    	  }
                    	  else{
                    		  $("#inputcrowdid").val("主题筛选用户"+(getcheckboxvalue.split(",").length-1)+"人");
                    	  }
                    	 $("#userIds").val(getcheckboxvalue+$("#userIds").val());
                    	
                    }
                   else{
                    $.ajax({
                        dataType: "json",
                        data: {
                            mainProblem:mainProblem,
                            mainSymptom:mainSymptom,
                            positiveIndex:positiveIndex,
                            healthRisk:healthRisk,
                        },
                        type: 'get',
                        url: '<%=path%>/selectCrowd/selectCrowdCount',
                        success: function (data) {
                            $("input[name='mainProblemName']").hide();
                            $("input[name='mainSymptomName']").hide();
                            $("input[name='positiveindexName']").hide();
                            $("input[name='healthRiskName']").hide();
                            $("input[name='mainProblemName']").val("");
                            $("input[name='mainSymptomName']").val("");
                            $("input[name='positiveindexName']").val("");
                            $("input[name='healthRiskName']").val("");
                            var mainProblemarr = data.data.mainProblemCount.split(",");
                            console.log(mainProblemarr);
                            var mainSymptomarrarr = data.data.mainSymptomarrCount.split(",");
                            var positiveIndexarrarr = data.data.positiveIndexarrCount.split(",");
                            var healthRiskarrarr = data.data.healthRiskarrCount.split(",");
                            if($("#userIds").val()!=""){
                              $("#inputcrowdid").show();
                      		  $("#inputcrowdid").val("自定义筛选用户"+($("#userIds").val().split(",").length-1)+"人");
                      	  }else{
                      		$("#inputcrowdid").hide();
                      	  }
                           
                            for(var i=0;i<mainProblemarr.length-2;i++){
                                mainSymptomarrAddId();
                            }
                            for(var i=0;i<mainProblemarr.length-1;i++){
                                if(mainProblemarr[i]!=""){
                                    $("input[name='mainProblemName']").show();
                                    $($("input[name='mainProblemName']")[i]).val(mainProblemarr[i]+"人");
                                }
                            }
                            for(var i=0;i<mainSymptomarrarr.length-2;i++){
                                mainSymptomarrCountAddId();
                            }
                            for(var i=0;i<mainSymptomarrarr.length-1;i++){
                                if(mainSymptomarrarr[i]!=""){
                                    $("input[name='mainSymptomName']").show();
                                    $($("input[name='mainSymptomName']")[i]).val(mainSymptomarrarr[i]+"人");
                                }
                            }
                            for(var i=0;i<positiveIndexarrarr.length-2;i++){
                                positiveIndexarrAddId();
                            }
                            for(var i=0;i<positiveIndexarrarr.length-1;i++){
                                if(positiveIndexarrarr[i]!="") {
                                    $("input[name='positiveindexName']").show();
                                    $($("input[name='positiveindexName']")[i]).val(positiveIndexarrarr[i] + "人");
                                }
                            }
                            for(var i=0;i<healthRiskarrarr.length-2;i++){
                                healthRiskarrAddId();
                            }
                            for(var i=0;i<healthRiskarrarr.length-1;i++){
                                if(healthRiskarrarr[i]!=""){
                                    $("input[name='healthRiskName']").show();
                                    $($("input[name='healthRiskName']")[i]).val(healthRiskarrarr[i]+"人");
                                }
                            }
                        }, error: function (data) {
                            console.log('新增失败');
                        }
                    });
                    }
                }
               layer.close(layer.index);
            },
            btn2: function () {
            parent.layer.close(indext);
            },
        });
    }
    function healthTopicsSelect(){
      var themeName =   $('#healthTopicsSelectId option:selected').text();//选中的文本
        $("#themeName").val(themeName);
    }
    //集团名称选择
    function subsidiaryDivExpBiz(){
        if( $('#subsidiaryRadioId tr').size()<=1){
            alert("旗下暂无子公司");
            return false;
        }else{
            $('.subsidiaryRadioDivId').show();
        }
    }
    //选择人群页面
    function selectCrowd(){
        var healthThemeId = $("#healthTopicsSelectId").val();
        window.location.href="<%=path%>/selectCrowd/page?healthThemeId="+healthThemeId;
    }

    //子公司选择
    function expBiz() {
        $('.pop').show();
    }

    //健康师选择
    function healthManagerSelectOnclick(node) {
        $('.healthManagerRadioDivId').show();

        $("#healthManagerDivDuttonId").click(function () {
            var names = document.getElementsByName("managerId");
            var i = 0;
            for (i; i < names.length; i++) {
                if (names[i].checked) {
                    var td = $(node).parent().parent();
                    var prevTd = td.prev("td");
                    var input = prevTd.find("input");
                    input.val( names[i].getAttribute('valueName'));
                }
            }
            $('.healthManagerRadioDivId').hide();
            $("#healthManagerDivDuttonId").unbind();
        })

        $(".mr33").click(function () {
            $('.healthManagerRadioDivId').hide();
            $("#healthManagerDivDuttonId").unbind();
        });
    }


    //医生选择
    function doctorSelectOnclick(node) {
        $('.koboroDoctorRadioDivId').show();

        $("#koboroDoctorDivDuttonId").click(function () {
            var names = document.getElementsByName("doctorId");
            var i = 0;
            for (i; i < names.length; i++) {
                if (names[i].checked) {
                    var td = $(node).parent().parent();
                    var prevTd = td.prev("td");
                    var input = prevTd.find("input");
                    input.val( names[i].getAttribute('valueName'));
                }
            }
            $('.koboroDoctorRadioDivId').hide();
            $("#koboroDoctorDivDuttonId").unbind();
        })

        $(".mr32").click(function () {
            $('.koboroDoctorRadioDivId').hide();
            $("#koboroDoctorDivDuttonId").unbind();
        });
    }


    //预约时间段
    function appointmentOnchange() {
        var appointmentTime=$("#appointmentTime").val();
        if(appointmentTime==0){
            $("#appointmentTime").val(1)
        }
        else{
            $("#appointmentTime").val(0)
        }
        $('#appointmentPeriodDiv').toggle();
    }

    //服务人数上限是否设置  改变输入框状态
    function maxmemberOnclick() {
        var radios = document.getElementsByName("maxmemberName");
        for (var i = 0; i < radios.length; i++) {
            //判断那个单选按钮为选中状态
            if (radios[i].checked) {
                if (radios[i].value == 1) {
                    $("#maxmemberInputId").removeAttr("readonly");
                } else {
                    $("#maxmemberInputId").val("");
                    $("#maxmemberInputId").attr("readonly", "readonly");
                }
            }
        }
    }

    function servicesAvailableAddId() {
        var a = $("#servicesAvailableAddDivId").html();
        $("#servicesAvailableAddParentDivId").append(a);
        // console.log("a", a);
        //
        // var t1 = "abba";
        // // alert(t1.replaceAll("b","a"));
        //
        // var s1 = "abc";
        // var regex = /(<input[^>]+id=")([^"]+)("[^>]*>)/g;
        // var regex2 = /(<input[^>]+name=")([^"]+)("[^>]*>)/g;
        // var regex3 = /(<label[^>]+for=")([^"]+)("[^>]*>)/g;
        // a = a.replace(regex, "$1$2" + s1 + "$3");
        // a = a.replace(regex2, "$1$2" + s1 + "$3");
        // a = a.replace(regex3, "$1$2" + s1 + "$3");
        // alert(a);
        // console.log("a", a);.children("tbody")
    }
    function mainSymptomarrAddId() {
        var a = $("#mainSymptomarrCountId").html();
        $("#mainProblemCountId").append(a);
    }
    function mainSymptomarrCountAddId() {
        var a = $("#mainSymptomarrCountId1").html();
        $("#mainProblemCountId1").append(a);
    }
    function positiveIndexarrAddId() {
        var a = $("#mainSymptomarrCountId2").html();
        $("#mainProblemCountId2").append(a);
    }
    function healthRiskarrAddId() {
        var a = $("#mainSymptomarrCountId3").html();
        $("#mainProblemCountId3").append(a);
    }

    function gradeChange(){
        var aa = $('#testSelect option:selected').val();
        var ss = $("input[name='managerName']").val();
        /* if(aa!=''&&ss!=''){
            healthManagerOnclick();
        } */
    }
    //医生
    function gradeChangeDoctors(){
        var aa = $('#testSelectDoctors option:selected').val();
        var ss = $("input[name='doctorName']").val();
        /* if(aa!=''&&ss!=''){
            doctorAddOnclick();
        } */
    }
    function healthManagerOnclick() {
        $("#healthManagerTableId").children("tbody").append(healthManagerTrd);
    }

    function doctorAddOnclick() {
        $("#doctorTableId").children("tbody").append(doctorTrId);
    }

    function RemoveTrOnclick(nowTr) {
        $(nowTr).parent().parent().remove();
    }

    function RemoveTrSerivceOnclick(nowTr) {
        $(nowTr).parent().remove();
    }
    function check(form) {
        if (!form.themeId.value || form.themeId.value == -1) {
            alert("健康主题不能为空");
            return false;
        }
        if (!form.servicesGroupInputName.value) {
            alert("服务集团不能为空");
            form.servicesGroupInputName.focus();
            return false;
        }
        var serviceLocation=$("#serviceLocationId").val();
        if(serviceLocation==""){
        	  alert("服务地点不能为空");
              form.serviceLocationName.focus();
              return false;
        }
        var appointmentTime=$("#appointmentTime").val();
        //设置时间段
        if(appointmentTime==0){
          //查询是否选择上午和下午时间
            var appointmentPeriodAM1=$("input[name='appointmentPeriodAM1']").val();
            var appointmentPeriodAM2=$("input[name='appointmentPeriodAM2']").val();
            var appointmentPeriodPM1=$("input[name='appointmentPeriodPM1']").val();
            var appointmentPeriodPM2=$("input[name='appointmentPeriodPM2']").val();
            if((appointmentPeriodAM1=="00:00:00" || appointmentPeriodAM1=="")||(appointmentPeriodAM2=="00:00:00" || appointmentPeriodAM2=="")){
                alert("请正确选择上午时间段!")
                return false;
            }
            if((appointmentPeriodPM1=="00:00:00" || appointmentPeriodPM1=="")||(appointmentPeriodPM2=="00:00:00" || appointmentPeriodPM2=="")){
                alert("请正确选择下午时间段!")
                return false;
            }
        }

        //校验服务项目
        var servicesAvailableSelects=[];
        $("[name=servicesAvailableSelect]").each(function () {
        	if($(this).val()=="" || $(this).val()== -1){
        		
        	}else{
        		servicesAvailableSelects.push($(this).val());
        	}
	        });
        if(servicesAvailableSelects.length==0){
        	 alert("服务项目不能为空");
             form.servicesAvailableSelect.focus();
             return false;
        }
        //校验服务人数上限
        var itemCeilings=[];
        $("[name=itemCeiling]").each(function () {
        	if($(this).val()==""){
        		 alert("服务人数上限不能为空");
                 form.$(this).focus();
                 return false;
        	}
	        });
       
      /*   if (!form.servicesAvailableSelect.value || form.servicesAvailableSelect.value == -1) {
        	alert(form.servicesAvailableSelect.value);
            alert("服务项目不能为空");
            form.servicesAvailableSelect.focus();
            return false;
        } */
        //健康管理师校验
        var managerNames=[];
        $("[name=managerName]").each(function () {
        	if($(this).val()=="" || $(this).val()== -1){
        		
        	}else{
        		managerNames.push($(this).val());
        	}
	        });
        if(managerNames.length==0){
        	 alert("请选择健康管理师");
             form.managerName.focus();
             return false;
        }
        //医生校验
        var doctorNames=[];
        $("[name=doctorName]").each(function () {
        	if($(this).val()=="" || $(this).val()== -1){
        		
        	}else{
        		doctorNames.push($(this).val());
        	}
	        });
        if(doctorNames.length==0){
        	 alert("请选择医生");
             form.doctorName.focus();
             return false;
        }
        return  true;
    }
    function returnpage(){
        window.location.href="<%=path%>/healthThemeTask/selectAll";
    }
</script>
<script type="text/javascript">
//选择时间间隔之前选择时间段
function selectTimeSection(obj){
	 var appointmentPeriodAM1=$("input[name='appointmentPeriodAM1']").val();
	 var appointmentPeriodAM2=$("input[name='appointmentPeriodAM2']").val();
	 var appointmentPeriodPM1=$("input[name='appointmentPeriodPM1']").val();
	 var appointmentPeriodPM2=$("input[name='appointmentPeriodPM2']").val();
	 if((appointmentPeriodAM1=="00:00:00" || appointmentPeriodAM1=="")||(appointmentPeriodAM2=="00:00:00" || appointmentPeriodAM2=="")){
		 alert("请正确选择上午时间段!")
        document.getElementById("timeLagName").options.selectedIndex = 0; //回到初始状态
        $("#timeLagName").selectpicker('refresh');//对searchPayState这个下拉框进行重置刷新
		 return false;
	 }
	 if((appointmentPeriodPM1=="00:00:00" || appointmentPeriodPM1=="")||(appointmentPeriodPM2=="00:00:00" || appointmentPeriodPM2=="")){
		 alert("请正确选择下午时间段!")
        document.getElementById("timeLagName").options.selectedIndex = 0; //回到初始状态
        $("#timeLagName").selectpicker('refresh');//对searchPayState这个下拉框进行重置刷新
		 return false;
	 }
	 
}
//上传图片
function uploadImg(){
	 $.ajaxFileUpload
     (
         {
             url:"<%=path%>/upload/uploadingFile", //用于文件上传的服务器端请求地址
             type: 'post',
             secureuri: false, //是否需要安全协议，一般设置为false
             fileElementId: 'inputfile', //文件上传域的ID
             dataType: 'JSON', //返回值类型 一般设置为json
             success: function (data, status)  //服务器成功响应处理函数
             {
            	 $("#imgUrl").val(data);
             },
             error: function (data, status, e)//服务器响应失败处理函数
             {
                 alert("上传失败");
             }
         }
     )
     return false;
}
</script>
</body>
</html>