package com.senac.projetoIntegrador.unidadeCurricular.repository;

import java.util.List;

import com.senac.projetoIntegrador.unidadeCurricular.dto.UnidadeCurricularDto;

public interface IUnidadeCurricularRepository {
	public List<UnidadeCurricularDto> getCurrentUnidadesCurricularesByUsuarioId(String usuarioId);
	public List<UnidadeCurricularDto> getLatestAtividadesUnidadesCurricularesByUsuarioId(String usuarioId);
}
