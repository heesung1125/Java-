package com.Package.GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.swing.*;

//Ŭ������ �޼ҵ带 ���� �ľ��ϸ鼭 �ش� �������� Ȯ�� �Ѵ�.
//JFrame : Swing API�� �ٽ� Ŭ����, Runnable : ��Ƽ������� �������̽�, KeyListener : Ű���� �Է� ó�� �������̽�
public class Shoot extends JFrame implements Runnable, KeyListener { 
	private BufferedImage bi = null;	//??
	private ArrayList msList = null;	// �̻��� ��ü ����Ʈ
	private ArrayList enList = null;	// enemy ��ü ����Ʈ
	private boolean left = false, right = false, up = false, down = false, fire = false;
	private boolean start = false, end = false;
	private int w = 300, h = 500, x = 130, y = 450, xw = 20, xh = 20;
	// w(â�� ��), h(â�� ����), x(�÷��̾� ��ǥ x��), y(�÷��̾� ��ǥ y��), xw(�÷��̾� ��), xh(�÷��̾� ����)

	public Shoot() { 					// Shoot Ŭ������ ������(�������� ������ �ʱ�ȭ�̴�.)
		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); // 8bit �÷��� �ȼ� �̹����� ������ ���۸� ����
		msList = new ArrayList();		// ArrayList ����, ���ó?
		enList = new ArrayList();		// ArrayList ����, �뵵 : �� �ʱ� ��ġ�� �� ������ �� �����
		this.addKeyListener(this);		// addKeyListener : Ű���� �Է� ���� �� �ֵ��� ���
		this.setSize(w, h);				// setSize : GUI âũ�� ���� ( 17��. â�� �� : w=300, â�� ���� : h=500 )
		this.setTitle("Shooting Game"); // setTitle : GUI Ÿ��Ʋ�� ����(html�� title�� ������ ���)
		this.setResizable(false);		// setResizable : GUI âũ�� ���� ���� ���� ����(True�� ���콺�� â ũ�� ���� ����)
		
