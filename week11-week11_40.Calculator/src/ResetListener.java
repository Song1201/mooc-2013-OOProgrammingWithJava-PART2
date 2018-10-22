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
public class ResetListener implements ActionListener{
  private JTextField output;
  private JTextField input;
  private JButton bigZ;

  public ResetListener(JTextField output, JTextField input, JButton bigZ) {
    this.output = output;
    this.input = input;
    this.bigZ = bigZ;
  }
 
  @Override
  public void actionPerformed(ActionEvent e) {
    output.setText("0");
    input.setText("");
    bigZ.setEnabled(false);
  }
  
}
