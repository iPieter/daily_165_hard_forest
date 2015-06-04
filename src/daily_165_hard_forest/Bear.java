package daily_165_hard_forest;

public class Bear extends Movable {

	public Bear(Pos pos) {
		super(pos);
	}
	
	public void move(Forest forest) {
		super.move(5, forest, this);
	}
	
	@Override
	public boolean hasTarget(ForestTile tile) {
		return tile.hasLumberjack();
	}

	@Override
	public void removeFromTile(ForestTile tile) {
		tile.setBear(null);
		
	}

	@Override
	public void addToTile(ForestTile tile) {
		tile.setBear(this);
		
	}
	
}
