package daily_165_hard_forest;

public class Forest {
	
	private ForestTile[][] grid;
	private int dimension;
	
	Forest(int dimension) {
		//create a forest with specified dimension
		grid = new ForestTile[dimension][dimension];
		this.dimension = dimension;
		
		populate();
	}
	
	public void populate() {
		//populates the grid with bears, trees and lumberjacks
		for (int i = 0; i< dimension; i++) {
			
		}
	}
}
