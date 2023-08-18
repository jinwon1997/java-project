package teamprj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class findid extends JFrame implements ActionListener{
	
	LoginHome lf;
	JLabel lbl1, lbl2;
	JTextArea ta1, ta2;
	JButton btn1, btn2;
	DialogBox err1;
	
	public findid() {
		setTitle("아이디 찾기");
		setBounds(100, 100, 404, 314);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lbl1 = new JLabel("이름 입력");
		lbl1.setBounds(12, 52, 57, 15);
		getContentPane().add(lbl1);
		
		lbl2 = new JLabel("주민번호 입력");
		lbl2.setBounds(12, 100, 97, 19);
		getContentPane().add(lbl2);
		
		ta1 = new JTextArea();
		ta1.setBounds(147, 47, 196, 24);
		getContentPane().add(ta1);
		
		ta2 = new JTextArea();
		ta2.setBounds(147, 95, 196, 24);
		getContentPane().add(ta2);
		
		btn1 = new JButton("확인");
		btn1.setBounds(61, 228, 97, 23);
		getContentPane().add(btn1);
		
		btn2 = new JButton("취소");
		btn2.setBounds(187, 228, 97, 23);
		getContentPane().add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		setResizable(false);
		setVisible(true);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn1) {
			if (1==2 && 2==3) {
				lf = new LoginHome();
				lf.setLocation(getX(),getY());
				dispose();
			}else {
				err1 = new DialogBox(this, "올바르지 않은 정보입니다.","알림");
			}
		}else if (obj == btn2) {
			lf = new LoginHome();
			lf.setLocation(getX(),getY());
			dispose();
		}
	}
	
	public static void main(String[] args) {
		new findid();
	}
}
