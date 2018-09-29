<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/security/tags"  prefix="security"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="Home">Home</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
   <security:authorize access="hasRole('ROLE_ADMIN')">
    <li class="nav-item">
    
      <a class="nav-link" href="AdminHome">Admin</a>
      
    </li>
    </security:authorize>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Product
      </a>
      <div class="dropdown-menu">
      <c:forEach items="${categoryList}" var="category">
        <a class="dropdown-item" href="getAllProductsBycatgeory/${category.categoryId}">${category.categoryName}</a>
        </c:forEach>
       </div>
    </li>
     
     <security:authorize access="isAnonymous()">
      <li class="nav-item">
        <a class="nav-link" href="login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Sign">SignUp</a>
      </li>    
      </security:authorize>
      <security:authorize access="isAuthenticated()">
       <li class="nav-item">
        <a class="nav-link" href="logout">Logout</a>
      </li>
     </security:authorize> 
      
  </ul>
</nav>

</body>
</html>
