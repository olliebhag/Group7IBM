<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/styles.css">
    <script src="https://kit.fontawesome.com/e1ffb954fb.js" crossorigin="anonymous"></script>
    <title>IBM Hackathon - Search</title>
</head>
<body>
    <c:import url="/WEB-INF/views/navbar.jsp"/><!-- Links to the navbar -->
    <main>
        <div class="searchbox">
            <%--@elvariable id="sort" type="Form"--%>
            <form:form action="/sortSearch" modelAttribute="sort">
                <form:label path="type">Sort by: </form:label>
                <form:select path="type" name="sort">
                    <option <c:if test="${sort.type == sort.getTypes()[0]}">selected="true"</c:if> value="Date">Date</option>
                    <option <c:if test="${sort.type == sort.getTypes()[1]}">selected="true"</c:if>value="Time">Time</option>
                    <option <c:if test="${sort.type == sort.getTypes()[2]}">selected="true"</c:if>value="Distance">Distance</option>
                    <option <c:if test="${sort.type == sort.getTypes()[3]}">selected="true"</c:if>value="Rating">Rating</option>
                    <option <c:if test="${sort.type == sort.getTypes()[4]}">selected="true"</c:if>value="isMale">isMale</option>
                    <option <c:if test="${sort.type == sort.getTypes()[5]}">selected="true"</c:if>value="isNotMale">isNotMale</option>
                </form:select>
                <input type="submit">
            </form:form>
        </div>

        <c:if test="${events.size() > 0}"><h1 class="green border">Search Results</h1></c:if>
        <c:if test="${events.size() == 0}"><h1>Search Results</h1></c:if>

        <c:if test="${events.size() == 0}">
            <p class="green big">No events found</p>
        </c:if>
        <div class="eventcontainer">
            <c:forEach items="${events}" var="event">
                <div class="event">
                    <h3><a href="/getEvent?id=${event.getId()}">${event.getStore().getName()}</a></h3>
                    <p><strong>Date:</strong> ${event.date()}</p>
                    <p><strong>Time:</strong> ${event.time()}</p>
                    <p><strong>Distance to pickup:</strong> ${event.getPickUpDistance(user.getCurrentLocation())}Km</p>
                    <p><strong>Driver:</strong> ${event.getDriver().nameToString()}</p>
                    <p><strong>Avg Rating:</strong> ${event.getDriver().getStars()}<i class="fa-solid fa-star"></i></p>
                </div>
            </c:forEach>
        </div>
    </main>
    <c:import url="/WEB-INF/views/footer.jsp"/><!-- Links to the footer -->
</body>
</html>