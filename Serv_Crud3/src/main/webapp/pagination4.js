/**
 * 
 */
let pageBtn=document.querySelectorAll('.pagi-btn');
console.log(pageBtn)
for(let i=0;i<pageBtn.length;i++){
	pageBtn[i].addEventListener('click',()=>{
	let val=pageBtn[i].getAttribute('value')
    //let end=pageBtn[i].getAttribute('end1')
	
	
	window.location.href=`insertServ?pageValue=${val}`
})
}


// ====================column to display form select tag

    let select = document.querySelector("#column-display select");
    select.addEventListener('change',(e)=>{
      let end=e.target.value;
      
      window.location.href=`insertServ?end2=${end}`
      
    })