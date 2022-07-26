package pobj.pinboard.document;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board {
	private List<Clip> contents;
	public 	Board() {
		contents=new ArrayList<Clip>();
	}
	
	public void draw(GraphicsContext ctx) {
		ctx.setFill(Color.WHITE);
		ctx.fillRect(0,0,ctx.getCanvas().getWidth(),ctx.getCanvas().getHeight());
		for(Clip c : contents)
			c.draw(ctx);
	}

	public List<Clip> getContents(){
		return contents;
	}
	
	public void addClip(Clip clip) {
		contents.add(clip);
	}
	public void addClip(List<Clip> clip) {
		contents.addAll(clip);
	}
	public void removeClip(Clip clip) {
		contents.remove(clip);
	}
	public void removeClip(List<Clip> clip) {
		contents.removeAll(clip);
	}

}
