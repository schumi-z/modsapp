<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<table>
	<tr>
		<th>N�v</th>
	</tr>
	<logic:iterate id="marka" name="markak">

		<c:url value="/torolmarka.do" var="torolmarka">
			<c:param name="id" value="${ marka.id }"></c:param>
		</c:url>

		<c:url value="/modositmarkaform.do" var="modositmarkaform">
			<c:param name="id" value="${ marka.id }"></c:param>
		</c:url>

		<tr>
			<td>${ marka.nev }</td>
			<td>
				<a href='<c:out value="${modositmarkaform}" />'>[M�dos�t]</a>
				<a href='<c:out value="${torolmarka}" />'>[T�r�l]</a>
			</td>
		</tr>
	</logic:iterate>
</table>