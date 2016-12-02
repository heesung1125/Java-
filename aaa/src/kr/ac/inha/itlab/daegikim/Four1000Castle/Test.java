package kr.ac.inha.itlab.daegikim.Four1000Castle;

import javax.swing.*;

public class Test {
	public static void main(String[] args) {
		MainForm form = new MainForm();
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료버튼 활성화
		form.setSize(1300,700); // 게임창 크기 설정 / 초기값 : (x1300,y700)
		form.setVisible(true); // 게임창 띄우기 설정 / 초기값 : true(창 띄우기)
		form.setResizable(false); // 게임창 크기 임의조정 설정 / 초기값 : false(불가능) 


    }
}
