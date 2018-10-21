package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
      frame = new JFrame("OKC is NBA Champion!!!");
      frame.setPreferredSize(new Dimension(400, 400));
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      Container container = frame.getContentPane();
      GridLayout gridLayout = new GridLayout(3, 1);
      container.setLayout(gridLayout);
      
      JTextField from = new JTextField();
      JButton copyButton =  new JButton("Copy!");
      JLabel to = new JLabel();
      TextCopier copier = new TextCopier(from, to);
      copyButton.addActionListener(copier);
      
      container.add(from);
      container.add(copyButton);
      container.add(to);
      
      frame.pack();
      frame.setVisible(true);
    }
}
