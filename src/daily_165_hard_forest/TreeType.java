package daily_165_hard_forest;

public enum TreeType {
	SAPLING, TREE, ELDER;
	
	public int getLumber() {
		switch (this) { 
			case TREE: return 1;
			case ELDER: return 2;
			default: return 0;
		}
	}
	
}
