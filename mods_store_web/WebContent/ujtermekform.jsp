<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<!-- TinyMCE -->
<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="js/richtextarea.js"></script>
<!-- /TinyMCE -->

<html:form action="/ujtermek" method="post" enctype="multipart/form-data">
<table>
	<tr><th colspan="2">�j term�k</th></tr>
	<tr>
		<td>N�v:</td>
		<td>
			<html:text property="nev" value="${ nev }" />
			<br/><font size="2" color="red"><html:errors property="nev" /></font>
		</td>
	</tr>
	<tr>
		<td colspan="2">Le�r�s:</td>
	</tr>
	<tr>
		<td colspan="2"><html:textarea rows="3" cols="30" property="leiras">${ leiras }</html:textarea></td>
	</tr>
	<tr>
		<td>Egys�g�r:</td>
		<td>
			<html:text property="egysegar" value="${ egysegar }" />
			<br/><font size="2" color="red"><html:errors property="egysegar" /></font>
		</td>
	</tr>
	<tr>
		<td>Term�kk�d:</td>
		<td>
			<html:text property="termekkod" value="${ termekkod }" />
			<br/><font size="2" color="red"><html:errors property="termekkod" /></font>
		</td>
	</tr>
	<tr>
		<td>K�p:</td>
		<td>
			<html:file property="kep" value="${ kep }" />
			<br/><font size="2" color="red"><html:errors property="kep" /></font>
		</td>
	</tr>
	<tr>
		<td>T�pus:</td>
		<td>
			<html:select property="tipus" value="${tipus_id}">
				<logic:iterate id="t" name="tipusok">
					<html:option value="${ t.id }">${ t.nev }</html:option>
				</logic:iterate>
			</html:select>
			<br/><font size="2" color="red"><html:errors property="tipus" /></font>
		</td>
	</tr>
	<tr>
		<td>M�rka:</td>
		<td>
			<html:select property="marka" value="${ marka_id }">
				<logic:iterate id="m" name="markak">
					<html:option value="${ m.id }">${ m.nev }</html:option>
				</logic:iterate>
			</html:select>
			<br/><font size="2" color="red"><html:errors property="marka" /></font>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="checkbox" name="aktiv" id="aktiv" checked="checked" value="true" />Akt�v
		</td>
	</tr>
	<tr>
		<td>
			<html:submit value="L�trehoz" />
		</td>
	</tr>
</table>
</html:form>