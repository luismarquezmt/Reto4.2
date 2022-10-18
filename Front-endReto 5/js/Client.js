const getAll = 'http://144.22.194.98:8080/api/Client/'

function hideTextFieldCli(){
    document.getElementById("cliente").style.display = "none";
}

function showTextFieldCli(){
    document.getElementById("cliente").style.display = "block";
}

/*-------------------------------GET METHOD ----------------------------------------------------*/



function getCliInfo (){
    $.ajax({
        url:getAll+"all",
        type:"GET",
        contentType:"application/JSON",
        success: function(JSON)
        {
            console.log(JSON)
            putCliAnswer(JSON)        
        },
        error:(err)=>{
        console.log("ERRORHUBO")
        },
        complete:()=>{
            console.log("completo")
        }
    })
}



function putCliAnswer(JSON){
    let table3="<table>"; 
    for(i=0;i< JSON.length;i++){
       table3+="<tr>";  
       table3+="<td>"+JSON[i].idClient+"</td>";
       table3+="<td>"+JSON[i].name+"</td>";
       table3+="<td>"+JSON[i].email+"</td>";
       table3+="<td>"+JSON[i].password  +"</td>";
       table3+="<td>"+JSON[i].age+"</td>";
       table3+="<td><button type='button' onclick='deleteCliInfo("+JSON[i].id+")'> Delete</button>";
       table3+="</tr>";
    } 
    table3+="</table>"; 
    $("#clientResult").append(table3);
   } 


/*-------------------------------SAVE METHOD ----------------------------------------------------*/



   function saveCliInfo(){
    let myData={
        email:$("#email").val(),    
        password:$("#password").val(),
        name:$("#nameClient").val(),
        age:+$("#age").val(),
    };

    let dataToSend=JSON.stringify(myData);
    console.log(myData)
    console.log(dataToSend)
    
    $.ajax({
        url:getAll+"save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        datatype:"json",
        success:function(){
            $("#clientResult").empty();
            $("#email").val("");
            $("#password").val(""),
            $("#nameClient").val("");
            $("#age").val("");
            getCliInfo();
            alert("Values were saved");
        }
    });
}
