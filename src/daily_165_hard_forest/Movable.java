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
	
	public abstract boolean isClear(ForestTile tile);
	
	public abstract void removeFromTile(ForestTile tile);
	
	public abstract void addToTile(ForestTile tile);
	
	public abstract void move(Forest forest);
	
	public void move(int steps, Forest forest, Movable sender) {
		//this is the method for finding out the moving pad
		Pos moveTo = this.pos;
		int i = 0;
		boolean moved = false;
		while (!moved && i < steps) {
			//get an array of adjacent positions
			Pos[] adj = forest.getTile(moveTo).getAdjacentCells();
			Pos newPos = adj[(int) (Math.random() * (double) adj.length)];
			
			//check if there's a target 
			if (sender.hasTarget(forest.getTile(newPos)) && sender.isClear(forest.getTile(newPos))) {
				forest.move(sender, newPos, true);
				moved = true;
			} if (sender.isClear(forest.getTile(newPos))) {
				i++;
				moveTo = newPos;
			} else {
				moved = true;
				moveTo = null;
			}
				
		}
		if (moveTo != null) {
			forest.move(sender, moveTo, true);
		}
	}
	

	public void tick(Forest forest) {
		move(forest);
	}
	
	public void setPos(Pos p) {
		this.pos = p;
	}
	
}
