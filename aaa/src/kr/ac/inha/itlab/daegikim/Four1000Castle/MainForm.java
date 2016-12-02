
package kr.ac.inha.itlab.daegikim.Four1000Castle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.*;

public class MainForm extends JFrame implements Runnable{
	public static boolean isScoreFramePopUp=false; // isScoreFramePopUp : ?? / 초기값 : false

	private boolean isPause=false; // isPause : ?? / 초기값 : false

	private boolean ThreadControl; // ThreadControl : ??
	private long StartMillis; // StartMillis : ??
    private long diff; // diff : ??
	private long SaveMillis; // SaveMillis : ??

	public final int ROW_CNT = 12, COL_CNT = 18; // ROW_CNT : ?? / 초기값 : 12, COL_CNT : ?? / 초기값 : 18
	public final int NUM_IMAGES = 27; // NUM_IMAGES : 게임에 출력될 카드이미지 숫자 / 초기값 : 27
	public int nCol, nRow; // nCol : ?? nRow : ??
	public int nSlctRow, nSlctCol; // nSlctRow : ?? nSlctCol : ??
	public int nLevel = 1; // nLevel : 게임레벨값 저장 초기값을 증가시키면 맨처음에 해당레벨에서 시작됨. / 초기값 : 1
	public int nYourScore; // nYourScore : ??
	public int [][] nLvCol = {{5,14},{3,16},{3,16},{1,18},{0,19}}; // nLvCol : 2차원배열?? / 초기값 : {{5,14},{3,16},{3,16},{1,18},{0,19}}
	public int [][] nLvRow = {{3,10},{3,10},{1,12},{1,12},{0,13}}; // nLvRow : 2차원배열?? / 초기값 : {{3,10},{3,10},{1,12},{1,12},{0,13}}
	public boolean bSelected = false; // bSelected : ?? / 초기값 : false
	public int[][] OX; // OX : 2차원 배열 ??
	Random m_Rand; // Random 클래스 호출 / 필드명 : m_Rand / 용도 : ??
	Thread thread; // Thread 클래스 호출 / 필드명 : thread / 용도 : ??
	Way way; // Way 클래스 호출 / 필드명 : way / 용도 : ??


	private JButton[] gameButtons; // gameButtons : [] ??
	private Icon[] gameBtIcon; // gameBtIcon : [] 게임아이콘 저장 배열
	private Icon nullIcon; // nullIcon : 게임 빈칸 아이콘 저장 배열
	private JButton btStart; // btStart : ??
	private JButton btReset; // btReset : ??
	private JButton btShuffle; // btShuffle : ??
	private JButton btScore; // btScore : ??
	private JButton btExit; // btExit : ??
	private JButton btPause; // btPause : ??
	private JPanel centerPanel; // centerPanel : ??
	private JPanel southPanel; // southPanel : ??
	private JPanel northPanel; // northPanel : ??
    private JPanel eastPanel; // eastPanel : ??
	private JComboBox combo; // combo : ??
	private JLabel time; // time : ??
	private JLabel score; // score : ??
	private JLabel nowLevel; // nowLevel : ??
	

	private JButton select1; // JButton 클래스 호출 / 필드명 : select1 / 용도 : ??
	private JButton select2; // JButton 클래스 호출 / 필드명 : select2 / 용도 : ??
	

	DecimalFormat dfms = new DecimalFormat("000"); // DecimalFormat 클래스 호출 / 필드명 : dfms / 용도 ???
	DecimalFormat dfsc = new DecimalFormat("00"); // DecimalFormat 클래스 호출 / 필드명 : dfsc / 용도 ???
	

	TreeMap<Long, String> scoreTreeMapLv1 = new TreeMap<Long, String>(); // TreeMap 클래스 호출 / 필드명: scoreTreeMapLv1 / 용도?
	TreeMap<Long, String> scoreTreeMapLv2 = new TreeMap<Long, String>(); // TreeMap 클래스 호출 / 필드명: scoreTreeMapLv2 / 용도?
	TreeMap<Long, String> scoreTreeMapLv3 = new TreeMap<Long, String>(); // TreeMap 클래스 호출 / 필드명: scoreTreeMapLv3 / 용도?
	TreeMap<Long, String> scoreTreeMapLv4 = new TreeMap<Long, String>(); // TreeMap 클래스 호출 / 필드명: scoreTreeMapLv4 / 용도?
	TreeMap<Long, String> scoreTreeMapLv5 = new TreeMap<Long, String>(); // TreeMap 클래스 호출 / 필드명: scoreTreeMapLv5 / 용도?

	ScoreForm scoreform; // ScoreForm 클래스 호출 / 필드명 : scoreform / 용도 : ??

	public MainForm() {
		super("Four1000Castle"); // 게임 타이틀 입력
		formInit(); // formInit 메소드 호출
	}

