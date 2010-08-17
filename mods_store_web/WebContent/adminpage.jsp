<%@ include file="taglibs.jsp"%>

<logic:present name="userdoesnotexist">
	<font color="red">Hibas felhasznalonev vagy jelszo!</font>
</logic:present>

<html:form action="/login.do" method="post">
<table border="0" style="margin: 20%;">
	<tr> 
		<td>Felhasználó név:</td>
		<td><input type="text" name="felhasznalonev" id="felhasznalonev" /></td>
	</tr>
	<tr>
		<td>Jelszó:</td>
		<td><input type="password" name="jelszo" id="jelszo" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Belep" /></td>
	</tr>
</table>

</html:form>
