// Création de particules animées
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