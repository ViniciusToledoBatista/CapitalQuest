package br.com.fiap.capitalquest.dao.impl;

import br.com.fiap.capitalquest.dao.TipoInvestimentoDao;
import br.com.fiap.capitalquest.factory.ConnectionFactory;
import br.com.fiap.capitalquest.model.TipoInvestimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleTipoInvestimentoDao implements TipoInvestimentoDao {

    private Connection conexao;

    public OracleTipoInvestimentoDao() {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter conexão para OracleTipoInvestimentoDao", e);
        }
    }

    @Override
    public void inserir(TipoInvestimento tipoInvestimento) throws Exception {
        String sql = "INSERT INTO T_CQ_TIPO_INVESTIMENTO (NM_TIPO_INVESTIMENTO) VALUES (?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, tipoInvestimento.getNome());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int codigoTipoInvestimento) throws Exception {
        String sql = "DELETE FROM T_CQ_TIPO_INVESTIMENTO WHERE CD_TIPO_INVESTIMENTO = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codigoTipoInvestimento);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<TipoInvestimento> listar() throws Exception {
        List<TipoInvestimento> lista = new ArrayList<>();

        String sql = "SELECT CD_TIPO_INVESTIMENTO, NM_TIPO_INVESTIMENTO " +
                "FROM T_CQ_TIPO_INVESTIMENTO " +
                "ORDER BY CD_TIPO_INVESTIMENTO";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("CD_TIPO_INVESTIMENTO");
                String nome = rs.getString("NM_TIPO_INVESTIMENTO");
                TipoInvestimento tipo = new TipoInvestimento(codigo, nome);
                lista.add(tipo);
            }
        }

        return lista;
    }
}
