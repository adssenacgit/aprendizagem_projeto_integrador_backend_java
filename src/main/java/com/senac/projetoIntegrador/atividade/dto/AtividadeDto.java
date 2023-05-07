package com.senac.projetoIntegrador.atividade.dto;

import java.sql.Timestamp;

public class AtividadeDto {
	private Long id;
	private String descricao;
	private Timestamp dataInicio;
	private Timestamp dataFim;
	private int duracao;
	private int ordem;
	private int status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Timestamp getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Timestamp getDataFim() {
		return dataFim;
	}
	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
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
