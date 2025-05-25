package br.com.fiap.capitalquest.controller;

import br.com.fiap.capitalquest.dao.SaidaDao;
import br.com.fiap.capitalquest.dao.TipoSaidaDao;
import br.com.fiap.capitalquest.dao.impl.OracleSaidaDao;
import br.com.fiap.capitalquest.dao.impl.OracleTipoSaidaDao;
import br.com.fiap.capitalquest.model.Cadastro;
import br.com.fiap.capitalquest.model.Saida;
import br.com.fiap.capitalquest.model.TipoSaida;

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

@WebServlet("/saida")
public class SaidaServlet extends HttpServlet {

    private SaidaDao saidaDao = new OracleSaidaDao();
    private TipoSaidaDao tipoSaidaDao = new OracleTipoSaidaDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Buscar tipos para dropdown
            List<TipoSaida> tiposSaida = tipoSaidaDao.listar();
            req.setAttribute("tiposSaida", tiposSaida);

            // Obter usuário logado da sessão
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("usuarioLogado") == null) {
                req.setAttribute("erro", "Usuário não autenticado.");
                req.getRequestDispatcher("saida.jsp").forward(req, resp);
                return;
            }
            Cadastro cadastro = (Cadastro) session.getAttribute("usuarioLogado");
            int codigoCadastro = cadastro.getCodigo();

            // Encaminhar para JSP
            req.getRequestDispatcher("saida.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao carregar saídas.");
            req.getRequestDispatcher("saida.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obter usuário logado da sessão
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("usuarioLogado") == null) {
                req.setAttribute("erro", "Usuário não autenticado.");
                req.getRequestDispatcher("saida.jsp").forward(req, resp);
                return;
            }
            Cadastro cadastro = (Cadastro) session.getAttribute("usuarioLogado");
            int codigoCadastro = cadastro.getCodigo();

            // Obter parâmetros do formulário
            String descricao = req.getParameter("descricao");
            String valorStr = req.getParameter("valor");
            String dataStr = req.getParameter("data");
            String codigoTipoSaidaStr = req.getParameter("codigoTipoSaida");

            // Validar campos obrigatórios
            if (descricao == null || descricao.isBlank() ||
                    valorStr == null || valorStr.isBlank() ||
                    dataStr == null || dataStr.isBlank() ||
                    codigoTipoSaidaStr == null || codigoTipoSaidaStr.isBlank()) {

                req.setAttribute("erro", "Por favor, preencha todos os campos obrigatórios.");
                doGet(req, resp);
                return;
            }

            double valor = Double.parseDouble(valorStr);
            LocalDate dataLD = LocalDate.parse(dataStr);
            int codigoTipoSaida = Integer.parseInt(codigoTipoSaidaStr);

            Saida saida = new Saida();
            saida.setDescricao(descricao);
            saida.setValor(valor);
            saida.setData(Date.valueOf(dataLD));
            saida.setCodigoTipoSaida(codigoTipoSaida);
            saida.setCodigoCadastro(codigoCadastro);

            // Inserir no banco
            saidaDao.inserir(saida);

            // Mensagem de sucesso
            req.setAttribute("sucesso", "Saída cadastrada com sucesso!");

            // Recarregar página via GET para atualizar lista e tipos
            doGet(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar saída: " + e.getMessage());
            doGet(req, resp);
        }
    }
}
