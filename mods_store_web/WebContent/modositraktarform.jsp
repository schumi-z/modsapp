<%@ include file="taglibs.jsp"%>

<c:url value="/modositraktar.do" var="modositraktar"></c:url>

<%@ include file="adminlink.jsp"%>
<hr>

<form action="${modositraktar}" method="post">
<input type="hidden" name="id" name="id" value="${ raktar.id }" />
<input type="hidden" name="meret" name="meret" value="${ raktar.meret.id }" />
<table>
	<tr><th colspan="2">Rakt�relem m�dos�t�sa</th></tr>
	<tr>
		<td>Term�kn�v:</td>
		<td>${ termek.nev }</td>
	</tr>
	<tr>
		<td>M�ret:</td>
		<td>${ raktar.meret.meret }</td>
	</tr>
	<tr>
		<td>Darabsz�m:</td>
		<td>
			<input type="text" name="darabszam" id="darabszam" value="${ raktar.darabszam }" />
			<br/><font size="2" color="red"><html:errors property="darabszam" /></font>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Ment�s" />
		</td>
	</tr>
</table>
</form>