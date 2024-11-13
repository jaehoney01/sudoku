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
	
	JLabel Title_Label = new JLabel("ȸ �� �� ��");
	JLabel ID_Label = new JLabel("���̵�:      ");
	JLabel NickName_Label = new JLabel("�г���:      ");
	JLabel PW_Label = new JLabel("��й�ȣ:     ");
	JLabel CheckPW_Label = new JLabel("��й�ȣ ��Ȯ��:");
	JLabel Email_Label = new JLabel("�̸���:      ");
	JLabel EmailCheck_Label = new JLabel("������ȣ:      ");
//	JLabel jl6 = new JLabel("����Ͻ� �г����� �Է����ּ���.");
//	JLabel jl7 = new JLabel("��й�ȣ�� �Է����ּ���.");
//	JLabel jl8 = new JLabel("��й�ȣ�� �ٽ� �ѹ� �Է����ּ���.");
	
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
	
	JButton ID_Overlap =  new JButton("�ߺ�Ȯ��");
	JButton NickName_Overlap =  new JButton("�ߺ�Ȯ��");
	JButton Email_Overlap =  new JButton("�����ϱ�");
	JButton t1 = new JButton();
	JButton t2 = new JButton();
	
	JButton Check = new JButton("Ȯ��");
	JButton New_In = new JButton("���� �Է�");
	
	public join_Screen() {
		ct.setLayout(new BorderLayout(20,20));
		PW_In.selectAll();
		
		t1.setBackground(new Color(238,238,238));
		t1.setBorderPainted(false);
		t2.setBackground(new Color(238,238,238));
		t2.setBorderPainted(false);
		
		
		Title_Label.setFont(new Font("���� ���", Font.BOLD, 20));
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
		
		setTitle("ȸ������ ȭ��");
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		int n;
		//�̹� ���̵� �г����� ������쿡
		//showInputDialog() �̿��ؼ� ���Է¹ޱ�
		
		//���̵� �ߺ�Ȯ�� ��ư
		if (obj == ID_Overlap) {
			//������ 0, ��� 1 ��ȯ
			n = JOptionPane.showConfirmDialog(this, "��� ������ ���̵��Դϴ�.\n����Ͻðڽ��ϱ�?", "���̵� �ߺ�����", JOptionPane.YES_NO_OPTION);
			//�� ������ ���
			if(n == 0) {
				System.out.println("���̵� ����");
			}
			//�ƴϿ� ������ ���
			else {
				JOptionPane.showMessageDialog(this, "���̵� �ٽ� �Է����ּ���.!!");
				ID_In.setText("");
			}
		}
		//�г��� �ߺ�Ȯ�� ��ư
		else if (obj == NickName_Overlap) {
			//������ 0, ��� 1 ��ȯ
			n = JOptionPane.showConfirmDialog(this, "��� ������ �г����Դϴ�.\n����Ͻðڽ��ϱ�?", "���̵� �ߺ�����", JOptionPane.YES_NO_OPTION);
			//�� ������ ���
			if(n == 0) {
				System.out.println("�г��� ����");
			}
			//�ƴϿ� ������ ���
			else {
				JOptionPane.showMessageDialog(this, "�г����� �ٽ� �Է����ּ���.!!");
				NickName_In.setText("");
			}
		}
		//Ȯ�� ��ư
		else if (obj == Check) {
			dispose();
			new login_Screen();
		}
		//���� �Է� ��ư
		else if (obj == New_In) {
			ID_In.setText("");
			NickName_In.setText("");
			PW_In.setText("");
			CheckPW_In.setText("");
		}
	}
}