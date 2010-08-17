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
		<a href='<c:out value="${meretek}"/>'>Méretek</a>
		<a href='<c:out value="${ujmeretform}"/>'>[Új]</a>
	</li>
	<li>
		<a href='<c:out value="${tipusokadmin}"/>'>Típusok</a>
		<a href='<c:out value="${ujtipusform}"/>'>[Új]</a>
	</li>
	<li>
		<a href='<c:out value="${markakadmin}"/>'>Márkák</a>
		<a href='<c:out value="${ujmarkaform}"/>'>[Új]</a>
	</li>
	<li>
		<a href='<c:out value="${termekekadmin}"/>'>Termékek</a>
		<a href='<c:out value="${ujtermekform}"/>'>[Új]</a>
	</li>
	<li>
		<a href='<c:out value="${raktaradmin}"/>'>Raktár</a>
	</li>
	
	<li>
		<a href='<c:out value="${rendelesekadmin}"/>'>Nem teljesitett rendelések</a>
	</li>
	<li>
		<a href='<c:out value="${teljesitettrendelesekadmin}"/>'>Teljesített rendelések</a>
	</li>
	
	<li>
		<a href='<c:out value="${hirleveladmin}"/>'>Hírlevél</a>
	</li>	
	<li>
		<a href='<c:out value="${hirlevelfeliratkozottakadmin}"/>'>Hírlevélre feliratkozottak</a>
	</li>
	<li>
		<a href='<c:out value="${logout}"/>'>Logout</a>
	</li>
</ul>