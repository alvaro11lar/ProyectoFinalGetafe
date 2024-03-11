<%@page import="entities.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List,entities.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>	
<script type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	List<Usuario> alumnos = (List<Usuario>)request.getAttribute("listadoUsuarios");
	System.out.println("Num alumnos "+alumnos.size());
	%>
	
	
	
	<div class="container">
<!-- 		<div class="row"> -->
		<!-- row-cols Clase nueva en Bootstrap 5 -->
		<div class="row">
			<div class="col-lg-4">
			<select name="inputRol" class="form-control" required>
                  <option selected>Seleccionar...</option>
                  <option>Usuario</option>
                  <option>Administrador</option>
                </select>
			</div>
			<div class="col-lg-4" >
				<input type="text" class="form-control" name="inputIdUsuario" placeholder="Nombre de usuario">
			</div>
			<div class="col-lg-4 d-flex justify-content-center">
				<a href="/ProyectoFinal/ServletLogin?accion=filtrar">
    <button class="btn btn-success">Filtrar</button>
</a>
			</div>
		</div>

	</div>
	
	<main>
             
    
                 
	<div class="container">
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th></th>
                <th></th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Dni</th>
                <th>Sexo</th>
                <th>IDUsuario</th>
                <th>Contraseña</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Fecha de nacimiento</th>
                <th>Roles</th>
            </tr>
        </thead>
        <tbody>
<%
	for(Usuario alumno : alumnos){
%>
	<tr>
		<td><a href="/ProyectoFinal/
				signUp.jsp?nombre=<%=alumno.getNombre()%>
				&apellidos=<%=alumno.getApellidos()%>
				&dni=<%=alumno.getDni() %>
				&sex=<%=alumno.getSexo() %>
				&IDUsuario=<%=alumno.getIdUsuario()%>
				&contraseña=<%=alumno.getContraseña() %>
				&email=<%=alumno.getEmail() %>
				&telefono=<%=alumno.getTelefono() %>
				&fechaNaccimiento=<%=alumno.getFechaNacimmiento() %>
				&accion=modificar
				"  class="btn btn-primary">Modificar</a></td>
		<td><a href="/ProyectoFinal/
				/ServletLogin?dni=<%=alumno.getDni()%>
				&accion=eliminar"
				class="btn btn-danger">Eliminar</a></td>
		<td><%= alumno.getNombre()  %></td>
		<td><%= alumno.getApellidos()  %></td>
		<td><%= alumno.getDni()  %></td>
		<td><%= alumno.getSexo()  %></td> 
		<td><%= alumno.getIdUsuario()  %></td>
		<td><%= alumno.getContraseña()  %></td>
		<td><%= alumno.getEmail()  %></td>
		<td><%= alumno.getTelefono()  %></td>
		<td><%= alumno.getFechaNacimmiento()  %></td>
		<td><%= alumno.getRoles() %></td>
	</tr>
<%	} %>

</table>


</main>

<footer>
	<a href="/ProyectoFinal/signUp.jsp?accion=insertar">
    <button class="btn btn-success">Nuevo Alumno</button>
</a>
</footer>
<!-- <button class="btn btn-success" onclick="">Nuevo Alumno</button> -->
</body>
</html>