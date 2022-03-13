<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ocp.webapp.model.ContactType" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Список всех резюме</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <table>
        <tr>
            <th>Имя</th>
            <th>Email</th>
            <th width="50"></th>
            <th width="50"></th>
        </tr>
        <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume" type="com.ocp.webapp.model.Resume"/>
            <tr>
                <td><a href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a></td>
                <td>${resume.getContact(ContactType.MAIL)}</td>
                <td><a href="resume?uuid=${resume.uuid} &action=edit"><img src="img/edit.png"></a></td>
                <td><a href="resume?uuid=${resume.uuid} &action=delete"><img src="img/delete.png"></a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<%@ include file="fragments/footer.jsp"%>

</body>
</html>
