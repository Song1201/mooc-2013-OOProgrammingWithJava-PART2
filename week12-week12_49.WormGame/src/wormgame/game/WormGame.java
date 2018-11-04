package wormgame.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.gui.Updatable;
import wormgame.domain.*;

public class WormGame extends Timer implements ActionListener {

  private int width;
  private int height;
  private boolean continues;
  private Updatable updatable;
  private Worm worm;
  private Apple apple;
  private Random randomizer;

  public WormGame(int width, int height) {
    super(1000, null);

    this.width = width;
    this.height = height;
    this.continues = true;

    addActionListener(this);
    setInitialDelay(2000);
    
    worm = new Worm(width/2,height/2,Direction.DOWN);
    randomizer = new Random();
    createApple();
}
  
  private void createApple() {
    apple = new Apple(randomizer.nextInt(width),randomizer.nextInt(height));
    while(worm.runsInto(apple))
      apple = new Apple(randomizer.nextInt(width),randomizer.nextInt(height));
  }

  public boolean continues() {
    return continues;
  }

  public void setUpdatable(Updatable updatable) {
    this.updatable = updatable;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (!continues) {
      return;
    }
    
    worm.move();
    if(worm.runsInto(apple)) {
      worm.grow();
      createApple();
    }
    if(worm.runsIntoItself()) continues = false;
    if(worm.hitBorder(width, height)) continues = false;
    updatable.update();
    setDelay(1000/worm.getLength());

  }

  public Worm getWorm() {
    return worm;
  }

  public void setWorm(Worm worm) {
    this.worm = worm;
  }

  public Apple getApple() {
    return apple;
  }

  public void setApple(Apple apple) {
    this.apple = apple;
  }

  

}
