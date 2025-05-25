package br.com.fiap.capitalquest.dao;

import br.com.fiap.capitalquest.model.TipoInvestimento;
import java.util.List;

public interface TipoInvestimentoDao {

    // Inserir um novo tipo de investimento
    void inserir(TipoInvestimento tipoInvestimento) throws Exception;

    // Deletar um tipo de investimento pelo código
    void deletar(int codigoTipoInvestimento) throws Exception;

    // Listar todos os tipos de investimento
    List<TipoInvestimento> listar() throws Exception;

}
