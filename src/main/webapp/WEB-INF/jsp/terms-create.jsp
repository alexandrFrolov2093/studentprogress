<%--
  Created by IntelliJ IDEA.
  User: Sanya
  Date: 13.05.2019
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание семестра</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>


<a href="/logout" class="logout-link">Logout</a>



<a href="/" class="links main-link">На главную</a>
<a href="/terms" class="links back-link">Назад</a>
<h3>Для создания семестра заполните следующие данные и нажмите кнопку «Создать».</h3>

<div class="container" id="term-create-page">
    <form action="/term-create" method="post">
        <div class="one-row">
            <div class="for-label">
                <label >Длительность (в неделях)</label>
            </div>
            <input type="text" name="duration">
        </div>
        <div class="one-row">
            <div class="for-label">
                <label>Дисциплины в семестре</label>
            </div>
            <select multiple size="8" name="disciplines">

                <option value="2">История науки и техники</option>

                <option value="3">Стохастика</option>

                <option value="4">??????????? !!!!</option>

                <option value="5">Теория Алгоритмизации</option>

                <option value="6">Анализ</option>

            </select>
        </div>
        <input type="submit" value="Создать">


    </form>
</div>


</body>
</html>

