function addButtons() {
    // Get the container element where buttons will be added
    var container = document.getElementById("button-container");

    // Get the current number of buttons in the container
    var currentCount = container.childElementCount;

    // Calculate the value of n for the new button
    var n = Math.pow(2, currentCount);

    // Create a new button element
    var newButton = document.createElement("button");
    newButton.textContent = "I dont work";

    // Add an event listener to the new button for further functionality if needed

    // Append the new button to the container
    container.appendChild(newButton);
}