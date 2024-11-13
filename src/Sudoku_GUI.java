import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

class login_Screen extends JFrame implements ActionListener {
	//컨테이너 생성
	Container ct = getContentPane();
	//라벨 설정
	JLabel Title_Label = new JLabel("SUDOKU");
	JLabel ID_Label = new JLabel("ID :   ");
	JLabel PW_Label = new JLabel("PW :   ");
	//순서대로 제일 위 SUDOKU문구 넣을 패널
	JPanel Title_Panel = new JPanel(new GridLayout(1,1,0,15));
	//ID :, PW : 문구 넣을 패널
	JPanel Label_Panel = new JPanel(new GridLayout(3,1,0,30));
	//ID, PW 입력받을 패널
	JPanel Input_Panel = new JPanel(new GridLayout(3,1,0,30));
	//ID찾기, PW찾기 버튼 패널
	JPanel Search_Panel = new JPanel(new GridLayout(3,1,0,30));
	//로그인, 회원가입 버튼 패널
	JPanel Button_Panel = new JPanel(new GridLayout(1,2,30,15));
	//아이디 비밀번호 입력받을 텍스트필드
	JTextField ID_In = new JTextField(15);
	JTextField PW_In = new JTextField(15);
	//각각의 버튼
	JButton ID_Search = new JButton("ID 찾기");
	JButton PW_Search = new JButton("PW 찾기");
	JButton Login = new JButton("로그인");
	JButton Join = new JButton("회원가입");	
	//로그인 화면 메소드
	public login_Screen() {
		//컨테이너 레이아웃 설정
		ct.setLayout(new BorderLayout());
		//라벨 폰트 설정
		Title_Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		//라벨 가운데 위치
		Title_Label.setHorizontalAlignment(JLabel.CENTER);
		//패널들 여백 조절
		Title_Panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		Label_Panel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
		Input_Panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		Search_Panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		Button_Panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 40, 30));
		//Title패널에 라벨 추가
		Title_Panel.add(Title_Label);
		//라벨 패널에 ID, PW 라벨 추가
		Label_Panel.add(ID_Label);
		Label_Panel.add(PW_Label);
		//패널에 ID, PW 입력하는 텍스트필드 추가		
		Input_Panel.add(ID_In);
		Input_Panel.add(PW_In);
		//패널에 아이디 비번 찾기 버튼 추가
		Search_Panel.add(ID_Search);
		Search_Panel.add(PW_Search);
		//로그인 버튼, 회원가입 버튼 패널에 추가
		Button_Panel.add(Login);
		Button_Panel.add(Join);
		//이벤트 처리
		ID_Search.addActionListener(this);
		PW_Search.addActionListener(this);
		Login.addActionListener(this);
		Join.addActionListener(this);
		//컨테이너에 패널 추가 및 위치 지정
		ct.add(Title_Panel, BorderLayout.NORTH);
		ct.add(Label_Panel, BorderLayout.WEST);
		ct.add(Input_Panel, BorderLayout.CENTER);
		ct.add(Search_Panel, BorderLayout.EAST);
		ct.add(Button_Panel, BorderLayout.SOUTH);
		
		setTitle("로그인 화면");
		setSize(400, 300);		
		setVisible(true);
		//창 듸울 때 가운데로 위치
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//아이디 찾기 버튼이라면
		if (obj == ID_Search) {
			System.out.println("아이디찾기");
		}
		//PW찾기 버튼이라면
		else if (obj == PW_Search) {
			System.out.println("비번찾기");
		}
		//로그인 버튼이라면
		else if (obj == Login) {
			//아이디와 비밀번호를 모두 입력하였는지 확인 후 입력 안되어있으면 입력요청
			if(ID_In.getText().equals("") || PW_In.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 모두 입력해주세요.!!");
			}
			//DB에 저장된 아이디와 비밀번호가 동일한지 확인, 이 경우엔 틀린경우
			else if(ID_In.getText().equals("1") && PW_In.getText().equals("1")) {
				System.out.println();
			}
			//위 조건들이 모두 충족해서 로그인 실행
			else {
				dispose();
				new game_Screen();
			}
				
		}
		//회원가입 버튼 눌렸을 시 회원가입 GUI창 띄우기
		else if (obj == Join) {
			dispose();
			new join_Screen();
		}
	}

}

public class Sudoku_GUI {

	public static void main(String[] args) {
		new play_Screen("상급");
	}

}
