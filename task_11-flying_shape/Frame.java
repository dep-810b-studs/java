import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame
{
    public Frame(String name)
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(name);
        setSize(1000,860);
        setResizable(false);

        JPanel buttonContainer = new JPanel();
        JButton btnStartMove = new JButton("Start moving");
        JButton btnChangeColorCircle = new JButton("Change color circle");
        JButton btnChangeSpeedCircle = new JButton("Change speed circle");
        JButton btnChangeSizeCircle = new JButton("Change size circle");
        JButton btnAbout = new JButton("About");


        buttonContainer.add(btnStartMove);
        buttonContainer.add(btnChangeColorCircle );
        buttonContainer.add(btnChangeSpeedCircle);
        buttonContainer.add(btnChangeSizeCircle);
        buttonContainer.add(btnAbout);

        getContentPane().add(drawingField);
        getContentPane().add(buttonContainer, BorderLayout.PAGE_END);

        btnChangeColorCircle .addActionListener(e->
        {
            drawingField.Circles.get(0).color = JColorChooser.showDialog(this,"Please select a color", Color.BLACK);
            drawingField.painting = true;
            drawingField.repaint();
        });

        btnStartMove.addActionListener(e->
        {
            if(checked)
            {
                drawingField.startMove();
                checked = false;
                btnStartMove.setText("Stop");
            }
            else
            {
                drawingField.stopMove();
                btnStartMove.setText("Start");
                checked = true;
            }
        });

        btnChangeSpeedCircle.addActionListener(e->
        {
            String str = JOptionPane.showInputDialog(this,"Please enter a speed of circle[1-9]:",1);
            int n = 1;
            try
            {
                n = new Integer(str);
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Please enter a correct number 1-9");
            }
            if(n<=0 || n>=10) JOptionPane.showMessageDialog(this, "Please enter a correct number 1-9");

            drawingField.Circles.get(0).speed=n;
        });

        btnChangeSizeCircle.addActionListener(e->
        {

            String str = JOptionPane.showInputDialog(this,"Please enter a size of circle([10-50]):",1);
            int n = 10;
            try
            {
                n = new Integer(str);
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Please enter a correct number 10-50");
            }
            if(n<10 || n >50)
            {
                n =drawingField.Circles.get(0).radius;
                JOptionPane.showMessageDialog(this, "Please enter a correct number 10-50");
            }

            drawingField.Circles.get(0).radius=n;
            drawingField.painting = true;
            drawingField.repaint();
        });

        btnAbout.addActionListener(e->
        {
            JOptionPane.showMessageDialog(this, "Летающая фигура v.2.0 ©\nАвтор: Щербаков ВС","About",0 ,new ImageIcon());
        });

    }

    public  void Show()
    {
        setVisible(true);
    }

    DrawingField drawingField = new DrawingField() ;
    boolean checked = true;
}
