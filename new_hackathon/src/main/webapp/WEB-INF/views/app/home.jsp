<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>GroceryMate</title>
    <style>

        body {
            font-family: Verdana, sans-serif;
            font-size: 15px;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            min-height: 100vh;
            background-color: #f0f0f0;
        }

        .phone-border {
            width: 90vw; /* Adjusted to 90% of the viewport width */
            max-width: 400px; /* Set a maximum width for larger screens */
            margin: 20px auto; /* Center the container and add margin for spacing */
            padding: 10px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            text-align: center; /* Center the content */
        }

        #mapContainer {
            position: relative;
        }

        #canvas1 {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: auto;
            background-color: transparent;
            border: 2px solid green;
            display: block;
            margin: 10px 0;
        }

        #radiusSlider {
            width: 100%;
            margin-top: 10px;
        }

        iframe {
            width: 100%;
            height: 300px; /* Adjusted the height of the map for visibility */
            margin-top: 10px; /* Added margin to separate canvas and map */
        }

        .navbar {
            width: 90vw;
            max-width: 400px;
            margin: auto;
            padding: 0px;
            background-color: lightgreen;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            text-align: center;
            border-radius: 10px;
        }

        .navbar a {
            color: #fff;
            text-decoration: none;
            padding: 10px;
        }

        .icons {
            width: 30px;
            height: 30px;
        }

        input[type="range"] {
            width: 100%;
            height: 5px;
            background: lightgreen;
            border: none;
            border-radius: 5px;
            outline: none;
            -webkit-appearance: none;
        }

        input[type="range"]::-webkit-slider-thumb {
            width: 20px;
            height: 20px;
            background: #fff; /* Set the thumb color */
            border: 2px solid lightgreen; /* Set the thumb border color */
            border-radius: 50%;
            cursor: pointer;
            -webkit-appearance: none;
        }

        #grocery {
            font-family: Verdana, sans-serif;
            color: #9ae799;
            font-size: 30px;
            font-style: italic;
            white-space: nowrap;
            border: 10px;
        }

        h1 {
            border: 40px;
            text-decoration: underline;
        }

    </style>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var can1 = document.getElementById("canvas1");
            var ctx1 = can1.getContext("2d");
            var radiusSlider = document.getElementById('radiusSlider');

            function draw() {
                ctx1.clearRect(0, 0, can1.width, can1.height);
                ctx1.beginPath();
                ctx1.arc(can1.width / 2, can1.height / 2, parseInt(radiusSlider.value), 0, 2 * Math.PI);
                ctx1.fillStyle = "rgba(0, 128, 0, 0.5)"; // Green with 50% transparency
                ctx1.fill();
                ctx1.strokeStyle = "green"; // Green border
                ctx1.lineWidth = 2; // Border width
                ctx1.stroke();
            }

            // Initial draw when the page loads
            draw();

            // Update the circle size on slider change
            radiusSlider.addEventListener('input', draw);
        });
    </script>
</head>
<body>
<div class="phone-border">
<h1 id="grocery">GroceryMate<img class="icons" src="https://cdn-icons-png.freepik.com/512/8866/8866816.png"></h1>
<h2> Welcome, ${user.getFname()}.</h2>


<%--<c:forEach items="${goals}" var="goal">--%>
<%--    <h3>Goal ${goal.id}</h3>--%>
<%--    <c:forEach items="${goal.exercises}" var="exercise">--%>
<%--        <p>${exercise.activity} for ${exercise.minutes} min.</p>--%>
<%--    </c:forEach>--%>
<%--</c:forEach>--%>

<div id="mapContainer">
    <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d9928.593175688735!2d-0.11285047489298611!3d51.52883984908843!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1ssupermarket!5e0!3m2!1sen!2suk!4v1707651340380!5m2!1sen!2suk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    <canvas id="canvas1" width="600" height="450"></canvas>
</div>
Select Radius: <input id="radiusSlider" type="range" min="10" max="300" value="100">
    <h3>Nearby Upcoming Journeys:</h3>
    <c:forEach items="${events}" var="event">
        <h3>${event.getDriver().getFname()} ${event.getDriver().getLname()} | ${event.getStore().getName()} </h3>
    </c:forEach>

    <div class="navbar">
        <a href="/"><img class="icons" src="https://cdn-icons-png.flaticon.com/512/25/25694.png"></a>
        <a href="/upcoming"><img class="icons" src="https://icons.veryicon.com/png/o/miscellaneous/face-monochrome-icon/calendar-249.png"></a>
        <a href="/profile"><img class="icons" src="https://static.thenounproject.com/png/2367782-200.png"></a>
    </div>
</div>


<%--<nav class="group-1">--%>
<%--    <div class="rectangle-2"></div>--%>
<%--    <a href="#"><img class="ellipse-2" src="./website_images/Ellipse 2.png" /></a>--%>
<%--    <a href="home_page.html"><img class="home-1" src="/Users/ben/IdeaProjects/Group7IBM/new_hackathon/src/main/webapp/WEB-INF/views/app/home_icon.jpg" /></a>--%>
<%--    <a href="#"><img class="cart-1" src="./website_images/cart.png" /></a>--%>
<%--</nav>--%>
</body>
</html>