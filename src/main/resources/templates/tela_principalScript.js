// Cores definidas: Branca, #3A86FF, #2EC4B6

document.addEventListener('DOMContentLoaded', () => {
    // Simulação de carregamento do nome do usuário
    const userNameElement = document.getElementById('user-name');
    // Em um ambiente real, este nome viria do backend após o login
    const userName = localStorage.getItem('userName') || 'Visitante'; 
    userNameElement.textContent = userName;

    // Lógica de Logout
    const logoutLink = document.getElementById('logout-link');
    logoutLink.addEventListener('click', (event) => {
        event.preventDefault();
        
        // Simulação de limpeza de sessão
        localStorage.removeItem('userName');
        alert('Sessão encerrada. Você será redirecionado para a tela de login.');
        
        // Redirecionamento para a tela de login
        window.location.href = '/index/'; 
    });

    // Lógica de Perfil (apenas um placeholder)
    const perfilLink = document.getElementById('perfil-link');
    perfilLink.addEventListener('click', (event) => {
        event.preventDefault();
        alert('Funcionalidade de Perfil em desenvolvimento. Aqui você poderá editar seus dados.');
    });

    // Adicionar interatividade aos cards (já feito no HTML, mas aqui podemos adicionar mais lógica)
    const featureCards = document.querySelectorAll('.feature-card');
    featureCards.forEach(card => {
        card.addEventListener('mouseenter', () => {
            card.style.backgroundColor = '#f0f8ff'; // Cor suave ao passar o mouse
        });
        card.addEventListener('mouseleave', () => {
            card.style.backgroundColor = '#FFFFFF'; // Volta para branco
        });
    });
});
