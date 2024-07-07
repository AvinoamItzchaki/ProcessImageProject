import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Window extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private ButtonsPanel buttonsPanel;
    private MainScene mainScene;
    private BufferedImage image;
    public Window () {
        buttonsPanel = new ButtonsPanel(0,(HEIGHT/4)*3,WIDTH,HEIGHT/4,this);
        this.add(buttonsPanel);
        buttonsPanel.repaint();

        fileChooser();
        mainScene = new MainScene(0,0,WIDTH,(HEIGHT/4)*3, image);
        this.add(mainScene);
        mainScene.repaint();


        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFocusable(true);
    }
    private void fileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        try {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                this.image = ImageIO.read(file);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public void setButtonsPanel(ButtonsPanel buttonsPanel) {
        this.buttonsPanel = buttonsPanel;
    }

    public MainScene getMainScene() {
        return mainScene;
    }

    public void setMainScene(MainScene mainScene) {
        this.mainScene = mainScene;
    }
}