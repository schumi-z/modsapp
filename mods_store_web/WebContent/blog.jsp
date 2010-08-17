<%@ include file="taglibs.jsp"%>

<script language="javascript">
			<!--
			$(document).ready(
				function (){
					$("#imggal").PikaChoose();
				});
			-->
		</script>

<div>

<c:forEach var="index" begin="${ 0 }" end="${ lastIndex - firstIndex }" step="1">
	<jsp:include page="blog_content/blog_${lastIndex - index}.html" />
</c:forEach>

<!--
<br/>
${firstIndex} ${lastIndex}<br/>
${firstPage} ${prevPage} ${nextPage} ${lastPage}<br/>
-->
<br/><br/>
<p style="margin-left: 40%;">
<c:if test="${page != 0}">
	<c:url value="/hirek.do" var="blog">
		<c:param name="page" value="0"></c:param>
	</c:url>
	<a href="${blog}">&lt;&lt;</a>
	
	<c:url value="/hirek.do" var="blog">
		<c:param name="page" value="${page - 1}"></c:param>
	</c:url>
	<a href="${blog}">&lt;</a>
</c:if>
&nbsp;&nbsp;${page + 1}. oldal&nbsp;&nbsp;
<c:if test="${page != lastPage}">
	<c:url value="/hirek.do" var="blog">
		<c:param name="page" value="${page + 1}"></c:param>
	</c:url>
	<a href="${blog}">&gt;</a>
	
	<c:url value="/hirek.do" var="blog">
		<c:param name="page" value="${lastPage}"></c:param>
	</c:url>
	<a href="${blog}">&gt;&gt;</a>
</c:if>
</p>