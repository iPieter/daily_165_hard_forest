package daily_165_hard_forest;

public class Tree extends Target {
	private TreeType type;
	private int age;
	
	private Pos pos;
	
	Tree(Pos pos) {
		this.age = 0;
		this.type = TreeType.SAPLING;
	}
	
	Tree(TreeType type, Pos pos) {
		this.age = 0;
		this.type = type;
		
		System.out.println("new tree " + pos.getX() + " " + pos.getY());

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
			
		}
	}
	
	public TreeType getType() {
		return this.type;
	}
}
