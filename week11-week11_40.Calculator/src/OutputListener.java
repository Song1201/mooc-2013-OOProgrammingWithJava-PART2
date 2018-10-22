/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JTextField;
/**
 *
 * @author lison
 */
public class OutputListener implements ActionListener{
  private JTextField output;
  private JButton bigZ;

  public OutputListener(JTextField output, JButton bigZ) {
    this.output = output;
    this.bigZ = bigZ;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(output.getText().equals("0")) {
      System.out.println("HAHA");
      bigZ.setEnabled(false);
    }
    else bigZ.setEnabled(true);
  }
  
}
