package com.senac.projetoIntegrador.atividade.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.senac.projetoIntegrador.atividade.dto.AtividadeDto;
import com.senac.projetoIntegrador.atividade.repository.IAtividadeRepository;

@Repository
public class AtividadeRepository implements IAtividadeRepository{
	private JdbcTemplate dbConnection;
	
	@Autowired
	QueriesAtiviadade queries;
	
	private class AtividadeMapper implements RowMapper<AtividadeDto> {
		@Override
		public AtividadeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			AtividadeDto atividadeDto = new AtividadeDto();
			atividadeDto.setDescricao(rs.getString("atividade_descricao"));
			atividadeDto.setDataFim(rs.getTimestamp("atividade_data_fim"));
			return atividadeDto;
		}
	}
	
	@Autowired
	private void dbConnection(@Qualifier("dbConnection") DataSource dbConn) {
		this.dbConnection = new JdbcTemplate(dbConn);
	}
	
	public List<AtividadeDto> getLatestAtividadesByUsuarioId(String usuarioId){
		return dbConnection.query(queries.getGetLatestAtividadesByUsuarioId(), new AtividadeMapper(), new Object[] {usuarioId});
	}
}
