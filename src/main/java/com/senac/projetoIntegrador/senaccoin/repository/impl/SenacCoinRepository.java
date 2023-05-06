package com.senac.projetoIntegrador.senaccoin.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.senac.projetoIntegrador.senaccoin.dto.SenacCoinDto;
import com.senac.projetoIntegrador.senaccoin.dto.SenacCoinMovimentacaoDto;
import com.senac.projetoIntegrador.senaccoin.dto.enums.MovimentStatus;
import com.senac.projetoIntegrador.senaccoin.exceptions.UserNotFoundException;
import com.senac.projetoIntegrador.senaccoin.repository.ISenacCoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class SenacCoinRepository implements ISenacCoinRepository {

    private Logger logger = LoggerFactory.getLogger(SenacCoinRepository.class);

    private JdbcTemplate dbConnection;

    @Autowired
    Queries queries;

    private class SenacCoinMapper implements RowMapper<SenacCoinDto> {

        @Override
        public SenacCoinDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            SenacCoinDto senacCoinDto = new SenacCoinDto();
            senacCoinDto.setSenacCoinSaldo(rs.getLong("senac_coin_saldo"));
            return senacCoinDto;
        }
    }

    private class SenacCoinMovimentacaoMapper implements RowMapper<SenacCoinMovimentacaoDto> {

        @Override
        public SenacCoinMovimentacaoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            SenacCoinMovimentacaoDto senacCoinMovimentacaoDto = new SenacCoinMovimentacaoDto();
            senacCoinMovimentacaoDto.setSenacCoinMovimentacaoDate(rs.getTimestamp("senac_coin_movimentacao_data"));
            senacCoinMovimentacaoDto
                    .setSenacCoinMovimentacaoObservacao(rs.getString("senac_coin_movimentacao_observacao"));
            senacCoinMovimentacaoDto.setSenacCoinMovimentacaoValor(rs.getLong("senac_coin_movimentacao_valor"));
            senacCoinMovimentacaoDto.setSenacCoinMovimentacaoStatus(MovimentStatus.valueOf(rs.getString("senac_coin_movimentacao_status")));
            return senacCoinMovimentacaoDto;
        }

    }

    @Autowired
    private void dbConnection(@Qualifier("dbConnection") DataSource dbConn) {
        this.dbConnection = new JdbcTemplate(dbConn);
    }

    @Async("asyncExecutor")
    public CompletableFuture<Integer> addMovement(SenacCoinMovimentacaoDto movement) {
        int numberOfRows = this.dbConnection.update(queries.getInsertMovimentacao(),
                new Object[] {
                        movement.getSenacCoinMovimentacaoDate(),
                        movement.getSenacCoinMovimentacaoObservacao(),
                        movement.getSenacCoinMovimentacaoValor(),
                        movement.getSenacCoinMovimentacaoStatus().toString(),
                        movement.getUsuarioId()
                });

        return CompletableFuture.completedFuture(Integer.valueOf(numberOfRows));
    }

    @Async("asyncExecutor")
    public CompletableFuture<Integer> updateBalance(SenacCoinMovimentacaoDto movement) {
        int numberOfRows = this.dbConnection.update(queries.getUpdateSenacCoinAmount(),
                new Object[] { movement.getSenacCoinMovimentacaoValor(), movement.getUsuarioId() });

        return CompletableFuture.completedFuture(Integer.valueOf(numberOfRows));
        
    }

    public List<SenacCoinMovimentacaoDto> getMovimentsByUserId(String userId) {
        return dbConnection.query(queries.getGetMovimentsByUserId(), new SenacCoinMovimentacaoMapper(),
                new Object[] { userId });

    }


    public Long getBalanceByUserId(String userId) throws UserNotFoundException {
        try {
            return dbConnection.queryForObject(queries.getGetBalance(), new SenacCoinMapper(), new Object[] { userId }).getSenacCoinSaldo();
        } catch (EmptyResultDataAccessException e) {
            logger.error(String.format("Failed to fetch balance to user %s. User not found", userId));
            throw new UserNotFoundException(String.format("User with id %s not found", userId));
        }
    }

}
