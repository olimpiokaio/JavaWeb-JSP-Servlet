<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<style>
.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
	color: #fff;
	background-color: #ff751a;
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <a class="navbar-brand" href="#">Didatico</a>
	
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
	    <div class="navbar-nav mr-auto mt-2 mt-lg-0">
	    </div>
	  </div>
	  <div class="form-inline my-2 my-lg-0">
	    <a class="btn btn-outline-danger my-2 my-sm-0" href="index.jsp">Sair</a>
	  </div>
	</nav>
		
	<div id="corpo" class="container">
		<section class=" col-md-12">

			<div class="row text-center">
				<div class="col-md-3 coluna">

					<div class="row">

						<div class="col-md-12" id="contSelec1">
							<span>Usuarios</span> 
							<br /> 
							<span id="seta-baixo"> 
							<ion-icon name="arrow-round-down"></ion-icon></span>
							<br/> 
							<a href="UsuarioServlet?acao=carregar" class="btn btn-light"
								style="font-size: 65pt; border-radius: 40px;"
								title="cadastrar usuario">
									<ion-icon name="person">Usuários</ion-icon>
							</a>
						</div>

						<div class="col-md-12" id="contSelec2">
							<span>Produtos</span>
							<br/>
							<span id="seta-baixo">
								<ion-icon name="arrow-round-down"></ion-icon>
							</span>
							<br/> 
							<a href="ProdutoServlet?acao=carregar" class="btn btn-light"
								style="font-size: 65pt; border-radius: 40px;"
								title="cadastrar produto"> <ion-icon name="cart">Produtos</ion-icon>
							</a>
						</div>

					</div>

				</div>

				<div class="col-md-9">
					<div class="row">

						<div class="col-md-8 col-sm-12">
							<div class="tab-content" id="v-pills-tabContent">
								<div class="tab-pane fade show active" id="v-pills-home"
									role="tabpanel" aria-labelledby="v-pills-home-tab">
									<h3>O que o sistema faz?</h3>
									<p class="text-left">Ipsum quia dolor sit amet,
										consectetur, adipisci velit..." "There is no one who loves
										pain itself, who seeks after it and wants to have it, simply
										because it is pain..." What is Lorem Ipsum? Lorem Ipsum is
										printing and typesetting industry. Lorem Ipsum has been the
										industry's standard dummy text ever since the 1500s, but also
										the leap into electronic typesetting, remaining essentially
										unchanged.</p>
								</div>
								<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
									aria-labelledby="v-pills-profile-tab">
									<h3>Funcionalidades</h3>
									<p class="text-left">Ipsum quia dolor sit amet,
										consectetur, adipisci velit..." "There is no one who loves
										pain itself, who seeks after it and wants to have it, simply
										because it is pain..." What is Lorem Ipsum? Lorem Ipsum is
										printing and typesetting industry. Lorem Ipsum has been the
										industry's standard dummy text ever since the 1500s, but also
										the leap into electronic typesetting, remaining essentially
										unchanged.</p>
								</div>
								<div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
									aria-labelledby="v-pills-messages-tab">
									<h3>Objetivos</h3>
									<p class="text-left">Ipsum quia dolor sit amet,
										consectetur, adipisci velit..." "There is no one who loves
										pain itself, who seeks after it and wants to have it, simply
										because it is pain..." What is Lorem Ipsum? Lorem Ipsum is
										printing and typesetting industry. Lorem Ipsum has been the
										industry's standard dummy text ever since the 1500s, but also
										the leap into electronic typesetting, remaining essentially
										unchanged.</p>
								</div>
								<div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
									aria-labelledby="v-pills-settings-tab">
									<h3>Descrição técnica</h3>
										<object width="100%" height="330"
											data="https://www.youtube.com/embed/5kNsV6s6jog">
										</object>
								</div>
							</div>
						</div>

						<div class="col-md-4 col-sm-12">
							<div class="nav flex-column nav-pills" id="v-pills-tab"
								role="tablist" aria-orientation="vertical">

								<a class="nav-link active opt_txt" id="v-pills-home-tab"
									data-toggle="pill" href="#v-pills-home" role="tab"
									aria-controls="v-pills-home" aria-selected="true">Introdução</a>

								<a class="nav-link opt_txt" id="v-pills-profile-tab"
									data-toggle="pill" href="#v-pills-profile" role="tab"
									aria-controls="v-pills-profile" aria-selected="false">funcionalidades</a>

								<a class="nav-link opt_txt" id="v-pills-messages-tab"
									data-toggle="pill" href="#v-pills-messages" role="tab"
									aria-controls="v-pills-messages" aria-selected="false">Objetivo</a>

								<a class="nav-link opt_txt" id="v-pills-settings-tab"
									data-toggle="pill" href="#v-pills-settings" role="tab"
									aria-controls="v-pills-settings" aria-selected="false">Descrição
									técnica</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</section>
	</div>

	<!-- Optional JavaScript -->
	<script>
	
	

		
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