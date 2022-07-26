package pobj.pinboard.document;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ClipEllipse extends AbstractClip {
	private double cx;
	private double cy;
	private double rx;
	private double ry;
	public ClipEllipse(double left, double top, double right, double bottom, Color color) {
		super(left, top, right, bottom, color);
		cx= (left + right)/2;
		cy = (top + bottom)/2;
		rx= (right - left)/2;
		ry = (bottom - top)/2;
	}

	@Override
	public void draw(GraphicsContext ctx) {
		ctx.setFill(getColor());
		ctx.fillOval(getLeft(),getTop(),getRight()-getLeft(),getBottom()-getTop());
	}
	
	@Override
	public boolean isSelected(double x, double y) {
		if( Math.pow((x-cx)/rx, 2) + Math.pow((y-cy)/ry, 2) <= 1 ) 
			return true;
		return false;
	}
	
	@Override
	public Clip copy() {
		return new ClipEllipse(getLeft(), getTop(), getRight(), getBottom(), getColor());
	}

}
