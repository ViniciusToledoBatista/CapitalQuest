package br.com.fiap.capitalquest.dao;

import br.com.fiap.capitalquest.model.TipoEntrada;
import java.util.List;

public interface TipoEntradaDao {

    List<TipoEntrada> listar() throws Exception;

}
