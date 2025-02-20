// Particules animées
function createParticles() {
    const particles = document.getElementById('particles');
    for (let i = 0; i < 50; i++) {
        const particle = document.createElement('div');
        particle.className = 'particle';
        particle.style.left = `${Math.random() * 100}%`;
        particle.style.animationDelay = `${Math.random() * 8}s`;
        particles.appendChild(particle);
    }
}

// Déconnexion
function logout() {
    window.location.href = 'loginAdmin.html';
}

// Calcul des statistiques
function calculateStats(couriers) {
    return {
        total: couriers.length,
        enAttente: couriers.filter(c => c.statut === 'EN_ATTENTE').length,
        traitee: couriers.filter(c => c.statut === 'TRAITEE').length
    };
}

// Mise à jour des statistiques
function updateStats(stats) {
    document.getElementById('totalCourriers').textContent = stats.total;
    document.getElementById('courriersEnAttente').textContent = stats.enAttente;
    document.getElementById('courriersTraitee').textContent = stats.traitee;
}

// Affichage des courriers
function displayData(couriers) {
    const tableBody = document.getElementById('couriersTableBody');
    tableBody.innerHTML = '';

    if (couriers.length === 0) {
        tableBody.innerHTML = '<tr><td colspan="4">Aucun courrier trouvé.</td></tr>';
        return;
    }

    couriers
        .filter(c => c.statut === 'EN_ATTENTE' || c.statut === 'TRAITEE')
        .forEach(courier => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${courier.id}</td>
                <td>${courier.description}</td>
                <td>${new Date(courier.dateEnvoi).toLocaleDateString()}</td>
                <td><span class="status">${courier.statut}</span></td>
            `;
            tableBody.appendChild(row);
        });
}

// Chargement des données
async function loadData() {
    try {
        const response = await fetch('http://localhost:9094/api/couriers');
        console.log("Réponse brute:", await response.text()); // Vérification

        if (!response.ok) throw new Error('Erreur serveur');

        const couriers = await response.json();
        updateStats(calculateStats(couriers));
        displayData(couriers);
    } catch (error) {
        console.error('Erreur:', error);
        alert('Impossible de charger les données');
    }
}

// Initialisation
document.addEventListener('DOMContentLoaded', () => {
    createParticles();
    loadData();
    setInterval(loadData, 10000); // Rafraîchir les données toutes les 10s
});
