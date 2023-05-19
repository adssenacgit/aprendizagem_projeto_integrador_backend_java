package com.senac.projetoIntegrador.unidadeCurricular.repository.impl;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QueriesUnidadeCurricular {
	private String getUnidadesCurricularesAtuaisByUsuarioId = """
				SELECT * FROM unidade_curricular uc
				JOIN grupo g ON uc.unidade_curricular_id = g.unidade_curricular_id
				JOIN participante p ON g.grupo_id = p.grupo_id
				JOIN estudante e ON p.estudante_id = e.estudante_id
				WHERE e.usuario_id = ? AND g.grupo_status = 1
			""";
	
	private String getLatestAtividadesUnidadesCurricularesByUsuarioId = """
				SELECT unidade_curricular_nome_curto FROM unidade_curricular uc
				JOIN grupo g ON uc.unidade_curricular_id = g.unidade_curricular_id
				JOIN participante p ON g.grupo_id = p.grupo_id
				JOIN acompanhamento ac ON p.participante_id = ac.participante_id
				JOIN atividade a ON ac.atividade_id = a.atividade_id
				JOIN estudante e ON p.estudante_id = e.estudante_id
				WHERE e.usuario_id = ?
				ORDER BY a.atividade_data_fim LIMIT 2
			""";

	public String getGetUnidadesCurricularesAtuaisById() {
		return getUnidadesCurricularesAtuaisByUsuarioId;
	}
	
	public String getGetLatestAtividadesUnidadesCurricularesByUsuarioId() {
		return getLatestAtividadesUnidadesCurricularesByUsuarioId;
	}
}
