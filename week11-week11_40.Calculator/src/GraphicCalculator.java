
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
      frame = new JFrame("Calculator");
      frame.setPreferredSize(new Dimension(600, 300));
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      createComponents(frame.getContentPane());
      
      frame.pack();
      frame.setVisible(true);
    }

    private void createComponents(Container container) {
      JTextField top = new JTextField("0");
      top.setEnabled(false);
      JTextField middle = new JTextField("0");
      JPanel menu = new JPanel(new GridLayout(1, 3));
      JButton plus = new JButton("+");
      JButton minus = new JButton("-");
      
      JButton bigZ = new JButton("Z");
      ActionListener zListener = new ResetListener(top, middle, bigZ);
      bigZ.addActionListener(zListener);
      bigZ.setEnabled(false);
      
      ActionListener plusListener = new PlusListener(top, middle, bigZ);
      plus.addActionListener(plusListener);

      ActionListener minusListener = new MinusListener(top, middle, bigZ);
      minus.addActionListener(minusListener);
      
      menu.add(plus);
      menu.add(minus);
      menu.add(bigZ);
      container.setLayout(new GridLayout(3, 1));
      container.add(top);
      container.add(middle);
      container.add(menu);
      
    }

    public JFrame getFrame() {
        return frame;
    }
}
