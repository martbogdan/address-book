<%@ page import="com.softserve.ita.Address" %>
<%@ page import="com.softserve.ita.Address" %>
<%@ page import="com.softserve.ita.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update address</title>
</head>
<body>

<%@include file="header.html"%>
<br><br>
<form action="/records/update" method="post">

    <%
        Address address = (Address) request.getAttribute("address");
    %>

    <table>
        <tr>
            <td>
                <label for="firstName">First Name: </label>
            </td>
            <td>
                <input type="text" id="firstName" name="firstName" value="<%=address.getFirstName()%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                <label for="lastName">Last Name: </label>
            </td>
            <td>
                <input type="text" id="lastName" name="lastName" value="<%=address.getLastName()%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                <label for="address">Address: </label>
            </td>
            <td>
                <textarea  id="address" name="address" value="<%=address.getAddress()%>"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
