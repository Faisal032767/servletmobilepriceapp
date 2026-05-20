let btn = document.querySelectorAll("#btn-edit");
    let input = document.querySelectorAll("input");

    for (let i = 0; i < btn.length; i++) {
      btn[i].addEventListener("click", () => {
        if (btn[i].innerText === "Edit") {
          btn[i].innerText = "Save";

          // input tag select algo start
          
            let x = i * 3;
            for (let k = x + 1; k < x + 3; k++) {
              input[k].removeAttribute("disabled");
              input[k].focus();
              input[k].setAttribute("class", "inputbg");
            }
          

          // input tag select algo end
        } else {
          btn[i].innerText = "Edit";

          // input tag select algo start
          let val=[]
            let x1 = i * 3;
            for (let k = x1 + 1; k < x1 + 3; k++) {
              input[k].setAttribute("disabled", "disabled");
              input[k].removeAttribute("class");
            //   console.log(input[k].value)
              val.push(input[k].value)
            }
         
          //finding id from input
          let x = i * 3;
          let updateId = 0;
          for (let y = x; y < x + 1; y++) {
            console.log("=");
            updateId = input[y].getAttribute("value");
          }
          console.log(updateId);
          console.log(val[0]);
          console.log(val[1]);
          // data and id both
          // window.location.href=`updateServ?updatId=${updateId}`
          fetch('updateServ',{
            method:'POST',
            headers:{ 'Content-type':'application/x-www-form-urlencoded'},
            body:'id='+updateId+'&name='+val[0]+'&price='+val[1]
          })
          .then(response=>response.text())
          .then(data=>console.log(data))
        }
      });
    }

    // ======================  delete ==============================================

    // let btn = document.querySelector("button");
    let btnDel = document.querySelectorAll("#btn-del");
    let btnyes = document.querySelector("#yes");
    let btnno = document.querySelector("#no");
    let btnpop = document.querySelector("#pop");

 
let btnSelected=0;
    for(let i=0;i<btnDel.length;i++){
        btnDel[i].addEventListener('click',()=>{
			btnSelected=i;
			//console.log(btnDel[i]);
        	 btnpop.classList.toggle("popover");
        })
       }
    
 
    
    btnyes.addEventListener("click", () => {
      let btnyess = btnyes.innerText;
      console.log(btnyess);
     let btnvalue = btnDel[btnSelected].getAttribute("value");
    // console.log(btnvalue)

      window.location.href = `deleteServ?deleteRecord=${btnvalue} `;

      btnpop.classList.toggle("popover");
      alert("Your record deleted successfully...");
    });

    btnno.addEventListener("click", () => {
      //let btnnoo = btnno.innerText;
      btnpop.classList.toggle("popover");
      alert("Your data is not deleted...");
    });

//-------------------------------------box2 pop up for adding user------------------------------------------------
let con = document.querySelector(".container");
let addBtn = document.querySelector("ol li .add");
let btn1 = document.querySelector(".box2 button");
let box2 = document.querySelector(".box2");

function fun() {



	box2.classList.toggle("active");
	con.classList.toggle("con-opacity");
}

addBtn.addEventListener("click", fun);
//------------------------------------------------------------------
function userData() {
	box2.classList.toggle("active");
	con.classList.toggle("con-opacity");
}
btn1.addEventListener("click", userData);