<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>Cr�er une id�e</title>
</head>
<body>
<%@include file="commons/header.jsp" %>
<%@include file="commons/links.jsp" %>
<c:choose>
	<c:when test="${!empty sessionScope.nom && !empty sessionScope.email}">
		<form method="post" action="idee?action=creer">
			<input type="text" placeholder="Titre" name="titre">
			<input type="text" placeholder="Cat�gorie" name="cat">
			<input type="text" placeholder="description" name="description">
			<input type="text" placeholder="Url Image" name="url">
			<input type="hidden" name="utilisateur" value="${ sessionScope.email }">
			<input type="hidden" name="nomUtil" value="${ sessionScope.nom }">
			
			<button type="submit"> Envoyer</button>
		</form>
	</c:when>
	<c:otherwise>
		<h1>Vous n'�tes pas connect�, veuillez vous identifier ou vous inscrire pour ajouter une id�e !</h1>
		 <a type="button" class="btn btn-info" href="utilisateur?action=creer" >INSCRIPTION</a>
		  <a type="button" class="btn btn-info" href="utilisateur?action=list" >CONNEXION</a>
	</c:otherwise>
</c:choose>

</body>
</html>