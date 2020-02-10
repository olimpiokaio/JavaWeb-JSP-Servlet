<%@page import="bean.BeanUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		<!-- icones disponiveis no site abaixo -->
		<!-- https://ionicons.com/usage -->
		<link href="https://unpkg.com/ionicons@4.5.5/dist/css/ionicons.min.css" rel="stylesheet">
		<script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script>
		
	
		<!-- Adicionando JQuery -->
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"
			integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
			crossorigin="anonymous">
		</script>
	
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
		<hr/>
			<h1 class="text-center">Cadastro de usuario</h1>
		</div>
	
		<div class="container">
			<div class="alert alert-success alert-dismissible fade ${alert}"
				role="alert">
				Usuario cadastrado com <strong>Sucesso!</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
		
		<div class="container">
			<form method="post" action="UsuarioServlet" enctype="multipart/form-data">
				<fieldset>
					<section class="row" id="corpoForm">
						<!-- inicio da coluna 1 -->
						<div class="col-md-6">
							
							<div class="form-group row">
								<label for="cep" class="col-md-2 col-form-label-sm"> CEP </label>
								<div class="col-md-10">
									<input type="text" name="cep" class="form-control form-control-sm" id="cep"
										onblur="pesquisacep(this.value)" placeholder="cep" maxlength="9"
										value="${ user.cep}" required /> <small id="cepm"
										class="form-text text-danger"> <c:out value="${txt4}" />
									</small>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="rua" class="col-md-2 col-form-label-sm"> RUA </label>
								<div class="col-md-10">
									<input type="text" name="rua" class="form-control form-control-sm" readonly
										id="rua" placeholder="rua" value="${user.rua}"> <small
										id="ruam" class="form-text text-danger"> <c:out
											value="${txt5}" />
									</small>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="bairro" class="col-md-2 col-form-label-sm"> BAIRRO
								</label>
								<div class="col-md-10">
									<input type="text" name="bairro" class="form-control form-control-sm" readonly
										id="bairro" placeholder="bairro" value="${ user.bairro}">
									<small id="bairrom" class="form-text text-danger"> <c:out
											value="${txt6}" />
									</small>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="cidade" class="col-md-2 col-form-label-sm"> 
									CIDADE
								</label>
								<div class="col-md-10">
									<input type="text" name="cidade" class="form-control form-control-sm" readonly
										id="cidade" placeholder="cidade" value="${ user.cidade}">
									<small id="cidadem" class="form-text text-danger"> <c:out
											value="${txt7}" />
									</small>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="uf" class="col-md-2 col-form-label-sm"> UF </label>
								<div class="col-md-10">
									<input type="text" name="uf" class="form-control form-control-sm" readonly id="uf"
										placeholder="uf" value="${ user.uf}"> 
									<small id="ufm" class="form-text text-danger"> 
										<c:out value="${txt8}" />
									</small>
								</div>
							</div>
					
							<div class="form-group row">
								<label for="ibge" class="col-md-2 col-form-label-sm"> IBGE </label>
								<div class="col-md-10">
									<input type="text" name="ibge" class="form-control form-control-sm" readonly
										id="ibge" placeholder="ibge" value="${ user.ibge}"> 
									<small id="ibgem" class="form-text text-danger"> 
										<c:out value="${txt9}" />
									</small>
								</div>
							</div>
							
						</div>
						<!-- fim da coluna 1 -->
						
						<!-- inicio da coluna 2 -->
						<div class="col-md-6">
							
							<div class="form-group row">
								<input type="hidden" readonly="readonly" id="id" name="id" value="${ user.id }" />
								<label for="login" class="col-sm-2 col-form-label-sm">
									LOGIN
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control form-control-sm" id="login" name="login" 
										placeholder="login" value="${user.login}" required maxlength="50"/>
									
									<small id="loginm" class="form-text text-danger"> 
										<c:out value="${txt}" />
									</small>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="nome" class="col-md-2 col-form-label-sm">
									NOME
								</label>
								<div class="col-md-10">
									<input type="text" name="nome" class="form-control form-control-sm" id="nome"
									placeholder="nome" value="${ user.nome}" required maxlength="50"/> 
									<small id="nomem" class="form-text text-danger"> 
										<c:out value="${txt2}" />
									</small>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="senha" class="col-md-2 col-form-label-sm">
									SENHA
								</label>
								<div class="col-md-10">
									<input type="password" name="senha" class="form-control form-control-sm" required
										id="senha" placeholder="senha" value="${user.senha}" maxlength="15"> 
									
									<small id="senha" class="form-text text-danger">
										<c:out value="${txt3}" />
									</small>
								</div>
							</div>
							
							<div class="form-group row">
								<legend class="col-form-label col-md-2 pt-0">SEXO</legend>
								<div class="col-sm-10">
									<div class="form-check">
							          <input class="form-check-input" type="radio" name="sexo" id="masc" value="M" 
							          <%
							          	try{
							          		if(request.getAttribute("user") != null){
							          			bean.BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
							          			if(usuario.getSexo().equalsIgnoreCase("M")){
							          				out.print(" checked ");
							          			}
							          		} else {
						          				out.print(" checked ");
						          			}
							          	}catch(Exception e){
							          		System.err.println(e);
							          	}
							          %>
							          >
							          <label class="form-check-label" for="masc">
							            MASCULINO
							          </label>
							        </div>
							        <div class="form-check">
							          <input class="form-check-input" type="radio" name="sexo" id="femi" value="F"
							          <%
							          try{
							        	  if(request.getAttribute("user") != null){
							        		  bean.BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
							        		  if(usuario.getSexo().equalsIgnoreCase("F")){
							        			  out.print(" checked ");
							        		  }
							        	  }
							          }catch(Exception e){
							        	  System.err.println(e);
							          }
							          %>
							          >
							          <label class="form-check-label" for="femi">
							            FEMININO
							          </label>
							        </div>
							        <small id="senha" class="form-text text-danger">
										<c:out value="${txt10}" />
									</small>
								</div>
							</div>
							
							
							<div class="form-group row">
						    	<div class="col-md-3">COMEDIMENTO</div>
						    	
							      <div class="col-md-9 form-check">
							        <input class="form-check-input" name="come" type="checkbox" id="come"
							        	<%
							        	try{							        		
							        		if(request.getAttribute("user") != null) {
								        		bean.BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
							        			if(usuario.getComedimento().equalsIgnoreCase("ativo")) {
							        				out.print(" checked ");
							        			}
							        		}
							        	}catch(Exception e) {
							        		System.err.print(e);
							        	}
							        	%>
							        />
							        <label class="form-check-label" for="come">
							          ATIVO
							        </label>
							      </div>
						  	</div>
						  	
						  	<div class="form-group row">
								<label for="senha" class="col-md-2 col-form-label-sm">
									PERFIL
								</label>
								<div class="col-md-10">
									<select class="form-control form-control-sm" id="perfil" name="perfil" required> 
										<option value="sem perfil">-- SELECIONE --</option>
										
										<option value="secretario" 
											<% 
											if(request.getAttribute("user") != null) {
												
												bean.BeanUsuario usuario = new bean.BeanUsuario();
												usuario = (BeanUsuario) request.getAttribute("user");
												if(usuario.getPerfil().equalsIgnoreCase("secretario")) {													
												out.println(" selected ");
												}
											}
											%>>
											Secretário(a)
										</option>
										
										<option value="generente"
										<% 
										if(request.getAttribute("user") != null) {
											
											bean.BeanUsuario usuario = new bean.BeanUsuario();
											usuario = (BeanUsuario) request.getAttribute("user");
											if(usuario.getPerfil().equalsIgnoreCase("gerente")) {													
											out.println(" selected ");
											}
										}
										%>>
										Generente
										</option>
										
										<option value="funcionario"
										<% 
										if(request.getAttribute("user") != null) {
											
											bean.BeanUsuario usuario = new bean.BeanUsuario();
											usuario = (BeanUsuario) request.getAttribute("user");
											if(usuario.getPerfil().equalsIgnoreCase("funcionario")) {													
											out.println(" selected ");
											}
										}
										%>>
										Funcionario
										</option>
										
									</select>
								</div>
							</div>
							
						  	<div class="form-group row">
								<div class="col-md-5">
									<div class="custom-file">				
										<input type="file" class="custom-file-input" id="foto" name="foto"/>
										<label class="custom-file-label" for="foto" data-browse="foto">selecione</label>
									</div>
								</div>
								 
								<div class="col-sm-5">
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="curriculo" name="curriculo"/>
										<label class="custom-file-label" for="curriculo" data-browse="curriculo">selecione</label>
									</div>				
								</div>
								
							</div>
							
						</div>
						<!-- fim da coluna 2 -->
					
						<div class="form-group row">
							<div class="col-sm-12">
								<button type="submit" title="click para cadastrar"
									class="btn btn-primary">SALVAR</button>
									
								<a title="click para cancelar" href="UsuarioServlet?acao=carregar"
									class="btn btn-light">CANCELAR</a>
							</div>
						</div>
					</section>
				</fieldset>
			</form>
		</div>
		
		<c:if test="${ !lista.isEmpty() }">
			<div class="container">
				<hr />
				<h2 class="text-center">Usuarios cadastrados</h2>
			</div>
			
			<div class="container">
				<div class="row">
					<div class="col-md-4">
					</div>
					<div class="col-md-4">
						<form class="form-inline" method="post" action="ConsultaUsuairo" style="padding: 7px; background: rgba(0, 0, 0, 0.2)">
				    		<input class="form-control col-md-8" type="search" name="nome" placeholder="Nome" aria-label="Search">
				    		<button class="btn btn-outline-secondary col-md-4" type="submit">Consultar</button>
				  		</form>
					</div>
					<div class="col-md-4">
					</div>					
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 col-lg-12 col-sm-12">
					<table class="table table-hover table-responsive-sm corpoTable">
						<thead>
							<tr>
								<th scope="col">Codigo</th>
								<th scope="col">Foto</th>
								<th scope="col">Curriculo</th>
								<th scope="col">Nome</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody style="color:#fff;">
							<c:forEach items="${ lista }" var="user">
								<tr>
									<td>
										<c:out value="${ user.id }" />
									</td>
									<td>								
										<c:if test="${!user.fotoBase64miniatura.isEmpty() && user.fotoBase64miniatura != null}">
											<a href="UsuarioServlet?acao=download&user=${user.id}&tipo=foto">
												<img src="<c:out value='${ user.fotoBase64miniatura }'/>" style="border-radius:10px"
												width="55" height="50" alt="image User" title="download ${ user.nome }"/>
											</a>
										</c:if>
										
										<c:if test="${user.fotoBase64miniatura == null}">
											<img src="resoucer/imagens/semArquivo.png" style="border-radius:10px" width="55" height="50" alt="image User" title="Não possui foto" onclick="semArquivo(1)"/>
										</c:if>
									</td>
									
									<td>
										<c:if test="${user.curriculoBase64 != null}">							
											<a href="UsuarioServlet?acao=download&user=${user.id}&tipo=curriculo" style="font-size:17pt;
												background: #ff751a;"class="btn btn-light" title="curriculo">
												<ion-icon name="document">curriculo</ion-icon>
											</a>
										</c:if>
										<c:if test="${user.curriculoBase64 == null}">
											<img src="resoucer/imagens/semArquivo.png" style="border-radius:10px"
												width="55" height="50" alt="${ user.nome } curriculo" title="Não possui curriculo" 
												onclick="semArquivo(2)"/>
										</c:if>
									</td>
									<td>
										<c:out value="${ user.nome }" />
									</td>
									<td align="right">
										<a style="font-size: 17pt; background: #ff751a;"class="btn btn-light" title="telefone"
											href="TelefoneServlet?id=${user.id}&acao=carregar">
											<ion-icon name="call">telefone</ion-icon>
										</a>
										
										<a style="font-size: 17pt" class="btn btn-light" title="deletar"
											href="UsuarioServlet?acao=deletar&id=${user.id}" 
											onclick="return confirm('Excluir registros do ${user.nome}')">
											<ion-icon name="trash">deletar</ion-icon>
										</a> 
										
										<a style="font-size: 17pt" class="btn btn-light" title="editar"
											href="UsuarioServlet?acao=editar&id=${user.id}"> 
											<ion-icon name="create">editar</ion-icon>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	
		<!-- Adicionando Javascript -->
		<script type="text/javascript">
		
			function semArquivo(arquivo) {
				if(arquivo == 1){					
					alert('Não possui foto!');
				}
				else if(arquivo == 2) {
					alert('Não possui Curriculo!');
				}
			}
		
			function limpa_formulário_cep() {
				//Limpa valores do formulário de cep.
				document.getElementById('rua').value = ("");
				document.getElementById('bairro').value = ("");
				document.getElementById('cidade').value = ("");
				document.getElementById('uf').value = ("");
				document.getElementById('ibge').value = ("");
			}
	
			function meu_callback(conteudo) {
				if (!("erro" in conteudo)) {
					//Atualiza os campos com os valores.
					document.getElementById('rua').value = (conteudo.logradouro);
					document.getElementById('bairro').value = (conteudo.bairro);
					document.getElementById('cidade').value = (conteudo.localidade);
					document.getElementById('uf').value = (conteudo.uf);
					document.getElementById('ibge').value = (conteudo.ibge);
				} //end if.
				else {
					//CEP não Encontrado.
					limpa_formulário_cep();
					alert("CEP não encontrado.");
				}
			}
	
			function pesquisacep(valor) {
	
				//Nova variável "cep" somente com dígitos.
				var cep = valor.replace(/\D/g, '');
	
				//Verifica se campo cep possui valor informado.
				if (cep != "") {
	
					//Expressão regular para validar o CEP.
					var validacep = /^[0-9]{8}$/;
	
					//Valida o formato do CEP.
					if (validacep.test(cep)) {
	
						//Preenche os campos com "..." enquanto consulta webservice.
						document.getElementById('rua').value = "...";
						document.getElementById('bairro').value = "...";
						document.getElementById('cidade').value = "...";
						document.getElementById('uf').value = "...";
						document.getElementById('ibge').value = "...";
	
						//Cria um elemento javascript.
						var script = document.createElement('script');
	
						//Sincroniza com o callback.
						script.src = 'https://viacep.com.br/ws/' + cep
								+ '/json/?callback=meu_callback';
	
						//Insere script no documento e carrega o conteúdo.
						document.body.appendChild(script);
	
					} //end if.
					else {
						//cep é inválido.
						limpa_formulário_cep();
						alert("Formato de CEP inválido.");
					}
				} //end if.
				else {
					//cep sem valor, limpa formulário.
					limpa_formulário_cep();
				}
			};
			
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