package br.com.fiap.capitalquest.dao;

import br.com.fiap.capitalquest.exception.DBException;
import br.com.fiap.capitalquest.model.Cadastro;

import java.util.List;

public interface CadastroDao {

    void cadastrar(Cadastro cadastro) throws DBException;

    void atualizar(Cadastro cadastro) throws DBException;

    void remover(int codigo) throws DBException;

    List<Cadastro> listar();

    Cadastro buscarPorEmail(String email);

}