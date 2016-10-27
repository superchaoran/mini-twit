<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:forEach var="tweetModel" items="${listFollowingTweets}" varStatus="status">
  <p><b>User ${tweetModel.user_id}:(${tweetModel.date}):</b> ${tweetModel.tweet}
</c:forEach>