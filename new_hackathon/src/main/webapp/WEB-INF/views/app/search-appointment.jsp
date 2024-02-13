<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<!-- TODO - Input filters for store, pick up, timing, gender, date -->
    <form:form action="/search" method="post">
        <form:select path="store">
            <c:forEach items="${stores}" var="store">
                <form:option value="${store.id}" label="${store.name}"/>
            </c:forEach>
        </form:select>
    </form:form>
</body>
</html>