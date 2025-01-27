<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>掲示板</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
   <style>
        body {
            background-color: #f8f9fa;
        }
        
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        
        .comment-card {
            margin-bottom: 20px
        }
        </style>
</head>
<body>

     <div class="container">
         <h1 class="text-center mb-4">コメント掲示板</h1>
         
         
         <!-- 検索フォーム -->
         <form action="comment" method="get" class="mb-4">
             <div class="input-group">
                 <input type="text" name="keyword" class="form-control" placeholder="キーワードを入力" value="${keyword}">
                 <button type="submit" class="btn btn-primary">検索</button>
             </div>
         </form>
         
         <!-- 投稿フォーム -->
         <form action="comment" method="post" name="form1" onsubmit="return check()">
             <div class="mb-3">
                  <label for="name" class="form-label">名前：</label>
                  <input type="text" id="name" name="name" class="form-control" placeholder="名前を入力してください">
             </div>
             <div class="mb-3">
                  <label for="comment" class="form-label">コメント:</label>
                  <textarea id="comment" name="comment" class="form-control" rows="5" placeholder="コメントを入力してください"></textarea>
             </div>
              <div class="d-flex justify-content-between">
                  <button type="submit" class="btn btn-primary">送信</button>
                  <button type="reset" class="btn btn-secondary">リセット</button>
            </div
         
         
     <div class="container my-5">
         <hr class="my-4">
         
         <!-- 投稿一覧 -->
         <c:if test="${not empty param.keyword}">
             <h2 class="text-center mb-4">"${param.keyword}"の検索結果</h2>
             <c:if test="${empty comments}">
                  <p class="text-center text-muted">一致するコメントはありません。</p>
             </c:if>
         </c:if>
         <c:if test="${empty param.keyword}">
             <h2 class="text-center mb-4">投稿されたコメント</h2>
         </c:if>
         
         <c:forEach var="comment" items="${comments}">
            <div class="card comment-card">
                <div class="card-body">
                    <p class="mb-1">
                        <strong>ID:</strong> ${comment.id} <br>
                        <strong>名前:</strong> ${comment.name} <br>
                        <strong>投稿日時:</strong> 
                        <fmt:formatDate value="${comment.createdAt}" pattern="yyyy/MM/dd HH:mm:ss" />
                    </p>
                    <p class="mt-2">${comment.comment}</p>
                </div>
            </div>   
        </c:forEach>
     
     
        <!-- ページネーション -->
        <nav>
           <ul class="pagination justify-content-center">
               <c:forEach begin="1" end="${totalPages}" var="i">
                 <li class="page-item ${i == currentPage ? 'active' : ''}">
                   <a class="page-link" href="comment?page=${i}&keyword=${param.keyword}">${i}</a>
                 </li>
               </c:forEach>
           </ul>
        </nav>
     </div>
     </div>
     
    <script src="bootstrap/bootstrap.bundle.min.js"></script>
    <script>
        function check() {
            let flag = 0; // フラグ変数(エラーチェック)

            if(document.form1.name.value =="") {
                flag = 1;
            }
            else if(document.form1.comment.value =="") {
                flag = 1;
            }
            if (flag) {
                window.alert('名前とコメントを入力してください');
                return false; // フォーム送信を中止
            }
            else {
                return true;
            }
        }
    </script>
</body>
</html>