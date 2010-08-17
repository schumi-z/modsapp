<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>
<hr>

<script type="text/javascript">

function vis(index){
	var td = document.getElementById('id' + index);
	if (td.style.display == "") {
		td.style.display = "none";
	} else {
		td.style.display = "";
	}
}

</script>

<logic:present name="rendelesek">

<table width="100%" border="1px">
	<tr>
		<th>N�v</th>
		<th>Rendel�si id&#337</th>
		<th>K�rtyasz�m</th>
		<th>Darabsz�m</th>
		<th>�sszeg</th>
		<th>Teljes�t</th>
		<th>T�rl�s</th>
	</tr>
	
	<c:set var="index" value="0" />
	
	<logic:iterate id="rendeles" name="rendelesek">
	
		<c:url value="/teljesit.do" var="teljesit">
			<c:param name="id" value="${ rendeles.rendeles.id }"></c:param>
		</c:url>
		
		<c:url value="/torolrendeles.do" var="torol">
			<c:param name="id" value="${ rendeles.rendeles.id }"></c:param>
			<c:param name="from" value="teljesitetlen"></c:param>
		</c:url>
	
		<c:set var="total" value="0" />	
		<c:set var="raktarak" value="${ rendeles.raktarak }" />
		<logic:iterate id="raktar" name="raktarak">
			<c:set var="total" value="${ total + raktar.darabszam * raktar.termek.egysegar }" />
		</logic:iterate>
	
		<tr>
			<td><a onclick="vis(${index});">${ rendeles.rendeles.nev }</a></td>
			<td>
				 <fmt:formatDate value="${ rendeles.rendeles.rendelesiIdo }" type="both"
              		timeStyle="short" dateStyle="short" />
			
			</td>
			<td>${ rendeles.rendeles.kartyaszam }</td>
			<td>${ rendeles.osszdarabszam }</td>
			<td>${ total }</td>
			<td><a href='<c:out value="${teljesit}" />'>[Teljes�t]</a></td>
			<td><a href='<c:out value="${torol}"/>'>[T�r�l]</a></td>
		</tr>
		
		<tr style="display: none;" id="id${index}">
			<td colspan="6"><table width="100%">
				<tr>
					<th>N�v:</th>
					<td>${ rendeles.rendeles.nev }</td>
					<th>Ir�ny�t�sz�m:</th>
					<td>${ rendeles.rendeles.iranyitoszam }</td>
				</tr>
				
				<tr>
					<th>K�rtyasz�m:</th>
					<td>${ rendeles.rendeles.kartyaszam }</td>
					<th>V�ros:</th>
					<td>${ rendeles.rendeles.varos }</td>
				</tr>
				
				<tr>
					<th>Telefonsz�m:</th>
					<td>${ rendeles.rendeles.telefonszam }</td>
					<th>Utca:</th>
					<td>${ rendeles.rendeles.utca }</td>
				</tr>
				
				<tr>
					<th>Email:</th>
					<td>${ rendeles.rendeles.email }</td>
					<th>H�zsz�m:</th>
					<td>${ rendeles.rendeles.hazszam }</td>
				</tr>
				
				<tr>
					<th>Fizet�si m�d:</th>
					<td>${ rendeles.rendeles.fizetesiMod }</td>
					<th>Emelet, ajt�:</th>
					<td>${ rendeles.rendeles.emeletAjto }</td>
				</tr>
				
				<tr>
					<th>Megjegyz�s:</th>
					<td colspan="3">${ rendeles.rendeles.megjegyzes }</td>
				</tr>
				
				<tr>
					<th>Term�kn�v</th>
					<th>Term�kk�d</th>
					<th>M�ret</th>
					<th>Darabsz�m</th>
					<th>Egys�g�r</th>
					<th>�sszeg</th>
				</tr>
				
				<logic:iterate id="raktar" name="raktarak">
					<tr>
						<td>${ raktar.termek.nev }</td>
						<td>${ raktar.termek.termekkod }</td>
						<td>${ raktar.meret.meret }</td>
						<td>${ raktar.darabszam }</td>
						<td>${ raktar.termek.egysegar }</td>
						<td>${ raktar.darabszam * raktar.termek.egysegar }</td>
					</tr>
				</logic:iterate>
				
			</table></td>
		</tr>
		
		<c:set var="index" value="${ index + 1 }" />
		
	</logic:iterate>
</table>

</logic:present>

<logic:notPresent name="rendelesek">
Nincsenek �j rendel�sek.
</logic:notPresent>
