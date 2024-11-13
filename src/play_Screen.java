import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class play_Screen extends JFrame implements ActionListener {
	JButton[][] button;
	JButton[][] button1;
	JButton[] click;
	JButton startButton = new JButton("게임시작");
	JButton resetButton = new JButton("게임포기");
	static String value;
	int sum = 0;
	boolean started = false;
	int N, K;
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	Sudoku db1;
	Sudoku_1 sudoku;
	Sudoku_DB db2;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);

	Timer timer = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			elapsedTime = elapsedTime + 1000;
			hours = (elapsedTime / 3600000);
			minutes = (elapsedTime / 60000) % 60;
			seconds = (elapsedTime / 1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

		}

	});
	
	public play_Screen(String s) {
		Sudoku_DB dbst = Sudoku_DB();
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout(20, 20));

		JPanel Button_Panel = new JPanel(new GridLayout(9, 9));
		JPanel Click_Panel = new JPanel(new GridLayout(11, 1));
		JPanel Time_Panel = new JPanel(new GridLayout(3,2));
		button = new JButton[9][9];
		click = new JButton[11];
		if(s.equals("초급"))
			N = 9; K = 20;
		if(s.equals("중급"))
			N = 9; K = 30;
		if(s.equals("상급"))
			N = 9; K = 30;
        sudoku = new Sudoku_1(N, K);
        
        int [][]array = sudoku.pirntSudoku();
//        button1 = sudoku.pirntSudoku();
//		ct.add(button1[1][1], BorderLayout.AFTER_LAST_LINE);
//		System.out.println(button1[1][1].getText());
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				button[i][j] = new JButton("");
				Button_Panel.add(button[i][j]);
				button[i][j].addActionListener(new ActionListener() {				
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton jb = (JButton) e.getSource();
						
						jb.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								for(int i = 0; i < 9; i++) {
									for(int j = 0; j < 9; j++) {
										if((i*65 + 7) == jb.getX() && (j*54) == jb.getY()) {
											if(array[i][j] != Integer.parseInt(value)) {
												jb.setBackground(Color.red);
												sum++;
											}												
											jb.setText(value);
											if(sum > 3) System.exit(0);
										}
									}
								}								
							}							
						});
					}
				});
			}
		}
		
		for (int i = 0; i < 9; i++) {
			click[i] = new JButton("" + (i + 1));
			Click_Panel.add(click[i]);
			click[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton jb = (JButton) e.getSource();
					
					value = jb.isEnabled() ? jb.getText() : "0";
				}
			});
		}
		
		click[9] = new JButton("X");
		Click_Panel.add(click[9]);
		click[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton jb = (JButton) e.getSource();
				value = jb.isEnabled() ? "" : "0";
			}
		});
		
		click[10] = new JButton("?");
		Click_Panel.add(click[10]);
		click[10].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton jb = (JButton) e.getSource();
				value = jb.isEnabled() ? "?" : "0";
			}
		});

		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		timeLabel.setBounds(100, 100, 200, 100);
		timeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(100, 200, 100, 50);
		startButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);

		Time_Panel.add(timeLabel);
		Time_Panel.add(startButton);
		
		Button_Panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		Click_Panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
		
		ct.add(Time_Panel,BorderLayout.BEFORE_FIRST_LINE);
		ct.add(Button_Panel, BorderLayout.CENTER);
		ct.add(Click_Panel, BorderLayout.EAST);

		setTitle("로그인 화면");
		setSize(700, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		
	}
	void start() {
		timer.start();
	}

	void stop() {
		timer.stop();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			// st가 스도쿠화면띄우기(
			if (started == false) {
				started = true;
				sudoku.fillValues();
		        int a[][] = sudoku.quiz_printSudoku();
		        for(int i = 0; i < 9; i++) {
		        	for(int j = 0; j < 9; j++) {
		        		button[i][j].setText(""+a[i][j]);
				        if (button[i][j].getText().equals(""+0))
				        	button[i][j].setText("");				 
				        else button[i][j].setEnabled(false);

		        	}
		        }
				startButton.setText("게임포기");
				start();
			} else if (started) {
				started = false;
				int n = JOptionPane.showConfirmDialog(this, "정말 게임을 포기하시겠습니까?", "게임포기 유무", JOptionPane.YES_NO_OPTION);

				if (n == 1) {
					start();
					return;
				} else if (n == 0) {
					dispose();
					new game_Screen();
				}
				stop();
			}

		}
		if(e.getSource() == resetButton) {
			db1.setTimer(timeLabel.getText());
			db2.insertUserRate(db1);
		}
	}

}
