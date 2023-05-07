package com.senac.projetoIntegrador.atividade.response;

import java.sql.Timestamp;

public class LatestAtividadesResponse {
	private String listaDescricao;
	private Timestamp listaDataFim;
	
	public String getListaDescricao() {
		return listaDescricao;
	}
	public void setListaDescricao(String listaDescricao) {
		this.listaDescricao = listaDescricao;
	}
	public Timestamp getListaDataFim() {
		return listaDataFim;
	}
	public LatestAtividadesResponse(String listaDescricao, Timestamp listaDataFim) {
		super();
		this.listaDescricao = listaDescricao;
		this.listaDataFim = listaDataFim;
	}
	public void setListaDataFim(Timestamp listaDataFim) {
		this.listaDataFim = listaDataFim;
	}
}
