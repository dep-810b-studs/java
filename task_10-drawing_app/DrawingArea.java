package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawingArea extends JPanel
{
    private static final int DA_WIDTH = 700;
    private static final int DA_HEIGHT = 500;
    private static final Color DA_BGCOLOR = Color.WHITE;
    private static final long serialVersionUID = 1L;


    ArrayList<Point> points = new ArrayList<>();

    private Color currentColor;
    BufferedImage bImage = new BufferedImage(DA_WIDTH, DA_HEIGHT, BufferedImage.TYPE_INT_RGB);


    public DrawingArea()
    {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Graphics g2d = bImage.getGraphics();

        g2d.setColor(DA_BGCOLOR);

        g2d.fillRect(0,0,DA_WIDTH,DA_HEIGHT);

        g2d.dispose();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                points.clear();
                points.add(e.getPoint());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                points.add(e.getPoint());
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                points.add(e.getPoint());
                points.clear();
                repaint();
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return  new Dimension(DA_WIDTH,DA_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawIntoBufferedImage();
        g.drawImage(bImage,0,0,null);
        freehandLines(g);
    }

    public void drawIntoBufferedImage()
    {
        Graphics g = bImage.getGraphics();
        freehandLines(g);
        g.dispose();
    }

    public void freehandLines(Graphics g)
    {
        if(points != null && points.size()>1)
        {
            g.setColor(getCurrentColor());
            for(int i =0; i < points.size()-1;++i)
            {
                Graphics2D  g2d = (Graphics2D) g;
                ((Graphics2D)g).setStroke(new BasicStroke(widthPen));
                ((Graphics2D)g).draw(new Line2D.Float(points.get(i).x,points.get(i).y,points.get(i+1).x,points.get(i+1).y));
            }
        }
    }

    public void clearDrawings()
    {
        if(points!=null)
        {
            points.clear();
            Graphics g = bImage.getGraphics();
            g.setColor(DA_BGCOLOR);
            g.fillRect(0, 0, DA_WIDTH, DA_WIDTH);
            g.dispose();
            repaint();
        }
    }

    public void setCurrentColor(Color currentColor)
    {
        if(currentColor == null)
            currentColor = Color.BLACK;
        else
            this.currentColor = currentColor;
    }

    public Color getCurrentColor()
    {
        if (currentColor == null)
            return Color.BLACK;
        else
            return currentColor;
    }

    public  void setWidth(int width)
    {
        if(!(width <=0 || width>=40)) widthPen=width;
        else
        {
            JOptionPane.showMessageDialog(this,"Ошибка, введите допустимое значение");
        }
    }

    public int getWidthPen() {
        return widthPen;
    }

    private int widthPen = 20;
}
