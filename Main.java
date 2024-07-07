import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Window window = new Window();
    }
}












































































































/*
import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private ImageIconButton blackWhite;
    private final Image BACKGROUND;
    private final int WIDTH;
    private final int HEIGHT;
    private final int BUTTON_WIDTH = 150;
    private final int BUTTON_HEIGHT = 50;
    private Image blackWhite1;

    public ButtonsPanel(Image background,int width, int height, Window window){
        this.BACKGROUND = background;
        this.WIDTH = width;
        this.HEIGHT = height;

        this.setBounds(0,(HEIGHT/4)*3, WIDTH, HEIGHT/4);
        this.setLayout(null);
        this.setFocusable(true);

        blackWhite = new ImageIconButton(new ImageIcon("Images\\ImagesPlan\\black-white.jpg"), new ImageIcon("Images\\ImagesPlan\\black-white.jpg"));
        blackWhite1 = new ImageIcon("Images\\ImagesPlan\\background.jpg").getImage();
        blackWhite.scaleIcons(BUTTON_WIDTH,BUTTON_HEIGHT);
        blackWhite.setContentAreaFilled(false);
        blackWhite.setBorderPainted(false);
        blackWhite.setFocusPainted(true);
        this.add(blackWhite);
        this.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(BACKGROUND,0,0,WIDTH,HEIGHT,this);
        blackWhite.paint(g, 1000,1000,BUTTON_WIDTH,BUTTON_HEIGHT);
        g.drawImage(new ImageIcon("src\\gameImages\\Doodle Jump\\hole@2x.png").getImage(),0,0,null);
    }
}

*/