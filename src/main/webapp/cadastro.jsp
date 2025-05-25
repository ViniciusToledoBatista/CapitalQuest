<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <title>Capital Quest - Cadastro</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="bg-light">

<%@ include file="headerLogin.jsp" %>

<div class="container d-flex justify-content-center align-items-center vh-100">
  <div class="card shadow-sm p-4" style="max-width: 500px; width: 100%;">
    <h3 class="text-center mb-4">Crie sua conta</h3>
    <form action="cadastro" method="post">
      <div class="mb-3">
        <label for="nome" class="form-label">Nome</label>
        <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite seu nome" required>
      </div>
      <div class="mb-3">
        <label for="sobrenome" class="form-label">Sobrenome</label>
        <input type="text" class="form-control" id="sobrenome" name="sobrenome" placeholder="Digite seu sobrenome" required>
      </div>
      <div class="mb-3">
        <label for="telefone" class="form-label">Telefone</label>
        <input type="tel" class="form-control" id="telefone" name="telefone" placeholder="(xx) xxxxx-xxxx" required>
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Digite seu email" required>
      </div>
      <div class="mb-3">
        <label for="senha" class="form-label">Senha</label>
        <input type="password" class="form-control" id="senha" name="senha" placeholder="Crie uma senha" required>
      </div>
      <div class="d-grid mb-3">
        <button type="submit" class="btn btn-success">Cadastrar</button>
      </div>
    </form>

    <c:if test="${not empty sucesso}">
      <div class="alert alert-success ms-2 me-2 m-auto">
          ${sucesso}
      </div>
    </c:if>

    <c:if test="${not empty erro}">
      <div class="alert alert-danger ms-2 me-2 m-auto">
          ${erro}
      </div>
    </c:if>
    <br>
    <div class="text-center">
      <small>Já possui conta? <a href="login.jsp">Faça login</a></small>
    </div>
  </div>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>
