<%@ include file="taglibs.jsp"%>
	
	<h2>Forgalmazott márkáink</h2>

	<c:url value="/kosarbatesz.do" var="kosarbatesz"></c:url>
	
	<a href='<c:out value="${kosarbatesz}" />' onmousemove="changeImage('addToCart'); return true;" onmouseout="changeImage('cartContent'); return true;"/><img src="images/cartContent.gif"  id="cartImg" width="40" height="40" align="right" border="0" /></a><br/>
		
		<c:set var="counter" value="1"></c:set>

		<table align="center">
		<tr>
		<td>
   		<logic:iterate id="marka" name="markak">

		<c:url value="/markaforgalmazotttipusai.do" var="mkti">
				<c:param name="markaId" value="${marka.id}" />
		</c:url>

		<a href='<c:out value="${mkti}" />'><img src="images/markak/${marka.kepUrl}" height="150" width="150"/></a>
		<c:if test="${counter % 3 == 0}"><br/></c:if>

		<c:set var="counter" value="${counter+1}"></c:set>

   		</logic:iterate>
		
		</td></tr>
		</table>
