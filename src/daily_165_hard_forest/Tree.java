package daily_165_hard_forest;

public class Tree {
	private TreeType type;
	private int age;
	
	private Pos pos;
	
	Tree(Pos pos) {
		this.age = 0;
		this.type = TreeType.SAPLING;
		this.pos = pos;
	}
	
	Tree(TreeType type, Pos pos) {
		this.age = 0;
		this.type = type;
		this.pos = pos;
		
	}
	
	public void tick(Forest forest) {
		this.age++;
		
		//upgrade to an older type
		if (this.type == TreeType.SAPLING && this.age > 12) {
			this.type = TreeType.TREE;
		} else if (this.type == TreeType.TREE && this.age > 120) {
			this.type = TreeType.ELDER;
		}
		
		//spawn a sapling
		if ((this.type == TreeType.TREE && Math.random() <=0.1) || (this.type == TreeType.ELDER && Math.random() <=0.2)) {
			Pos[] adj = forest.getTile(this.pos).adjacentCells();
			
			for (Pos p: adj) {
				if (!forest.getTile(p).hasTree(TreeType.ELDER) || !forest.getTile(p).hasTree(TreeType.SAPLING) || !forest.getTile(p).hasTree(TreeType.TREE)) {
					forest.getTile(p).setTree(TreeType.SAPLING);
				}
			}
		}
	}
	
	public TreeType getType() {
		return this.type;
	}
}
