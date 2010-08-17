<%@ include file="taglibs.jsp"%>



<style type="text/css">
#carticon {
	width: 50px;
	height: 50px;
	margin-left: 10px;
	padding: 0;
	border: 0;
	background: transparent url('images/addToCart.gif') no-repeat top left;
	text-indent: -1000em;
	vertical-align: middle;
	cursor: pointer; /* hand-shaped cursor */
	cursor: hand; /* IE 5.x */
}
</style>

<script type="text/javascript" src="js/jquery.tools.min.js"></script>

<c:url value="/kosarbatesz.do" var="kosartartalom"></c:url>

<c:url value="/kosarbatesz.do" var="kosarbatesz"></c:url>


<h2>Termékeink a márkából:</h2>

<table width="100%">


	<logic:iterate id="termek" name="termekek">

		<tr>
			<td>

				<a href='<c:out value="images/${termek.kepUrl}"/>' rel="#overlayX" title="Termék">


				<object data="images/${termek.kepUrl}" width="100"
				height="100" border="0"> <img src="images/noimage.jpg" width="100"
					height="100" border="0" > </object>
			</a></td>
			<td>
			<table>
				<tr>
					<td><b>Megnevezés:</b> ${termek.nev}</td>
				</tr>
				<tr>
					<td><b>Termékkód: </b>${termek.termekkod}</td>
				</tr>
				<tr>
					<td><b>Típus: </b>${termek.tipus.nev}</td>
				</tr>
				<tr>
					<td> 
						<b>Méretek: </b>
						<logic:iterate id="meret" collection="${termek.meretek}" type="hu.modsstore.model.dto.Meret" >
								${meret.meret}
						</logic:iterate>
						
					</td>
				</tr>
				<tr>
					<td><b>Szín: </b>${termek.leiras}</td>
				</tr>
				<tr>
					<td><b>Egysegár: </b>${termek.egysegar}</td>
				</tr>
			</table>
			</td>

			<td>
			<form action="${kosarbatesz}" method="post"><input
				type="hidden" name="termekId" id="termekId" value="${termek.id}" />
			<table>
				<tr>
					<td>Válassz méretet: <select id="size" name="size">
						<logic:iterate id="meret" collection="${termek.meretek}" type="hu.modsstore.model.dto.Meret">
						<option value="${meret.meret}">${meret.meret}</option>
						</logic:iterate>
					</select></td>
				</tr>
				<tr>
					<td>
					<button type="submit" id="carticon" title="Kosarba tesz">Kuld</button>
					</td>
					<td align="right" colspan="4"><a
						href='<c:out value="${kosartartalom}" />' title="Kosaram tartalma" /><img
						src="images/cartContent.gif" width="50" height="50"
						alt="Kosár aktuális tartalma" border="0" /></a></td>
				</tr>
			</table>
			</form>
			</td>
		</tr>
		<tr>
			<td colspan="10" style="border-bottom: thin solid #000000;"></td>
		</tr>




	</logic:iterate>

</table>

<c:set var="actPage" value="${sessionScope.actPage}"/>
<c:set var="maxNumPage" value="${sessionScope.numberOfPages}"/>


