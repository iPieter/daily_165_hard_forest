package daily_165_hard_forest;

public abstract class Movable {
	
	private Pos pos;
	
	public Movable(Pos pos) {
		this.pos = pos;
	}
	
	public Pos getPos() {
		return this.pos;
	}
	
	public abstract boolean hasTarget(ForestTile tile);
	
	public abstract void removeFromTile(ForestTile tile);
	
	public abstract void addToTile(ForestTile tile);
	
	public abstract void move(Forest forest);
	
	public void move(int steps, Forest forest, Movable sender) {
		//this is the method for finding out the moving pad
		for (int i=0; i< steps; i++) {
			//get an array of adjacent positions
			Pos[] adj = forest.getTile(this.pos).getAdjacentCells();
			
			Pos moveTo = null;
			
			//check if there's a target 
			for (Pos p : adj) {
				if (sender.hasTarget(forest.getTile(p))) {
					moveTo = p;
				}
			}
			
			if (moveTo == null ) {
				moveTo = adj[(int) Math.random()*adj.length];
			}
			
			forest.move(sender, moveTo);
		}
	}
	
	public void tick(Forest forest) {
		move(forest);
	}
	
	
}
