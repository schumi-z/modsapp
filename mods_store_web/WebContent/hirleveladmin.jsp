<%@ include file="taglibs.jsp"%>

<%@ include file="adminlink.jsp"%>

<script type="text/javascript">

function alertBox(msg){

	$(document).ready( function() {
		jAlert(msg+'!', 'Info');
	});
	
}

</script>

<logic:present name="hirlevel_kezbesitve">
	<script type="text/javascript">alertBox('Hirlevél kézbesítve a feliratkozottaknak');</script>
</logic:present>

<hr>

<c:url value="/hirlevelkuldadmin.do" var="hirlevelkuldadmin"></c:url>

<!-- TinyMCE -->
<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="js/richtextarea.js"></script>
<!-- /TinyMCE -->

<div>
		<!-- Gets replaced with TinyMCE, remember HTML in a textarea should be encoded -->
		<div>

		<form action="${hirlevelkuldadmin}" method="post">
			<textarea id="hmessage" name="hmessage" rows="15" cols="60" style="width: 50%"></textarea>
			<input type="submit" name="save" value="Küld" />
			<input type="reset" name="reset" value="Reset" />
		</form>	
		</div>

		<!-- Some integration calls -->
<!--		<a href="javascript:;" onmousedown="tinyMCE.get('hmessage').show();">[Show]</a>-->
<!--		<a href="javascript:;" onmousedown="tinyMCE.get('hmessage').hide();">[Hide]</a>-->
<!--		<a href="javascript:;" onmousedown="tinyMCE.get('hmessage').execCommand('Bold');">[Bold]</a>-->
<!---->
<!--		<a href="javascript:;" onmousedown="alert(tinyMCE.get('hmessage').getContent());">[Get contents]</a>-->
<!--		<a href="javascript:;" onmousedown="alert(tinyMCE.get('hmessage').selection.getContent());">[Get selected HTML]</a>-->
<!--		<a href="javascript:;" onmousedown="alert(tinyMCE.get('hmessage').selection.getContent({format : 'text'}));">[Get selected text]</a>-->
<!--		<a href="javascript:;" onmousedown="alert(tinyMCE.get('hmessage').selection.getNode().nodeName);">[Get selected element]</a>-->
<!--		<a href="javascript:;" onmousedown="tinyMCE.execCommand('mceInsertContent',false,'<b>Hello world!!</b>');">[Insert HTML]</a>-->
<!--		<a href="javascript:;" onmousedown="tinyMCE.execCommand('mceReplaceContent',false,'<b>{$selection}</b>');">[Replace selection]</a>-->

		<br />
		
</div>
