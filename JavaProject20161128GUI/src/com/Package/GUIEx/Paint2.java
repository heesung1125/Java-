package com.Package.GUIEx;

import java.awt.*;
public class Paint2{
  public static void main(String[] args){
    Frame f=new Frame("paint");		//Frame ��ü ����
    f.setSize(200,100);
    f.setVisible(true);				// �������� ���̰� �Ѵ�.
    Graphics g=f.getGraphics();		// �������� Graphics ��ü�� ���´�.
    g.drawLine(10,30,50,50);
    g.drawRect(60,30,50,50);
    g.drawString("Hello!",120,50);
  }
}