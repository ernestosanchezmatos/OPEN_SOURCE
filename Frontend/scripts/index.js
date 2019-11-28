document.addEventListener("DOMContentLoaded", indexMain, false);

function indexMain(){
    axios.get('http://localhost:8081/ordenes')
    .then(data=>{
        var rpta=data.data;
        console.log(data.data);
        var contTablaServicios=document.getElementById('contTablaServicios');
        for (var i=0;i<rpta.length;i++){            
            contTablaServicios.innerHTML+=`<tr>
            <th scope="row">1</th>
            <td>${rpta[i].fechaGeneracion}</td>
            <td>${rpta[i].fechaEjecucion}</td>
            <td>${rpta[i].ejemplar.nejemplar}</td>
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

