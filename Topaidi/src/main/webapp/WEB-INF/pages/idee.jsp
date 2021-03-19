<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<%@include file="commons/links.jsp" %>
<title>Liste des idées</title>
</head>
<body>
<%@include file="commons/header.jsp" %>
<c:if test="${!empty sessionScope.nom }">
	<p>Bienvenue : ${ sessionScope.nom}</p>
</c:if>
<div class="row mt-3">
<c:forEach items="${idees}" var="idee">
	<div class="col-sm-3">
	<div class="card" style="width: 18rem;">
	  <img class="card-img-top" src="${idee.getUrlImage()}" alt="Card image cap">
	  
		  <div class="card-body">
		    <h5 class="card-title">${idee.getTitre()}</h5>
		    <p class="card-text">${idee.getCategorie()}</p>
		    <p class="card-text">${idee.getDescription()}</p>
		  </div>
		  <div class="card-footer">
		  	<p>Soumis par : ${idee.getNomUtil()}</p>
		  	<p>Le : ${idee.getDate()}</p>
		  	<p>Note : ${idee.getTop()}</p>
		  	<p>Note : ${idee.getFlop()}</p>
		  	<c:choose>
				<c:when test="${!empty sessionScope.nom && !empty sessionScope.email}">
				  	<form method="post" action="idee?action=top" >
				  		<input type="hidden" name="idIdee" value="${idee.getId()}">
				  		<input type="hidden" name="email" value="${ sessionScope.email}">
						<input type="hidden" name="top" value="${idee.getTop()}">
				  		<input type="hidden" name="flop" value="${idee.getFlop()}">
				  		<button type="submit" class="btn btn-dark">Top</button>
				  	</form>
		  		  	<form method="post" action="idee?action=flop" >
				  		<input type="hidden" name="idIdee" value="${idee.getId()}">
						<input type="hidden" name="email" value="${ sessionScope.email}">
				  		<input type="hidden" name="top" value="${idee.getTop()}">
				  		<input type="hidden" name="flop" value="${idee.getFlop()}">
				  		<button type="submit" class="btn btn-dark">Flop</button>
				  	</form>
		  		</c:when>
		  		<c:otherwise>
		  			<p>Vous devez être connecté pour voter !</p>
		  		</c:otherwise>
		  	</c:choose>
		  </div>
		</div>
	</div>	
  </c:forEach>
</div>
  
  <br>
    <a type="button" class="btn btn-info" href="idee?action=creer" >Ajouter</a>
</body>
</html>