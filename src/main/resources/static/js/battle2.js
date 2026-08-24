const API_AUTOS = 'http://localhost:8080/api/peleadores';
const API_ARTISTAS = 'http://localhost:8081/api/characters';

// Servidores base donde están alojadas las imágenes
const HOST_AUTOS = 'http://localhost:8080';
const HOST_ARTISTAS = 'http://localhost:8081';

// Imagen por defecto en línea por si no existe el archivo local
const PLACEHOLDER_IMG = 'https://via.placeholder.com/150?text=Sin+Imagen';

const fighter1Select = document.getElementById('fighter1');
const fighter2Select = document.getElementById('fighter2');
const fighter1Image = document.getElementById('fighter1Image');
const fighter2Image = document.getElementById('fighter2Image');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');

let competidoresGlobales = [];

// Función auxiliar para construir la URL correcta de la imagen
function resolverUrlImagen(urlOriginal, hostBase) {
    if (!urlOriginal) return PLACEHOLDER_IMG;
    if (urlOriginal.startsWith('http://') || urlOriginal.startsWith('https://')) {
        return urlOriginal;
    }
    // Si la ruta es relativa (ej: "images/khea.jpg" o "/drake.webp"), le pegamos el servidor base
    const rutaLimpia = urlOriginal.startsWith('/') ? urlOriginal : '/' + urlOriginal;
    return hostBase + rutaLimpia;
}

async function fetchData() {
    let autos = [];
    let artistas = [];

    // 1. Cargar Autos
    try {
        const responseAutos = await fetch(API_AUTOS);
        const crudosAutos = await responseAutos.json();
        autos = crudosAutos.map(auto => ({
            ...auto,
            imagen: resolverUrlImagen(auto.imagen, HOST_AUTOS)
        }));
    } catch (error) {
        console.error('Error al cargar autos:', error);
    }

    // 2. Cargar Artistas
    try {
        const responseArtistas = await fetch(API_ARTISTAS);
        const crudosArtistas = await responseArtistas.json();
        
        artistas = crudosArtistas.map(artista => {
            const poderArtista = artista.puntosVida + (artista.defensaBase * 10) + artista.energia;
            const imgRaw = artista.url_imagen || artista.url_Imagen;
            
            return {
                id: artista.id + 10000,
                nombre: artista.nombre,
                marca: 'Artista',
                imagen: resolverUrlImagen(imgRaw, HOST_ARTISTAS),
                nivelDePoder: poderArtista
            };
        });
    } catch (error) {
        console.error('Error al cargar artistas:', error);
    }

    competidoresGlobales = [...autos, ...artistas];
    loadFighters();
}

function loadFighters() {
    fighter1Select.innerHTML = '';
    fighter2Select.innerHTML = '';

    competidoresGlobales.forEach(fighter => {
        const option1 = document.createElement('option');
        option1.value = JSON.stringify(fighter);
        option1.text = `${fighter.nombre} (${fighter.marca || fighter.modelo || ''})`;
        fighter1Select.appendChild(option1);

        const option2 = document.createElement('option');
        option2.value = JSON.stringify(fighter);
        option2.text = `${fighter.nombre} (${fighter.marca || fighter.modelo || ''})`;
        fighter2Select.appendChild(option2);
    });

    if (competidoresGlobales.length > 0) {
        actualizarImagen(fighter1Select, fighter1Image);
        actualizarImagen(fighter2Select, fighter2Image);
    }
}

function actualizarImagen(selectElement, imageElement) {
    if (!selectElement.value) return;
    const selected = JSON.parse(selectElement.value);
    imageElement.src = selected.imagen || PLACEHOLDER_IMG;
    
    // Evita romper la UI si la imagen tampoco existe en el servidor backend
    imageElement.onerror = () => {
        imageElement.src = PLACEHOLDER_IMG;
    };
}

fighter1Select.addEventListener('change', () => actualizarImagen(fighter1Select, fighter1Image));
fighter2Select.addEventListener('change', () => actualizarImagen(fighter2Select, fighter2Image));

fightButton.addEventListener('click', () => {
    if (!fighter1Select.value || !fighter2Select.value) {
        alert('Seleccioná ambos competidores.');
        return;
    }

    const fighter1 = JSON.parse(fighter1Select.value);
    const fighter2 = JSON.parse(fighter2Select.value);

    const power1 = fighter1.nivelDePoder || fighter1.puntosVida || (Math.floor(Math.random() * 1000) + 500);
    const power2 = fighter2.nivelDePoder || fighter2.puntosVida || (Math.floor(Math.random() * 1000) + 500);

    let winnerText;
    if (power1 > power2) {
        winnerText = `🏆 ¡El ganador es ${fighter1.nombre} con ${power1} pts! 💥`;
    } else if (power2 > power1) {
        winnerText = `🏆 ¡El ganador es ${fighter2.nombre} con ${power2} pts! 💥`;
    } else {
        winnerText = "🤝 ¡Empate!";
    }

    resultDiv.textContent = winnerText;
    resultDiv.classList.remove('hidden');
});

fetchData();