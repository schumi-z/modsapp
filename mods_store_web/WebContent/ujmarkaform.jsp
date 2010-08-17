<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<!-- TinyMCE -->
<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="js/richtextarea.js"></script>
<!-- /TinyMCE -->

<html:form action="/ujmarka" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th colspan="2">Új márka</th>
		</tr>
		<tr>
			<td>Név:</td>
			<td>
				<html:text property="nev" value="${ nev }" />
				<br/><font size="2" color="red"><html:errors property="nev" /></font>
			</td>
		</tr>
		<tr>
			<td>Kép:</td>
			<td>
				<html:file property="kep" value="${ kep }" />
				<br/><font size="2" color="red"><html:errors property="kep" /></font>
			</td>
		</tr>
		<tr>
			<td colspan="2">Márka történet:</td>
		</tr>
		<tr>
			<td colspan="2">
				<html:textarea property="ismerteto" cols="30" rows="15">${ ismerteto }</html:textarea>
				<br/><font size="2" color="red"><html:errors property="ismerteto" /></font>
			</td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="Létrehoz" /></td>
		</tr>
	</table>
</html:form>