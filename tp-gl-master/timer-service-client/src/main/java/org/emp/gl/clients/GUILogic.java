package org.emp.gl.clients;

import javax.swing.*;
import java.awt.*;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class GUILogic extends JFrame {
    private final TimerService timerService = new DummyTimeServiceImpl();
    private JLabel timeLabel;

    public GUILogic() {
        // Initialisation de la fenêtre
        setTitle("Horloge Graphique");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centre la fenêtre

        // Création du label
        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        updateTime(); // Initialisation

        // Ajout du listener pour les changements de seconde
        timerService.addTimeChangeListener((prop, oldValue, newValue) -> {
            if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
                SwingUtilities.invokeLater(this::updateTime); // Mise à jour thread-safe
            }
        });

        // Ajout du label à la fenêtre
        add(timeLabel);
    }

    private void updateTime() {
        if (timerService != null) {
            timeLabel.setText(String.format("%02d:%02d:%02d",
                    timerService.getHeures(),
                    timerService.getMinutes(),
                    timerService.getSecondes()));
        }
    }

    public static void main(String[] args) {
        // Lancement de l'application Swing
        SwingUtilities.invokeLater(() -> {
            GUILogic gui = new GUILogic();
            gui.setVisible(true);
        });
    }
}