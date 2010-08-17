<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<!-- TinyMCE -->
<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="js/richtextarea.js"></script>
<!-- /TinyMCE -->

<html:form action="/modosittermek" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" id="id" value="${ termek.id }" />
<table>
	<tr><th colspan="2">Termék módosítása</th></tr>
	<tr>
		<td>Név:</td>
		<td>
			<input type="text" name="nev" id="nev" value="${ termek.nev }"/>
			<br/><font size="2" color="red"><html:errors property="nev" /></font>
		</td>
	</tr>
	<tr>
		<td colspan="2">Leírás:</td>
	</tr>
	<tr>
		<td colspan="2"><textarea rows="3" cols="30" name="leiras" id="leira">${ termek.leiras }</textarea></td>
	</tr>
	<tr>
		<td>Egységár:</td>
		<td>
			<input type="text" name="egysegar" id="egysegar" value="${ termek.egysegar }" />
			<br/><font size="2" color="red"><html:errors property="egysegar" /></font>
		</td>
	</tr>
	<tr>
		<td>Termékkód:</td>
		<td>
			<input type="text" name="termekkod" id="termekkod" value="${ termek.termekkod }" />
			<br/><font size="2" color="red"><html:errors property="termekkod" /></font>
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
		<td>Típus:</td>
		<td>
			<select name="tipus" id="tipus">
				<logic:iterate id="tipus" name="tipusok">
					<c:choose>
						<c:when test="${ termek.tipus.id == tipus.id }" >
							<option selected="selected" value="${ tipus.id }">${ tipus.nev }</option>
						</c:when>
						<c:otherwise>
							<option value="${ tipus.id }">${ tipus.nev }</option>
						</c:otherwise>
					</c:choose>
				</logic:iterate>
			</select>
			<br/><font size="2" color="red"><html:errors property="tipus" /></font>
		</td>
	</tr>
	<tr>
		<td>Márka:</td>
		<td>
			<select name="marka" id="marka">
				<logic:iterate id="marka" name="markak">
					<c:choose>
						<c:when test="${ termek.marka.id == marka.id }" >
							<option selected="selected" value="${ marka.id }">${ marka.nev }</option>
						</c:when>
						<c:otherwise>
							<option value="${ marka.id }">${ marka.nev }</option>
						</c:otherwise>
					</c:choose>
				</logic:iterate>
			</select>
			<br/><font size="2" color="red"><html:errors property="marka" /></font>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:choose>
				<c:when test="${ termek.aktiv == true }">
					<input type="checkbox" name="aktiv" id="aktiv" checked="checked" value="true" />Aktív
				</c:when>
				<c:otherwise>
					<input type="checkbox" name="aktiv" id="aktiv" value="true" />Aktív
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Módosít" />
		</td>
	</tr>
</table>
</html:form>