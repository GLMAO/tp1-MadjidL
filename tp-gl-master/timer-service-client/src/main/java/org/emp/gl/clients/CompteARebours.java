package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {

    private final String name;
    private final TimerService timerService;
    private int count;

    public CompteARebours(String name, TimerService timerService, int initialCount) {
        this.name = name;
        this.timerService = timerService;
        this.count = initialCount;
        timerService.addTimeChangeListener(this);
        System.out.println("[CLIENT] " + name + " démarré à T-" + initialCount);
    }

    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            if (count > 0) {
                count--;
                System.out.println("   [" + name + "] : T-" + count);
                if (count == 0) {
                    timerService.removeTimeChangeListener(this);
                    System.out.println("--- " + name + " FINI et DÉSINSCRIT. ---");
                }
            }
        }
    }
}