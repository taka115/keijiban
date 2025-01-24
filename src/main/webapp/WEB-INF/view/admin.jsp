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
     margin-bottom: 20px; /* 各コメントの間に余白を追加 */
     padding: 10px; /* 内側の余白を設定 */
     border-bottom: 1px solid #ccc; /* コメントと次のコメントの間に薄いボーダーを表示 */
     display: flex; /* フレックスボックスを使用して、要素を横並びにする */
}

/* コメントの詳細部分のスタイル */
.comment-details {
    flex: 1; /* コメントの詳細部分が利用可能なスペースを全て使う */
    margin-right: 20px; /* ボタンとの間にスペースを追加 */
}

/* コメントの内容部分のスタイル */
.comment-content {
    margin-top: 5px; /* コメントとその内容の間に少しスペースを追加 */
}

/* 削除ボタンのスタイル */
.delete-btn {
    background-color: #FFA500; /* ボタンの背景色をオレンジ色に設定 */
    color: white; /* ボタンの文字色を白に設定 */
    padding: 10px 15px; /* ボタンの内側の余白（縦10px、横15px）を設定 */
    text-decoration: none; /* リンクの下線を削除 */
    border-radius: 3px; /* ボタンの角を丸くする */
    align-items: center; /* ボタン内のテキストを縦方向で中央に配置 */
    text-align: center; /* ボタン内のテキストを横方向で中央に配置 */
}

/* ログアウトボタンのスタイル */
.logout-btn {
    text-decoration: none; /* リンクの下線を削除 */
    color: white; /* ボタンの文字色を白に設定 */
    background-color: #ADD8E6; /* ボタンの背景色を薄い青に設定 */
    padding: 10px 20px; /* ボタンの内側の余白（縦10px、横20px）を設定 */
    border-radius: 5px; /* ボタンの角を丸くする */
    display: inline-block; /* ボタンをインラインブロック要素に設定（リンクとブロックの中間） */
    font-size: 16px; /* ボタンの文字サイズを設定 */
    border: 1px solid #87CEEB; /* ボタンに薄い青のボーダーを追加 */
}

/* ログアウトボタンにホバー時の効果 */
.logout-btn:hover {
    background-color: #87CEEB; /* マウスホバー時にボタンの背景色を少し濃い青に変更 */
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