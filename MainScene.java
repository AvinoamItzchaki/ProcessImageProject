import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MainScene extends JPanel implements MouseMotionListener {
    private double percentScrrenToFilter;
    public static int MAIN_SCENE_WIDTH = 0;
    public static int MAIN_SCENE_HEIGHT = 0;
    private String currentFilter;
    private Stick stick;
    private BufferedImage imageBefore ;
    private BufferedImage imageAfter ;
    private BufferedImage image ;


    public MainScene (int x, int y, int width, int height, BufferedImage image){
        setPictureTodisplay(image);
        this.image = image;
        MAIN_SCENE_WIDTH = width;
        MAIN_SCENE_HEIGHT = height;
        percentScrrenToFilter = 0.0;
        this.currentFilter = "Normal";
        this.setBounds(x,y,width,height);
        this.stick= new Stick(width/2,0,10,height);
        this.setFocusable(true);
        this.addMouseMotionListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageAfter,0,0,MAIN_SCENE_WIDTH,MAIN_SCENE_HEIGHT,this);
        //g.drawImage(imageAfter,0,0,stick.getX(),MAIN_SCENE_HEIGHT,this);
        //g.drawImage(imageBefore,stick.getX(),0,MAIN_SCENE_WIDTH - stick.getX(),MAIN_SCENE_HEIGHT,this);
        this.stick.paint(g);
    }

    public boolean withinBoundsPerPixel(int currX){
        boolean within = false;
        double widthPanel = this.getWidth();
        percentScrrenToFilter=  (this.stick.getX()) / (widthPanel);
        int xAtPicture=(int) (percentScrrenToFilter*this.image.getWidth());
        if(currX>= xAtPicture){within=true;}
        return within;

    }
    public void setPictureTodisplay(BufferedImage image) {
        this.setBounds(0, 0, image.getWidth(), image.getHeight());
        this.imageBefore = image;
        this.imageAfter = copyImage(image);

    }


    public BufferedImage copyImage(BufferedImage original) {
        BufferedImage copy = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        Graphics g = copy.getGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        return copy;
    }
    public void  switchCaseFilterAplly(){
        switch (currentFilter) {
            case "Negative":
                applyFilterToNegative();
                break;
            case "Gray Scale":
                applyFilterToGrayscale();
                break;
            case "Black White":
                applyFilterToBlackWhite();
                break;
            case "Color Shift Left":
                applyFilterToColorShiftLeft();
                break;
            case "Color Shift Right":
                applyFilterToColorShiftRight();
                break;
            case "Lighter":
                applyFilterToLighter();
                break;
            case "Darker":
                applyFilterToDarker();
                break;
            case "Sepia":
                applyFilterToSepia();
                break;
            case "Noise":
                applyFilterToNoise();
                break;
            case "Vintage":
                applyFilterToVintage();
                break;
            case "Solarize":
                applyFilterToSolarize();
                break;
            case "Normal":
                break;
            default:
                break;
        }

        repaint();

    }


    public Stick getStick() {
        return stick;
    }

    public void setStick(Stick stick) {
        this.stick = stick;
    }


    public BufferedImage getImageBefore() {
        return imageBefore;
    }

    public void setImageBefore(BufferedImage imageBefore) {
        this.imageBefore = imageBefore;
    }

    public BufferedImage getImageAfter() {
        return imageAfter;
    }

    public void setImageAfter(BufferedImage imageAfter) {
        this.imageAfter = imageAfter;
    }

    public String getCurrentFilter() {
        return currentFilter;
    }

    public void setCurrentFilter(String currentFilter) {
        this.currentFilter = currentFilter;
    }

    public void applyFilterToBlackWhite() {
        this.imageAfter = copyImage(this.image);
        for (int x = 0; x < imageAfter.getWidth() ; x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                int colorCode = imageAfter.getRGB(x,y);
                Color color = new Color(colorCode);
                int avarage = (color.getRed() + color.getGreen() + color.getBlue())/3;
                Color newColor = new Color(avarage,avarage,avarage);
                if (avarage >= 128){
                    newColor = new Color(255,255,255);
                }
                else {
                    newColor = new Color(0,0,0);
                }
                imageAfter.setRGB(x,y,newColor.getRGB());
            }
            }
        }
    }

    public void applyFilterToGrayscale() {
        this.imageAfter = copyImage(this.image);;
        for (int x = 0; x < imageAfter.getWidth() ; x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int colorCode = imageAfter.getRGB(x, y);
                    Color color = new Color(colorCode);
                    int avarage = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                    Color newColor = new Color(avarage, avarage, avarage);
                    imageAfter.setRGB(x, y, newColor.getRGB());
                }
            }
        }
    }
    public void applyFilterToColorShiftRight() {
        this.imageAfter = copyImage(this.image);;
        for (int x = 0; x < imageAfter.getWidth() ; x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int colorCode = imageAfter.getRGB(x,y);
                    Color color = new Color(colorCode);
                    int red = color.getRed(),green = color.getGreen(),blue = color.getBlue();
                    Color newColor = new Color(blue,red,green);
                    imageAfter.setRGB(x,y,newColor.getRGB());
                }
            }
        }
    }

    public void applyFilterToColorShiftLeft() {
        this.imageAfter = copyImage(this.image);
        for (int x = 0; x < imageAfter.getWidth() ; x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int colorCode = imageAfter.getRGB(x, y);
                    Color color = new Color(colorCode);
                    int red = color.getRed(), green = color.getGreen(), blue = color.getBlue();
                    Color newColor = new Color(green, blue, red);
                    imageAfter.setRGB(x, y, newColor.getRGB());
                }
            }
        }
    }
    public void applyFilterToLighter() {
        this.imageAfter = copyImage(this.image);;
        for (int x = 0; x < imageAfter.getWidth() ; x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int colorCode = imageAfter.getRGB(x, y);
                    Color color = new Color(colorCode);
                    int red = color.getRed(), green = color.getGreen(), blue = color.getBlue();
                    red = (int) (red * 1.5);
                    green = (int) (green * 1.5);
                    blue = (int) (blue * 1.5);
                    if (red > 255) {
                        red = 255;
                    }
                    if (green > 255) {
                        green = 255;
                    }
                    if (blue > 255) {
                        blue = 255;
                    }
                    Color newColor = new Color(red, green, blue);
                    imageAfter.setRGB(x, y, newColor.getRGB());
                }
            }
        }
    }
    public void applyFilterToDarker() {
        this.imageAfter = copyImage(this.image);;
        for (int x = 0; x < imageAfter.getWidth() ; x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int colorCode = imageAfter.getRGB(x, y);
                    Color color = new Color(colorCode);
                    int red = color.getRed(), green = color.getGreen(), blue = color.getBlue();
                    Color newColor = new Color((int) (red * 0.6667), (int) (green * 0.6667), (int) (blue * 0.6667));
                    imageAfter.setRGB(x, y, newColor.getRGB());
                }
            }
        }
    }

    public void applyFilterToNoise() {
        this.imageAfter = copyImage(this.image);
        Random random = new Random();
        double noiseLevel = 0.3;

        BufferedImage noisyImage = new BufferedImage(imageAfter.getWidth(), imageAfter.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = noisyImage.createGraphics();
        g2d.drawImage(imageAfter, 0, 0, null);

        for (int x = 0; x < imageAfter.getWidth(); x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int pixel = imageAfter.getRGB(x, y);
                    int red = (pixel >> 16) & 0xFF;
                    int green = (pixel >> 8) & 0xFF;
                    int blue = pixel & 0xFF;

                    int noise = (int) (noiseLevel * random.nextFloat() * 255);

                    red = Math.max(0, Math.min(red + noise, 255));
                    green = Math.max(0, Math.min(green + noise, 255));
                    blue = Math.max(0, Math.min(blue + noise, 255));

                    int newPixel = (red << 16) | (green << 8) | blue;
                    noisyImage.setRGB(x, y, newPixel);
                }
            }
        }
        g2d.dispose();
        this.imageAfter = noisyImage;
    }
    public void applyFilterToSepia() {
        if (!currentFilter.equals("Vintage")){
            this.imageAfter = copyImage(this.image);
        }
        for (int x = 0; x < imageAfter.getWidth() ; x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int colorCode = imageAfter.getRGB(x, y);
                    Color color = new Color(colorCode);
                    int red = color.getRed(), green = color.getGreen(), blue = color.getBlue();
                    int outputRed, outputGreen, outputBlue;
                    outputRed = (int) (red * 0.393) + (int) (green * 0.769) + (int) (blue * 0.189);
                    outputGreen = (int) (red * 0.349) + (int) (green * 0.686) + (int) (blue * 0.168);
                    outputBlue = (int) (red * 0.272) + (int) (green * 0.534) + (int) (blue * 0.131);
                    if (outputRed > 255) {
                        outputRed = 255;
                    }
                    if (outputGreen > 255) {
                        outputGreen = 255;
                    }
                    if (outputBlue > 255) {
                        outputBlue = 255;
                    }
                    Color newColor = new Color(outputRed, outputGreen, outputBlue);
                    imageAfter.setRGB(x, y, newColor.getRGB());
                }
            }
        }
    }
    public void applyFilterToVintage() {
        applyFilterToNoise();
        applyFilterToSepia();
    }
    public void applyFilterToNormal() {
        this.imageAfter = copyImage(this.image);
    }
    public void applyFilterToSolarize() {
        this.imageAfter = copyImage(this.image);

        for (int x = 0; x < imageAfter.getWidth(); x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int rgb = imageAfter.getRGB(x, y);

                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;

                    if (red > 127) {
                        red = 255 - red;
                    }
                    if (green > 127) {
                        green = 255 - green;
                    }
                    if (blue > 127) {
                        blue = 255 - blue;
                    }
                    int newRGB = (red << 16) | (green << 8) | blue;
                    imageAfter.setRGB(x, y, newRGB);
                }
            }
        }
    }

    public void applyFilterToNegative() {
        this.imageAfter = copyImage(this.image);;
        for (int x = 0; x < imageAfter.getWidth() ; x++) {
            if(withinBoundsPerPixel(x)) {
                for (int y = 0; y < imageAfter.getHeight(); y++) {
                    int colorCode = imageAfter.getRGB(x, y);
                    Color color = new Color(colorCode);
                    Color newColor = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
                    imageAfter.setRGB(x, y, newColor.getRGB());
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        this.stick.setX(x);
        if(this.currentFilter!=null){
            this.imageAfter = copyImage(this.image);
            repaint();
            switchCaseFilterAplly();
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}