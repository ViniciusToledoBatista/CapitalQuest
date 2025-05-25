package br.com.fiap.capitalquest.test;

import br.com.fiap.capitalquest.dao.TipoSaidaDao;
import br.com.fiap.capitalquest.dao.impl.OracleTipoSaidaDao;
import br.com.fiap.capitalquest.model.TipoSaida;

import java.util.List;

public class TipoSaidaDaoTest {

    public static void main(String[] args) {
        // Cria a instância do DAO
        TipoSaidaDao dao = new OracleTipoSaidaDao();

        try {
            // Recupera a lista de tipos de saída do banco
            List<TipoSaida> tipos = dao.listar();

            // Imprime os tipos completos
            System.out.println("Lista de Tipos de Saída:");
            if (tipos.isEmpty()) {
                System.out.println("Nenhum tipo de saída encontrado.");
            } else {
                for (TipoSaida tipo : tipos) {
                    System.out.println("Código: " + tipo.getCodigo() + " - Nome: " + tipo.getNome());
                }
            }

        } catch (Exception e) {
            // Caso ocorra algum erro, imprime a stack trace para diagnóstico
            e.printStackTrace();
        }
    }
}
