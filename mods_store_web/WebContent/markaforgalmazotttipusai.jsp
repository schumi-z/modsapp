<%@ include file="taglibs.jsp"%>

<h2>${markanev}</h2><br/><br/>

<table align="center">

<c:if test="${requestScope.size==0}"><p align="center">Jelenleg nem forgalmazunk ilyen term�ket<br/> K�rlek n�zz vissza k�s�bb</p></c:if>

<logic:iterate id="mkt" name="kaphatoTipusok">
	<c:url value="/markakaphatotermekei.do" var="mkti">
				<c:param name="tipusId" value="${mkt.id}" />
	</c:url>
<tr><td><a href='<c:out value="${mkti}" />' title="${mkt.nev}" onmouseout="document.but${mkt.id}.src='images/tipusok/${mkt.inaktivKepUrl}'" onmouseover="document.but${mkt.id}.src='images/tipusok/${mkt.aktivKepUrl}'"><img  name="but${mkt.id}" src="images/tipusok/${mkt.inaktivKepUrl}"  width="400" height="70" /></a></td></tr>
</logic:iterate>
</table>
<h2> M�rkaismertet&#337 </h2>
${markaIsmerteto}