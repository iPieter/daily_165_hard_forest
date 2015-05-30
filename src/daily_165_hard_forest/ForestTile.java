package daily_165_hard_forest;

public class ForestTile {
	private Tree tree;
	private Bear bear;
	private Lumberjack lumberjack;
	
	private Pos pos;
	
	ForestTile(Pos pos, Tree tree, Bear bear, Lumberjack lumberjack) {
		this.tree = tree;
		this.bear = bear;
		this.lumberjack = lumberjack;
		
		this.pos = pos;
	}
}
