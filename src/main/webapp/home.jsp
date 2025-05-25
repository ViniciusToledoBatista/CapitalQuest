<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="br.com.fiap.capitalquest.model.Cadastro" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
  Cadastro usuarioLogado = (Cadastro) session.getAttribute("usuarioLogado");
  if (usuarioLogado == null) {
    response.sendRedirect("index.jsp");
    return;
  }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>Capital Quest - Home</title>
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="resources/css/styles.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body class="bg-light">

<%@ include file="header.jsp" %>

<div class="container py-3">
  <h4>Bem-vindo, <strong><%= usuarioLogado.getNome() %> <%= usuarioLogado.getSobrenome() %></strong>!</h4>
</div>

<form id="formUsuario" method="post" action="algumServletOuUrl" style="display:none;">
  <input type="hidden" name="cdCadastro" value="<%= usuarioLogado.getCodigo() %>" />
</form>

<div class="container py-5">
  <h2 class="mb-4 text-center" style="color: var(--primary-color);">Resumo das Suas Finanças</h2>
  <div class="row g-4">

    <!-- Saldo Atual -->
    <div class="col-md-4">
      <div class="card shadow-sm border-0">
        <div class="card-body">
          <h5 class="card-title text-dark">
            <i class="bi bi-wallet2"></i> Saldo Atual
          </h5>
          <p class="fs-3 text-success">R$ <strong>2.200,00</strong></p>
          <small class="text-muted">Entradas - Saídas</small>
        </div>
      </div>
    </div>

    <!-- Gastos por Categoria -->
    <div class="col-md-4">
      <div class="card shadow-sm border-0">
        <div class="card-body">
          <h5 class="card-title text-dark">
            <i class="bi bi-pie-chart-fill text-danger"></i> Gastos por Categoria
          </h5>
          <canvas id="graficoGastos" width="100" height="100"></canvas>
        </div>
      </div>
    </div>

    <!-- Investimentos -->
    <div class="col-md-4">
      <div class="card shadow-sm border-0">
        <div class="card-body">
          <h5 class="card-title text-dark">
            <i class="bi bi-piggy-bank-fill text-primary"></i> Investimentos
          </h5>
          <p class="fs-4 text-primary">R$ <strong>15.000,00</strong></p>
          <canvas id="graficoInvestimentos" width="100" height="100"></canvas>
        </div>
      </div>
    </div>

  </div>
</div>

<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
  // Gráfico Gastos
  const ctxGastos = document.getElementById('graficoGastos');
  new Chart(ctxGastos, {
    type: 'pie',
    data: {
      labels: ['Alimentação', 'Transporte', 'Moradia', 'Lazer'],
      datasets: [{
        label: 'R$',
        data: [800, 400, 1000, 600],
        backgroundColor: ['#dc3545', '#ffc107', '#0d6efd', '#20c997'],
        borderWidth: 1
      }]
    }
  });

  // Gráfico Investimentos
  const ctxInvestimentos = document.getElementById('graficoInvestimentos');
  new Chart(ctxInvestimentos, {
    type: 'pie',
    data: {
      labels: ['Ações', 'Tesouro Direto', 'Fundos Imobiliários'],
      datasets: [{
        label: 'R$',
        data: [5000, 7000, 3000],
        backgroundColor: ['#0d6efd', '#198754', '#6610f2'],
        borderWidth: 1
      }]
    }
  });

  <!-- 🧠 Watson Assistant Chatbot -->
  window.watsonAssistantChatOptions = {
    integrationID: "d4c4e537-7ca1-4f92-b1e3-fbf24c6f48b4", // The ID of this integration.
    region: "us-south", // The region your integration is hosted in.
    serviceInstanceID: "195932a6-55f2-44d3-a0cc-1c05f839f176", // The ID of your service instance.
    onLoad: async (instance) => { await instance.render(); }
  };
  setTimeout(function(){
    const t=document.createElement('script');
    t.src="https://web-chat.global.assistant.watson.appdomain.cloud/versions/" + (window.watsonAssistantChatOptions.clientVersion || 'latest') + "/WatsonAssistantChatEntry.js";
    document.head.appendChild(t);
  });
</script>

</body>
</html>
