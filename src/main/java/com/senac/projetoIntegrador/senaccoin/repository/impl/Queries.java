package com.senac.projetoIntegrador.senaccoin.repository.impl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Queries {
    private String insertMovimentacao = """
                INSERT INTO senac_coin_movimentacao (senac_coin_movimentacao_data, senac_coin_movimentacao_observacao, senac_coin_movimentacao_valor, senac_coin_movimentacao_status, usuario_id)
                VALUES (?, ?, ?, ?, ?);
            """;
    private String getMovementsByUserId = """
                SELECT senac_coin_movimentacao_data, senac_coin_movimentacao_observacao, senac_coin_movimentacao_valor, senac_coin_movimentacao_status FROM senac_coin_movimentacao
                WHERE usuario_id = ?;
            """;

    private String getBalance = """
                SELECT senac_coin_saldo FROM senac_coin WHERE usuario_id = ?;
            """;

    private String updateSenacCoinAmount = """
                UPDATE senac_coin
                SET senac_coin_saldo = senac_coin_saldo + ?
                WHERE usuario_id = ?;
            """;

    public String getInsertMovimentacao() {
        return insertMovimentacao;
    }

    public String getUpdateSenacCoinAmount() {
        return updateSenacCoinAmount;
    }

    public String getGetMovimentsByUserId() {
        return getMovementsByUserId;
    }

    public String getGetBalance() {
        return getBalance;
    }

    public String getGetMovementsByUserId() {
        return getMovementsByUserId;
    }

}
