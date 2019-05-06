<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring MVC Intro</title>
</head>
<body>
    <h1>${introduction}</h1>
    <img src="${pageContext.request.contextPath}/resources/images/spring-logo.png" alt="logo">
    <h2>Forms</h2>
    <ul>
        <li><a href="${formV1}">Show Form v1</a></li>
        <li><a href="${formV2}">Show Form v2</a></li>
        <li><a href="${formV3}">Show Form v3</a></li>
    </ul>
    <br />
    <h2>Static views</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/hello-world">Hello World</a></li>
        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/test">Test</a></li>
    </ul>
</body>
</html>