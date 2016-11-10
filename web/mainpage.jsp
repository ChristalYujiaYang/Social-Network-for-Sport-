<%-- 
    Document   : mainpage
    Created on : 2015-11-24, 20:18:47
    Author     : Crystal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" media="screen and (min-width: 600px)" href="css/laptop.css"/>
        <link rel="stylesheet" type="text/css" media="screen and (max-width: 600px)" href="css/mobile.css"/>
        <title>Social Network for Sport</title>
        <script type="text/javascript">
// javascript will go here
//copy from http://www.onextrapixel.com/2011/08/22/adding-weather-to-your-site-with-jquery-and-yql/
            $(function () {

                // Specify the ZIP/location code and units (f or c)
                var loc = '15213'; // or e.g. SPXX0050
                var u = 'f';

                var query = "SELECT item.condition FROM weather.forecast WHERE location='" + loc + "' AND u='" + u + "'";
                var cacheBuster = Math.floor((new Date().getTime()) / 1200 / 1000);
                var url = 'http://query.yahooapis.com/v1/public/yql?q=' + encodeURIComponent(query) + '&format=json&_nocache=' + cacheBuster;

                window['wxCallback'] = function (data) {
                    var info = data.query.results.channel.item.condition;
                    
                    $('#icon').append('<img src="http://l.yimg.com/a/i/us/we/52/' + info.code + '.gif" width="25" height="25" title="' + info.text + '" />');
                    $('#temp').html(info.temp + '&deg;' + (u.toUpperCase()));
                };

                $.ajax({
                    url: url,
                    dataType: 'jsonp',
                    cache: true,
                    jsonpCallback: 'wxCallback'
                });

            });
        </script>
    </head>
    <body>
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
                <div class="loginbutton">
                    <span id="weather">
                        Pittsburgh, PA: 
                    </span>
                    <span id="icon"></span>
                    <span id="temp"></span>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="login.jsp">log in</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="register.jsp">register</a>
                </div>
            </div>
            <div class="main">
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
