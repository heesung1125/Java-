package com.Package.GUIEx;

import java.awt.*;
import java.awt.event.*;
public class Draw3 extends Frame{
  Graphics g;                     // �������� Graphics ��ü�� ���� ����
  int x, y, ox, oy;         // ������ ���� ��ǥ(x, y)�� �����̱� ���� ��ǥ(ox, oy)
  public Draw3(String title){      // ������
    super(title);
    setSize(200,200);
    setVisible(true);
    g=this.getGraphics();       // �������� Graphics ��ü�� ��´�.
    g.setColor(Color.red);        // �׸��� ���� ���� ������ ���Ѵ�.
 
    // ���콺 ������ �̺�Ʈ ó��
    addMouseMotionListener(new MouseMotionAdapter(){
        public void mouseDragged(MouseEvent e){        // ���콺�� �����̸�
          x=e.getX(); y=e.getY();              // ���콺�� ���� ��ġ�� �˾ƿ´�.
 
          // �� ��ġ���� ���� ��ġ���� ������ �ߴ´�.
          g.drawLine(ox, oy, x, y);
        
          ox=x; oy=y;                  // x�� y�� ox�� oy�� �����Ѵ�.
        }
    });
 
    // ���콺 �̺�Ʈ ó��
    addMouseListener(new MouseAdapter(){
        // ���콺�� ������ ȣ��ȴ�.
        public void mousePressed(MouseEvent e){
           ox=e.getX(); oy=e.getY();             // ���콺�� ��ġ�� ����Ѵ�.
        }
    });
  }
  public static void main(String[] args){
    Frame f=new Draw3("���� �׸���");
  }
}