document.addEventListener("DOMContentLoaded", indexMain, false);

function indexMain(){
    var _objUsuario=localStorage.getItem("usuario");
    var objUsuario=JSON.parse(_objUsuario);
    console.log(objUsuario);
    var contTablaServicios=document.getElementById('contTablaServicios');

    axios.get('http://localhost:8081/ordenes')
    .then(data=>{
        var rpta=data.data;
        console.log(data.data);

        var imgUsuario=document.getElementById('imgUsuario');  
        imgUsuario.innerHTML=`<img src="${objUsuario.imagenRuta}">`;
        
        for (var i=0;i<rpta.length;i++){            
            contTablaServicios.innerHTML+=`<tr>
            <th scope="row">1</th>
            <td>${rpta[i].fechaGeneracion}</td>
            <td>${rpta[i].fechaEjecucion}</td>
            <td >${rpta[i].ejemplar.nejemplar}</td>
            <td>${rpta[i].empleado.persona.npersona}</td>
            <td>AreaManagerTEST 'GAAAA'</td>
            <td>AreaTEST 'GAAAA'</td>
            <td>${rpta[i].cliente.persona.npersona}</td>
            <td>EstimatedWorkTimeTEST 'GAAAA'</td>
            <td>
                <a href="form-validation.html" button class="btn btn-primary btn-sm"><i class="zmdi zmdi-edit"></i></button></a>
                <a button class="btn btn-danger btn-sm"> <i class="zmdi zmdi-delete" ></i></button></a>
            </td>
            </tr>`;
        }
    });
}

