// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.8 page 435
// Exercise from Java:How to program 10th edition

package chapter9;

public class Quadrilateral {
	
	private Point upperLeft;
	private Point lowerLeft;
	private Point upperRight;
	private Point lowerRight;
	
	public Quadrilateral(Point upperLeft, Point lowerLeft, Point upperRight, Point lowerRight) {
		this.upperLeft = upperLeft;
		this.lowerLeft = lowerLeft;
		this.upperRight = upperRight;
		this.lowerRight = lowerRight;
	}
	
	
	
	public Point getUpperLeft() {
		return upperLeft;
	}



	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}



	public Point getLowerLeft() {
		return lowerLeft;
	}



	public void setLowerLeft(Point lowerLeft) {
		this.lowerLeft = lowerLeft;
	}



	public Point getUpperRight() {
		return upperRight;
	}



	public void setUpperRight(Point upperRight) {
		this.upperRight = upperRight;
	}



	public Point getLowerRight() {
		return lowerRight;
	}



	public void setLowerRight(Point lowerRight) {
		this.lowerRight = lowerRight;
	}



	public int calculateHeight(){
		int height = Math.abs(this.getUpperLeft().getY() - this.getLowerLeft().getY());
		return height;
	}
	
	
}
