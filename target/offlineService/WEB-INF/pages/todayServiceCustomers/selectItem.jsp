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
  <script type="text/javascript" src="<%=path%>/TheHomePageTemplate/js/jquery.min.js"></script>
  <script type="text/javascript">
  var doctorsJson;
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
      //默认隐藏
      $("#thisOtherServiceItemTitle").hide();
      $("#thisOtherServiceItem").hide();
      //查询所有的医生
      $.ajax({
   	         contentType: "application/x-www-form-urlencoded; charset=UTF-8",
   	         dataType: "json",
   	         type: 'get',
   	         data:{},
   	         url: '<%=path%>/todayServiceCustomers/findDoctors',
   	         success: function (data) {
   	        	 doctorsJson=data;
   	         }, error: function (data) {
   	        	 console.log('查询失败');
   	         }
   	     }); 
  });
	//更多服务项目
	function findOtherItems(){
	     $.ajax({
	         contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	         dataType: "json",
	         data: $('#otherServiceItemFrom').serialize(),
	         type: 'get',
	         url: '<%=path%>/todayServiceCustomers/findOtherItem',
	         success: function (data) {
	        	 //清空表格
	              $("#otherServiceItem").html("");
                  $.each(data,function(i,result){ 
                	  var item=result['item_name'];
                       var isShow="";
                      if(i==0){
                    	  isShow+= "<tr class='"+i+" on'>";
                      }else{
                    	  isShow+= "<tr class='"+i+"'>";
                      }
                      var list =isShow+
                      "<td colspan='2' style='text-align: left'>"+
                       +item+
                       "<i class='fa fa-sort-down' style='float: right;' onclick='displayContent(this)'></i>"+
                      "</td>"+                                         
                      "</tr>"; 
                      $.each(result['itemContent'],function(j,results){  
                    	  var isShow="";
                    	  if(i==0){
                    		  isShow+="<tr class='"+i+"'>"
                    	  }else{
                    		  isShow+= "<tr style='display:none' class='"+i+"'>"
                    	  }
		                   	 list+= isShow+
		                              "<td>"+
		                   	             /* "<input type='checkbox' value='"+results+"' name='otherItem'/>"+ */
		                   	             "<div>"+
					                        "<input style='height: 26px;width: 21px;margin: none'  name='otherItem' value='"+results+"' type='checkbox' >"+
					                        "<label for='"+results+"'></label>"+
					                     "</div>"+
		                              "</td>"+
		                              "<td>"+
		                              results+
		                              "</td>"+
		                           "</tr>"
                     });
                      $("#otherServiceItem").append(list);
                 });
	            
	         }, error: function (data) {
	        	 console.log('新增失败');
	         }
	     });
	} 
	//打开隐藏
	function  displayContent(obj){
		var tr=$(obj).parent().parent();
		var trClass=tr.attr('class');
		//包含on隐藏
		if(tr.hasClass('on')){
			tr.removeClass('on');
			var trClassnew=tr.attr('class');
			$('.'+trClassnew).attr("style","display:none");
			tr.show();
		}else{
			$('.'+trClass).show();
			tr.addClass('on');
		}
		
	}
	//添加项目
    function addItem(){
    	 //获取勾选的本次服务项目
 	   var boxes = document.getElementsByTagName("input");
 	   //自定义服务项目
 	   var otherServiceItems = "";
 	    for(i=0;i<boxes.length;i++){
 	        if(boxes[i].name=="otherItem" && boxes[i].checked == true){
 	        	otherServiceItems+=boxes[i].value+",";
 	        }
 	    }
 	    otherServiceItems = otherServiceItems.substr(0, otherServiceItems.length - 1);
 	    if(otherServiceItems==""){
 	    	layer.msg("请选择要添加的项目");
 	    	return false;
 	    }
 	    var  itemArr=otherServiceItems.split(",");
 	     for ( var i = 0; i <itemArr.length; i++){
 		    console.log(itemArr[i]);
 		    //显示并且追加
 		    if($("#thisOtherServiceItemTitle").hide()){
 		    	$("#thisOtherServiceItemTitle").show();
 		    	$("#thisOtherServiceItem").show();
 		    }else{
 		    	//单纯追加
 		    }
 		   var tdStr="<tr>"+
           "<td>"+
           "<div>"+
           "<input  name='thisOthertem' value='"+itemArr[i]+"';    type='checkbox' style='height: 26px;width: 21px;margin: none'>"+
           "<label for='checkbox1'></label>"+
           "</div>"+
           "</td>"+ 
           "<td>"+itemArr[i]+"</td>+"+
           "<td>"+
           "<select class='selectpicker'  name='doctorName' id='doctorName'>";
             var optionStr="";
             for (var int = 0; int < doctorsJson.length; int++) {
            	 optionStr+="<option value='"+doctorsJson[int].doctor_name+","+doctorsJson[int].login_name+"'>"+doctorsJson[int].doctor_name+"</option>" 
				}
          var endStr="</select>"+    
           "</td>"+
         "</tr>";
        $("#thisOtherServiceItem").append(tdStr+optionStr+endStr);
 		}
   } 
	//改变强行预约
    function changeStatus(obj){
    	obj.remove();
    	layer.msg("强行预约成功,请重新提交");
    }
     //提交以及打印服务项目
    function submitPrint(customersId,taskId,archivalNumber,date){
 	   //获取勾选的本次服务项目
 	   var boxes = document.getElementsByTagName("input");
 	   //本次服务项目
 	   var serviceItems ="";
 	   //自定义服务项目
 	   var otherServiceItems ="";
 	   //自定义服务医生
 	   var otherServiceDoctor = "";
 	   //强行预约的项目
 	   var  enforcementItems="";
 	   //自定义服务项目健康管理师
 	    for(i=0;i<boxes.length;i++){
 	        if(boxes[i].name=="item" && boxes[i].checked == true){
 	        	serviceItems+=boxes[i].value+",";
 	        	var content=$(boxes[i]).parents('td').next().next().text();
 	        	if(content.indexOf("强行预约") >= 0){
 	        		enforcementItems+=boxes[i].value+",";
 	        	}
 	        }
 	        if(boxes[i].name=="thisOthertem" && boxes[i].checked == true){
 	        	otherServiceItems+=boxes[i].value+",";
 	        }
 	    }
 	    if(enforcementItems.length>0){
 	    	enforcementItems = enforcementItems.substr(0, enforcementItems.length - 1);
 	    	layer.msg(enforcementItems+"  需强行预约");
 	    	return false;
 	    }
 	    if(serviceItems.length==0&&otherServiceItems.length==0){
 	    	layer.msg("请选择服务项目");
 	    	return false;
 	    }
 	    //获取所有select 姓名和登录名
  	    $("select option:selected").each(function() {
  	    	otherServiceDoctor+=$(this).val()+";";
  	    });
 	    serviceItems = serviceItems.substr(0, serviceItems.length - 1);
 	    otherServiceItems = otherServiceItems.substr(0, otherServiceItems.length - 1);
 	    otherServiceDoctor = otherServiceDoctor.substr(0, otherServiceDoctor.length - 1);
 	    //提交
	   $.ajax({
             //几个参数需要注意一下
                 type: "POST",//方法类型
                 dataType: "json",//预期服务器返回的数据类型
                 url: "<%=path%>/todayServiceCustomers/saveServiceItem",
                 data:{"customersId":customersId,"taskId":taskId,"archivalNumber":archivalNumber,"serviceItems":serviceItems,"otherServiceItems":otherServiceItems,"otherServiceDoctor":otherServiceDoctor},
                 success: function (result) {
                     console.log(result);//打印服务端返回的数据(调试用)
                     if (result) {
                     	var url="<%=path%>/todayServiceCustomers/printItems?customersId="+customersId+"&date="+date;
                     	 layer.open({
                     	      type:2,
                     	      title:"本次服务项目",
                     	      closeBtn:1, //显示关闭按钮
                     	      shade: [0.8, '#393D49'],
                     	      area: ['55%','50%'],
                     	      shadeClose:true,
                     	      scrollbar: false, // 父页面 滚动条 禁止 
                     	      offset: 'auto', //右下角弹出
                     	      shift: 2,
                     	      zIndex: 999,
                     	      content: [url, 'yes'],
                     	      end: function () {
                                 window.location.href="<%=path%>/todayServiceCustomers/selectAll";
                                 }
                     		  });
                     }else{
                     	layer.msg("请选择服务项目");
                     	return false;
                     }
                     ;
                 },
                 error : function() {
               	  layer.msg("保存失败");
                 }
             });  
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
          <li><a href="<%=path%>/logout"><i class="fa falist fa-power-off"></i> 退出登录</a></li>
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
                 <div class="panel-body table-responsive">
            <table id="customers" class="table table-striped table-bordered">
                <thead>
                    <tr>
                         <th>姓名</th>
                         <th>部门</th>
                         <th>性别</th>
                         <th>联系方式</th>
                         <th>服务记录</th>
                    </tr>
                </thead>
             
                <tfoot>
                   <tr>
                      <td>${todayServiceCustomers.name}</td>
                      <td>${todayServiceCustomers.dept}</td>
                      <td>
                       <c:if test="${todayServiceCustomers.sex==1}">男</c:if>
                        <c:if test="${todayServiceCustomers.sex==2}">女</c:if>
                      </td>
                       <td>${todayServiceCustomers.phoneNumber}</td>
                       <td><a href="<%=basePath%>todayServiceCustomers/findServiceRecord?customersId=${todayServiceCustomers.id}"><i class='fa fa-eye'></i></a></td>
                   </tr>
                </tfoot>
             
                <tbody>
                  
                </tbody>
            </table>
        </div>
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
        <div class="panel-title">
            <div class="panel-body">
            <button  onclick="submitPrint('${customersId}','${taskId}','${todayServiceCustomers.archivalNumber}','${date}');" class="btn btn-light" style="margin-left: 69%">提交及打印已选项目</button>
             <form class="form-inline" action="">
               <div class="form-group">
                 <label for="" class="form-label" style="font-size: 17;margin-top: 6px">本次服务项目</label>
               </div>
             </form>
           </div>
        </div>
        <div class="panel-body table-responsive">
            <table id="serviceItem" class="table table-striped table-bordered" style="border:1px  solid #ddd">
                <thead>
                    <tr>
                         <th style="background: none"></th>
                         <th>服务项目</th>
                         <th>剩余可约人数</th>
                    </tr>
                </thead>
                <tbody>
                 <c:forEach var="i" items="${items}" varStatus="index">
                     <tr>
                         <td>
                         <div >
                         <input  name="item" value="${i.serviceProject}"  ${i.isCheck ==1?'checked="checked"':''} type='checkbox' style="height: 26px;width: 21px;margin: none">
                         <label for='checkbox${index.index}'></label>
                         </div>
                         </td> 
                         <td>${i.serviceProject}</td>
                         <td>
                           <c:if test="${i.serviceProjectCeiling==0}">
                                                                                                无人数限制
                           </c:if>
                           <c:if test="${i.serviceProjectCeiling!=0 }">
                                <c:if test="${i.serviceProjectCeiling-i.number==0}">0&nbsp;&nbsp;<a style="cursor:pointer;" onclick="changeStatus(this)">强行预约</a></c:if>                                              
                                <c:if test="${i.serviceProjectCeiling-i.number!=0}">${i.serviceProjectCeiling-i.number}</c:if>                                 
                           </c:if>
                         </td>
                     </tr>
                  </c:forEach>   
                 </tbody>
            </table>


        </div>
        
        
        
        <!-- 本次其他服务项目 -->
        <div class="panel-title" style="margin-top: 10px;" id="thisOtherServiceItemTitle" >
            <div class="panel-body">
             <form class="form-inline" action="">
               <div class="form-group">
                 <label for="" class="form-label" style="font-size: 17;margin-top: 6px">本次其他服务项目</label>
               </div>
             </form>
           </div>
        </div>
       <!-- <div class="panel-body table-responsive"> -->
            <table id="thisOtherServiceItem" class="table table-striped table-bordered" style="border:1px  solid #ddd">
                <thead>
                </thead>
                <tbody>
                     
                 </tbody>
            </table>
       <!--  </div> -->
        
        
        
        <div class="panel-title" style="margin-top: 10px">
            <div class="panel-body">
             <form class="form-inline" action="" id="otherServiceItemFrom">
               <div class="form-group">
                 <label for="" class="form-label" style="font-size: 17;margin-top: 6px"> 更多服务项目</label>
               </div>
               <div class="form-group">
                 <label for="name" class="form-label"></label>
                 <input style="width: 300px；;height: 36px" type="text" name="name" class="form-control" id="name" >
               </div>
                  <a onclick="findOtherItems()" class="btn btn-light">查询</a>
                  <a  onclick="addItem()" class="btn btn-light" style="margin-left: 69%">添加</a>
             </form>
           </div>
        </div>
        <div class="panel-body table-responsive">
            <table id="otherServiceItem" class="table table-striped table-bordered" style="border: 1px solid #ddd">
                <thead>
                    <tr>
                       
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
<script>
$(document).ready(function() {
    /*  $('#serviceItem').DataTable(); */
    /*  $('#otherServiceItem').DataTable(); */
    /* $('#customers').DataTable(); */
    findOtherItems();
} );
</script>
</body>
</html>