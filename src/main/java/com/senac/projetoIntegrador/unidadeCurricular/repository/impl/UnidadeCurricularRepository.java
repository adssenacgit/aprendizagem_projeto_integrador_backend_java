package com.senac.projetoIntegrador.unidadeCurricular.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.senac.projetoIntegrador.unidadeCurricular.dto.UnidadeCurricularDto;
import com.senac.projetoIntegrador.unidadeCurricular.repository.IUnidadeCurricularRepository;

@Repository
public class UnidadeCurricularRepository implements IUnidadeCurricularRepository{
	private JdbcTemplate dbConnection;
	
	@Autowired
	QueriesUnidadeCurricular queries;
	
	private class UnidadeCurricularMapper implements RowMapper<UnidadeCurricularDto>{
		@Override
		public UnidadeCurricularDto mapRow(ResultSet rs, int rowNum) throws SQLException{
			UnidadeCurricularDto unidadeCurricularDto = new UnidadeCurricularDto();
			unidadeCurricularDto.setNomeCurto(rs.getString("unidade_curricular_nome_curto"));
			return unidadeCurricularDto;
		}
	}
	
	@Autowired
	private void dbConnection(@Qualifier("dbConnection") DataSource dbConn) {
		this.dbConnection = new JdbcTemplate(dbConn);
	}

	@Override
	public List<UnidadeCurricularDto> getCurrentUnidadesCurricularesByUsuarioId(String usuarioId) {
		return dbConnection.query(queries.getGetUnidadesCurricularesAtuaisById(), new UnidadeCurricularMapper(), new Object[] {usuarioId});
	}

	@Override
	public List<UnidadeCurricularDto> getLatestAtividadesUnidadesCurricularesByUsuarioId(String usuarioId) {
		return dbConnection.query(queries.getGetLatestAtividadesUnidadesCurricularesByUsuarioId(), new UnidadeCurricularMapper(), new Object[] {usuarioId});
	}
}
