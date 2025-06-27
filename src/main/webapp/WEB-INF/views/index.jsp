<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Home</title></head>
<body>
    <h2>Add New Employee</h2>
    <form:form method="POST" modelAttribute="employee" action="/addEmployee">
        Name: <form:input path="empName" />
        <form:errors path="empName"/><br><br>

        Department:
        <form:select path="department">
            <form:option value="" label="--Select Department--" />
            <form:options items="${departments}" />
        </form:select><br><br>

        Year of Joining: <form:input path="yearOfJoining" />
        <form:errors path="yearOfJoining"/><br><br>

        <input type="submit" value="Add Employee" />
    </form:form>

    <hr>

    <h3>Search Employee by ID</h3>
    <form action="searchById" method="get">
        Enter ID: <input type="number" name="id" required />
        <input type="submit" value="Search" />
    </form>
	<h3>Search by Department & Year</h3>
	<form action="searchByDepartment" method="post">
	    Department:
	    <select name="department" required>
	        <option value="">--Select Department--</option>
	        <c:forEach var="dept" items="${departments}">
	            <option value="${dept}">${dept}</option>
	        </c:forEach>
	    </select>

	    Year (>=): <input type="number" name="year" required />
	    <input type="submit" value="Search" />
	</form>


    <br>
    <a href="/allEmployees">View All Employees</a>
</body>
</html>
