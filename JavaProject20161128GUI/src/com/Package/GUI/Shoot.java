package com.Package.GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.swing.*;

//클레스와 메소드를 먼저 파악하면서 해당 변수들을 확인 한다.
//JFrame : Swing API의 핵심 클래스, Runnable : 멀티쓰레드용 인터페이스, KeyListener : 키보드 입력 처리 인터페이스
public class Shoot extends JFrame implements Runnable, KeyListener { 
	private BufferedImage bi = null;	//??
	private ArrayList msList = null;	// 미사일 객체 리스트
	private ArrayList enList = null;	// enemy 객체 리스트
	private boolean left = false, right = false, up = false, down = false, fire = false;
	private boolean start = false, end = false;
	private int w = 300, h = 500, x = 130, y = 450, xw = 20, xh = 20;
	// w(창의 폭), h(창의 높이), x(플레이어 좌표 x값), y(플레이어 좌표 y값), xw(플레이어 폭), xh(플레이어 높이)

	public Shoot() { 					// Shoot 클래스의 생성자(생성자의 역할은 초기화이다.)
		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); // 8bit 컬러의 픽셀 이미지를 저장할 버퍼를 생성
		msList = new ArrayList();		// ArrayList 생성, 사용처?
		enList = new ArrayList();		// ArrayList 생성, 용도 : 적 초기 위치값 및 적출현 수 저장용
		this.addKeyListener(this);		// addKeyListener : 키보드 입력 받을 수 있도록 허용
		this.setSize(w, h);				// setSize : GUI 창크기 지정 ( 17열. 창의 폭 : w=300, 창의 높이 : h=500 )
		this.setTitle("Shooting Game"); // setTitle : GUI 타이틀명 설정(html의 title와 동일한 기능)
		this.setResizable(false);		// setResizable : GUI 창크기 임의 설정 여부 설정(True면 마우스로 창 크기 설정 가능)
		
