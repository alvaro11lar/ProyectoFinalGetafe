<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>	
<script type="text/javascript">
// $(document).ready(function(){
// 	alert('kdkdkd');
// 	$("#SignUp" ).on( "submit", function( event ) {
// 		  alert( "Handler for `submit` called." );
// 		  event.preventDefault();
// 		});
// });



// function test(){
// fecha = $('#inputFechaNacimiento').val();
// alert('hola');
// };	


</script>
</head>
<body>

<%

String nombre 	 = request.getParameter("nombre")!=null?request.getParameter("nombre"):"";
String apellidos = request.getParameter("apellidos")!=null?request.getParameter("apellidos"):"";
String sexo = request.getParameter("sex")!=null?request.getParameter("sex"):"";
System.out.println("La medida del sexo es: " + sexo.length());
String asignatura = request.getParameter("asignatura")!=null?request.getParameter("asignatura"):"";
String IDUsuario = request.getParameter("IDUsuario")!=null?request.getParameter("IDUsuario"):"";
String contraseña = request.getParameter("contraseña")!=null?request.getParameter("contraseña"):"";
String email = request.getParameter("email")!=null?request.getParameter("email"):"";
String telefonoStr = request.getParameter("telefono")!=null?request.getParameter("telefono"):"";
//int telefono = Integer.parseInt(telefonoStr);
String fechaNaccimiento = request.getParameter("fechaNaccimiento")!=null?request.getParameter("fechaNaccimiento"):"";
String roles = request.getParameter("roles")!=null?request.getParameter("roles"):"";
String dni = request.getParameter("dni")!=null?request.getParameter("dni"):"";
String accion = request.getParameter("accion").equals("modificar")?"modificar":"insertar";


%>
  <div class="container mt-4">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card">
        <div class="card-header">Registro</div>
        <div class="card-body">
          <form action="/ProyectoFinal/ServletLogin?accion=<%=accion %>" method="post" id="SignUp">
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="inputNombre">Nombre</label>
                <input type="text" class="form-control" name="inputNombre" placeholder="Nombre"  minlength="4" maxlength="20" value="<%=nombre %>" required>
              </div>
              <div class="form-group col-md-6">
                <label for="inputApellidos">Apellidos</label>
                <input type="text" class="form-control" name="inputApellidos" placeholder="Apellidos" minlength="4" maxlength="40" value="<%=apellidos %>" required>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-4">
                <label for="inputDNI">DNI</label>
                <input type="text" class="form-control" name="inputDNI" placeholder="DNI" maxlength="9"  value="<%=dni %>">
              </div>
              <div class="form-group col-md-4">
                <label for="inputSexo">Sexo</label>
                <select name="inputSexo" class="form-control" required>
                  <option selected>Seleccionar...</option>
                  <option>Masculino</option>
                  <option>Femenino</option>
                  <option>Otro</option>
                </select>
              </div>
              <div class="form-group col-md-4">
                <label for="inputIdUsuario">ID de Usuario</label>
                <input type="text" class="form-control" name="inputIdUsuario" placeholder="ID de Usuario" maxlength="8"  value="<%=IDUsuario %>" required>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="inputPassword">Contraseña</label>
                <input type="password" class="form-control" name="inputPassword" placeholder="Contraseña" maxlength="9" value="<%=contraseña %>" required>
              </div>
              <div class="form-group col-md-6">
                <label for="inputEmail">Email</label>
                <input type="email" class="form-control" name="inputEmail" placeholder="Email" value="<%=email %>" required>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="inputTelefono">Teléfono</label>
                <input type="text" class="form-control" id="inputTelefono" name="inputTelefono" placeholder="Teléfono"  max="999999999" value="<%=telefonoStr %>" required>
              </div>
              <div class="form-group col-md-6">
                <label for="inputFechaNacimiento">Fecha de Nacimiento</label>
                <input type="date" class="form-control" name="inputFechaNacimiento" value="<%=fechaNaccimiento %>" required>
              </div>
            </div>
            <div class="form-group col-md-4">
                <label for="inputRol">Roles</label>
                <select id="inputRol" name="rol" class="form-control" required multiple>
                  <option>Seleccionar...</option>
                  <option>Usuario</option>
                  <option>Administrador</option>
                </select>
              </div>
            <button type="submit" class="btn btn-primary">Registrarse</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>


</body>
</html>