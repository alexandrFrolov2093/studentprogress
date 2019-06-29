<%--
  Created by IntelliJ IDEA.
  User: Sanya
  Date: 14.05.2019
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание новой учетной записи студента</title>
    <link rel="stylesheet" href="resources/css/styles.css" type='text/css' media='all'/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker({

                dateFormat: 'yy-mm-dd'
            });
        });
    </script>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>


<a href="/logout" class="logout-link">Logout</a>


<a href="/" class="main-link links">На главную</a>
<a href="/students" class="back-link links">Назад</a>

<h3>Для создания студента заполните все поля и нажмите кнопку «Создать»</h3>
<form action="/student-create" method="post">
    <div class="container" id="student-create-page">

        <div>
            <label>Фамилия</label>
            <input name="newSername" type="text">
        </div>

        <div>
            <label>Имя</label>
            <input name="newName" type="text">
        </div>

        <div>
            <label>Группа</label>
            <input name="newGroup" type="text">
        </div>

        <div>
            <label>Дата поступления</label>
            <input name="newDate" type="text" id="datepicker">
        </div>

        <div>
            <input type="submit" value="Создать">
        </div>


    </div>
</form>

</body>
</html>