<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>CadastroUsuario</title>
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="resoucer/bootstrap-4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="resoucer/font-back.css" />
	<!-- icones -->
	<link href="https://unpkg.com/ionicons@4.5.5/dist/css/ionicons.min.css"
		rel="stylesheet">
	<script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script>
	<!-- icones disponiveis no site abaixo -->
	<!-- https://ionicons.com/usage -->
	
	<!-- biblioteca jquery 3.4 -->
	<script src="resoucer/jquery/jquery.min.js" type="text/javascript"></script> 
	<script src="resoucer/jquery/jquery.maskMoney.min.js" type="text/javascript"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <a class="navbar-brand" href="#">Didatico</a>
	
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	      <li class="nav-item active">
	        <a class="nav-link" href="login-sucesso.jsp">Home<span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="http://localhost:8080/CursoJspServlet/UsuarioServlet?acao=carregar">Usuario</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="http://localhost:8080/CursoJspServlet/ProdutoServlet?acao=carregar">Produto</a>
	      </li>
	    </ul>
	  </div>
	  <div class="form-inline my-2 my-lg-0">
	    <a class="btn btn-outline-danger my-2 my-sm-0" href="index.jsp">Sair</a>
	  </div>
	</nav>
	
	<div class="container">
		<hr />
		<h1 class="text-center">Cadastro</h1>
	</div>

	<div class="container">
		<div class="alert alert-success alert-dismissible fade ${alert}"
			role="alert">
			<strong>Sucesso!</strong> Produto cadastrado.
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</div>

	<div class="container">
		<form method="post" action="ProdutoServlet">
			<input type="hidden" readonly id="id" name="id"
				value="${ produto.id }" />
			<fieldset>
				<legend>Produto</legend>
				<div class="form-group row">

					<label for="nome" class="col-sm-2 col-form-label">
						Nome do produto
					</label>

					<div class="col-sm-10">

						<input type="text" class="form-control" id="nome"
							alt="nome do produto" placeholder="Nome do produto" name="nome"
							value="${produto.nome}" required> <small id="nome"
							class="form-text text-danger"> <c:out value="${nome_msg}" />
						</small>
					</div>

				</div>
				<div class="form-group row">

					<label for="quantidade" class="col-sm-2 col-form-label">
						Quantidade
					</label>

					<div class="col-sm-10">
						<input type="number" min="0" name="quantidade"
							class="form-control" id="quantidade" max="99000" min="0"
							placeholder="Quantidade do produto" value="${produto.quantidade}"
							alt="nome do produto" required> 
						<small id="quantidade" class="form-text text-danger"> 
							<c:out value="${quantidade_msg}" />
						</small>
					</div>
				
				</div>
				<div class="form-group row">

					<label for="valor" class="col-sm-2 col-form-label">
						Valor da unidade
					</label>
					<div class="col-sm-10">
						<input type="text" id="preco" name="valor" class="form form-control"
							value="${produto.valor}" data-thousands="." 
							placeholder="valor do produto" data-decimal="," 
							data-prefix="R$" required/>
						<small id="valor" class="form-text text-danger"> 
							<c:out value="${valor_msg}" />
						</small>
					</div>

				</div>
				
				<div class="form-group row">
					<label for="cat" class="col-sm-2 col-form-label">
						Categoria
					</label>
					<div class="col-sm-10">
						<select class="form-control" id="cat" name="categoria">
							<c:forEach items="${ categorias }" var="cat" >
								<option value="${ cat.id }"
									<c:if test="${cat.id == produto.categoria }">
										selected
									</c:if>
								>${ cat.nome }
								</option>
							</c:forEach>
						</select>
						<small id="valor" class="form-text text-danger"> 
							<c:out value="${valor_msg}" />
						</small>
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" title="click para cadastrar"
							class="btn btn-primary">Cadastrar</button>
						<a href="ProdutoServlet?acao=limpar" class="btn btn-light">
							Cancelar Cadastro</a>
					</div>
				</div>
			</fieldset>
		</form>
	</div>

	<div class="text-center">
		<hr />
		<h2>Produtos cadastrados</h2>
	</div>

	<div class="row">
		<div class="col-md-12 col-sm-12 col-sm-12">
			<table class="table table-dark table-hover table-responsive-sm">
				<thead>
					<tr>
						<th scope="col">Codigo</th>
						<th scope="col">Nome</th>
						<th scope="col">Quantidade</th>
						<th scope="col">Valor</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ lista }" var="produto">
						<tr class="col-sm-12">
							<td><c:out value="${ produto.id }" /></td>
							<td><c:out value="${ produto.nome }" /></td>
							<td><c:out value="${ produto.quantidade }" /></td>
							<td><c:out value="R$ ${ produto.valor }" /></td>
							<td align="right">
								<a style="font-size: 17pt" class="btn btn-light" title="excluir"
									href="ProdutoServlet?acao=deletar&id=${produto.id}"
									onclick="return confirm('Excluir registros de ${produto.nome}')">
									<ion-icon name="trash">excluir</ion-icon>
								</a> 
								
								<a style="font-size: 17pt" class="btn btn-light" title="editar"
									href="ProdutoServlet?acao=editar&id=${produto.id}"> 
									<ion-icon name="create">editar</ion-icon>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="resoucer/bootstrap-4.3.1/js/jquery-3.3.1.slim.min.js"></script>
	<script src="resoucer/bootstrap-4.3.1/js/popper.min.js"></script>
	<script src="resoucer/bootstrap-4.3.1/js/bootstrap.min.js"></script>
	<!--  foi comentado pois estava dando erro no jquery na parte de mascara
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous">
	</script>
	<!-- Optional JavaScript -->
	<script>
		$(function(){
		  $("#preco").maskMoney();
	  	})
	</script>
</body>
</html>