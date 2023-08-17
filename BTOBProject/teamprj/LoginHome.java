package teamprj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import member.MemberBean;
import member.MemberMgr;
import member.ZipcodeFrame;

public class LoginHome extends JFrame implements ActionListener{
		
		JLabel la1, la2;
		TextField tf1, tf2;
		JButton btn1, btn2, btn3, btn4;
		ImageIcon fristimage;
		CreateMember cm;
		Vector<MemberBean> vlist;
		DialogBox err1; 
		findid fid;
		findpassword fpd;
		
		MemberMgr mgr;
		int num;
		
	public LoginHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("BTOB");
		
		fristimage = new ImageIcon("teamprj/main.jpg");
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fristimage.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 1200, 600);
		add(panel);
		
		panel.add(la1 = new JLabel("ID"));  // layout�� null�� �༭ ũ��� ��ġ�� �����ؾ� ����
		panel.add(tf1 = new TextField("",10));
		panel.add(la2 = new JLabel("��й�ȣ"));
		panel.add(tf2 = new TextField("",20));
		tf2.setEchoChar('��');
		
		la1.setBounds(300, 500, 20, 30);
		tf1.setBounds(330, 500, 90, 30);
		la2.setBounds(430, 500, 60, 30);
		tf2.setBounds(490, 500, 90, 30);
		
		panel.add(btn1 = new JButton("�α���"));
		panel.add(btn2 = new JButton("ȸ������"));
		panel.add(btn3 = new JButton("���̵� ã��"));
		panel.add(btn4 = new JButton("��й�ȣ ã��"));
		
		btn1.setBounds(630, 500, 100, 30);
		btn2.setBounds(740, 500, 100, 30);
		btn3.setBounds(850, 500, 100, 30);
		btn4.setBounds(960, 500, 100, 30);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		setSize(1200, 600);
		setVisible(true);
		setResizable(false);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btn1/*�α����ϱ�*/) {
			String id = tf1.getText();
			String pw = tf2.getText();
			if (id == "aaa") {
				setVisible(false);
			}else {
				DialogBox err1 = new DialogBox(this, "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.","�˸�");
			}
			
		}else if(obj==btn2/*ȸ������*/) {
			if (cm==null) {
				cm = new CreateMember();
				cm.setLocation(getX(),getY());
				dispose();
			}
		}else if(obj==btn3/*���̵� ã��*/) {
			if (fid==null) {
				fid = new findid();
				fid.setLocation(getX(),getY());
				dispose();
			}
		}else if(obj==btn4/*��й�ȣ ã��*/) {
			if (fpd==null) {
				fpd = new findpassword();
				fpd.setLocation(getX(),getY());
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		new LoginHome();
	}
}
