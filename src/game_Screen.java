import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class game_Screen extends JFrame implements ActionListener {
	public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(102,102,102); //πË∞Êªˆ ∞·¡§
	         Color o=new Color(255,255,255); //±€¿⁄ªˆ ∞·¡§
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	
	Container ct = getContentPane();
	String s = "";
	JLabel greet = new JLabel("æ»≥Á«œººø‰! " + s +"¥‘ »Øøµ«’¥œ¥Ÿ.");
	
	JTextArea record;
	
	RoundedButton easy = new RoundedButton(" √  ±ﬁ ");
	RoundedButton normal = new RoundedButton(" ¡ﬂ ±ﬁ ");
	RoundedButton hard = new RoundedButton(" ªÛ ±ﬁ ");
	RoundedButton rank = new RoundedButton("∑©≈∑ ∫∏±‚");
	
	JPanel Label_Panel = new JPanel(new GridLayout(1,1,20,2));
	JPanel Button_Panel = new JPanel(new GridLayout(4,1,0,5));
	JPanel Text_Panel = new JPanel(new GridLayout(1,1,0,2));
	
	public game_Screen() {
		ct.setLayout(new BorderLayout());
		
		record = new JTextArea(2,10);
		record.setText("          ±‚∑œ");
		record.setEditable(false);
		greet.setHorizontalAlignment(JLabel.CENTER);
		greet.setOpaque(true);
		greet.setBackground(Color.WHITE);
		greet.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 30));
		easy.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 40));
		normal.setFont(new Font("∏º¿∫ ∞ÌµÒB", Font.BOLD, 40));
		hard.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 40));
		rank.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 40));
		record.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		
		Label_Panel.add(greet);
		
		Button_Panel.add(easy);
		Button_Panel.add(normal);
		Button_Panel.add(hard);
		Button_Panel.add(rank);
		
		Text_Panel.add(record);
		
		easy.addActionListener(this);
		normal.addActionListener(this);
		hard.addActionListener(this);
		rank.addActionListener(this);
		
		ct.add(Label_Panel, BorderLayout.NORTH);		
		ct.add(Button_Panel, BorderLayout.CENTER);
		ct.add(Text_Panel, BorderLayout.EAST);
		
		setTitle("∞‘¿” ¡ÿ∫Ò »≠∏È");
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == easy) {
			dispose();
			new play_Screen("√ ±ﬁ");
		}
		else if(obj == normal) {
			dispose();
			new play_Screen("¡ﬂ±ﬁ");
		}
		else if(obj == hard) {
			dispose();
			new play_Screen("ªÛ±ﬁ");
		}
		else if(obj == rank) {
			dispose();
			new rank_Screen();
		}
	}
	
}