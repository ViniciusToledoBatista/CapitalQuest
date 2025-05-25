package br.com.fiap.capitalquest.controller;

import br.com.fiap.capitalquest.dao.InvestimentoDao;
import br.com.fiap.capitalquest.dao.impl.OracleInvestimentoDao;
import br.com.fiap.capitalquest.model.Cadastro;
import br.com.fiap.capitalquest.model.Investimento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/investimento-lista")
public class InvestimentoListaServlet extends HttpServlet {

    private InvestimentoDao investimentoDao;

    @Override
    public void init() throws ServletException {
        investimentoDao = new OracleInvestimentoDao();
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
            List<Investimento> listaInvestimentos = investimentoDao.listarPorCadastro(cdCadastro);
            request.setAttribute("listaInvestimentos", listaInvestimentos);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao listar investimentos: " + e.getMessage());
        }

        request.getRequestDispatcher("investimento-lista.jsp").forward(request, response);
    }

    // POST para deletar os investimentos selecionados
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

        String[] codigosSelecionados = request.getParameterValues("investimentoSelecionado");

        if (codigosSelecionados != null) {
            try {
                for (String codigoStr : codigosSelecionados) {
                    int codigo = Integer.parseInt(codigoStr);
                    investimentoDao.deletar(codigo);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("erro", "Erro ao excluir investimentos: " + e.getMessage());
            }
        }

        response.sendRedirect("investimento-lista");
    }
}
