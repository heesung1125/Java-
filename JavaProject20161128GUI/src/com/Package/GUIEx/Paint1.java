package com.Package.GUIEx;

import java.awt.*;

public class Paint1 extends Frame {
	public Paint1(String title) { // ������
		super(title);
	}

	public void paint(Graphics g) { // Graphics Ŭ����-�׸��׸��� ���� ������ �����ؾ� �ȴ�.
		g.drawLine(10, 30, 50, 50); // drawLine : ���� �׸��� �޼ҵ�. ������x,������y,����x,����y
		g.drawRect(60, 30, 50, 50); // drawRect : �簢���� �׸��� �޼ҵ�.
		g.drawString("Hello!", 120, 50); // drawString : GUIâ�� ���ڿ��� �׸���. "�׸� ���ڿ�", ��ǥx,��ǥy
	}

	public static void main(String[] args) {
		Paint1 f = new Paint1("paint");
		f.setSize(200, 100); // setSize : â ũ�� ����
		f.setVisible(true); // setVisible : ������ ������ â�� ��� ���� �� ���� ����
	}
}