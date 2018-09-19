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
<!-- Start Page Loading -->
<div class="loading"><img src="<%=path%>/TheHomePageTemplate/img/loading.gif" alt="loading-img"></div>
<!-- End Page Loading -->
<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START TOP -->

<!-- END TOP -->
<!-- //////////////////////////////////////////////////////////////////////////// -->

<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START CONTENT -->
<!-- END SIDEBAR -->
<!-- //////////////////////////////////////////////////////////////////////////// -->

<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- Start Page Header -->
<!-- End Page Header -->
<!-- //////////////////////////////////////////////////////////////////////////// -->
<!-- START CONTAINER -->
    <!-- Start Row -->
    <div class="row btndiv">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                        <div class="panel-body">
                            <!-- Start right -->
                            <div class="col-md-12 col-lg-6" >
                                <a href='#' class="btn" style="background: none;font-size: 16px"><font color="blue">自定义筛选</font></a>
                                <a href="<%=path%>/selectCrowd/page2?healthThemeId=${healthThemeId}" class="btn"  style="background: none;font-size: 16px" ><font >健康主题筛选</font></a>
                            </div>
                            <!-- End right -->
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
                    <form id="fromId" class="form-inline">
                        <table class="table lh32" >
                            <tbody>
                            <tr>
                                <td class="tr">公司:</td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 230px" type="text"  class="form-control" id="blocName" name="blocName">
                                    </div>
                                </td>
                                <td class="tr">主要问题:</td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 230px" type="text"  class="form-control" id="main_health_problems_string" name="main_health_problems_string">
                                    </div>
                                </td>
                                <td class="tr">建档情况:</td>
                                <td>
                                    <div class="form-group" style="margin-top:  10px;margin-left: -20px">
                                        <div class="col-sm-8">
                                            <select class="selectpicker"  name="partyBuilding" id="partyBuilding">
                                                <option value="">建档情况</option>
                                                <option value="yes">已建档</option>
                                                <option value="no">未建档</option>
                                            </select>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tr">部门:</td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 230px" type="text"  class="form-control" id="dept" name="dept">
                                    </div>
                                </td>
                                <td class="tr">主要症状:</td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 230px" type="text"  class="form-control" id="current_diagnosis" name="current_diagnosis">
                                    </div>
                                </td>
                                <td class="tr">年龄段:</td>
                                <td>
                                    <div class="form-group" style="margin-top:  10px;margin-left: -20px">
                                        <div class="col-sm-8">
                                            <select class="selectpicker"  name="age" id="age">
                                                <option value="">年龄段</option>
                                                <option value="20-30">20-30</option>
                                                <option value="30-40">30-40</option>
                                                <option value="40-50">40-50</option>
                                                <option value="50-60">50-60</option>
                                                <option value="60-70">60-70</option>
                                                <option value="70-80">70-80</option>
                                            </select>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tr">性别:</td>
                                <td>
                                    <div class="form-group" style="margin-top:  10px;margin-left: -20px">
                                        <div class="col-sm-8">
                                            <select class="selectpicker"  name="sex" id="sex">
                                                <option value="">性别</option>
                                                <option value="男">男</option>
                                                <option value="女">女</option>
                                            </select>
                                        </div>
                                    </div>
                                </td>
                                <td class="tr">阳性指标:</td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 230px" type="text"  class="form-control" id="abnormal_clinical_indicators" name="abnormal_clinical_indicators">
                                    </div>
                                </td>
                                <td class="tr">健康风险:</td>
                                <td>
                                    <div class="form-group" style="margin-top:  10px;margin-left: -20px">
                                        <div class="col-sm-8">
                                            <select class="selectpicker"  name="riskResult" id="riskResult">
                                                <option value="">健康风险</option>
                                                <option value="乳腺癌风险">乳腺癌风险</option>
                                                <option value="宫颈癌风险">宫颈癌风险</option>
                                                <option value="直结肠癌风险">直结肠癌风险</option>
                                                <option value="胃癌风险">胃癌风险</option>
                                                <option value="前列腺癌风险">前列腺癌风险</option>
                                                <option value="肺癌风险">肺癌风险</option>
                                                <option value="外周血管病风险">外周血管病风险</option>
                                                <option value="慢性肾病风险">慢性肾病风险</option>
                                                <option value="冠心病风险">冠心病风险</option>
                                                <option value="脑卒中风险">脑卒中风险</option>
                                                <option value="慢性阻塞性肺疾病">慢性阻塞性肺疾病</option>
                                                <option value="型糖尿病风险">型糖尿病风险</option>
                                                <option value="高血压风险">高血压风险</option>
                                            </select>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tr">体检阳性汇总:</td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 230px" type="text"  class="form-control" id="reportProblem" name="reportProblem">
                                    </div>
                                </td>
                                <td class="tr">客户姓名:</td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 230px" type="text"  class="form-control" id="name" name="name">
                                    </div>
                                </td>
                                <td class="tr">联系方式:</td>
                                <td>
                                    <div class="form-group">
                                        <input style="width: 230px" type="text"  class="form-control" id="phoneNumber" name="phoneNumber">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td >
                                    <footer style="background: none;border-top: 0px">
                                        <button class="btn btn-primary" type="button" id="selectButtonId">查&nbsp;&nbsp;&nbsp;询</button>
                                    </footer>
                                </td>
                            </tr>
                            </tbody>
                        </table>
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
                            <th>档案号</th>
                            <th>性别</th>
                            <th>姓名</th>
                            <th>联系方式</th>
                            <th>部门</th>
                            <th>主要问题</th>
                            <th>阳性指标</th>
                            <th>健康风险</th>
                            <th>体检阳性汇总</th>
                            <th>主要疾病</th>
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
<!-- 時間插件 -->
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="<%=path%>/layer/layer.js"></script>
<script src="<%=path%>/js/custom/timeFormatting.js"></script>
<script src="<%=path%>/TheHomePageTemplate/js/jquery.dataTables.js"></script>
<script src="<%=path%>/js/page.js"></script>
<script>
    //全选全不选
    function pitchOn(obj){
        $('input[type=checkbox]').prop('checked', $(obj).prop('checked'));
    }
    function getcode(){
        return 1;
    }
    function getChoseIds(){
        var ids = "";
        $.each($('input[name="check"]:checked'),function(){
            ids +=$(this).val()+",";
        });
        return ids;
    }
    $(document).ready(function () {
        var dataTable = $("#task").dataTable(options).api();
        searchData(dataTable,$("#selectButtonId"));
    });

    var column = [
        function (data) {
            return "<div class='checkbox margin-t-0 text-center'><input id='checkbox"+data.id+"' value='"+data.archival_number+"' type='checkbox' name='check'><label for='checkbox"+data.id+"'></label></div>";
        },
        "archival_number",
        "sex",
        "name",
        "phone_number",
        "dept",
        "main_health_problems_string",
        "abnormal_clinical_indicators",
        "riskResult",
        "reportProblem",
        "current_diagnosis"
    ];

    var options = page("<%=path%>/selectCrowd/list", column, function (data) {
        return data.data;
    }, 'fromId');

</script>

</body>
</html>

