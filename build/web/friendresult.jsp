<%-- 
    Document   : friendresult
    Created on : 2015-12-8, 22:31:00
    Author     : Crystal
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css"href="css/friends.css"/>
        <title>FriendResult</title>
    </head>
    <body>
        <div class="searchfriends">
            <form id="form" name="form" method="post" action="FriendServlet" onSubmit="return validateSearch();">
                <input type="text" name="txtFriend" maxlength="20" id="txtFriend">
                <input type="image" src="image/searchbutton.png" style="width: 10%; height: 10%;">
            </form>
        </div>
        <div class="result">
            <form id="addfriend" name="addfriend" method="post" action="AddFriendServlet">
                <table>
                    <c:forEach items="${requestScope.findfriends}" var="findfriends">
                        <tr>
                            <td>
                                ${findfriends.name}
                            </td>
                            <td>
                                <input type="Submit" name="submit" value="Add">
                            </td>
                        </tr>
                        <input name="friendid" type="hidden" value="${findfriends.userid}">
                    </c:forEach>
                </table>
            </form>
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
