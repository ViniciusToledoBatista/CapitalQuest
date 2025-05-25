package br.com.fiap.capitalquest.dao;

import br.com.fiap.capitalquest.model.TipoSaida;
import java.util.List;

public interface TipoSaidaDao {

    List<TipoSaida> listar() throws Exception;

}
