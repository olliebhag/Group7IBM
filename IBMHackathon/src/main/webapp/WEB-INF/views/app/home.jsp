<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ShopMate</title>
    <style>
        .frame-1,
.frame-1 * {
  box-sizing: border-box;
}

.frame-1 {
  display: flex;
  flex-direction: column;
  background: #ffffff;
  height: 765px;
  position: relative;
  overflow: hidden;
}

.rectangle-1 {
  background: #ffffff;
  width: 468px;
  height: 765px;
  position: relative;
}

.mate,
.grocery {
  color: #464646;
  text-align: left;
  font-family: "Inter-BlackItalic", sans-serif;
  font-size: 48px;
  font-weight: 900;
  font-style: italic;
  width: 100%;
}

iframe {
  width: 100%;
}

#mapContainer {
  top: 50%; /* Adjust the percentage or use a fixed value */
  position: relative;
}

#canvas1 {
  position: absolute;
  top: 0;
  left: 0;
  background-color: transparent;
  border: 2px solid green;
}

.grocery {
  color: #9ae799;
  text-align: left;
  font-family: "Inter-BoldItalic", sans-serif;
  font-size: 48px;
  font-weight: 700;
  font-style: italic;
  width: 100%;
  margin-top: 10px; /* Add some margin between mate and grocery */
}

.map-img-1 {
  width: 468px;
  height: 273px;
  object-fit: cover;
}

.ellipse-1 {
  width: 194px;
  height: 188px;
  overflow: visible;
}

.group-1 {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  margin-top: auto;
}

.rectangle-2 {
  background: #9ae799;
  width: 100%;
  height: 87px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 16px; /* Adjust padding as needed */
}

.ellipse-2 {
  border-radius: 50%;
  width: 60px;
  height: 60px;
  object-fit: cover;
}

.home-1 {
  width: 92px;
  height: 92px;
  object-fit: cover;
}

.cart-1 {
  width: 69px;
  height: 69px;
  object-fit: cover;
}
.rectangle-3 {
  background: #d9d9d9;
  border-radius: 46px;
  width: 361px;
  height: 10px;
}

.pick-up-zone-radius {
  color: #000000;
  text-align: left;
  font-family: "Inter-ExtraLightItalic", sans-serif;
  font-size: 20px;
  font-weight: 200;
  font-style: italic;
  position: absolute;
  left: 144px;
  top: 112px;
}

.list-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  position: absolute;
  top: 650px;
  left: 40%;
  transform: translate(-50%, -50%);
}

.name-list {
  list-style: none;
  padding: 0;
  margin: 0;
  width: 100%;
}

.name-item {
  padding: 8px;
  border-bottom: 1px solid #eee;
  width: 100%;
}

.dropdown {
  display: flex;
  margin-top: 10px;
}

/* Styling for the label */
label {
  font-weight: bold;
  margin-right: 5px;
}

/* Styling for the select element */
select {
  padding: 8px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 4px;
  cursor: pointer;
}

/* Styling for the options within the dropdown */
select option {
  background-color: #fff;
  color: #333;
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
  

    <div id="mapContainer">
      <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d9928.593175688735!2d-0.11285047489298611!3d51.52883984908843!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1ssupermarket!5e0!3m2!1sen!2suk!4v1707651340380!5m2!1sen!2suk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
      <canvas id="canvas1" width="600" height="450"></canvas>
    </div>
    Select Radius: <input id="radiusSlider" type="range" min="10" max="300" value="100">
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
  
  
  <div class="frame-1">
    <div class="rectangle-1"></div>
    <div class="mate">Mate</div>
    <div class="grocery">Grocery</div>
  
  </div>
  
  
  <!-- List of names with store location, driver rating, and distance -->
  <div class="list-container">
    <input type="text" id="filterStore" class="filter-input" placeholder="Filter by store">
    
  <div class="dropdown">
    <select id="filterSelect">
      <option value="ratingHighToLow">Rating High to Low</option>
      <option value="filterDistance">Distance low to high</option>
    </select>
  </div>
    <ul class="name-list" id="nameList">
      <li class="name-item" data-store="Tesco" data-rating="4.5" data-distance="2 miles">John Doe - Tesco - Rating: 4.5 - Distance: 2 miles</li>
      <li class="name-item" data-store="Aldi" data-rating="4.2" data-distance="5 miles">Jane Smith - Aldi - Rating: 4.2 - Distance: 5 miles</li>
      <li class="name-item" data-store="Lidl" data-rating="3.8" data-distance="3 miles">Bob Johnson - Lidl - Rating: 3.8 - Distance: 3 miles</li>
      <!-- Add more names with store, rating, and distance data as needed -->
    </ul>
  </div>
    <nav class="group-1">
      <div class="rectangle-2"></div>
      <a href="profile_page.html"><img class="ellipse-2" src="../website_images/Ellipse 2.png" /></a>
      <a href="home_page.html"><img class="home-1" src="../website_images/home.png" /></a>
      <a href="#"><img class="cart-1" src="../website_images/cart.png" /></a>
  </nav>
  <!-- Your content goes here -->
  
  <!-- JavaScript for filtering -->
  <script>
    const filterStoreInput = document.getElementById('filterStore');
    const filterSelect = document.getElementById('filterSelect');
    const nameList = document.getElementById('nameList');
  
    filterStoreInput.addEventListener('input', filterNames);
    filterSelect.addEventListener('change', filterNames);
  
    function filterNames() {
      const filterStoreValue = filterStoreInput.value.toLowerCase();
      const filterSelectValue = filterSelect.value;
  
      const nameItems = nameList.getElementsByClassName('name-item');
  
      Array.from(nameItems).forEach(item => {
        const storeText = item.dataset.store.toLowerCase();
        const ratingText = item.dataset.rating.toLowerCase();
        const distanceText = item.dataset.distance.toLowerCase();
        const isMatchStore = storeText.includes(filterStoreValue);
  
        switch (filterSelectValue) {
          case 'ratingHighToLow':
            item.style.display = 'block';
            break;
          case 'filterDistance':
            const isMatchDistance = filterStoreValue === storeText; // Check if selected store equals data-store
            item.style.display = isMatchStore && isMatchDistance ? 'block' : 'none';
            break;
          default:
            item.style.display = isMatchStore ? 'block' : 'none';
        }
      });
    }
  </script>
  
  
  
  </body>
</html>