<%@ include file="taglibs.jsp"%>

<c:url value="/modositraktar.do" var="modositraktar"></c:url>

<%@ include file="adminlink.jsp"%>
<hr>

<form action="${modositraktar}" method="post">
<input type="hidden" name="id" name="id" value="${ raktar.id }" />
<input type="hidden" name="meret" name="meret" value="${ raktar.meret.id }" />
<table>
	<tr><th colspan="2">Raktárelem módosítása</th></tr>
	<tr>
		<td>Terméknév:</td>
		<td>${ termek.nev }</td>
	</tr>
	<tr>
		<td>Méret:</td>
		<td>${ raktar.meret.meret }</td>
	</tr>
	<tr>
		<td>Darabszám:</td>
		<td>
			<input type="text" name="darabszam" id="darabszam" value="${ raktar.darabszam }" />
			<br/><font size="2" color="red"><html:errors property="darabszam" /></font>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Mentés" />
		</td>
	</tr>
</table>
</form>