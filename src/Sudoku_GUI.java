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
	//�����̳� ����
	Container ct = getContentPane();
	//�� ����
	JLabel Title_Label = new JLabel("SUDOKU");
	JLabel ID_Label = new JLabel("ID :   ");
	JLabel PW_Label = new JLabel("PW :   ");
	//������� ���� �� SUDOKU���� ���� �г�
	JPanel Title_Panel = new JPanel(new GridLayout(1,1,0,15));
	//ID :, PW : ���� ���� �г�
	JPanel Label_Panel = new JPanel(new GridLayout(3,1,0,30));
	//ID, PW �Է¹��� �г�
	JPanel Input_Panel = new JPanel(new GridLayout(3,1,0,30));
	//IDã��, PWã�� ��ư �г�
	JPanel Search_Panel = new JPanel(new GridLayout(3,1,0,30));
	//�α���, ȸ������ ��ư �г�
	JPanel Button_Panel = new JPanel(new GridLayout(1,2,30,15));
	//���̵� ��й�ȣ �Է¹��� �ؽ�Ʈ�ʵ�
	JTextField ID_In = new JTextField(15);
	JTextField PW_In = new JTextField(15);
	//������ ��ư
	JButton ID_Search = new JButton("ID ã��");
	JButton PW_Search = new JButton("PW ã��");
	JButton Login = new JButton("�α���");
	JButton Join = new JButton("ȸ������");	
	//�α��� ȭ�� �޼ҵ�
	public login_Screen() {
		//�����̳� ���̾ƿ� ����
		ct.setLayout(new BorderLayout());
		//�� ��Ʈ ����
		Title_Label.setFont(new Font("���� ���", Font.BOLD, 18));
		//�� ��� ��ġ
		Title_Label.setHorizontalAlignment(JLabel.CENTER);
		//�гε� ���� ����
		Title_Panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		Label_Panel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
		Input_Panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		Search_Panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		Button_Panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 40, 30));
		//Title�гο� �� �߰�
		Title_Panel.add(Title_Label);
		//�� �гο� ID, PW �� �߰�
		Label_Panel.add(ID_Label);
		Label_Panel.add(PW_Label);
		//�гο� ID, PW �Է��ϴ� �ؽ�Ʈ�ʵ� �߰�		
		Input_Panel.add(ID_In);
		Input_Panel.add(PW_In);
		//�гο� ���̵� ��� ã�� ��ư �߰�
		Search_Panel.add(ID_Search);
		Search_Panel.add(PW_Search);
		//�α��� ��ư, ȸ������ ��ư �гο� �߰�
		Button_Panel.add(Login);
		Button_Panel.add(Join);
		//�̺�Ʈ ó��
		ID_Search.addActionListener(this);
		PW_Search.addActionListener(this);
		Login.addActionListener(this);
		Join.addActionListener(this);
		//�����̳ʿ� �г� �߰� �� ��ġ ����
		ct.add(Title_Panel, BorderLayout.NORTH);
		ct.add(Label_Panel, BorderLayout.WEST);
		ct.add(Input_Panel, BorderLayout.CENTER);
		ct.add(Search_Panel, BorderLayout.EAST);
		ct.add(Button_Panel, BorderLayout.SOUTH);
		
		setTitle("�α��� ȭ��");
		setSize(400, 300);		
		setVisible(true);
		//â ��� �� ����� ��ġ
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//���̵� ã�� ��ư�̶��
		if (obj == ID_Search) {
			System.out.println("���̵�ã��");
		}
		//PWã�� ��ư�̶��
		else if (obj == PW_Search) {
			System.out.println("���ã��");
		}
		//�α��� ��ư�̶��
		else if (obj == Login) {
			//���̵�� ��й�ȣ�� ��� �Է��Ͽ����� Ȯ�� �� �Է� �ȵǾ������� �Է¿�û
			if(ID_In.getText().equals("") || PW_In.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "���̵�� ��й�ȣ�� ��� �Է����ּ���.!!");
			}
			//DB�� ����� ���̵�� ��й�ȣ�� �������� Ȯ��, �� ��쿣 Ʋ�����
			else if(ID_In.getText().equals("1") && PW_In.getText().equals("1")) {
				System.out.println();
			}
			//�� ���ǵ��� ��� �����ؼ� �α��� ����
			else {
				dispose();
				new game_Screen();
			}
				
		}
		//ȸ������ ��ư ������ �� ȸ������ GUIâ ����
		else if (obj == Join) {
			dispose();
			new join_Screen();
		}
	}

}

public class Sudoku_GUI {

	public static void main(String[] args) {
		new play_Screen("���");
	}

}
