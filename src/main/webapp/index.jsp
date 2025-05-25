<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="resources/css/styles.css" rel="stylesheet">

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <title>Capital Quest - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<body>

<%@ include file="headerLogin.jsp" %>

<!-- Hero Section -->
<section class="hero-section text-center">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6 text-md-start px-4">
                <h1 class="display-4 fw-bold">Sua Jornada Financeira Começa Aqui</h1>
                <p class="lead">
                    Aprenda, organize e invista — tudo em um só lugar.
                </p>
                <a href="cadastro.jsp" class="btn btn-success btn-lg">Comece Agora</a>
            </div>
            <div class="col-md-6 px-4">
                <img src="resources/img/exemplo.dash.jpg" alt="Dashboard ilustrativo" class="img-fluid" />
            </div>
        </div>
    </div>
</section>

<!-- Sobre -->
<section class="container py-5">
    <div class="row align-items-center">
        <div class="col-md-6 px-4">
            <img src="resources/img/educ.fin.home.png" alt="Educação Financeira" class="img-fluid" />
        </div>
        <div class="col-md-6 px-4">
            <h2 class="fw-bold">O que é a Capital Quest?</h2>
            <p>
                A <strong>Capital Quest</strong> é uma plataforma que une <strong>educação financeira</strong>,
                <strong>controle financeiro</strong> e <strong>investimentos</strong> em um só lugar.
                Uma solução gamificada, prática e eficiente para quem deseja transformar sua relação com o dinheiro.
            </p>
        </div>
    </div>
</section>

<!-- Diferenciais -->
<section class="bg-light py-5">
    <div class="container">
        <h2 class="text-center fw-bold mb-4">Nossos Diferenciais</h2>
        <div class="row g-4">
            <div class="col-md-3">
                <div class="card text-center p-3">
                    <i class="bi bi-controller" style="font-size: 2.5rem;"></i>
                    <div class="card-body">
                        <h5 class="card-title">Aprendizado Gamificado</h5>
                        <p class="card-text">
                            Aprenda finanças de forma divertida, prática e interativa.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center p-3">
                    <i class="bi bi-wallet2" style="font-size: 2.5rem;"></i>
                    <div class="card-body">
                        <h5 class="card-title">Controle Financeiro</h5>
                        <p class="card-text">
                            Gerencie seus gastos, receitas e investimentos em um só lugar.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center p-3">
                    <i class="bi bi-graph-up-arrow" style="font-size: 2.5rem;"></i>
                    <div class="card-body">
                        <h5 class="card-title">Investimentos</h5>
                        <p class="card-text">
                            Aprenda e invista na própria plataforma com segurança e praticidade.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center p-3">
                    <i class="bi bi-infinity" style="font-size: 2.5rem;"></i>
                    <div class="card-body">
                        <h5 class="card-title">Experiência Integrada</h5>
                        <p class="card-text">
                            Educação, controle e investimentos juntos em uma experiência única.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Propósito com Tabs -->
<section class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-8 px-4">
            <h2 class="fw-bold text-center mb-4">Nossa Essência</h2>

            <!-- Nav tabs customizadas -->
            <ul class="nav nav-tabs justify-content-center mb-4 custom-tabs" id="essenciaTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="missao-tab" data-bs-toggle="tab" data-bs-target="#missao" type="button" role="tab" aria-controls="missao" aria-selected="true">
                        Missão
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="visao-tab" data-bs-toggle="tab" data-bs-target="#visao" type="button" role="tab" aria-controls="visao" aria-selected="false">
                        Visão
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="valores-tab" data-bs-toggle="tab" data-bs-target="#valores" type="button" role="tab" aria-controls="valores" aria-selected="false">
                        Valores
                    </button>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content custom-tab-content" id="essenciaTabContent">
                <div class="tab-pane fade show active" id="missao" role="tabpanel" aria-labelledby="missao-tab">
                    <p>
                        Empoderar pessoas por meio da educação financeira, oferecendo ferramentas intuitivas, seguras e acessíveis para que alcancem autonomia, equilíbrio e prosperidade em sua vida financeira.
                    </p>
                </div>
                <div class="tab-pane fade" id="visao" role="tabpanel" aria-labelledby="visao-tab">
                    <p>
                        Ser reconhecida como a plataforma que mais impacta positivamente a vida financeira das pessoas, promovendo autonomia, inclusão e transformação econômica de forma ética, inovadora e sustentável.
                    </p>
                </div>
                <div class="tab-pane fade" id="valores" role="tabpanel" aria-labelledby="valores-tab">
                    <p>
                        • Educação que transforma: Acreditamos que conhecimento gera liberdade.<br />
                        • Inovação constante: Evoluímos sempre, buscando tecnologia que simplifica.<br />
                        • Transparência: Construímos relações baseadas na ética e na clareza.<br />
                        • Comprometimento: Estamos juntos com nossos usuários em cada etapa da jornada financeira.<br />
                        • Acessibilidade: Democratizamos a educação e os recursos financeiros para todos.<br />
                        • Sustentabilidade financeira: Promovemos hábitos que geram prosperidade responsável e duradoura.
                    </p>
                </div>
            </div>
        </div>
    </div>
</section>


<!-- Call to Action -->
<section class="bg-primary text-light text-center py-5">
    <div class="container">
        <h2 class="fw-bold mb-4 text-white">Pronto para transformar sua vida financeira?</h2>
        <a href="cadastro.jsp" class="btn btn-light btn-lg me-3 btn-custom">Comece Agora</a>
        <a href="contato.jsp" class="btn btn-light btn-lg me-3 btn-custom">Fale Conosco</a>
    </div>
</section>

<%@ include file="footer.jsp" %>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
