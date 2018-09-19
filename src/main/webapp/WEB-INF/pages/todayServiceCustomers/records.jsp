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
  <script type="text/javascript">
	//查询列表
	function findServiceRecordData(){
	     $.ajax({
	         contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	         dataType: "json",
	         data: $('#serviceRecord').serialize(),
	         type: 'get',
	         url: '<%=path%>/todayServiceCustomers/findServiceRecordData',
	         success: function (data) {
	             $('#serviceRecordTable').dataTable().fnClearTable(); //清空表格
	             if(data.length) {
	                 $('#serviceRecordTable').dataTable().fnAddData(showData(data), true); //刷下表格
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
	        var date=timetostr(data[i].service_start_time);
	        tempObj.push(date);
	        tempObj.push(data[i].items);
	        list.push(tempObj);
	    }
	    return list;
	}
    function getDate(){
 	   var date=$("#serviceDate").val();
 	   $("#date").val(date);
    }
</script>
  </head>
  <body style="background:#f5f5f5">
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
              <!-- Start right -->
               <h4 style="margin-top: 0px" class="title">服务记录</h4>
               <a href="<%=path%>/todayServiceCustomers/selectAll" class="btn btn-light">返回</a>
              <!-- End right -->
            </div>
      </div>
    </div>
  </div>
  <!-- end Row -->
  <!-- Start Row -->
  <div class="row" style="margin-top: 30px">
    <!-- Start Panel -->
    <div class="col-md-12">
      <div class="panel panel-default">
         <!-- from -->
         <div class="panel-body">
          <form class="form-inline" action="" id="serviceRecord">
          <!-- 隐藏按照日期查询时间段 -->
              <input name="date" id="date" type="hidden"/>
              <input name="customersId" id="customersId" value="${customersId}" type="hidden"/>
               <div class="form-group">
                 <label for="bolocName" class="form-label"></label>
                   ${todayServiceCustomers.archivalNumber}
               </div>
               <div class="form-group">
                 <label for="bolocName" class="form-label"></label>
                  ${todayServiceCustomers.dept}
               </div>
               <div class="form-group">
                 <label for="bolocName" class="form-label"></label>
                  ${todayServiceCustomers.name}
               </div>
               &nbsp;&nbsp;&nbsp;&nbsp;
               <div class="form-group">
                 <label for="dept" class="form-label"></label>
                  <input  type="text" id="serviceDate" class="selectdate" placeholder="服务日期" onchange="getDate()" style="height: 30px " value="${date}">
               </div>
               <button type="button" class="btn btn-default" onclick="findServiceRecordData()" style="height: 30px">查询</button>
             </form>
           </div>
        <div class="panel-title">
          
        </div>
        <div class="panel-body table-responsive">
            <table id="serviceRecordTable" class="table table-striped table-bordered">
                <thead>
                    <tr>
                          <th>服务日期</th>
                          <th>服务项目</th>
                    </tr>
                </thead>
             
                <tfoot>
                    <tr>
                    </tr>
                </tfoot>
             
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
<script src="<%=path%>/TheHomePageTemplate/js/datatables/jquery.dataTables.js"></script>
<!-- 時間插件 -->
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="<%=path%>/layer/layer.js"></script>
<script src="<%=path%>/js/custom/timeFormatting.js"></script>
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/bootstrap-select/bootstrap-select.js"></script>

<!-- ================================================
Bootstrap Toggle
================================================ -->
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/bootstrap-toggle/bootstrap-toggle.min.js"></script>

<!-- ================================================
Moment.js
================================================ -->
<script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/moment/moment.min.js"></script>
<script>
$(document).ready(function() {
    $('#notService').DataTable();
    findServiceRecordData();
} );
</script>
<script type="text/javascript">
    $(function () {
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
</script>

</body>
</html>