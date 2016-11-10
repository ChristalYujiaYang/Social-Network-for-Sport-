<%-- 
    Document   : mainpage
    Created on : 2015-11-24, 20:18:47
    Author     : Crystal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <a href="mainpage.jsp">Home</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="login.jsp">log in</a>
                </div>
            </div>
            <div class="main">
                <div class="mranking">
                    <div class="title">Ranking List</div>
                    <div class="rankingitems">
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
                </div>
                <div class="event">
                    <div class="title">Events</div>
                    <div class="eventitems">
                        <table>
                            <c:forEach items="${requestScope.findevents}" var="findevents">
                                <tr>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/JumpServlet?id=${findevents.arandacid}">${findevents.title}  </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
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
    </body>
</html>
