<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hi</title>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<h6>Now is ${time}</h6>
<h3>So ${message}</h3>

<c:set var="allUsersList" value="${allUsers}"/>
<c:choose>
    <c:when test="${allUsersList.size() > 0}">
        <table style="width:80%">
            <tr>
                <th>id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Status</th>
                <th>email</th>
                <th>user name</th>
            </tr>

            <c:forEach items="${allUsersList}" var="user">
                <tr>
                    <th>${user.id}</th>
                    <th>${user.firstName}</th>
                    <th>${user.lastName}</th>
                    <th>${user.status}</th>
                    <th>${user.email}</th>
                    <th>${user.username}</th>
                </tr>
            </c:forEach>

        </table>
    </c:when>
    <c:otherwise>
        There are no users in list
    </c:otherwise>
</c:choose>


</body>
</html>