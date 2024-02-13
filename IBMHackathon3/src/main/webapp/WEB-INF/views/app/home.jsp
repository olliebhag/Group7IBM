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
    <title>IBM Hackathon - Home</title>
</head>
<body>
    <c:import url="/WEB-INF/views/navbar.jsp"/><!-- Links to the navbar -->
    <main>
        <div class="mapcontainer">
            <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d9928.593175688735!2d-0.11285047489298611!3d51.52883984908843!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1ssupermarket!5e0!3m2!1sen!2suk!4v1707651340380!5m2!1sen!2suk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            <canvas id="mapdraw"></canvas>
        </div>
        <script src="map.js"></script>
        <div class="slidercontainer">
            <label for="slider" id="sliderlabel">Radius:</label>
            <input id="slider" type="range" min="25" max="180" value="50">
        </div>
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