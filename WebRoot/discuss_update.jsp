<%@ page language="java" pageEncoding="utf-8" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="scripts/validator.js"></script>
<script language="javascript" type="text/javascript" src="scripts/datepicker/WdatePicker.js"></script> 
<title> 管理 </title>

</head>

<BODY style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg.gif); BACKGROUND-REPEAT: repeat-x">

	<c:if test="${(not empty s) && (s == 0 )}" >
		<script> 
			alert('保存成功！') ;
		</script>
	</c:if> 
<DIV> 

  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR   style="BACKGROUND-IMAGE: url(images/bg_header.gif); BACKGROUND-REPEAT: repeat-x"  height=47>
        <TD width=10><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN 
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; 
      COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">  管理 </SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD 
    style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(images/main_rc.gif)" 
    width=10></TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align=middle>
          <DIV>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=0>
              <TBODY>
              		<tr>
              			<td>
              			<form  name="form1" id="form1" action="discuss.do?method=update" method="post"  >
							 <table width="95%" border="0">    
										<tr>
									        <td  > 内容  </td>
									        <td  > 
									        <input name="id" type="hidden"   value="${map.id}"	/>
									        <input name="news_id" type="hidden"   value="${map.news_id}"	/>
									        <input name="t" type="hidden"   value="1"	/>
									        ${map.content}
											</td>
									    </tr>  	
										 		
										 <tr>
									        <td  >  评论时间   </td>
									        <td  >	
									        ${map.tbl_date} 
									        </td>
									    </tr>
										<tr>
									        <td  >  回复 </td>
									        <td  >  
									        <textarea name="answer" rows="8" cols="40"  >${map.answer}</textarea>
											</td>
									    </tr>  
									    <tr>
									        <td  > <br/> </td>
									        <td  > <br/> </td>
									    </tr>  
									  	<tr>
											<td colspan="2"> 
												<input  type="button" value="确定"  onclick="doSubmit()" />  
											</td>
										</tr>		     
								</table>	
							</form> 
              			</td>
              		</tr>	
              </TBODY>
            </TABLE>
          </DIV>
        </TD>
        <TD style="BACKGROUND-IMAGE: url(images/main_rs.gif)"></TD>
      </TR>
      <TR   style="BACKGROUND-IMAGE: url(images/main_fs.gif); BACKGROUND-REPEAT: repeat-x"   height=10>
	        <TD style="BACKGROUND-IMAGE: url(images/main_lf.gif)"></TD>
	        <TD style="BACKGROUND-IMAGE: url(images/main_fs.gif)"></TD>
	        <TD style="BACKGROUND-IMAGE: url(images/main_rf.gif)"></TD>
      </TR>
    </TBODY>
  </TABLE>
   
  
</DIV> 
 
<script type="text/javascript"> 

 function doSubmit()  {
	 if(!Validator.Validate(form1,1))
			return;
	 form1.submit();
 }
  
</script>
  
			
</body>
</html>

