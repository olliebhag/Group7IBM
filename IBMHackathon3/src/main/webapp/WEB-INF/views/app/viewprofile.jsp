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
    <title>IBM Hackathon - ${user.nameToString()}</title>
</head>
<body>
<c:import url="/WEB-INF/views/navbar.jsp"/><!-- Links to the navbar -->
<main>
    <h1 class="welcome">${user.nameToString()}</h1>
    <div class="shared">
        <h2>Shared</h2>
        <p class="big green">${user.calcTotalPools()}</p>
        <h2>total pools</h2>
    </div>
    <div class="tile">
        <p>About ${user.getFname()}</p>
        <ul>
            <li><strong>Age:</strong> ${user.calcAge()}</li>
            <c:if test="${user.getMale()}"><li><strong>Gender:</strong> Male</li></c:if>
            <li><strong>Avg Stars: </strong>${user.getStars()}<i class="fa-solid fa-star"></i></li>
        </ul>
    </div>
    <div class="distance">
        <p><em>Driven</em></p>
        <h2>${user.getDistanceTravelled()}</h2>
        <p><em>total miles</em></p>
    </div>
    <c:if test="${user.getVehicles().size() == 0}">
        <p>${user.getFname()} has no vehicles.</p>
    </c:if>
    <c:if test="${user.getVehicles().size() > 0}">
        <h2><c:if test="${user.getMale()}">His</c:if><c:if test="${!user.getMale()}">Her</c:if><div class="green">Vehicles</div></h2>
        <div class="vehiclecontainer">
            <c:forEach items="${user.getVehicles()}" var="vehicle">
                <div class="vehicle">
                    <h3>${vehicle.getReg()}
                        <c:if test="${random == 0}"><i class="fa-solid fa-car"></i></c:if>
                        <c:if test="${random == 1}"><i class="fa-solid fa-car-side"></i></c:if>
                        <c:if test="${random == 2}"><i class="fa-solid fa-car-tunnel"></i></c:if>
                        <c:if test="${random == 3}"><i class="fa-solid fa-car-rear"></i></c:if>
                        <c:if test="${random == 4}"><i class="fa-solid fa-car-on"></i></c:if>
                        <c:if test="${random == 5}"><i class="fa-solid fa-taxi"></i></c:if>
                        <c:if test="${random == 6}"><i class="fa-solid fa-truck-pickup"></i></c:if>
                    </h3>
                    <p><strong>Seats: </strong>${vehicle.getSeats()}</p>
                    <p><strong>Rating: </strong>${vehicle.getStars()}<i class="fa-solid fa-star"></i></p>
                    <p><strong>Distance: </strong>${vehicle.getDistanceTravelled()}</p>
                </div>
            </c:forEach>
        </div>
    </c:if>
</main>
<c:import url="/WEB-INF/views/footer.jsp"/><!-- Links to the footer -->
</body>
</html>