const getAllCloud = 'http://144.22.194.98:8080/api/Cloud/'

function hideTextFieldClo(){
    document.getElementById("nube").style.display = "none";
}

function showTextFieldClo(){
    document.getElementById("nube").style.display = "block";
}

/*-------------------------------GET METHOD ----------------------------------------------------*/


function getCloInfo (){
    $.ajax({
        url:getAllCloud+"all",
        type:"GET",
        contentType:"application/JSON",
        success: function(JSON)
        {
            console.log(JSON)
            putCloAnswer(JSON)        
        },
        error:(err)=>{
        console.log("ERRORHUBO")
        },
        complete:()=>{
            console.log("completo")
        }
    })
}


function putCloAnswer(JSON){
    let table3="<table>"; 
    table3+="<tr>";  
    table3+="<th>"+"ID"+"</th>";
    table3+="<th>"+"Name"+"</th>";
    table3+="<th>"+"Brand"+"</th>";
    table3+="<th>"+"Year"+"</th>";
    table3+="<th>"+"Description"+"</th>";
    for(i=0;i< JSON.length;i++){
        table3+="<tr>";  
       table3+="<td>"+JSON[i].id+"</td>";
       table3+="<td>"+JSON[i].name+"</td>";
       table3+="<td>"+JSON[i].brand+"</td>";
       table3+="<td>"+JSON[i].year+"</td>";
       table3+="<td>"+JSON[i].description+"</td>";
       table3+="<td><button type='button' onclick='deleteCloInfo("+JSON[i].id+")'> Delete</button>";
       table3+="</tr>";
    } 
    table3+="</table>";
    $("#cloudResult").append(table3);
   } 

/*-------------------------------SAVE METHOD ----------------------------------------------------*/

   function saveCloInfo(){
    let myData={
        brand:$("#brand").val(),    
        year:+$("#year").val(),
        name:$("#nameCloud").val(),
        description:$("#description").val(),
    };

    let dataToSend=JSON.stringify(myData);
    console.log(myData)
    console.log(dataToSend)
    
    $.ajax({
        url:getAllCloud+"save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        datatype:"json",
        success:function(){
            $("#cloudResult").empty();
            $("#brand").val("");
            $("#year").val(""),
            $("#description").val("");
            $("#nameCloud").val("");
            getCloInfo();
            alert("Values were saved");
        }
    });
}

/*-------------------------------UPDATE METHOD ----------------------------------------------------*/

