<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <div style="max-width:384px;">
    <table>
      <tr>
        <td><textarea id="tweet" name="tweet" maxlength="255" rows="2" cols="80"/></textarea></td>
      </tr>
      <tr>
        <td>
        	<span style="font-size: 10pt; color: grey;">* Maximum 255 characters</span>
        	<input type="button" value="Tweet" style="margin-left: 10px;" onClick="tweet()">
        </td>
      </tr>
    </table>
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
