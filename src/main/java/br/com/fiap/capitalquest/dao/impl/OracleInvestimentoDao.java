package br.com.fiap.capitalquest.dao.impl;

import br.com.fiap.capitalquest.dao.InvestimentoDao;
import br.com.fiap.capitalquest.factory.ConnectionFactory;
import br.com.fiap.capitalquest.model.Investimento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleInvestimentoDao implements InvestimentoDao {

    private final Connection conexao;

    public OracleInvestimentoDao() {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter conexão no OracleInvestimentoDao", e);
        }
    }

    @Override
    public void inserir(Investimento investimento) throws Exception {
        String sql = "INSERT INTO T_CQ_INVESTIMENTO " +
                "(DS_INVESTIMENTO, VL_INVESTIMENTO, DT_INVESTIMENTO, CD_TIPO_INVESTIMENTO, CD_CADASTRO) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, investimento.getDescricao());
            ps.setDouble(2, investimento.getValor());

            if (investimento.getData() != null) {
                ps.setDate(3, new Date(investimento.getData().getTime()));
            } else {
                ps.setDate(3, null);
            }

            ps.setInt(4, investimento.getCodigoTipoInvestimento());
            ps.setInt(5, investimento.getCodigoCadastro());

            ps.executeUpdate();
        }
    }

    @Override
    public void deletar(int codigoInvestimento) throws Exception {
        String sql = "DELETE FROM T_CQ_INVESTIMENTO WHERE CD_INVESTIMENTO = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, codigoInvestimento);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Investimento> listarPorCadastro(int codigoCadastro) throws Exception {
        String sql = "SELECT CD_INVESTIMENTO, DS_INVESTIMENTO, VL_INVESTIMENTO, DT_INVESTIMENTO, CD_TIPO_INVESTIMENTO " +
                "FROM T_CQ_INVESTIMENTO " +
                "WHERE CD_CADASTRO = ? " +
                "ORDER BY DT_INVESTIMENTO DESC";

        List<Investimento> lista = new ArrayList<>();

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, codigoCadastro);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Investimento investimento = new Investimento();
                    investimento.setCodigo(rs.getInt("CD_INVESTIMENTO"));
                    investimento.setDescricao(rs.getString("DS_INVESTIMENTO"));
                    investimento.setValor(rs.getDouble("VL_INVESTIMENTO"));
                    investimento.setData(rs.getDate("DT_INVESTIMENTO"));
                    investimento.setCodigoTipoInvestimento(rs.getInt("CD_TIPO_INVESTIMENTO"));
                    investimento.setCodigoCadastro(codigoCadastro);

                    lista.add(investimento);
                }
            }
        }

        return lista;
    }
}
