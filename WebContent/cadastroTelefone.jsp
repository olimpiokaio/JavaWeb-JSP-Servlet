<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>CadastroUsuario</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="resoucer/bootstrap-4.3.1/css/bootstrap.min.css">

<link rel="stylesheet" href="resoucer/font-back.css" />
<!-- icones -->
<link href="https://unpkg.com/ionicons@4.5.5/dist/css/ionicons.min.css"
	rel="stylesheet">
<script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script>
<!-- icones disponiveis no site abaixo -->
<!-- https://ionicons.com/usage -->

<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#"><img
			style="height: 70px; whitd: 70px;"
			src="http://aux4.iconspalace.com/uploads/720109378308002255.png" /></a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" title="sair"
					style="color: #fff; font-size: 17pt" href="index.jsp"> <ion-icon
							name="exit">sair</ion-icon>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					style="color: #fff; font-size: 17pt" href="login-sucesso.jsp"
					title="home"> <ion-icon name="home">home</ion-icon>
				</a></li>
			</ul>
		</div>
	</nav>
	<hr />
	<div class="container">
		<h1 class="text-center">Lista telefonica</h1>
	</div>
	
	<div class="container">
		<div class="alert alert-success alert-dismissible fade ${alert}"
			role="alert">
			<strong>Sucesso!</strong>Contato cadastrado!
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</div>

	<hr />
	<div class="container">
		<form method="post" action="TelefoneServlet">
			<fieldset>
				<legend>Telefone</legend>
				<input type="hidden" name="id" value="${user_id}" readonly/>
				<div class="form-group row">
					<label for="numero" class="col-sm-2 col-form-label">
						<ion-icon style="font-size: 20pt;" name="call">numero</ion-icon>
					</label>
					<div class="col-sm-10">
						<input type="text" name="numero" class="form-control" id="numero"
							placeholder="numero" value="${numero}" required maxlength="20"/> 
						<small id="numero" class="form-text text-danger"> 
							<c:out value="${txt1}" />
						</small>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="senha" class="col-sm-2 col-form-label"> 
						<ion-icon style="font-size:20pt" name="list-box">Tipo Telefone</ion-icon>
					</label>
					<div class="col-sm-10">
						<select id="tipo" name="tipo" class="form-control" required>
							<option value="fixo">numero fixo</option>
							<option selected value="celular">numero celular</option>
						</select>
 						<small id="senha" class="form-text text-danger">
 							<c:out value="${txt2}" />
						</small>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="cep" class="col-sm-2 col-form-label">
						<ion-icon style="font-size: 20pt;" name="person">usuairo</ion-icon>
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" readonly
							id="nome" value="${user_nome}" required/>
							<small id="nome" class="form-text text-danger">
								<c:out value="${txt3}" />
							</small>
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" title="click para cadastrar"
							class="btn btn-primary">Cadastrar novo contato</button>
							
						<a href="http://localhost:8080/CursoJspServlet/UsuarioServlet?acao=carregar" title="voltar para usuarios"
							class="btn btn-light">Voltar para usuarios</a>
					</div>
				</div>
				
			</fieldset>
		</form>
	</div>

	<div class="container">
		<hr />
		<h2 class="text-center">Telefones cadastrados</h2>
	</div>

	<div class="row">
		<div class="col-md-12 col-lg-12 col-sm-12">
			<table class="table table-dark table-hover table-responsive-sm">
				<thead>
					<tr>
						<th scope="col">codigo</th>
						<th scope="col">Numero</th>
						<th scope="col">Tipo</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ list }" var="telefone">
						<tr class="col-sm-12">
							<td align="left"><c:out value="${ telefone.id }" /></td>
							<td align="left"><c:out value="${ telefone.numero }" /></td>
							<td align="left"><c:out value="${ telefone.tipo }" /></td>
							<td align="right">
								<a href="TelefoneServlet?acao=excluir&tel=${telefone.id}&id=${user_id}"
								 style="font-size: 17pt" class="btn btn-light" title="excluir"
								 onclick="return confirm('Excluir telefone ${telefone.numero}')">
									<ion-icon name="trash">excluir</ion-icon>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Adicionando Javascript -->
	<script type="text/javascript">
		
	</script>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="resoucer/bootstrap-4.3.1/js/jquery-3.3.1.slim.min.js"></script>
	<script src="resoucer/bootstrap-4.3.1/js/popper.min.js"></script>
	<script src="resoucer/bootstrap-4.3.1/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>