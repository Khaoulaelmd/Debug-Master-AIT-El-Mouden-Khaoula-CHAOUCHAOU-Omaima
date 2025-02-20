document.getElementById('courrierForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const employeeId = document.getElementById('employeeId').value.trim();
    const description = document.getElementById('errorDetails').value;
    const loader = document.getElementById('loader');
    const messageBox = document.getElementById('message');

    messageBox.style.display = 'none';
    loader.style.display = 'block';

    try {
        console.log("ID employé saisi :", employeeId);  // Vérifier l'ID saisi

        const employeeResponse = await fetch(`http://localhost:9095/api/employees/${employeeId}`);

        if (!employeeResponse.ok) {
            const errorText = await employeeResponse.text();
            console.log("Réponse API Employé :", errorText);
            throw new Error("Employé non trouvé !");
        }

        const employee = await employeeResponse.json();
        console.log("Employé récupéré :", employee);

        const courrier = {
            idEmployee: employee.id,
            idAdmine: 1,
            description: description,
            statut: "EN_ATTENTE",
            dateEnvoi: new Date().toISOString()
        };

        const response = await fetch("http://localhost:9094/api/couriers", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(courrier)
        });

        if (!response.ok) {
            const errorText = await response.text();
            console.log("Réponse API Courrier :", errorText);
            throw new Error("Erreur lors de l'envoi du courrier !");
        }

        messageBox.textContent = "Courrier envoyé avec succès !";
        messageBox.className = "message success";
        this.reset();
    } catch (error) {
        console.error("Erreur :", error);
        messageBox.textContent = error.message;
        messageBox.className = "message error";
    } finally {
        messageBox.style.display = 'block';
        loader.style.display = 'none';
    }
});
