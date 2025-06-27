<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Search by Department</title></head>
<body>
    <h2>Employees in Department: ${deptName}</h2>
    <c:if test="${not empty employees}">
        <table border="1">
            <tr><th>ID</th><th>Name</th><th>Year of Joining</th><th>Department</th></tr>
            <c:forEach var="emp" items="${employees}">
                <tr>
                    <td>${emp.empId}</td>
                    <td>${emp.empName}</td>
                    <td>${emp.yearOfJoining}</td>
                    <td>${emp.department}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty employees}">
        <p>No employees found in ${deptName} with that year.</p>
    </c:if>
    <br><a href="/">Back to Home</a>
</body>
</html>
