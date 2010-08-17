<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<html:form action="/ujtipus" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th colspan="2">Új típus</th>
		</tr>
		<tr>
			<td>Név:</td>
			<td>
				<html:text property="nev" />
				<br/><font size="2" color="red"><html:errors property="nev" /></font>
			</td>
		</tr>
		<tr>
			<td>Aktív kép:</td>
			<td>
				<html:file property="aktivKep" value="${ aktiv_kep }" />
				<br/><font size="2" color="red"><html:errors property="aktivKep" /></font>
			</td>
		</tr>
		<tr>
			<td>Inaktív kép:</td>
			<td>
				<html:file property="inaktivKep" value="${ inaktiv_kep }" />
				<br/><font size="2" color="red"><html:errors property="inaktivKep" /></font>
			</td>
		</tr>
		<tr>
			<td colspan="2"><html:submit value="Létrehoz" /></td>
		</tr>
	</table>
</html:form>
