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

public class displayPic_GUI {

	public JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Create the application.
	 */
	public displayPic_GUI(final int ind) {
		initialize(ind);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final int ind) {
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
		try{
			lblNewLabel_1.setText(Run.vec.elementAt(ind).get_name());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Name is null");
		}
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(61, 62, 480, 480);
		frame.getContentPane().add(lblNewLabel);
		try {
			lblNewLabel.setIcon(new ImageIcon(ImageIO.read(Run.vec.elementAt(ind).get_image()).getScaledInstance(480, 480, Image.SCALE_SMOOTH)));
		} 
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Image cannot be displayed !");
		}
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnX.setBounds(547, 7, 41, 25);
		frame.getContentPane().add(btnX);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(48, 565, 510, 45);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setText(Run.vec.elementAt(ind).get_anno());
	}
}
