// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.23 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

public class Turtle {

	private int currentXPosition = 0;
	private int currentYPosition = 0;
	private int lastXPosition = 0;
	private int lastYPosition = 0;
	private boolean isDrawing = false;
	private int facing = 0;
	private int unitsToMove = 0;
	
	public void move(){
		if (facing == 0){
			lastXPosition = currentXPosition;
			lastYPosition = currentYPosition;
			currentYPosition += unitsToMove * 10;
		} else if (facing == 1){
			lastYPosition = currentYPosition;
			lastXPosition = currentXPosition;
			currentXPosition -= unitsToMove * 10;
		} else if (facing == 2){
			lastXPosition = currentXPosition;
			lastYPosition = currentYPosition;
			currentYPosition -= unitsToMove * 10;
		} else{
			lastYPosition = currentYPosition;
			lastXPosition = currentXPosition;
			currentXPosition += unitsToMove * 10;
		}
	}
	
	public int getUnitsToMove() {
		return unitsToMove;
	}
	public void setUnitsToMove(int unitsToMove) {
		this.unitsToMove = unitsToMove;
	}
	public int getCurrentXPosition() {
		return currentXPosition;
	}
	public void setCurrentXPosition(int currentXPosition) {
		this.currentXPosition = currentXPosition;
	}
	public int getCurrentYPosition() {
		return currentYPosition;
	}
	public void setCurrentYPosition(int currentYPosition) {
		this.currentYPosition = currentYPosition;
	}
	public int getLastXPosition() {
		return lastXPosition;
	}
	public void setLastXPosition(int lastXPosition) {
		this.lastXPosition = lastXPosition;
	}
	public int getLastYPosition() {
		return lastYPosition;
	}
	public void setLastYPosition(int lastYPosition) {
		this.lastYPosition = lastYPosition;
	}
	public boolean isDrawing() {
		return isDrawing;
	}
	public void setDrawing(boolean isDrawing) {
		this.isDrawing = isDrawing;
	}
	public int getFacing() {
		return facing;
	}
	public void setFacing(int facing) {
		this.facing = facing;
	}
	
	
}
