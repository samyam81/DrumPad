
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

public class Drum {

    JFrame frame = new JFrame();

    Color first = new Color(210, 4, 45);
    Color second = new Color(253, 253, 253);
    Color third = new Color(137, 207, 240);
    Color fourth = new Color(255, 119, 188);

    // Buttons
    JButton btn1 = new JButton("BUBBLES");
    JButton btn2 = new JButton("CLAY");
    JButton btn3 = new JButton("CONFETTI");
    JButton btn4 = new JButton("GLIMMER");
    JButton btn5 = new JButton("MOON");
    JButton btn6 = new JButton("UFO");
    JButton btn7 = new JButton("Kick 1");
    JButton btn8 = new JButton("Kick 2");
    JButton btn9 = new JButton("Kick 3");

    // MP3 players
    MP3Player mp3player1 = new MP3Player(new File("Sound\\bubbles.mp3"));
    MP3Player mp3player2 = new MP3Player(new File("Sound\\clay.mp3"));
    MP3Player mp3player3 = new MP3Player(new File("Sound\\confetti.mp3"));
    MP3Player mp3player4 = new MP3Player(new File("Sound\\glimmer.mp3"));
    MP3Player mp3player5 = new MP3Player(new File("Sound\\moon.mp3"));
    MP3Player mp3player6 = new MP3Player(new File("Sound\\ufo.mp3"));
    MP3Player mp3player7 = new MP3Player(new File("Sound\\7.mp3"));
    MP3Player mp3player8 = new MP3Player(new File("Sound\\8.mp3"));
    MP3Player mp3player9 = new MP3Player(new File("Sound\\9.mp3"));

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Drum();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Drum() {
        frame.setTitle("DrumPad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 341, 498);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(226, 114, 91));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout()); // Set layout to BorderLayout

        // Add DRUMPAD label to the top of the frame
        JLabel lblTitle = new JLabel("DRUMPAD");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitle, BorderLayout.NORTH);

        JPanel drumButtonsPanel = new JPanel();
        drumButtonsPanel.setBackground(new Color(65, 105, 225));
        drumButtonsPanel.setLayout(new GridLayout(3, 3)); // Set layout to GridLayout

        // Add buttons to drumButtonsPanel
        drumButtonsPanel.add(createStyledButton(btn1, first));
        drumButtonsPanel.add(createStyledButton(btn2, second));
        drumButtonsPanel.add(createStyledButton(btn3, third));
        drumButtonsPanel.add(createStyledButton(btn4, fourth));
        drumButtonsPanel.add(createStyledButton(btn5, third));
        drumButtonsPanel.add(createStyledButton(btn6, second));
        drumButtonsPanel.add(createStyledButton(btn7, Color.PINK));
        drumButtonsPanel.add(createStyledButton(btn8, first));
        drumButtonsPanel.add(createStyledButton(btn9, fourth));

        // Add action listeners to buttons
        addActionListeners();

        contentPane.add(drumButtonsPanel, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }

    // Method to add action listeners to buttons
    private void addActionListeners() {
        btn1.addActionListener(createActionListener(mp3player1));
        btn2.addActionListener(createActionListener(mp3player2));
        btn3.addActionListener(createActionListener(mp3player3));
        btn4.addActionListener(createActionListener(mp3player4));
        btn5.addActionListener(createActionListener(mp3player5));
        btn6.addActionListener(createActionListener(mp3player6));
        btn7.addActionListener(createActionListener(mp3player7));
        btn8.addActionListener(createActionListener(mp3player8));
        btn9.addActionListener(createActionListener(mp3player9));
    }

    // Method to create action listener for buttons
    private ActionListener createActionListener(MP3Player mp3Player) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mp3Player.play();
            }
        };
    }

    // Method to create a styled button
    private JButton createStyledButton(JButton button, Color color) {
        button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button.setBackground(color);
        button.setFocusable(false);
        return button;
    }
}
