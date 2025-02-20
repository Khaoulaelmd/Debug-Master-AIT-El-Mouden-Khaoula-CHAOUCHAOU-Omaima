// scriptLogin.js
function validateLogin() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('error-message');

    // Vérification simple (à remplacer par une vraie authentification en production)
    if (username === 'admin' && password === 'password123') {
        // Stockage session côté client (temporaire)
        localStorage.setItem('isLoggedIn', 'true');
        window.location.href = 'interfaceDashboard.html';
    } else {
        errorMessage.style.display = 'block';
        setTimeout(() => errorMessage.style.display = 'none', 3000);
    }
}

// Particules communes à toutes les pages
function createParticles() {
    const container = document.getElementById('particles');
    for(let i = 0; i < 20; i++) {
        const particle = document.createElement('div');
        particle.className = 'particle';
        particle.style.left = Math.random() * 100 + '%';
        particle.style.width = particle.style.height =
            Math.random() * 100 + 50 + 'px';
        particle.style.animationDelay = Math.random() * 5 + 's';
        container.appendChild(particle);
    }
}
createParticles();