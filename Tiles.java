package application;

import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tiles {
	private int Id;
	private String Type;
	private String Property;
	
	public Tiles(int Id,String Type,String Property) {
		this.Id = Id;
		this.Type = Type;
		this.Property = Property;
	}
	
	public ImageView StarterVertical() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\startervertical.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView EmptyNone() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\emptynone.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView PipeVertical() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\pipevertical.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView PipeHorizontal() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\pipehorizontal.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView Pipe01() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\pipe01.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView EmptyFree() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\emptyfree.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView PipeStaticHorizontal() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\pipestatichorizontal.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView EndHorizontal() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\endhorizontal.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView PipeStaticVertical()  throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\pipestaticvertical.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView EndVertical() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\endvertical.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView Pipe00() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\pipe00.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public ImageView PipeStatic01() throws Exception {
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\pipestatic01.jpg");
		ImageView image = new ImageView(new Image(inputimg));
		return image;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getType() {
		return this.Type;
	}
	
	public void setType(String Type) {
		this.Type = Type;
	}
	
	public String getProperty() {
		return this.Property;
	}
	
	public void setProperty(String Property) {
		this.Property = Property;
	}
	
	
	

}
