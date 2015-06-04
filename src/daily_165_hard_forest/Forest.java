package daily_165_hard_forest;

public class Forest {
	
	private ForestTile[][] grid;
	private int dimension;
	private LumberMill lumberMill;
	private int tick;
	
	Forest(int dimension) {
		//create a forest with specified dimension
		grid = new ForestTile[dimension][dimension];
		this.dimension = dimension;
		this.tick = 0;
		
		populate();
	}
	
	public int getDimension() {
		return this.dimension;
	}
	
	public boolean isCorner(Pos pos) {
		return pos.equals(new Pos(0,0)) || pos.equals(new Pos(dimension - 1,dimension - 1)) || pos.equals(new Pos(dimension - 1,0))|| pos.equals(new Pos(0,dimension- 1));
	}
	
	public boolean isEdge(Pos pos) {
		return pos.equalX(new Pos(0,0)) || pos.equalX(new Pos(dimension - 1,0)) || pos.equalY(new Pos(0,0)) || pos.equalY(new Pos(0,dimension - 1));
	}
	
	public boolean inGrid(Pos pos) {
		return pos.getX() >= 0 && pos.getX() < dimension && pos.getY() >= 0 && pos.getY() < dimension;
	}
	
	public ForestTile getTile(Pos p) {
		return grid[p.getX()][p.getY()];
	}
	
	public void move(Movable m, Pos p) {
		//this is the method that contains the actual moving logic
		
		//step 1: remove the movable from the old tile
		m.removeFromTile(grid[m.getPos().getX()][m.getPos().getY()]);
		
		//step 2: add the movable to the target tile
		m.addToTile(grid[p.getX()][p.getY()]);
		
	}
	
	public void populate() {
		//create a lumbermill, for managing the lumberjacks
		lumberMill = new LumberMill(this);
		
		//populates the grid with bears, trees and lumberjacks
		for (int i = 0; i< dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				
				//TODO: make a better grid populator
				double rnd = Math.random();
				Pos p = new Pos(i,j);
				if ( rnd <= 0.5 ) {
					grid[i][j] = new ForestTile(p, new Tree(TreeType.TREE, p), null, null, this);
				} else if (rnd <= 0.6) {
					grid[i][j] = new ForestTile(p, null, null, new Lumberjack(p, lumberMill), this);
				} else if (rnd <= 0.62) {
					grid[i][j] = new ForestTile(p, null, new Bear(p), null, this);
				}
				 
				
			}
		}
	}
	
	public void tick() {
		for (ForestTile[] tileRow : grid) {
			for (ForestTile tile : tileRow) {
				tile.tick();
			}
		}
		
		this.tick++;
	}
	
	public int getYear() {
		return this.tick/12;
	}
}
