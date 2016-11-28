package com.Package.GUIEx;

import java.awt.*;
public class Draw1 extends Frame{
  public Draw1(String title){                    // 생성자
    super(title);
  }
  public void paint(Graphics g){
    g.drawLine(10,30,50,50);					// drawLine :  좌표 (x1, y1)에서 (x2, y2)까지 직선을 긋는다.
    g.drawRect(60,30,50,50);					// drawRect : 좌표 (x, y)로부터 너비가 width이고 높이가 height인 사각형을 그린다.
    g.drawRoundRect(120,30,50,50,20,20);		// drawRoundRect : (x, y)로부터 너비가 width이고 높이가 height인 모서리가 둥근 사각형을 그린다. arcWidth 와 arcHeight는 모서리의 크기를 정한다.
    g.drawOval(10,100,70,50);					// 타원을 그린다.
    g.drawArc(100,100,50,50,90,180);			// 원호를 그린다.
    int[] x=new int[]{200,240,200,220,240};
    int[] y=new int[]{80,80,120,60,120};
    g.drawPolygon(x,y,5);						// 다각형을 그린다.
  }
  public static void main(String[] args){
    Frame f=new Draw1("도형 그리기");
    f.setSize(300,200);
    f.setVisible(true);
  }
}