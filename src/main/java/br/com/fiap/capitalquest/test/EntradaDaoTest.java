package br.com.fiap.capitalquest.test;

import br.com.fiap.capitalquest.dao.EntradaDao;
import br.com.fiap.capitalquest.dao.impl.OracleEntradaDao;
import br.com.fiap.capitalquest.model.Entrada;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class EntradaDaoTest {

    public static void main(String[] args) {
        try {
            EntradaDao dao = new OracleEntradaDao();

            int codigoCadastro = 24;       // Ajuste conforme base de dados
            int codigoTipoEntrada = 20;    // Ajuste conforme base de dados

            // 1) Teste inserção
            Entrada novaEntrada = new Entrada();
            novaEntrada.setDescricao("Teste de inserção - salário");
            novaEntrada.setValor(2500.00);
            novaEntrada.setData(Date.valueOf(LocalDate.now())); // java.sql.Date
            novaEntrada.setCodigoTipoEntrada(codigoTipoEntrada);
            novaEntrada.setCodigoCadastro(codigoCadastro);

            dao.inserir(novaEntrada);
            System.out.println("Inserção realizada com sucesso.");

            // 2) Teste listagem por cadastro
            List<Entrada> entradas = dao.listarPorCadastro(codigoCadastro);
            System.out.println("Entradas encontradas para o cadastro " + codigoCadastro + ":");
            for (Entrada e : entradas) {
                System.out.println("Código: " + e.getCodigo() +
                        ", Descrição: " + e.getDescricao() +
                        ", Valor: " + e.getValor() +
                        ", Data: " + e.getData() +
                        ", TipoEntrada: " + e.getCodigoTipoEntrada() +
                        ", Cadastro: " + e.getCodigoCadastro());
            }

            // 3) Teste deletar a entrada recém inserida (pega a última entrada inserida na lista)
            if (!entradas.isEmpty()) {
                int codigoUltimaEntrada = entradas.get(0).getCodigo();
                dao.deletar(codigoUltimaEntrada);
                System.out.println("Entrada com código " + codigoUltimaEntrada + " deletada com sucesso.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
