package animalworld.view;

import animalworld.model.Entity;
import animalworld.model.Environment;
import animalworld.model.TestEntity;

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

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Entity entity: environment.getEntities()) {
                    (new Thread(new EntityView(entity))).start();
                }
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
        frame.setPreferredSize(new Dimension(350, 300));
        frame.setMinimumSize(new Dimension(200, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
