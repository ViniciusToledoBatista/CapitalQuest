<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <title>Capital Quest - Minhas Entradas</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css" />
</head>
<body style="background-color: var(--gray-light);">

<%@ include file="header.jsp" %>

<div class="container" style="display: flex; justify-content: center; align-items: center; min-height: 100vh;">
  <div class="card" style="max-width: 900px; width: 100%; padding: 2rem;">
    <h3 class="text-center mb-3">Minhas Entradas</h3>

    <!-- Mensagem de erro -->
    <c:if test="${not empty erro}">
      <div style="background-color: var(--danger-color); color: #fff; padding: 1rem; border-radius: 8px; margin-bottom: 1rem;">
          ${erro}
      </div>
    </c:if>

    <!-- Verifica se há entradas -->
    <c:if test="${empty listaEntradas}">
      <div style="background-color: var(--primary-light); color: var(--primary-color); padding: 1rem; border-radius: 8px; text-align: center; margin-bottom: 1rem;">
        Nenhuma entrada encontrada.
      </div>
    </c:if>

    <!-- Lista de entradas com formulário para exclusão -->
    <c:if test="${not empty listaEntradas}">
      <form action="entrada-lista" method="post">

        <div class="table-responsive" style="overflow-x:auto;">
          <table>
            <thead>
            <tr>
              <th>
                <input type="checkbox" id="selectAll" title="Selecionar todos" />
              </th>
              <th>Data</th>
              <th>Descrição</th>
              <th>Valor (R$)</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="entrada" items="${listaEntradas}">
              <tr>
                <td>
                  <input type="checkbox" name="entradaSelecionada" value="${entrada.codigo}" />
                </td>
                <td><fmt:formatDate value="${entrada.data}" pattern="dd/MM/yyyy" /></td>
                <td><c:out value="${entrada.descricao}" /></td>
                <td>
                  R$ <fmt:formatNumber value="${entrada.valor}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>

        <!-- Botões de navegação -->
        <div class="mt-3" style="display: flex; justify-content: space-between; align-items: center;">
          <a href="home.jsp" class="btn btn-outline-primary">Home</a>
          <div>
            <a href="entrada.jsp" class="btn btn-success me-2">Adicionar Nova Entrada</a>
            <button type="submit" class="btn btn-danger" onclick="return confirm('Deseja realmente excluir as entradas selecionadas?')">
              Deletar Entradas Selecionadas
            </button>
          </div>
        </div>

      </form>
    </c:if>

  </div>
</div>

<%@ include file="footer.jsp" %>

<!-- Script para selecionar todos -->
<script>
  document.getElementById('selectAll')?.addEventListener('click', function() {
    const checkboxes = document.querySelectorAll('input[name="entradaSelecionada"]');
    checkboxes.forEach(cb => cb.checked = this.checked);
  });
</script>

</body>
</html>
