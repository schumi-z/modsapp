<%@ include file="taglibs.jsp"%>

<c:url value="/meretekadmin.do" var="meretek"></c:url>

<c:url value="/ujmeretform.do" var="ujmeretform"></c:url>

<c:url value="/tipusokadmin.do" var="tipusokadmin"></c:url>

<c:url value="/ujtipusform.do" var="ujtipusform"></c:url>

<c:url value="/markakadmin.do" var="markakadmin"></c:url>

<c:url value="/ujmarkaform.do" var="ujmarkaform"></c:url>

<c:url value="/termekekadmin.do" var="termekekadmin"></c:url>

<c:url value="/ujtermekform.do" var="ujtermekform"></c:url>

<c:url value="/raktaradmin.do" var="raktaradmin"></c:url>

<c:url value="/rendelesekadmin.do" var="rendelesekadmin"></c:url>

<c:url value="/teljesitettrendelesekadmin.do" var="teljesitettrendelesekadmin"></c:url>

<c:url value="/hirleveladmin.do" var="hirleveladmin"></c:url>

<c:url value="/hirlevelfeliratkozottakadmin.do" var="hirlevelfeliratkozottakadmin"></c:url>

<c:url value="/logout.do" var="logout"></c:url>



<ul>	
	<li>
		<a href='<c:out value="${meretek}"/>'>M�retek</a>
		<a href='<c:out value="${ujmeretform}"/>'>[�j]</a>
	</li>
	<li>
		<a href='<c:out value="${tipusokadmin}"/>'>T�pusok</a>
		<a href='<c:out value="${ujtipusform}"/>'>[�j]</a>
	</li>
	<li>
		<a href='<c:out value="${markakadmin}"/>'>M�rk�k</a>
		<a href='<c:out value="${ujmarkaform}"/>'>[�j]</a>
	</li>
	<li>
		<a href='<c:out value="${termekekadmin}"/>'>Term�kek</a>
		<a href='<c:out value="${ujtermekform}"/>'>[�j]</a>
	</li>
	<li>
		<a href='<c:out value="${raktaradmin}"/>'>Rakt�r</a>
	</li>
	
	<li>
		<a href='<c:out value="${rendelesekadmin}"/>'>Nem teljesitett rendel�sek</a>
	</li>
	<li>
		<a href='<c:out value="${teljesitettrendelesekadmin}"/>'>Teljes�tett rendel�sek</a>
	</li>
	
	<li>
		<a href='<c:out value="${hirleveladmin}"/>'>H�rlev�l</a>
	</li>	
	<li>
		<a href='<c:out value="${hirlevelfeliratkozottakadmin}"/>'>H�rlev�lre feliratkozottak</a>
	</li>
	<li>
		<a href='<c:out value="${logout}"/>'>Logout</a>
	</li>
</ul>