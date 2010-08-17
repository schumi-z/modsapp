function setControllerBtn(){
	
	var actPage = document.getElementById('actPageHidden').value;
	
	var maxPageNum = document.getElementById('maxNumPageHidden').value;
	
	var fBtn = document.getElementById('fBtn');
	var bBtn = document.getElementById('bBtn');
	var nBtn = document.getElementById('nBtn');
	var lBtn = document.getElementById('lBtn');
	
	
	if (actPage == 1){
		//disable back and first
		
		fBtn.disabled = true;
		bBtn.disabled = true;
		
	}else{
		//enable back and first
		fBtn.disabled = false;
		bBtn.disabled = false;
	}
	
	if (actPage == maxPageNum){
		//disable next and last
		nBtn.disabled = true;
		lBtn.disabled = true;
	}
	else{
		//enable next and first
		nBtn.disabled = false;
		lBtn.disabled = false;
	}
	
}