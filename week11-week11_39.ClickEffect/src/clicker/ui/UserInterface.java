package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserInterface implements Runnable {

  private JFrame frame;
  private Calculator calculator;

  public UserInterface(Calculator calculator) {
    this.calculator = calculator;
  }
  
  public void run() {
    frame = new JFrame("Click Effect");
    frame.setPreferredSize(new Dimension(200, 100));
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    createComponents(frame.getContentPane());

    frame.pack();
    frame.setVisible(true);
  }

  private void createComponents(Container container) {
    JLabel showNumber = new JLabel("0");
    JButton click = new JButton("Click!");
    ActionListener clickToIncrease = new ClickListener(calculator, showNumber);
    click.addActionListener(clickToIncrease);
    container.setLayout(new BorderLayout());
    container.add(showNumber,BorderLayout.WEST);
    container.add(click,BorderLayout.SOUTH);
  }

  public JFrame getFrame() {
    return frame;
  }
}
