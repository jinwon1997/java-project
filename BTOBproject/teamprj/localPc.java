package teamprj;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTextField;

import member.MemberBean;
import member.ZipcodeBean;

public class localPc extends MFrame implements ActionListener{
	
	Vector<localBean> vlist;
	Choice ch;
	LocalMgr mgr;
	JPanel jp;
	JTextField jt;
	
	public localPc() {
		super(300,500);
		setTitle("Local Pc");
		mgr = new LocalMgr();
		jp = new JPanel();
		ch = new Choice();
		vlist = mgr.getLocalList();
		jp.setBackground(Color.GRAY);
		for (int i = 0; i < vlist.size(); i++) {
			localBean bean = vlist.get(i);
			String str = bean.getLocalName().trim();
			ch.add(str);
		}
		jt = new JTextField("",10);
		jp.add(ch);
		jp.add(jt);
		add(jp,BorderLayout.NORTH);
		TextArea ta = new TextArea();
		add(ta);
		setVisible(true);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	
	public static void main(String[] args) {
		new localPc();
	}
}
