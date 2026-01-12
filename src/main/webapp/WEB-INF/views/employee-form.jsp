<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>

        <h2>Add Employee</h2>

        <form:form method="post"
                   action="${pageContext.request.contextPath}/employees"
                   modelAttribute="employeeForm">

            <div>
                Name: <form:input path="name"/>
                <form:errors path="name"/>
            </div>

            <div>
                Role: <form:input path="role"/>
                <form:errors path="role"/>
            </div>

            <button type="submit">Save</button>

        </form:form>

        <a href="${pageContext.request.contextPath}/employees">Back to list</a>

    </body>
</html>