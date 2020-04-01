/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author asksoft
 */
public class MarqueePanel extends JPanel {

    private JLabel textLabel;
    private int panelLocation;
    private ActionListener taskPerformer;
    private boolean isRunning = false;

    public static final int FRAMES_PER_SECOND = 24;
    public static final int MOVEMENT_PER_FRAME = 5;

    /**
     * Class constructor creates a marquee panel.
     */
    public MarqueePanel() {
        this.setLayout(null);
        this.textLabel = new JLabel("Scrolling Text Here");
        this.panelLocation = 0;
        this.taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MarqueePanel.this.tickAnimation();
            }
        };
    }

    /**
     * Starts the animation.
     */
    public void start() {
        this.isRunning = true;
        this.tickAnimation();
    }

    /**
     * Stops the animation.
     */
    public void stop() {
        this.isRunning = false;
    }

    /**
     * Moves the label one frame to the left. If it's out of display range, move
     * it back to the right, out of display range.
     */
    private void tickAnimation() {
        this.panelLocation -= MarqueePanel.MOVEMENT_PER_FRAME;
        if (this.panelLocation < this.textLabel.getWidth()) {
            this.panelLocation = this.getWidth();
        }
        this.textLabel.setLocation(this.panelLocation, 0);
        this.repaint();
        if (this.isRunning) {
            Timer t = new Timer(1000 / MarqueePanel.FRAMES_PER_SECOND, this.taskPerformer);
            t.setRepeats(false);
            t.start();
        }
    }
   
}
