package bean;

public class BeanUsuario {

	private Long id;
	private String login;
	private String senha;
	private String nome;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String ibge;
	private String fotoBase64;
	private String fotoBase64miniatura;
	private String contentType;
	private String curriculoBase64;
	private String curriculoContentType;
	private String acesso = "user";
	private String tempFotoUser;
	private String sexo;
	private String comedimento;
	private String perfil;
	
	public String getPerfil() {
		return perfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getComedimento() {
		return comedimento;
	}
	
	public void setComedimento(String comedimento) {
		this.comedimento = comedimento;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getAcesso() {
		return acesso;
	}
	
	public void setFotoBase64miniatura(String fotoBase64miniatura) {
		this.fotoBase64miniatura = fotoBase64miniatura;
	}
	
	public String getFotoBase64miniatura() {
		return fotoBase64miniatura;
	}
	
	public String getTempFotoUser() {
		if(this.fotoBase64 != null && this.contentType != null) {	
			tempFotoUser = "data:" + contentType + ";base64," + fotoBase64;
			return this.tempFotoUser;
		}
		else {
			return null;
		}
	}
	
	public String getCurriculoContentType() {
		return curriculoContentType;
	}
	
	public void setCurriculoContentType(String curriculoContentType) {
		this.curriculoContentType = curriculoContentType;
	}
	
	public String getCurriculoBase64() {
		return curriculoBase64;
	}
	
	public void setCurriculoBase64(String curriculoBase64) {
		this.curriculoBase64 = curriculoBase64;
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}
	
	public String getFotoBase64() {
		return fotoBase64;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
