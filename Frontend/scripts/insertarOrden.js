document.addEventListener("DOMContentLoaded", InsertarMain, false);
var lstaIngenieros=[];
var lstaHospitales=[];
var lstaEjemplares=[];
function InsertarMain(){
    //PARA INGENIEROS
    var ruta="http://localhost:8081/empleados";
    var tablaListaIng=document.getElementById('tablaListaIng');
    tablaListaIng.innerHTML='';
    axios.get(ruta)
    .then(data=>{
        lstaIngenieros=data.data;
        console.log(lstaIngenieros);
        for (var i=0;i<lstaIngenieros.length;i++){
            var cod_ingeniero=lstaIngenieros[i].persona.personaId;
            tablaListaIng.innerHTML+=
            `<tr>  
               <td class="radio inlineblock m-r-20">
                   <input type="radio"  name="listaingenieros" id="ingeniero${cod_ingeniero}" class="with-gap" value="${cod_ingeniero}"  >
                   <label for="ingeniero${cod_ingeniero}">        &nbsp                                                        
                   </label>
               </td>                                                     
               <td>${lstaIngenieros[i].persona.npersona}</td>
               <td>${lstaIngenieros[i].persona.numContacto}</td>
               <td>${lstaIngenieros[i].persona.lugar.nlugar}</td>
            </tr> `
        }
    });
//PARA HOSPITALES
   var ruta2="http://localhost:8081/clientes";
   var tablaListaHosp=document.getElementById('tablaListaHosp');
   tablaListaHosp.innerHTML='';
   axios.get(ruta2)
    .then(data=>{
        lstaHospitales=data.data;
        console.log(lstaHospitales);
        for (var i=0;i<lstaHospitales.length;i++){
            var cod_hosp=lstaHospitales[i].persona.personaId;
            tablaListaHosp.innerHTML+=
            `<tr>  
               <td class="radio inlineblock m-r-20">
                   <input type="radio"  name="listahospitales" id="hospital${cod_hosp}" class="with-gap" value="${cod_hosp}"  >
                   <label for="hospital${cod_hosp}">        &nbsp                                                        
                   </label>
               </td>                                                     
               <td>${lstaHospitales[i].persona.npersona}</td>
               <td>${lstaHospitales[i].persona.numContacto}</td>
               <td>${lstaHospitales[i].persona.lugar.nlugar}</td>
            </tr> `
        }
    });
//PARA EJEMPLARES
var ruta3="http://localhost:8081/ejemplares";
var tablaListaEjem=document.getElementById('tablaListaEjem');
axios.get(ruta3)
 .then(data=>{
    lstaEjemplares=data.data;
     console.log(lstaEjemplares);
     for (var i=0;i<lstaEjemplares.length;i++){
         var cod_ejem=lstaEjemplares[i].ejemplarId;
         tablaListaEjem.innerHTML+=
         `<tr>  
            <td class="radio inlineblock m-r-20">
                <input type="radio"  name="listaejemplares" id="ejemplar${cod_ejem}" class="with-gap" value="${cod_ejem}"  >
                <label for="ejemplar${cod_ejem}">&nbsp                                                        
                </label>
            </td>                                                     
            <td>${lstaEjemplares[i].nejemplar}</td>
            <td>${lstaEjemplares[i].modelo.serieModelo}</td>
            <td>${lstaEjemplares[i].modelo.equipo.nequipo}</td>
         </tr> `
     }
 });
}

function RegistrarOrden(){
    var ruta='http://localhost:8081/ordenes';
    var fechaGenerada=document.getElementById('fechaGenerada').value;
    var fechaEjecutada=document.getElementById('fechaEjecutada').value;
    var listaingenieros=document.querySelector('input[name="listaingenieros"]:checked').value;
    var listaejemplares=document.querySelector('input[name="listaejemplares"]').value;
    var listahospitales=document.querySelector('input[name="listahospitales"]').value;
 
    axios({
        method:'post',
        url:ruta,
        data:{       
            empleado:{
                empeladoId:1
            }  ,  
            cliente:{
                clienteId:1
            }    ,
            fechaGeneracion:'2019-10-10',
            fechaEjecucion:'2019-10-10',
            nservicio:'gaa',
            ejemplar:{
                ejemplarId:1
            },
            numPuntaje:1,
        }
        }).then(data=>{
          window.location="./admin_view_service.html";
     })
}
function SelEjemplar(){
    var listaejemplares=document.querySelector('input[name="listaejemplares"]').value;
    
}

function SelHospital(){
    var listahospitales=document.querySelector('input[name="listahospitales"]').value;
  
}

function SelIngeniero(){
    var listaingenieros=document.querySelector('input[name="listaingenieros"]').value;
   
}

