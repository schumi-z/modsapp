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
       xmlHttp = false;   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}
 
var xmlhttpLatestItem = new getXMLObject();	//xmlhttp holds the ajax object
var xmlhttpNumberOfVisitors = new getXMLObject();

function getLatestItemFunction(servletName, tagId) {
  if(xmlhttpLatestItem) { 
	 xmlhttpLatestItem.open("GET",servletName,true); //call a servlet
	 xmlhttpLatestItem.onreadystatechange  = handleLatestItemServerResponse;
	 xmlhttpLatestItem.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	 xmlhttpLatestItem.send(null);
  }
}

function getNumberOfVisitors(servletName, tagId) {
	  if(xmlhttpNumberOfVisitors) { 
		  xmlhttpNumberOfVisitors.open("GET",servletName,true); //call a servlet
		  xmlhttpNumberOfVisitors.onreadystatechange  = handleNumberOfVisitorsServerResponse;
		  xmlhttpNumberOfVisitors.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		  xmlhttpNumberOfVisitors.send(null);
	  }
	}
 
function handleLatestItemServerResponse() {
   if (xmlhttpLatestItem.readyState == 4) {
     if(xmlhttpLatestItem.status == 200) {
    	 document.getElementById('latest').innerHTML=xmlhttpLatestItem.responseText; //Update the HTML Form element 
     }
     else {
        alert("Error during AJAX call. Please try again");
     }
   }
}

function handleNumberOfVisitorsServerResponse() {
	   if (xmlhttpNumberOfVisitors.readyState == 4) {
	     if(xmlhttpNumberOfVisitors.status == 200) {
	    	 document.getElementById('latogatok').innerHTML=xmlhttpNumberOfVisitors.responseText; //Update the HTML Form element 
	     }
	     else {
	        alert("Error during AJAX call. Please try again");
	     }
	   }
	}