<%@ include file="taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title><tiles:getAsString name="title" ignore="true" /></title>

<script src="js/kosar.js" type="text/javascript"></script>
<script src="js/priceReCalculate.js" type="text/javascript"></script>
<script src="js/paging.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<script type="text/javascript" src="js/body_left_ajax.js"></script>


<link type="text/css" href="css/test.css" rel="stylesheet" />



<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/imagegal-min.js"></script>


<!-- Cookie check -->
<script type="text/javascript">
	var tmpcookie = new Date();
	chkcookie = (tmpcookie.getTime() + '');
	document.cookie = "chkcookie=" + chkcookie + "; path=/";
	if (document.cookie.indexOf(chkcookie, 0) < 0) {
		alert("Please enable cookies at your browser's settings in order to use all function of this application");
	}
</script>

<meta name="keywords" content="Debrecen, Debrecen Halköz, Mods Store, Streetwear, Mods Office, Alpha Industries Inc, Hooligan, UnderGround Debrecen, BenLee, Lonsdale Debrecen">

<meta name="description" content="Mods Store Shop">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" >
<link rel="icon" href="images/favicon.ico" type="image/x-icon">

</head>

<body style="background: #000000 url('images/hatter.jpg') repeat-y fixed center top; background-attachment:fixed;" onload="load();" onunload="GUnload();">



<table border="0" cellpadding="0" cellspacing="0" style="background-color: white;"
	align="center" width="750" height="auto">
	<tr>
		<td width="100%" colspan="4" valign="top" height="10%"><tiles:insert
			attribute="header" /></td>

	</tr>
	<tr id="menu">
		<td width="100%" height="5%" valign="middle" colspan="4"><tiles:insert
			attribute="menu" /></td>
	</tr>
	<tr>
		<td width="50px" valign="top" height="84%"
			id="bodyLeft"><tiles:insert
			attribute="leftbody" /></td>

		<td width="700px" valign="top" height="84%" id="mainpanel">
		<tiles:insert attribute="body" />
		</td>
	</tr>
	<tr>
		<td width="100%" colspan="4" valign="bottom" height="1%"><tiles:insert
			attribute="footer" /></td>
	</tr>
</table>

</body>

</html>