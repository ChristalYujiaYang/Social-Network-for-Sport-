<%-- 
    Document   : recommand
    Created on : 2015-11-28, 20:09:28
    Author     : Crystal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css"href="css/activity.css"/>
        <title>Recommend</title>
        <script type="text/javascript">
            function join()
            {
                document.formActivity.action = "JoinServlet";
            }
            function quit()
            {
                document.formActivity.action = "QuitServlet";
            }

        </script>
    </head>
    <body>
        <div class="activity">
            <form method="post" name="formActivity" runat="server">
                <div class="title">
                    ${requestScope.findevent.title}
                </div>
                <div class="content">
                    ${requestScope.findevent.text}
                </div>
                <div class="bottom">
                    <div class="title">
                        Number of People:${requestScope.findevent.peoplenum}
                    </div>
                    <div class="title">
                        PeopleMax:${requestScope.findevent.peoplemax}
                    </div>
                    <div class="title">
                        PeopleMin:${requestScope.findevent.peoplemin}
                    </div>
                    <br/>
                    <div class="button">
                        <input type="submit" name="Submit" value="Join" onclick="join()" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" name="Submit" value="Quit" onclick="quit()">
                        <input name="arandacid" type="hidden" value="${requestScope.findevent.getArandacid()}">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
