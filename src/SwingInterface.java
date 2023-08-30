import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SwingInterface extends JFrame {

    public SwingInterface() {
        setTitle("Simple Swing Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JButton button = new JButton("Click Me! :)");
        button.addActionListener(e -> JOptionPane.showMessageDialog(SwingInterface.this, "Button Clicked!"));

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(button);

        playAudio();
    }

    private void playAudio() {
        Thread audioThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String mp3FilePath = "reflected-light-147979.mp3";
                    AdvancedPlayer player = new AdvancedPlayer(Objects.requireNonNull(getClass().getResourceAsStream(mp3FilePath)));

                    player.setPlayBackListener(new PlaybackListener() {
                        @Override
                        public void playbackFinished(PlaybackEvent evt) {
                            player.close();
                        }
                    });

                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        audioThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingInterface simpleSwing = new SwingInterface();
            simpleSwing.setVisible(true);
        });
    }
}
