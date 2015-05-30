package daily_165_hard_forrest;

public class Forrest {
	
	private ForrestTile[][] grid;
	private int dimension;
	
	Forrest(int dimension) {
		//create a forrest with specified dimension
		grid = new ForrestTile[dimension][dimension];
		this.dimension = dimension;
		
		populate();
	}
	
	public void populate() {
		//populates the grid with bears, trees and lumberjacks
		for (int i = 0; i< dimension; i++) {
			
		}
	}
}
