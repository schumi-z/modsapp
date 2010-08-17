function disableDeleteBtn(){
	var deteteBtn = document.getElementById('deletBtn');

	var payBtn = document.getElementById('payBtn');
	
	deteteBtn.disabled=true;
	
	if (document.getElementById('1')==null)
	{
		payBtn.disabled = true;
	}else{
		payBtn.disabled = false;
	}

}

function enableOrDisableDeleteBtn(){
	
	
	var deteteBtn = document.getElementById('deletBtn');

	var checkedCount=0;
	
	var i = 1;
	   while(document.getElementById(i)!=null)
	   {
		   tmpCheck = document.getElementById(i);
		   if (tmpCheck.checked)
		   {	
		   checkedCount++;
		   
		   }
		   i++;
	   }
	  

	  if (checkedCount>0)
	  {
		deteteBtn.disabled=false;
	  }
	  else{
		  deteteBtn.disabled=true;
		  }

}

function checkAllBtn(btn){
	
	
	var deteteBtn = document.getElementById('deletBtn');

	if (btn.checked)
	{
		
		for (var i = 1; i <= 10; i++)
		  {
		   var tmpCheck = document.getElementById(i);
		   if (tmpCheck!=null)
		   {
			   tmpCheck.checked=true;
		   }
		  }
	
		deteteBtn.disabled=false;
	}
	else{
		

		for (var j = 1; j <= 10; j++)
		  {
		   var tmpCheck_f = document.getElementById(j);

		   if (tmpCheck_f!=null)
		   {
			   tmpCheck_f.checked=false;
		   }
		  }
		deteteBtn.disabled=true;
		} 
	
}

function changeImage(imgName)
{
	//document.getElementById('cartImg').src="../images/"+imgName+".gif";

}
