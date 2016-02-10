import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class displayImage_GUI {

	public JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the application.
	 */
	public displayImage_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 650);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImageViewer = new JLabel("Image Viewer");
		lblImageViewer.setBounds(248, 12, 101, 15);
		frame.getContentPane().add(lblImageViewer);

		
		lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(196, 541, 204, 15);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setText(Run.vec.elementAt(Run.runner).get_name());
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(48, 29, 500, 500);
		frame.getContentPane().add(lblNewLabel);
		try {
			lblNewLabel.setIcon(new ImageIcon(ImageIO.read(Run.vec.elementAt(Run.runner).get_image()).getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
		} 
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Image cannot be displayed !");
		}
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n= Run.vec.size();
				Run.runner= (Run.runner + n-1)%n;
				try {
					lblNewLabel_1.setText(Run.vec.elementAt(Run.runner).get_name());
					lblNewLabel.setIcon(new ImageIcon(ImageIO.read(Run.vec.elementAt(Run.runner).get_image()).getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
				} catch (IOException e) {
					e.printStackTrace();
				}
				frame.setVisible(true);
				
			}
		});
		btnPrevious.setBounds(74, 565, 117, 25);
		frame.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n= Run.vec.size();
				Run.runner= (Run.runner +1)%n;
				try {
					lblNewLabel_1.setText(Run.vec.elementAt(Run.runner).get_name());
					lblNewLabel.setIcon(new ImageIcon(ImageIO.read(Run.vec.elementAt(Run.runner).get_image()).getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
				} catch (IOException e) {
					e.printStackTrace();
				}

				frame.setVisible(true);
			}
		});
		btnNext.setBounds(399, 565, 117, 25);
		frame.getContentPane().add(btnNext);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnX.setBounds(268, 587, 51, 25);
		frame.getContentPane().add(btnX);
	}
}
