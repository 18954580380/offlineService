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
<!-- START CONTENT -->
<div class="content" style="padding-top: 10px;">
<!-- START CONTAINER -->
  <!-- Start Row -->
  <div class="row">
    <!-- Start Panel -->
    <div class="col-md-12">
      <button onclick="abortMission('${customers.archivalNumber}',${customers.themeTaskId });" style="margin-left: 565px;width: 73px;margin-bottom: 10px">客户放弃</button>
      </br>
      <div class="panel panel-default">
        <div class="panel-body table-responsive">
            <table id="items" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th style="background:none;"></th>
                        <th>服务项目</th>
                        <th>是否完成</th>
                    </tr>
                </thead>
                
                <tfoot>
                   
                </tfoot>
             
                <tbody>
                  <c:forEach var="item" items="${items}" varStatus="index">
                    <tr>
                      <td>
                      <div class='checkbox margin-t-0 text-center'>
                         <input id="checkbox${index.index}"  name="${item.status}" type="checkbox" data-status="${item.status}" value="${item.served_items}"   ${item.status ==1?'checked="checked"':''}>
                          <label for="checkbox${index.index}"></label></div></td>
                      <td>${item.served_items }</td>
                      <td> ${item.status ==1?'完成':'未完成'}</td>
                    </tr>
                   </c:forEach> 
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
<script src="<%=path%>/layer/layer.js"></script>
<script>
$(document).ready(function() {
    $('#items').DataTable();
} );
//放弃任务
function abortMission(archivalNumber,themeTaskId){
	//获取所有需要放弃的任务
	   var boxes = document.getElementsByTagName("input");
	   //本次服务项目
	   var serviceItems ="";
	    for(i=0;i<boxes.length;i++){
	        if(boxes[i].name=="0" && boxes[i].checked == true){
	        	serviceItems+=boxes[i].value+",";
	        }
	    }
	    if(serviceItems.length==0){
	    	layer.msg("请选择未完成的服务项目");
	    	return false;
	    }
	    serviceItems = serviceItems.substr(0, serviceItems.length - 1);
	   //是否确认放弃任务
	    layer.confirm('是否确认放弃,放弃后不能修改？', {
	           btn: ['确定','取消'] //按钮
	       }, function(){
	    	   $.ajax({
	               //几个参数需要注意一下
	                   type: "POST",//方法类型
	                   dataType: "json",//预期服务器返回的数据类型
	                   url: "<%=path%>/todayServiceCustomers/abortMission",
	                   data:{"archivalNumber":archivalNumber,"themeTaskId":themeTaskId,"serviceItems":serviceItems},
	                   success: function (result) {
	                	   if(result){
	                	     layer.alert("操作成功!",function(){
	                	    	 var index=parent.layer.getFrameIndex(window.name);
	                	    	 window.parent.location.reload();
	                	    	 parent.layer.close(index);
	                	     })
	                	   }
	                   },
	                   error : function() {
	                 	  layer.msg("操作失败");
	                   }
	               });
	       });
}
</script>
</body>
</html>