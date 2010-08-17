<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<!-- TinyMCE -->
<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="js/richtextarea.js"></script>
<!-- /TinyMCE -->

<html:form action="/modositmarka" method="post" enctype="multipart/form-data">
	<html:hidden property="id" value="${ marka.id }" />
	<table>
		<tr>
			<th colspan="2">Márka módosítása</th>
		</tr>
		<tr>
			<td>Név:</td>
			<td>
				<input type="text" name="nev" id="nev" value="${ marka.nev }" />
				<br/><font size="2" color="red"><html:errors property="nev" /></font>
			</td>
		</tr>
		<tr>
			<td>Kép:</td>
			<td>
				<html:file property="kep" value="${ marka.kepUrl }" />
				<br/><font size="2" color="red"><html:errors property="kep" /></font>
			</td>
		</tr>
		<tr>
			<td colspan="2">Márka történet:</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="ismerteto" id="ismerteto" cols="60" rows="15" >${ marka.markaIsmerteto }</textarea>
				<br/><font size="2" color="red"><html:errors property="ismerteto" /></font>
			</td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="Módosít" /></td>
		</tr>
	</table>
</html:form>