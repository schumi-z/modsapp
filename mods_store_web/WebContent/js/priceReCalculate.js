
/* Ajax XmlHttpRequest object creator JS function
 * @author Pistar Zoltan
 * */
function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");  // For Microsoft IE 6.0+
     
     }
     catch (e2) {
       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}
 
var xmlhttp = new getXMLObject();	//xmlhttp holds the ajax object

/*recalculate JS function*/
function reCalculatePrice(count, itemId) {
  if(xmlhttp) { 

    xmlhttp.open("POST","UpdateCartContent",true); //getname will be the servlet name
    xmlhttp.onreadystatechange  = handleServerResponse;
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("count=" + count.value+"&itemId="+itemId); //Posting params to Servlet
  }
}

/*Ajax request handler function, update cart content on UI*/
function handleServerResponse() {
   if (xmlhttp.readyState == 4) {

	 
	   var result = xmlhttp.responseText;
	   
//	   alert(result);
	   
	   var content = new Array();

   		for (var i=0; i<2; i++)
   		{
       	content.push(result.substring(0, result.indexOf(' ')));
       	result = result.substring(result.indexOf(' ')+1, result.length);
       	}
   		
   		content.push(result);
	   
	  
       document.getElementById(content[0]+"X").innerHTML = content[1];
       
       document.getElementById('sum').innerHTML = content[2];
      
   }
}



