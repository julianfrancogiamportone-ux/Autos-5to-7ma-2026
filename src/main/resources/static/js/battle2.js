const API_NARUTO = 'http://localhost:8080/api/peleadores'; 

const fighter1Select = document.getElementById('fighter1'); 
const fighter2Select = document.getElementById('fighter2'); 
const fighter1Image = document.getElementById('fighter1Image'); 
const fighter2Image = document.getElementById('fighter2Image'); 
const fightButton = document.getElementById('fightButton'); 
const resultDiv = document.getElementById('result'); 

let peleadores = []; 

async function fetchData() {     
    try { 
        const responseNaruto = await fetch(API_NARUTO); 
        
        if (!responseNaruto.ok) {
            throw new Error(`Error HTTP: ${responseNaruto.status}`);
        }

        peleadores = await responseNaruto.json(); 
        loadFighters(); 

    } catch (error) { 
        console.error('Error al cargar los personajes:', error); 
        resultDiv.textContent = 'Error al cargar luchadores desde el servidor.';
    } 
} 

function loadFighters() { 
    // Limpiar opciones previas
    fighter1Select.innerHTML = '<option value="">-- Selecciona Luchador 1 --</option>';
    fighter2Select.innerHTML = '<option value="">-- Selecciona Luchador 2 --</option>';

    peleadores.forEach(fighter => { 
        const option1 = document.createElement('option'); 
        option1.value = JSON.stringify(fighter); 
        // Se muestra el nombre y sus puntos de vida/defensa
        option1.text = `${fighter.nombre} (HP: ${fighter.puntosVida || 100})`; 
        fighter1Select.appendChild(option1); 

        const option2 = document.createElement('option'); 
        option2.value = JSON.stringify(fighter); 
        option2.text = `${fighter.nombre} (HP: ${fighter.puntosVida || 100})`; 
        fighter2Select.appendChild(option2); 
    }); 
} 

// Actualizar la imagen al seleccionar un personaje
fighter1Select.addEventListener('change', () => { 
    if (!fighter1Select.value) {
        fighter1Image.src = 'placeholder1.png';
        return;
    }
    const selected = JSON.parse(fighter1Select.value); 
    // Usamos selected.imagen (el nombre exacto del atributo en Java)
    fighter1Image.src = selected.imagen || 'placeholder1.png'; 
}); 

fighter2Select.addEventListener('change', () => { 
    if (!fighter2Select.value) {
        fighter2Image.src = 'placeholder2.png';
        return;
    }
    const selected = JSON.parse(fighter2Select.value); 
    // Usamos selected.imagen (el nombre exacto del atributo en Java)
    fighter2Image.src = selected.imagen || 'placeholder2.png'; 
}); 

fightButton.addEventListener('click', () => { 
    if (!fighter1Select.value || !fighter2Select.value) { 
        alert('Seleccioná ambos luchadores.'); 
        return; 
    } 

    const fighter1 = JSON.parse(fighter1Select.value); 
    const fighter2 = JSON.parse(fighter2Select.value); 

    // Calculamos el poder usando puntosVida y defensaBase de la entidad Java
    const power1 = (fighter1.puntosVida || 100) + (fighter1.defensaBase || 0); 
    const power2 = (fighter2.puntosVida || 100) + (fighter2.defensaBase || 0); 

    let winner; 
    if (power1 > power2) { 
        winner = fighter1.nombre; 
    } else if (power2 > power1) { 
        winner = fighter2.nombre; 
    } else { 
        winner = "¡Empate!"; 
    } 

    resultDiv.textContent = `🏆 ¡El ganador es: ${winner}!`; 
    resultDiv.classList.remove('hidden'); 
}); 

fetchData();