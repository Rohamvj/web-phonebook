<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/17/2018
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" width="100%">

    <thead>
    <tr>
        <th>Name</th>
        <th>Family</th>
        <th></th>
    </tr>
    </thead>


    <tbody>

    <%

        ArrayList<ArrayList> personList = (ArrayList<ArrayList>) request.getAttribute("personList");

        for (ArrayList<String> tmp : personList
        ) {


    %>


    <tr>
        <td><% out.print( tmp.get(0) ); %></td>
        <td><% out.print( tmp.get(1) ); %></td>
        <td></td>
    </tr>

    <%

        }


    %>


    </tbody>


</table>


</body>
</html>
