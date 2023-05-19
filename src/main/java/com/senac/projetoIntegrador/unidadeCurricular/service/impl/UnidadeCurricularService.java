package com.senac.projetoIntegrador.unidadeCurricular.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoIntegrador.unidadeCurricular.dto.UnidadeCurricularDto;
import com.senac.projetoIntegrador.unidadeCurricular.repository.IUnidadeCurricularRepository;
import com.senac.projetoIntegrador.unidadeCurricular.service.IUnidadeCurricularService;

@Service
public class UnidadeCurricularService implements IUnidadeCurricularService{
	@Autowired
	IUnidadeCurricularRepository repository;
	
	public List<UnidadeCurricularDto> getCurrentUnidadesCurricularesByUsuarioId(String usuarioId){
		return repository.getCurrentUnidadesCurricularesByUsuarioId(usuarioId);
	}

	public List<UnidadeCurricularDto> getLatestAtividadesUnidadesCurricularesByUsuarioId(String usuarioId) {
		return repository.getLatestAtividadesUnidadesCurricularesByUsuarioId(usuarioId);
	}
}
