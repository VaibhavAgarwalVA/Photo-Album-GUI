import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class displayName_GUI {

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public displayName_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle( "Pictures List Table" );
		frame.getContentPane().setLayout(null);
		
		JLabel lblPicturesList = new JLabel("Pictures List");
		lblPicturesList.setBounds(166, 12, 128, 37);
		frame.getContentPane().add(lblPicturesList);
		
		int n= Run.vec.size();
		Vector <String> data = new Vector<String>();
		for(int i=0;i<n;i++){
			data.addElement(Run.vec.elementAt(i).get_name());
			System.out.println("Name["+i+"]: "+Run.vec.elementAt(i).get_name());
		}
		
		JComboBox comboBox = new JComboBox(data);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ((JComboBox)e.getSource()).getSelectedIndex();
				System.out.println("Index: "+i);
				displayPic_GUI obj= new displayPic_GUI(i);
				obj.frame.setVisible(true);
			}
		});
		comboBox.setBounds(88, 93, 265, 24);
		frame.getContentPane().add(comboBox);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnReturn.setBounds(166, 223, 117, 25);
		frame.getContentPane().add(btnReturn);
		
		
		frame.setVisible(true);
	}
}
