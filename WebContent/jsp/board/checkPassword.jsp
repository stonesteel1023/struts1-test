<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>비밀번호 확인</title>
    <link rel="stylesheet" href="../css/board.css" type="text/css" />	
  </head>
  
  <body>
    <center>
    <h2>비밀번호 확인</h2>
    
    <form action="checkAction.action" method="post">
    <s:hidden name="seqarg" value="%{seqarg}" />
    <s:hidden name="currentPage" value="%{currentPage}" />
      
      <table width="250" border="0" cellspacing="0" cellpadding="0">
      
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>
        </tr>
      
        <tr>
          <td width="100" bgcolor="#F4F4F4">  비밀번호 입력</td>
          <td width="150" bgcolor="#FFFFFF">
            &nbsp;&nbsp;<s:password name="pwdarg" theme="simple" cssStyle="width:100px" maxlength="20"/>
            &nbsp;&nbsp;<input name="submit" type="submit" value="확인" class="inputb">
          </td>
        </tr>
      
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>
        </tr>
      </table>
    </form>
    </center>
  </body>
</html>
