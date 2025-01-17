<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>

    <h1>コメント掲示板</h1>
    <form action="comment" method="post" name="form1" onSubmit="return check()">  <!--actionタグ未設定-->
        <p>名前:<br>
        <input type="text" name="name"></p>
        <p>コメント:<br>
           <textarea name="comment" rows="5" cols="40"></textarea>
        </p>
        <p><input type="submit" value="送信"><input type="reset" value="リセット"></p>
    </form>
    
    <h2>投稿されたコメント</h2>
    <c:forEach var="comment" items="${comments}">
        <div style="margin-bottom: 20px; border-bottom: 1px solid #ccc; padding-bottom: 10px;">
            <p>
                <strong>ID:</strong> ${comment.id}
                <strong>名前:</strong> ${comment.name}
                <strong>投稿日時:</strong> ${comment.createdAt}
            </p>
            <p>${comment.comment}</p>
        </div>
      </c:forEach>
        
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