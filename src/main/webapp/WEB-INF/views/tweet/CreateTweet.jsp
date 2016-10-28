<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <div class="form-group">
        <textarea id="tweet" name="tweet" maxlength="255" rows="2" cols="100" class="form-control" cols="100"/></textarea>
        <span style="font-size: 10pt; color: grey;">* Maximum 255 characters</span>
     
        <input class="btn btn-primary" type="button" value="Tweet" style="margin-left: 10px;" onClick="tweet()">
   </div>
 
  
  <script>
    function tweet(tweet){
      var tweet = document.getElementById("tweet").value;
      $.post("${pageContext.request.contextPath}/tweet/create",{tweet:tweet,commandName:"tweetForm"}).always(function(data){
        /*alert("${pageContext.request.contextPath}/tweet/create");
    	alert(data.message);*/
        window.location = "${pageContext.request.contextPath}/welcome";
      });
    }
  </script>
