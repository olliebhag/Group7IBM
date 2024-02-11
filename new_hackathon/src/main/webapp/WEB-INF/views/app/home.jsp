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

        .phone-border {
            width: 60%;
            padding: 20px;
            background-color: #f0f0f0;
            margin: 0 auto; /* Center the phone screen */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        }

        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        #mapContainer {
            position: relative;
        }

        #canvas1 {
            position: absolute;
            top: 0;
            left: 0;
            background-color: transparent;
            border: 2px solid green;
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
<h1> Grocery Mate </h1>
<h2> Welcome  </h2>

<c:forEach items="${events}" var="event">
    <h3>${event.getDriver()}</h3>
</c:forEach>


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
</div>
</body>
</html>