<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>비밀번호 확인</title>
  <link rel="stylesheet" href="../css/board.css" type="text/css">	
  <SCRIPT type="text/javascript">
    function locationURL() {
    
      if ( window.name == 'modify' ) 
        window.opener.parent.location.href=
          'modifyFormAction.action?seqarg=<s:property value="seqarg" />&currentPage=<s:property value="currentPage" />';
        
      else if ( window.name == 'delete' ) 
      {
        alert('삭제되었습니다.');
        window.opener.parent.location.href=
          'deleteAction.action?seq=<s:property value="seqarg" />&currentPage=<s:property value="currentPage" />';
      }
      
      window.close();
    }
  </SCRIPT>
</head>
  
<body>
    <script>locationURL()</script>
</body>
</html>
