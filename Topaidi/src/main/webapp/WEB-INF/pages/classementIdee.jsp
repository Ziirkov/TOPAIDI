<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<%@include file="commons/links.jsp" %>
<title>Classement des idées</title>
</head>
<body>
<%@include file="commons/header.jsp" %>
<c:if test="${!empty sessionScope.nom }">
	<p>Bienvenue : ${ sessionScope.nom}</p>
</c:if>

<h1>CLASSEMENT TOPS</h1>
<br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">TITRE :</th>
      <th scope="col">POURCENTAGE :</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${classementTop}" var="class">
	    <tr> 
	      <td>${class.getTitre()}</td>
	      <td>${class.getMoyenne()}</td>
	    </tr>
	</c:forEach>
  </tbody>
</table>

<h1>CLASSEMENT BRAINS</h1>
<br>
<table class="table">
  <tbody>
    <tr> 
    <td style="font-weight: bold;">NOM :</td>
     <c:forEach items="${classementBrainsNom}" var="nom">
      <td>${nom}</td>
     </c:forEach>
   	</tr>  
    <tr>
    <td style="font-weight: bold;">NOMBRE D'IDEES :</td> 	    
	<c:forEach items="${classementBrainsStat}" var="stat">
	      <td>${stat}</td>
   	</c:forEach>
    </tr>
  </tbody>
</table>

<h1>CLASSEMENT BUZZ</h1>
<br>
<table class="table">
  <tbody>
	    <tr>
	    <td style="font-weight: bold;">TITRE :</td>
	    <c:forEach items="${classementVoteTitre}" var="titre">
	      <td>${titre.getTitre()}</td>
      	</c:forEach>
	    </tr>
   	    <tr>
	    <td style="font-weight: bold;">NOMBRE DE VOTES :</td>
	    <c:forEach items="${classementVoteNum}" var="num">
	      <td>${num}</td>
      	</c:forEach>
	    </tr>
  </tbody>
</table>
</body>
</html>