<%@ include file="taglibs.jsp"%>

<script type="text/javascript">
getLatestItemFunction("GetLatestItemServlet","ajaX");
</script>


<div id="separator">   
<p>L�togat�k sz�ma:</p>
<p>${latogatokszama}</p>
</div>
<div id="separator">
<p>Hirlev�l</p>
<html:form action="feliratkozik.do" method="post">

	<table>
		<tr>
			<td>Email cim:</td>
		</tr>
		<tr>	
			<td><html:text property="email" styleId="beviteli"/></td>
		</tr>
		<tr>
		<td><font size="1" color="red"><html:errors property="email" /></font></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><html:submit value="Feliratkoz�s"/></td>
		</tr>
	</table>
</html:form>
</div>

<div id="separator">
<p>Legfrissebb termekek</p>
<div id="latest" >
</div>

</div>

<div   style="height: 400px;"><marquee direction="down" height="100%" truespeed="truespeed" behavior="scroll" ><img src="images/shl.gif"/></marquee></div>

