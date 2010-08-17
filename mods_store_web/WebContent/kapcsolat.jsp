
 <script src="http://maps.google.com/maps?file=api&v=1&key=
ABQIAAAATZzeE8tqGGCI0RLKHTcQZxQdOWmCdk4BtsIPUB1sYEYF7TAyAhQhKU_IOf_yC_VSS2We2ebenJMoWw" type="text/javascript"></script>
		
		<script type="text/javascript">
	    //<![CDATA[
	    	var map = null;
		    var geocoder = null;
		    	
			function load() {
				if (GBrowserIsCompatible()) {
					map = new GMap2(document.getElementById("map"));
					map.setCenter(new GLatLng(47.533052, 21.622295), 15); //ca terkep kozeppontja
					
					geocoder = new GClientGeocoder();
					
					//Jelolok tombje
					var waterParks = [];
					waterParks.push(['Mods Office','Hal k�z 7, 4025']);
					
					if (geocoder) {
						for (var i = 0; i < waterParks.length; i++) {
							plotAddress(waterParks[i]);
						}		        			        	
					}	
										
					map.addControl(new GLargeMapControl());
				}
			}
					
			function plotAddress(waterPark) {
				//waterPark[1] = water park address
				geocoder.getLatLng(waterPark[1], function(point) {
					if (point) {
												
						var marker = new GMarker(point);
						
						GEvent.addListener(marker, "click", function() {			        
						  //waterPark[0] = water park name
						  marker.openInfoWindowHtml('<h2>'+waterPark[0]+'</h2>');
						});		  
						            
						map.addOverlay(marker);
					}
				});
			}
	    //]]>				
		</script>

<h2>Kapcsolat</h2>

<p align="center">Amennyiben a honlapon tal�lhat� term�kekkel kapcsolatban valamilyen k�rd�sed lenne, esetleg olyan dolgot szeretn�l rendelni, ami �ppen nem tal�lhat� az �ruh�zban, k�rj�k jelezd!
MODS STORE CREW</p>

<div style="margin-left: 30%;">
<p><a href="http://iwiw.hu/pages/community/comdata.jsp?cID=1674702"><img src="images/_kapcsolat/iwiw.jpg" width="150" height="100"/></a></p>
<p><a href="http://www.myspace.com/modsstore"><img src="images/_kapcsolat/myspacelogo.jpg" width="150" height="100"/></a></p>
<p><a href="http://www.facebook.com/pages/The-Mods-Store-Streetwear/263486371596?v=wall#/pages/The-Mods-Store-Streetwear/263486371596?ref=mf"><img src="images/_kapcsolat/facebook.jpg" width="150" height="100"/></a></p>
</div>

<h2>El�rhet&#337s�g�nk</h2>
<p><b>A bolt a Hal K�zben tal�lhat� a belv�rosban!</b></p>
<p><b>Az elad� adatai:</b><br/><br/>

Az �ltalad v�s�rolt �ruk elad�ja a Mods Store Streetwear Kft.<br/>

C�m: 4031 Debrecen, Szoboszl�i �t 30.<br/>

C�gjegyz�ksz�m: 09-09-016011<br/>

Ad�sz�m: 14553226-2-09<br/>

Telefonsz�m: 06 52 403-308<br/>

Fax: 06 52 403-308<br/>

E-mail: <a href="mailto:mscclothing@gmail.com">mscclothing@gmail.com</a><br/>

</p>


<div id="map" style="width: 500px; height: 400px; margin-left: 10%;"></div>
    

	
