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
		<th>Név</th>
		<th>Rendelési id&#337</th>
		<th>Kártyaszám</th>
		<th>Darabszám</th>
		<th>Összeg</th>
		<th>Törlés</th>
	</tr>
	
	<c:set var="index" value="0" />
	
	<logic:iterate id="rendeles" name="rendelesek">
	
		<c:set var="totalPrice" value="0" />
		<c:set var="raktarak" value="${ rendeles.raktarak }" />
		<logic:iterate id="raktar" name="raktarak">
			<c:set var="totalPrice" value="${ totalPrice + raktar.darabszam * raktar.termek.egysegar }" />
		</logic:iterate>
		
		<c:url value="/torolrendeles.do" var="torol">
			<c:param name="id" value="${ rendeles.rendeles.id }"></c:param>
			<c:param name="from" value="teljesitett"></c:param>
		</c:url>
	
		<tr>
			<td><a onclick="vis(${index});">${ rendeles.rendeles.nev }</a></td>
			<td>
				 <fmt:formatDate value="${ rendeles.rendeles.rendelesiIdo }" type="both"
              		timeStyle="short" dateStyle="short" />
			
			</td>
			<td>${ rendeles.rendeles.kartyaszam }</td>
			<td>${ rendeles.osszdarabszam }</td>
			<td>${ totalPrice }</td>
			<td><a href='<c:out value="${torol}"/>'>[Töröl]</a></td>
		</tr>
		
		<tr style="display: none;" id="id${index}">
			<td colspan="5"><table width="100%">
				<tr>
					<th>Név:</th>
					<td>${ rendeles.rendeles.nev }</td>
					<th>Irányítószám:</th>
					<td>${ rendeles.rendeles.iranyitoszam }</td>
				</tr>
				
				<tr>
					<th>Kártyaszám:</th>
					<td>${ rendeles.rendeles.kartyaszam }</td>
					<th>Város:</th>
					<td>${ rendeles.rendeles.varos }</td>
				</tr>
				
				<tr>
					<th>Telefonszám:</th>
					<td>${ rendeles.rendeles.telefonszam }</td>
					<th>Utca:</th>
					<td>${ rendeles.rendeles.utca }</td>
				</tr>
				
				<tr>
					<th>Email:</th>
					<td>${ rendeles.rendeles.email }</td>
					<th>Házszám:</th>
					<td>${ rendeles.rendeles.hazszam }</td>
				</tr>
				
				<tr>
					<th>Fizetési mód:</th>
					<td>${ rendeles.rendeles.fizetesiMod }</td>
					<th>Emelet, ajtó:</th>
					<td>${ rendeles.rendeles.emeletAjto }</td>
				</tr>
				
				<tr>
					<th>Megjegyzés:</th>
					<td colspan="3">${ rendeles.rendeles.megjegyzes }</td>
				</tr>
				
				<tr>
					<th>Terméknév</th>
					<th>Termékkód</th>
					<th>Méret</th>
					<th>Darabszám</th>
					<th>Egységár</th>
					<th>Összeg</th>
				</tr>
				
				<c:set var="raktarak" value="${ rendeles.raktarak }" />
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

<table>
	<tr>
	
		<td>
			<html:form action="/teljesitettrendelesekadmin" method="post" enctype="multipart/form-data">
				<html:hidden property="pageIndex" value="0" />
				<c:choose>
					<c:when test="${ page == 0 }">
						<html:submit value="&lt&lt" disabled="true" />
					</c:when>
					<c:otherwise>
						<html:submit value="&lt&lt" />
					</c:otherwise>
				</c:choose>
			</html:form>
		</td>
	
		<td>
			<html:form action="/teljesitettrendelesekadmin" method="post" enctype="multipart/form-data">
				<html:hidden property="pageIndex" value="${ page - 1 }" />
				<c:choose>
					<c:when test="${ page == 0 }">
						<html:submit value="&lt" disabled="true" />
					</c:when>
					<c:otherwise>
						<html:submit value="&lt" />
					</c:otherwise>
				</c:choose>
			</html:form>
		</td>
		
		<td>
			${ page + 1 } / ${ total }
		</td>
		
		<td>
			<html:form action="/teljesitettrendelesekadmin" method="post" enctype="multipart/form-data">
				<html:hidden property="pageIndex" value="${ page + 1 }" />
				<c:choose>
					<c:when test="${ page == total - 1 or total == 0 }">
						<html:submit value="&gt" disabled="true" />
					</c:when>
					<c:otherwise>
						<html:submit value="&gt" />
					</c:otherwise>
				</c:choose>
			</html:form>
		</td>
		
		<td>
			<html:form action="/teljesitettrendelesekadmin" method="post" enctype="multipart/form-data">
				<html:hidden property="pageIndex" value="${ total - 1 }" />
				<c:choose>
					<c:when test="${ page == total - 1  or total == 0}">
						<html:submit value="&gt&gt" disabled="true" />
					</c:when>
					<c:otherwise>
						<html:submit value="&gt&gt" />
					</c:otherwise>
				</c:choose>
			</html:form>
		</td>
		
	</tr>
</table>

</logic:present>

<logic:notPresent name="rendelesek">
Nincsenek rendelések.
</logic:notPresent>