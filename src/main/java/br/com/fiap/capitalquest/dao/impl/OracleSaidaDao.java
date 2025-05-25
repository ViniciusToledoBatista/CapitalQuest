package br.com.fiap.capitalquest.dao.impl;

import br.com.fiap.capitalquest.dao.SaidaDao;
import br.com.fiap.capitalquest.factory.ConnectionFactory;
import br.com.fiap.capitalquest.model.Saida;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleSaidaDao implements SaidaDao {

    private final Connection conexao;

    public OracleSaidaDao() {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter conexão no OracleSaidaDao", e);
        }
    }

    @Override
    public void inserir(Saida saida) throws Exception {
        String sql = "INSERT INTO T_CQ_SAIDA " +
                "(DS_SAIDA, VL_SAIDA, DT_SAIDA, CD_TIPO_SAIDA, CD_CADASTRO) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, saida.getDescricao());
            ps.setDouble(2, saida.getValor());

            if (saida.getData() != null) {
                ps.setDate(3, new Date(saida.getData().getTime()));
            } else {
                ps.setDate(3, null);
            }

            ps.setInt(4, saida.getCodigoTipoSaida());
            ps.setInt(5, saida.getCodigoCadastro());

            ps.executeUpdate();
        }
    }

    @Override
    public void deletar(int codigoSaida) throws Exception {
        String sql = "DELETE FROM T_CQ_SAIDA WHERE CD_SAIDA = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, codigoSaida);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Saida> listarPorCadastro(int codigoCadastro) throws Exception {
        String sql = "SELECT CD_SAIDA, DT_SAIDA, DS_SAIDA, VL_SAIDA, CD_TIPO_SAIDA " +
                "FROM T_CQ_SAIDA " +
                "WHERE CD_CADASTRO = ? " +
                "ORDER BY DT_SAIDA DESC";

        List<Saida> lista = new ArrayList<>();

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, codigoCadastro);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Saida saida = new Saida();
                    saida.setCodigo(rs.getInt("CD_SAIDA"));
                    saida.setData(rs.getDate("DT_SAIDA"));
                    saida.setDescricao(rs.getString("DS_SAIDA"));
                    saida.setValor(rs.getDouble("VL_SAIDA"));
                    saida.setCodigoTipoSaida(rs.getInt("CD_TIPO_SAIDA"));
                    saida.setCodigoCadastro(codigoCadastro);

                    lista.add(saida);
                }
            }
        }

        return lista;
    }
}
