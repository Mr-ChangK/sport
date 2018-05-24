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
            <a class="navbar-brand" href="/index">体测分析系统</a>
        </div>
        <ul class="nav navbar-top-links navbar-right">
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#" id="out"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
    </nav>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <#if role=="3">
                <li>
                    <a class="active-menu" href="/sports/student?path=studentManager"><i class="fa fa-dashboard"></i>学生管理</a>
                </li>

                <li>
                    <a href="/sports/teacher?path=teacherMan"><i class="fa fa-desktop"></i> 老师管理</a>
                </li>
                </#if>
                <#if role=="1"||role=="3">
                <li>
                    <a href="/sports/charts?path=chartManager"><i class="fa fa-bar-chart-o"></i>图表</a>
                </li>
                </#if>
                <#if role=="2">
                <li>
                    <a href="/sports/tranking?path=studentindex"><i class="fa fa-qrcode"></i>首页</a>
                </li>
                </#if>
                <#if role=="1">
                <li>
                    <a href="/sports/insertGrade?path=studentManager"><i class="fa fa-table"></i>成绩录入</a>
                </li>
                </#if>
                <#if role=="3">
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
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            学生信息<input id="btn_add" class="btn btn-small btn-primary" style="float:right" type="button" value="添加"/>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>用户名</th>
                                        <th>姓名</th>
                                        <th>年龄</th>
                                        <th>成绩</th>
                                        <th>老师姓名</th>
                                        <th>学院</th>
                                        <th>专业</th>
                                        <th>删除</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list studentList as student>
                                    <tr class="odd gradeX">
                                        <td>${student.userName}</td>
                                        <td>${student.name}</td>
                                        <td>${student.age}</td>
                                        <td>${student.grade}</td>
                                        <td>${student.teacherName}</td>
                                        <td>${student.college}</td>
                                        <td>${student.major}</td>
                                        <td><button class="btn-primary" value="${student.id}" onclick='deleteStudent("${student.id}")'>删除</button></td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="txt_departmentname">姓名</label>
                        <input type="text" name="txt_name" class="form-control" id="txt_name" placeholder="姓名">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">用户名</label>
                        <input type="text" name="txt_username" class="form-control" id="txt_username" placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">年龄</label>
                        <input type="text" name="txt_age" class="form-control" id="txt_age" placeholder="年龄">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">性别</label>
                        <input type="text" name="txt_sex" class="form-control" id="txt_sex" placeholder="性别">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">老师姓名</label>
                        <input type="text" name="txt_teacher" class="form-control" id="txt_teacher" placeholder="老师姓名">
                    </div>
                    <div class="form-group">
                        <label for="txt_departmentlevel">密码</label>
                        <input type="password" name="txt_password" class="form-control" id="txt_password" placeholder="密码">
                    </div>
                    <div class="form-group">
                        <label for="txt_statu">学院</label>
                        <input type="text" name="txt_college" class="form-control" id="txt_college" placeholder="学院">
                    </div>
                    <div class="form-group">
                        <label for="txt_statu">专业</label>
                        <input type="text" name="txt_major" class="form-control" id="txt_major" placeholder="专业">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                    <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
                </div>
            </div>
        </div>
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

    <script>
        $(function(){

        })
        function deleteStudent(id){
            $.ajax({
                type: "post",
                url: "/sports/deleteStudent",
                data: {"id":id},
                dataType: "json",
                success: function(data){
                    if(data.success==false){
                        alert("删除失败")
                    }
                    window.location.reload()
                }
            });
        }
        $("#btn_add").click(function () {
            $("#myModalLabel").text("新增");
            $('#myModal').modal();
        });
        $("#btn_submit").click(function(){
            if($("#txt_name").val()==null||$("#txt_password").val()==null||$("#txt_password").val()==null){
                alert("不能为空")
            }
            $.ajax({
                type: "post",
                url: "/sports/saveStudent",
                data: {
                    "name":$("#txt_name").val(),
                    "userName":$("#txt_username").val(),
                    "password":$("#txt_password").val(),
                    "teacherName":$("#txt_teacher").val(),
                    "sex":$("#txt_sex").val(),
                    "age":$("#txt_age").val(),
                    "college":$("#txt_college").val(),
                    "major":$("#txt_major").val(),
                },
                dataType: "json",
                success: function(data){
                    if(data.success==false){
                        alert("保存失败")
                    }else{
                        alert("保存成功")
                    }
                    window.location.reload()
                }
            });
        })
        $("#out").click(function(){
            window.location.href="/loginOut"
        })
    </script>
</body>

</html>