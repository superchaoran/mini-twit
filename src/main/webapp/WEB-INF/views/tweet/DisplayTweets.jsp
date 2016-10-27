<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:forEach var="tweet" items="${listTweets}" varStatus="status">
  <p><b>Self:(${tweet.date}):</b> ${tweet.tweet}
</c:forEach>