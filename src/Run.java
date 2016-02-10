import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Run implements java.io.Serializable{

	private JFrame frame;

	public static Vector <PicData> vec= new Vector<PicData>();
	public static int runner;
	
	public static void file_input(){
		try{
			FileInputStream fileIn = new FileInputStream("images.ser");
     	  	ObjectInputStream in = null; 
  			File file = new File("images.ser");
  			boolean isEmpty = file.length()<10;
    	   	if(!isEmpty){
    	  		in = new ObjectInputStream(new BufferedInputStream(fileIn));
    	   		vec = (Vector<PicData>) in.readObject();
    	   	}
			if(in!=null){
				in.close();
			}
			fileIn.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error in file handling");
		}
	}
	
	static void free_mem(){
		int n= vec.size();
		for(int i=0;i<n;i++){
			vec.remove(0);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		file_input();
		//free_mem();
		runner = 0;
		try {
			imageWala_GUI window = new imageWala_GUI();
			window.frame.setVisible(true);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
