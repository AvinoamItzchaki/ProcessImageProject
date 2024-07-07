import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private final int WIDTH;
    private final int HEIGHT;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 50;
    private Image blackWhite1;

    public ButtonsPanel(int x,int y,int width, int height, Window window){

        this.WIDTH = width;
        this.HEIGHT = height;
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.setFocusable(true);

        JButton blackWhite = new JButton("black white");
        JButton grayscale = new JButton("grayscale");
        JButton colorShiftRight = new JButton("colorShiftRight");
        JButton lighter = new JButton("lighter");
        JButton darker = new JButton("darker");
        JButton colorShiftLeft = new JButton("colorShiftLeft");
        JButton normal = new JButton("normal");
        JButton noise = new JButton("noise");
        JButton sepia = new JButton("sepia");
        JButton vintage = new JButton("vintage");
        JButton negative = new JButton("negative");
        JButton solarize = new JButton("solarize");

        blackWhite.setBounds(0,0,BUTTON_WIDTH,BUTTON_HEIGHT);
        grayscale.setBounds(0,BUTTON_HEIGHT,BUTTON_WIDTH,BUTTON_HEIGHT);
        negative.setBounds(0,BUTTON_HEIGHT*2,BUTTON_WIDTH,BUTTON_HEIGHT);

        lighter.setBounds(BUTTON_WIDTH+50,0,BUTTON_WIDTH,BUTTON_HEIGHT);
        darker.setBounds(BUTTON_WIDTH+50,BUTTON_HEIGHT , BUTTON_WIDTH , BUTTON_HEIGHT);
        solarize.setBounds(BUTTON_WIDTH+50, BUTTON_HEIGHT*2,  BUTTON_WIDTH ,BUTTON_HEIGHT);

        noise.setBounds(BUTTON_WIDTH*2+100, 0,BUTTON_WIDTH,BUTTON_HEIGHT);
        sepia.setBounds(BUTTON_WIDTH*2+100, BUTTON_HEIGHT,BUTTON_WIDTH,BUTTON_HEIGHT);
        vintage.setBounds(BUTTON_WIDTH*2+100, BUTTON_HEIGHT*2,BUTTON_WIDTH,BUTTON_HEIGHT);

        normal.setBounds(BUTTON_WIDTH*3+150,0,BUTTON_WIDTH+50 ,BUTTON_HEIGHT);
        colorShiftRight.setBounds(BUTTON_WIDTH*3+150,BUTTON_HEIGHT,BUTTON_WIDTH+50 ,BUTTON_HEIGHT);
        colorShiftLeft.setBounds(BUTTON_WIDTH*3+150,BUTTON_HEIGHT*2,BUTTON_WIDTH+50 ,BUTTON_HEIGHT);


        blackWhite.addActionListener(e -> {
            System.out.println("aaaaaa");
            window.getMainScene().applyFilterToBlackWhite();
            window.getMainScene().setCurrentFilter("Black White");
            window.getMainScene().repaint();
        });

        grayscale.addActionListener(e -> {
            window.getMainScene().applyFilterToGrayscale();
            window.getMainScene().setCurrentFilter("Gray Scale");
            window.getMainScene().repaint();
        });

        colorShiftRight.addActionListener(e -> {
            window.getMainScene().applyFilterToColorShiftRight();
            window.getMainScene().setCurrentFilter("Color Shift Right");
            window.getMainScene().repaint();
        });

        colorShiftLeft.addActionListener(e -> {
            window.getMainScene().applyFilterToColorShiftLeft();
            window.getMainScene().setCurrentFilter("Color Shift Left");
            window.getMainScene().repaint();
        });

        lighter.addActionListener(e -> {
            window.getMainScene().applyFilterToLighter();
            window.getMainScene().setCurrentFilter("Lighter");
            window.getMainScene().repaint();
        });

        darker.addActionListener(e -> {
            window.getMainScene().applyFilterToDarker();
            window.getMainScene().setCurrentFilter("Darker");
            window.getMainScene().repaint();
        });

        noise.addActionListener(e -> {
            window.getMainScene().applyFilterToNoise();
            window.getMainScene().setCurrentFilter("Noise");
            window.getMainScene().repaint();
        });
        sepia.addActionListener(e -> {
            window.getMainScene().applyFilterToSepia();
            window.getMainScene().setCurrentFilter("Sepia");
            window.getMainScene().repaint();
        });
        vintage.addActionListener(e -> {
            //noise+sepia
            window.getMainScene().setCurrentFilter("Vintage");
            window.getMainScene().applyFilterToVintage();
            window.getMainScene().repaint();
        });
        normal.addActionListener(e -> {
            window.getMainScene().applyFilterToNormal();
            window.getMainScene().setCurrentFilter("Normal");
            window.getMainScene().repaint();
        });
        solarize.addActionListener(e -> {
            window.getMainScene().applyFilterToSolarize();
            window.getMainScene().setCurrentFilter("Solarize");
            window.getMainScene().repaint();
        });
        negative.addActionListener(e -> {
            window.getMainScene().applyFilterToNegative();
            window.getMainScene().setCurrentFilter("Negative");
            window.getMainScene().repaint();
        });

        this.add(blackWhite);
        this.add(grayscale);
        this.add(colorShiftRight);
        this.add(lighter);
        this.add(darker);
        this.add(colorShiftLeft);
        this.add(normal);
        this.add(noise);
        this.add(sepia);
        this.add(vintage);
        this.add(solarize);
        this.add(negative);

        this.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        //g.drawImage(BACKGROUND,0,0,WIDTH,HEIGHT,this);
        Color color = new Color(31, 174, 217);
        g.setColor(color);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }

}

