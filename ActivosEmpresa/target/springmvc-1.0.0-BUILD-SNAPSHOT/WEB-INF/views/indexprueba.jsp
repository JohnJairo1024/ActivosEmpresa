<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>CRUD SPRING MVC CON MYSQL</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-md-6">
			<h4 class="text-center">Lista de Personas</h4>
			<hr>
			<table class="table table-bordered table-striped">
				<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Direccion</th>
					<th>Edad</th>
					<th>Editar</th>
					<th>Eliminar</th>	
				</tr>
				</thead>
				<tbody>
				<c:forEach var="persona" items="${list}">
					<tr>
						<td>${persona.idPersona}</td>
						<td>${persona.nombre}</td>
						<td>${persona.apellidos}</td>
						<td>${persona.direccion}</td>
						<td>${persona.edad}</td>
						<td><a href="editemp/${persona.idPersona}" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-check"></i> Editar</a></td>
						<td><a href="deleteemp/${persona.idPersona}" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i> Eliminar</a></td>
					</tr>
				</c:forEach>				
				</tbody>
			</table>
			<br />
			<!-- REFERENCIA DE LA PANTALLA NUEVO EMPLEADO -->
			<a href="personaform" class="btn btn-success"><i class="glyphicon glyphicon-edit"></i> Nueva Persona</a>			
		</div>
	</div>
</div>
</body>
</html>