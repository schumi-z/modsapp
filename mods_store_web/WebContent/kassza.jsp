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
<script type="text/javascript">alertBox('Rendel�s�t r�gz�tett�k, koll�lg�nk hamarosan keresi �nt!');</script>
</logic:present>

<h2>Rendel�s lead�sa</h2><br/><br/>

<form action='<c:out value="${rendel}" />' method="post">

<table>
	<tr>
		<td>N�v:<font color="red">*</font></td>
		<td><input type="text" name="nev" id="nev" value="${nev_}"/><br/><font size="2" color="red"><html:errors property="nev" /></font></td>
		<td>Telefonsz�m:<font color="red">*</font></td>
		<td><input type="text" name="telszam" id="telszam" value="${telszam_ }"/><br/><font size="2" color="red"><html:errors property="telszam" /></font></td>
	</tr>

	<tr>
		<td>Ir�ny�t�sz�m:<font color="red">*</font></td>
		<td><input type="text" name="irszam" id="irszam" value="${irszam_ }" /><br/><font size="2" color="red"><html:errors property="irszam" /></font></td>
		<td>V�ros:<font color="red">*</font></td>
		<td><input type="text" name="varos" id="varos" value="${varos_ }" /><br/><font size="2" color="red"><html:errors property="varos" /></font></td>
	</tr>

	<tr>
		<td>Utca:<font color="red">*</font></td>
		<td><input type="text" name="utca" id="utca" value="${utca_ }" /><br/><font size="2" color="red"><html:errors property="utca" /></font></td>
		<td>H�zsz�m:<font color="red">*</font></td>
		<td><input type="text" name="hazszam" id="hazszam" value="${hazszam_ }" /><br/><font size="2" color="red"><html:errors property="hazszam" /></font></td>
	</tr>
	
	<tr>
		<td>Emelet/Ajt�:</td>
		<td><input type="text" name="emeletajto" id="emeletajto"  value="${ajto_ }"/><br/><font size="2" color="red"><html:errors property="emeletajto" /></font></td>
		<td>Email:<font color="red">*</font></td>
		<td><input type="text" name="email" id="email" value="${email_ }" /><br/><font size="2" color="red"><html:errors property="email" /></font></td>
	</tr>
	<tr>
	<td>T�rzsv�s�rl�i k�rtya sz�ma:</td>
		<td><input type="text" name="tk" id="tk" value="${tk_ }" /></td>
	
	</tr>

	<tr>
		<td>Fizet�s m�dja:<font color="red">*</font></td>
		<td colspan="3"><input type="radio" name="fm" id="fm" value="posta" />Postai Ut�nv�tel<input
			type="radio" name="fm" id="fm" value="futar" />DPD fut�rszolg�lat<input type="radio"
			name="fm"  id="fm" value="boltban" />Bolti �tv�tel<br/><font size="2" color="red"><html:errors property="fm" /></font></td>
	</tr>

	<tr>
		<td>Megjegyz�s:</td>
		<td colspan="3"><textarea cols="50" rows="10" name="megjegyzes"
			id="megjegyzes" >${megjegyzes_ }</textarea></td>
	</tr>

	<tr>
		<td colspan="4" align="center"><input type="submit"
			value="Elk�ld"/></td>
	</tr>
</table>
</form>

