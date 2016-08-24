// Grzegorz Koñczak, 24.08.2016
// Exercise number 18.19 page 849
// Exercise from Java:How to program 10th edition

package chapter18;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JColorChooser;

public class Fractal extends JFrame
{
   private static final int WIDTH = 400;  // define width of GUI
   private static final int HEIGHT = 480; // define height of GUI
   private static final int MIN_LEVEL = 0;
   private static final int MAX_LEVEL = 15;

   // set up GUI
   public Fractal()
   {
      super("Fractal");

      // set up levelJLabel to add to controlJPanel
      final JLabel levelJLabel = new JLabel("Level: 0");

      final FractalJPanel drawSpace = new FractalJPanel(0);

      // set up control panel
      final JPanel controlJPanel = new JPanel();
      controlJPanel.setLayout(new FlowLayout());

      // set up decrease level button to add to control panel and 
      // register listener
      final JButton decreaseLevelJButton = new JButton("Decrease Level");
      controlJPanel.add(decreaseLevelJButton);
      decreaseLevelJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {
            // process decreaseLevelJButton event
            @Override
            public void actionPerformed(ActionEvent event)
            {
               int level = drawSpace.getLevel();
               --level; 

               // modify level if possible
               if ((level >= MIN_LEVEL) &&
                  (level <= MAX_LEVEL))
               {
                  levelJLabel.setText("Level: " + level);
                  drawSpace.setLevel(level);
                  repaint(); 
               } 
            } 
         } // end anonymous inner class
      ); // end addActionListener

      // set up increase level button to add to control panel
      // and register listener
      final JButton increaseLevelJButton = new JButton("Increase Level");
      controlJPanel.add(increaseLevelJButton);
      increaseLevelJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {
            // process increaseLevelJButton event
            @Override
            public void actionPerformed(ActionEvent event)
            {
               int level = drawSpace.getLevel();
               ++level;

               // modify level if possible
               if ((level >= MIN_LEVEL) &&
                  (level <= MAX_LEVEL))
               {
                  levelJLabel.setText("Level: " + level);
                  drawSpace.setLevel(level);
                  repaint();
               }
            } 
         } // end anonymous inner class
      ); // end addActionListener
 
      controlJPanel.add(levelJLabel);

      // create mainJPanel to contain controlJPanel and drawSpace
      final JPanel mainJPanel = new JPanel();
      mainJPanel.add(controlJPanel);
      mainJPanel.add(drawSpace);

      add(mainJPanel); // add JPanel to JFrame

      setSize(WIDTH, HEIGHT); // set size of JFrame
      setVisible(true); // display JFrame
   } // end constructor Fractal

   public static void main(String[] args)
   {
      Fractal demo = new Fractal();
      demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
} // end class Fractal
