package br.com.fiap.capitalquest.test;

import br.com.fiap.capitalquest.dao.CadastroDao;
import br.com.fiap.capitalquest.exception.DBException;
import br.com.fiap.capitalquest.factory.DaoFactory;
import br.com.fiap.capitalquest.model.Cadastro;

public class CadastroDaoTest {

    public static void main(String[] args) {

        CadastroDao dao = DaoFactory.getCadastroDAO();

        //Cadastrar um produto
        Cadastro cadastro = new Cadastro(
                0,
                "Vanessa",
                "Nascimento",
                "912345678",
                "vanessa.nutri@icloud.com",
                "rose"

        );

        /*try {
            dao.cadastrar(cadastro);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }*/

        //Buscar um cadastro pelo email e atualizar
        /*cadastro = dao.buscarPorEmail("vinitoledob@icloud.com");
        cadastro.setNome("Vini");
        cadastro.setSobrenome("Batista");
        try {
            dao.atualizar(cadastro);
        } catch (DBException e) {
            e.printStackTrace();
        }*/





        /*//Listar os cadastros
        List<Cadastro> lista = dao.listar();
        for (Cadastro item : lista) {
            System.out.println(
                    item.getCodigo() + " " +
                            item.getNome() + " " +
                            item.getSobrenome() + " " +
                            item.getTelefone() + " " +
                            item.getEmail() + " " +
                            item.getSenha());
        }*/

        //Remover um produto
        try {
            dao.remover(4);
        } catch (DBException e) {
            e.printStackTrace();
        }


    }
}
