package br.com.fiap.capitalquest.dao;

import br.com.fiap.capitalquest.model.Investimento;
import java.util.List;

public interface InvestimentoDao {

    // Inserir um novo investimento
    void inserir(Investimento investimento) throws Exception;

    // Deletar um investimento pelo código
    void deletar(int codigoInvestimento) throws Exception;

    // Listar todos os investimentos de um cadastro (ordenados por data decrescente)
    List<Investimento> listarPorCadastro(int codigoCadastro) throws Exception;

}
