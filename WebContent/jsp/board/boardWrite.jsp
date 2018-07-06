<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>스트럿츠2 게시판</title>
	<link rel="stylesheet" href="../css/board.css" type="text/css" />	
	
	<SCRIPT type="text/javascript">
		function validation() {		
			var frm = document.forms[0];			
			if(frm.subject.value == "") {
				alert("제목을 입력해주세요.");
				return false;
			} 
			else if(frm.writer.value == "") {
				alert("이름을 입력해주세요.");
				return false;
			}
			else if(frm.pwd.value == "") {
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			else if(frm.content.value == "") {
				alert("내용을 입력해주세요.");
				return false;			
			}
			return true;
		}
	</SCRIPT>
</head>

<body>
<center>
<table width="600"  border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td align="center"><h3>스트럿츠2 게시판</h3></td>
	</tr>
</table>

<s:if test="boardVo==null">
	<form action="writeAction.action" method="post" onsubmit="return validation();">
</s:if>
<s:else>
	<form action="modifyAction.action"  method="post" >		
		<s:hidden name="currentPage" value="%{currentPage}" />
		<s:hidden name="seqarg" value="%{seqarg}" />
</s:else>

<table width="600" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="right" colspan="2">
			<font color="#FF0000">*</font>는 필수 입력사항입니다.
		</td>
	</tr>

	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>
	

	<tr>
		<td width="100" bgcolor="#F4F4F4">
			<font color="#FF0000">*</font>  제목
		</td>
		<td width="500" bgcolor="#FFFFFF">
		<s:textfield name="title" theme="simple" maxlength="50" 
			value="%{boardVo.title}"  cssStyle="width:370px"/>
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>

	<tr>
		<td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  이름 </td>
		<td bgcolor="#FFFFFF">
			<s:textfield name="writer" theme="simple" maxlength="20"
			value="%{boardVo.writer}" cssStyle="width:100px" />
		 </td>
	</tr>
	<tr bgcolor="#777777">
			<td height="1" colspan="2"></td>	
	</tr>
 
	<tr>
		<td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  비밀번호 </td>
		<td bgcolor="#FFFFFF">
			<s:password name="pwd" theme="simple" maxlength="20"
			value="%{boardVo.pwd}" cssStyle="width:100px" />
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>	
	</tr>

	<tr>
		<td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  내용 </td>
		<td bgcolor="#FFFFFF">
			<s:textarea name="content" theme="simple" 
			value="%{boardVo.content}" cols="50" rows="10" />
		</td>
	</tr>
    <tr bgcolor="#777777">
      <td height="1" colspan="2"></td>  
    </tr>
  
    <tr>
      <td height="10" colspan="2"></td>
    </tr>

	<tr>
		<td align="right" colspan="2">
			<input name="submit" type="submit" value="작성완료" class="inputb">
			<input name="list" type="button" value="목록" class="inputb" onClick=
"javascript:location.href='listAction.action?currentPage=<s:property value="currentPage" />'">
		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>