<table align="center">
	<tr>
		<td><input type="hidden" value="${actPage}" name="actPageHidden" id="actPageHidden"/></td>
		<td><input type="hidden" value="${maxNumPage}" name="maxNumPageHidden" id="maxNumPageHidden"/></td>
		<td>
		<form action="first.do"><input type="submit" value="<<"" id="fBtn" name="fBtn"/></form>
		</td>
		<td>
		<form action="back.do"><input type="submit" value="<"" id="bBtn" name="bBtn"/></form>
		</td>
		<td>
	<table align="center">
			<tr>

				
				<c:if test="${actPage-10 > 0}">
				
				<td>
		
				<c:url value="/jumtopage.do" var="jump10Minus"><c:param name="actPage" value="${actPage-10}"/></c:url>
				
				<a href='<c:out value="${jump10Minus}" />'> <c:out value="${actPage-10}"/>
 				</a></td>
				<td>.....</td>
				</c:if>

				<c:if test="${actPage-3 > 0}">
					<td>
					<c:url value="/jumtopage.do" var="jump3Minus"><c:param name="actPage" value="${actPage-3}"/></c:url>
					<a href='<c:out value="${jump3Minus}" />'> <c:out value="${actPage-3}"/></a>
					</td>
				</c:if>

				<c:if test="${actPage-2 > 0}">
					<td>
					<c:url value="/jumtopage.do" var="jump2Minus"><c:param name="actPage" value="${actPage-2}"/></c:url>
					<a href='<c:out value="${jump2Minus}" />'> <c:out value="${actPage-2}"/></a>
					</td>
				</c:if>

				<c:if test="${actPage-1 > 0}">
					<td>
					<c:url value="/jumtopage.do" var="jump1Minus"><c:param name="actPage" value="${actPage-1}"/></c:url>
					<a href='<c:out value="${jump1Minus}" />'> <c:out value="${actPage-1}"/></a>
					</td>
				</c:if>


				<td>
				<c:url value="/jumtopage.do" var="jumpAct"><c:param name="actPage" value="${actPage}"/></c:url>
				<a
					href='<c:out value="${jumpAct}" />'> <c:out value="${actPage}"/>
 				</a></td>


				<c:if test="${actPage+1 <= maxNumPage}">
					<td>
					<c:url value="/jumtopage.do" var="jump1Plus"><c:param name="actPage" value="${actPage+1}"/></c:url>
					<a href='<c:out value="${jump1Plus}" />'> <c:out value="${actPage+1}"/></a>
					</td>
				</c:if>

				<c:if test="${actPage+2 <= maxNumPage}">
					<td>
					<c:url value="/jumtopage.do" var="jump2Plus"><c:param name="actPage" value="${actPage+2}"/></c:url>
					<a href='<c:out value="${jump2Plus}" />'> <c:out value="${actPage+2}"/></a>
					</td>
				</c:if>

				<c:if test="${actPage+3 <= maxNumPage}">
					<td>
					<c:url value="/jumtopage.do" var="jump3Plus"><c:param name="actPage" value="${actPage+3}"/></c:url>
					<a href='<c:out value="${jump3Plus}" />'> <c:out value="${actPage+3}"/></a>
					</td>
				</c:if>

				<c:if test="${actPage+10 <= maxNumPage}">
					<td>.....</td>
					<td>
					<c:url value="/jumtopage.do" var="jump10Plus"><c:param name="actPage" value="${actPage+10}"/></c:url>
					<a href='<c:out value="${jump10Plus}" />'> <c:out value="${actPage+10}"/></a>
					</td>
				</c:if>

			</tr>
		</table>
		</td>
		<td>
		<form action="next.do"><input type="submit" value=">" id="nBtn" name="nBtn"/></form>
		</td>
		<td>
		<form action="last.do"><input type="submit" value=">>" id="lBtn" name="lBtn"/></form>
		</td>
	</tr>

	<tr>
		<td colspan="10" align="center"><font color="#000099"> <b>
		<c:out value="${sessionScope.actPage}"/>
		 / 
		 <c:out value="${sessionScope.numberOfPages}"/>
		 </b> </font></td>
	</tr>
</table>

<!-- picture overlay -->
<div class="overlay" id="overlay">

	<!-- fund image come here -->
	<div class="wrap"></div>

</div>

<!-- make all links with the 'rel' attribute open overlays -->
<script type="text/javascript">

setControllerBtn();

$(function() {

	// if the function argument is given to overlay, it is assumed to be the onBeforeLoad event listener
	$("a[rel]").overlay(function() {

		// grab wrapper element inside content
		var wrap = this.getContent().find("div.wrap");

		// load only every time it is opened
		
			wrap.load(this.getTrigger().attr("href"));
		
	});
});

</script>

