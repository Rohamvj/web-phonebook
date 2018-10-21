<%--
  Created by IntelliJ IDEA.
  User: ROHAM
  Date: 10/20/2018
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://localhost:8080/">
    <title>Title</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<form method="post" action="/newPerson/">

    <label>
        نام:
        <input type="text" name="name" dir="rtl" >
    </label>

    <label>
        نام خانوادگی:
        <input type="text" name="family" dir="rtl">
    </label>

    <label>
        تلفن همراه:
        <input type="text" name="mobile" dir="rtl">
    </label>

    <label>
        تلفن منزل:
        <input type="text" name="home" dir="rtl">
    </label>

    <label>
        تلفن محل کار:
        <input type="text" name="work" dir="rtl">
    </label>
    <p><br><br><br><center>
    <button type="submit">ساخت شخص جدید</button>
</center></p>
</form>


</body>
</html>
