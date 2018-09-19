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
  <link href="<%=path%>/TheHomePageTemplate/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
  </head>
  <body style="background:#f5f5f5">
<!-- START CONTENT -->
<div class="content" style="padding-top: 76px;">
<!-- START CONTAINER -->
  <!-- Start Row -->
  <div class="row" style="margin-top: 200px">
      <button onclick="confirmTheRelease('${themeTask.id}','${themeTask.serviceStartTime}')">确认发布</button>
     
      <input  type="text" id="serviceDate" class="selectdate" placeholder="服务日期"  style="height: 30px " value="${date}">
   
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
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="<%=path%>/TheHomePageTemplate/js/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="<%=path%>/layer/layer.js"></script>
<script>
$(function () {
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
});
function confirmTheRelease(taskId,serviceStartTime){
	var data=$(".selectdate").val();
	if(data==""){
		layer.msg("请选择发布时间！");
		return false;
	}else{
		var releaseTime=new Date(data);
		var startTime=new Date(serviceStartTime);
		if(releaseTime > startTime){
			layer.msg("发布日期大于主题任务开始日期！");
			return false;
		}else{
			//修改发布日期
			   //是否确认放弃任务
		    layer.confirm('是否确认发布,发布后任务信息不能修改？', {
		           btn: ['确定','取消'] //按钮
		       }, function(){
		    	   $.ajax({
		               //几个参数需要注意一下
		                   type: "POST",//方法类型
		                   dataType: "json",//预期服务器返回的数据类型
		                   url: "<%=path%>/healthThemeTask/publish",
		                   data:{"taskId":taskId,"releaseTime":data},
		                   success: function (result) {
		                	   if(result.code==1){
		                	     layer.alert("发布成功!",function(){
		                	    	 var index=parent.layer.getFrameIndex(window.name);
		                	    	 window.parent.location.reload();
		                	    	 parent.layer.close(index);
		                	     })
		                	   }else{
		                		   layer.alert("发布失败！");
		                		   return false;
		                	   }
		                   },
		                   error : function() {
		                 	  layer.msg("发布失败");
		                   }
		               });
		       });
		}
	}
}
</script>
</body>
</html>