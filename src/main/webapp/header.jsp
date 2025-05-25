<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/styles.css" rel="stylesheet">

<nav class="navbar navbar-expand-lg shadow-sm" style="background-color: var(--primary-color);">
  <div class="container">
    <a class="navbar-brand fw-bold" href="home.jsp" style="color: var(light-color);">
      Capital Quest
    </a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon" style="filter: invert(1);"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link link-light-hover" href="entrada">Entradas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link link-light-hover" href="saida">Saídas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link link-light-hover" href="investimento">Investimentos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link link-light-hover" href="trilhas">Trilhas</a>
        </li>
      </ul>

      <form action="logout" method="post" class="d-flex">
        <button type="submit" class="btn btn-outline-light btn-hover">Logout</button>
      </form>
    </div>
  </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

