package com.senac.projetoIntegrador.atividade.service;

import java.util.List;

import com.senac.projetoIntegrador.atividade.dto.AtividadeDto;

public interface IAtividadeService {	
	public List<AtividadeDto> getLatestAtividadesByUsuarioId(String usuarioId);
}
