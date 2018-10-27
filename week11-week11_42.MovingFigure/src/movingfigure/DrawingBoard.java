package movingfigure;


import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lison
 */
public class DrawingBoard extends JPanel{
  private Figure figure;

  public DrawingBoard(Figure figure) {
    this.figure = figure;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); 
    figure.draw(g);
  }
  
  
}
