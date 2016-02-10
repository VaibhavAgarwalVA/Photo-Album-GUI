import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class importNew_GUI {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JEditorPane editorPane;
	private JLabel lblPreview;
	private File file;
	private JButton btnCancel;
	private int stat;
	/**
	 * Create the application.
	 */
	public importNew_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImportImage = new JLabel("Import Image");
		lblImportImage.setFont(new Font("Khmer OS System", Font.BOLD, 17));
		lblImportImage.setBounds(55, 28, 131, 25);
		frame.getContentPane().add(lblImportImage);
		
		textField = new JTextField();
		textField.setBounds(42, 290, 406, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(433, 98, 120, 180);
		frame.getContentPane().add(lblNewLabel);

		lblPreview = new JLabel(" ");
		lblPreview.setBounds(457, 74, 70, 15);
		frame.getContentPane().add(lblPreview);
		
		final JFileChooser fileDialog = new JFileChooser();
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Run.vec.size() >= 10){
					JOptionPane.showMessageDialog(null, "Maximum 10 images can be stored !!");
					frame.setVisible(false);
				}
				else{
					stat=0;
					int returnVal = fileDialog.showOpenDialog(frame);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
	            		file = fileDialog.getSelectedFile();
	               		textField.setText(file.getName());
                   		try 
                   		{ 
                   			stat=1;
                	   		lblNewLabel.setIcon(new ImageIcon(ImageIO.read(file).getScaledInstance(120, 180, Image.SCALE_SMOOTH)));
                	   		lblPreview.setText("Preview");
                   		} 
                   		catch(Exception e) {
                       		e.printStackTrace();
                       		JOptionPane.showMessageDialog(null, "Input Error !");
                       		frame.setVisible(false);
                   		}
	            	}
	            	else{
	            		JOptionPane.showMessageDialog(null, "Input aborted by the user !");  
	            		frame.setVisible(false);
	            	} 
				}
			}
		});
		btnBrowse.setBounds(460, 287, 100, 25);
		frame.getContentPane().add(btnBrowse);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(43, 114, 354, 164);
		frame.getContentPane().add(editorPane);
		
		textField_1 = new JTextField(" ");
		textField_1.setBounds(329, 27, 231, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(stat == 0){
					JOptionPane.showMessageDialog(null,"Please choose an image !");
					frame.setVisible(false);
				}
				PicData c= new PicData();
		        Run.vec.addElement(c);
	            Run.vec.elementAt(Run.vec.size()-1).set_image(file);
				String nm= textField_1.getText();
				Run.vec.elementAt(Run.vec.size()-1).set_name(nm);
				nm = editorPane.getText();
				Run.vec.elementAt(Run.vec.size()-1).set_anno(nm);
				frame.setVisible(false);
			}
		});
		btnSave.setBounds(280, 320, 117, 40);
		frame.getContentPane().add(btnSave);
		
		JLabel lblShortAnnotation = new JLabel("Short Annotation:");
		lblShortAnnotation.setFont(new Font("LM Roman Caps 10", Font.BOLD, 12));
		lblShortAnnotation.setBounds(42, 87, 144, 15);
		frame.getContentPane().add(lblShortAnnotation);
				
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setFont(new Font("L M Roman Caps10", Font.BOLD, 12));
		lblName.setBounds(277, 32, 70, 15);
		frame.getContentPane().add(lblName);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(96, 321, 117, 39);
		frame.getContentPane().add(btnCancel);
	}
}
