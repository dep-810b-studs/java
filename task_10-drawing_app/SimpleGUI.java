package com.company;

import java.awt.*;
import javax.swing.*;

public class SimpleGUI extends JFrame
{
     DrawingArea area = new DrawingArea();

     public SimpleGUI()
     {
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         setTitle("Simple paint v.2.0 ©");
         setResizable(false);
         setVisible(true);

         JPanel buttonContainer = new JPanel();
         JButton btnClear = new JButton("Clear");
         JButton btnChangeWidth = new JButton("Change Width of pen");
         JButton btnAbout = new JButton("About");
         JButton btnColorChoose = new JButton("Choose color");

         buttonContainer.add(btnClear);
         buttonContainer.add(btnColorChoose);
         buttonContainer.add(btnChangeWidth);
         buttonContainer.add(btnAbout);

         btnAbout.addActionListener(e->
         {
             JOptionPane.showMessageDialog(area, "Simple paint v.2.0 ©\nАвтор: Щербаков ВС","About",0 ,new ImageIcon());
         });

         btnChangeWidth.addActionListener(e->
         {
             int width = area.getWidthPen();
             try
             {
                 String text =JOptionPane.showInputDialog(area,"Please enter a width of pen([1-39]):",width);

                 if (text.equals("пидр"))
                     JOptionPane.showMessageDialog(this,"сам пидр");

                 width = new Integer(JOptionPane.showInputDialog(area,"Please enter a width of pen([1-39]):",width));
             }
             catch (NumberFormatException ex)
             {

             }
            area.setWidth(width);
         });

         btnColorChoose.addActionListener( e->
         {
             JColorChooser jcc = new JColorChooser();
             Color c = jcc.showDialog(null,"Please select a color", Color.BLACK);
             area.setCurrentColor(c);
         });

         btnClear.addActionListener(e -> area.clearDrawings());

         getContentPane().add(area);
         getContentPane().add(buttonContainer, BorderLayout.PAGE_END);

         pack();

     }
}





