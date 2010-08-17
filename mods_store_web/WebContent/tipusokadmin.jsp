<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<table>
	<tr>
		<th>Név</th>
	</tr>
	<logic:iterate id="tipus" name="tipusok">

		<c:url value="/toroltipus.do" var="toroltipus">
			<c:param name="id" value="${tipus.id}"></c:param>
		</c:url>
		
		<c:url value="/modosittipusform.do" var="modosittipusform">
			<c:param name="id" value="${tipus.id}"></c:param>
		</c:url>

		<tr>
			<td>${ tipus.nev }</td>
			<td>
				<a href='<c:out value="${modosittipusform}" />'>[Módosít]</a>
				<a href='<c:out value="${toroltipus}" />'>[Töröl]</a>
			</td>
		</tr>
	</logic:iterate>
</table>