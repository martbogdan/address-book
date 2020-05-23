<%@ page import="com.softserve.ita.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address info</title>
</head>
<body>
<%@include file="header.html"%>
<br><br>
<%
    Address address = (Address) request.getAttribute("address");
%>

    <p>First name: <%=address.getFirstName()%></p>
    <p>Last name: <%=address.getLastName()%></p>
    <p>Address: <%=address.getAddress()%></p>

</body>
</html>
