<%@ include file="taglibs.jsp"%>

<script type="text/javascript">

function alertBox(msg){

	$(document).ready( function() {
		jAlert(msg+'!', 'Info');
	});
	
}

</script>




<logic:present name="feliratkozas_sikeres">
	<script type="text/javascript">alertBox('Sikeresen feliartkozott hírlevelünkre!');</script>
</logic:present>

<logic:present name="mar_olvasonk">
	<script type="text/javascript">alertBox('Ön már olvasója hírlevelünknek!');</script>
</logic:present>

<logic:present name="leliratkozas_sikeres">
	<script type="text/javascript">alertBox('Sikeresen leiratkozott hirlevelünkröl!');</script>
</logic:present>

<logic:present name="on_mar_leiratkozott">
	<script type="text/javascript">alertBox('Ön már korábban leiratkozott hírlevelünkröl vagy nem is volt olvasónk');</script>
</logic:present>

	
<h2>Mods Store Hírlvél!</h2>
<p>
	Íratkozz fel hírlevelünkre, hogy els&#337 kézb&#337l értesülhess a legfrisebb termékeinkr&#337l, rendezvényeinkr&#337l.
</p>

<html:form action="feliratkozik.do" method="post">

	<table style="margin-left: 30px;">
		<tr>
			<td>Email cim:</td>
			<td><html:text property="email" styleId="beviteli" /></td>
			
		</tr>
		<tr>
			<td colspan="2" align="center"><font size="1" color="red"><html:errors property="email" /></font></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><html:submit value="Feliratkozás" /></td>
		</tr>
	</table>
</html:form>
