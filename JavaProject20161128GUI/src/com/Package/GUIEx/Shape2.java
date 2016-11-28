package com.Package.GUIEx;

import java.awt.*;
import java.awt.geom.*;
public class Shape2 extends Frame{
  public Shape2(String title){
    super(title);
  }
  public void paint(Graphics g){
    Graphics2D g2=(Graphics2D)g;
    GeneralPath gp=new GeneralPath();  // GeneralPath ��ü�� �����.
    gp.moveTo(150,50);                  // (150, 50)���� ������ ���� �ű��.
    gp.lineTo(150,250);                   // (150, 250)���� ������ �ߴ´�.
    gp.lineTo(250,150);                   // (250, 150)���� ������ �ߴ´�.
    gp.lineTo(50,150);                    // (50, 150)���� ������ �ߴ´�.
    gp.closePath();                 // ó�� ���� ������ �����Ͽ� ��θ� �ݴ´�.
    
    g2.draw(gp);                           // GeneralPath ��ü�� �׸���.
  }
  public static void main(String[] args){
    Frame f=new Shape2("GeneralPath");
    f.setSize(300,300);
    f.setVisible(true);
  }
}
