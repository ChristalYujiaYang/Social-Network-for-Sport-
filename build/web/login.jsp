<%-- 
    Document   : mainpage
    Created on : 2015-11-24, 20:18:47
    Author     : Crystal
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div class="login">
                    <div class="text">
                        <font style="font-weight: bold; font-size: 3vw;"class="add">User Login</font>
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
                        <form method="post" name="formLogin" runat="server" onSubmit="return validateLogin();" action="LoginServlet">
                            <br/>
                            <div class="luserinfo">
                                <table>
                                    <tr>
                                        <td>
                                            Email：
                                        </td>
                                        <td>
                                            <input type="text" name="txtEmail" maxlength="50" id="txtEmail">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Password：
                                        </td>
                                        <td>
                                            <input type="password" name="txtPassword" maxlength="20" id="txtPassword">
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
                copyright © School of Information Sciences, University of Pittsburgh
                <br/>
                contact us: YUW75@pitt.edu/YUY54@pitt.edu
            </div>
        </div>
        <!-- javaScript function validateLogin(),check if username and password is null -->
        <script language="javaScript">
            function validateLogin()
            {
                var UserName = document.formLogin.txtEmail.value;
                var Password = document.formLogin.txtPassword.value;
                if (UserName === "")
                {
                    alert("Please enter email！");
                    return false;
                }
                if (Password === "")
                {
                    alert("Please enter password！");
                    return false;
                }
                else
                {
                    return true;
                }
            }
        </script>
    </body>
</html>
