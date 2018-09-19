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
    <!-- ========== Css Files ========== -->
    <link href="<%=path%>/TheHomePageTemplate/css/root.css" rel="stylesheet">
    <script type="text/javascript">
    function dayin()
    {   document.body.innerHTML=document.getElementById('print').innerHTML;
        window.print();
    }
    </script>
</head>
<body style="background:#f5f5f5">
<button type="button" style="float: right;margin-bottom: 5px;margin-right: 20px;background-color: none;color: none" onclick="dayin()" class="btn btn-default" >打印</button>
<!-- START CONTAINER -->
<div class="container-padding" style="margin-top:0px;" id="print">
                <!-- from -->
                <h1 style="text-align: center;">本次服务项目</h1>
                <div class="panel-body">
                    <form class="form-inline" id="search" action="">
                        <div class="form-group">
                            <label for="themeName" class="form-label">档案号</label>
                            ${todayServiceCustomers.archivalNumber }
                        </div>
                        <div class="form-group">
                            <label for="name" class="form-label">姓名</label>
                            ${todayServiceCustomers.name }
                        </div>
                        <div class="form-group">
                            <label for="date" class="form-label">日期</label>
                           ${date}
                        </div>
                    </form>
                </div>
                <div class="panel-body table-responsive" style="margin-bottom:10px">
                    <table id="templateTable" class="table table-striped table-bordered">
                        <thead>
                        <th>服务项目</th>
                        <th>完成打"√"</th>
                        <th>完成人</th>
                        </thead>
                       <!--  <tfoot>
                        <tr>
                        </tr>
                        </tfoot> -->
                        <tbody>
                         <c:forEach var="i" items="${items}">
                                        <tr>
                                            <td>${i.served_items}</td>
                                            <td>
                                              &nbsp;
                                            </td>
                                            <td>
                                             &nbsp;
                                            </td>
                                        </tr>
                          </c:forEach>  
                        </tbody>
                    </table>
                </div>
</div>
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
<script src="<%=path%>/TheHomePageTemplate/js/jquery.dataTables.js"></script>
<script src="<%=path%>/layer/layer.js"></script>
<script src="<%=path%>/js/page.js"></script>
<script>
</script>
</body>
</html>