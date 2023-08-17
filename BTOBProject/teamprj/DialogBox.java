package teamprj;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


class DialogBox extends JDialog implements ActionListener {
    
	JButton b1;
	CreateMember cp;
	LoginHome lh;
	findid fid;
	findpassword fpd;
    
    DialogBox(CreateMember cp,String name,String title) {
        super(cp, true);
        this.cp = cp;
        setTitle(title);
        // 메시지 출력
        add(new JLabel(name, JLabel.CENTER));
        
        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());
        add(pan, BorderLayout.SOUTH);

        b1 = new JButton("확인");
        pan.add(b1);
        b1.addActionListener(this);
        	
        setSize(300, 150);
        setLocationRelativeTo(cp);
        setVisible(true);
    }
    
    DialogBox(LoginHome lh,String name,String title) {
        super(lh, true);
        this.lh = lh;
        setTitle(title);
        // 메시지 출력
        add(new JLabel(name, JLabel.CENTER));
        
        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());
        add(pan, BorderLayout.SOUTH);

        b1 = new JButton("확인");
        pan.add(b1);
        b1.addActionListener(this);
        	
        setSize(300, 150);
        setLocationRelativeTo(lh);
        setVisible(true);
    }
    
    DialogBox(findpassword fpd,String name,String title) {
        super(fpd, true);
        this.fpd = fpd;
        setTitle(title);
        // 메시지 출력
        add(new JLabel(name, JLabel.CENTER));
        
        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());
        add(pan, BorderLayout.SOUTH);

        b1 = new JButton("확인");
        pan.add(b1);
        b1.addActionListener(this);
        	
        setSize(300, 150);
        setLocationRelativeTo(lh);
        setVisible(true);
    }
    
    DialogBox(findid fid,String name,String title) {
        super(fid, true);
        this.fid = fid;
        setTitle(title);
        // 메시지 출력
        add(new JLabel(name, JLabel.CENTER));
        
        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());
        add(pan, BorderLayout.SOUTH);

        b1 = new JButton("확인");
        pan.add(b1);
        b1.addActionListener(this);
        	
        setSize(300, 150);
        setLocationRelativeTo(lh);
        setVisible(true);
    }


    // 다이얼로그 위의 버튼을 클릭했을 때
    public void actionPerformed(ActionEvent evt) {
        dispose();
    }
}