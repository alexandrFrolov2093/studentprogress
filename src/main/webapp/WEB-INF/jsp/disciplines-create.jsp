<%--
  Created by IntelliJ IDEA.
  User: Sanya
  Date: 13.05.2019
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание дисциплины</title>
    <link rel="stylesheet" href="resources/css/styles.css" type='text/css' media='all'/>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>
<a href="/logout" class="logout-link">Logout</a>


<a href="/logout" class="logout-link">Logout</a>



<a href="/" class="links main-link">На главную</a>
<a href="/disciplines" class="links back-link">Назад</a>
<h3>Для того, чтобы создать новую дисциплину заполните все поля и нажмите кнопку «Создать»</h3>
<div class="container" id="discipline-create-page">
    <form action="/discipline-create" method="post">
        <div>
            <label>Название</label>
            <input name="newDiscipline" type="text">
        </div>
        <input type="submit" value="Создать">

    </form>
</div>


</body>
</html>

