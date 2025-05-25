package br.com.fiap.capitalquest.controller;

import br.com.fiap.capitalquest.dao.EntradaDao;
import br.com.fiap.capitalquest.dao.TipoEntradaDao;
import br.com.fiap.capitalquest.dao.impl.OracleEntradaDao;
import br.com.fiap.capitalquest.dao.impl.OracleTipoEntradaDao;
import br.com.fiap.capitalquest.model.Cadastro;
import br.com.fiap.capitalquest.model.Entrada;
import br.com.fiap.capitalquest.model.TipoEntrada;

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

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {

    private EntradaDao entradaDao = new OracleEntradaDao();
    private TipoEntradaDao tipoEntradaDao = new OracleTipoEntradaDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Buscar tipos para dropdown
            List<TipoEntrada> tiposEntrada = tipoEntradaDao.listar();
            req.setAttribute("tiposEntrada", tiposEntrada);

            // Obter usuário logado da sessão
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("usuarioLogado") == null) {
                req.setAttribute("erro", "Usuário não autenticado.");
                req.getRequestDispatcher("entrada.jsp").forward(req, resp);
                return;
            }
            Cadastro cadastro = (Cadastro) session.getAttribute("usuarioLogado");
            int codigoCadastro = cadastro.getCodigo();

            // Encaminhar para JSP
            req.getRequestDispatcher("entrada.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao carregar entradas.");
            req.getRequestDispatcher("entrada.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obter usuário logado da sessão
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("usuarioLogado") == null) {
                req.setAttribute("erro", "Usuário não autenticado.");
                req.getRequestDispatcher("entrada.jsp").forward(req, resp);
                return;
            }
            Cadastro cadastro = (Cadastro) session.getAttribute("usuarioLogado");
            int codigoCadastro = cadastro.getCodigo();

            // Obter parâmetros do formulário
            String descricao = req.getParameter("descricao");
            String valorStr = req.getParameter("valor");
            String dataStr = req.getParameter("data");
            String codigoTipoEntradaStr = req.getParameter("codigoTipoEntrada");

            // Validar campos obrigatórios
            if (descricao == null || descricao.isBlank() ||
                    valorStr == null || valorStr.isBlank() ||
                    dataStr == null || dataStr.isBlank() ||
                    codigoTipoEntradaStr == null || codigoTipoEntradaStr.isBlank()) {

                req.setAttribute("erro", "Por favor, preencha todos os campos obrigatórios.");
                doGet(req, resp);
                return;
            }

            double valor = Double.parseDouble(valorStr);
            LocalDate dataLD = LocalDate.parse(dataStr);
            int codigoTipoEntrada = Integer.parseInt(codigoTipoEntradaStr);

            Entrada entrada = new Entrada();
            entrada.setDescricao(descricao);
            entrada.setValor(valor);
            entrada.setData(Date.valueOf(dataLD));
            entrada.setCodigoTipoEntrada(codigoTipoEntrada);
            entrada.setCodigoCadastro(codigoCadastro);

            // Inserir no banco
            entradaDao.inserir(entrada);

            // Mensagem de sucesso
            req.setAttribute("sucesso", "Entrada cadastrada com sucesso!");

            // Recarregar página via GET para atualizar lista e tipos
            doGet(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar entrada: " + e.getMessage());
            doGet(req, resp);
        }
    }
}
