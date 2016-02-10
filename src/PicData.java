import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class PicData implements java.io.Serializable{
	
	private File image;
	private String name;
	private String anno;
	
	//getters
	File get_image(){
		return image;
	}
	
	String get_name(){
		return name;
	}
	
	String get_anno(){
		return anno;
	}
	
	//setters
	void set_image(File img){
		image= img;
	}
	
	void set_name(String n){
		name= n;
	}
	
	void set_anno(String n){
		anno = n;
	}
}
