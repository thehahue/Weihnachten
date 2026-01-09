package com.weihnachten.observer.unwetter;

import java.util.Random;

public class WetterSimulator {
    private Unwetterstatus wetterSystem;
    private Random random;
    private boolean running;

    public WetterSimulator(Unwetterstatus wetterSystem) {
        this.wetterSystem = wetterSystem;
        this.random = new Random();
        this.running = true;
    }

    public void startSimulation(int iterations) {
        System.out.println("\n>>> Wetter-Simulator gestartet (Intervall: 5s) <<<");

        int count = 0;
        while (running) {
            try {
                Thread.sleep(5000);

                double temperatur = -15.0 + (random.nextDouble() * 55.0);
                double wind = random.nextDouble() * 120.0;
                double druck = 960.0 + (random.nextDouble() * 80.0);
                double regen = random.nextDouble() * 80.0;

                System.out.println("\n[Simulator] Neue Messung...");
                wetterSystem.setWetterDaten(temperatur, wind, druck, regen);

                count++;

                if (count == iterations) {
                    running = false;
                }
            } catch (InterruptedException e) {
                System.out.println("Simulation unterbrochen.");
                running = false;
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(">>> Simulator beendet <<<");
    }
}
