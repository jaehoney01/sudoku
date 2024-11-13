import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class join_Screen extends JFrame implements ActionListener {
	Container ct = getContentPane();
	
	JLabel Title_Label = new JLabel("회 원 가 입");
	JLabel ID_Label = new JLabel("아이디:      ");
	JLabel NickName_Label = new JLabel("닉네임:      ");
	JLabel PW_Label = new JLabel("비밀번호:     ");
	JLabel CheckPW_Label = new JLabel("비밀번호 재확인:");
	JLabel Email_Label = new JLabel("이메일:      ");
	JLabel EmailCheck_Label = new JLabel("인증번호:      ");
//	JLabel jl6 = new JLabel("사용하실 닉네임을 입력해주세요.");
//	JLabel jl7 = new JLabel("비밀번호를 입력해주세요.");
//	JLabel jl8 = new JLabel("비밀번호를 다시 한번 입력해주세요.");
	
	JPanel Label_Panel = new JPanel(new GridLayout(0,1,0,2));
	JPanel Text_Panel = new JPanel(new GridLayout(6,1,0,15));
	JPanel Input_Panel = new JPanel(new GridLayout(6,1,0,15));
	JPanel Check_Panel = new JPanel(new GridLayout(6,1,0,15));
	JPanel Button_Panel = new JPanel(new GridLayout(1,2,20,20));	
	
	JTextField ID_In = new JTextField();
	JTextField NickName_In = new JTextField();
	JTextField PW_In = new JTextField();
	JTextField CheckPW_In = new JTextField();
	JTextField Email_In = new JTextField();
	JTextField EmailCheck_In = new JTextField();
	
	JButton ID_Overlap =  new JButton("중복확인");
	JButton NickName_Overlap =  new JButton("중복확인");
	JButton Email_Overlap =  new JButton("인증하기");
	JButton t1 = new JButton();
	JButton t2 = new JButton();
	
	JButton Check = new JButton("확인");
	JButton New_In = new JButton("새로 입력");
	
	public join_Screen() {
		ct.setLayout(new BorderLayout(20,20));
		PW_In.selectAll();
		
		t1.setBackground(new Color(238,238,238));
		t1.setBorderPainted(false);
		t2.setBackground(new Color(238,238,238));
		t2.setBorderPainted(false);
		
		
		Title_Label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Title_Label.setHorizontalAlignment(JLabel.CENTER);
		
		Label_Panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		Text_Panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
		Button_Panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 40, 20));
		Check_Panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 15, 5));
		
		Label_Panel.add(Title_Label);
		
		Text_Panel.add(ID_Label);
		Text_Panel.add(NickName_Label);
		Text_Panel.add(PW_Label);
		Text_Panel.add(CheckPW_Label);
		Text_Panel.add(Email_Label);
		Text_Panel.add(EmailCheck_Label);
		
		Input_Panel.add(ID_In);
		Input_Panel.add(NickName_In);
		Input_Panel.add(PW_In);
		Input_Panel.add(CheckPW_In);
		Input_Panel.add(Email_In);
		Input_Panel.add(EmailCheck_In);
		
		Check_Panel.add(ID_Overlap);
		Check_Panel.add(NickName_Overlap);
		Check_Panel.add(t1);
		Check_Panel.add(t2);
		Check_Panel.add(Email_Overlap);
		
		Button_Panel.add(Check);
		Button_Panel.add(New_In);
		
		ID_Overlap.addActionListener(this);
		NickName_Overlap.addActionListener(this);
		Email_Overlap.addActionListener(this);
		Check.addActionListener(this);
		New_In.addActionListener(this);
		
		ct.add(Label_Panel, BorderLayout.NORTH);
		ct.add(Text_Panel, BorderLayout.WEST);
		ct.add(Input_Panel, BorderLayout.CENTER);
		ct.add(Check_Panel, BorderLayout.EAST);
		ct.add(Button_Panel, BorderLayout.SOUTH);
		
		setTitle("회원가입 화면");
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		int n;
		//이미 아이디나 닉네임이 있을경우에
		//showInputDialog() 이용해서 재입력받기
		
		//아이디 중복확인 버튼
		if (obj == ID_Overlap) {
			//예스면 0, 노면 1 반환
			n = JOptionPane.showConfirmDialog(this, "사용 가능한 아이디입니다.\n사용하시겠습니까?", "아이디 중복여부", JOptionPane.YES_NO_OPTION);
			//예 눌렸을 경우
			if(n == 0) {
				System.out.println("아이디 선택");
			}
			//아니오 눌렸을 경우
			else {
				JOptionPane.showMessageDialog(this, "아이디를 다시 입력해주세요.!!");
				ID_In.setText("");
			}
		}
		//닉네임 중복확인 버튼
		else if (obj == NickName_Overlap) {
			//예스면 0, 노면 1 반환
			n = JOptionPane.showConfirmDialog(this, "사용 가능한 닉네임입니다.\n사용하시겠습니까?", "아이디 중복여부", JOptionPane.YES_NO_OPTION);
			//예 눌렸을 경우
			if(n == 0) {
				System.out.println("닉네임 선택");
			}
			//아니오 눌렸을 경우
			else {
				JOptionPane.showMessageDialog(this, "닉네임을 다시 입력해주세요.!!");
				NickName_In.setText("");
			}
		}
		//확인 버튼
		else if (obj == Check) {
			dispose();
			new login_Screen();
		}
		//새로 입력 버튼
		else if (obj == New_In) {
			ID_In.setText("");
			NickName_In.setText("");
			PW_In.setText("");
			CheckPW_In.setText("");
		}
	}
}