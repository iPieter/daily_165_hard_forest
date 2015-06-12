package daily_165_hard_forest;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Forest {
	
	private ForestTile[][] grid;
	private int dimension;
	private LumberMill lumberMill;
	private Economy economy;
	
	private int tick;
	BufferedImage tileset;
	
	Forest(int dimension) {
		//create a forest with specified dimension
		grid = new ForestTile[dimension][dimension];
		this.dimension = dimension;
		this.tick = 0;
		this.economy = new Economy();

		populate();
		
		loadTiles();
	}
	
	public int getDimension() {
		return this.dimension;
	}
	
	public boolean isCorner(Pos pos) {
		return pos.equals(new Pos(0,0)) || pos.equals(new Pos(dimension - 1,dimension - 1)) || pos.equals(new Pos(dimension - 1,0))|| pos.equals(new Pos(0,dimension- 1));
	}
	
	public boolean isEdge(Pos pos) {
		return pos.equalX(new Pos(0,0)) || pos.equalX(new Pos(dimension - 1,0)) || pos.equalY(new Pos(0,0)) || pos.equalY(new Pos(0,dimension - 1));
	}
	
	public boolean inGrid(Pos pos) {
		return pos.getX() >= 0 && pos.getX() < dimension && pos.getY() >= 0 && pos.getY() < dimension;
	}
	
	public ForestTile getTile(Pos p) {
		return grid[p.getX()][p.getY()];
	}
	
	public void move(Movable m, Pos p, boolean remove) {
		//this is the method that contains the actual moving logic
		
		//step 1: add the movable to the target tile
		m.addToTile(grid[p.getX()][p.getY()]);		
		
		//step 2: remove the movable from the old tile
		if (remove) {
			m.removeFromTile(grid[m.getPos().getX()][m.getPos().getY()]);
		}
		
		m.setPos(p);

		
	}
	
	public void populate() {
		//create a lumbermill, for managing the lumberjacks
		lumberMill = new LumberMill(this, economy);
		
		//populates the grid with bears, trees and lumberjacks
		for (int i = 0; i< dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				
				//TODO: make a better grid populator
				double rnd = Math.random(); 
				Pos p = new Pos(i,j);
				if ( rnd <= 0.5 ) {
					grid[i][j] = new ForestTile(p, new Tree(TreeType.TREE, p), null, null, this);
				} else if (rnd <= 0.6) {
					grid[i][j] = new ForestTile(p, null, null, new Lumberjack(p, lumberMill), this);
				} else if (rnd <= 0.62) {
					grid[i][j] = new ForestTile(p, null, new Bear(p), null, this);
				} else {
					grid[i][j] = new ForestTile(p, null, null, null, this);
				}
				 
				
			}
		}
	}
	
	public void tick() {
		//tick each forest tile
		for (ForestTile[] tileRow : grid) {
			for (ForestTile tile : tileRow) {
				tile.tick();
			}
		}
		
		//tick the lumbermill each year
		if (tick%12 == 0) {
			this.economy.tick();

			this.lumberMill.tick();
		}
		
		this.tick++;
	}
	
	public void addBear() {
		Bear b = new Bear(null);
		
		int x = (int) (Math.random()  * (double) dimension);
		int y = (int) (Math.random() * (double) dimension);
			
		move(b, grid[x][y].getPos(), false);
			
		
				
	}
	
	public void addLumberjack() {
		Lumberjack l = new Lumberjack(null, lumberMill);
		
		int x = (int) (Math.random()  * (double) dimension);
		int y = (int) (Math.random() * (double) dimension);
			
		move(l, grid[x][y].getPos(), false);
			
		
				
	}
	
	public void removeBear() {
		boolean removed = false;
		do {
			int x = (int) (Math.random()  * (double) dimension);
			int y = (int) (Math.random() * (double) dimension);
			
			if (grid[x][y].hasBear()) {
				grid[x][y].setBear(null);
				removed = true;
			}
			
		} while (!removed);
	}
	
	public void getImage(Graphics2D g) {
		for (int i = 0; i< dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				g.drawImage(tileset.getSubimage(0, grid[i][j].getImage()*10, 10, 10), i *10, j *10, null);
			}
		}
		
	}
	
	public void loadTiles() {
		try {
			tileset = ImageIO.read(getClass().getResourceAsStream("/sprites/sprites_3.png"));
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int getYear() {
		return this.tick/12;
	}

}
