<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="css/style.css">
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<body>

	<%@include file="header.jsp" %>	
    <h2>Submitted Annonce Information</h2>
    <table>
        <tr>
            <td>Titre :</td>
            <td>${titre}</td>
        </tr>
        <tr>
            <td>Description :</td>
            <td>${description}</td>
        </tr>
    </table>
    <%@include file="footer.jsp" %>
</body>