<%-- 
    Document   : mainpage
    Created on : 2015-11-24, 20:18:47
    Author     : Crystal
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" media="screen and (min-width: 600px)" href="css/laptop.css"/>
        <link rel="stylesheet" type="text/css" media="screen and (max-width: 600px)" href="css/mobile.css"/>
        <title>Social Network for Sport</title>
    </head>
    <body>
        <div class="wrapped">
            <div class="header">
                <div class="logo">
                    SPORT
                </div>
                <div class="searchbox">
                    <form id="form" name="form" method="post" action="SearchServlet">
                        <input type="text" name="Search" size="30vw" maxlength="50" id="Search">
                        <input type="image" src="image/searchbutton.png" style="width: 10%; height: 10%;" onClick=document.form.submit();>
                    </form>
                </div>
                <div class="loginbutton">
                    <a href="login.jsp">log in</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="register.jsp">register</a>
                </div>
            </div>
            <div class="main">
                <div class="register">
                    <div class="text">
                        <font style="font-weight: bold; font-size: 3vw;"class="add">User Register</font>
                        <br/>
                        <br/>
                        <%
                            request.setCharacterEncoding("UTF-8");
                            List<String> info = (List<String>)request.getAttribute("info");
                            if(info != null){
                                Iterator<String> iter = info.iterator();
                                while(iter.hasNext()){
                                    out.println(iter.next());
                                }
                            }
                        %>
                        <form method="post" name="formRegister" onSubmit="return validateRegister();" action="RegisterServlet">
                            <div class="ruserinfo">
                                <table>
                                    <tr>
                                        <td>
                                            Name£º
                                        </td>
                                        <td>
                                            <input type="text" name="txtName" maxlength="50" id="txtName">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Email£º
                                        </td>
                                        <td>
                                            <input type="text" name="txtEmail" maxlength="20" id="txtEmail">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Password£º
                                        </td>
                                        <td>
                                            <input type="password" name="txtPassword" maxlength="20" id="txtPassword">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Interests£º
                                        </td>
                                        <td>
                                            <div class="interests"><input name="love" type="checkbox" id="aa" value="basketball" />basketball<input name="love" type="checkbox" id="aa" value="baseball" />baseball</div>
                                            <div class="interests"><input name="love" type="checkbox" id="aa" value="swimming" />swimming<input name="love" type="checkbox" id="aa" value="football" />football</div>
                                            <div class="interests"><input name="love" type="checkbox" id="aa" value="jogging" />jogging &nbsp;&nbsp;&nbsp;<input name="love" type="checkbox" id="aa" value="soccer" />soccer</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Age£º
                                        </td>
                                        <td>
                                            <select name="select" id="selectAge" class="interests">
                                                <option value="0-10">0-10</option>
                                                <option value="10-20">10-20</option>
                                                <option value="20-30">20-30</option>
                                                <option value="30-40">30-40</option>
                                                <option value="40-50">40-50</option>
                                                <option value="50-60">50-60</option>
                                                <option value="60 above">older than 60</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Phone£º
                                        </td>
                                        <td>
                                            <input type="text" name="txtPhone" maxlength="20" id="txtPhone">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <input type="submit" name="Submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="reset" name="Reset" value="Reset">
                                        </td> 
                                    </tr>
                                </table>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="items">
                    <div class="icon"><a href="${pageContext.request.contextPath}/EventsServlet?id=basketball"><img src="image/basketball.png" style="width: 100%; height: 100%" alt="failed" border=0 /></a></div>
                    <div class="icon"><a href="${pageContext.request.contextPath}/EventsServlet?id=baseball"><img src="image/baseball.png" style="width: 100%; height: 100%" alt="failed" border=0 /></a></div>
                    <div class="icon"><a href="${pageContext.request.contextPath}/EventsServlet?id=swimming"><img src="image/swimming.png" style="width: 100%; height: 100%" alt="failed" border=0 /></a></div>
                    <div class="icon"><a href="${pageContext.request.contextPath}/EventsServlet?id=football"><img src="image/football.png" style="width: 100%; height: 100%" alt="failed" border=0 /></a></div>
                    <div class="icon"><a href="${pageContext.request.contextPath}/EventsServlet?id=jogging"><img src="image/jogging.png" style="width: 100%; height: 100%" alt="failed" border=0 /></a></div>
                    <div class="icon"><a href="${pageContext.request.contextPath}/EventsServlet?id=soccer"><img src="image/soccer.png" style="width: 100%; height: 100%" alt="failed" border=0 /></a></div>
                </div>
            </div>
            <div class="footer">
                copyright ? School of Information Sciences, University of Pittsburgh
                <br/>
                contact us: YUW75@pitt.edu/YUY54@pitt.edu
            </div>
        </div>
        <!-- javaScript function validateRegister(),check username,password and email -->
        <script language="javaScript">
            function validateRegister() {
                var UserName = document.formRegister.txtName.value;
                var Password = document.formRegister.txtPassword.value;
                var Email = document.formRegister.txtEmail.value;
                var interests = document.getElementsByName('love');
                var phone = document.formRegister.txtPhone.value;
                var isSelect = false;
                if (UserName === "") {
                    alert("Please enter your name£¡");
                    return false;
                }
                if (Email === "") {
                    alert("Please enter your email!");
                    return false;
                }
                if (Password === "") {
                    alert("Please enter password!");
                    return false;
                }
                if (Password.length < 6) {
                    alert("Password could not be less than 6 characters!");
                    document.formRegister.txtPassword.focus();
                    return false;
                }
                var patrn = /^(\w)+([-+.]\w+)*@\w+([-.]\w+)*\..\w+([-.]\w+)*$/;
                if (!patrn.exec(Email)) {
                    alert("Wrong format of email address!");
                    return false;
                }
                var patrn1 = /\d{3}-\d{3}-?\d{4}|\d{10}|\(\d{3}\)\d{3}-\d{4}/;
                if (!patrn1.exec(phone)) {
                    alert("Wrong format of phone number!");
                    return false;
                }
                for (var i = 0; i < interests.length; i++)
                {
                    if (interests[i].checked === true)
                    {
                        isSelect = true;
                        break;
                    }
                }
                if (isSelect === false)
                {
                    alert("Please choose at least one interest£¡");
                    return false;
                }
                else {
                    return true;
                }
            }
        </script>
    </body>
</html>
