// Cores definidas: Branca, #3A86FF, #2EC4B6

document.addEventListener('DOMContentLoaded', () => {
    // Função para alternar entre as abas de Login e Cadastro
    window.showForm = function(formType) {
        const loginForm = document.getElementById('login-form');
        const cadastroForm = document.getElementById('cadastro-form');
        const loginTab = document.querySelector('.tab-button:nth-child(1)');
        const cadastroTab = document.querySelector('.tab-button:nth-child(2)');

        if (formType === 'login') {
            loginForm.classList.add('active');
            cadastroForm.classList.remove('active');
            loginTab.classList.add('active');
            cadastroTab.classList.remove('active');
        } else if (formType === 'cadastro') {
            loginForm.classList.remove('active');
            cadastroForm.classList.add('active');
            loginTab.classList.remove('active');
            cadastroTab.classList.add('active');
        }
    };

    // Lógica de submissão do Login
    const loginForm = document.getElementById('loginForm');
    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const email = document.getElementById('loginEmail').value;
        const senha = document.getElementById('loginSenha').value;

        // Simulação de lógica de login
        console.log(`Tentativa de Login: E-mail: ${email}, Senha: ${senha}`);
        alert('Login simulado com sucesso! Redirecionando para a tela principal...');
        
        // Em um ambiente real, você faria uma requisição POST para o backend
        // e, em caso de sucesso, redirecionaria:
        window.location.href = '/tela_principal/'; 
    });

    // Lógica de submissão do Cadastro
    const cadastroForm = document.getElementById('cadastroForm');
    cadastroForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const nome = document.getElementById('cadastroNome').value;
        const email = document.getElementById('cadastroEmail').value;
        const senha = document.getElementById('cadastroSenha').value;
        const endereco = document.getElementById('cadastroEndereco').value;
        const espacoEmCasa = document.getElementById('cadastroEspaco').value;
        const tempoDisponivel = document.getElementById('cadastroTempo').value;

        // Simulação de lógica de cadastro
        const userData = { nome, email, senha, endereco, espacoEmCasa, tempoDisponivel };
        console.log('Dados de Cadastro:', userData);
        alert('Cadastro simulado com sucesso! Faça login para continuar.');

        // Após o cadastro, geralmente se volta para a tela de login
        showForm('login');
        
        // Em um ambiente real, você faria uma requisição POST para o backend
        // para persistir os dados do novo Adotante.
    });
});