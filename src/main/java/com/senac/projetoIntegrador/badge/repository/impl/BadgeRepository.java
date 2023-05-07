package com.senac.projetoIntegrador.badge.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.senac.projetoIntegrador.badge.dto.BadgeDto;
import com.senac.projetoIntegrador.badge.repository.IBadgeRepository;

@Repository
public class BadgeRepository implements IBadgeRepository{
	private JdbcTemplate dbConnection;
	
	@Autowired
	QueriesBadge queries;
	
	private class BadgeMapper implements RowMapper<BadgeDto>{
		@Override
		public BadgeDto mapRow(ResultSet rs, int rowNum) throws SQLException{
			BadgeDto badgeDto = new BadgeDto();
			badgeDto.setDescricao(rs.getString("badge_descricao"));
			badgeDto.setImagem(rs.getBlob("badge_imagem"));
			return badgeDto;
		}
	}
	
	@Autowired
	private void dbConnection(@Qualifier("dbConnection") DataSource dbConn) {
		this.dbConnection = new JdbcTemplate(dbConn);
	}

	public List<BadgeDto> getLatestBadgesByUsuarioId(String usuarioId) {
		return dbConnection.query(queries.getGetLatestBadgesByUsuarioId(), new BadgeMapper(), new Object[] {usuarioId});
	}
}
