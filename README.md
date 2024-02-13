# Grocery Mate - 2024 IBM Hackathon

This repository contains Spring Boot and JavaServer Pages (JSP) files for the Grocery Mate application developed during the 2024 UoL IBM Hackathon. 
The application aims to facilitate carpooling and event coordination for users visiting supermarkets and grocery shopping.

## How to Use

### 1. Event Details Page

This page displays detailed information about a specific event. 
Users can see the event location on a map, check the date and time, view the driver's details, and see a list of participants. 
Depending on the user's role (driver or participant), additional actions such as deleting or leaving the event are available.

### 2. Home Page (`home.jsp`)

The home page provides an overview of available events based on the user's current location. 
Users can see a map with their location, adjust the search radius using a slider, and view a list of upcoming events. 
Each event card displays essential information, and users can click on an event to see more details.

### 3. User Profile Page (`profile.jsp`)

This page showcases the user's profile, including shared pool statistics, personal details, driven distance, and a list of associated vehicles. 
Users can add vehicles if none are present and click on vehicle details to view more information.

### 4. Search Page

The search page allows users to filter and sort events based on various criteria such as date, time, distance, and driver's rating. 
Users can adjust the sorting criteria using a form, and the results are displayed, showing relevant event information.

### 5. User Details Page (`userDetails.jsp`)

This page provides detailed information about a specific user. 
Users can see the other user's shared pool statistics, personal details, driven distance, and a list of associated vehicles. 

## Footer and Header

### Footer (`footer.jsp`)

The footer contains navigation buttons allowing users to quickly access the home page, search for events, and view their profile. 
The icons represent home, calendar, and profile functionalities.

### Header (`header.jsp`)

The header displays the Grocery Mate logo and serves as a consistent branding element across all pages.

## Usage

1. Clone this repository.
2. Configure the application with Spring Boot.
3. Deploy the JSP pages on your server.

Feel free to explore and customize the code to fit your specific requirements. Good luck with your project!
