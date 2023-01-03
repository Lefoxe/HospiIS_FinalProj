import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Patient extends Doctor{
	JLabel back = new JLabel();
	JLabel title = new JLabel("Tamago Hospital");
	JLabel Name = new JLabel("Enter Name: ");
	JLabel Room = new JLabel("Enter Room No.: ");
	JLabel Ail = new JLabel("Enter Ailment: ");

	JTextField name = new JTextField(20);
	JTextField room = new JTextField(20);
	JTextField ail = new JTextField(20);
	JTextField phys = new JTextField(20);

	public void prefaceP(){
		frm.setIconImage(image.getImage());
		frm.setSize(450,200);
		frm.setLocationRelativeTo(null);
		frm.setTitle("TH: Patients");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnl.setBackground(new Color(0xDAF7A6));
		back.setText("Select Function");
		back.setFont(f3);
		title.setFont(f);

		pnl.add(title);
		pnl.add(back,"\n");
		add.setFocusable(false);
		rmv.setFocusable(false);
		edit.setFocusable(false);
		rtrn.setFocusable(false);
		add.addActionListener(new ActionButton1());
		pnl.add(add);
		rmv.addActionListener(new ActionButton1());
		pnl.add(rmv);
		edit.addActionListener(new ActionButton1());
		pnl.add(edit);
		rtrn.addActionListener(new ActionButton1());
		pnl.add(rtrn);

		frm.add(pnl);

		frm.setVisible(true);
		frm.setResizable(false);
	}

	class ActionButton1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==add){
				frm.dispose();
				frm.remove(pnl);
				frm.repaint();
				frm.validate();
				frm2.remove(pnl5);
				frm2.remove(pnl6);
				frm2.remove(pnl7);
				frm2.remove(pnl8);
				frm2.remove(pnl9);
				frm2.remove(pnl10);
				frm2.repaint();
				frm2.revalidate();
				frm2.setIconImage(image.getImage());
				frm2.setSize(500,500);
				frm2.setLocationRelativeTo(null);
				frm2.setTitle("Add to Patient's Records");
				frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pnl2.setBackground(new Color(0xDAF7A6));
				pnl3.setBackground(new Color(0xDAF7A6));
				pnl4.setBackground(new Color(0xDAF7A6));
				back.setText("Enter Physician: ");
				title.setFont(f);
				Name.setFont(f2);
				Room.setFont(f2);
				Ail.setFont(f2);
				back.setFont(f2);

				pnl3.setLayout(new BoxLayout(pnl3, BoxLayout.PAGE_AXIS));
				pnl3.add(Box.createRigidArea(new Dimension(0,5)));


				Main main = new Main();
				table = new JTable(main.tebelpat());
				sp = new JScrollPane(table);

				pnl2.add(title);
				pnl3.add(sp);
				pnl3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
				pnl3.add(Name);
				pnl3.add(name);
				pnl3.add(Room);
				pnl3.add(room);
				pnl3.add(Ail);
				pnl3.add(ail);
				pnl3.add(back);
				pnl3.add(phys);

				add2.setFocusable(false);
				add2.addActionListener(new ActionButton2());
				pnl4.add(add2);
				rtrn2.setFocusable(false);
				rtrn2.addActionListener(new ActionButton2());
				pnl4.add(rtrn2);

				frm2.add(pnl2, BorderLayout.NORTH);
				frm2.add(pnl3, BorderLayout.CENTER);
				frm2.add(pnl4, BorderLayout.SOUTH);

				frm2.setResizable(true);
				frm2.setVisible(true);
			}

			else if(e.getSource()==rmv){
				frm.dispose();
				frm.remove(pnl);
				frm.repaint();
				frm.validate();
				frm2.remove(pnl2);
				frm2.remove(pnl3);
				frm2.remove(pnl4);
				frm2.remove(pnl8);
				frm2.remove(pnl9);
				frm2.remove(pnl10);
				frm2.repaint();
				frm2.revalidate();
				frm2.setIconImage(image.getImage());
				frm2.setSize(500,500);
				frm2.setLocationRelativeTo(null);
				frm2.setTitle("Remove from Patient's Records");
				frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pnl5.setBackground(new Color(0xDAF7A6));
				pnl6.setBackground(new Color(0xDAF7A6));
				pnl7.setBackground(new Color(0xDAF7A6));
				title.setFont(f);
				Name.setFont(f2);

				pnl6.setLayout(new BoxLayout(pnl6, BoxLayout.PAGE_AXIS));
				pnl6.add(Box.createRigidArea(new Dimension(0,5)));

				Main main = new Main();
				table = new JTable(main.tebelpat());
				sp = new JScrollPane(table);

				pnl5.add(title);
				pnl6.add(sp);
				pnl6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
				pnl6.add(Name);
				pnl6.add(name);

				rmv2.setFocusable(false);
				rmv2.addActionListener(new ActionButton2());
				pnl7.add(rmv2);
				rtrn2.setFocusable(false);
				rtrn2.addActionListener(new ActionButton2());
				pnl7.add(rtrn2);

				frm2.add(pnl5, BorderLayout.NORTH);
				frm2.add(pnl6, BorderLayout.CENTER);
				frm2.add(pnl7, BorderLayout.SOUTH);

				frm2.setResizable(true);
				frm2.setVisible(true);
			}

			else if(e.getSource()==edit){
				frm.setVisible(false);
				frm.repaint();
				frm.validate();
				frm2.remove(pnl2);
				frm2.remove(pnl3);
				frm2.remove(pnl4);
				frm2.remove(pnl5);
				frm2.remove(pnl6);
				frm2.remove(pnl7);
				frm2.repaint();
				frm2.revalidate();
				frm2.setIconImage(image.getImage());
				frm2.setSize(500,500);
				frm2.setLocationRelativeTo(null);
				frm2.setTitle("Edit Patient's Records");
				frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pnl8.setBackground(new Color(0xDAF7A6));
				pnl9.setBackground(new Color(0xDAF7A6));
				pnl10.setBackground(new Color(0xDAF7A6));
				title.setFont(f);
				column.setFont(f2);
				old.setFont(f2);
				bago.setFont(f2);

				pnl9.setLayout(new BoxLayout(pnl9, BoxLayout.PAGE_AXIS));
				pnl9.add(Box.createRigidArea(new Dimension(0,5)));


				Main main = new Main();
				table = new JTable(main.tebelpat());
				sp = new JScrollPane(table);

				pnl8.add(title);
				pnl9.add(sp);
				pnl9.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
				pnl9.add(column);
				pnl9.add(name);
				pnl9.add(old);
				pnl9.add(room);
				pnl9.add(bago);
				pnl9.add(ail);

				edit2.setFocusable(false);
				edit2.addActionListener(new ActionButton2());
				pnl10.add(edit2);
				rtrn2.setFocusable(false);
				rtrn2.addActionListener(new ActionButton2());
				pnl10.add(rtrn2);

				frm2.add(pnl8, BorderLayout.NORTH);
				frm2.add(pnl9, BorderLayout.CENTER);
				frm2.add(pnl10, BorderLayout.SOUTH);

				frm2.setResizable(true);
				frm2.setVisible(true);
			}

			else if(e.getSource()==rtrn){
				frm.dispose();
				frm.remove(pnl);
				frm.repaint();
				frm.validate();
				Login login = new Login();
				login.frm.setVisible(true);
			}
		}
	}

	class ActionButton2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==add2){
				String a = name.getText();
				String b = room.getText();
				String c = ail.getText();
				String d = phys.getText();
				Main main = new Main();
				main.Pasyents(a,b,c,d);
				main.update();
				table.setModel(main.tebelpat());
				sp.repaint();
				sp.validate();
				frm2.repaint();
				frm2.validate();
				name.setText("");
				room.setText("");
				ail.setText("");
				phys.setText("");
			}

			else if(e.getSource()==rmv2){
				String a = name.getText();
				Main main = new Main();
				main.rmvP(a);
				main.update();
				table.setModel(main.tebelpat());
				sp.repaint();
				sp.validate();
				frm2.repaint();
				frm2.validate();
				name.setText("");
			}

			else if(e.getSource()==edit2){
				String a = name.getText();
				String b = room.getText();
				String c = ail.getText();
				Main main = new Main();
				main.editP(a,b,c);
				main.update();
				table.setModel(main.tebelpat());
				sp.repaint();
				sp.validate();
				frm2.repaint();
				frm2.validate();
				name.setText("");
				room.setText("");
				ail.setText("");
			}

			else if(e.getSource()==rtrn2){
				frm2.dispose();
				pnl3.remove(sp);
				pnl6.remove(sp);
				pnl9.remove(sp);
				frm2.remove(pnl4);
				frm2.remove(pnl7);
				frm2.remove(pnl10);
				pnl.removeAll();
				pnl.add(title);
				pnl.add(back);
				pnl.add(add);
				pnl.add(rmv);
				pnl.add(edit);
				pnl.add(rtrn);
				frm.add(pnl);
				frm.repaint();
				frm.validate();
				frm.setVisible(true);
			}
		}
	}

}