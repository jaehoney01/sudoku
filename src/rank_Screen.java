import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class rank_Screen extends JFrame implements ActionListener{
	Container ct = getContentPane();
	
	JTabbedPane jtp = new JTabbedPane();	
	
	JComboBox<String> select;
	
	JButton Exit = new JButton("³ª°¡±â");

	public rank_Screen() {
		ct.setLayout(new BorderLayout());
		
		Exit.addActionListener(this);
		
		jtp.addTab("ÃÊ±Þ", new Easy());
		jtp.addTab("Áß±Þ", new Normal());
		jtp.addTab("°í±Þ", new Hard());
		ct.add(jtp, BorderLayout.NORTH);
		ct.add(Exit, BorderLayout.SOUTH);
		setTitle("·©Å· º¸±â");
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Exit) {
			dispose();
		}
	}

}

class Easy extends JPanel implements ItemListener {
	
	JTable E_Table;
	
	JComboBox<String> E_Combo;
	JScrollPane js;
	public Easy() {
		setLayout(new BorderLayout());
		
		E_Combo = new JComboBox<String>();
		E_Combo.addItem("½Â·ü");
		E_Combo.addItem("ÆÇ¼ö");
		E_Combo.addItem("½Ã°£");
		
		E_Combo.addItemListener(this);
		
		add(E_Combo, BorderLayout.NORTH);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(E_Combo.getSelectedItem().equals("½Â·ü")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
			String [][]b = {{"1","ÃÊ","±Þ"},
                    {"2","½Â","·ü"},
                    {"3","½¦","¸®"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			E_Table = new JTable(model);
			js = new JScrollPane(E_Table);			
			add(js);
		}
		else if(E_Combo.getSelectedItem().equals("ÆÇ¼ö")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
			String [][]b = {{"1","ÃÊ","±Þ"},
                    {"2","ÆÇ","¼ö"},
                    {"3","½¦","¸®"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			E_Table = new JTable(model);
			js = new JScrollPane(E_Table);
			add(js);
		}
		else if(E_Combo.getSelectedItem().equals("½Ã°£")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
			String [][]b = {{"1","ÃÊ","±Þ"},
                    {"2","½Ã","°£"},
                    {"3","½¦","¸®"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			E_Table = new JTable(model);
			js = new JScrollPane(E_Table);
			add(js);
		}
		
		
	}
}

class Normal extends JPanel implements ItemListener {
	
	JTable N_Table;
	
	JComboBox<String> N_Combo;
	JScrollPane js;
	public Normal() {
		setLayout(new BorderLayout());
		String s = "ÃÊ±Þ";
		N_Combo = new JComboBox<String>();
		N_Combo.addItem("½Â·ü");
		N_Combo.addItem("ÆÇ¼ö");
		N_Combo.addItem("½Ã°£");
		
		N_Combo.addItemListener(this);
		
		add(N_Combo, BorderLayout.NORTH);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(N_Combo.getSelectedItem().equals("½Â·ü")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
	        String [][]b = {{"1","±Þ","ÀÎ"},
	                        {"2","½Â","·ü"},
	                        {"3","Áß","¾Æ"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			N_Table = new JTable(model);
			js = new JScrollPane(N_Table);			
			add(js);
		}
		else if(N_Combo.getSelectedItem().equals("ÆÇ¼ö")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
	        String [][]b = {{"1","±Þ","ÀÎ"},
	                        {"2","ÆÇ","¼ö"},
	                        {"3","Áß","¾Æ"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			N_Table = new JTable(model);
			js = new JScrollPane(N_Table);
			add(js);
		}
		else if(N_Combo.getSelectedItem().equals("½Ã°£")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
	        String [][]b = {{"1","±Þ","ÀÎ"},
	                        {"2","½Ã","°£"},
	                        {"3","Áß","¾Æ"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			N_Table = new JTable(model);
			js = new JScrollPane(N_Table);
			add(js);
		}
		
		
	}
}
class Hard extends JPanel implements ItemListener {
	
	JTable H_Table;
	
	JComboBox<String> H_Combo;
	JScrollPane js;
	public Hard() {
		setLayout(new BorderLayout());
		
		H_Combo = new JComboBox<String>();
		H_Combo.addItem("½Â·ü");
		H_Combo.addItem("ÆÇ¼ö");
		H_Combo.addItem("½Ã°£");
		
		H_Combo.addItemListener(this);
		
		add(H_Combo, BorderLayout.NORTH);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(H_Combo.getSelectedItem().equals("½Â·ü")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
			String [][]b = {{"1","°í","±Þ"},
                    {"2","½Â","·ü"},
                    {"3","°í","±Þ"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			H_Table = new JTable(model);
			js = new JScrollPane(H_Table);			
			add(js);
		}
		else if(H_Combo.getSelectedItem().equals("ÆÇ¼ö")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
			String [][]b = {{"1","°í","±Þ"},
                    {"2","ÆÇ","¼ö"},
                    {"3","°í","±Þ"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			H_Table = new JTable(model);
			js = new JScrollPane(H_Table);
			add(js);
		}
		else if(H_Combo.getSelectedItem().equals("½Ã°£")) {
			String []a = {"¼øÀ§","½Â·ü","?"};
			String [][]b = {{"1","°í","±Þ"},
                    {"2","½Ã","°£"},
                    {"3","°í","±Þ"}};
	        
			DefaultTableModel model = new DefaultTableModel(b,a);
			H_Table = new JTable(model);
			js = new JScrollPane(H_Table);
			add(js);
		}
	}
}