		// setDefaultCloseOperation : �ݱ� ��ư(������� ������ X��ư) �������� ��� ���� ����. (JFrame.EXIT_ON_CLOSE : Ŭ���� GUI����)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true); 		// setVisible : GUI�� ��� ���� ���� (true:â���̱�,false:â �Ⱥ��̱�)
	}

	public void run() { // run() : ��Ƽ������ ���� �޼ҵ�(�ݵ�� �̸��� run ���� �ؾߵȴ�. ���� �޼ҵ�� ���?) 
		try {								// ����ó��
			int msCnt = 0;
			int enCnt = 0;
			while (true) {					// while (true) : ���� �ݺ�
				Thread.sleep(10);			// sleep : 0.01�� ���� �Ͻ� ���� (���⼭�� ���� ��ü �ӵ� �����뵵�� ���)

				if (start) {				// if (start) : start ������ true �̸� �Ʒ� ���� ����.
					if (enCnt > 2000) {		// if (enCnt > 2000) : 2000���� �۾����� �� ���� ����.
						enCreate();			// �� ���� �޼ҵ� ȣ��
						enCnt = 0;
					}
					if (msCnt >= 100) {		// �̻��� ����?
						fireMs();			// �̻��� �߻�?
						msCnt = 0;
					}
					msCnt += 10;			// (10)���� �����Ǹ� �̻��� �߻� �ӵ��� ������. 
					enCnt += 10;			// (10)���� �����Ǹ� ���� ������ ���� ������.
					keyControl();			// ȭ��ǥŰ�� �̻��� �߻��ư ����
					crashChk();				// �̻��ϰ� �� & ���� �÷��̾� �浹���� �˻�.
				}
				draw();						// ȭ�鿡 ��ü���� �׸���.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fireMs() {
		if (fire) {								// if (fire) : fire ������ true �̸� �Ʒ� ���� ����.
			if (msList.size() < 100) {			// if (msList.size() < 100) : msList ���� ������ 100���� ������...(�̻��� ���� ����)
				Ms m = new Ms(this.x, this.y);	// Ms��ü ����(�̻���? ���� ��ġ �ʱⰪ�� �÷��̾� x/y��ǥ)
				msList.add(m);					// Ms��ü�� ����Ʈ�� �߰�.
			}
		}
	}

	public void enCreate() {
		for (int i = 0; i < 9; i++) { // for (int i = 0; i < 9; i++) : 10�� �ݺ�for��, ���⼭�� ���� �ִ� ���� ������ (���� 9�� ����)
			
			// Math.random() : Random Ŭ���� ����, ������ ���� ���� ���ϱ�, rx =  ������(0~1���� �Ҽ���)*(â ���� 300 - �÷��̾� ���� 20)
			// �� ���� ������ġ ���ΰ� ���� ���� ������ ���η� �� ���´�.
			//(w + xw)�� �̻����� �÷��̾� ���� �������� ������ ������ ���� �������� �̻��Ϸ� ������� ��� ���� ������ �ʰ� �Ѵ�.?
			double rx = Math.random() * (w + xw);
			
			// ry = ������(0~1���� �Ҽ���) * 50px
			// �� ���� ��ġ ���۹��� ���̰� (50)���ڰ� Ŀ�� ���� ���� �տ��� ���� ������, �������� ������ ���� ���η� �� ���´�.
			double ry = Math.random() * 50; 
			
			Enemy en = new Enemy((int) rx, (int) ry); // Enemy��ü ����, x/y��ǥ ���� ������
			enList.add(en); // add(en) : enList�� enCreate�޼ҵ忡�� ������ ���� ����.
		}
	}

	public void crashChk() {	// �÷��̾� vs �� & �̻��� vs �� �浹üũ
		Graphics g = this.getGraphics();				// Graphics Ŭ���� ��ü ����
		Polygon p = null;								// Polygon Ŭ���� ��ü ����
		for (int i = 0; i < msList.size(); i++) {		// msList �迭 ������ŭ �ݺ�
			Ms m = (Ms) msList.get(i);					// msList i��° �迭�� �ҷ��ͼ� m������ ����.
			for (int j = 0; j < enList.size(); j++) {	// enList �迭 ������ŭ �ݺ�
				Enemy e = (Enemy) enList.get(j);		// enList j��° �迭�� �ҷ��ͼ� e������ ����.
				
				// m.x : �̻��� x��ǥ, m.w : �̻��� ����				
				int[] xpoints = { m.x, (m.x + m.w), (m.x + m.w), m.x }; // xpoints �迭������ �̻��� �浹�� ���� ����.(x��ǥ)

				// m.y : �̻��� y��ǥ, m.h : �̻��� ����				
				int[] ypoints = { m.y, m.y, (m.y + m.h), (m.y + m.h) }; // ypoints �迭������ �̻��� �浹�� ���� ����.(y��ǥ)
				p = new Polygon(xpoints, ypoints, 4); // ������ ���� ����Ʈ 4�� ���� �� .
				
				// intersects : Shape �� ���� ������, ������ ���� ������ ���� ������ �������� ����� ����.
				// if(p.intersects(...) : �̻��ϰ� ���� ��ġ��...
				if (p.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {
					msList.remove(i);	// msList���� �迭i�� ���� (�̻��� ����)
					enList.remove(j);	// enList���� �迭j�� ���� (�� ����)
				}
			}
		}
		for (int i = 0; i < enList.size(); i++) { 			// enList �迭 ������ŭ �ݺ�
			Enemy e = (Enemy) enList.get(i);				// enList i��° �迭�� �ҷ��ͼ� e������ ����.
			
			// x : �÷��̾� x��ǥ, xw : �÷��̾� ����
			int[] xpoints = { x, (x + xw), (x + xw), x };
			
			// y : �÷��̾� y��ǥ, xh : �÷��̾� ����
			int[] ypoints = { y, y, (y + xh), (y + xh) };
			p = new Polygon(xpoints, ypoints, 4); // ������ ���� ����Ʈ 4�� ���� �� .
			
			// intersects : Shape �� ���� ������, ������ ���� ������ ���� ������ �������� ����� ����.
			// if(p.intersects(...) : �÷��̾�� ���� ��ġ��...
			if (p.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {
				enList.remove(i);	// enList���� �迭i�� ���� (�� ����)
				start = false;		// start �ʵ忡 false���� ����  , ���� �浹�ϸ� Ű�Է� �ȵ�.
				end = true;			// end �ʵ忡 true���� ���� 
			}
		}
	}

	public void draw() {
		Graphics gs = bi.getGraphics(); //?
		gs.setColor(Color.white);	// setColor : ���� ���� (���� ����)
		gs.fillRect(0, 0, w, h);	// fillRect : ä���� �簢�� �׸���
		gs.setColor(Color.black);	// setColor : ���� ���� (�÷��̾���� �� ���ڻ� ����)
		gs.drawString("Enemy ��ü�� : " + enList.size(), 180, 50); // ���ڿ� �Է��ϰ� �ش� ��ǥ�� ("..."x,y)�� ǥ��
		gs.drawString("Ms ��ü�� : " + msList.size(), 180, 70); // ���ڿ� �Է��ϰ� �ش� ��ǥ�� ("..."x,y)�� ǥ��
		gs.drawString("���ӽ��� : Enter", 180, 90); // ���ڿ� �Է��ϰ� �ش� ��ǥ�� ("..."x,y)�� ǥ��

		if (end) {	// if (end) : end �ʵ尡 ���̸�... (������ ������)
			gs.drawString("G A M E     O V E R", 100, 250); // ���ڿ� �Է��ϰ� �ش� ��ǥ�� ("..."x,y)�� ǥ��
		}

		gs.fillRect(x, y, xw, xh);	// fillRect : ä���� �簢�� �׸��� (�÷��̾� �׸���)

		for (int i = 0; i < msList.size(); i++) { // �̻��� �� ��ŭ �ݺ�
			Ms m = (Ms) msList.get(i);			  // �̻��� ����
			gs.setColor(Color.blue);			  // setColor : ���� ���� (�̻��ϻ� ����)
			
			gs.drawOval(m.x, m.y, m.w, m.h);	  // drawOval(int x, int y, int width, int height) : Ÿ�� �׸��� 3,4��° �� ������ ����
			if (m.y < 0)						  // �̻����� y���� 0���� ������(�̻����� ȭ�� �� �����...)
				msList.remove(i);				  // remove : msList�� i��° �迭�� ����  (�̻��� ����)
			m.moveMs();							  // �̻��� �̵�.
		}
		gs.setColor(Color.black);				  // setColor : ���� ���� (�� ���� ����)
		for (int i = 0; i < enList.size(); i++) { // ���� ����ŭ �ݺ�
			Enemy e = (Enemy) enList.get(i);	  // enList���� i��° �迭�� �ҷ�����
			gs.fillRect(e.x, e.y, e.w, e.h);	  // fillRect : ä���� �簢�� �׸��� (�� �׸���)
			if (e.y > h)						  // ���� ��ǥ�� ȭ������� �Ѿ��...
				enList.remove(i);				  // remove : msList�� i��° �迭�� ����  (�� ����) 
			e.moveEn();							  // �� �̵�.
		}

		Graphics ge = this.getGraphics();
		ge.drawImage(bi, 0, 0, w, h, this);
	}

	public void keyControl() {	// �Էµ� Ű�� � �ǹ̷� �޾� ������ �����ϰ� ó���Ѵ�.
		if (0 < x) {		// �÷��̾��� x��ǥ���� 0���� ũ��...
			if (left)		// left������ ���̸�(�� Ű ������)
				x -= 3;		// x��ǥ�� 3 ����
		}
		if (w > x + xw) {	//	w(â��)�� x(�÷��̾���ǥ��) + xw(�÷��̾� ��) ���� ������...
			if (right)		//	right������ ���̸�(�� Ű ������)
				x += 3;		//	x�� 3 ����
		}
		if (25 < y) {		// �÷��̾��� x��ǥ���� 25���� ũ��...
			if (up)			// up������ ���̸�(�� Ű ������)
				y -= 3;		// y��ǥ�� 3 ����
		}
		if (h > y + xh) {	//	h(â����)�� y(�÷��̾���ǥ��) + xh(�÷��̾� ����) ���� ������...
			if (down)		//	down������ ���̸�(�� Ű ������)
				y += 3;		// y��ǥ�� 3 ����
		}
	}
	
	//keyPressed(KeyEvent ke) : Call Back �޼ҵ�(ȣ��κ��� ���µ� ����Ǹ�..) Ű���尡 �������� ����, ���� Ű�ڵ尡 ���Ե� �̺�Ʈ�� ���ڷ� �Է� ��.
	public void keyPressed(KeyEvent ke) {	
		switch (ke.getKeyCode()) { //getKeyCode : � Ű�� �Է� �Ǿ����� �˷��ִ� �޼ҵ�
		case KeyEvent.VK_LEFT:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			left = true;		// left��� ������ true�� �Է�, �������� �̵�?
			break;
		case KeyEvent.VK_RIGHT:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			right = true;		// right��� ������ true�� �Է�, ���������� �̵�?
			break;
		case KeyEvent.VK_UP:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			up = true;			// up��� ������ true�� �Է�, �������� �̵�?
			break;
		case KeyEvent.VK_DOWN:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			down = true;		// down��� ������ true�� �Է�, �Ʒ������� �̵�?
			break;
		case KeyEvent.VK_A:		// Ű������ aŰ�� ������ �� ó�� �� ���� 
			fire = true;		// fire��� ������ true�� �Է�, �̻��� �߻�?
			break;
		case KeyEvent.VK_ENTER:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			start = true;		// start��� ������ true�� �Է�, ���� ����?
			end = false;		// ???
			break;
		}
	}
	//keyPressed(KeyEvent ke) : Call Back �޼ҵ�(ȣ��κ��� ���µ� ����Ǹ�..) Ű���尡 ������ ���� ����, �� Ű�ڵ尡 ���Ե� �̺�Ʈ�� ���ڷ� �Է� ��.
	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			left = false;		// left��� ������ false�� �Է�, �������� �̵�����?
			break;
		case KeyEvent.VK_RIGHT:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			right = false;		// right��� ������ false�� �Է�, ���������� �̵�����?
			break;
		case KeyEvent.VK_UP:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			up = false;			// up��� ������ false�� �Է�, �������� �̵�����?
			break;
		case KeyEvent.VK_DOWN:	// Ű������ ��Ű�� ������ �� ó�� �� ���� 
			down = false;		// down��� ������ false�� �Է�, �Ʒ������� �̵�����?
			break;
		case KeyEvent.VK_A:		// Ű������ aŰ�� ������ �� ó�� �� ���� 
			fire = false;		// fire��� ������ false�� �Է�, �̻��� �߻� ����?
			break;
		}
	}

	public void keyTyped(KeyEvent ke) { // KeyListener �������̽����� ���� ���� ��� ����.
	}

	public static void main(String[] args) {	// Shoot Ŭ������ ���� �޼ҵ�
		Thread t = new Thread(new Shoot());		// Shoot Ŭ����(�����δ� run�޼ҵ�)�� ������� ����.
		t.start();								// start : ������ ���� �޼ҵ�
	}
}

class Ms { // �̻��� Ŭ����
	int x; // �̻��� x��ǥ��
	int y; // �̻��� y��ǥ��
	int w = 20; // �̻��� ����
	int h = 20;	// �̻��� ����

	public Ms(int x, int y) {	// ShootŬ������ fireMs �޼ҵ��� �� �Է� �ޱ�.
		this.x = x;				// fireMs �޼ҵ���
		this.y = y;				// fireMs �޼ҵ���
	}

	public void moveMs() { // �̻��� �̵� �޼ҵ�
		y--;	// �̻��� ��ġ�� ����, �̻����� ������ ����
	}
}

class Enemy {	//�� ���� Ŭ����
	int x;	// ��  ���� ��ġ��
	int y;	// ��  ���� ��ġ��
	int w = 10; // �� ����
	int h = 10; // �� ����

	public Enemy(int x, int y) { // ShootŬ������ enCreate �޼ҵ� �� �� �Է¹ޱ�.
		this.x = x;				 // enCreate�޼ҵ��� rx ������ EnemyŬ������ x�ʵ忡 �Է�
		this.y = y;				 // enCreate�޼ҵ��� ry ������ EnemyŬ������ y�ʵ忡 �Է�
	}

	public void moveEn() { // �� �̵� �޼ҵ�
		y++;	// �� ��ġ�� ����, ���� ������ ������
	}
}