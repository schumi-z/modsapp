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
			<th colspan="2">M�rka m�dos�t�sa</th>
		</tr>
		<tr>
			<td>N�v:</td>
			<td>
				<input type="text" name="nev" id="nev" value="${ marka.nev }" />
				<br/><font size="2" color="red"><html:errors property="nev" /></font>
			</td>
		</tr>
		<tr>
			<td>K�p:</td>
			<td>
				<html:file property="kep" value="${ marka.kepUrl }" />
				<br/><font size="2" color="red"><html:errors property="kep" /></font>
			</td>
		</tr>
		<tr>
			<td colspan="2">M�rka t�rt�net:</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="ismerteto" id="ismerteto" cols="60" rows="15" >${ marka.markaIsmerteto }</textarea>
				<br/><font size="2" color="red"><html:errors property="ismerteto" /></font>
			</td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="M�dos�t" /></td>
		</tr>
	</table>
</html:form>