<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>TOPAIDI</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="navbar-collapse">
   		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
 				<a class="nav-link" href="idee?action=list">Liste Idee</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="idee?action=creer">Ajouter une idée</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="idee?action=classement">Classements Idées</a>
			</li>
			<c:choose>
				<c:when test="${!empty sessionScope.nom && !empty sessionScope.email}">

				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href="utilisateur?action=list">Connexion</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="utilisateur?action=creer">Inscription</a>
					</li>
				</c:otherwise>
			</c:choose>
			
   		</ul>
	</div>
</nav>
</body>
</html>