<%-- 
    Document   : friends
    Created on : 2015-11-29, 10:46:30
    Author     : Crystal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"href="css/friends.css"/>
        <title>friends</title>
    </head>
    <body>
        <div class="searchfriends">
            <form id="form" name="form" method="post" action="FriendServlet" onSubmit="return validateSearch();">
                <input type="text" name="txtFriend" maxlength="20" id="txtFriend">
                <input type="image" src="image/searchbutton.png" style="width: 10%; height: 10%;">
            </form>
        </div>
        <div class="showfriends">
            <ul>
                <c:forEach items="${requestScope.showfriends}" var="showfriends">
                    <li>
                        ${showfriends.name}
                    </li>
                </c:forEach>
            </ul>
        </div>
        <script language="javaScript">
            function validateSearch()
            {
                var search = document.form.txtFriend.value;
                if (search === "")
                {
                    alert("Please enter search content！");
                    return false;
                }
                if (search.indexOf(" ") >= 0) {
                    alert("We are sorry, but you can just put in one word");
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
