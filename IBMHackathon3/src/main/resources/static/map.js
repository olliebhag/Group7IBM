document.addEventListener("DOMContentLoaded", function() {
    var can1 = document.getElementById("mapdraw");
    var ctx1 = can1.getContext("2d");
    var slider = document.getElementById('slider');
    can1.width = can1.parentElement.clientWidth;
    can1.height = can1.parentElement.clientHeight;

    function draw() {
        ctx1.clearRect(0, 0, can1.width, can1.height);
        ctx1.beginPath();
        ctx1.arc(can1.width / 2, can1.height / 2, parseInt(slider.value), 0, 2 * Math.PI);
        ctx1.fillStyle = "rgba(161, 245, 66, 0.5)"; // Green with 50% transparency
        ctx1.fill();
        ctx1.strokeStyle = "green"; // Green border
        ctx1.lineWidth = 1; // Border width
        ctx1.stroke();
        // console.log("Drawing circle with radius " + slider.value);
    }

    // Initial draw when the page loads
    draw();

    // Update the circle size on slider change
    slider.addEventListener('input', draw);
});