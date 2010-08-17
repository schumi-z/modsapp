<%@ include file="taglibs.jsp"%>
<%@page import="hu.modsstore.webshop.CartItem"%>

<c:url value="/torol.do" var="torol"></c:url>
<c:url value="/kasszahoz.do" var="kasszahoz"></c:url>

<link type="text/css" href="css/cartstyle.css" rel="stylesheet" />

<body>

<h2>Az ön kosarának tartalma:</h2><br/><br/>

<form action='<c:out value="${torol}" />' method="post">
<table width="100%" id="cartTable">
	<thead>
	
	<tr>
		<th scope="col">Töröl</th>
		<th scope="col">Neve/Leirása</th>
		<th scope="col">Méret</th>
		<th scope="col">Mennyiség (db)</th>
		<th scope="col">Teljes / Egységár (Huf)</th>
	</tr></thead>
	<tbody>
		<c:set var="counter" value="0" scope="page"></c:set>
		<logic:iterate id="termek" name="sc" property="cart">
			<tr>

				<td id="cbox"><input type="checkbox" name="selected"
					value="<bean:write name="termek" property="itemID"/>"
					id="${counter+1}" onclick="enableOrDisableDeleteBtn();" /></td>
				<td id="itemName"><bean:write name="termek" property="itemName" /></td>
				<td id="sizelab"><label><bean:write name="termek" property="size" /></label></td>
				<td id="count"><input type="text"
					value="<bean:write name="termek" property="count"/>"
					onblur="reCalculatePrice(this,<bean:write name="termek" property="itemID"/>);" />
				</td>
				<td><label id="<c:out value="${termek.itemID}X"/>"><bean:write
					name="termek" property="totalPrice" /></label> / <bean:write name="termek"
					property="itemPrice" /></td>




			</tr>
			<c:set var="counter" value="${counter+1}" />
		</logic:iterate>
	</tbody>

</table>

<input type="hidden" id="countNum" value="${counter}">

<table>
	<tr>
		<td>
		<form><input type="submit" value="Töröl" id="deletBtn" /></form>
		</td>
		<td>
		<form action='<c:out value="${kasszahoz}" />'><input
			type="submit" value="Fizet" id="payBtn" /></form>
		</td>
		
	</tr>
</table>
</form><br/>
Összesen:
<label id="sum">${sc.totalPrice}</label>
Huf
<br/>
<c:choose>
					<c:when test="${!empty tipusId}">
					<a href="markakaphatotermekei.do?tipusId=${tipusId}">Vissza</a>
					</c:when>
					<c:otherwise>
					<a href="markak.do">Vissza</a>	
					</c:otherwise>
			</c:choose>
<br/>
<script type="text/javascript">

disableDeleteBtn();

</script>
</body>