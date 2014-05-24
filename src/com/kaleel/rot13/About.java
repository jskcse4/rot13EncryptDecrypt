package com.kaleel.rot13;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JDialog
  implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private Font font;
  private Font bfont;

  public About(JFrame display)
  {
    setTitle("About Us");
    buildFrame();
    pack();
    setLocation(200, 200);
    setSize(260, 200);
  }

  private void buildFrame()
  {
    this.font = new Font("Ariel", 0, 12);
    this.bfont = new Font("Ariel", 1, 12);
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = 1;
    c.insets = new Insets(0, 0, 2, 0);

    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    c.gridheight = 1;
    c.weighty = 1.0D;
    c.weightx = 0.0D;
    JPanel panel = new JPanel();
    Dimension d = new Dimension(300, 100);
    panel.setPreferredSize(d);
    panel.setMinimumSize(d);
    panel.setMaximumSize(d);

    c.insets = new Insets(0, 2, 0, 2);
    c.gridy = 1;
    JLabel copyright = new JLabel("Orgnisation:  MEC-CSE");
    copyright.setFont(this.bfont);
    add(copyright, c);

    c.gridy = 2;
    JLabel author = new JLabel("Authors:");
    author.setFont(this.bfont);
    add(author, c);

    c.gridy = 3;
    JLabel email = new JLabel("SyedKhaleel :       ");
    email.setFont(this.bfont);
    add(email, c);

    c.gridy = 3;
    JLabel email1 = new JLabel("                           jskcse4@gmail.com");
    email1.setFont(this.font);
    add(email1, c);

    c.gridy = 4;
    JLabel mypanel = new JLabel();
    mypanel.setLayout(new BoxLayout(mypanel, 1));
    add(mypanel, c);

    c.gridy = 5;
    JLabel fb = new JLabel("Add me in Facebook");
    fb.setForeground(Color.BLUE);

    fb.setFont(this.bfont);
    fb.setCursor(Cursor.getPredefinedCursor(12));
    fb.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if ((e.getClickCount() > 0) && 
          (Desktop.isDesktopSupported())) {
          Desktop desktop = Desktop.getDesktop();
          try {
            URI uri = new URI("https://www.facebook.com/syed.khaleel1");
            desktop.browse(uri);
          } catch (IOException ex) {
            ex.printStackTrace();
          } catch (URISyntaxException ex) {
            ex.printStackTrace();
          }
        }
      }
    });
    add(fb, c);

    c.gridy = 6;
    JLabel system = new JLabel("\nSystem Information");
    system.setFont(this.bfont);
    add(system, c);

    c.gridy = 7;
    JLabel version = new JLabel("Java Version : " + System.getProperty("java.version"));
    version.setFont(this.bfont);
    add(version, c);

    c.gridy = 8;
    JLabel os = new JLabel("OS : " + System.getProperty("os.name"));
    os.setFont(this.bfont);
    add(os, c);

    c.gridy = 9;
    JButton exit = new JButton("Close");
    exit.addActionListener(this);
    exit.setFont(this.font);
    add(exit, c);
    setVisible(true);
    setResizable(false);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().compareTo("Close") == 0)
      dispose();
  }
}