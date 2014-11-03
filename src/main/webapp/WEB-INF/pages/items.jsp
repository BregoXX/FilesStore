<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Files Storage</title>
    </head>

    <body>

        <!-- отображает сообщени об удаленном файле-->
        <c:if test="${deletedFile != null}">
            <font color="red">File: ${deletedFile} Was deleted<br/></font>
            <!-- удаляем из сессии имя файла, чтобы оно не отображалось после рефреша страницы-->
            <c:remove var="deletedFile" scope="session" />
        </c:if>

        <!-- Список файлов -->
        <c:forEach items="${items}" var="item">
            <a href="${pageContext.request.contextPath}/downloadServlet?fileName=${item}">${item}</a> <br/>
        </c:forEach>

        <!-- Форма загрузки файла -->
        <form method="POST" action="upload" enctype="multipart/form-data">
            File:
            <input type="file" name="file" id="file"/> <br/>
            <input type="submit" value="Upload" name="upload" id="upload"/>
        </form>
    </body>
</html>