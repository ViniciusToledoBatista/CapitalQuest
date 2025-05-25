package br.com.fiap.capitalquest.controller;

import br.com.fiap.capitalquest.dao.SaidaDao;
import br.com.fiap.capitalquest.dao.impl.OracleSaidaDao;
import br.com.fiap.capitalquest.model.Cadastro;
import br.com.fiap.capitalquest.model.Saida;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/saida-lista")
public class SaidaListaServlet extends HttpServlet {

    private SaidaDao saidaDao;

    @Override
    public void init() throws ServletException {
        saidaDao = new OracleSaidaDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        Cadastro usuarioLogado = (Cadastro) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int cdCadastro = usuarioLogado.getCodigo();

        try {
            List<Saida> listaSaidas = saidaDao.listarPorCadastro(cdCadastro);
            request.setAttribute("listaSaidas", listaSaidas);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao listar saídas: " + e.getMessage());
        }

        request.getRequestDispatcher("saida-lista.jsp").forward(request, response);
    }

    // POST para deletar as saídas selecionadas
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        Cadastro usuarioLogado = (Cadastro) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String[] codigosSelecionados = request.getParameterValues("saidaSelecionada");

        if (codigosSelecionados != null) {
            try {
                for (String codigoStr : codigosSelecionados) {
                    int codigo = Integer.parseInt(codigoStr);
                    saidaDao.deletar(codigo);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("erro", "Erro ao excluir saídas: " + e.getMessage());
            }
        }

        response.sendRedirect("saida-lista");
    }
}
