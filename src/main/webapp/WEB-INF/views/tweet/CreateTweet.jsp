<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Mini Twitter :: New Tweet</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body style="margin: 0px;">

  <div style="margin-left:30px; margin-top: 30px;">
    <table>
      <tr>
        <td><textarea id="tweet" name="tweet" maxlength="255" rows="2" cols="130"/></textarea></td>
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
        alert("${pageContext.request.contextPath}/tweet/create");
    	alert(data.message);
        window.location = "${pageContext.request.contextPath}/welcome";
      });
    }
  </script>
</body>
</html>