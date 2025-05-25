package br.com.fiap.capitalquest.dao.impl;

import br.com.fiap.capitalquest.dao.TipoSaidaDao;
import br.com.fiap.capitalquest.factory.ConnectionFactory;
import br.com.fiap.capitalquest.model.TipoSaida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleTipoSaidaDao implements TipoSaidaDao {

    private Connection conexao;

    public OracleTipoSaidaDao() {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter conexão para OracleTipoSaidaDao", e);
        }
    }

    @Override
    public List<TipoSaida> listar() throws Exception {
        List<TipoSaida> lista = new ArrayList<>();

        String sql = "SELECT CD_TIPO_SAIDA, NM_TIPO_SAIDA FROM T_CQ_TIPO_SAIDA ORDER BY CD_TIPO_SAIDA";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("CD_TIPO_SAIDA");
                String nome = rs.getString("NM_TIPO_SAIDA");
                TipoSaida tipo = new TipoSaida(codigo, nome);
                lista.add(tipo);
            }
        }

        return lista;
    }
}
