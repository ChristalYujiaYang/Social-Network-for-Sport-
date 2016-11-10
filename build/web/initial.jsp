<%-- 
    Document   : initial
    Created on : 2015-11-29, 11:32:48
    Author     : Crystal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />       
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width: 355px)" href="css/initial.css"/>
        <link rel="stylesheet" type="text/css" media="screen and (max-width: 355px)" href="css/initialm.css"/>
        <script type="text/javascript" src="js/mydate.js"></script>
        <title>Initial</title>
    </head>
    <body>
        <div class="initial">
            <div class="title">
                Start an Activity
            </div>
            <div class="content">
                <form id="forminitial" name="forminitial" method="post" action="ActivityServlet" onsubmit="return validateInitial();">
                    <table>
                        <tr>
                            <td>
                                Title:
                            </td>
                            <td>
                                <input type="text" id="txtTitle" name="txtTitle" class="text normal required">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Content：
                            </td>
                            <td>
                                <textarea id="txtContent" name="txtContent" style="width: 90%; resize: none" class="text required"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                PeopleMax:
                            </td>
                            <td>    
                                <input type="text" name="txtMax" maxlength="5" id="txtMax">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                PeopleMin:
                            </td>
                            <td>
                                <input type="text" name="txtMin" maxlength="5" id="txtMin">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Date :
                            </td>
                            <td>
                                <input type="date" name="txtDate" value="yyyy-mm-dd" 
                                       onfocus='if (this.value === "yyyy-mm-dd") {
                                                   this.value = "";
                                               }
                                               ;
                                       'onblur='if (this.value === "") {
                                                   this.value = "yyyy-mm-dd";
                                               }
                                               ;'>
                            </td>
                        <tr>
                        <tr>
                            <td>
                                Place:
                            </td>
                            <td>
                                <input type="text" name="txtPlace" maxlength="20" id="txtPlace">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                class:
                            </td>
                            <td>
                                <select name="select" id="selectClass" class="interests">
                                    <option value="basketball">basketball</option>
                                    <option value="baseball">baseball</option>
                                    <option value="swimming">swimming</option>
                                    <option value="football">football</option>
                                    <option value="jogging">jogging</option>
                                    <option value="soccer">soccer</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" name="Submit" value="Submit">
                                <input type="reset" name="Reset" value="Reset">
                            </td> 
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="initial">
            <div class="title">Events</div>
            <div class="eventitems">
                <table>
                    <c:forEach items="${requestScope.findevents}" var="findevents">
                        <tr>
                            <td>
                                <a href="${pageContext.request.contextPath}/SEventServlet?id=${findevents.arandacid}">${findevents.title}  </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="pagelist">
                <p>
                    <font>
                    <a href="${pageContext.request.contextPath}/InitialServlet?change=decrease">Previous Page</a>
                    &nbsp; Page No.<font color="#ff0000">${PageNum}</font> &nbsp; 
                    <a href="${pageContext.request.contextPath}/InitialServlet?change=increase">Next Page</a>
                    </font>
                </p>
            </div>
        </div>
    </body>
    <!-- javaScript function validateInitial(),check title, and so on -->
    <script language="javaScript">
        function validateInitial() {
            var Title = document.forminitial.txtTitle.value;
            var Max = document.forminitial.txtMax.value;
            var Min = document.forminitial.txtMin.value;
            var Date = document.forminitial.txtDate.value;
            var Place = document.forminitial.txtPlace.value;
            var Text = document.forminitial.txtContent.value;
            if (Title === "") {
                alert("Please enter a title!");
                return false;
            }
            if (Text === "") {
                alert("Please enter content!");
                return false;
            }
            var patrn1 = /^[0-9]*$/;
            if (!patrn1.exec(Max)) {
                alert("Please enter valid Max number of people!");
                return false;
            }
            var patrn2 = /^[0-9]*$/;
            if (!patrn2.exec(Min)) {
                alert("Please enter valid Min number of people!");
                return false;
            }
            var patrn3 = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
            if (!patrn3.exec(Date)) {
                alert("Wrong format of date!");
                return false;
            }
            if (Place === "") {
                alert("Please enter place of activity!");
                return false;
            }
            else {
                return true;
            }
        }
    </script>
</html>

