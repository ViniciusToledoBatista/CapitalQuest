package br.com.fiap.capitalquest.factory;

import br.com.fiap.capitalquest.dao.*;
import br.com.fiap.capitalquest.dao.impl.*;

public class DaoFactory {

    public static CadastroDao getCadastroDAO() {
        return new OracleCadastroDao();
    }

    public static EntradaDao getEntradaDao() {
        return new OracleEntradaDao();
    }

    public static SaidaDao getSaidaDao() {
        return new OracleSaidaDao();
    }

    public static TipoSaidaDao getTipoSaidaDao() {
        return new OracleTipoSaidaDao();
    }

    public static TipoEntradaDao getTipoEntradaDao() {
        return new OracleTipoEntradaDao();
    }

    public static InvestimentoDao getInvestimentoDao() {
        return new OracleInvestimentoDao();
    }

    public static TipoInvestimentoDao getTipoInvestimentoDao() {
        return new OracleTipoInvestimentoDao();
    }
}
