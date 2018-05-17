<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta content="text/html; charset=UTF-8">
    <title>Employees</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/main.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</head>

<body>
<div class="wrapper">
    <%@include file="/WEB-INF/jsp/secure/auth_header.jsp" %>
    <div class="container">
        <h3 class="page-title">Department employees</h3>
        <div class="block block-table">
            <div class="table-container">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">First name</th>
                        <th scope="col">Last name</th>
                        <th scope="col">Position</th>
                        <th scope="col">Hourly rate</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${department.employees}">
                        <tr>
                            <td><c:out value="${employee.firstName}"/></td>
                            <td><c:out value="${employee.lastName}"/></td>
                            <td><c:out value="${employee.position.name}"/></td>
                            <td><c:out value="${employee.hourlyRate}"/></td>
                            <td><a href="${contextPath}/delete-employee-${department.id}/${employee.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="btn-block">
            <a href="${contextPath}/new-employee" class="btn btn-g">Add employee</a>
            <a href="${contextPath}/list-departments" class="btn btn-r">Back</a>
        </div>
    </div>
</div>
</body>
</html>