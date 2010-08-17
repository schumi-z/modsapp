<%@ include file="taglibs.jsp"%>

<c:forEach var="index" begin="${ 0 }" end="${ lastIndex - firstIndex }" step="1">
	<jsp:include page="aktualis_content/aktualis_${lastIndex - index}.html" />
</c:forEach>

<script type="text/javascript">

function popup(url) 
{
 var width  = 400;
 var height = 400;
 var left   = (screen.width  - width)/2;
 var top    = (screen.height - height)/2;
 var params = 'width='+width+', height='+height;
 params += ', top='+top+', left='+left;
 params += ', directories=no';
 params += ', location=no';
 params += ', menubar=no';
 params += ', resizable=no';
 params += ', scrollbars=no';
 params += ', status=no';
 params += ', toolbar=no';
 newwin=window.open(url,'KellemesKaracsonyiUnnepeket', params);
 if (window.focus) {newwin.focus();}
 return false;
}


//popup('karacsony.html');
//popup('aktualispopup.html');

</script>
<!--
<br/>
${firstIndex} ${lastIndex}<br/>
${firstPage} ${prevPage} ${nextPage} ${lastPage}<br/>
-->
<br/><br/>
<p style="margin-left: 40%;">
<c:if test="${page != 0}">
	<c:url value="/aktualis.do" var="aktualis">
		<c:param name="page" value="0"></c:param>
	</c:url>
	<a href="${aktualis}">&lt;&lt;</a>
	
	<c:url value="/aktualis.do" var="aktualis">
		<c:param name="page" value="${page - 1}"></c:param>
	</c:url>
	<a href="${aktualis}">&lt;</a>
</c:if>
&nbsp;&nbsp;${page + 1}. oldal&nbsp;&nbsp;
<c:if test="${page != lastPage}">
	<c:url value="/aktualis.do" var="aktualis">
		<c:param name="page" value="${page + 1}"></c:param>
	</c:url>
	<a href="${aktualis}">&gt;</a>
	
	<c:url value="/aktualis.do" var="aktualis">
		<c:param name="page" value="${lastPage}"></c:param>
	</c:url>
	<a href="${aktualis}">&gt;&gt;</a>
</c:if>
</p>
