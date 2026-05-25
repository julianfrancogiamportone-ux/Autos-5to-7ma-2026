package autos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import autos.entidades.Ataque;
import autos.entidades.Arma;
import autos.entidades.Peleador;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 1 — Nacimiento de los objetos
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIO 1 — Nacimiento de los objetos ══════");

        Arma espada = new Arma(0L, "Espada Larga",     15, 5.0f);
        Arma hacha  = new Arma(0L, "Hacha de Batalla", 20, 3.0f);
        Arma lanza  = new Arma(0L, "Lanza Afilada",    10, 2.0f);
        Arma maza   = new Arma(0L, "Maza Pesada",      25, 6.0f);
        Arma daga   = new Arma(0L, "Daga Venenosa",     8, 1.0f);

        // (id, nombre, costoEnergia, danioBase)
        Ataque corte    = new Ataque(0L, "Corte Profundo",  5, 10);
        Ataque golpe    = new Ataque(0L, "Golpe Poderoso",  7, 12);
        Ataque estocada = new Ataque(0L, "Estocada Rápida", 4,  8);

        List<Arma>   inventarioGuerrero   = new ArrayList<>();
        List<Arma>   inventarioBerserker  = new ArrayList<>();
        List<Ataque> habilidadesGuerrero  = new ArrayList<>();
        List<Ataque> habilidadesBerserker = new ArrayList<>();

        Peleador guerrero  = new Peleador(0L, "Guerrero Valiente", 1000, 50, 10.0f,
                null, inventarioGuerrero,  habilidadesGuerrero);
        Peleador berserker = new Peleador(0L, "Berserker Feroz",   1200, 40,  8.0f,
                null, inventarioBerserker, habilidadesBerserker);

        System.out.println("Peleador 1: " + guerrero.getNombre()
                + " | Vida inicial: " + guerrero.getPuntosVida());
        System.out.println("Peleador 2: " + berserker.getNombre()
                + " | Vida inicial: " + berserker.getPuntosVida());

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 2 — Equipamiento condicional
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIO 2 — Equipamiento condicional ══════");

        guerrero.setArmaEquipada(espada);
        berserker.setArmaEquipada(hacha);

        int bonusGuerrero  = guerrero.getArmaEquipada().getBonificadorDanio();
        int bonusBerserker = berserker.getArmaEquipada().getBonificadorDanio();

        if (bonusGuerrero > bonusBerserker) {
            System.out.println(guerrero.getNombre()
                    + " tiene el arma más fuerte (bonificador: " + bonusGuerrero + ").");
        } else if (bonusBerserker > bonusGuerrero) {
            System.out.println(berserker.getNombre()
                    + " tiene el arma más fuerte (bonificador: " + bonusBerserker + ").");
        } else {
            System.out.println("Ambos peleadores tienen el mismo bonificador: " + bonusGuerrero + ".");
        }

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 3 — Llenando el inventario
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIO 3 — Llenando el inventario ══════");

        List<Arma> todasLasArmas = List.of(espada, hacha, lanza, maza, daga);

        for (Arma arma : todasLasArmas) {
            guerrero.getInventarioList().add(arma);
            System.out.println("  [+] \"" + arma.getNombre()
                    + "\" agregada al inventario de " + guerrero.getNombre() + ".");
        }

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 4 — Buscando el mejor ataque
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIO 4 — Buscando el mejor ataque ══════");

        guerrero.getHabilidadesAtaquesList().add(corte);
        guerrero.getHabilidadesAtaquesList().add(golpe);
        guerrero.getHabilidadesAtaquesList().add(estocada);
        System.out.println("Habilidades agregadas a " + guerrero.getNombre() + ".");

        Ataque mejorAtaque = guerrero.getHabilidadesAtaquesList().get(0);

        for (Ataque habilidad : guerrero.getHabilidadesAtaquesList()) {
            if (habilidad.getDanioBase() > mejorAtaque.getDanioBase()) {
                mejorAtaque = habilidad;
            }
        }

        System.out.println("El ataque con mayor daño base es: \"" + mejorAtaque.getNombre()
                + "\" (" + mejorAtaque.getDanioBase() + " de daño base).");

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 5 — Promedio de consumo de energía
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIO 5 — Promedio de consumo ══════");

        int sumaEnergia = 0;
        for (Ataque habilidad : guerrero.getHabilidadesAtaquesList()) {
            sumaEnergia += habilidad.getCostoEnergia();
        }

        double promedio = (double) sumaEnergia / guerrero.getHabilidadesAtaquesList().size();
        System.out.println("Promedio de costo de energía de " + guerrero.getNombre() + ": " + promedio);

        if (promedio > 50) {
            System.out.println("ADVERTENCIA: el promedio supera los 50 de energía.");
        } else {
            System.out.println("El promedio de energía está dentro del límite (menor o igual a 50).");
        }

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 6 + 7 — Primer golpe con verificación de fatiga
        // Guerrero: 1000 vida, 50 energía | Berserker: 1200 vida, 40 energía
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIOS 6 y 7 — Primer golpe ══════");

        berserker.getHabilidadesAtaquesList().add(golpe);

        // EJ. 7 — verificación de fatiga
        if (guerrero.getEnergia() >= corte.getCostoEnergia()) {

            // EJ. 6 — cálculo del daño
            int bonificador = (guerrero.getArmaEquipada() != null)
                    ? guerrero.getArmaEquipada().getBonificadorDanio()
                    : 0;

            int danio = corte.getDanioBase() + bonificador;

            berserker.setPuntosVida(berserker.getPuntosVida() - danio);
            guerrero.setEnergia(guerrero.getEnergia() - corte.getCostoEnergia());

            System.out.println(guerrero.getNombre() + " usa \"" + corte.getNombre()
                    + "\" sobre " + berserker.getNombre() + " causando " + danio + " de daño.");
            System.out.println("Vida restante de " + berserker.getNombre()
                    + ": " + berserker.getPuntosVida());
            System.out.println("Energía restante de " + guerrero.getNombre()
                    + ": " + guerrero.getEnergia());

        } else {
            System.out.println(guerrero.getNombre() + " está demasiado cansado para atacar.");
        }

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 8 — Descanso táctico
        // Usa los valores actuales de cada peleador sin forzar nada.
        // vida < 200  → curación pesada: +500 vida, energía = 0
        // vida >= 200 → descanso rápido: +100 energía
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIO 8 — Descanso táctico ══════");

        // Guerrero
        if (guerrero.getPuntosVida() < 200) {
            guerrero.setPuntosVida(guerrero.getPuntosVida() + 500);
            guerrero.setEnergia(0);
            System.out.println(guerrero.getNombre()
                    + " recibe curación pesada → Vida: " + guerrero.getPuntosVida()
                    + " | Energía: " + guerrero.getEnergia());
        } else {
            guerrero.setEnergia(guerrero.getEnergia() + 100);
            System.out.println(guerrero.getNombre()
                    + " descansa rápido → Energía: " + guerrero.getEnergia());
        }

        // Berserker
        if (berserker.getPuntosVida() < 200) {
            berserker.setPuntosVida(berserker.getPuntosVida() + 500);
            berserker.setEnergia(0);
            System.out.println(berserker.getNombre()
                    + " recibe curación pesada → Vida: " + berserker.getPuntosVida()
                    + " | Energía: " + berserker.getEnergia());
        } else {
            berserker.setEnergia(berserker.getEnergia() + 100);
            System.out.println(berserker.getNombre()
                    + " descansa rápido → Energía: " + berserker.getEnergia());
        }

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 9 — Filtrado de habilidades
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIO 9 — Filtrado de habilidades ══════");
        System.out.println(guerrero.getNombre() + " tiene " + guerrero.getEnergia()
                + " de energía. Habilidades disponibles:");

        boolean hayDisponible = false;
        for (Ataque habilidad : guerrero.getHabilidadesAtaquesList()) {
            if (habilidad.getCostoEnergia() <= guerrero.getEnergia()) {
                System.out.println("  - " + habilidad.getNombre()
                        + " (costo: " + habilidad.getCostoEnergia() + ")");
                hayDisponible = true;
            }
        }
        if (!hayDisponible) {
            System.out.println("  (ninguna habilidad disponible con la energía actual)");
        }

        // ──────────────────────────────────────────────────────────────────────
        // EJERCICIO 10 — Combate a muerte (bucle while)
        // Sin sets ni recuperación de energía. Cuando un peleador se queda sin
        // energía, descansa (lógica del Ej.8) para que el combate no se trabe.
        // ──────────────────────────────────────────────────────────────────────
        System.out.println("\n══════ EJERCICIO 10 — Combate a muerte ══════");

        Ataque ataqueGuerrero  = guerrero.getHabilidadesAtaquesList().get(0);
        Ataque ataqueBerserker = berserker.getHabilidadesAtaquesList().get(0);

        int turno = 1;

        while (guerrero.getPuntosVida() > 0 && berserker.getPuntosVida() > 0) {
            System.out.println("\n--- Turno " + turno + " ---");

            // Guerrero ataca
            if (guerrero.getEnergia() >= ataqueGuerrero.getCostoEnergia()) {
                int bonificador = (guerrero.getArmaEquipada() != null)
                        ? guerrero.getArmaEquipada().getBonificadorDanio() : 0;
                int danio = ataqueGuerrero.getDanioBase() + bonificador;
                berserker.setPuntosVida(berserker.getPuntosVida() - danio);
                guerrero.setEnergia(guerrero.getEnergia() - ataqueGuerrero.getCostoEnergia());
                System.out.println(guerrero.getNombre() + " ataca por " + danio + " de daño.");
            } else {
                // sin energía → descansa (lógica Ej.8)
                if (guerrero.getPuntosVida() < 200) {
                    guerrero.setPuntosVida(guerrero.getPuntosVida() + 500);
                    guerrero.setEnergia(0);
                    System.out.println(guerrero.getNombre() + " recibe curación pesada.");
                } else {
                    guerrero.setEnergia(guerrero.getEnergia() + 100);
                    System.out.println(guerrero.getNombre() + " descansa y recupera energía.");
                }
            }

            if (berserker.getPuntosVida() <= 0) break;

            // Berserker ataca
            if (berserker.getEnergia() >= ataqueBerserker.getCostoEnergia()) {
                int bonificador = (berserker.getArmaEquipada() != null)
                        ? berserker.getArmaEquipada().getBonificadorDanio() : 0;
                int danio = ataqueBerserker.getDanioBase() + bonificador;
                guerrero.setPuntosVida(guerrero.getPuntosVida() - danio);
                berserker.setEnergia(berserker.getEnergia() - ataqueBerserker.getCostoEnergia());
                System.out.println(berserker.getNombre() + " ataca por " + danio + " de daño.");
            } else {
                // sin energía → descansa (lógica Ej.8)
                if (berserker.getPuntosVida() < 200) {
                    berserker.setPuntosVida(berserker.getPuntosVida() + 500);
                    berserker.setEnergia(0);
                    System.out.println(berserker.getNombre() + " recibe curación pesada.");
                } else {
                    berserker.setEnergia(berserker.getEnergia() + 100);
                    System.out.println(berserker.getNombre() + " descansa y recupera energía.");
                }
            }

            System.out.println("  [Estado] "
                    + guerrero.getNombre()  + ": " + guerrero.getPuntosVida()  + " vida | "
                    + berserker.getNombre() + ": " + berserker.getPuntosVida() + " vida");

            turno++;
        }

        System.out.println("\n══════ FIN DEL COMBATE ══════");
        if (guerrero.getPuntosVida() > 0 && berserker.getPuntosVida() <= 0) {
            System.out.println("Ganador: " + guerrero.getNombre() + "!");
        } else if (berserker.getPuntosVida() > 0 && guerrero.getPuntosVida() <= 0) {
            System.out.println("Ganador: " + berserker.getNombre() + "!");
        } else {
            System.out.println("Empate! Ambos cayeron al mismo tiempo.");
        }
    }
}