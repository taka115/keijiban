<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
     <title>ログイン</title>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

 <div class="d-flex justify-content-center align-items-center min-vh-100">
     <div class="card p-4 shadow" style="width: 100%; max-width: 400px;">
           <h1 class="text-center mb-4">管理者用ログイン</h1>

           <c:if test="${not empty error}">
               <div class="alert alert-danger text-center" role="alert">
                   ログインIDかパスワードが正しくありません。
               </div>
           </c:if>
           
           <form action="login"  method="post">
               <div class="mb-3">
                   <label for="loginId" class="form-label">ログインID</label>
                   <input type="text" class="form-control" id="loginId" name="loginId" required>
               </div>
               <div class="mb-3">
                   <label for="loginPass" class="form-label">パスワード</label>
                   <input type="password" class="form-control" id="loginPass" name="loginPass" required>
               </div>
               <button type="submit" class="btn btn-primary w-100">送信</button>
           </form>
     </div>
 </div>
 
<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>