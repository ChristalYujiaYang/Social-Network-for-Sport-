<%-- 
    Document   : modify
    Created on : 2015-12-1, 13:42:58
    Author     : Crystal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css"href="css/modify.css"/>
        <title>Modify</title>
    </head>
    <body>
        <div class="modify">
            <div class="title">
                Modify information
            </div>
            <form id="formmodify" name="formmodify" method="post" action="ModifyServlet" onsubmit="return validateModify();">
                <div class="ruserinfo">
                    <table>
                        <tr>
                            <td>
                                Name：
                            </td>
                            <td>
                                <input type="text" name="txtName" maxlength="50" id="txtName">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Email：
                            </td>
                            <td>
                                <input type="text" name="txtEmail" maxlength="20" id="txtEmail">
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
                            <td>
                                Interests：
                            </td>
                            <td>
                                <div class="interests"><input name="love" type="checkbox" id="aa" value="basketball" />basketball<input name="love" type="checkbox" id="aa" value="baseball" />baseball</div>
                                <div class="interests"><input name="love" type="checkbox" id="aa" value="swimming" />swimming<input name="love" type="checkbox" id="aa" value="football" />football</div>
                                <div class="interests"><input name="love" type="checkbox" id="aa" value="jogging" />jogging &nbsp;&nbsp;&nbsp;<input name="love" type="checkbox" id="aa" value="soccer" />soccer</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Age：
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
                                Phone：
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
        <!-- javaScript function validateModify(),check title,keywords and class -->
        <script language="javaScript">
            function validateModify() {
                var UserName = document.formRegister.txtName.value;
                var Password = document.formRegister.txtPassword.value;
                var Email = document.formRegister.txtEmail.value;
                var interests = document.getElementsByName('love');
                var isSelect = false;
                if (UserName === "") {
                    alert("Please enter your name！");
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
                    alert("Please choose at least one interest！");
                    return false;
                }
                else {
                    return true;
                }
            }
    </body>
</html>