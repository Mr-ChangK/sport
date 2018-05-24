<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>体测分析系统</title>
    <!-- Bootstrap Styles-->
    <link href="${request.contextPath}/assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FontAwesome Styles-->
    <link href="${request.contextPath}/assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- Morris Chart Styles-->
    <link href="${request.contextPath}/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet"/>
    <!-- Custom Styles-->
    <link href="${request.contextPath}/assets/css/custom-styles.css" rel="stylesheet"/>
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
</head>

<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">体测分析系统</a>
        </div>
    </nav>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <#if role=3>
                <li>
                    <a class="active-menu" href="studentManager.ftl"><i class="fa fa-dashboard"></i>学生管理</a>
                </li>

                <li>
                    <a href="teacherMan.ftl"><i class="fa fa-desktop"></i> 老师管理</a>
                </li>
                </#if>
                <#if role==1||role==3>
                <li>
                    <a href="chartManager.ftl"><i class="fa fa-bar-chart-o"></i>图表</a>
                </li>
                </#if>
                <#if role==2>
                <li>
                    <a href="studentindex.ftl"><i class="fa fa-qrcode"></i>首页</a>
                </li>
                </#if>
                <#if role==1>
                <li>
                    <a href="gradeinsert.ftl"><i class="fa fa-table"></i>成绩录入</a>
                </li>
                </#if>
                <#if role==3>
                <li>
                    <a href="sportsManager.ftl"><i class="fa fa-edit"></i>体测管理</a>
                </li>
                </#if>
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        欢迎登录
                    </h1>
                </div>
            </div>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="${request.contextPath}/assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="${request.contextPath}/assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="${request.contextPath}/assets/js/jquery.metisMenu.js"></script>
<!-- Morris Chart Js -->
<script src="${request.contextPath}/assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="${request.contextPath}/assets/js/morris/morris.js"></script>
<!-- Custom Js -->
<script src="${request.contextPath}/assets/js/custom-scripts.js"></script>


</body>

</html>