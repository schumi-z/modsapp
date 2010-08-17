<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<html:form action="/termekekadmin" method="post" enctype="multipart/form-data">
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
		<th>Név</th>
		<th>Egységár</th>
		<th>Termékkód</th>
		<th>Típus</th>
		<th>Márka</th>
	</tr>
	<logic:iterate id="termek" name="termekek">
		<tr>
	
			<c:url value="/toroltermek.do" var="toroltermek">
		   		<c:param name="id" value="${ termek.id }"></c:param>
			</c:url>	

			<c:url value="/modosittermekform.do" var="modosittermek">
		   		<c:param name="id" value="${ termek.id }"></c:param>
			</c:url>

			<c:url value="/ujraktarform.do" var="ujraktarform">
		   		<c:param name="id" value="${ termek.id }"></c:param>
			</c:url>

			<td>${ termek.nev }</td>
			<td>${ termek.egysegar }</td>
			<td>${ termek.termekkod }</td>
			<td>${ termek.tipus.nev }</td>
			<td>${ termek.marka.nev }</td>
			<td><a href='<c:out value="${toroltermek}"/>'>[Töröl]</a>
				<a href='<c:out value="${modosittermek}"/>'>[Módosít]</a>
				<a href='<c:out value="${ujraktarform}"/>'>[Raktár]</a>
			</td>
		</tr>
	</logic:iterate>
</table>
<hr>

<table>
	<tr>
	
		<td>
			<html:form action="/termekekadmin" method="post" enctype="multipart/form-data">
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
			<html:form action="/termekekadmin" method="post" enctype="multipart/form-data">
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
			<html:form action="/termekekadmin" method="post" enctype="multipart/form-data">
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
			<html:form action="/termekekadmin" method="post" enctype="multipart/form-data">
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
