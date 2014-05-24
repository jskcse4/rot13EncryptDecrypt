package com.kaleel.rot13;

import java.awt.EventQueue;

public class MainDisplay
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        MainDisplayFrame MDframe = new MainDisplayFrame();
        MDframe.setDefaultCloseOperation(3);
        MDframe.setSize(500, 360);
        MDframe.setVisible(true);
        MDframe.setResizable(false);
      }
    });
  }
}