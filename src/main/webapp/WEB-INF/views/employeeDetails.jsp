<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>All Employees</title></head>
<body>
    <h2>All Employee Details</h2>

    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Year of Joining</th><th>Department</th>
        </tr>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.empId}</td>
                <td>${emp.empName}</td>
                <td>${emp.yearOfJoining}</td>
                <td>${emp.department}</td>
            </tr>
        </c:forEach>
    </table>

    <br><a href="/">Back to Home</a>
</body>
</html>
