<%-- 
    Document   : article
    Created on : 2015-11-28, 16:30:41
    Author     : Crystal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="css/article.css"/>
        <title>Article</title>
    </head>
    <body>
        <div class="article">
            <form method="post" name="formArticle" runat="server" onSubmit="return validateArticle();" action="ArticleServlet">
                <table>
                    <tr>
                        <td>
                            Title
                        </td>  
                        <td>
                            <input type="text" name="txtTitle" maxlength="50" id="txtTitle">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Keywords
                        </td>  
                        <td>
                            <input type="text" name="txtK1" maxlength="20" id="txtK1">
                            <input type="text" name="txtK2" maxlength="20" id="txtK2">
                            <input type="text" name="txtK3" maxlength="20" id="txtK3">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Text
                        </td>  
                        <td>
                            <textarea id="txtText" name="txtText" rows="15" style="width: 100%; resize: none"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Class
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
                        </td> 
                    </tr>
                </table>
            </form>
        </div>
        <!-- javaScript function validateArticle(),check title,keywords and class -->
        <script language="javaScript">
            function validateArticle() {
                var Title = document.formArticle.txtTitle.value;
                var K1 = document.formArticle.txtK1.value;
                var Text = document.formArticle.txtText.value;
                if (Title === "") {
                    alert("Please enter a title！");
                    return false;
                }
                if (K1 === "") {
                    alert("You should fill in at least one keyword!");
                    return false;
                }
                if (Text === "") {
                    alert("Please enter text!");
                    return false;
                }
                else {
                    return true;
                }
            }
        </script>
    </body>
</html>
