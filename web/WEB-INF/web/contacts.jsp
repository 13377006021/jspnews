<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","zxly")}
${pageContext.setAttribute("type","contacts")}
<%@ include file="header.jsp"%>
<!--内容区块-->
<div id="main">

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <form action="" method="post" >
            <tr>
                <td width="20%" height="50" align="right">您的姓名：</td>
                <td width="30%" align="left"><input type="text" name="username" size="20"  title="姓名" style="border:1px solid #ccc; height:20px; line-height:20px;"/>
                    <font color="#cc0000">*</font></td>
                <td width="20%" align="right">E-mail：</td>
                <td width="30%" align="left"><input name="email" type="text" id="email" title="email" size="20" style="border:1px solid #ccc; height:20px; line-height:20px;" /><font color="#cc0000">*</font></td></td>
            </tr>
            <tr>
                <td height="50" align="right">联系电话：</td>
                <td align="left"><input type="text" name="phone" size="20" title="联系电话" style="border:1px solid #ccc; height:20px; line-height:20px;"/>
                    <font color="#cc0000">*</font></td>
                <td align="right">QQ/MSN：</td>
                <td align="left"><input name="qq" type="text" id="qq" title="qq" onKeyPress="event.returnValue=IsDigit();" size="20" style="border:1px solid #ccc; height:20px; line-height:20px;" /><font color="#cc0000">*</font></td></td>
            </tr>
            <tr>
                <td height="50"><div align="right">留言主题：</div></td>
                <td colspan="3" align="left"><input type="text" name="title" size="42" title="主题" style="border:1px solid #ccc; height:20px; line-height:20px;"/>
                    <font color="#cc0000">*</font></td>
            </tr>
            <tr>
                <td height="50" align="right">留言內容：</td>
                <td colspan="3" align="left"><textarea name="content" cols="70" rows="5" wrap="virtual" title="详细信息"  style="border:1px solid #ccc;"></textarea><font color="#cc0000">*</font></td>
                </td>

            </tr>
            <tr>
                <td height="50"> </td>
                <td colspan="3" align="left">
                    <input type="submit" value="确定提交"  class="btn_sub contacts_btn"/> <input type="reset" value="重新填写" name="reset" class="buttom"/>
                </td>
            </tr>
        </form>
    </table>
</div>

<%@ include file="footer.jsp"%>