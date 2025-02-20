function sendMessage() {
    const inputField = document.getElementById('userInput');
    const message = inputField.value.trim();
    if (message === '') return;

    const chatBox = document.getElementById('chatBox');

    // Message utilisateur
    const userDiv = document.createElement('div');
    userDiv.classList.add('chat-message', 'user-message');
    userDiv.textContent = message;
    chatBox.appendChild(userDiv);

    inputField.value = '';
    chatBox.scrollTop = chatBox.scrollHeight;

    // Réponse bot en attente
    const botDiv = document.createElement('div');
    botDiv.classList.add('chat-message', 'bot-message');
    botDiv.innerHTML = `🔍 Analyse en cours...`;
    chatBox.appendChild(botDiv);
    chatBox.scrollTop = chatBox.scrollHeight;

    // ⚡ Envoyer la requête au backend
    fetch(`http://localhost:5555/ai/${encodeURIComponent(message)}`)
        .then(response => response.text()) // Récupérer la réponse en texte brut
        .then(data => {
            botDiv.innerHTML = data; // Mettre à jour la réponse du bot
            chatBox.scrollTop = chatBox.scrollHeight;
        })
        .catch(error => {
            botDiv.innerHTML = `❌ Erreur : Impossible de contacter le serveur.`;
            console.error("Erreur de connexion :", error);
        });
}
