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
                            <a href='<%=path%>/selectCrowd/page?healthThemeId=${healthThemeId}' class="btn" style="background: none;font-size: 16px" ><font >自定义筛选</font></a>
                            <a href="#" class="btn"  style="background: none;font-size: 16px"><font color="blue">健康主题筛选</font></a>
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
                    <form id="searchFrom" class="form-inline">
                        <table class="table lh32" >
                            <tbody>
                            <tr>
                                <c:forEach items="${mainProblem}" var="c">
                                    <td>
                                        <div class="form-group">
                                            <input  type="checkbox"  class="form-control" checked="checked"  name="mainProblem"   value="${c}" >${c}
                                        </div>
                                    </td>
                                </c:forEach>
                                <c:forEach items="${mainSymptom}" var="c">
                                    <td>
                                        <div class="form-group">
                                            <input  type="checkbox"  class="form-control" checked="checked"  name="mainSymptom"   value="${c}" >${c}
                                        </div>
                                    </td>
                                </c:forEach>
                                <c:forEach items="${positiveIndex}" var="c">
                                    <td>
                                        <div class="form-group">
                                            <input  type="checkbox"  class="form-control" checked="checked"  name="positiveIndex" value="${c}" >${c}
                                        </div>
                                    </td>
                                </c:forEach>
                                <c:forEach items="${healthRisk}" var="c">
                                    <td>
                                        <div class="form-group">
                                            <input  type="checkbox"  class="form-control" checked="checked"  name="healthRisk"    value="${c}" >${c}
                                        </div>
                                    </td>
                                </c:forEach>
                            </tr>
                            <tr>
                                <td align="right">
                                    <footer style="background: none;border-top: 0px">
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
                    <table id="coustomerTable" class="table table-striped table-bordered">
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
$(document).ready(function () {
    var dataTable = $("#coustomerTable").dataTable(options).api();
    $("#searchFrom").find("input").click(function(){
        var aInput = $(this).closest('form').find("input");
        aInput.each(function () {
            var val = $(this).val();
            if (val) {
                $(this).val(val.trim());
            }
        });
        dataTable.ajax.reload();
        dataTable.draw();
    });
});
var column = [
              function (data) {
                  return "<div class='checkbox margin-t-0 text-center'><input id='checkbox"+data.id+"' value='"+data.archival_number+"' type='checkbox' name='themeTemplate'><label for='checkbox"+data.id+"'></label></div>";
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
          var options = page("<%=path%>/selectCrowd/selectCrowdHealthThemeScreeningList", column, function (data) {
              return data.data;
          },'searchFrom');
    function getcode(){
        return 2;
    }
    //全选全不选
    function pitchOn(obj){
        $('input[name="themeTemplate"]').prop('checked', $(obj).prop('checked'));
    }
    function getmainProblem(){
        var cc = $('input[name="riskResultHiddenName"]');
        var mainProblem = "";
        var mainProblemCount = 0;
        $('input[name="mainProblem"]:checked').each(function(j,item){
            if(item.value.indexOf(cc) != -1){
                mainProblemCount + 1;
            }
            mainProblem += item.value+",";
        });
        return mainProblem;
    }
    function getmainSymptom(){
        var mainSymptom = "";
        $('input[name="mainSymptom"]:checked').each(function(j,item){
            mainSymptom += item.value+",";
        })
        return mainSymptom;
    }
    function getpositiveIndex(){
        var positiveIndex = "";
        $('input[name="positiveIndex"]:checked').each(function(j,item){
            positiveIndex += item.value+",";
        })
        return positiveIndex;
    }
    function gethealthRisk(){
        var healthRisk = "1";
        $('input[name="healthRisk"]:checked').each(function(j,item){
            healthRisk += item.value+",";
        })
        return healthRisk;
    }
    function getcheckboxvalue(){
        var healthRisk = "";
        $('input[name="themeTemplate"]:checked').each(function(j,item){
            healthRisk += item.value+",";
        })
        return healthRisk;
    }
   

</script>

</body>
</html>