		// setDefaultCloseOperation : 닫기 버튼(우측상단 빨간색 X버튼) 눌렀을때 어떻게 할지 설정. (JFrame.EXIT_ON_CLOSE : 클릭시 GUI종료)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true); 		// setVisible : GUI를 출력 여부 설정 (true:창보이기,false:창 안보이기)
	}

	public void run() { // run() : 멀티쓰레드 전용 메소드(반드시 이름이 run 으로 해야된다. 메인 메소드와 비슷?) 
		try {								// 예외처리
			int msCnt = 0;
			int enCnt = 0;
			while (true) {					// while (true) : 무한 반복
				Thread.sleep(10);			// sleep : 0.01초 동안 일시 정지 (여기서는 게임 전체 속도 조절용도로 사용)

				if (start) {				// if (start) : start 변수가 true 이면 아래 내용 실행.
					if (enCnt > 2000) {		// if (enCnt > 2000) : 2000값이 작아지면 적 갯수 증가.
						enCreate();			// 적 생성 메소드 호출
						enCnt = 0;
					}
					if (msCnt >= 100) {		// 미사일 갯수?
						fireMs();			// 미사일 발사?
						msCnt = 0;
					}
					msCnt += 10;			// (10)값이 증가되면 미사일 발사 속도가 빨라짐. 
					enCnt += 10;			// (10)값이 증가되면 적이 나오는 턴이 빨라짐.
					keyControl();			// 화살표키와 미사일 발사버튼 제어
					crashChk();				// 미사일과 적 & 적과 플레이어 충돌여부 검사.
				}
				draw();						// 화면에 객체들을 그리기.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fireMs() {
		if (fire) {								// if (fire) : fire 변수가 true 이면 아래 내용 실행.
			if (msList.size() < 100) {			// if (msList.size() < 100) : msList 값의 갯수가 100보다 작으면...(미사일 갯수 제한)
				Ms m = new Ms(this.x, this.y);	// Ms객체 생성(미사일? 생성 위치 초기값을 플레이어 x/y좌표)
				msList.add(m);					// Ms객체를 리스트에 추가.
			}
		}
	}

	public void enCreate() {
		for (int i = 0; i < 9; i++) { // for (int i = 0; i < 9; i++) : 10번 반복for문, 여기서는 적의 최대 수는 설정값 (적은 9개 생성)
			
			// Math.random() : Random 클래스 없이, 간단히 정수 난수 구하기, rx =  랜덤값(0~1사이 소수값)*(창 넓이 300 - 플레이어 넓이 20)
			// 적 최초 시작위치 세로값 랜덤 값이 없으면 세로로 쭉 나온다.
			//(w + xw)는 미사일이 플레이어 좌측 끝에서만 나오기 때문에 가장 오른쪽은 미사일로 맞출수가 없어서 적이 나오지 않게 한다.?
			double rx = Math.random() * (w + xw);
			
			// ry = 랜덤값(0~1사이 소수값) * 50px
			// 적 최초 위치 시작범위 높이값 (50)숫자가 커질 수록 적이 앞에서 부터 나오며, 랜덤값이 없으면 적이 가로로 쭉 나온다.
			double ry = Math.random() * 50; 
			
			Enemy en = new Enemy((int) rx, (int) ry); // Enemy객체 생성, x/y좌표 전달 생성자
			enList.add(en); // add(en) : enList로 enCreate메소드에서 구현된 값을 저장.
		}
	}

	public void crashChk() {	// 플레이어 vs 적 & 미사일 vs 적 충돌체크
		Graphics g = this.getGraphics();				// Graphics 클래스 객체 생성
		Polygon p = null;								// Polygon 클래스 객체 생성
		for (int i = 0; i < msList.size(); i++) {		// msList 배열 갯수만큼 반복
			Ms m = (Ms) msList.get(i);					// msList i번째 배열값 불러와서 m변수에 저장.
			for (int j = 0; j < enList.size(); j++) {	// enList 배열 갯수만큼 반복
				Enemy e = (Enemy) enList.get(j);		// enList j번째 배열값 불러와서 e변수에 저장.
				
				// m.x : 미사일 x좌표, m.w : 미사일 넓이				
				int[] xpoints = { m.x, (m.x + m.w), (m.x + m.w), m.x }; // xpoints 배열변수에 미사일 충돌값 범위 설정.(x좌표)

				// m.y : 미사일 y좌표, m.h : 미사일 높이				
				int[] ypoints = { m.y, m.y, (m.y + m.h), (m.y + m.h) }; // ypoints 배열변수에 미사일 충돌값 범위 설정.(y좌표)
				p = new Polygon(xpoints, ypoints, 4); // 폴리건 생성 포인트 4개 지정 ■ .
				
				// intersects : Shape 의 내부 영역이, 지정된 구형 영역의 내부 영역과 교차할지 어떨지를 판정.
				// if(p.intersects(...) : 미사일과 적이 곂치면...
				if (p.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {
					msList.remove(i);	// msList에서 배열i값 제거 (미사일 제거)
					enList.remove(j);	// enList에서 배열j값 제거 (적 제거)
				}
			}
		}
		for (int i = 0; i < enList.size(); i++) { 			// enList 배열 갯수만큼 반복
			Enemy e = (Enemy) enList.get(i);				// enList i번째 배열값 불러와서 e변수에 저장.
			
			// x : 플레이어 x좌표, xw : 플레이어 넓이
			int[] xpoints = { x, (x + xw), (x + xw), x };
			
			// y : 플레이어 y좌표, xh : 플레이어 높이
			int[] ypoints = { y, y, (y + xh), (y + xh) };
			p = new Polygon(xpoints, ypoints, 4); // 폴리건 생성 포인트 4개 지정 ■ .
			
			// intersects : Shape 의 내부 영역이, 지정된 구형 영역의 내부 영역과 교차할지 어떨지를 판정.
			// if(p.intersects(...) : 플레이어와 적이 곂치면...
			if (p.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {
				enList.remove(i);	// enList에서 배열i값 제거 (적 제거)
				start = false;		// start 필드에 false값을 대입  , 적과 충돌하면 키입력 안됨.
				end = true;			// end 필드에 true값을 대입 
			}
		}
	}

	public void draw() {
		Graphics gs = bi.getGraphics(); //?
		gs.setColor(Color.white);	// setColor : 색상 지정 (배경색 설정)
		gs.fillRect(0, 0, w, h);	// fillRect : 채워진 사각형 그리기
		gs.setColor(Color.black);	// setColor : 색상 지정 (플레이어색깔 및 글자색 설정)
		gs.drawString("Enemy 객체수 : " + enList.size(), 180, 50); // 문자열 입력하고 해당 좌표값 ("..."x,y)에 표시
		gs.drawString("Ms 객체수 : " + msList.size(), 180, 70); // 문자열 입력하고 해당 좌표값 ("..."x,y)에 표시
		gs.drawString("게임시작 : Enter", 180, 90); // 문자열 입력하고 해당 좌표값 ("..."x,y)에 표시

		if (end) {	// if (end) : end 필드가 참이면... (게임이 끝나면)
			gs.drawString("G A M E     O V E R", 100, 250); // 문자열 입력하고 해당 좌표값 ("..."x,y)에 표시
		}

		gs.fillRect(x, y, xw, xh);	// fillRect : 채워진 사각형 그리기 (플레이어 그리기)

		for (int i = 0; i < msList.size(); i++) { // 미사일 수 만큼 반복
			Ms m = (Ms) msList.get(i);			  // 미사일 갯수
			gs.setColor(Color.blue);			  // setColor : 색상 지정 (미사일색 설정)
			
			gs.drawOval(m.x, m.y, m.w, m.h);	  // drawOval(int x, int y, int width, int height) : 타원 그리기 3,4번째 값 같으면 원형
			if (m.y < 0)						  // 미사일의 y값이 0보다 작으면(미사일이 화면 을 벗어나면...)
				msList.remove(i);				  // remove : msList의 i번째 배열값 삭제  (미사일 제거)
			m.moveMs();							  // 미사일 이동.
		}
		gs.setColor(Color.black);				  // setColor : 색상 지정 (적 색깔 지정)
		for (int i = 0; i < enList.size(); i++) { // 적의 수만큼 반복
			Enemy e = (Enemy) enList.get(i);	  // enList에서 i번째 배열값 불러오기
			gs.fillRect(e.x, e.y, e.w, e.h);	  // fillRect : 채워진 사각형 그리기 (적 그리기)
			if (e.y > h)						  // 적의 좌표가 화면밖으로 넘어가면...
				enList.remove(i);				  // remove : msList의 i번째 배열값 삭제  (적 제거) 
			e.moveEn();							  // 적 이동.
		}

		Graphics ge = this.getGraphics();
		ge.drawImage(bi, 0, 0, w, h, this);
	}

	public void keyControl() {	// 입력된 키를 어떤 의미로 받아 들일지 결정하고 처리한다.
		if (0 < x) {		// 플레이어의 x좌표값이 0보다 크면...
			if (left)		// left변수가 참이면(← 키 누르면)
				x -= 3;		// x좌표를 3 감소
		}
		if (w > x + xw) {	//	w(창폭)가 x(플레이어좌표값) + xw(플레이어 폭) 보다 작으면...
			if (right)		//	right변수가 참이면(→ 키 누르면)
				x += 3;		//	x값 3 증가
		}
		if (25 < y) {		// 플레이어의 x좌표값이 25보다 크면...
			if (up)			// up변수가 참이면(↑ 키 누르면)
				y -= 3;		// y좌표를 3 감소
		}
		if (h > y + xh) {	//	h(창길이)가 y(플레이어좌표값) + xh(플레이어 길이) 보다 작으면...
			if (down)		//	down변수가 참이면(↓ 키 누르면)
				y += 3;		// y좌표를 3 증가
		}
	}
	
	//keyPressed(KeyEvent ke) : Call Back 메소드(호출부분이 없는데 실행되면..) 키보드가 눌렸을때 실행, 눌린 키코드가 포함된 이벤트가 인자로 입력 됨.
	public void keyPressed(KeyEvent ke) {	
		switch (ke.getKeyCode()) { //getKeyCode : 어떤 키가 입력 되었는지 알려주는 메소드
		case KeyEvent.VK_LEFT:	// 키보드의 ←키가 눌렸을 때 처리 할 내용 
			left = true;		// left라는 변수에 true를 입력, 왼쪽으로 이동?
			break;
		case KeyEvent.VK_RIGHT:	// 키보드의 →키가 눌렸을 때 처리 할 내용 
			right = true;		// right라는 변수에 true를 입력, 오른쪽으로 이동?
			break;
		case KeyEvent.VK_UP:	// 키보드의 ↑키가 눌렸을 때 처리 할 내용 
			up = true;			// up라는 변수에 true를 입력, 윗쪽으로 이동?
			break;
		case KeyEvent.VK_DOWN:	// 키보드의 ↓키가 눌렸을 때 처리 할 내용 
			down = true;		// down라는 변수에 true를 입력, 아랫쪽으로 이동?
			break;
		case KeyEvent.VK_A:		// 키보드의 a키가 눌렸을 때 처리 할 내용 
			fire = true;		// fire라는 변수에 true를 입력, 미사일 발사?
			break;
		case KeyEvent.VK_ENTER:	// 키보드의 ↓키가 눌렸을 때 처리 할 내용 
			start = true;		// start라는 변수에 true를 입력, 게임 시작?
			end = false;		// ???
			break;
		}
	}
	//keyPressed(KeyEvent ke) : Call Back 메소드(호출부분이 없는데 실행되면..) 키보드가 누르고 뗄때 실행, 땐 키코드가 포함된 이벤트가 인자로 입력 됨.
	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:	// 키보드의 ←키가 눌렸을 때 처리 할 내용 
			left = false;		// left라는 변수에 false를 입력, 왼쪽으로 이동정지?
			break;
		case KeyEvent.VK_RIGHT:	// 키보드의 →키가 눌렸을 때 처리 할 내용 
			right = false;		// right라는 변수에 false를 입력, 오른쪽으로 이동정지?
			break;
		case KeyEvent.VK_UP:	// 키보드의 ↑키가 눌렸을 때 처리 할 내용 
			up = false;			// up라는 변수에 false를 입력, 윗쪽으로 이동정지?
			break;
		case KeyEvent.VK_DOWN:	// 키보드의 ↓키가 눌렸을 때 처리 할 내용 
			down = false;		// down라는 변수에 false를 입력, 아랫쪽으로 이동정지?
			break;
		case KeyEvent.VK_A:		// 키보드의 a키가 눌렸을 때 처리 할 내용 
			fire = false;		// fire라는 변수에 false를 입력, 미사일 발사 정지?
			break;
		}
	}

	public void keyTyped(KeyEvent ke) { // KeyListener 인터페이스에서 강제 구현 기능 없음.
	}

	public static void main(String[] args) {	// Shoot 클래스의 메인 메소드
		Thread t = new Thread(new Shoot());		// Shoot 클래스(실제로는 run메소드)를 쓰레드로 생성.
		t.start();								// start : 쓰레드 시작 메소드
	}
}

class Ms { // 미사일 클래스
	int x; // 미사일 x좌표값
	int y; // 미사일 y좌표값
	int w = 20; // 미사일 넓이
	int h = 20;	// 미사일 높이

	public Ms(int x, int y) {	// Shoot클래스의 fireMs 메소드의 값 입력 받기.
		this.x = x;				// fireMs 메소드의
		this.y = y;				// fireMs 메소드의
	}

	public void moveMs() { // 미사일 이동 메소드
		y--;	// 미사일 위치값 감소, 미사일이 앞으로 나감
	}
}

class Enemy {	//적 설정 클래스
	int x;	// 적  가로 위치값
	int y;	// 적  세로 위치값
	int w = 10; // 적 넓이
	int h = 10; // 적 높이

	public Enemy(int x, int y) { // Shoot클래스의 enCreate 메소드 의 값 입력받기.
		this.x = x;				 // enCreate메소드의 rx 변수값 Enemy클래스의 x필드에 입력
		this.y = y;				 // enCreate메소드의 ry 변수값 Enemy클래스의 y필드에 입력
	}

	public void moveEn() { // 적 이동 메소드
		y++;	// 적 위치값 증가, 적이 밑으로 내려옴
	}
}