package br.com.fiap.capitalquest.controller;

import br.com.fiap.capitalquest.dao.CadastroDao;
import br.com.fiap.capitalquest.factory.DaoFactory;
import br.com.fiap.capitalquest.model.Cadastro;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private CadastroDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = DaoFactory.getCadastroDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        try {
            Cadastro cadastro = dao.buscarPorEmail(email);

            if (cadastro != null && senha != null && senha.equals(cadastro.getSenha())) {
                // Sucesso no login - salva o usuário na sessão
                req.getSession().setAttribute("usuarioLogado", cadastro);
                resp.sendRedirect("home.jsp");
            } else {
                // Dados incorretos - retorna com mensagem de erro
                req.setAttribute("erro", "E-mail ou senha inválidos.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao acessar o banco de dados.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Opcional: redirecionar para login ou tratar requisições GET
        resp.sendRedirect("login.jsp");
    }
}
