package br.com.fiap.capitalquest.test;

import br.com.fiap.capitalquest.dao.InvestimentoDao;
import br.com.fiap.capitalquest.dao.impl.OracleInvestimentoDao;
import br.com.fiap.capitalquest.model.Investimento;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class InvestimentoDaoTest {

    public static void main(String[] args) {
        try {
            InvestimentoDao dao = new OracleInvestimentoDao();

            int codigoCadastro = 24;         // Ajuste conforme base de dados
            int codigoTipoInvestimento = 35; // Ajuste conforme base de dados

            // 1) Teste inserção
            Investimento novoInvestimento = new Investimento();
            novoInvestimento.setDescricao("Teste de inserção - renda fixa");
            novoInvestimento.setValor(1000.00);
            novoInvestimento.setData(Date.valueOf(LocalDate.now())); // java.sql.Date
            novoInvestimento.setCodigoTipoInvestimento(codigoTipoInvestimento);
            novoInvestimento.setCodigoCadastro(codigoCadastro);

            dao.inserir(novoInvestimento);
            System.out.println("Inserção realizada com sucesso.");

            // 2) Teste listagem por cadastro
            List<Investimento> investimentos = dao.listarPorCadastro(codigoCadastro);
            System.out.println("Investimentos encontrados para o cadastro " + codigoCadastro + ":");
            for (Investimento i : investimentos) {
                System.out.println("Código: " + i.getCodigo() +
                        ", Descrição: " + i.getDescricao() +
                        ", Valor: " + i.getValor() +
                        ", Data: " + i.getData() +
                        ", TipoInvestimento: " + i.getCodigoTipoInvestimento() +
                        ", Cadastro: " + i.getCodigoCadastro());
            }

            // 3) Teste deletar o investimento recém inserido (pega o último investimento inserido na lista)
            if (!investimentos.isEmpty()) {
                int codigoUltimoInvestimento = investimentos.get(0).getCodigo();
                dao.deletar(codigoUltimoInvestimento);
                System.out.println("Investimento com código " + codigoUltimoInvestimento + " deletado com sucesso.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
