<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>ログアウト</title>
   <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark">

<div class="d-flex justify-content-center align-items-center min-vh-100">
    <div class="card p-4 shadow text-white" style="width: 100%; max-width: 400px;">
        <h1 class="text-primary mb-3">ログアウト</h1>
        <p class="text-muted mb-4">ログアウトしました。</p>
        <a href="login" class="btn btn-primary w-100">ログイン画面に戻る</a>
    </div>
</div>

<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>