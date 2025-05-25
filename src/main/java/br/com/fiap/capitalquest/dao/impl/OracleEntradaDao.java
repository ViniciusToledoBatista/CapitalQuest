package br.com.fiap.capitalquest.dao.impl;

import br.com.fiap.capitalquest.dao.EntradaDao;
import br.com.fiap.capitalquest.factory.ConnectionFactory;
import br.com.fiap.capitalquest.model.Entrada;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleEntradaDao implements EntradaDao {

    private final Connection conexao;

    public OracleEntradaDao() {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter conexão no OracleEntradaDao", e);
        }
    }

    @Override
    public void inserir(Entrada entrada) throws Exception {
        String sql = "INSERT INTO T_CQ_ENTRADA " +
                "(DS_ENTRADA, VL_ENTRADA, DT_ENTRADA, CD_TIPO_ENTRADA, CD_CADASTRO) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, entrada.getDescricao());
            ps.setDouble(2, entrada.getValor());

            if (entrada.getData() != null) {
                ps.setDate(3, new Date(entrada.getData().getTime()));
            } else {
                ps.setDate(3, null);
            }

            ps.setInt(4, entrada.getCodigoTipoEntrada());
            ps.setInt(5, entrada.getCodigoCadastro());

            ps.executeUpdate();
        }
    }

    @Override
    public void deletar(int codigoEntrada) throws Exception {
        String sql = "DELETE FROM T_CQ_ENTRADA WHERE CD_ENTRADA = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, codigoEntrada);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Entrada> listarPorCadastro(int codigoCadastro) throws Exception {
        String sql = "SELECT CD_ENTRADA, DT_ENTRADA, DS_ENTRADA, VL_ENTRADA, CD_TIPO_ENTRADA " +
                "FROM T_CQ_ENTRADA " +
                "WHERE CD_CADASTRO = ? " +
                "ORDER BY DT_ENTRADA DESC";

        List<Entrada> lista = new ArrayList<>();

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, codigoCadastro);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Entrada entrada = new Entrada();
                    entrada.setCodigo(rs.getInt("CD_ENTRADA"));
                    entrada.setData(rs.getDate("DT_ENTRADA"));
                    entrada.setDescricao(rs.getString("DS_ENTRADA"));
                    entrada.setValor(rs.getDouble("VL_ENTRADA"));
                    entrada.setCodigoTipoEntrada(rs.getInt("CD_TIPO_ENTRADA"));
                    entrada.setCodigoCadastro(codigoCadastro);

                    lista.add(entrada);
                }
            }
        }

        return lista;
    }
}
