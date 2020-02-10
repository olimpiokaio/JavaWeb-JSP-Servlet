<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="resoucer/bootstrap-4.3.1/css/bootstrap.min.css">
<!-- folha de estilo -->
<link rel="stylesheet" href="resoucer/font-back.css" />

<title>Login</title>

</head>
<body>

	<header class="text-center">
		<hr />
		<h1>Projeto</h1>
		<h2>JSP + Servlet + JDBC</h2>
		<hr />
	</header>

	<section class="container">
		<div class="row">

			<div class="col-md-4"></div>

			<div class="col-md-4">
				<form method="post" action="LoginServlet">
					<div class="form-group">
						<label for="login">Login</label> 
						<input type="text" class="form-control" id="login" name="login" required
							aria-describedby="Enter Login" placeholder="Digite aqui seu login"> 
						<small id="emailHelp" class="form-text text-muted"> 
							Digite seu login 
						</small>
					</div>
					<div class="form-group">
						<label for="password">Senha</label> 
						<input type="password" class="form-control" id="password" name="password"
							placeholder="Digite aqui sua senha" required>
					</div>
					<button type="submit" class="btn btn-primary">Entrar</button>
				</form>
			</div>

			<div class="col-md-4"></div>

		</div>
	</section>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="resoucer/bootstrap-4.3.1/js/jquery-3.3.1.slim.min.js"></script>
	<script src="resoucer/bootstrap-4.3.1/js/popper.min.js"></script>
	<script src="resoucer/bootstrap-4.3.1/js/bootstrap.min.js"></script>
</body>
</html>