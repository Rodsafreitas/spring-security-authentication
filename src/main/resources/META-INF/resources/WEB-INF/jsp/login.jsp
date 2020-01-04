<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="stylesheet" type="text/css" th:href="@{/webjars/bootstrap/3.3.7/css/bootstrap.min.css}" />

    <title>Registration</title>
</head>
<body>
       <h1>Login</h1>
     <form method="post" action="/doLogin">

                            <label for="username">Username</label>: <input type="text" id="username" name="username" class="form-control" autofocus="autofocus" placeholder="Username" />

                            <label for="password">Password</label>: <input type="password" id="password" name="password" class="form-control" placeholder="Password" />

                                    <input type="submit" name="login-submit" id="login-submit" class="form-control btn btn-primary" value="Log In" />
  </form>
</body>
</html>