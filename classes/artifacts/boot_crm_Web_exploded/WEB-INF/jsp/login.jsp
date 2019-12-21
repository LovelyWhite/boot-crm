<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>登录</title>
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <script src= "${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src= "${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <script>
        // 判断是登录账号和密码是否为空
        function check(){
            var usercode = $("#usercode").val();
            var password = $("#password").val();
            if(usercode=== "" || password=== ""){
                swal("密码不能为空");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div><img class="center-block img-responsive" src="${pageContext.request.contextPath}/images/title.png"></div>
<form action="${pageContext.request.contextPath}/login.action" method="post" onsubmit="return check()">
   <div class="container max-width">
       <div class="input-group">
           <span class="input-group-addon" id="usercode_descri">账号</span>
           <input class="form-control" id="usercode" type="text" name="usercode" aria-describedby="usercode_descri" />
       </div>
       <div class="input-group inter-top">
           <span class="input-group-addon" id="password_descri">密码</span>
           <input class="form-control" id="password" type="password" name="password" aria-describedby="password_descri"/>
       </div>
       <input class="btn btn-default pull-right inter-top" type="submit" value="登录" />
   </div>
</form>
</body>
</html>
