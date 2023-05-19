package com.senac.projetoIntegrador.unidadeCurricular.service;

import java.util.List;

import com.senac.projetoIntegrador.unidadeCurricular.dto.UnidadeCurricularDto;

public interface IUnidadeCurricularService {
	public List<UnidadeCurricularDto> getCurrentUnidadesCurricularesByUsuarioId(String usuarioId);
	public List<UnidadeCurricularDto> getLatestAtividadesUnidadesCurricularesByUsuarioId(String usuarioId);
}
