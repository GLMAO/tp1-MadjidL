package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.beans.PropertyChangeEvent;

public class Horloge implements TimerChangeListener {
    private final String name;
    private final TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;
        this.timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialisée et enregistrée.");
    }

    private void afficherHeure() {
        if (timerService != null) {
            System.out.println(name + " affiche " +
                    String.format("%02d", timerService.getHeures()) + ":" +
                    String.format("%02d", timerService.getMinutes()) + ":" +
                    String.format("%02d", timerService.getSecondes()));
        }
    }

    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            afficherHeure();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Déjà géré par la méthode personnalisée via l'interface
    }
}