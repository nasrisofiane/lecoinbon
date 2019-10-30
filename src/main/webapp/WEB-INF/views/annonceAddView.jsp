<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="css/style.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./style.css" />
<title>Insert title here</title>
<style>
	textarea{
		resize:none
	}
	form{
		display:flex;
		flex-direction:column;
		justify-content:center;
		align-items:center;
	}
</style>
</head>
<body>
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

</body>
</html>