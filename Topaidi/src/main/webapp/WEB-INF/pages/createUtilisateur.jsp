<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<%@include file="commons/links.jsp" %>
<title>INSCRIPTION</title>
</head>
<body>
<%@include file="commons/header.jsp" %>
<h1>VEUILLEZ CREER UN NOUVEL UTILISATEUR</h1>
	<form method="post" action="utilisateur?action=creer">
		<input type="email" placeholder="Email" name="email">
		<input type="text" placeholder="Nom" name="nom">
		<input type="password" placeholder="Password" name="password">
		<button type="submit"> Envoyer</button>
	</form>
	<a type="button" class="btn btn-info" href="utilisateur?action=list" >CONNEXION</a>
</body>
</html>