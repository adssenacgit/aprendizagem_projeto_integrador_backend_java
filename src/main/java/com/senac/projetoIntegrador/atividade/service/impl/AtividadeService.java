package com.senac.projetoIntegrador.atividade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoIntegrador.atividade.dto.AtividadeDto;
import com.senac.projetoIntegrador.atividade.repository.IAtividadeRepository;
import com.senac.projetoIntegrador.atividade.service.IAtividadeService;

@Service
public class AtividadeService implements IAtividadeService {
	@Autowired
	IAtividadeRepository repository;
	
	public List<AtividadeDto> getLatestAtividadesByUsuarioId(String usuarioId) {
		return repository.getLatestAtividadesByUsuarioId(usuarioId);
	}
}
