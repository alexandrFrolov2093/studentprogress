
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список названий дисциплин</title>
    <link rel="stylesheet" href="resources/css/styles.css" type='text/css' media='all'/>
    <script src="../../resources/js/functions.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>


<a href="/logout" class="logout-link">Logout</a>



<a href="/" class="main-link links">На главную</a>
<div class="container">
    <div id="select-semestr">
        <label>Выбрать семестр</label>
        <form action="/terms-select" method="get">
            <select name="selectTerm" id="selectTerm">

                <c:forEach items="${terms}" var="t">

                    <option value="${t.id}">${t.name}</option>

                </c:forEach>

            </select>

            <input type="submit" value="Выбрать">
        </form>

    </div>
    <p>Длительность семестра ${selectedTerm.duration}</p>
    <p>Список дисциплин семестра</p>
    <div id="term-list-main-info">
        <table class="main-info-table">
            <tr>
                <th>Наименование дисциплины</th>
            </tr>

            <c:forEach items="${disciplines}" var="d">

                <tr>
                    <td>${d.discipline}</td>
                </tr>

            </c:forEach>




        </table>
        <div>
            <form action="/terms-create" , method="get">

                <input type="submit" value="Создать семестр..." class="big-button">

            </form>

            <input type="submit" value="Модифицировать текущий семестр..." class="big-button" onclick="termModify()">

            <form action="/term-modify" method="get" id="term-modify-form">
                <input type="hidden", name="termIdModify", id="termIdModify">
            </form>


            <form action="/term-delete" method="post" id = "delete-term-form">
                <input type="hidden" name="idTermDelete" id="idTermDelete">
            </form>

            <input type="submit" value="Удалить текущий семестр" class="big-button" onclick="deleteTerm()">

        </div>
    </div>

</div>

</body>
</html>

