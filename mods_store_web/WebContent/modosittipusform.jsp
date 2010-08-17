<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<html:form action="/modosittipus" method="post" enctype="multipart/form-data">
	<html:hidden property="id" value="${ tipus.id }" />
	<table>
		<tr>
			<th colspan="2">T�pus m�dos�t�sa</th>
		</tr>
		<tr>
			<td>N�v:</td>
			<td>
				<input type="text" name="nev" id="nev" value="${tipus.nev}">
				<br/><font size="2" color="red"><html:errors property="nev" /></font>
			</td>
		</tr>
		<tr>
			<td>Akt�v k�p:</td>
			<td>
				<html:file property="aktivKep" value="${ tipus.aktivKepUrl }" />
				<br/><font size="2" color="red"><html:errors property="aktivKep" /></font>
			</td>
		</tr>
		<tr>
			<td>Inakt�v k�p:</td>
			<td>
				<html:file property="inaktivKep" value="${ tipus.inaktivKepUrl }" />
				<br/><font size="2" color="red"><html:errors property="inaktivKep" /></font>
			</td>
		</tr>
		<tr>
			<td colspan="2"><html:submit value="M�dos�t" /></td>
		</tr>
	</table>
</html:form>