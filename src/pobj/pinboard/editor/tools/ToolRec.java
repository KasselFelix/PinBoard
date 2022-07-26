package pobj.pinboard.editor.tools;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import pobj.pinboard.editor.EditorInterface;

public class ToolRec implements Tool {
	private double x1;
	private double y1;
	private double x2;
	private double y2;

	@Override
	public void press(EditorInterface i, MouseEvent e) {
		x1=e.getX();
		y1=e.getY();
	}

	@Override
	public void drag(EditorInterface i, MouseEvent e) {
		x2=e.getX();
		y2=e.getY();
	}

	@Override
	public void release(EditorInterface i, MouseEvent e) {
		i.
	}

	@Override
	public void drawFeedback(EditorInterface i, GraphicsContext gc) {
		gc.strokeRect(x1, y1, x2, y2);
	}

	@Override
	public String getName(EditorInterface editor) {
		return "Tool rec";
	}

}
