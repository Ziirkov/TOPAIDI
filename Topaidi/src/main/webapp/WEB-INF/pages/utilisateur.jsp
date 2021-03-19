<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<%@include file="commons/links.jsp" %>
<title>CONNEXION</title>
</head>
<body>
<%@include file="commons/header.jsp" %>
<div><h1>CONNEXION</h1></div>
	
	<form method="post" action="utilisateur?action=list">
		<input type="email" placeholder="Email" name="email">
		<input type="password" placeholder="Password" name="password">
		<button type="submit"> Envoyer</button>
	</form>
   <a type="button" class="btn btn-info" href="utilisateur?action=creer" >INSCRIPTION</a>
</body>
</html>