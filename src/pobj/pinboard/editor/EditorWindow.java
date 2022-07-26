package pobj.pinboard.editor;

import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pobj.pinboard.document.Board;
import pobj.pinboard.document.ClipEllipse;
import pobj.pinboard.document.ClipRect;

public class EditorWindow extends javafx.application.Application implements EditorInterface {
	
	private Board board;

	@Override
	public void start(javafx.stage.Stage stage) {
		stage.setTitle("PinBoard - <untitled>") ;
		Canvas canvas = new Canvas(300, 400);
		
		Menu file = new Menu("File");
		MenuItem New = new MenuItem("New");
		MenuItem close = new MenuItem("Close");
		file.getItems().add(New);
		file.getItems().add(close);
		New.setOnAction( (e)-> start(new Stage()));
		close.setOnAction( (e)-> stage.close() );
		Menu edit = new Menu("Edit");
		Menu tools = new Menu("Tools");
		MenuBar menuBar= new MenuBar(file,edit,tools);
		
		Button box = new Button("Box");
		Button Ellipse = new Button("Ellipse");
		Button Img = new Button("Img");
		ToolBar toolBar = new ToolBar(box,Ellipse,Img);
		
		Label label = new Label("filled rectangle tool");
		
		VBox vbox = new VBox();
		vbox.getChildren().add(menuBar);
		vbox.getChildren().add(toolBar);
		vbox.getChildren().add(canvas);
		vbox.getChildren().add(new Separator());
		vbox.getChildren().add(label);
		
		stage.setScene(new javafx.scene.Scene(vbox));
		
		board = new Board();

		board.addClip(new ClipRect(125, 50, 175, 150, Color.BLACK));
		board.addClip(new ClipEllipse(100, 175, 200, 250,Color.BLACK));
		
		board.draw(canvas.getGraphicsContext2D());
		
		stage.show();
	}
	
	
	public static void main(String[] args) { launch(args); }


	@Override
	public Board getBoard() {
		return board;
	}


	@Override
	public Selection getSelection() {
		return null;
	}


	@Override
	public CommandStack getUndoStack() {
		return null;
	}
}
