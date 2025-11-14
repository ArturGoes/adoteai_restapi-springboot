// Cores definidas: Branca, #3A86FF, #2EC4B6

document.addEventListener('DOMContentLoaded', () => {
    const matchForm = document.getElementById('matchForm');
    const matchResultsSection = document.getElementById('matchResults');
    const resultContent = document.getElementById('resultContent');
    const logoutLink = document.getElementById('logout-link');

    // Lógica de Logout (copiada da tela principal para consistência)
    logoutLink.addEventListener('click', (event) => {
        event.preventDefault();
        localStorage.removeItem('userName');
        alert('Sessão encerrada. Você será redirecionado para a tela de login.');
        window.location.href = '/index/'; 
    });

    matchForm.addEventListener('submit', function(event) {
        event.preventDefault();
        
        const preferencias = document.getElementById('preferencias').value;
        const temCriancas = document.getElementById('temCriancas').checked;
        const temOutrosPets = document.getElementById('temOutrosPets').checked;
        const alergias = document.getElementById('alergias').checked;

        const formData = {
            preferencias,
            temCriancas,
            temOutrosPets,
            alergias
        };

        console.log('Dados do Formulário para Match:', formData);
        
        // 1. Mostrar que a busca está em andamento
        matchResultsSection.style.display = 'block';
        resultContent.innerHTML = `<p style="color: #3A86FF; font-weight: bold;">Buscando seu par perfeito com a IA...</p>`;

        // 2. Simulação de chamada à API de Match (que seria o Controller Java)
        // Em um ambiente real, você faria uma requisição AJAX (fetch ou axios) para o backend
        // Ex: fetch('/api/match', { method: 'POST', body: JSON.stringify(formData) })
        
        setTimeout(() => {
            // 3. Simulação de resultados da IA
            const mockResults = [
                { nome: "Rex", raca: "Labrador", idade: 3, temperamento: "Sociável", matchScore: "95%" },
                { nome: "Mimi", raca: "Siamês", idade: 1, temperamento: "Calmo", matchScore: "88%" },
                { nome: "Bolt", raca: "Vira-lata", idade: 5, temperamento: "Ativo", matchScore: "75%" }
            ];

            let htmlContent = '<h4>Animais Recomendados para Você:</h4>';
            
            if (alergias) {
                htmlContent += `<p style="color: #2EC4B6; font-weight: bold;">Atenção: Sua alergia foi considerada. Os resultados abaixo são de animais com menor probabilidade de causar reações, mas a consulta veterinária é essencial.</p>`;
            }

            mockResults.forEach(animal => {
                htmlContent += `
                    <div class="animal-card">
                        <h4>${animal.nome} (${animal.raca})</h4>
                        <p><strong>Idade:</strong> ${animal.idade} anos</p>
                        <p><strong>Temperamento:</strong> ${animal.temperamento}</p>
                        <p style="color: #3A86FF; font-weight: bold;">Score de Match: ${animal.matchScore}</p>
                        <button style="background-color: #2EC4B6; color: white; border: none; padding: 8px 15px; border-radius: 5px; cursor: pointer; margin-top: 10px;">Ver Perfil Completo</button>
                    </div>
                `;
            });

            resultContent.innerHTML = htmlContent;

        }, 2000); // Simula um atraso de 2 segundos para a IA processar
    });
});