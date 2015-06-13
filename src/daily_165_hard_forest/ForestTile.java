package daily_165_hard_forest;

import java.awt.image.BufferedImage;

public class ForestTile {
	private Tree tree;
	private Bear bear;
	private Lumberjack lumberjack;
	
	private Forest forest;
	private Pos pos;
	private Pos[] adjacentCells;
	private BufferedImage image;
	
	ForestTile(Pos pos, Tree tree, Bear bear, Lumberjack lumberjack, Forest forest) {
		this.tree = tree;
		this.bear = bear;
		this.lumberjack = lumberjack;
		
		this.forest = forest;
		this.pos = pos;
		
		//precalculate the adjacent cells, for preformance
		this.adjacentCells = adjacentCells();
		refreshTile();
	}
	
	public void refreshTile() {
		this.image = forest.getTileset().getSubimage(0, getImageId()*10, 10, 10);
	}
	
	public boolean hasTree(TreeType type) {
		return (this.tree == null) ? (false) : (this.tree.getType().equals(type));
	}
	
	public void setTree(TreeType type) {
		this.tree = new Tree(type, pos);
	}
	
	public boolean hasBear() {
		return this.bear != null;
	}
	
	public Pos getPos() {
		return this.pos;
	}
	
	public boolean hasLumberjack() {
		return this.lumberjack != null;
	}
	
	public void setLumberjack(Lumberjack j) {
		this.lumberjack = j;
		
		//check if there is a tree, and cut it down
		if (this.tree != null && j != null && this.tree.getType() != TreeType.SAPLING) {
			//add the wood to the lumber mill
			j.getLumberMill().addWood(this.tree.getType().getLumber());
			
			//cut it down
			this.tree = null;
		}
		refreshTile();
	}
	
	public void setBear(Bear b) {
		this.bear = b;
		
		//check if there is a tree, and cut it down
		if (this.bear != null && this.lumberjack != null) {
			
			this.lumberjack.getLumberMill().reportMaw();
			
			
			//cut it down
			this.lumberjack = null;
		}
		refreshTile();
	}
	
	public void tick() {
		if (this.tree != null) {
			this.tree.tick(this.forest);
		}
		
		if (this.bear != null) {
			this.bear.tick(this.forest);
		}
		
		if (this.lumberjack != null) {
			this.lumberjack.tick(this.forest);
		}
	}
	
	public Pos[] getAdjacentCells() {
		return this.adjacentCells;
	}
	
	public Pos[] adjacentCells() {
		Pos[] adj;
		//check if it is in a corner, to correctly dimension the array
		if (this.forest.isCorner(this.pos) ) {
			adj= new Pos[3];
		} else if (this.forest.isEdge(pos)) {
			adj= new Pos[5];
		} else {
			adj= new Pos[8];
		}
		
		int arCount = 0;
		//loop through all the adjacent positions
		for (int i=-1; i<=1;i++) {
			for (int j=-1;j<=1;j++) {
				//create a new pos with offsets
				Pos p = new Pos(pos, i, j);
				
				//check if the pos is valid and is not the original pos
				if (this.forest.inGrid(p) && !pos.equals(p)) {
					//if it is, add it
					adj[arCount++] = p;
				}
			}
		}
		
		return adj;
		
	}
	
	//not needed ...
	public void remove(Movable m) {
		if (m.equals(this.tree)) {
			this.tree = null;
		} else if (m.equals(this.bear)) {
			this.bear = null;
		}
	}
	
	public String toString() {
		return pos.toString() + " Bear: " + hasBear() + " Tree:" + hasTree(TreeType.TREE) + " Lumberjack: " + hasLumberjack();
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public int getImageId() {
		if (this.bear == null && this.lumberjack == null && this.tree == null) {
			return (Math.random() > 0.5? 0: 6);
		} else if (this.bear != null) {
			return 5;
		} else if (this.lumberjack != null ) {
			return 4;
		} else if (this.tree.getType() == TreeType.SAPLING) {
			return 1;
		} else if (this.tree.getType() == TreeType.TREE) {
			return 2;
		} else {
			return 3;
		}
		
	}
}
