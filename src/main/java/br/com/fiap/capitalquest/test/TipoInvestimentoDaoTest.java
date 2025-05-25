package br.com.fiap.capitalquest.test;

import br.com.fiap.capitalquest.dao.TipoInvestimentoDao;
import br.com.fiap.capitalquest.dao.impl.OracleTipoInvestimentoDao;
import br.com.fiap.capitalquest.model.TipoInvestimento;

import java.util.List;

public class TipoInvestimentoDaoTest {

    public static void main(String[] args) {
        // Cria a instância do DAO
        TipoInvestimentoDao dao = new OracleTipoInvestimentoDao();

        try {
            // Recupera a lista de tipos de investimento do banco
            List<TipoInvestimento> tipos = dao.listar();

            // Imprime os tipos completos
            System.out.println("Lista de Tipos de Investimento:");
            if (tipos.isEmpty()) {
                System.out.println("Nenhum tipo de investimento encontrado.");
            } else {
                for (TipoInvestimento tipo : tipos) {
                    System.out.println("Código: " + tipo.getCodigo() + " - Nome: " + tipo.getNome());
                }
            }

        } catch (Exception e) {
            // Caso ocorra algum erro, imprime a stack trace para diagnóstico
            e.printStackTrace();
        }
    }
}