	public void formInit(){ // formInit 메소드 생성 / 용도 ? 
		setLayout(new BorderLayout()); // JFrame 클래스 setLayout메소드 호출 및 객체 생성
		way = new Way(); // way 필드 초기화 및 객체 생성
		scoreform= new ScoreForm(scoreTreeMapLv1,scoreTreeMapLv2,scoreTreeMapLv3,scoreTreeMapLv4,scoreTreeMapLv5);
		//scoreform 필드 초기화 및 객체 생성 / 용도 ? 
		m_Rand = new Random (System.currentTimeMillis()); 
		//m_Rand 필드 초기화 및 객체 생성 / 용도 현재 시간값 이용하여 랜덤값 생성 
		
		OX = new int[ROW_CNT+2][COL_CNT+2];
		for (int i = 0; i < ROW_CNT+2; i++) { //빈칸 지정?
	    		for (int j = 0; j < COL_CNT+2; j++) {
				OX[i][j] = -1;
			}
		}

		select1 = new JButton(); // select1 필드 초기화 및 객체 생성
		select2 = new JButton(); // select2 필드 초기화 및 객체 생성

		combo=new JComboBox(); // combo 필드 초기화 및 객체 생성
		for(int i=1; i<=5; i++){ // ??
			combo.addItem(i+" level");
		}
		combo.addActionListener(new ComboBoxHandler());

		centerPanel = new JPanel(); centerPanel.setBackground(Color.DARK_GRAY); // 내부 상하 패널색 지정
		southPanel = new JPanel(); southPanel.setBackground(Color.DARK_GRAY); //	하단 패널색 지정
		northPanel = new JPanel(); northPanel.setBackground(Color.DARK_GRAY); // 상단 패널색 지정
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.DARK_GRAY); // 좌측바 패널색 지정
		eastPanel = new JPanel(); eastPanel.setBackground(Color.DARK_GRAY); // 우측바 패널색 지정

		southPanel.setLayout(new FlowLayout());
		northPanel.setLayout(new FlowLayout());
		westPanel.setLayout(new FlowLayout());
		eastPanel.setLayout(new FlowLayout());

		gameBtIcon = new Icon[NUM_IMAGES]; // 게임에 사용 될 카드이미지 숫자만큼 배열값 설정
		for(int i=0; i<gameBtIcon.length; i++){ // 게임 아이콘 이미지 저장용 반복문
            gameBtIcon[i] = new ImageIcon(getClass().getResource("resources/30px-"+String.format("%02d", i+1)+".png"));
		}
		
		nullIcon = new ImageIcon(getClass().getResource("resources/null.png")); // 빈칸 이미지

		btStart = new JButton("START"); //btStart.setBackground(Color.ORANGE);
		// START 버튼 생성 : 버튼 클릭시 게임 시작
		btReset = new JButton("RESET"); btReset.setBackground(Color.ORANGE);
		//RESET 버튼 생성 : 버튼 클릭시 게임 재시작
		btShuffle = new JButton("SHUFFLE"); btShuffle.setBackground(Color.ORANGE);
		//SHUFFLE 버튼 생성 : 버튼 클릭시 카드 셔플
		btScore = new JButton("SCORE"); btScore.setBackground(Color.ORANGE);
		//SCORE 버튼 생성 : 버튼 클릭시 스코어 창 팝업
		btExit = new JButton("EXIT"); btExit.setBackground(Color.ORANGE);
		//EXIT 버튼 생성 : 버튼 클릭시 게임 종료창 팝업
		btPause = new JButton("PAUSE"); btPause.setBackground(Color.DARK_GRAY);
		//PAUSE 버튼 생성 : 버튼 처음 클릭시 게임 일시 정지 다시 누르면 중지한 부분부터 게임다시 실행
		
		
		btStart.addActionListener(new StartButtonHandler());
		btReset.addActionListener(new ResetButtonHandler());
		btShuffle.addActionListener(new ShuffleButtonHandler());
		btExit.addActionListener(new ExitButtonHandler());
		btPause.addActionListener(new PaushButtonHandler());
		btScore.addActionListener(new ScoreButtonHandler());
		//각 버튼 클릭시 실행할 메소드 호출
		

		time = new JLabel();
		time.setFont(new Font("Consolas",1,30)); // 상단 타이머 폰트 지정
		time.setForeground(Color.ORANGE); // 상단 타이머 글자색 지정

		score = new JLabel();
		score.setFont(new Font("Consolas",1,20)); // 상단 스코어 폰트 지정
		score.setForeground(Color.ORANGE); // 상단 스코어 글자색 지정

		nowLevel = new JLabel();
		nowLevel.setFont(new Font("Consolas",1,20)); // 상단 게임레벨 폰트 지정
		nowLevel.setForeground(Color.ORANGE); // 상단 게임레벨 글자색 지정

		gameButtons = new JButton[(ROW_CNT+2)*(COL_CNT+2)];

