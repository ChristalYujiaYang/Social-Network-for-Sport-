<%-- 
    Document   : mainpage
    Created on : 2015-11-24, 20:18:47
    Author     : Crystal
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/rightbar.js"></script>
        <link rel="stylesheet" type="text/css" media="screen and (min-width: 600px)" href="css/laptop.css"/>
        <link rel="stylesheet" type="text/css" media="screen and (max-width: 600px)" href="css/mobile.css"/>
        <title>Social Network for Sport</title>
        <%--copy from  http://www.divcss5.com/template/m101.shtml--%>

        <script type="text/javascript" language="javascript">
            function connect(id) {
                document.getElementById("iframe1").src = id + ".jsp";
            }
        </script>
        <script type="text/javascript" language="javascript">
            function GetConnect() {
                document.getElementById("iframe1").src = "${pageContext.request.contextPath}/SEventServlet?id=${requestScope.id}&get=${requestScope.get}";
                        var sfEls = document.getElementById("nav").getElementsByTagName("li");
                        for (var i = 0; i < sfEls.length; i++) {
                            sfEls[i].onmouseover = function () {
                                this.className += (this.className.length > 0 ? " " : "") + "sfhover";
                            };
                            sfEls[i].onMouseDown = function () {
                                this.className += (this.className.length > 0 ? " " : "") + "sfhover";
                            };
                            sfEls[i].onMouseUp = function () {
                                this.className += (this.className.length > 0 ? " " : "") + "sfhover";
                            };
                            sfEls[i].onmouseout = function () {
                                this.className = this.className.replace(new RegExp("( ?|^)sfhover\\b"), "");
                            };
                        }
                    }
        </script>
    </head>
    <body onload="GetConnect()">
        <div class="wrapped">
            <div class="header">
                <div class="logo">
                    SPORT
                </div>
                <div class="searchbox">
                    <form id="form" name="form" method="post" action="SearchServlet" onSubmit="return validateSearch();">
                        <input type="text" name="Search" size="30vw" maxlength="50" id="Search">
                        <input type="image" src="image/searchbutton.png" style="width: 10%; height: 10%;">
                    </form>
                </div>
                <div class="hloginbutton">
                    <ul id="nav"> 
                        <li>
                            <a href="${pageContext.request.contextPath}/HomeServlet">Home</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                        </li>
                        <li>
                            <%
                                request.setCharacterEncoding("UTF-8");
                                List<String> info = (List<String>) request.getAttribute("info");
                                if (info != null) {
                                    Iterator<String> iter = info.iterator();
                                    while (iter.hasNext()) {
                                        out.println(iter.next());
                                    }
                                }
                            %>
                            <ul> 
                                <li><a id="modify" onclick="connect(this.id)" herf="javascript:void(0)">Modify</a></li> 
                                <li><a href="${pageContext.request.contextPath}/LogoutServlet">Log out</a></li> 
                            </ul> 
                        </li> 
                        <li>
                            &nbsp;&nbsp;|&nbsp;&nbsp;<a id="article" onclick="connect(this.id)" herf="javascript:void(0)">Article</a>
                        </li>
                    </ul> 
                </div>
            </div>
            <div class="main">
                <div class="joined">
                    <div class="title">Joined Activity</div>
                    <table>
                        <c:forEach items="${requestScope.joinedactivity}" var="joinedactivity">
                            <tr>
                                <td>
                                    <a href="${pageContext.request.contextPath}/JumpServlet?id=${joinedactivity.arandacid}">${joinedactivity.title}  </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="frame">
                    <iframe id="iframe1" ></iframe>
                </div>
                <div class="hranking">
                    <div class="title">Ranking list</div>
                    <table>
                        <c:forEach items="${requestScope.rankevents}" var="rankevents">
                            <tr>
                                <td>
                                    <a href="${pageContext.request.contextPath}/JumpServlet?id=${rankevents.arandacid}">${rankevents.title}  </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div id="friends">
                    <strong class="rightejecttit"><span>Friends</span></strong>
                    <div class="rightejectcon">
                        <div class="friendframe">
                            <iframe src="${pageContext.request.contextPath}/ShowFriendServlet" id="iframe2"></iframe>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                copyright © School of Information Sciences, University of Pittsburgh
                <br/>
                contact us: YUW75@pitt.edu/YUY54@pitt.edu
            </div>
        </div>
        <script language="javaScript">
            function validateSearch()
            {
                var search = document.form.Search.value;
                if (search === "")
                {
                    alert("Please enter search content！");
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
