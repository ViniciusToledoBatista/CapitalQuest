package br.com.fiap.capitalquest.controller;

import br.com.fiap.capitalquest.dao.EntradaDao;
import br.com.fiap.capitalquest.dao.impl.OracleEntradaDao;
import br.com.fiap.capitalquest.model.Cadastro;
import br.com.fiap.capitalquest.model.Entrada;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/entrada-lista")
public class EntradaListaServlet extends HttpServlet {

    private EntradaDao entradaDao;

    @Override
    public void init() throws ServletException {
        entradaDao = new OracleEntradaDao();
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
            List<Entrada> listaEntradas = entradaDao.listarPorCadastro(cdCadastro);
            request.setAttribute("listaEntradas", listaEntradas);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao listar entradas: " + e.getMessage());
        }

        request.getRequestDispatcher("entrada-lista.jsp").forward(request, response);
    }

    // 🔥 POST para deletar as entradas selecionadas
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

        String[] codigosSelecionados = request.getParameterValues("entradaSelecionada");

        if (codigosSelecionados != null) {
            try {
                for (String codigoStr : codigosSelecionados) {
                    int codigo = Integer.parseInt(codigoStr);
                    entradaDao.deletar(codigo);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("erro", "Erro ao excluir entradas: " + e.getMessage());
            }
        }

        response.sendRedirect("entrada-lista");
    }
}
