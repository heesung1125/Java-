package com.Package.GUIEx;

import java.awt.*;

public class Paint1 extends Frame {
	public Paint1(String title) { // 생성자
		super(title);
	}

	public void paint(Graphics g) { // Graphics 클래스-그림그리기 전에 무조건 생성해야 된다.
		g.drawLine(10, 30, 50, 50); // drawLine : 선을 그리는 메소드. 시작점x,시작점y,끝점x,끝점y
		g.drawRect(60, 30, 50, 50); // drawRect : 사각형을 그리는 메소드.
		g.drawString("Hello!", 120, 50); // drawString : GUI창에 문자열을 그린다. "그릴 문자열", 좌표x,좌표y
	}

	public static void main(String[] args) {
		Paint1 f = new Paint1("paint");
		f.setSize(200, 100); // setSize : 창 크기 설정
		f.setVisible(true); // setVisible : 위에서 생성한 창을 출력 할지 않 할지 설정
	}
}