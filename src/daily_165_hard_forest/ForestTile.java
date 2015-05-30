package daily_165_hard_forest;

public class ForestTile {
	private Tree tree = null;
	private Bear bear = null;
	private Lumberjack lumberjack = null;
	
	ForestTile(boolean tree, boolean bear, boolean lumberjack) {
		//if booleans are true, populate with a new T
		if (tree) {
			this.tree = new Tree();
		}
		
		if (bear) {
			this.bear = new Bear();
		}
		
		if (lumberjack) {
			this.lumberjack = new Lumberjack();
		}
	}
}
