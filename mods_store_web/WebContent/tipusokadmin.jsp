<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<table>
	<tr>
		<th>N�v</th>
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
				<a href='<c:out value="${modosittipusform}" />'>[M�dos�t]</a>
				<a href='<c:out value="${toroltipus}" />'>[T�r�l]</a>
			</td>
		</tr>
	</logic:iterate>
</table>