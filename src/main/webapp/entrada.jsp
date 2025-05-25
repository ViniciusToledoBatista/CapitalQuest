<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Capital Quest - Nova Entrada</title>

  <!-- CSS Customizado -->
  <link rel="stylesheet" href="styles.css" />
  <style>
    /* Pequena adaptação para largura e centralização do card */
    .card-form {
      max-width: 500px;
      margin: 0 auto;
    }
  </style>
</head>

<body>

<%@ include file="header.jsp" %>

<main class="container my-3">
  <div class="card card-form" tabindex="0">
    <div class="card-body">
      <h3 class="text-center mb-3">Registrar Nova Entrada</h3>

      <!-- Mensagem de sucesso -->
      <c:if test="${not empty sucesso}">
        <div style="color: var(--success-color); text-align: center; margin-bottom: 1rem;">
            ${sucesso}
        </div>
      </c:if>

      <!-- Mensagem de erro -->
      <c:if test="${not empty erro}">
        <div style="color: var(--danger-color); text-align: center; margin-bottom: 1rem;">
            ${erro}
        </div>
      </c:if>

      <form action="entrada" method="post" class="needs-validation" novalidate>

        <label for="descricao" class="form-label">Descrição:</label>
        <input type="text" id="descricao" name="descricao" required />
        <div class="invalid-feedback">Por favor, insira a descrição.</div>

        <label for="valor" class="form-label">Valor (R$):</label>
        <input type="number" id="valor" name="valor" step="0.01" min="0" required />
        <div class="invalid-feedback">Por favor, insira um valor válido.</div>

        <label for="data" class="form-label">Data:</label>
        <input type="date" id="data" name="data" required />
        <div class="invalid-feedback">Por favor, selecione uma data.</div>

        <label for="codigoTipoEntrada" class="form-label">Tipo de Entrada:</label>
        <select id="codigoTipoEntrada" name="codigoTipoEntrada" required>
          <option value="" disabled selected>Selecione o tipo</option>
          <c:forEach var="tipo" items="${tiposEntrada}">
            <option value="${tipo.codigo}">${tipo.nome}</option>
          </c:forEach>
        </select>
        <div class="invalid-feedback">Por favor, selecione o tipo de entrada.</div>

        <div class="d-grid gap-2" style="display: flex; flex-direction: column; gap: 0.75rem; margin-top: 1rem;">
          <button type="submit" class="btn btn-primary">Registrar Entrada</button>
          <a href="entrada-lista" class="btn btn-outline-primary" style="text-align: center;">Listar Entradas</a>
        </div>
      </form>
    </div>
  </div>
</main>

<%@ include file="footer.jsp" %>

<script>
  (() => {
    'use strict'
    const forms = document.querySelectorAll('.needs-validation')
    Array.from(forms).forEach(form => {
      form.addEventListener('submit', event => {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }
        form.classList.add('was-validated')
      }, false)
    })
  })()
</script>

</body>
</html>
