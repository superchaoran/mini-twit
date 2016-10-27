<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <c:forEach var="user" items="${listUsers}" varStatus="status">
   <p style="float: left; margin-right:15px;">
     <c:choose>
       <c:when test="${user.isFollowed == false}">
         <b>User ${user.id}</b>:
         <input type="button" value="Follow" style="margin-left: 10px;" onClick="follow('${user.id}')">
       </c:when>

       <c:otherwise>
         <b>User ${user.id}</b>:
         <input type="button" value="Unfollow" style="margin-left: 10px;" onClick="unfollow('${user.id}')">
       </c:otherwise>
     </c:choose>
     <br/>
   </p>
 </c:forEach>
  
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
