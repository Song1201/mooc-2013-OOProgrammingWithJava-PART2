/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author lison
 */
public class MinusListener implements ActionListener{
  private JTextField output;
  private JTextField input;
  private JButton bigZ;

  public MinusListener(JTextField output, JTextField input, JButton bigZ) {
    this.output = output;
    this.input = input;
    this.bigZ = bigZ;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      output.setText(""+(Integer.parseInt(output.getText())-
            Integer.parseInt(input.getText())));
    } catch(Exception exception) {
      input.setText("");
    }
    input.setText("");
    if(output.getText().equals("0")) bigZ.setEnabled(false);
    else bigZ.setEnabled(true);
  }
}
