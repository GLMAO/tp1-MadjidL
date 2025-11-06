package org.emp.gl.timer.service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface TimerChangeListener extends PropertyChangeListener {
    String DIXEME_DE_SECONDE_PROP = "dixième";
    String SECONDE_PROP = "seconde";
    String MINUTE_PROP = "minute";
    String HEURE_PROP = "heure";

    // Méthode personnalisée (abstraite ici pour forcer l'implémentation)
    void propertyChange(String prop, Object oldValue, Object newValue);

    // Implémentation par défaut pour PropertyChangeListener
    @Override
    default void propertyChange(PropertyChangeEvent evt) {
        propertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
    }
}