<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>

<br/>
<br/>
A h�rlev�lre feliratkozottak list�ja.
<br/>
<br/>

<table border="1">
<logic:iterate id="feliratkozott" name="feliratkozottak">
	
	<tr>
		<td>
			${feliratkozott.emailCim}
		</td>
	</tr>
</logic:iterate>
</table>