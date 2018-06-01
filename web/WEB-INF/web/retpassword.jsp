<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","找回密码")}
${pageContext.setAttribute("type","retpswd")}
<%@ include file="header.jsp"%>
<%@ include file="isLogin.jsp"%>

<!--内容区域-->
<div id="main">
    <div class="box">
        <div class="box_lo_reg">
            <div class="zc">
                <div class="bj_bai">
                    <h3>找回密码</h3>
                    <form action="" method="post">
                        <input name="email" type="email" class="kuang_txt email" placeholder="邮箱">
                        <img src="/CheckImg.do" alt="验证码" width="270px" height="60px" style="margin-bottom: 5px;
                            cursor: pointer" title="验证码" id="checkImg"/>
                        <input name="verCode" type="text" class="kuang_txt yanzm" placeholder="验证码">
                        <div style="height: 10px"></div>
                        <input type="submit" class="btn_sub retPassword_btn" value="发送验证码">

                    </form>
                    <div id="zh_yzm" class="zh_yzm">
                            <input name="yzm" type="text" class="kuang_txt yzm" placeholder="验证码">
                            <input type="submit" class="btn_sub tj_yzm" value="验证">
                    </div>
                </div>
                <div class="bj_right">
                    <p>使用以下账号直接登录</p>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_qq">QQ注册</a>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_wb">微博注册</a>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_wx">微信注册</a>
                    <p>想起密码？<a href="login.html">立即登录</a></p>
                </div>
            </div>
        </div>

    </div>
</div>

<div id="dialogBg"></div>
<div id="dialog" class="animated">
    <img class="dialogIco" width="50" height="50" src="app/images/ico.png" alt="" />
    <div class="dialogTop">
        <a href="javascript:;" class="claseDialogBtn">关闭</a>
    </div>
    <form action="" method="post">
        <ul class="editInfos">
            <li><label><font color="#ff0000">* </font>密码：<input type="password" name="new_password" required value="" class="ipt" /></label></li>
            <li><label><font color="#ff0000">* </font>重输：<input type="password" name="new_password_2" required value="" class="ipt" /></label></li>
            <li><input type="submit" value="确认更新" class="submit_Btn" /></li>
        </ul>
    </form>
</div>


<%@ include file="footer.jsp"%>
