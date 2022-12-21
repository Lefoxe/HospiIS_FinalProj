import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login{

	static JFrame mfrm = new JFrame();
	static JFrame frm = new JFrame();
	JPanel pnl = new JPanel();
	JPanel pnl2 = new JPanel();
	JPanel pnl3 = new JPanel();
	JPanel pnl4 = new JPanel();
	ImageIcon image = new ImageIcon("logo.png");
	ImageIcon bg = new ImageIcon("BG.jpg");


	Font f = new Font("Sergoe UI", Font.BOLD, 48);
	Font f2 = new Font("Sergoe UI", Font.PLAIN, 14);
	Font f3 = new Font("Sergoe UI", Font.BOLD, 14);

	JLabel back = new JLabel();
	JLabel title = new JLabel("Tamago Hospital");
	JLabel usr =  new JLabel("Username: ");
	JLabel pass = new JLabel("Password: ");
	JLabel message = new JLabel();

	JButton log = new JButton("Login");
	JButton clr = new JButton("Clear");
	JButton doc = new JButton("Doctor");
	JButton patient = new JButton("Patient");
	JButton close = new JButton("Close");
	JButton logout = new JButton("Logout");

	static JTextField usrField = new JTextField(20);
	static JPasswordField passField = new JPasswordField(20);

	public void activate(){
		Comp();
	}

	private void Comp(){
		back.setIcon(bg);
		back.setSize(388, 388);
		pnl.setBackground(new Color(0xDAF7A6));
		pnl2.setBackground(new Color(0xDAF7A6));
		pnl3.setBackground(new Color(0xDAF7A6));
		pnl4.setBackground(new Color(0xDAF7A6));
		mfrm.setIconImage(image.getImage());
		mfrm.setSize(450, 425);
		mfrm.setLocationRelativeTo(null);
		mfrm.setTitle("TH: Login");
		mfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.setFont(f);
		usr.setFont(f2);
		pass.setFont(f2);
		log.setFont(f2);
		clr.setFont(f2);
		log.setFocusable(false);
		clr.setFocusable(false);
		pnl2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 4));

		pnl.add(title);
		pnl2.add(usr);
		pnl2.add(usrField);
		pnl2.add(pass);
		pnl2.add(passField);
		pnl2.add(log);
		pnl2.add(clr);


		log.addActionListener(new ActionButton1());
		pnl2.add(log);
		clr.addActionListener(new ActionButton1());
		pnl2.add(clr);
		pnl2.add(back);

		mfrm.add(pnl, BorderLayout.NORTH);
		mfrm.add(pnl2, BorderLayout.CENTER);
		mfrm.add(pnl3, BorderLayout.WEST);
		mfrm.add(pnl4, BorderLayout.EAST);
		mfrm.setVisible(true);
		mfrm.setResizable(false);


	}

	public void notfound(){
		frm.remove(pnl2);
		frm.setIconImage(image.getImage());
		frm.setSize(450,200);
		frm.setTitle("Tamago Hospital");
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnl.setBackground(new Color(0xDAF7A6));
		title.setFont(f);

		pnl.add(title);
		message.setForeground(Color.red);
		message.setText("Incorrect Username or Password");
		message.setFont(f3);
		back.setText("\n");

		pnl.add(message);
		pnl.add(back);
		close.setFocusable(false);
		close.addActionListener(new ActionButton1());
		pnl.add(close);
		pnl.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 4));

		frm.add(pnl);

		frm.setVisible(true);
		frm.setResizable(false);


	}

	public void part2(){
		mfrm.dispose();
		frm.remove(pnl);
		frm.setIconImage(image.getImage());
		frm.setSize(450,200);
		frm.setLocationRelativeTo(null);
		frm.setTitle("TH: Selection");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnl2.setBackground(new Color(0xDAF7A6));
		back.setText("Select Records");
		back.setFont(f3);
		title.setFont(f);

		pnl2.add(title);
		pnl2.add(back,"\n");
		doc.setFocusable(false);
		patient.setFocusable(false);
		logout.setFocusable(false);
		logout.setBackground(new Color(0xFF3824));
		doc.addActionListener(new ActionButton2());
		pnl2.add(doc);
		patient.addActionListener(new ActionButton2());
		pnl2.add(patient);
		logout.addActionListener(new ActionButton2());
		pnl2.add(logout);

		frm.add(pnl2);

		frm.setVisible(true);
		frm.setResizable(false);
	}

	class ActionButton1 extends Main implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==log){
				String usrID = usrField.getText();
				String password = String.valueOf(passField.getPassword());
				Main main = new Main();
				logme(usrID, password);
			}
			else if(e.getSource()==clr){
				usrField.setText("");
				passField.setText("");
			}

			else if(e.getSource()==close){
				frm.dispose();
				frm.repaint();
				frm.validate();
				usrField.setText("");
				passField.setText("");
			}

		}
	}

	class ActionButton2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==doc){
				frm.dispose();
				Doctor doctor = new Doctor();
				doctor.prefaceD();
			}

			else if(e.getSource()==patient){
				frm.dispose();
				Patient patient = new Patient();
				patient.prefaceP();
			}

			else if(e.getSource()==logout){
				frm.dispose();
				frm.repaint();
				frm.validate();
				mfrm.setVisible(true);
				usrField.setText("");
				passField.setText("");

			}

		}
	}


}