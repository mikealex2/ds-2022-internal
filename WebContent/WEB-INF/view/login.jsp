<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300i,400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
    <title>Sign in</title>
    <style>
    *{
        text-align: center;
    }
    body {
        font-family: "Nunito Sans";
    }
    h3 {
        padding-left: 30px;
        padding-right: 20px;
        font-weight: 700;
    }
    label {
        padding-top: 4px;
        padding-left: 4px;
    }
    .bg-color:hover label {
        color: #31a1f2;
    }
    .btn-custom {
        background-color: #31a1f2;
    }
</style>
</head>
<body>
  <div class="container">
      <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6 p-0 pt-3">
              <br><br><br>
              <h1 >Sign in</h1><br>
              <form:form class="login-form" action="${pageContext.request.contextPath}/authUser" method="POST">
                  <label>Username</label><br>
                  <input type="text" name="username" required><br><br>
                  <label>Password</label><br>
                  <input type="password" name="password" required><br><br>
                  <input type="submit" class="btn btn-custom" value="Sign in">
                  <div class="text-center pt-3 pb-3">
                  </div>
                  <div class="text-center pt-3 pb-3">
                      <c:if test="${param.error!=null}">
                          <h4>Invalid username or password!</h4>
                      </c:if>
                  </div>
              </form:form>
           </div>
          <div class="col-md-3"></div>
      </div>
  </div>
</body>
</html>