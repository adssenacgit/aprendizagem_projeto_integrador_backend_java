package com.senac.projetoIntegrador.unidadeCurricular.dto;

public class UnidadeCurricularDto {
	private Long id;
	private String codigo;
	private Byte[] imagem;
	private String nome;
	private String nomeCurto;
	private int horas;
	private int modulo;
	private int ordem;
	private int status;
	
	
	public UnidadeCurricularDto() {
		super();
	}
	public UnidadeCurricularDto(String nomeCurto) {
		super();
		this.nomeCurto = nomeCurto;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Byte[] getImagem() {
		return imagem;
	}
	public void setImagem(Byte[] imagem) {
		this.imagem = imagem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCurto() {
		return nomeCurto;
	}
	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getModulo() {
		return modulo;
	}
	public void setModulo(int modulo) {
		this.modulo = modulo;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
