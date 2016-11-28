package com.Package.GUIEx;

import java.awt.*;
public class Draw1 extends Frame{
  public Draw1(String title){                    // ������
    super(title);
  }
  public void paint(Graphics g){
    g.drawLine(10,30,50,50);					// drawLine :  ��ǥ (x1, y1)���� (x2, y2)���� ������ �ߴ´�.
    g.drawRect(60,30,50,50);					// drawRect : ��ǥ (x, y)�κ��� �ʺ� width�̰� ���̰� height�� �簢���� �׸���.
    g.drawRoundRect(120,30,50,50,20,20);		// drawRoundRect : (x, y)�κ��� �ʺ� width�̰� ���̰� height�� �𼭸��� �ձ� �簢���� �׸���. arcWidth �� arcHeight�� �𼭸��� ũ�⸦ ���Ѵ�.
    g.drawOval(10,100,70,50);					// Ÿ���� �׸���.
    g.drawArc(100,100,50,50,90,180);			// ��ȣ�� �׸���.
    int[] x=new int[]{200,240,200,220,240};
    int[] y=new int[]{80,80,120,60,120};
    g.drawPolygon(x,y,5);						// �ٰ����� �׸���.
  }
  public static void main(String[] args){
    Frame f=new Draw1("���� �׸���");
    f.setSize(300,200);
    f.setVisible(true);
  }
}