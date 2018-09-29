<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@include file="Header.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
body{
background-repeat:no-repeat; 
background-position:center; 
background-size:cover; 
}

.form-heading { color:#fff; font-size:23px;}
.panel h2{ color:#444444; font-size:18px; margin:0 0 8px 0;}
.panel p { color:#777777; font-size:14px; margin-bottom:30px; line-height:24px;}
.login-form .form-control {
  background: #f7f7f7 none repeat scroll 0 0;
  border: 1px solid #d4d4d4;
  border-radius: 4px;
  font-size: 14px;
  height: 50px;
  line-height: 50px;
}
.main-div {
  background: #ffffff none repeat scroll 0 0;
  border-radius: 2px;
  margin: 10px auto 30px;
  max-width: 38%;
  padding: 50px 70px 70px 71px;
}

.login-form .form-group {
  margin-bottom:10px;
}
.login-form{ text-align:center;}
.forgot a {
  color: #777777;
  font-size: 14px;
  text-decoration: underline;
}

.login-form  .btn.btn-primary {
  background-color:#E74E2C;
    border: none;
    color: white;
    padding: 8px 12px;
    text-align: left;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 8px;
    cursor: pointer;
  
}
.forgot {
  text-align: left; margin-bottom:30px;
}
.botto-text {
  color: #ffffff;
  font-size: 14px;
  margin: auto;
}
.login-form .btn.btn-primary.reset {
  background: #ff9900 none repeat scroll 0 0;
}
.back { text-align: left; margin-top:10px;}
.back a {color: #444444; font-size: 13px;text-decoration: none;}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body id="LoginForm" background="C:\Users\MOHIT\Desktop\Project Work\frontend\src\main\webapp\resources\Images\5.jpg">
<div class="container">
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <h2>SignUp</h2>
   <p>Please Enter Your Details</p>
   
  <spring:form  id="SignUp" action="${pageContext.request.contextPath}/addCustomer" modelAttribute="customer" method="post" class="login-form">

        
        <div class="form-group">


            <spring:input name="name" type="text" class="form-control" id="Name" placeholder="UserName" path="name"/>

        </div>
        
        
        <div class="form-group">


            <spring:input name="emailId" type="email" class="form-control" id="inputEmail" placeholder="Email Address" path="emailId"/>

        </div>

        <div class="form-group">

            <spring:input name="password" type="password" class="form-control" id="inputPassword" placeholder="Password" path="password"/>

        </div>
        <div class="form-group">

            <spring:input name="mob" type="number" class="form-control" id="Mobile" placeholder="Mobile" path="mob" style="float:right;"/>

        </div>
        
        <div class="forgot">
        <a href="reset.html">Forgot password?</a>
</div>
  		<button type="submit" class="btn btn-primary" >SignUp</button>
        
          
    </spring:form>
    <div class="form-group">
     
     </div>
   </div>
   </div>
   </div>
   </div>


	

</body>
</html>