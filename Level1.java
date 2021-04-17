package application;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level1 {
	
	private Tiles[][] level1tiles = new Tiles[4][4];
	private static Pane pane = new Pane();
	private static int startx;
	private static int starty;
	private static int endx;
	private static int endy;
	private static Scene scene;
	private static Stage stage = new Stage();
	private static ImageView ball;
	private static Text text;
	private static Button button;
	private static int moves;
	private static int ballx;
	private static int bally;

	public Level1() throws Exception{
		CreateLevel1Tiles();
		CreateLevel1Pane();
		scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		DragTiles();
		MoveTiles();
	}
	
	public void CreateLevel1Tiles() throws Exception {
		File file = new File("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\levels\\level1.txt");
		Scanner input = new Scanner(file);
		if(file.exists()) {
			int i = 0;
			int j = 0;
			while(input.hasNextLine()) {
				String[] line = input.nextLine().split(",");
				level1tiles[i][j] = new Tiles(Integer.parseInt(line[0]),line[1],line[2]);
				j++;
				if(j > 3) {
					i++;
					j = 0;
				}
			}
		}
		input.close();
	}
	
	public Pane CreateLevel1Pane() throws Exception {
		for(int i = 0;i<level1tiles.length;i++) {
			for(int j = 0;j<level1tiles[i].length;j++) {
				if(level1tiles[i][j].getType().equals("Starter") && level1tiles[i][j].getProperty().equals("Vertical")) {
					ImageView img = level1tiles[i][j].StarterVertical();
					pane.getChildren().add(img);
					img.setX(84*(j));
					img.setY(84*(i));
					}
				else if(level1tiles[i][j].getType().equals("Empty") && level1tiles[i][j].getProperty().equals("none")) {
					ImageView img = level1tiles[i][j].EmptyNone();
					pane.getChildren().add(img);
					img.setX(84*(j));
					img.setY(84*(i));
				}
				else if(level1tiles[i][j].getType().equals("Pipe") && level1tiles[i][j].getProperty().equals("Vertical")) {
					ImageView img = level1tiles[i][j].PipeVertical();
					pane.getChildren().add(img);
					img.setX(84*(j));
					img.setY(84*(i));
				}
				else if(level1tiles[i][j].getType().equals("Pipe") && level1tiles[i][j].getProperty().equals("Horizontal")) {
					ImageView img = level1tiles[i][j].PipeHorizontal();
					pane.getChildren().add(img);
					img.setX(84*(j));
					img.setY(84*(i));
				}
				else if(level1tiles[i][j].getType().equals("Pipe") && level1tiles[i][j].getProperty().equals("01")) {
					ImageView img = level1tiles[i][j].Pipe01();
					pane.getChildren().add(img);
					img.setX(84*(j));
					img.setY(84*(i));
				}
				else if(level1tiles[i][j].getType().equals("Empty") && level1tiles[i][j].getProperty().equals("Free")) {
					ImageView img = level1tiles[i][j].EmptyFree();
					pane.getChildren().add(img);
					img.setX(84*(j));
					img.setY(84*(i));
				}
				else if(level1tiles[i][j].getType().equals("PipeStatic") && level1tiles[i][j].getProperty().equals("Horizontal")) {
					ImageView img = level1tiles[i][j].PipeStaticHorizontal();
					pane.getChildren().add(img);
					img.setX(84*(j));
					img.setY(84*(i));
				}
				else if(level1tiles[i][j].getType().equals("End") && level1tiles[i][j].getProperty().equals("Horizontal")) {
					ImageView img = level1tiles[i][j].EndHorizontal();
					pane.getChildren().add(img);
					img.setX(84*(j));
					img.setY(84*(i));
				}
			}
		}
		FileInputStream inputimg = new FileInputStream("C:\\Users\\ch\\eclipse-workspace\\Term Project\\application\\images\\ball.png");
		ball = new ImageView(new Image(inputimg));
		pane.getChildren().add(ball);
		ball.setX(23);
		ball.setY(18);
		HBox hbox = new HBox(10);
		button = new Button("Next Level");
		text = new Text("Moves:" + moves );
		hbox.getChildren().addAll(button,text);
		button.setOnAction(e -> {
			if(ballx == 3 && bally == 3) {
				// Create Level2 here
			}
		});
		hbox.setLayoutX(115);
		hbox.setLayoutY(338);
		pane.getChildren().add(hbox);
		return pane;
	}
	
	public void DragTiles() {
		for(int i = 0;i<pane.getChildren().size();i++) {
			if(pane.getChildren().get(i) instanceof ImageView) {
				ImageView img = (ImageView)(pane.getChildren().get(i));
				img.setOnMousePressed(e -> {
					startx = (int)e.getX()/80;
					starty = (int)e.getY()/80;
				});
				img.setOnMouseDragged(e -> {
					img.setX(e.getX());
					img.setY(e.getY());
				});
			}
		}
	}
	
	public void MoveTiles(){
		for(int i = 0;i<pane.getChildren().size();i++) {
			if(pane.getChildren().get(i) instanceof ImageView) {
				ImageView img = (ImageView)(pane.getChildren().get(i));
				img.setOnMouseReleased(e -> {
					endx = (int)e.getX()/80;
					endy = (int)e.getY()/80;
					int differencex = Math.abs(endx-startx);
					int differencey = Math.abs(endy-starty);
					if(level1tiles[endy][endx].getProperty().equals("Free") && (differencex+differencey == 1) && !(level1tiles[starty][startx].getType().equals("Starter"))
						&& !(level1tiles[starty][startx].getType().equals("PipeStatic")) && !(level1tiles[starty][startx].getType().equals("End"))) {
						Tiles temporarytile = level1tiles[endy][endx];
						level1tiles[endy][endx] = null;
						level1tiles[endy][endx] = level1tiles[starty][startx];
						level1tiles[starty][startx] = null;
						level1tiles[starty][startx] = temporarytile;
						moves++;
						pane.getChildren().clear();
						Pane temporarypane = new Pane();
						scene.setRoot(temporarypane);
						try {
							pane = CreateLevel1Pane();
						}
						catch(Exception ex) {
							System.out.println("File not found");
						}
						
						scene.setRoot(pane);
						MoveTiles();
						DragTiles();
						stage.hide();
						stage.show();
					}
					
					else {
						pane.getChildren().clear();
						try {
							pane = CreateLevel1Pane();
						}
						catch(Exception ex) {
							System.out.println("File not found");
						}
						Pane temporarypane = new Pane();
						scene.setRoot(temporarypane);
						scene.setRoot(pane);
						MoveTiles();
						DragTiles();
						stage.hide();
						stage.show();
					}
					
					if(level1tiles[1][0].getProperty().equals("Vertical") && level1tiles[2][0].getProperty().equals("Vertical") && level1tiles[3][0].getProperty().equals("01") 
						&& level1tiles[3][1].getProperty().equals("Horizontal")) {
						Polyline polyline = new Polyline(36,21,36,255,48,279,77,294,296,292);
						PathTransition transition = new PathTransition();
						transition.setPath(polyline);
						transition.setNode(ball);
						transition.setDuration(Duration.millis(5000));
						transition.play();
						ballx = 3;
						bally = 3;
					}
				});
			}
		}
	}
	
	public Pane getPane() {
		return pane;
	}
	public Tiles[][] getLevel1Tiles() {
		return this.level1tiles;
	}
		
}
