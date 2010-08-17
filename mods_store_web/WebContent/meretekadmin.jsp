<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>
  
<table>
	<tr>
		<th>Név</th>
	</tr>
	<logic:iterate id="meret" name="meretek">
	
		<c:url value="/torolmeret.do" var="torol">
		   <c:param name="id" value="${ meret.id }"></c:param>
		</c:url>		

		<tr>
			<td>${ meret.meret }</td>
			<td><a href='<c:out value="${torol}"/>'>[Töröl]</a></td>
		</tr>
	</logic:iterate>
</table>