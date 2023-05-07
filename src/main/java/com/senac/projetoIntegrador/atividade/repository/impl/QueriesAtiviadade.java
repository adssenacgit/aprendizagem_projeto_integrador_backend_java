package com.senac.projetoIntegrador.atividade.repository.impl;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QueriesAtiviadade {
	private String getLatestAtividadesByUsuarioId = """
				SELECT atividade_descricao, atividade_data_fim FROM atividade a
				JOIN acompanhamento ac ON a.atividade_id = ac.atividade_id
				JOIN participante p ON ac.participante_id = p.participante_id
				JOIN estudante e ON p.estudante_id = e.estudante_id
				WHERE e.usuario_id = ?
				ORDER BY a.atividade_data_fim LIMIT 2
			""";

	public String getGetLatestAtividadesByUsuarioId() {
		return getLatestAtividadesByUsuarioId;
	}
	
	
}
