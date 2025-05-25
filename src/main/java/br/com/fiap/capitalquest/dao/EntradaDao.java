package br.com.fiap.capitalquest.dao;

import br.com.fiap.capitalquest.model.Entrada;

import java.sql.Date;
import java.util.List;

public interface EntradaDao {

    // Inserir uma nova entrada
    void inserir(Entrada entrada) throws Exception;

    // Deletar uma entrada pelo código
    void deletar(int codigoEntrada) throws Exception;

    // Listar todas as entradas de um cadastro (ordenadas por data decrescente)
    List<Entrada> listarPorCadastro(int codigoCadastro) throws Exception;

}
