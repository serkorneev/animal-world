package com.griddynamics.devschool.animalworld.view;

import com.griddynamics.devschool.animalworld.model.Entity;
import com.griddynamics.devschool.animalworld.model.Environment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Sergey Korneev
 */
public class MainFrame {
    public static EntitiesPanel ep;

    public static void createGUI() {
        final JFrame frame = new JFrame("Animal World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        ep = new EntitiesPanel();
        final JScrollPane scrollPane = new JScrollPane(ep);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        final JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        final Environment environment = new Environment();
        final JButton startButton = new JButton("Start");
        actionPanel.add(startButton);

        final JButton pauseButton = new JButton("Pause");
        pauseButton.setEnabled(false);
        actionPanel.add(pauseButton);

        for (Entity entity: environment.getEntities()) {
            ep.addView(new EntityView(entity));
        }
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                environment.start();
                startButton.setEnabled(false);
                pauseButton.setEnabled(true);
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                environment.stop();
                pauseButton.setEnabled(false);
                startButton.setEnabled(true);
            }
        });

        mainPanel.add(actionPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(EntitiesPanel.MAX_WIDTH, EntitiesPanel.MAX_HEIGHT));
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setMaximumSize(new Dimension(EntitiesPanel.MAX_WIDTH + 5, EntitiesPanel.MAX_HEIGHT + 65));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
