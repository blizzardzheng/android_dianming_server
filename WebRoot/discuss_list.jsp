<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
<%@ include file="/commons/taglibs.jsp"%>
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>
</head>

<body class="mainbody">

    
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">��������</span></td>
              </tr>
            </table></td>
            <td><div align="right">
            <span class="STYLE1">  
                 &nbsp;&nbsp;  &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">
          		��� 
        </div></td>
        <td width="16%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"> ��¼�� </span></div></td>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"> ѧ������ </span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"> ����ʱ�� </span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">����</span></div></td>
      </tr>
    
			<c:forEach var="item" items="${list}" varStatus="idx"  >  
			
		      <tr>
		        <td height="20" bgcolor="#FFFFFF">
		        	<div align="center"> ${idx.index+1} </div>
		        </td>
		        
	
		        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21"> ${item.answer} </div></td>	
		        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"> ${item.content}  </div></td>
		        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"> ${item.tbl_date}  </div></td>
				
		        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">  
                  <a href="discuss.do?method=del&id=${item.id}" >ɾ��</a>  
                   </div>
		         </td>
		      </tr>
	 
    	 	</c:forEach>	
	 
    </table></td>
  </tr>
</table>
 

</body>

</html>