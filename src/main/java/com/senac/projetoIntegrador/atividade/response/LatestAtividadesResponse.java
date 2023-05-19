package com.senac.projetoIntegrador.atividade.response;

import java.sql.Timestamp;

public class LatestAtividadesResponse {
	private String descricao;
	private Timestamp dataFim;
	private String nomeUc;
	
	public LatestAtividadesResponse(String descricao, Timestamp dataFim, String nomeUc) {
		super();
		this.descricao = descricao;
		this.dataFim = dataFim;
		this.nomeUc = nomeUc;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Timestamp getDataFim() {
		return dataFim;
	}
	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}
	public String getNomeUc() {
		return nomeUc;
	}
	public void setNomeUc(String nomeUc) {
		this.nomeUc = nomeUc;
	}
	
}
