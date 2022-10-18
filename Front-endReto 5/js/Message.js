const getAllMes = 'http://144.22.194.98:8080/api/Message/'

function hideTextFieldMes(){
    document.getElementById("mensaje").style.display = "none";
}

function showTextFieldMes(){
    document.getElementById("mensaje").style.display = "block";
}

/*-------------------------------GET METHOD ----------------------------------------------------*/



function getMesInfo (){
    $.ajax({
        url:getAllMes+"all",
        type:"GET",
        contentType:"application/JSON",
        success: function(JSON)
        {
            console.log(JSON)
            putMesAnswer(JSON)        
        },
        error:(err)=>{
        console.log("ERRORHUBO")
        },
        complete:()=>{
            console.log("completo")
        }
    })
}



function putMesAnswer(JSON){
    let table3="<table>"; 
    for(i=0;i< JSON.length;i++){
       table3+="<tr>";  
       table3+="<td>"+JSON[i].idMessage+"</td>";
       table3+="<td>"+JSON[i].messageText+"</td>";

       table3+="<td><button type='button' onclick='deleteMesInfo("+JSON[i].id+")'> Delete</button>";
       table3+="</tr>";
    } 
    table3+="</table>";
    $("#messageResult").append(table3);
   } 


/*-------------------------------SAVE METHOD ----------------------------------------------------*/



   function saveMesInfo(){
    let myData={
      messageText:$("#messageText").val(),
      };

    let dataToSend=JSON.stringify(myData);

    console.log(dataToSend)
    
    $.ajax({
        url:getAllMes+"save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        datatype:"json",
        success:function(){
            $("#messageResult").empty();
            $("#messageText").val("");
            
            getMesInfo();
            alert("Values were saved");
        }
    });
}
