<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile Page</title>
</head>
<body>
<!-- TODO - View profile data, ratings, reviews and vehicle data -->
<div class="frame-1">
    <div class="rectangle-1"></div>
    <div class="john-doe">${user.getFname()} ${user.Lname()}</div>
    <img class="ellipse-1" src="Ellipse%201.png" />
    <div class="driver">Driver</div>
    <div class="group-2">
        <img class="gold-star-1" src="./website_images/Gold_Star.png" />
        <div class="_4-8-rating">4.8 Rating</div>
    </div>
    <div class="_50">50</div>
    <div class="miles-driven">Miles Driven</div>
    <ul>
        <li href="#" ></li>
    </ul>



<%--    <nav class="group-1">--%>
<%--        <div class="rectangle-2"></div>--%>
<%--        <a href="#"><img class="ellipse-2" src="./website_images/Ellipse 2.png" /></a>--%>
<%--        <a href="home.jsp"><img class="home-1" src="./website_images/home.png" /></a>--%>
<%--        <a href="#"><img class="cart-1" src="./website_images/cart.png" /></a>--%>
<%--    </nav>--%>

    <img class="setting-gear-1" src="./website_images/setting-gear.png" />
    <div class="shared">Shared</div>
    <div class="_5">5</div>
    <div class="car-pools">Car Pools</div>
    <img class="calander-2" src="website_images/calander.png" />
</div>


<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    .frame-1,
    .frame-1 * {
        box-sizing: border-box;
    }
    .frame-1 {
        background: #ffffff;
        height: 765px;
        position: relative;
        overflow: hidden;
    }
    .rectangle-1 {
        background: #ffffff;
        width: 468px;
        height: 765px;
        position: absolute;
        left: 0px;
        top: 0px;
    }
    .john-doe {
        color: #000000;
        text-align: left;
        font-family: "Inter-BoldItalic", sans-serif;
        font-size: 32px;
        font-weight: 700;
        font-style: italic;
        position: absolute;
        left: 198px;
        top: 42px;
    }
    .ellipse-1 {
        border-radius: 50%;
        width: 167px;
        height: 168px;
        position: absolute;
        left: 8px;
        top: 16px;
        object-fit: cover;
    }
    .driver {
        color: #000000;
        text-align: left;
        font-family: "Inter-ExtraLightItalic", sans-serif;
        font-size: 32px;
        font-weight: 200;
        font-style: italic;
        position: absolute;
        left: 198px;
        top: 100px;
        width: 92px;
        height: 38px;
    }
    .group-2 {
        position: absolute;
        inset: 0;
    }
    .gold-star-1 {
        width: 43px;
        height: 42px;
        position: absolute;
        left: 132px;
        top: 214px;
        object-fit: cover;
    }
    ._4-8-rating {
        color: #000000;
        text-align: left;
        font-family: "Inter-ExtraLightItalic", sans-serif;
        font-size: 32px;
        font-weight: 200;
        font-style: italic;
        position: absolute;
        left: 187px;
        top: 222px;
        width: 181px;
        height: 34px;
    }
    ._50 {
        color: #000000;
        text-align: left;
        font-family: "Inter-Medium", sans-serif;
        font-size: 96px;
        font-weight: 500;
        position: absolute;
        left: 177px;
        top: 289px;
        width: 124px;
        height: 98px;
    }
    .miles-driven {
        color: #000000;
        text-align: left;
        font-family: "Inter-ExtraLightItalic", sans-serif;
        font-size: 32px;
        font-weight: 200;
        font-style: italic;
        position: absolute;
        left: 148px;
        top: 399px;
        width: 198px;
        height: 54px;
    }
    .group-1 {
        position: fixed;
        bottom:0;
        inset:0;
        width: 500px;
        margin-top: 38%;
    }
    .rectangle-2 {
        background: #9ae799;
        width: 600px;
        height: 87px;
        position: absolute;
        left: 0px;
        top: 678px;
    }
    .ellipse-2 {
        border-radius: 50%;
        width: 60px;
        height: 60px;
        position: absolute;
        left: 387px;
        top: 692px;
        object-fit: cover;
    }
    .home-1 {
        width: 92px;
        height: 92px;
        position: absolute;
        left: 0px;
        top: 673px;
        object-fit: cover;
    }
    .cart-1 {
        width: 69px;
        height: 69px;
        position: absolute;
        left: 199px;
        top: 684px;
        object-fit: cover;
    }
    .setting-gear-1 {
        width: 44px;
        height: 45px;
        position: absolute;
        left: 401px;
        top: 48.39px;
        transform-origin: 0 0;
        transform: rotate(-33.669deg) scale(1, 1);
        object-fit: cover;
    }
    .shared {
        color: #000000;
        text-align: left;
        font-family: "Inter-BoldItalic", sans-serif;
        font-size: 40px;
        font-weight: 700;
        font-style: italic;
        position: absolute;
        left: 19px;
        top: 527px;
        width: 144px;
        height: 52px;
    }
    ._5 {
        color: #9ae799;
        text-align: left;
        font-family: "Inter-BoldItalic", sans-serif;
        font-size: 128px;
        font-weight: 700;
        font-style: italic;
        position: absolute;
        left: 177px;
        top: 462px;
    }
    .car-pools {
        color: #000000;
        text-align: left;
        font-family: "Inter-BoldItalic", sans-serif;
        font-size: 36px;
        font-weight: 700;
        font-style: italic;
        position: absolute;
        left: 268px;
        top: 527px;
        width: 187px;
        height: 47px;
    }
    .calander-2 {
        width: 41px;
        height: 41px;
        position: absolute;
        left: 414px;
        top: 90px;
        object-fit: cover;
    }


</style>
</body>
</html>