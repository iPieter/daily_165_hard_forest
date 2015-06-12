package daily_165_hard_forest;

public class Lumberjack extends Movable {
	private LumberMill lumberMill;
	
	public Lumberjack(Pos pos, LumberMill lumberMill) {
		super(pos);
		this.lumberMill = lumberMill;
	}
	
	
	@Override
	public boolean hasTarget(ForestTile tile) {
		return tile.hasTree(TreeType.TREE) || tile.hasTree(TreeType.ELDER);
	}
	

	public void move(Forest forest) {
		super.move(3, forest, this);
	}
	
	public LumberMill getLumberMill() {
		return this.lumberMill;
	}
	
	@Override
	public void removeFromTile(ForestTile tile) {
		//remove the Lumberjack from the given tile
		tile.setLumberjack(null);
	}

	@Override
	public void addToTile(ForestTile tile) {
		tile.setLumberjack(this);
		
	}


	@Override
	public boolean isClear(ForestTile tile) {
		return !(tile.hasLumberjack());
	}

}
