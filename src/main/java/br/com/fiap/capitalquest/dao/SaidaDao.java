package br.com.fiap.capitalquest.dao;

import br.com.fiap.capitalquest.model.Saida;
import java.util.List;

public interface SaidaDao {

    // Inserir uma nova saída
    void inserir(Saida saida) throws Exception;

    // Deletar uma saída pelo código
    void deletar(int codigoSaida) throws Exception;

    // Listar todas as saídas de um cadastro (ordenadas por data decrescente)
    List<Saida> listarPorCadastro(int codigoCadastro) throws Exception;

}
