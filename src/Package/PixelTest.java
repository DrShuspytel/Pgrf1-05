package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PixelTest {

    private JFrame window;
    //objekt pro zápis pixelů
    private BufferedImage img;
    //obbjekt pro vykreslení BufferedImage
    private JPanel panel;



    public PixelTest() {

        window = new JFrame();

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setTitle("PGRF1 CVI");

        //vytvoreni img, nastavení rozměrů

        img = new BufferedImage(800,600, BufferedImage.TYPE_INT_RGB);
        //inicializace panelu, do ktereho budeme kreslit img
        panel = new JPanel() {
            public void paint(Graphics g){
                super.paintComponents(g);
                //pri preklesleni panelu zajisti vykresleni img
                g.drawImage(img, 0,0,null);
            }
        };
        //pridat panel do okna
        window.add(panel);
        window.setVisible(true);

        drawPixel(100,50, Color.GREEN.getRGB());

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                drawPixel(e.getX(), e.getY(), 0xffff00);
            }
        });
    }

    private void drawPixel(int x, int y, int color) {
        img.setRGB(x,y, color);
        panel.getGraphics().drawImage(img, 0, 0, null);

    }


    public static void main(String[] args){
            new PixelTest();

        }
    }