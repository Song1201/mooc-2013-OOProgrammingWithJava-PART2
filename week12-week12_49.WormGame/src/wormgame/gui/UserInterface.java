package wormgame.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import wormgame.game.WormGame;

public class UserInterface implements Runnable {

  private JFrame frame;
  private WormGame game;
  private int sideLength;
  private DrawingBoard drawingBoard;

  public UserInterface(WormGame game, int sideLength) {
    this.game = game;
    this.sideLength = sideLength;
  }

  @Override
  public void run() {
    frame = new JFrame("Worm Game");
    int width = (game.getWidth() + 1) * sideLength + 10;
    int height = (game.getHeight() + 2) * sideLength + 10;

    frame.setPreferredSize(new Dimension(width, height));

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    createComponents(frame.getContentPane());

    frame.pack();
    frame.setVisible(true);
  }

  public void createComponents(Container container) {
    // Create drawing board first which then is added into container-object.
    // After this, create keyboard listener which is added into frame-object
    DrawingBoard drawingBoard = new DrawingBoard(game, sideLength);
    container.add(drawingBoard);
    this.drawingBoard = drawingBoard;
    KeyboardListener keyboardListener = new KeyboardListener(game.getWorm());
    frame.addKeyListener(keyboardListener);
    
  }
  
  public Updatable getUpdatable() {
    // Do not think this is the best way to do it. But this can pass the test.
    // The drawing board can be obtained from the frame.
    if(drawingBoard==null) return null;
    return drawingBoard;
  }

  public JFrame getFrame() {
    return frame;
  }
}
