<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Result - ID</title>
</head>
<body>
    <h2>Employee Search Result (By ID)</h2>

    <c:choose>
        <c:when test="${not empty employee}">
            <table border="1" cellpadding="8" cellspacing="0">
                <tr>
                    <th>ID</th>
                    <td>${employee.empId}</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>${employee.empName}</td>
                </tr>
                <tr>
                    <th>Year of Joining</th>
                    <td>${employee.yearOfJoining}</td>
                </tr>
                <tr>
                    <th>Department</th>
                    <td>${employee.department}</td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <p style="color:red;">No employee found with that ID.</p>
        </c:otherwise>
    </c:choose>

    <br><a href="/">Back to Home</a>
</body>
</html>
