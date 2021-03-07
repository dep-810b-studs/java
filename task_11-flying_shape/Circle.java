import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Circle extends Ellipse2D.Double
{
    public Circle()
    {
    }

    public  void move()
    {
        move(dx*speed ,dy*speed);

        if(!inFrame())
        {
            incSpeed();
            incRadius();
            Random random = new Random();
            color = new Color(random.nextInt());
            if(this.x  < 0 || this.x > 995 -  this.radius) {
                inverseX();
                if(this.x<0) this.x = 0;
                else if(this.x >995 - this.radius) this.x = 995 - this.radius;
            }
            if(this.y  < -5 || this.y > 795 - this.radius) {
                inverseY();
                if(this.y<0) this.y = 0;
                else if(this.y > 795 - this.radius) this.y = 795 - this.radius;
            }
        }
    }

    public void startMove()
    {

    }

    public  void checkContact(ArrayList<Circle> arr)
    {
        Circle temp = isContact(arr);
        if(temp!=null)
        {
            if(isContactX(temp)) inverseX();
            if(isContactY(temp)) inverseY();
        }
    }

    private Circle isContact(ArrayList<Circle> arr)
    {
        for (Circle circle : arr)
        {
            if(!circle.equals(this) && circle.isContact(this)) return circle;
        }
        return  null;
    }

    private boolean isContact(Circle circle)
    {
     return  (circle.x - this.x < Math.max(circle.radius,this.radius) && circle.y - this.y < Math.max(circle.radius,this.radius));
    }

    private boolean isContactX(Circle circle)
    {
        return circle.x - this.x < Math.max(circle.radius,this.radius);
    }
    private boolean isContactY(Circle circle)
    {
        return circle.y - this.y < Math.max(circle.radius,this.radius);
    }

    public void inverseX(){this.dx*=-1;}
    public void inverseY(){this.dy*=-1;}

    private void move(int x, int y)
    {
        this.x+=x;
        this.y+=y;
    }

    private boolean inFrame(){return (this.x > 0 && this.x <995 - this.radius && this.y> -5 && this.y <795 - this.radius );}

    public  void incRadius(){if (radius < 250) radius+=10;  else radius=10;}

    public  void incSpeed(){ if (speed < 70)  speed++; else  speed =1; }

    Color color = Color.BLACK;
    int radius = 20;
    int speed = 9;
    int dx = 1, dy =4;
}
