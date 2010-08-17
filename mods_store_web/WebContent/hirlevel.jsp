<%@ include file="taglibs.jsp"%>

<script type="text/javascript">

function alertBox(msg){

	$(document).ready( function() {
		jAlert(msg+'!', 'Info');
	});
	
}

</script>




<logic:present name="feliratkozas_sikeres">
	<script type="text/javascript">alertBox('Sikeresen feliartkozott h�rlevel�nkre!');</script>
</logic:present>

<logic:present name="mar_olvasonk">
	<script type="text/javascript">alertBox('�n m�r olvas�ja h�rlevel�nknek!');</script>
</logic:present>

<logic:present name="leliratkozas_sikeres">
	<script type="text/javascript">alertBox('Sikeresen leiratkozott hirlevel�nkr�l!');</script>
</logic:present>

<logic:present name="on_mar_leiratkozott">
	<script type="text/javascript">alertBox('�n m�r kor�bban leiratkozott h�rlevel�nkr�l vagy nem is volt olvas�nk');</script>
</logic:present>

	
<h2>Mods Store H�rlv�l!</h2>
<p>
	�ratkozz fel h�rlevel�nkre, hogy els&#337 k�zb&#337l �rtes�lhess a legfrisebb term�keinkr&#337l, rendezv�nyeinkr&#337l.
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
			<td colspan="2" align="center"><html:submit value="Feliratkoz�s" /></td>
		</tr>
	</table>
</html:form>
