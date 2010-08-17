<%@ include file="taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Mods Store </title>

<link rel="stylesheet" type="text/css" href="css/welcomescreen.css">
<c:url value="/mainpage.do" var="mainpage"></c:url>
</head>
<body>
<!--  <div><img src="images/welcomeline_bg.jpg" width="480" align="center"></div>		-->
  <div id="main" style="width: 480px; height: 300px;">
  <div id="innerLogo"><img src="images/modsstore_logo_bb.jpg" width="200" height="200"></div>
  <div id="innerButton"><a href='<c:out value="${mainpage}" />'><img src="images/belepes_Btn_white.jpg" width="100" height="70" border="0"></a></div>
	</div>
</body>
</html>