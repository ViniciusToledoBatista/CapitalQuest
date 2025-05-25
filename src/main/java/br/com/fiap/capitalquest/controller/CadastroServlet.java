package br.com.fiap.capitalquest.controller;

import br.com.fiap.capitalquest.dao.CadastroDao;
import br.com.fiap.capitalquest.exception.DBException;
import br.com.fiap.capitalquest.factory.DaoFactory;
import br.com.fiap.capitalquest.model.Cadastro;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastro")

public class CadastroServlet extends HttpServlet {

    private CadastroDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getCadastroDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String telefone = req.getParameter("telefone");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Cadastro cadastro = new Cadastro(
                0,
                nome,
                sobrenome,
                telefone,
                email,
                senha
        );

        try {
            dao.cadastrar(cadastro);
            req.setAttribute("sucesso", "Usuário cadastrado com sucesso. faça o Login");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar usuário");
        }

        req.getRequestDispatcher("cadastro.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
