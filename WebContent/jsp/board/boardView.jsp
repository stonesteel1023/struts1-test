<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>스트럿츠2 게시판</title>
  <link rel="stylesheet" href="../css/board.css" type="text/css" />  
  <SCRIPT type="text/javascript">
    function open_win_noresizable (url, name) {
      var oWin = window.open(url, name, 
      "scrollbars=no,status=no,resizable=no,width=300,height=100");
    }
  </SCRIPT>
</head>
  
<body>
  <center>
  <table width="600" border="0" cellspacing="0" cellpadding="2">
    <tr>
      <td align="center"><h3>스트럿츠2 게시판</h3></td>
    </tr>
    <tr>
      <td height="20"></td>
    </tr>
  </table>
  
  <table width="600" border="0" cellspacing="0" cellpadding="0">
    
    <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>
    </tr>
    
    <tr>
      <td bgcolor="#F4F4F4">  번호 </td>
      <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="seqarg" />
      </td>
    </tr>
    <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>  
    </tr>
      
    <tr>
      <td width="100" bgcolor="#F4F4F4">  제목</td>
      <td width="500" bgcolor="#FFFFFF">
        &nbsp;&nbsp;<s:property value="boardVo.title" />
      </td>
    </tr>
                    
    <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>
    </tr>
      
    <tr>
      <td bgcolor="#F4F4F4">  글쓴이 </td>
      <td bgcolor="#FFFFFF">
        &nbsp;&nbsp;<s:property value="boardVo.writer" />
      </td>
    </tr>
    <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>  
    </tr>
      
    <tr>
      <td bgcolor="#F4F4F4">  내용 </td>
      <td bgcolor="#FFFFFF">
        &nbsp;&nbsp;<s:property value="boardVo.content" />
      </td>
    </tr>
    <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>
    </tr>
      
    <tr>
      <td bgcolor="#F4F4F4">  조회수 </td>
      <td bgcolor="#FFFFFF">
        &nbsp;&nbsp;<s:property value="boardVo.hit" />
      </td>
    </tr>
    <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>  
    </tr>
     
    <tr>
      <td bgcolor="#F4F4F4">  등록날짜 </td>
      <td bgcolor="#FFFFFF">
        &nbsp;&nbsp;<s:property value="boardVo.regdate" />
      </td>
    </tr>
      
    <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>  
    </tr>
      
   <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>  
    </tr>
      
    <tr>
      <td height="10" colspan="2"></td>
    </tr>
      
    <tr>
      <td align="right" colspan="2">
        
        <s:url id="modifyURL" action="modifyForm" >
          <s:param name="seq">
            <s:property value="seqarg" />
          </s:param>
        </s:url>
          
        <s:url id="deleteURL" action="deleteAction" >
          <s:param name="seq">
            <s:property value="seqarg" />
          </s:param>
        </s:url>
      
        <input name="list" type="button" value="수정" class="inputb" 
         onClick="javascript:open_win_noresizable('checkFormAction.action?seqarg=<s:property value="seqarg" />&currentPage=<s:property value="currentPage" />','modify')">
          
        <input name="list" type="button" value="삭제" class="inputb" 
         onClick="javascript:open_win_noresizable('checkFormAction.action?seqarg=<s:property value="seqarg" />&currentPage=<s:property value="currentPage" />','delete')">

        <input name="list" type="button" value="목록" class="inputb" 
          onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage" />'">

      </td>
    </tr>
</table>
</center> 
</body>
</html>