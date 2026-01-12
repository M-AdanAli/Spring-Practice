<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <h2>Employees List</h2>
        <ul>
            <c:forEach var="emp" items="${employees}">
                <li>${emp.name} - ${emp.role}</li>
            </c:forEach>
        </ul>
        <h2> <a href="${pageContext.request.contextPath}/employees/new">
            Add New Employee
        </a> </h2>
    </body>
</html>