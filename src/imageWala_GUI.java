import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class imageWala_GUI implements java.io.Serializable{

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public imageWala_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImageViewer = new JLabel("Image Viewer");
		lblImageViewer.setForeground(Color.GRAY);
		lblImageViewer.setBounds(258, 12, 122, 30);
		frame.getContentPane().add(lblImageViewer);
		
		JButton btnImportNewImage = new JButton("Import New Image");
		btnImportNewImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				importNew_GUI obj=new importNew_GUI();
				obj.frame.setVisible(true);
			}
		});
		btnImportNewImage.setBounds(87, 93, 174, 25);
		frame.getContentPane().add(btnImportNewImage);
		
		JButton btnAllImages = new JButton("All Images");
		btnAllImages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Run.vec.size()>0){
					displayImage_GUI obj= new displayImage_GUI();
					obj.frame.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "No images to load !!");
				}
			}
		});
		btnAllImages.setBounds(87, 130, 174, 25);
		frame.getContentPane().add(btnAllImages);
		
		JButton btnImageNamewise = new JButton("Images Name-Wise");
		btnImageNamewise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Run.vec.size()>0){
					displayName_GUI obj= new displayName_GUI();
					obj.frame.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "No images to load !!");
				}
			}
		});
		btnImageNamewise.setBounds(87, 170, 174, 25);
		frame.getContentPane().add(btnImageNamewise);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					FileOutputStream fileOut = new FileOutputStream("images.ser");
					ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(fileOut));
					out.writeObject(Run.vec);
					out.close();
					fileOut.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				try{
					FileInputStream fileIn = new FileInputStream("images.ser");
		     	  	ObjectInputStream in = null; 
		  			File file = new File("images.ser");
		  			boolean isEmpty = file.length()<10;
		    	   	if(!isEmpty){
		    	  		in = new ObjectInputStream(new BufferedInputStream(fileIn));
		    	   		Run.vec = (Vector<PicData>) in.readObject();
		    	   	}
					if(in!=null){
						in.close();
					}
					fileIn.close();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Error in file handling");
				}
				frame.setVisible(false);
			}
		});
		btnExit.setBounds(245, 298, 99, 25);
		frame.getContentPane().add(btnExit);
		
		JLabel lblTakeANew = new JLabel("- Store a new photo from the system");
		lblTakeANew.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblTakeANew.setBounds(297, 98, 270, 15);
		frame.getContentPane().add(lblTakeANew);
		
		JLabel lblDisplayAllImages = new JLabel("- Display all stored images ");
		lblDisplayAllImages.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblDisplayAllImages.setBounds(297, 135, 270, 15);
		frame.getContentPane().add(lblDisplayAllImages);
		
		JLabel lblDisplayA = new JLabel("- Display a list of all names of images");
		lblDisplayA.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblDisplayA.setBounds(297, 175, 270, 15);
		frame.getContentPane().add(lblDisplayA);
		
		JLabel lblCaptureYourMemories = new JLabel("Capture your memories !!");
		lblCaptureYourMemories.setForeground(Color.BLACK);
		lblCaptureYourMemories.setFont(new Font("Purisa", Font.BOLD | Font.ITALIC, 16));
		lblCaptureYourMemories.setBounds(188, 38, 344, 43);
		frame.getContentPane().add(lblCaptureYourMemories);
		
		JLabel lblLetsYouStore = new JLabel("Lets you store a maximum of 10 pictures !");
		lblLetsYouStore.setFont(new Font("URW Chancery L", Font.BOLD | Font.ITALIC, 17));
		lblLetsYouStore.setBounds(143, 241, 370, 30);
		frame.getContentPane().add(lblLetsYouStore);
	}
}
