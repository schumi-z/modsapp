<%@ include file="taglibs.jsp"%>
   
<c:url value="/aktualis.do" var="aktualis"></c:url>
<c:url value="/boltunkrol.do" var="boltunkrol"></c:url>
<c:url value="/markak.do" var="shop"></c:url>
<c:url value="/hirek.do" var="hirek"></c:url>
<c:url value="/koncertek.do" var="koncertek"></c:url>
<c:url value="/linkek.do" var="linkek"></c:url>
<c:url value="/kapcsolat.do" var="kapcsolat"></c:url>
<c:url value="/adminpage.do" var="admin"></c:url>
<c:url value="/tudnivalok.do" var="tudnivalok"></c:url>
<c:url value="/underground.do" var="underground"></c:url>
<c:url value="/forum.do" var="forum"></c:url>

<c:url value="/hirlevel.do" var="hirlevel"></c:url>
<c:url value="/zenekarok.do" var="zenekarok"></c:url><!-- hamarosan -->
<c:url value="/baratok.do" var="baratok"></c:url><!-- hamarosan -->
<c:url value="/mscclothing.do" var="mscclothing"></c:url>


<div id="menu">
<table width="100%" id="topmenu">
<tr>
<td>
<ul>
<li><a href='<c:out value="${aktualis}" />'>.::Aktu�lis::.</a></li>
<li><a href='<c:out value="${boltunkrol}" />'>.::Boltunkr�l::.</a></li>
<li><a href='<c:out value="${shop}" />'>.::Shop::.</a></li>
<li><a href='<c:out value="${tudnivalok}" />'>.::Tudnival�k::.</a></li>
<li><a href='<c:out value="${hirek}" />'>.::Blog::.</a></li>
<li><a href='<c:out value="${koncertek}" />'>.::Koncertek::.</a></li>
<li><a href='<c:out value="${linkek}" />'>.::Linkek::.</a></li>
</ul>
</td>
</tr>
</table>

<table width="100%" id="bottommenu">
<tr>
<td>
<ul>
<li><a href='<c:out value="${kapcsolat}" />'>.::Kapcsolat::.</a></li>
<li><a href='<c:out value="${underground}" />'>.::UnderGround::.</a></li>
<li><a href='<c:out value="${forum}" />'>.::F�rum::.</a></li>
<li><a href='<c:out value="${hirlevel}" />'>.::H�rlev�l::.</a></li>
<li><a href='<c:out value="${zenekarok}" />'>.::Zenekarok::.</a></li>
<li><a href="http://www.modsstore.hu/markaforgalmazotttipusai.do?markaId=65">.::MSC Clothing::.</a></li>
<li><a href='<c:out value="${baratok}" />'>.::Bar�taink::.</a></li>
</ul>
</td>
</tr>
</table>
</div>
