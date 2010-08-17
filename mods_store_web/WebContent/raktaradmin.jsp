<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<html:form action="/raktaradmin" method="post" enctype="multipart/form-data">
	<html:hidden property="pageIndex" value="0" />
	<table>
		<tr>
		
			<td>Márka:</td>
			
			<td>
				<html:select property="marka" value="${ marka.id }">
					<html:option value="0">Mind</html:option>
					<logic:iterate id="m" name="markak">
						<html:option value="${ m.id }">${ m.nev }</html:option>
					</logic:iterate>
				</html:select>
			</td>
			
			<td>Típus:</td>
			
			<td>
				<html:select property="tipus" value="${ tipus.id }">
					<html:option value="0">Mind</html:option>
					<logic:iterate id="t" name="tipusok">
						<html:option value="${ t.id }">${ t.nev }</html:option>
					</logic:iterate>
				</html:select>
			</td>
			
			<td><html:submit value="Mehet" /></td>

		</tr>
	</table>
</html:form>
<hr>

<table>
	<tr>
		<th>Terméknév</th>
		<th>Márka</th>
		<th>Típus</th>
		<th>Méret</th>
		<th>Darabszám</th>
	</tr>
	<logic:iterate id="elem" name="raktar">

		<c:url value="/torolraktar.do" var="torolraktar">
			<c:param name="id" value="${ elem.id }"></c:param>
		</c:url>

		<c:url value="/modositraktarform.do" var="modositraktarform">
			<c:param name="id" value="${ elem.id }"></c:param>
		</c:url>

		<c:url value="/ujraktarform.do" var="ujraktarform">
			<c:param name="id" value="${ elem.termek.id }"></c:param>
		</c:url>


		<tr>
			<td>${ elem.termek.nev }</td>
			<td>${ elem.termek.marka.nev }</td>
			<td>${ elem.termek.tipus.nev }</td>
			<td>${ elem.meret.meret }</td>
			<td>${ elem.darabszam }</td>
			<td><a href='<c:out value="${torolraktar }" />'>[Töröl]</a>
			<a href='<c:out value="${modositraktarform}" />'>[Módosít]</a>
			<a href='<c:out value="${ujraktarform}" />'>[Új raktár]</a></td>
		</tr>
	</logic:iterate>
</table>

<table>
	<tr>
	
		<td>
			<html:form action="/raktaradmin" method="post" enctype="multipart/form-data">
				<html:hidden property="pageIndex" value="0" />
				<html:hidden property="marka" value="${ marka.id }" />
				<html:hidden property="tipus" value="${ tipus.id }" />
				<c:choose>
					<c:when test="${ page == 0 }">
						<html:submit value="&lt&lt" disabled="true" />
					</c:when>
					<c:otherwise>
						<html:submit value="&lt&lt" />
					</c:otherwise>
				</c:choose>
			</html:form>
		</td>
	
		<td>
			<html:form action="/raktaradmin" method="post" enctype="multipart/form-data">
				<html:hidden property="pageIndex" value="${ page - 1 }" />
				<html:hidden property="marka" value="${ marka.id }" />
				<html:hidden property="tipus" value="${ tipus.id }" />
				<c:choose>
					<c:when test="${ page == 0 }">
						<html:submit value="&lt" disabled="true" />
					</c:when>
					<c:otherwise>
						<html:submit value="&lt" />
					</c:otherwise>
				</c:choose>
			</html:form>
		</td>
		
		<td>
			${ page + 1 } / ${ total }
		</td>
		
		<td>
			<html:form action="/raktaradmin" method="post" enctype="multipart/form-data">
				<html:hidden property="pageIndex" value="${ page + 1 }" />
				<html:hidden property="marka" value="${ marka.id }" />
				<html:hidden property="tipus" value="${ tipus.id }" />
				<c:choose>
					<c:when test="${ page == total - 1 or total == 0 }">
						<html:submit value="&gt" disabled="true" />
					</c:when>
					<c:otherwise>
						<html:submit value="&gt" />
					</c:otherwise>
				</c:choose>
			</html:form>
		</td>
		
		<td>
			<html:form action="/raktaradmin" method="post" enctype="multipart/form-data">
				<html:hidden property="pageIndex" value="${ total - 1 }" />
				<html:hidden property="marka" value="${ marka.id }" />
				<html:hidden property="tipus" value="${ tipus.id }" />
				<c:choose>
					<c:when test="${ page == total - 1  or total == 0}">
						<html:submit value="&gt&gt" disabled="true" />
					</c:when>
					<c:otherwise>
						<html:submit value="&gt&gt" />
					</c:otherwise>
				</c:choose>
			</html:form>
		</td>
		
	</tr>
</table>