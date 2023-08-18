package teamprj;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import member.MemberBean;
import member.MemberMgr;

public class CreateMember extends JFrame
implements ActionListener{

	JButton btn1, btn2, btn3;
	LoginHome lf;
	DialogBox err1, err2;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	Vector<localBean> vlist;
	Choice ch;
	LocalMgr mgr;
	JRadioButton gender1, gender2;
	ButtonGroup gender;
	JLabel itf1, itf2, itf3, itf4, itf5, itf5_2, itf6, itf7, logo;
	
	public CreateMember() {
		setSize(1000,1000);
		setTitle("회원가입");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setFont(new Font("궁서체", Font.BOLD, 12));
		setBounds(100, 100, 471, 466);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		mgr = new LocalMgr();
		btn1 = new JButton("아이디 중복 확인");
		
		btn1.setBounds(289, 57, 150, 23);
		getContentPane().add(btn1);
		
		tf1 = new JTextField();
		tf1.setBounds(131, 57, 146, 21);
		getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(131, 91, 146, 21);
		tf2.setColumns(10);
		getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setBounds(131, 132, 146, 21);
		tf3.setColumns(10);
		getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setBounds(131, 165, 146, 21);
		tf4.setColumns(10);
		getContentPane().add(tf4);
		
		ch = new Choice();
		vlist = mgr.getLocalList();
		for (int i = 0; i < vlist.size(); i++) {
			localBean bean = vlist.get(i);
			String str = bean.getLocalName().trim();
			ch.add(str);
		}
		ch.setBounds(131, 204, 146, 21);
		getContentPane().add(ch);
		
		tf5 = new JTextField();
		tf5.setBounds(131, 240, 146, 21);
		tf5.setColumns(10);
		getContentPane().add(tf5);
		
		tf6 = new JTextField();
		tf6.setBounds(131, 280, 146, 21);
		tf6.setColumns(10);
		getContentPane().add(tf6);
		
		btn2 = new JButton("회원가입");
		btn2.setBounds(69, 392, 97, 23);
		getContentPane().add(btn2);
		
		btn3 = new JButton("취소");
		btn3.setBounds(199, 392, 97, 23);
		getContentPane().add(btn3);
		
		gender1 = new JRadioButton("남성");
		gender1.setBackground(new Color(255, 255, 255));
		gender1.setBounds(131, 320, 64, 23);
		gender1.setSelected(true);
		getContentPane().add(gender1);
		
		gender2 = new JRadioButton("여성");
		gender2.setBackground(new Color(255, 255, 255));
		gender2.setBounds(209, 320, 68, 23);
		getContentPane().add(gender2);
		
		gender = new ButtonGroup();
		gender.add(gender1);
		gender.add(gender2);
		
		JLabel itf1 = new JLabel("\uC544\uC774\uB514");
		itf1.setBounds(12, 57, 64, 15);
		getContentPane().add(itf1);
		
		JLabel itf2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		itf2.setBounds(12, 91, 64, 15);
		getContentPane().add(itf2);
		
		JLabel itf3 = new JLabel("\uC774\uB984");
		itf3.setBounds(12, 132, 64, 15);
		getContentPane().add(itf3);
		
		JLabel itf4 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		itf4.setBounds(12, 165, 107, 15);
		getContentPane().add(itf4);
		
		JLabel itf5 = new JLabel("주소");
		itf5.setBounds(12, 204, 64, 15);
		getContentPane().add(itf5);
		
		JLabel itf5_2 = new JLabel("상세주소");
		itf5_2.setBounds(12, 240, 64, 15);
		getContentPane().add(itf5_2);
		
		JLabel itf6 = new JLabel("전화번호");
		itf6.setBounds(12, 280, 64, 15);
		getContentPane().add(itf6);
		
		JLabel itf7 = new JLabel("성별");
		itf7.setBounds(12, 320, 33, 15);
		getContentPane().add(itf7);
		
		JLabel logo = new JLabel("BTOB 피시방 회원가입");
		logo.setForeground(new Color(0, 0, 0));
		logo.setFont(new Font("굴림", Font.PLAIN, 28));
		logo.setBackground(UIManager.getColor("CheckBox.foreground"));
		logo.setBounds(102, 1, 300, 46);
		getContentPane().add(logo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CreateMember.class.getResource("/graphics/potato.jpg")));
		lblNewLabel.setBounds(0, 1, 455, 426);
		getContentPane().add(lblNewLabel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		//////////////////////////////////////
		setResizable(false);
		this.setVisible(true);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btn1) {

		}else if(obj==btn2) {
			if (1==2 && 2==3) {
				lf = new LoginHome();
				dispose();
			}else {
				lf = new LoginHome();
				dispose();
			}
		}else if(obj==btn3) {
			lf = new LoginHome();
			dispose();
		}
	}
	
	public static void main(String[] args) {
		new CreateMember();
	}
}
