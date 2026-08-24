const API_URL = 'http://localhost:8080/api/peleadores';

const fighter1Select = document.getElementById('fighter1');
const fighter2Select = document.getElementById('fighter2');
const fighter1Image = document.getElementById('fighter1Image');
const fighter2Image = document.getElementById('fighter2Image');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');

let autos = [];

async function fetchData() {
    try {
        const response = await fetch(API_URL);
        autos = await response.json();
    } catch (error) {
        console.error('Error al cargar los autos:', error);
    }
    loadFighters();
}

function loadFighters() {
    [...autos].forEach(fighter => {
        const option1 = document.createElement('option');
        option1.value = JSON.stringify(fighter);
        option1.text = `${fighter.nombre} (${fighter.marca || fighter.modelo || ''})`;
        fighter1Select.appendChild(option1);

        const option2 = document.createElement('option');
        option2.value = JSON.stringify(fighter);
        option2.text = `${fighter.nombre} (${fighter.marca || fighter.modelo || ''})`;
        fighter2Select.appendChild(option2);
    });

    if (autos.length > 0) {
        const selected1 = JSON.parse(fighter1Select.value);
        fighter1Image.src = selected1.imagen || 'placeholder1.png';

        const selected2 = JSON.parse(fighter2Select.value);
        fighter2Image.src = selected2.imagen || 'placeholder2.png';
    }
}

// Actualizar la imagen al seleccionar un auto diferente
fighter1Select.addEventListener('change', () => {
    const selected = JSON.parse(fighter1Select.value);
    fighter1Image.src = selected.imagen || 'placeholder1.png';
});

fighter2Select.addEventListener('change', () => {
    const selected = JSON.parse(fighter2Select.value);
    fighter2Image.src = selected.imagen || 'placeholder2.png';
});

// Lógica para realizar la pelea
fightButton.addEventListener('click', () => {
    const fighter1 = JSON.parse(fighter1Select.value);
    const fighter2 = JSON.parse(fighter2Select.value);

    if (!fighter1 || !fighter2) {
        alert('Seleccioná ambos competidores.');
        return;
    }

    // Calcular o simular fuerza / potencia
    const power1 = fighter1.nivelDePoder || fighter1.puntosVida || (Math.floor(Math.random() * 1000) + 500);
    const power2 = fighter2.nivelDePoder || fighter2.puntosVida || (Math.floor(Math.random() * 1000) + 500);

    let winner;
    if (power1 > power2) {
        winner = fighter1.nombre;
    } else if (power2 > power1) {
        winner = fighter2.nombre;
    } else {
        winner = "¡Empate!";
    }

    resultDiv.textContent = `🏆 El ganador es: ${winner}! 🏎️`;
    resultDiv.classList.remove('hidden');
});

fetchData();