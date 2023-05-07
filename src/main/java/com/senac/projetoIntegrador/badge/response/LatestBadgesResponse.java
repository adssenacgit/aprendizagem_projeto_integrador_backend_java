package com.senac.projetoIntegrador.badge.response;

import java.sql.Blob;

public class LatestBadgesResponse {
	private String descricao;
	private Blob imagem;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Blob getImagem() {
		return imagem;
	}
	public void setImagem(Blob imagem) {
		this.imagem = imagem;
	}
	public LatestBadgesResponse(String descricao, Blob imagem) {
		super();
		this.descricao = descricao;
		this.imagem = imagem;
	}
}
