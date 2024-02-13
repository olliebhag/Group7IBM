<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://kit.fontawesome.com/e1ffb954fb.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/styles.css">
    <title>IBM Hackathon - Event</title>
</head>
<body>
    <c:import url="/WEB-INF/views/navbar.jsp"/><!-- Links to the navbar -->
    <main>
        <div class="mapconainter">
            <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d9928.593175688735!2d${event.getPickUp().getLon()}!3d${event.getPickUp().getLat()}!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1ssupermarket!5e0!3m2!1sen!2suk!4v1707651340380!5m2!1sen!2suk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>
        <div class="event">
            <h3>${event.getStore().getName()}</h3>
            <c:if test="${event.getDriver().getId() == user.getId()}">
                <a class="eventbutton" href="/deleteEvent?id=${event.getId()}">Delete</a>
            </c:if>
            <c:if test="${event.getDriver().getId() != user.getId() && event.getParticipants().contains(user)}">
                <a class="eventbutton" href="/leaveEvent?id=${event.getId()}&user=${user.getId()}">Leave</a>
            </c:if>
            <c:if test="${event.getDriver().getId() != user.getId() && !event.getParticipants().contains(user)}">
                <a class="eventbutton" href="/joinEvent?id=${event.getId()}&user=${user.getId()}">Join</a>
            </c:if>
            <p><strong>Date:</strong> ${event.date()}</p>
            <p><strong>Time:</strong> ${event.time()}</p>
            <p><strong>Distance to pickup:</strong> ${event.getPickUpDistance(user.getCurrentLocation())}Km</p>
            <p style="padding-block: 3%;"><strong>Driver:</strong><a class="driverbutton" href="/viewprofile?id=${event.getDriver().getId()}">${event.getDriver().nameToString()}</a></p>
            <p><strong>Rating:</strong> ${event.getDriver().getStars()}<i class="fa-solid fa-star"></i></p>
            <p><strong>Participants:</strong></p>
            <ol>
                <c:forEach items="${event.getParticipants()}" var="participant">
                    <li>${participant.nameToString()}</li>
                </c:forEach>
            </ol>
        </div>
    </main>
    <c:import url="/WEB-INF/views/footer.jsp"/><!-- Links to the footer -->
</body>
</html>