<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Mini Twitter :: Follow / Unfollow</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body style="margin: 0px;">

  <div style="margin-left:30px; margin-top: 30px;">

    <h1 style="color: grey;">Follow / Unfollow Users</h1>

    <c:if test="${not empty notice}">
      ${notice}
    </c:if>

    <br/>

    <c:forEach var="user" items="${listUsers}" varStatus="status">
      <p>
        <c:choose>
          <c:when test="${user.isFollowed == false}">
            <b>User: </b>${user.id}
            <input type="button" value="Follow" style="margin-left: 10px;" onClick="follow('${user.id}')">
          </c:when>

          <c:otherwise>
            <b>User: </b>${user.id}
            <input type="button" value="Unfollow" style="margin-left: 10px;" onClick="unfollow('${user.id}')">
          </c:otherwise>
        </c:choose>
        <br/>
      </p>
    </c:forEach>
  </div>

  <script>
    function follow(user_id){
      $.post("${pageContext.request.contextPath}/users/follow",{id:user_id,commandName:"followForm"}).always(function(data){
        //alert(data.message);
        location.reload();
      });
    }

    function unfollow(user_id){
      $.post("${pageContext.request.contextPath}/users/unfollow",{id:user_id,commandName:"unfollowForm"}).always(function(data){
        //alert(data.message);
        location.reload();
      });
    }
  </script>
</body>
</html>