		southPanel.add(btStart);
		southPanel.add(btReset);
		southPanel.add(btPause);
		southPanel.add(btShuffle);
		southPanel.add(btScore);
		southPanel.add(btExit);
		southPanel.add(combo);

		northPanel.add(nowLevel);
		northPanel.add(time);
		northPanel.add(score);

		add(centerPanel, BorderLayout.CENTER); // centerPanel 가운데 정렬
		add(southPanel, BorderLayout.SOUTH); // southPanel 하단 정렬
		add(northPanel, BorderLayout.NORTH); // northPanel 상단 정렬
		add(westPanel, BorderLayout.WEST); // westPanel 좌측 정렬
		add(eastPanel, BorderLayout.EAST); // eastPanel 우측 정렬
		
		setLevel(nLevel); // setLevel 메소드 호출
		onReady(); // onReady 메소드 호출
	} //end of formInit()

	public void onReady(){ // 게임 초기화면 상태
		diff=0;
		nYourScore=0; // 게임 점수 / 초기값 : 0
		SaveMillis=0;
		nowLevel.setText("Now Level: " +nLevel+"              "); // 게임 상단 현재 게임레벨 출력
		time.setText("Time: 0:00.000"); // 게임 상단 현재 게임 타이머 출력
		score.setText("              Score: "+nYourScore); // 게임 상단 현재 게임 점수 출력

		combo.setEnabled(true);
		btStart.setEnabled(true); // Start 버튼 초기 상태 설정 true : 버튼 활성화
		btScore.setEnabled(true); // Score 버튼 초기 상태 설정 true : 버튼 활성화
		btExit.setEnabled(true); // Exit 버튼 초기 상태 설정  true : 버튼 활성화
		btReset.setEnabled(true); // Reset 버튼 초기 상태 설정  true : 버튼 활성화
		btStart.setBackground(Color.ORANGE); // Start 버튼 컬러 지정
		btScore.setBackground(Color.ORANGE); // Score 버튼 컬러 지정
		btExit.setBackground(Color.ORANGE); // Exit 버튼 컬러지정
		
		btReset.setBackground(Color.ORANGE); // Reset 버튼 컬러지정

		btPause.setEnabled(false); // Pause 버튼 초기 상태 설정 false : 버튼 비활성화
		btShuffle.setEnabled(false); // Shuffle 버튼 초기 상태 설정 false : 버튼 비활성화
		btPause.setBackground(Color.DARK_GRAY);
		btShuffle.setBackground(Color.DARK_GRAY);
	}

	public void onStart(){
		diff=0;
		nYourScore=0;
		SaveMillis=0;
		nowLevel.setText("Now Level: " +nLevel+"              ");
		time.setText("Time: 0:00.0000");
		score.setText("              Score: "+nYourScore);

		combo.setEnabled(false);
		btStart.setEnabled(false);
		btScore.setEnabled(false);
		btReset.setEnabled(false);
		btStart.setBackground(Color.DARK_GRAY);
		btScore.setBackground(Color.DARK_GRAY);
		btExit.setBackground(Color.DARK_GRAY);
		btReset.setBackground(Color.DARK_GRAY);

		btPause.setEnabled(true);
		btExit.setEnabled(true);
		btShuffle.setEnabled(true);
		btPause.setBackground(Color.ORANGE);
		btExit.setBackground(Color.ORANGE);
		btShuffle.setBackground(Color.ORANGE);
	}

	public void onPause(){
		combo.setEnabled(false);
		btStart.setEnabled(false);
		btShuffle.setEnabled(false);
		btStart.setBackground(Color.DARK_GRAY);
		btShuffle.setBackground(Color.DARK_GRAY);

		btPause.setEnabled(true);
		btScore.setEnabled(true);
		btReset.setEnabled(true);
		btExit.setEnabled(true);
		btPause.setBackground(Color.ORANGE);
		btScore.setBackground(Color.ORANGE);
		btReset.setBackground(Color.ORANGE);
		btExit.setBackground(Color.ORANGE);
	}

	public void onUnPause(){
		combo.setEnabled(false);
		btStart.setEnabled(false);
		btScore.setEnabled(false);
		btReset.setEnabled(false);
		btStart.setBackground(Color.DARK_GRAY);
		btScore.setBackground(Color.DARK_GRAY);
		btReset.setBackground(Color.DARK_GRAY);

		btPause.setEnabled(true);
		btExit.setEnabled(true);
		btShuffle.setEnabled(true);
		btPause.setBackground(Color.ORANGE);
		btExit.setBackground(Color.ORANGE);
		btShuffle.setBackground(Color.ORANGE);
	}

	public void timeOver(){
		JOptionPane.showMessageDialog(null, "TIme Over!!");
		setLevel(nLevel);
		onReady();
	}

	public void setLevel (int level)
	{
		int i, j, n;
		int[] ImageCount = new int[NUM_IMAGES];

		for (i = 0; i < NUM_IMAGES; i++) ImageCount[i] = 0;

		for (i = 0; i < ROW_CNT+2; i++) {
	    		for ( j = 0; j < COL_CNT+2; j++) {
				OX[i][j] = -1;
			}
		}
	
		//level 1
		if (level == 1)	{
			for (i = 6; i <= 13; i++ ) {
				for (j = 4; j <= 9; j++ ) {
					do 
					{
						n = (int)(m_Rand.nextFloat()*12.0);
					} while (ImageCount[n] == 4);
				
					OX[j][i] = n;
					ImageCount[n]++;
				}
			}
		//level 2
		} else if (level == 2) {
			for (i = 4; i <= 15; i++ ) {
				for (j = 4; j <= 9; j++ ) 	{
					do 
					{
						n = (int)(m_Rand.nextFloat()*18.0);
					} while (ImageCount[n] == 4);

					OX[j][i] = n;
					ImageCount[n]++;
				} 
			}
		//level 3
		} else if (level == 3) {
			for (i = 4; i <= 15; i++ ) {
				for (j = 2; j <= 11; j++ ) {
					do 
					{
						n = (int)(m_Rand.nextFloat()*20.0);
					} while (ImageCount[n] == 6);
				
					OX[j][i] = n;
					ImageCount[n]++;
				} 
			}
		//level 4	
		} else if (level == 4) {
			for (i = 2; i <= 17; i++ ) {
				for (j = 2; j <= 11; j++ ) {
					do 
					{
						n = (int)(m_Rand.nextFloat()*20.0);
					} while (ImageCount[n] == 8);
			
					OX[j][i] = n;
					ImageCount[n]++;
				} 
			}
		//level 5
		} else if (level == 5) {
			for (i = 1; i <= 18; i++ ) {
				for (j = 1; j <= 12; j++ ) {
					do 
					{
						n = (int)(m_Rand.nextFloat()*27.0);
					} while (ImageCount[n] == 8);
				
					OX[j][i] = n;
					ImageCount[n]++;
				} 
			}
		} 
		
		make_button(COL_CNT+2,ROW_CNT+2);
		nLevel=level;
		nowLevel.setText("Now Level: " +nLevel+"              ");
	}

	public void setGrid(JComponent comp, GridBagConstraints c, JPanel pan, int x, int y, int width, int height){
		c.gridx=x;
		c.gridy=y;
		c.gridwidth=width;
		c.gridheight=height;
		pan.add(comp,c);
	}

	public void make_button(int rows, int cols)
	{
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		
		centerPanel.setLayout(gridbag);
		centerPanel.removeAll();

		int i=0;
		for(int row=0; row<rows; row++){
			for(int col=0; col<cols; col++){
				if(OX[col][row]!=-1){
					gameButtons[i]=new JButton(gameBtIcon[OX[col][row]]);
					gameButtons[i].setBackground(Color.ORANGE);
					gameButtons[i].addActionListener(new GameButtonsHandler());
					gameButtons[i].setEnabled(false);
					gameButtons[i].setBorderPainted(true);
					setGrid(gameButtons[i], c, centerPanel, row, col, 1, 1);
					i++;
				}
				else{
                    gameButtons[i]=new JButton(nullIcon);
					gameButtons[i].setBackground(Color.ORANGE);
					gameButtons[i].setBorderPainted(false);
					gameButtons[i].setEnabled(false);
					setGrid(gameButtons[i], c, centerPanel, row, col, 1, 1);
					i++;
				}
			} //end of for
		} //end of for 
		centerPanel.updateUI();
	}

	public void remake_button(int rows, int cols)
	{
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		
		centerPanel.setLayout(gridbag);
		centerPanel.removeAll();

		int i=0;
		for(int row=0; row<rows; row++){
			for(int col=0; col<cols; col++){
				if(OX[col][row]!=-1){
					gameButtons[i].setIcon(gameBtIcon[OX[col][row]]);
					gameButtons[i].setBackground(Color.ORANGE);
					gameButtons[i].setEnabled(true);
					gameButtons[i].setBorderPainted(true);
					setGrid(gameButtons[i], c, centerPanel, row, col, 1, 1);
					i++;
				}
				else{
					gameButtons[i].setIcon(nullIcon);
					gameButtons[i].setBackground(Color.ORANGE);
					gameButtons[i].setBorderPainted(false);
					gameButtons[i].setEnabled(false);
					setGrid(gameButtons[i], c, centerPanel, row, col, 1, 1);
					i++;
				}
			} //end of for
		} //end of for 
		centerPanel.updateUI();
	}

    /**
     * Find path with source and target
     * @param sCol Source column
     * @param sRow Source row
     * @param tCol Target column
     * @param tRow Target row
     */
    public void findPath (int sCol, int sRow, int tCol, int tRow)
	{
        //媛숈� 洹몃┝�씠 �븘�땲�씪硫�
		if (OX[sRow][sCol] != OX[tRow][tCol]) {
			way.curv = 3;
			return;
		}

        //source �� target �씠 媛숇떎硫�
		if (sCol == tCol && sRow == tRow) {
			way.curv = 3;
			return;
		}
		
	
		int i;

        //而ㅻ툕 �뾾�씠 釉붾윮 �젣嫄곌� 媛��뒫�븳 寃쎌슦
		way.curv=0;
        //媛숈� Row�뿉 �몢 踰꾪듉�씠 �엳�떎.
		if ( sRow == tRow ) {
			int diff=Math.max(sCol,tCol)-Math.min(sCol,tCol);
			int startCol= Math.min(sCol,tCol);
			way.x0=startCol;
			way.y0=sRow;
			way.x1=startCol+diff;
			way.y1=tRow;
			if (diff==1) return;
			for (i=1;i<diff;i++) 
				if (OX[sRow][startCol+i] != -1) break;
			
			if (i==diff) return;
		}

        //媛숈� Column�뿉 �몢 踰꾪듉�씠 �엳�떎.
		if ( sCol== tCol ) {
			int diff=Math.max(sRow,tRow)-Math.min(sRow,tRow);
			int startRow= Math.min(sRow,tRow);
	
			way.x0=sCol;
			way.y0=startRow;
			way.x1=tCol;
			way.y1=startRow+diff;
	
			if (diff==1) return;

			for (i=1;i<diff;i++)
				if (OX[startRow+i][sCol] != -1) break;

			if (i==diff) return;
		}

        //1踰덉쓽 而ㅻ툕濡� 釉붾윮 �젣嫄곌� 媛��뒫�븳 寃쎌슦
		way.curv=1;
		if (Math.max(sCol,tCol)-Math.min(sCol,tCol) > 0 && 
			Math.max(sRow,tRow)-Math.min(sRow,tRow) > 0 ) {
			way.x0=sCol;
			way.y0=sRow;
			way.x2=tCol;
			way.y2=tRow;
			if (sCol < tCol && sRow < tRow) {
				if ( (Check_ClearX(sCol+1,tCol,sRow) && Check_ClearY(sRow,tRow-1,tCol)) ) {
					way.x1=tCol;
					way.y1=sRow;
					return;
				}
				if ( (Check_ClearY(sRow+1,tRow,sCol) && Check_ClearX(sCol,tCol-1,tRow)) ) {
					way.x1=sCol;
					way.y1=tRow;
					return;
				}
			}
			else if (sCol < tCol && sRow > tRow) {
				if ( (Check_ClearX(sCol+1,tCol,sRow) && Check_ClearY(sRow,tRow+1,tCol)) ) {
					way.x1=tCol;
					way.y1=sRow;
					return;
				}
				if ( (Check_ClearY(sRow-1,tRow,sCol) && Check_ClearX(sCol,tCol-1,tRow)) ) {
					way.x1=sCol;
					way.y1=tRow;
					return;
				}
			}
			else if (sCol > tCol && sRow > tRow) {
				if ( (Check_ClearX(tCol,sCol-1,sRow) && Check_ClearY(sRow,tRow+1,tCol)) ) {
					way.x1=tCol;
					way.y1=sRow;
					return;
				}
				if ( (Check_ClearY(sRow-1,tRow,sCol) && Check_ClearX(tCol+1,sCol,tRow)) ) {
					way.x1=sCol;
					way.y1=tRow;
					return;
				}
			}
			else {
				if ( (Check_ClearX(tCol+1,sCol,tRow) && Check_ClearY(tRow,sRow+1,sCol)) ) {
					way.x1=sCol;
					way.y1=tRow;
					return;
				}
				if ( (Check_ClearY(tRow-1,sRow,tCol) && Check_ClearX(tCol,sCol-1,sRow)) ) {
					way.x1=tCol;
					way.y1=sRow;
					return;
				}
			}
		}

        //2踰덉쓽 而ㅻ툕濡� 釉붾윮 �젣嫄곌� 媛��뒫�븳 寃쎌슦
		way.curv=2;
		int leftCol,rightCol;
		leftCol=Math.min(sCol,tCol);
		rightCol=Math.max(sCol,tCol);
		for (i=nLvRow[nLevel-1][0];i<=nLvRow[nLevel-1][1];i++) { //row
			if (Check_ClearX(leftCol,rightCol,i)) {
				if ( Check_ClearY(i,( sRow > i) ? sRow-1:sRow+1,sCol) &&
					Check_ClearY(i,( tRow > i ) ? tRow-1 : tRow+1 ,tCol) ) {
					way.x0=sCol;
					way.y0=sRow;
					way.x1=sCol;
					way.y1=i;
					way.x2=tCol;
					way.y2=i;
					way.x3=tCol;
					way.y3=tRow;
					return;
				}
			}
		}
		
		int topRow,bottomRow;
		topRow=Math.min(sRow,tRow);
		bottomRow=Math.max(sRow,tRow);
		for (i=nLvCol[nLevel-1][0];i<=nLvCol[nLevel-1][1];i++) { //col
			if (Check_ClearY(topRow,bottomRow,i)) {
				if ( Check_ClearX(i,( sCol > i) ? sCol-1:sCol+1,sRow) &&
					Check_ClearX(i,( tCol > i ) ? tCol-1 : tCol+1 ,tRow) ) {
					way.x0=sCol;
					way.y0=sRow;
					way.x1=i;
					way.y1=sRow;
					way.x2=i;
					way.y2=tRow;
					way.x3=tCol;
					way.y3=tRow;
					return;
				}
			}
		}

        //洹� �쇅�뿉�뒗 3踰덉쓽 而ㅻ툕 �씠�긽�씠�떎.
		way.curv=3;
	}

	public boolean Check_ClearX(int col1, int col2, int row) 
	{
		int start=Math.min(col1, col2);
		int end=Math.max(col1, col2);
		for (int i = start; i < end+1; i++){ 
			if (OX[row][i] != -1) {
				return false;
			}
		}
		return true;
	}

	public boolean Check_ClearY(int row1, int row2, int col)
	{
		int start=Math.min(row1, row2);
		int end=Math.max(row1, row2);
		for (int i = start; i < end+1; i++) {
			if (OX[i][col] != -1) {
				return false;
			}
		}	
		return true;
	}

	public void drawPath(){
		System.out.println("*****drawPath()*****");
		System.out.println("curv:"+way.curv);
		System.out.println("x0,y0 : "+way.x0+","+way.y0);
		System.out.println("x1,y1 : "+way.x1+","+way.y1);
		System.out.println("x2,y2 : "+way.x2+","+way.y2);
		System.out.println("x3,y3 : "+way.x3+","+way.y3);
		System.out.println();
		
		
		if (way.curv == 0) {
			if (Math.max(way.x0,way.x1)-Math.min(way.x0,way.x1)==1 
					|| Math.max(way.y0,way.y1)-Math.min(way.y0,way.y1)==1 ) {
				return;
			}

			if (way.y0 == way.y1) {
				if (way.x0 > way.x1) {
					for(int i=way.x1; i<way.x0+1; i++){
						gameButtons[(i*14)+way.y0].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.x0; i<way.x1+1; i++){
						gameButtons[(i*14)+way.y0].setBackground(Color.BLUE);
					}
				}
				return;
			}
			else if (way.x0 == way.x1) {
				if (way.y0 > way.y1) {
					for(int i=way.y1; i<way.y0+1; i++){
						gameButtons[(way.x0*14)+i].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.y0; i<way.y1+1; i++){
						gameButtons[(way.x0*14)+i].setBackground(Color.BLUE);
					}
				}
				return;
			}
		}
	
		
		if (way.curv == 1) {

			if (way.y0 == way.y1) {
				if (way.x0 > way.x1) {
					for(int i=way.x1; i<way.x0+1; i++){
						gameButtons[(i*14)+way.y1].setBackground(Color.BLUE);
					}
					
				}
				else {
					for(int i=way.x0; i<way.x1+1; i++){
						gameButtons[(i*14)+way.y1].setBackground(Color.BLUE);
					}
				}


				if (way.y1 > way.y2) {
					for(int i=way.y2; i<way.y1+1; i++){
						gameButtons[(way.x1*14)+i].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.y1; i<way.y2+1; i++){
						gameButtons[(way.x1*14)+i].setBackground(Color.BLUE);
					}
				}
				return;
			}
			else if (way.x0 == way.x1) {
				if (way.y0 > way.y1) {
					for(int i=way.y1; i<way.y0+1; i++){
						gameButtons[(way.x0*14)+i].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.y0; i<way.y1+1; i++){
						gameButtons[(way.x0*14)+i].setBackground(Color.BLUE);
					}
				}

				if (way.x1 > way.x2) {
					for(int i=way.x2; i<way.x1+1; i++){
						gameButtons[(i*14)+way.y1].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.x1; i<way.x2+1; i++){
						gameButtons[(i*14)+way.y1].setBackground(Color.BLUE);
					}
				}
				return;
			}
		}
		
		if(way.curv==2){
			
			if (way.y0 == way.y1) {
				if (way.x0 > way.x1) {
					for(int i=way.x1; i<way.x0+1; i++){
						gameButtons[(i*14)+way.y1].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.x0; i<way.x1+1; i++){
						gameButtons[(i*14)+way.y1].setBackground(Color.BLUE);
					}
				}
				
				if (way.y1 > way.y2) {
					for(int i=way.y2; i<way.y1+1; i++){
						gameButtons[(way.x1*14)+i].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.y1; i<way.y2+1; i++){
						gameButtons[(way.x1*14)+i].setBackground(Color.BLUE);
					}
				}

				if (way.x2 > way.x3) {
					for(int i=way.x3; i<way.x2+1; i++){
						gameButtons[(i*14)+way.y2].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.x2; i<way.x3+1; i++){
						gameButtons[(i*14)+way.y2].setBackground(Color.BLUE);
					}
				}
				return;
			}
			else if (way.x0 == way.x1) {
				if (way.y0 > way.y1) {
					for(int i=way.y1; i<way.y0+1; i++){
						gameButtons[(way.x0*14)+i].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.y0; i<way.y1+1; i++){
						gameButtons[(way.x0*14)+i].setBackground(Color.BLUE);
					}
				}
				

				if (way.x1 > way.x2) {
					for(int i=way.x2; i<way.x1+1; i++){
						gameButtons[(i*14)+way.y1].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.x1; i<way.x2+1; i++){
						gameButtons[(i*14)+way.y1].setBackground(Color.BLUE);
					}
				}
				
				if (way.y2 > way.y3) {
					for(int i=way.y3; i<way.y2+1; i++){
						gameButtons[(way.x2*14)+i].setBackground(Color.BLUE);
					}
				}
				else {
					for(int i=way.y2; i<way.y3+1; i++){
						gameButtons[(way.x2*14)+i].setBackground(Color.BLUE);
					}
				}
				return;
			}
		}
		
	}

	public void finishCheck(){
		switch(nLevel){
		case 1: if(nYourScore==48){clearGame(1,2);}break;
		case 2: if(nYourScore==72){clearGame(2,3);}break;
		case 3: if(nYourScore==120){clearGame(3,4);}break;
		case 4: if(nYourScore==160){clearGame(4,5);}break;
		case 5: if(nYourScore==216){clearGame(5,1);}break;
		default: break;
		}
	}

	public void clearGame(int Level, int nextLevel){
		stop();
		SoundPlayer.playApplause();
		JOptionPane.showMessageDialog(null, "Level "+Level+" Clear!\nTime: "+diff/60000+":"+dfsc.format((diff%60000)/1000)+"."+dfms.format(diff%1000));
		registerScore(Level);
		setLevel(nextLevel);
		combo.setSelectedIndex(nextLevel-1);
		onReady();
	}
	
	public void registerScore(int Level){
		String name = JOptionPane.showInputDialog("What is your name?");
		switch(Level){
		case 1: scoreTreeMapLv1.put(diff, name);
				scoreform.setScoreListLv1(scoreTreeMapLv1);
				break;
		case 2: scoreTreeMapLv2.put(diff, name);
				scoreform.setScoreListLv2(scoreTreeMapLv2);
				break;
		case 3: scoreTreeMapLv3.put(diff, name);
				scoreform.setScoreListLv3(scoreTreeMapLv3);
				break;
		case 4: scoreTreeMapLv4.put(diff, name);
				scoreform.setScoreListLv4(scoreTreeMapLv4);	
				break;
		case 5: scoreTreeMapLv5.put(diff, name);
				scoreform.setScoreListLv5(scoreTreeMapLv5);
				break;
		default:
				break;
		}
	}

	private class GameButtonsHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			System.out.println("*****GameButtonsHandler*****");
			int i=0;
			for(JButton bt : gameButtons){
				if(e.getSource()==bt){
					System.out.println(i+" Button");
					nCol=(i/14);
					nRow=(i%14);
					System.out.println(nCol+","+nRow);
					break;
				}
				i++;
			}
			
			for(JButton bt: gameButtons){
				if(!bt.isEnabled()){
					bt.setBackground(Color.ORANGE);
				}
				else if(bt.isEnabled()){
					bt.setBackground(Color.ORANGE);
				}
			}

			select1.setBackground(Color.GREEN);
	
			if (!bSelected) {
				select1.setBackground(Color.ORANGE);
				select2.setBackground(Color.ORANGE);
				select1=(JButton)e.getSource();
				select1.setBackground(Color.GREEN);
				if (OX[nRow][nCol] > -1) {
					System.out.println("*First Select");
					bSelected = true;
					nSlctCol = nCol;
					nSlctRow = nRow;
				}
				System.out.println();
			}
			else {
				System.out.println("*Second Select");
				System.out.println();
				System.out.println("*****Progress*****");
				select2=(JButton)e.getSource();
				
				if (nRow == nSlctRow && nCol == nSlctCol) {
					System.out.println("*Fail (Same Button)");
					System.out.println();
					bSelected = true;
					select2=new JButton();
				}
				else {
					if (OX[nSlctRow][nSlctCol] == OX[nRow][nCol]) {
						System.out.println("Same Icon");
						findPath (nSlctCol, nSlctRow, nCol, nRow);
						if (way.curv < 3) {
							bSelected = false;
							System.out.println("*Success");
							System.out.println();
							nYourScore += 2;
							score.setText("              Score: "+nYourScore);
							select1.setBackground(Color.BLUE);
							select1.setEnabled(false);
							select1.setIcon(nullIcon);
							select1.setBorderPainted(false);
							select2.setBackground(Color.BLUE);
							select2.setEnabled(false);
							select2.setIcon(nullIcon);
							select2.setBorderPainted(false);
							select1=new JButton();
							select2=new JButton();
							SoundPlayer.playPew();
							OX[nSlctRow][nSlctCol] = -1;
							OX[nRow][nCol] = -1;
							drawPath();
							finishCheck();
						}
						else {
							bSelected = false;
							System.out.println("*Fail (No Path)");
							System.out.println();
							SoundPlayer.playError();
							select1.setBackground(Color.RED);
							select2.setBackground(Color.RED);
						}
					}
					else {
						System.out.println("*Fail (Different Icon)");
						System.out.println();
						bSelected = false;		
						SoundPlayer.playError();
						select1.setBackground(Color.RED);
						select2.setBackground(Color.RED);
					}
				}
			}
			way = new Way();

            for (int[] aOX : OX) {
                for (int j = 0; j < aOX.length; j++) {
                    System.out.print(aOX[j] + "\t");
                }
                System.out.println();
            }
			
			System.gc();
		}
		
	}

	private class StartButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
            for (int[] aOX : OX) {
                for (int anAOX : aOX) System.out.print(anAOX + "\t");
                System.out.println();
            }

			int i=0;
			for(JButton bt : gameButtons){
				nCol=(i/14);
				nRow=(i%14);
				if(OX[nRow][nCol]!=-1) bt.setEnabled(true);
				i++;
			}
			onStart();
			start();
			SoundPlayer.playIntro();
		} 
	}

	private class ResetButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setLevel(nLevel);
			isPause=false;
			stop();
			onReady();
		} 
	}

	private class ShuffleButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int rows=COL_CNT+2;
			int cols=ROW_CNT+2;
			
			int temp;

			for(int row=0; row<rows; row++){
				for(int col=0; col<cols; col++){
					if(OX[col][row]!=-1){
						for(int row2=row; row2<rows; row2++){
							for(int col2=col; col2<cols; col2++){
								if(OX[col2][row2]!=-1){
									temp=OX[col2][row2];
									OX[col2][row2]=OX[col][row];
									OX[col][row]=temp;
								}
							}
						}
					}
				} //end of for
			} //end of for 

			bSelected=false;
			select1=new JButton();
			select2=new JButton();
			remake_button(COL_CNT+2,ROW_CNT+2);
			System.gc();
		}
	}

	private class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			stop();
			JOptionPane.showMessageDialog(null, "Bye!!");
			System.gc();
			System.exit(0);
		} 
	} 

	private class PaushButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int nCol;
			int nRow;
			if(!isPause){
				int i=0;
				for(JButton bt : gameButtons){
					nCol=(i/14);
					nRow=(i%14);
					if(OX[nRow][nCol]!=-1){
						bt.setEnabled(false);
					}
					i++;
				}
				stop();
				isPause=true;
				SaveMillis = diff;
				onPause();
			}
			else {
				int i=0;
				for(JButton bt : gameButtons){
					nCol=(i/14);
					nRow=(i%14);
					if(OX[nRow][nCol]!=-1){
						bt.setEnabled(true);
					}
					i++;
				}
				start();
				isPause=false;
				onUnPause();
			}
		} 
	} 

	private class ScoreButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{		
			if(isScoreFramePopUp){
				isScoreFramePopUp=false;
			}
			else {
				scoreform.setVisible(true);
				scoreform.updateForm();
				isScoreFramePopUp=true;
			}

		}
	} 

	private class ComboBoxHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String comboBoxString = combo.getSelectedItem().toString();
			int g_size=Integer.parseInt(comboBoxString.substring(0, 1)); 
			setLevel(g_size);
		} 
	} 

	public void start(){
		thread = new Thread(this);
		StartMillis=Calendar.getInstance().getTimeInMillis();
		ThreadControl=true;
		thread.start();
	}

	public void stop(){
		ThreadControl=false;
	}

	@Override
	public void run() {
		System.out.println("run");
		while(ThreadControl){
			updateTime();
			if(diff>300000){
				timeOver();
				break;
			}
		}
	}

	public void updateTime(){
		try{
            long nowMillis = Calendar.getInstance().getTimeInMillis();
			diff= nowMillis -StartMillis;
			diff+=SaveMillis;
			time.setText("Time: "+diff/60000+":"+dfsc.format((diff%60000)/1000)+"."+dfms.format(diff%1000));
			northPanel.updateUI();
			Thread.sleep(33);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}// end of myForm
