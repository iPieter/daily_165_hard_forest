package daily_165_hard_forrest;

public class ForrestTile {
	private Tree tree = null;
	private Bear bear = null;
	private Lumberjack lumberjack = null;
	
	ForrestTile(boolean tree, boolean bear, boolean lumberjack) {
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
