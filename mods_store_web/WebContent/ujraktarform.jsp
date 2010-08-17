<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<c:url value="/ujraktar.do" var="ujraktar"></c:url>

<form action="${ujraktar }" method="post">
<input type="hidden" name="id" name="id" value="${ termek.id }" />
<table>
	<tr><th colspan="2">�j rakt�relem</th></tr>
	<tr>
		<td>Term�kn�v:</td>
		<td>${ termek.nev }</td>
	</tr>
	<tr>
		<td>M�ret:</td>
		<td>
			<select name="meret" id="meret">
				<logic:iterate id="meret" name="meretek">
					<c:choose>
						<c:when test="${ meret.id == meret_id }" >
							<option selected="selected" value="${ meret.id }">${ meret.meret }</option>
						</c:when>
						<c:otherwise>
							<option value="${ meret.id }">${ meret.meret }</option>
						</c:otherwise>
					</c:choose>
				</logic:iterate>
			</select>
			<br/><font size="2" color="red"><html:errors property="meret" /></font>
		</td>
	</tr>
	<tr>
		<td>Darabsz�m:</td>
		<td>
			<input type="text" name="darabszam" id="darabszam" value="${ db }" />
			<br/><font size="2" color="red"><html:errors property="darabszam" /></font>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="L�trehoz" />
		</td>
	</tr>
</table>
</form>