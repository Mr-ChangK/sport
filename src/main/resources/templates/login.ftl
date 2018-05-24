<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Login Form Template</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="${request.contextPath}/assetslogin/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/assetslogin/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/assetslogin/css/form-elements.css">
    <link rel="stylesheet" href="${request.contextPath}/assetslogin/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="${request.contextPath}/assetslogin/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="${request.contextPath}/assetslogin/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="${request.contextPath}/assetslogin/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${request.contextPath}/assetslogin/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${request.contextPath}/assetslogin/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>体测分析系统</strong></h1>
                    <div class="description">

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>登录</h3>
                            <p>请输入用户名和密码登录</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/login" method="post" class="login-form" id="form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="username" placeholder="Username..."
                                       class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="Password..."
                                       class="form-password form-control" id="form-password">
                            </div>
                            <div class="form-group">
                                <input type="radio" name="role" value="2" checked>&nbsp&nbsp学生
                                <input type="radio" name="role" value="1">&nbsp&nbsp老师
                                <input type="radio" name="role" value="3">&nbsp&nbsp管理员
                            </div>
                            <button type="button" class="btn" id="ok">登录!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Javascript -->
<script src="${request.contextPath}/assetslogin/js/jquery-1.11.1.min.js"></script>
<script src="${request.contextPath}/assetslogin/bootstrap/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/assetslogin/js/jquery.backstretch.min.js"></script>
<script src="${request.contextPath}/assetslogin/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="${request.contextPath}/assetslogin/js/placeholder.js"></script>
<![endif]-->
<script type="text/javascript">
    $(function () {
        if (${result}==false){
            alert("账户或者密码错误，请重新登录")
        }
    })
    $("#ok").click(function () {
        if($('input[name="role"]:checked').val()==null){
            alert("请选择您的身份")
            return
        }
        $("#form").submit();
    });
</script>

</body>

</html>