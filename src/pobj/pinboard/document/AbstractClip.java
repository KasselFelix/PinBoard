package pobj.pinboard.document;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class AbstractClip implements Clip{
	private double left;
	private double top;
	private double right;
	private double bottom;
	private Color color;
	
	public AbstractClip(double left, double top, double right, double bottom, Color color) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.color = color;
	}
	
	@Override
	public double getTop() {
		return top;
	}

	@Override
	public double getLeft() {
		return left;
	}

	@Override
	public double getBottom() {
		return bottom;
	}

	@Override
	public double getRight() {
		return right;
	}

	@Override
	public void setGeometry(double left, double top, double right, double bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	@Override
	public void move(double x, double y) {
		left+=x;
		right+=x;
		top+=y;
		bottom+=y;
	}

	@Override
	public boolean isSelected(double x, double y) {
		if((x<=right && x>=left) && (y<=bottom && y>=top))
			return true;
		return false;
	}

	@Override
	public void setColor(Color c) {
		color=c;
	}

	@Override
	public Color getColor() {
		return color;
	}
	
	public void setLeft(double left) {
		this.left = left;
	}

	public void setTop(double top) {
		this.top = top;
	}

	public void setRight(double right) {
		this.right = right;
	}

	public void setBottom(double bottom) {
		this.bottom = bottom;
	}

}
