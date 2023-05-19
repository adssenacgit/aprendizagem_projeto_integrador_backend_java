package com.senac.projetoIntegrador.usuario.repository.impl;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QueriesUsuario {
	private String getUsuarioById = """
				SELECT * FROM usuario WHERE Id = ?;
			""";

	public String getGetUsuarioById() {
		return getUsuarioById;
	}
}
