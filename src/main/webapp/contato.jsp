<%@ include file="headerLogin.jsp" %>

<section class="container" style="padding: 3rem 0; max-width: 600px;">

    <h1 class="mb-3">Fale Conosco</h1>

    <div class="card mb-4">
        <h2>Contato direto</h2>
        <p><strong>Telefone:</strong> +55 (11) 94165-8833</p>
        <p><strong>E-mail:</strong> contato@capitalquest.com.br</p>
    </div>

    <div class="card">
        <h2>Envie sua mensagem</h2>

        <form id="contatoForm" method="post" action="enviarMensagemContato" novalidate>

            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" placeholder="Seu nome completo" required autocomplete="name" />

            <label for="telefone">Telefone</label>
            <input type="tel" id="telefone" name="telefone" placeholder="(XX) XXXXX-XXXX" required autocomplete="tel" pattern="^\(?\d{2}\)?\s?\d{4,5}-?\d{4}$" />

            <label for="email">E-mail</label>
            <input type="email" id="email" name="email" placeholder="seu@email.com" required autocomplete="email" />

            <label for="assunto">Assunto</label>
            <input type="text" id="assunto" name="assunto" placeholder="Motivo do contato" required />

            <label for="mensagem">Mensagem</label>
            <textarea id="mensagem" name="mensagem" rows="6" placeholder="Escreva sua mensagem aqui..." required></textarea>

            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>

        <div id="mensagemSucesso" class="text-center mt-3" style="display:none; color: var(--success-color); font-weight: 600;">
            Mensagem enviada com sucesso.<br/>
            Entraremos em contato o mais breve possível.<br/>
            Conte sempre com a Capital Quest.
        </div>
    </div>

</section>

<script>
    const form = document.getElementById('contatoForm');
    const mensagemSucesso = document.getElementById('mensagemSucesso');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        if (!form.checkValidity()) {
            form.reportValidity();
            return;
        }

        // Simulando envio (substituir por envio real no backend)
        setTimeout(() => {
            form.reset();
            mensagemSucesso.style.display = 'block';
            form.style.display = 'none';
        }, 300);
    });
</script>

<%@ include file="footer.jsp" %>
