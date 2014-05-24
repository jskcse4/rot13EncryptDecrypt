package com.kaleel.rot13;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainDisplayFrame extends JFrame
{
  private static final long serialVersionUID = 1L;
  protected JTextArea textArea1;
  protected JTextArea textArea2;
  private JButton AboutButton;
  private JButton CloseButton;
  private JButton EncDecButton;
  private JButton ResetButton;
  private JButton CopyButton;
  private JLabel Label1;
  private JLabel Label2;
  private JFrame display;

  public MainDisplayFrame()
  {
    setTitle("ROT13 Encryption & Decryption by JSK");
    Box box = Box.createVerticalBox();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel = new JPanel();
    this.Label1 = new JLabel("Enter your Text in below TextArea ");
    panel1.add(this.Label1);
    box.add(panel1);
    this.textArea1 = new JTextArea(7, 5);
    box.add(new JScrollPane(this.textArea1));
    this.Label2 = new JLabel("Your Encrypted / Decrypted text is ");
    panel2.add(this.Label2);
    box.add(panel2);
    this.textArea2 = new JTextArea(7, 5);
    box.add(new JScrollPane(this.textArea2));
    this.AboutButton = new JButton("About");
    this.CloseButton = new JButton("Close");
    this.EncDecButton = new JButton("Encrypt/Decrypt");
    this.ResetButton = new JButton("Reset");
    this.CopyButton = new JButton("Copy to ClipBoard");
    panel.add(this.EncDecButton);
    panel.add(this.CopyButton);
    panel.add(this.ResetButton);
    panel.add(this.AboutButton);
    panel.add(this.CloseButton);
    box.add(panel);
    add(box);
    pack();

    this.CopyButton.addActionListener(
      new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        Clipboard clipboard = MainDisplayFrame.this.getToolkit().getSystemClipboard();
        StringSelection data = new StringSelection(MainDisplayFrame.this.textArea2.getText());
        clipboard.setContents(data, data);
      }
    });
    this.AboutButton.addActionListener(
      new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        new About(MainDisplayFrame.this.display);
      }
    });
    this.ResetButton.addActionListener(
      new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        MainDisplayFrame.this.textArea1.setText(null);
        MainDisplayFrame.this.textArea2.setText(null);
      }
    });
    this.EncDecButton.addActionListener(
      new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        String msg = MainDisplayFrame.this.textArea1.getText();

        MainDisplayFrame.this.textArea2.setText(convert(msg));
      }

      private String convert(String msg)
      {
        StringBuilder retVal = new StringBuilder();
        for (char a : msg.toCharArray()) {
          if ((a >= 'A') && (a <= 'Z')) {
            a = (char)(a + '\r');
            if (a > 'Z')
              a = (char)(a - '\032');
          }
          else if ((a >= 'a') && (a <= 'z')) {
            a = (char)(a + '\r');
            if (a > 'z') {
              a = (char)(a - '\032');
            }
          }
          retVal.append(a);
        }
        return retVal.toString();
      }
    });
    this.CloseButton.addActionListener(
      new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        JOptionPane.showMessageDialog(MainDisplayFrame.this.rootPane, "Thanks to Use my Application.");
        System.exit(0);
      }
    });
  }
}