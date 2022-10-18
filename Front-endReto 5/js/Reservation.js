const getAllRes = 'http://144.22.194.98:8080/api/Reservation/'

function hideTextFieldRes(){
    document.getElementById("reservacion").style.display = "none";
}

function showTextFieldRes(){
    document.getElementById("reservacion").style.display = "block";
}

/*-------------------------------GET METHOD ----------------------------------------------------*/



function getResInfo (){
    $.ajax({
        url:getAllRes+"all",
        type:"GET",
        contentType:"application/JSON",
        success: function(JSON)
        {
            console.log(JSON)
            putResAnswer(JSON)        
        },
        error:(err)=>{
        console.log("ERRORHUBO")
        },
        complete:()=>{
            console.log("completo")
        }
    })
}



function putResAnswer(JSON){
    let table3="<table>"; 
    for(i=0;i< JSON.length;i++){
       table3+="<tr>";  
       table3+="<td>"+JSON[i].idReservation+"</td>";
       table3+="<td>"+JSON[i].startDate+"</td>";
       table3+="<td>"+JSON[i].devolutionDate+"</td>"
       table3+="<td>"+JSON[i].status+"</td>"
       table3+="<td>"+JSON[i].score+"</td>"
       table3+="<td><button type='button' onclick='deleteResInfo("+JSON[i].id+")'> Delete</button>";
       table3+="</tr>";
    } 
    table3+="</table>";
    $("#reservationResult").append(table3);
   } 


/*-------------------------------SAVE METHOD ----------------------------------------------------*/



   function saveResInfo(){
    let myData={
        startDate:$("#startDate").val(),
        devolutionDate:$("#devolutionDate").val(),
        status:$("#status").val(),
        score:+$("#score").val(),

      };

    let dataToSend=JSON.stringify(myData);

    console.log(dataToSend)
    
    $.ajax({
        url:getAllRes+"save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        datatype:"json",
        success:function(){
            $("#reservationResult").empty();
            $("#startDate").val("");
            $("#devolutionDate").val("");
            $("#status").val("");
            $("#score").val("");
            getResInfo();
            alert("Values were saved");
        }
    });
}
