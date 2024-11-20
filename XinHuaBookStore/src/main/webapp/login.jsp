<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register/login</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all">
    <link href="https://fonts.googleapis.com/css?family=Mukta:300,400,500" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
    <section class="main">
        <div class="bottom-grid">
            <div class="logo">
                <h1> <a href="login.jsp"> Workspace Sign In Form</a></h1>
            </div>
        </div>
        <!-- login -->
        <div class="w3lhny-register">
            <div class="iconhny">
               <span class="fa fa-user-plus"></span>
             </div>
                <fieldset>
                    <div class="form">
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" placeholder="Account" id="userAccount" required="" />
                        </div>
                        <div class="form-row">
                            <span class="fa fa-lock"></span>
                            
                            <input type="password" class="form-text" placeholder="Password" id="userPass" required="" />
                        </div>
                        <div class="form-row button-login">
                            <button class="btn btn-login" id="login">Sign In</button>
                        </div>
                        <div class="form-row button-login">
                            <button class="btn btn-login" id="adminLogin">Admin Sign In</button>
                        </div>
                    </div>
                </fieldset>

                <span class="create-account">Or Continue With!</span>

                <div class="social-media">
                    <a href="#facebook" class="fb"><span class="fa fa-facebook"></span></a>
                    <a href="#twitter" class="tw"><span class="fa fa-twitter"></span></a>
                    <a href="#pinterest" class="pi"><span class="fa fa-pinterest"></span></a>
                </div>
                <p class="already">No Account Yet <a href="regist.jsp">Sign Up</a></p>
        </div>
    </section>
</body>
</html>