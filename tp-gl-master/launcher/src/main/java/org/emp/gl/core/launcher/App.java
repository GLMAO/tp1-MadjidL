package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

import java.util.Random;

public class App {

    public static void main(String[] args) throws InterruptedException {
        testDuTimeService();
    }

    private static void testDuTimeService() throws InterruptedException {
        TimerService service = new DummyTimeServiceImpl();

        // Étape c
        new Horloge("Num 1", service);
        new Horloge("Num 2", service);
        System.out.println("\n--- DÉBUT : Étape (c) - Horloges en cours ---");
        Thread.sleep(5000);

        // Étape d.1
        System.out.println("\n--- DÉBUT : Étape (d.1) - CompteARebours simple ---");
        new CompteARebours("CA-Simple", service, 5);
        Thread.sleep(6000);

        // Étape d.3
        System.out.println("\n--- DÉBUT : Étape (d.3) - 10 CompteARebours aléatoires ---");
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int randomValue = random.nextInt(11) + 10;
            new CompteARebours("CA-R-" + i, service, randomValue);
        }
        System.out.println("[MAIN] Les comptes à rebours sont lancés. Attendre...");
        Thread.sleep(25000);

        System.out.println("\n--- FIN des tests ---");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}