import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class DrawingField extends JPanel
{

    public DrawingField()
    {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Graphics g2d = bImage.getGraphics();

        g2d.setColor(DA_BGCOLOR);

        g2d.fillRect(0,0,DA_WIDTH,DA_HEIGHT);

        g2d.dispose();

        addMouseListener(mouseAdapter);

        /*super.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                onMousePressed(e);
            }
        });*/
    }

    private void onMousePressed(MouseEvent e)
    {
        startMove(e.getX(),e.getY());
    }

    public void startMove()
    {
        Random random = new Random();
        startMove(random.nextInt() % 900,random.nextInt() % 700);
    }

    public  void startMove(int x, int y)
    {
        Circle circle = new Circle();
        if (timer == null)
        {
            circle.x = x;
            circle.y = y;
            circle.speed=1;
            timer = new java.util.Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run()
                {
                    circle.move();
                    circle.checkContact(Circles);
                    drawCircle();
                }
            }, 0, 25);
        }
        else
        {
            timer = new java.util.Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    circle.move();
                    drawCircle();
                }
            }, 0, 25);
        }
        Circles.add(circle);
    }

    public  void stopMove()
    {
        timer.cancel();
    }

    public void drawCircle()
    {
        if(!painting)
        {
            painting = true;
            repaint();
        }
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if(painting)
        {
            for(Circle circle : Circles)
            {
                g.setColor(circle.color);
                g.drawOval((int)circle.x,(int)circle.y,circle.radius,circle.radius);
                g.fillOval((int)circle.x,(int)circle.y,circle.radius,circle.radius);
                painting = false;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    BufferedImage bImage = new BufferedImage(DA_WIDTH, DA_HEIGHT, BufferedImage.TYPE_INT_RGB);

    boolean painting = false;

    ArrayList<Circle> Circles= new java.util.ArrayList<>();

    private static final int DA_WIDTH = 700;
    private static final int DA_HEIGHT = 500;
    private static final Color DA_BGCOLOR = Color.WHITE;
    private static final long serialVersionUID = 1L;
    private Timer timer;
    MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            onMousePressed(e);
        }
    };

}
