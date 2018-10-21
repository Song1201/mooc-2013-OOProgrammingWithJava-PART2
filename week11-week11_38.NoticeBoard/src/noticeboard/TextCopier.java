/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author lison
 */
public class TextCopier implements ActionListener{
  private JTextField from;
  private JLabel to;

  public TextCopier(JTextField from, JLabel to) {
    this.from = from;
    this.to = to;
  }
  
  
  
  @Override
  public void actionPerformed(ActionEvent e) {
    to.setText(from.getText());
    from.setText("");
  }
  
  
}
