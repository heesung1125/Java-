package com.Package.GUIEx;

import java.awt.*;
import java.awt.geom.*;
public class Shape2 extends Frame{
  public Shape2(String title){
    super(title);
  }
  public void paint(Graphics g){
    Graphics2D g2=(Graphics2D)g;
    GeneralPath gp=new GeneralPath();  // GeneralPath 객체를 만든다.
    gp.moveTo(150,50);                  // (150, 50)으로 현재의 점을 옮긴다.
    gp.lineTo(150,250);                   // (150, 250)까지 직선을 긋는다.
    gp.lineTo(250,150);                   // (250, 150)까지 직선을 긋는다.
    gp.lineTo(50,150);                    // (50, 150)까지 직선을 긋는다.
    gp.closePath();                 // 처음 점과 끝점을 연결하여 경로를 닫는다.
    
    g2.draw(gp);                           // GeneralPath 객체를 그린다.
  }
  public static void main(String[] args){
    Frame f=new Shape2("GeneralPath");
    f.setSize(300,300);
    f.setVisible(true);
  }
}
