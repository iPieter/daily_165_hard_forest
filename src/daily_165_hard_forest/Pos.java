package daily_165_hard_forest;

public class Pos {
	private int x,y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Pos(Pos p, int offX, int offY) {
		this.x = p.getX() + offX;
		this.y = p.getY() + offY;
	}
	
	public boolean equals(Pos p) {
		return p.getX() == this.x && p.getY() == this.y;
	}
	
	public boolean equalX(Pos p) {
		return p.getX() == this.x;
	}
	
	public boolean equalY(Pos p) {
		return p.getY() == this.y;
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return "(" +this.x + ","  + this.y + ")";
	}
}
