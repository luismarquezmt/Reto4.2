const getAllCat = 'http://144.22.194.98:8080/api/Category/'

function hideTextFieldCat(){
    document.getElementById("categoria").style.display = "none";
}

function showTextFieldCat(){
    document.getElementById("categoria").style.display = "block";
}
    
/*-------------------------------GET METHOD ----------------------------------------------------*/



function getCatInfo (){
    $.ajax({
        url:getAllCat+"all",
        type:"GET",
        contentType:"application/JSON",
        success: function(JSON)
        {
            console.log(JSON)
            putCatAnswer(JSON)        
        },
        error:(err)=>{
        console.log("ERRORHUBO")
        },
        complete:()=>{
            console.log("completo")
        }
    })
}



function putCatAnswer(JSON){
    let table3="<table>"; 
        table3+="<tr>";  
        table3+="<th>"+"ID"+"</th>";
        table3+="<th>"+"name"+"</th>";
        table3+="<th>"+"description"+"</th>";
    for(i=0;i< JSON.length;i++){
       table3+="<tr>";  
       table3+="<td>"+JSON[i].id+"</td>";
       table3+="<td>"+JSON[i].name+"</td>";
       table3+="<td>"+JSON[i].description+"</td>";
       
       table3+="<td><button type='button' onclick='deleteCatInfo("+JSON[i].id+")'> Delete</button>";
       table3+="</tr>";
    } 
    table3+="</table>";
    $("#categoryResult").append(table3);
   } 


/*-------------------------------SAVE METHOD ----------------------------------------------------*/



   function saveCatInfo(){
    let myData={
        name:$("#nameCategory").val(),    
        description:$("#descriptionCategory").val(),
    
    };

    let dataToSend=JSON.stringify(myData);
    console.log(myData)
    console.log(dataToSend)
    
    $.ajax({
        url:getAllCat+"save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        datatype:"json",
        success:function(){
            $("#categoryResult").empty();
            $("#nameCategory").val("");
            $("#descriptionCategory").val(""),
           
            getCatInfo();
            alert("Values were saved");
        }
    });
}
