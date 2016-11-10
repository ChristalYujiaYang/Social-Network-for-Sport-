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
        <link rel="stylesheet" type="text/css"href="css/comment.css"/>
        <title>Recomand</title>
    </head>
    <body>
        <div class="comment">
            <div class="title">
                ${requestScope.findevent.getTitle()}
            </div>
            <div class="content">
                ${requestScope.findevent.getText()}
            </div>
        </div>
        <div class="comment">
            <div class="title">
                Make a Comment
            </div>
            <form id="formcomment" name="formcomment" method="post" action="CommentServlet" onsubmit="return validateComment();">
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
                        <td></td>
                        <td>
                            <input type="submit" name="Submit" value="Submit">
                            <input name="arandacid" type="hidden" value="${requestScope.findevent.getArandacid()}">
                        </td> 
                    </tr>
                </table>
            </form>
        </div>
        <div class="comment">
            <div class="title">
                Comment
            </div>
            <table>
                <c:forEach items="${requestScope.comment}" var="comment">
                    <tr>
                        <td>
                            ${comment.title}	
                        </td>
                        <td>
                            ${comment.name}&nbsp;
                        </td>
                        <td>
                            ${comment.date}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            ${comment.text}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!-- javaScript function validateComment(),check title and text -->
        <script language="javaScript">
            function validateComment() {
                var Title = document.formcomment.txtTitle.value;
                var Text = document.formcomment.txtContent.value;
                if (Title === "") {
                    alert("Please enter a title！");
                    return false;
                }
                if (Text === "") {
                    alert("Please enter content!");
                    return false;
                }
                else {
                    return true;
                }
            }
        </script>
    </body>
</html>
