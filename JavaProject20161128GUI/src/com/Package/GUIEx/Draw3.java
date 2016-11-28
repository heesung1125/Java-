package com.Package.GUIEx;

import java.awt.*;
import java.awt.event.*;
public class Draw3 extends Frame{
  Graphics g;                     // 프레임의 Graphics 객체를 위한 변수
  int x, y, ox, oy;         // 움직인 후의 좌표(x, y)와 움직이기 전의 좌표(ox, oy)
  public Draw3(String title){      // 생성자
    super(title);
    setSize(200,200);
    setVisible(true);
    g=this.getGraphics();       // 프레임의 Graphics 객체를 얻는다.
    g.setColor(Color.red);        // 그리기 색을 빨간 색으로 정한다.
 
    // 마우스 움직임 이벤트 처리
    addMouseMotionListener(new MouseMotionAdapter(){
        public void mouseDragged(MouseEvent e){        // 마우스가 움직이면
          x=e.getX(); y=e.getY();              // 마우스의 현재 위치를 알아온다.
 
          // 전 위치부터 현재 위치까지 직선을 긋는다.
          g.drawLine(ox, oy, x, y);
        
          ox=x; oy=y;                  // x와 y를 ox와 oy에 대입한다.
        }
    });
 
    // 마우스 이벤트 처리
    addMouseListener(new MouseAdapter(){
        // 마우스를 누르면 호출된다.
        public void mousePressed(MouseEvent e){
           ox=e.getX(); oy=e.getY();             // 마우스의 위치를 기억한다.
        }
    });
  }
  public static void main(String[] args){
    Frame f=new Draw3("도형 그리기");
  }
}