<%@ include file="taglibs.jsp"%>

<script type="text/javascript">

function alertBox(msg){

	$(document).ready( function() {
		jAlert(msg+'!', 'Info');
	});
	
}

</script>

<c:url value="/rendelesleadas.do" var="rendel"></c:url>

<logic:present name="sent">
<script type="text/javascript">alertBox('Rendelését rögzítettük, kollélgánk hamarosan keresi Önt!');</script>
</logic:present>

<h2>Rendelés leadása</h2><br/><br/>

<form action='<c:out value="${rendel}" />' method="post">

<table>
	<tr>
		<td>Név:<font color="red">*</font></td>
		<td><input type="text" name="nev" id="nev" value="${nev_}"/><br/><font size="2" color="red"><html:errors property="nev" /></font></td>
		<td>Telefonszám:<font color="red">*</font></td>
		<td><input type="text" name="telszam" id="telszam" value="${telszam_ }"/><br/><font size="2" color="red"><html:errors property="telszam" /></font></td>
	</tr>

	<tr>
		<td>Irányítószám:<font color="red">*</font></td>
		<td><input type="text" name="irszam" id="irszam" value="${irszam_ }" /><br/><font size="2" color="red"><html:errors property="irszam" /></font></td>
		<td>Város:<font color="red">*</font></td>
		<td><input type="text" name="varos" id="varos" value="${varos_ }" /><br/><font size="2" color="red"><html:errors property="varos" /></font></td>
	</tr>

	<tr>
		<td>Utca:<font color="red">*</font></td>
		<td><input type="text" name="utca" id="utca" value="${utca_ }" /><br/><font size="2" color="red"><html:errors property="utca" /></font></td>
		<td>Házszám:<font color="red">*</font></td>
		<td><input type="text" name="hazszam" id="hazszam" value="${hazszam_ }" /><br/><font size="2" color="red"><html:errors property="hazszam" /></font></td>
	</tr>
	
	<tr>
		<td>Emelet/Ajtó:</td>
		<td><input type="text" name="emeletajto" id="emeletajto"  value="${ajto_ }"/><br/><font size="2" color="red"><html:errors property="emeletajto" /></font></td>
		<td>Email:<font color="red">*</font></td>
		<td><input type="text" name="email" id="email" value="${email_ }" /><br/><font size="2" color="red"><html:errors property="email" /></font></td>
	</tr>
	<tr>
	<td>Törzsvásárlói kártya száma:</td>
		<td><input type="text" name="tk" id="tk" value="${tk_ }" /></td>
	
	</tr>

	<tr>
		<td>Fizetés módja:<font color="red">*</font></td>
		<td colspan="3"><input type="radio" name="fm" id="fm" value="posta" />Postai Utánvétel<input
			type="radio" name="fm" id="fm" value="futar" />DPD futárszolgálat<input type="radio"
			name="fm"  id="fm" value="boltban" />Bolti átvétel<br/><font size="2" color="red"><html:errors property="fm" /></font></td>
	</tr>

	<tr>
		<td>Megjegyzés:</td>
		<td colspan="3"><textarea cols="50" rows="10" name="megjegyzes"
			id="megjegyzes" >${megjegyzes_ }</textarea></td>
	</tr>

	<tr>
		<td colspan="4" align="center"><input type="submit"
			value="Elküld"/></td>
	</tr>
</table>
</form>

