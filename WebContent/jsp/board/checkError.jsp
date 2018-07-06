<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>비밀번호 오류</title>
  <link rel="stylesheet" href="/board/common/css/css.css" type="text/css">
  <script type="text/javascript">
    function ErrorMessage() {
      alert("비밀번호가 틀립니다.");
      history.back(-1);
    }
  </script>
</head>
  
  <body>
    <script>ErrorMessage()</script>
  </body>
</html>