<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>管理者用ログイン</h1>
<form action="" method="post" name="admin"><!--action-->
    <p>ログインID <input type="password" name="login"></p>
    <p>パスワード <input type="password" name="password"></p>
    <input type="submit" value="送信">
</form>
</body>
</html>