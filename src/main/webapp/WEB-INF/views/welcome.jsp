<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <p>Welcome <b>User ${user_id}</b> | <a onclick="document.forms['logoutForm'].submit()">Logout</a></p>

    </c:if>
    <br/><br/>
 
    <jsp:include page="tweet/CreateTweet.jsp" />
    <br/><br/>
    
    <div id ="AllUsers"></div>
    <div id ="DisplayAllUsers" style="display:none;"><a href="${pageContext.request.contextPath}/users">All Users</a></div>
    <br/><br/>
    
    <div style="margin-top:15px">
	    <div style = "float:left;">
		    <p>List Users I Follow</p>
		    <br/>
		    <a href="${pageContext.request.contextPath}/following.xml">XML</a>
		    &nbsp | &nbsp
		    <a href="${pageContext.request.contextPath}/following.json">JSON</a>
		    <br/><br/>
		</div>
	    <div style = "float:left;margin-left: 50px;">
		    <p>List My Followers</p>
		    <br/>
		    <a href="${pageContext.request.contextPath}/followers.xml">XML</a>
		    &nbsp | &nbsp
		    <a href="${pageContext.request.contextPath}/followers.json">JSON</a>
		    <br/><br/>
		</div>
	</div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
    $("#DisplayAllUsers").find('a').click(function(){
        $('#AllUsers').load($(this).attr('href'));
    });
    $("#DisplayAllUsers").find('a').trigger('click');

});
</script>
</body>
</html>
