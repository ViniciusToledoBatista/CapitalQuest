package br.com.fiap.capitalquest.test;

import br.com.fiap.capitalquest.dao.TipoEntradaDao;
import br.com.fiap.capitalquest.dao.impl.OracleTipoEntradaDao;
import br.com.fiap.capitalquest.model.TipoEntrada;

import java.util.List;

public class TipoEntradaDaoTest {

    public static void main(String[] args) {
        // Cria a instância do DAO
        TipoEntradaDao dao = new OracleTipoEntradaDao();

        try {
            // Recupera a lista de tipos de entrada do banco
            List<TipoEntrada> tipos = dao.listar();

            // Imprime os tipos completos
            System.out.println("Lista de Tipos de Entrada:");
            if (tipos.isEmpty()) {
                System.out.println("Nenhum tipo de entrada encontrado.");
            } else {
                for (TipoEntrada tipo : tipos) {
                    System.out.println("Código: " + tipo.getCodigo() + " - Nome: " + tipo.getNome());
                }
            }

        } catch (Exception e) {
            // Caso ocorra algum erro, imprime a stack trace para diagnóstico
            e.printStackTrace();
        }
    }
}
