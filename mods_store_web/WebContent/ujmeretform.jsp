<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<c:url value="/ujmeret.do" var="ujmeret"></c:url>

<form action="${ujmeret}" method="post">
	<table>
		<tr>
			<th colspan="2">Új méret</th>
		</tr>
		<tr>
			<td>Név:</td>
			<td>
				<input type="text" id="meret" name="meret" />
				<br/><font size="2" color="red"><html:errors property="meret" /></font>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Létrehoz" /></td>
		</tr>
	</table>
</form>