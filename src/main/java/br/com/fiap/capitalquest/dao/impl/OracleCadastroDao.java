package br.com.fiap.capitalquest.dao.impl;

import br.com.fiap.capitalquest.factory.ConnectionFactory;
import br.com.fiap.capitalquest.dao.CadastroDao;
import br.com.fiap.capitalquest.exception.DBException;
import br.com.fiap.capitalquest.model.Cadastro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleCadastroDao implements CadastroDao {

    private Connection conexao;

    @Override
    public void cadastrar(Cadastro cadastro) throws DBException {
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = ConnectionFactory.getInstance().getConnection();

            String sql = "INSERT INTO T_CQ_CADASTRO (DS_NOME, DS_SOBRENOME, NR_TELEFONE, DS_EMAIL, DS_SENHA) " +
                    "VALUES (?, ?, ?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cadastro.getNome());
            stmt.setString(2, cadastro.getSobrenome());
            stmt.setString(3, cadastro.getTelefone());
            stmt.setString(4, cadastro.getEmail());
            stmt.setString(5, cadastro.getSenha());

            stmt.executeUpdate();

            System.out.println("Cadastro inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void atualizar(Cadastro cadastro) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionFactory.getInstance().getConnection();

            String sql = "UPDATE T_CQ_CADASTRO SET " +
                    "DS_NOME = ?, " +
                    "DS_SOBRENOME = ?, " +
                    "NR_TELEFONE = ?, " +
                    "DS_SENHA = ? " +
                    "WHERE DS_EMAIL = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cadastro.getNome());
            stmt.setString(2, cadastro.getSobrenome());
            stmt.setString(3, cadastro.getTelefone());
            stmt.setString(4, cadastro.getSenha());
            stmt.setString(5, cadastro.getEmail());

            stmt.executeUpdate();

            System.out.println("Cadastro atualizado.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void remover(int codigo) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "DELETE FROM T_CQ_CADASTRO WHERE CD_CADASTRO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();

            System.out.println("Cadastro removido.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List <Cadastro> listar(){

        List<Cadastro> lista = new ArrayList<Cadastro>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM T_CQ_CADASTRO";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            //Percorre todos os registros encontrados
            while (rs.next()) {
                int codigo = rs.getInt("CD_CADASTRO");
                String nome = rs.getString("DS_NOME");
                String sobrenome = rs.getString("DS_SOBRENOME");
                String telefone = rs.getString("NR_TELEFONE");
                String email = rs.getString("DS_EMAIL");
                String senha = rs.getString("DS_SENHA");



                Cadastro cadastro = new Cadastro(
                        codigo, nome, sobrenome, telefone, email, senha
                );
                lista.add(cadastro);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;

    }

    @Override
    public Cadastro buscarPorEmail(String email) {
        Cadastro cadastro = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM T_CQ_CADASTRO WHERE DS_EMAIL = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()){
                int codigo = rs.getInt("CD_CADASTRO");
                String nome = rs.getString("DS_NOME");
                String sobrenome = rs.getString("DS_SOBRENOME");
                String telefone = rs.getString("NR_TELEFONE");
                String senha = rs.getString("DS_SENHA");

                cadastro = new Cadastro(codigo, nome, sobrenome, telefone, email, senha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cadastro;
    }


}
