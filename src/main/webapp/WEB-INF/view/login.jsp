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

<c:if test="${not empty error}">
<p>ログインIDかパスワードが正しくありません。</p>
</c:if>
<form action="login"  method="post"><!--action-->
    <p>ログインID <input type="text" name="loginId"></p>
    <p>パスワード <input type="password" name="loginPass"></p>
    <input type="submit" value="送信">
</form>
</body>
</html>