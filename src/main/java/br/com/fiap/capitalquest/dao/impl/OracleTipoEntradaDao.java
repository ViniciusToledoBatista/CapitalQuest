package br.com.fiap.capitalquest.dao.impl;

import br.com.fiap.capitalquest.dao.TipoEntradaDao;
import br.com.fiap.capitalquest.factory.ConnectionFactory;
import br.com.fiap.capitalquest.model.TipoEntrada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleTipoEntradaDao implements TipoEntradaDao {

    private Connection conexao;

    public OracleTipoEntradaDao() {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter conexão para OracleTipoEntradaDao", e);
        }
    }

    @Override
    public List<TipoEntrada> listar() throws Exception {
        List<TipoEntrada> lista = new ArrayList<>();

        String sql = "SELECT CD_TIPO_ENTRADA, NM_TIPO_ENTRADA FROM T_CQ_TIPO_ENTRADA ORDER BY CD_TIPO_ENTRADA";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("CD_TIPO_ENTRADA");
                String nome = rs.getString("NM_TIPO_ENTRADA");
                TipoEntrada tipo = new TipoEntrada(codigo, nome);
                lista.add(tipo);
            }
        }

        return lista;
    }
}
