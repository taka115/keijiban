<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ページ</title>
   <style>
      .comment-container {
          margin-bottom: 20px;
          padding: 10px;
          border-bottom: 1px solid #ccc;
          display: flex;
          justify-content: space-between;
          align-items: flex-start;
     }
      .comment-details {
          flex: 1;
          margin-right: 20px; /* ボタンとコメントの間にスペースを追加 */
     }
      .comment-content {
          margin-top: 5px;
     }
      .delete-btn {
          background-color: #FFA500;
          color: white;
          padding: 10px 15px;
          text-decoration: none;
          border-radius: 3px;
          width: 80px;  /* ボタンの幅を固定 */
          height: 40px;  /* ボタンの高さを固定 */
          display: inline-flex;  /* インラインでflexboxを使用 */
          align-items: center;  /* ボタン内のテキストを中央に配置 */
          justify-content: center;  /* テキストを中央揃え */
          text-align: center;
     }
      .logout-btn {
          text-decoration: none;
          color: white;
          background-color: #ADD8E6; /* 薄い青色 */
          padding: 10px 20px;
          border-radius: 5px;
          display: inline-block;
          font-size: 16px;
          border: 1px solid #87CEEB; /* 薄い青のボーダー */
    }
     .logout-btn:hover {
        background-color: #87CEEB; /* マウスホバー時に少し濃い色に */
    }
</style>
     
</head>
<body>
    <h1>投稿されたコメント</h1>
    <p><a href="logout" class="logout-btn">ログアウト</a></p>
      <c:forEach var="comment" items="${comments}">
        <div class="comment-container">
            <div class="comment-details">
                <span><strong>ID:</strong> ${comment.id} </span>
                <span><strong>名前:</strong> ${comment.name} </span>
                <span><strong>タイムスタンプ:</strong> <fmt:formatDate value="${comment.createdAt}" pattern="yyyy/MM/dd HH:mm:ss" /></span>
                <div class="comment-content">
                    <strong>コメント:</strong> ${comment.comment}
                </div>
            </div>
            <form action="admin" method="get" style="display: inline;">
               <input type="hidden" name="id" value="${comment.id}">
               <input type="submit" value="削除" class="delete-btn">
            </form>
            
        </div>
    </c:forEach>
</body>
</html>