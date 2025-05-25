package br.com.fiap.capitalquest.controller;

import br.com.fiap.capitalquest.dao.InvestimentoDao;
import br.com.fiap.capitalquest.dao.TipoInvestimentoDao;
import br.com.fiap.capitalquest.dao.impl.OracleInvestimentoDao;
import br.com.fiap.capitalquest.dao.impl.OracleTipoInvestimentoDao;
import br.com.fiap.capitalquest.model.Cadastro;
import br.com.fiap.capitalquest.model.Investimento;
import br.com.fiap.capitalquest.model.TipoInvestimento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {

    private InvestimentoDao investimentoDao = new OracleInvestimentoDao();
    private TipoInvestimentoDao tipoInvestimentoDao = new OracleTipoInvestimentoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Buscar tipos de investimento para dropdown
            List<TipoInvestimento> tiposInvestimento = tipoInvestimentoDao.listar();
            req.setAttribute("tiposInvestimento", tiposInvestimento);

            // Obter usuário logado da sessão
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("usuarioLogado") == null) {
                req.setAttribute("erro", "Usuário não autenticado.");
                req.getRequestDispatcher("investimento.jsp").forward(req, resp);
                return;
            }
            Cadastro cadastro = (Cadastro) session.getAttribute("usuarioLogado");
            int codigoCadastro = cadastro.getCodigo();

            // Encaminhar para JSP
            req.getRequestDispatcher("investimento.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao carregar investimentos.");
            req.getRequestDispatcher("investimento.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obter usuário logado da sessão
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("usuarioLogado") == null) {
                req.setAttribute("erro", "Usuário não autenticado.");
                req.getRequestDispatcher("investimento.jsp").forward(req, resp);
                return;
            }
            Cadastro cadastro = (Cadastro) session.getAttribute("usuarioLogado");
            int codigoCadastro = cadastro.getCodigo();

            // Obter parâmetros do formulário
            String descricao = req.getParameter("descricao");
            String valorStr = req.getParameter("valor");
            String dataStr = req.getParameter("data");
            String codigoTipoInvestimentoStr = req.getParameter("codigoTipoInvestimento");

            // Validar campos obrigatórios
            if (descricao == null || descricao.isBlank() ||
                    valorStr == null || valorStr.isBlank() ||
                    dataStr == null || dataStr.isBlank() ||
                    codigoTipoInvestimentoStr == null || codigoTipoInvestimentoStr.isBlank()) {

                req.setAttribute("erro", "Por favor, preencha todos os campos obrigatórios.");
                doGet(req, resp);
                return;
            }

            double valor = Double.parseDouble(valorStr);
            LocalDate dataLD = LocalDate.parse(dataStr);
            int codigoTipoInvestimento = Integer.parseInt(codigoTipoInvestimentoStr);

            // Criar objeto Investimento
            Investimento investimento = new Investimento();
            investimento.setDescricao(descricao);
            investimento.setValor(valor);
            investimento.setData(Date.valueOf(dataLD));
            investimento.setCodigoTipoInvestimento(codigoTipoInvestimento);
            investimento.setCodigoCadastro(codigoCadastro);

            // Inserir no banco
            investimentoDao.inserir(investimento);

            // Mensagem de sucesso
            req.setAttribute("sucesso", "Investimento cadastrado com sucesso!");

            // Recarregar página via GET
            doGet(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar investimento: " + e.getMessage());
            doGet(req, resp);
        }
    }
}
