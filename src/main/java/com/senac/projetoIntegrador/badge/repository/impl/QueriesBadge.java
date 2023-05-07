package com.senac.projetoIntegrador.badge.repository.impl;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QueriesBadge {
	private String getLatestBadgesByUsuarioId = """
				SELECT b.badge_descricao, b.badge_imagem, ac.acompanhamento_finalizacao FROM badge b
				JOIN acompanhamento ac ON b.badge_id = ac.badge_id
				JOIN participante p ON ac.participante_id = p.participante_id
				JOIN estudante e ON p.estudante_id = e.estudante_id
				WHERE e.usuario_id = ? AND ac.acompanhamento_finalizacao IS NOT NULL
				ORDER BY ac.acompanhamento_finalizacao LIMIT 3
			""";

	public String getGetLatestBadgesByUsuarioId() {
		return getLatestBadgesByUsuarioId;
	}

	public void setGetLatestBadgesByUsuarioId(String getLatestBadgesByUsuarioId) {
		this.getLatestBadgesByUsuarioId = getLatestBadgesByUsuarioId;
	}
}
