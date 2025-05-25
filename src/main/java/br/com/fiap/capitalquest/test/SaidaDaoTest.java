package br.com.fiap.capitalquest.test;

import br.com.fiap.capitalquest.dao.SaidaDao;
import br.com.fiap.capitalquest.dao.impl.OracleSaidaDao;
import br.com.fiap.capitalquest.model.Saida;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class SaidaDaoTest {

    public static void main(String[] args) {
        try {
            SaidaDao dao = new OracleSaidaDao();

            int codigoCadastro = 24;       // Ajuste conforme base de dados
            int codigoTipoSaida = 29;      // Ajuste conforme base de dados

            // 1) Teste inserção
            Saida novaSaida = new Saida();
            novaSaida.setDescricao("Teste de inserção - compras");
            novaSaida.setValor(150.00);
            novaSaida.setData(Date.valueOf(LocalDate.now())); // java.sql.Date
            novaSaida.setCodigoTipoSaida(codigoTipoSaida);
            novaSaida.setCodigoCadastro(codigoCadastro);

            dao.inserir(novaSaida);
            System.out.println("Inserção realizada com sucesso.");

            // 2) Teste listagem por cadastro
            List<Saida> saidas = dao.listarPorCadastro(codigoCadastro);
            System.out.println("Saídas encontradas para o cadastro " + codigoCadastro + ":");
            for (Saida s : saidas) {
                System.out.println("Código: " + s.getCodigo() +
                        ", Descrição: " + s.getDescricao() +
                        ", Valor: " + s.getValor() +
                        ", Data: " + s.getData() +
                        ", TipoSaida: " + s.getCodigoTipoSaida() +
                        ", Cadastro: " + s.getCodigoCadastro());
            }

            // 3) Teste deletar a saída recém inserida (pega a última saída inserida na lista)
            if (!saidas.isEmpty()) {
                int codigoUltimaSaida = saidas.get(0).getCodigo();
                dao.deletar(codigoUltimaSaida);
                System.out.println("Saída com código " + codigoUltimaSaida + " deletada com sucesso.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
