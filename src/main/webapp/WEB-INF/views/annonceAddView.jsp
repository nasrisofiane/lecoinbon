<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="css/style.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<body>
	
	<%@include file="header.jsp" %>
	<h2>Add annonce</h2>
	<div>
	<form:form method="POST" action="http://localhost:8080/addAnnonce" modelAttribute="annonce">
		<fieldset>
		<legend>Titre</legend>
		<form:errors path="titre" cssClass="error" element="div"/>
		<form:input path="titre"/>
		</fieldset>
		
		<fieldset>
		<legend>Description</legend>
		<form:errors path="description" cssClass="error" element="div" />
		<form:input path="description"/>
		</fieldset>
		<input type="submit" value="ajouter l'annonce">
	</form:form>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>